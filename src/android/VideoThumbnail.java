/**
 * video-thumbnail
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT
 * OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */
package com.lewie9021.videothumbnail;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore.Video.Thumbnails;
import android.util.Base64;
import android.util.Log;

import java.lang.String;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class VideoThumbnail extends CordovaPlugin {

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            // Action is 'create'
            if (action.equals("create")) {
                Uri fileURI = Uri.fromFile(new File(args.getString(0)));
                String filePath = args.getString(0).replace(fileURI.getScheme() + ":", "");
                Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail(filePath, Thumbnails.MINI_KIND);

                callbackContext.success(encodeTobase64(thumbnail));
                return true;
            } else {
                callbackContext.error("Invalid action");
                return false;
            }
        } catch (JSONException e) {
            callbackContext.error("JSON Exception");
            return true;
        }
    }

    public static String encodeTobase64(Bitmap image) {
        Bitmap bmImage = image;

        ByteArrayOutputStream byteArrayData = new ByteArrayOutputStream();  
        bmImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayData);
        byte[] byteData = byteArrayData.toByteArray();
        String encodedImage = Base64.encodeToString(byteData, Base64.DEFAULT);

        return encodedImage;
    }
}
