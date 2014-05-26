# com.Lewie9021.video-thumbnail

This plugin provides support for rendering video thumbnails within Cordova, After looking around the web for a video thumbnail plugin, I couldn't seem to find a plugin that worked 'out the box'. I decided I would create one myself that unlike some of the similar plugins, generates a base64 encoded string that can be used via an image element or via CSS styling with a background url property.

## Installation

	cordova plugin add https://github.com/Lewie9021/video-thumbnail.git

## Supported Platforms

- Android

## createThumbnail

	navigator.videoThumbnail.createThumbnail(source, success, failure);

### Parameters

<dl>
	<dt>source</dt>
	<dd>Path to the video file. Example: </dd>

	<dt>success(imageData)</dt>
	<dd>Successful callback. This function will be fired when the thumbnail has been created without any errors.</dd>

	<dt>failure(err)</dt>
	<dd>Fail callback. This function will be fired if there are any errors that have occured during the creation of the thumbnail.</dd>
</dl>

### Example

	navigator.videoThumbnail.createThumbnail(fileURI, function(imageData) {
		console.log(imageData); //Will display the base64 encoded string in console.
	}, function(err) {
		alert("Error: " + err); //Fire an alert if any errors occur.
	});
