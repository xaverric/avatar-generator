# Avatar generator
Simple tool for creating random avatar

## Usage
```
int imageSize = 400;  //px
int tileSize = 40;    //px
String pathToBeSaved = "file path including file name";

AvatarGenerator avatarGenerator = new AvatarGenerator(imageSize);
avatarGenerator.generateAndSaveAvatar(AvatarType.SQUARE, tileSize, FileFormat.PNG, pathToBeSaved);
```
## Examples
![Example 1](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example1.png) ![Example 2](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example2.png)
![Example 3](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example3.png) ![Example 4](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example4.png)
![Example 5](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example5.png) ![Example 6](https://github.com/xaverric/avatar-generator/blob/master/src/main/resources/examples/example6.png)
