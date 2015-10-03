# cordova-plugin-video-thumbnail

Provides support for rendering video thumbnails on Android using Cordova.

## Motivation

After searching the Web for a video thumbnail plugin, I couldn't seem to find one that worked 'out the box'. I decided I would create my own that generates a base64 encoded string. Using the src attribute of an image element, thumbnails can be easily be rendered on the screen to the user. Alternatively, you may use the CSS rule 'background' to produce a similar result.

## Installation

```
$ cordova plugin add cordova-plugin-video-thumbnail
```

## Parameters

**fileURI**

Path to video on the device

**callback(err, imageData)**

This function will be fired when the plugin has finished processing. If an error has occurred 'err' will be populated, otherwise, it will be null and imageData will contain a base64 string.

## Example

```js
navigator.createThumbnail(fileURI, function(err, imageData) {
    if (err)
        throw err;
    
    console.log(imageData); // Will log the base64 encoded string in console.
});
```
