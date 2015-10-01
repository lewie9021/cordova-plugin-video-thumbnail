# cordova-plugin-video-thumbnail

Provides support for rendering video thumbnails within Cordova.

## Motivation

After searching the Web for a video thumbnail plugin, I couldn't seem to find one that worked 'out the box'. I decided I would create my own that generates a base64 encoded string. Using the src attribute of an image element, thumbnails can be easily be rendered on the screen to the user. Alternatively, you may use the CSS rule 'background' to produce a similar result.

## Installation

```
$ cordova plugin add https://github.com/lewie9021/cordova-plugin-video-thumbnail.git
```

## Supported Platforms

- Android

### Parameters

<dl>
    <dt>fileURI</dt>
    <dd>Path to the video in the device</dd>

    <dt>callback(err, imageData)</dt>
    <dd>This function will be fired when the plugin has finished process. If an error has occurred 'err' will be populated, otherwise, it will be null and imageData will contain a base64 string.</dd>
</dl>

### Example

```js
navigator.createThumbnail(fileURI, function(err, imageData) {
    if (err)
        throw err;
    
    console.log(imageData); // Will log the base64 encoded string in console.
});
```
