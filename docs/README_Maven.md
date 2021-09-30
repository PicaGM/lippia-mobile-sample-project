## System requirements:
- JDK (Java Development Kit): URL 
- SDK & SDK tools (Software Development Kit): URL
- ADB (Android Debug Bridge): URL
- Appium Desktop: URL
- Android Studio: URL _OPTIONAL_

## Getting Started

### Running with Maven

- #### Mobile physical solution
  #### First step:
    - Connect your device from USB to computer
    - From your device
      Enable developer mode and then enable USB debugging.   
      _Make sure that your cell phone is in file transfer mode and that the PC has detected it correctly_   

  #### Second step:
    - Obtain your mobile IP addresss   
      _Settings -> About phone/tablet -> Status -> IP address_   
   
  #### Third step:
    - Execute following commands:
      This command lists the connected devices
      ```
      $ adb devices
        List of devices attached
        ZY322M46B6	device
      ``` 
      The next command, shuts down the server, starts the server to switch it to tcp mode and assign it   a listening port, and finally connects to our device through its ip and previously assigned port
      ```
      $ adb kill-server && adb tcpip 5555 && adb connect ip:5555
        * daemon not running; starting now at tcp:5037
        * daemon started successfully
        restarting in TCP mode port: 5555
        connected to 192.168.0.15:5555
      ```
      Finally, the following command list the devices again, but if we disconnect our device,    
      we can see that it is still connected wirelessly ready to receive instructions
      ```
      $ adb devices
        List of devices attached
        192.168.0.15:5555	device
      ```

      **Troubleshooting:**   
      If you don't see "Developer" option in Settings -> About phone/table, follow these steps:   
        - Go to **Settings** -> **About** -> **Build number** and tap 7 times   

  #### Fourth step:
    - Go to Lippia Mobile Project, and go to pom.xml file.
    - Find deviceName property, and replace value with the name of your device
    ```
    <profile>
      <id>Local</id>
          <activation>
            <activeByDefault>true</activeByDefault>
          </activation>
      <properties>
        <crowdar.driverHub>http://127.0.0.1:4723/wd/hub</crowdar.driverHub>
        <cucumber.runner>testng.xml</cucumber.runner>
        <crowdar.avd></crowdar.avd>
        <crowdar.appLocation>path/sample_apk/lippia.apk</crowdar.appLocation>
        <crowdar.deviceName>yourDeviceName</crowdar.deviceName>
      </properties>
    </profile>
    ```

  #### Fifth step:   
    - Go to:
    ```
    ├── src
    |   └── main
    |       └── resources
    |           └── capabilities
    |               └── androidCapabilities.json 
    ├── ...
    ```
    - Find avd property, and replaces with deviceId.   
    - Follow the next schema:
    ```
    {
      "deviceName": "{{deviceName}}",
      "app": "{{app}}",
      "platformName": "Android",
      "deviceId": "ip:5555",
      "resetKeyboard": "true",
      "unicodeKeyboard": "true"
    }
    ```

  #### Sixth step:
    - Open Appium Desktop and Start the server
    - Finally, execute the following command:   
    ```
    $ mvn clean test
    ```


- #### Mobile emulated solution
