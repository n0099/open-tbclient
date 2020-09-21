package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes9.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.imageData == null || this.imageData.length == 0) && ((this.imagePath == null || this.imagePath.length() == 0) && (this.imageUrl == null || this.imageUrl.length() == 0))) {
            a.a(TAG, "checkArgs fail, all arguments are null");
            return false;
        } else if (this.imageData != null && this.imageData.length > 10485760) {
            a.a(TAG, "checkArgs fail, content is too large");
            return false;
        } else if (this.imagePath != null && this.imagePath.length() > 10240) {
            a.a(TAG, "checkArgs fail, path is invalid");
            return false;
        } else if (this.imagePath != null && getFileSize(this.imagePath) > 10485760) {
            a.a(TAG, "checkArgs fail, image content is too large");
            return false;
        } else if (this.imageUrl == null || this.imageUrl.length() <= 10240) {
            return true;
        } else {
            a.a(TAG, "checkArgs fail, url is invalid");
            return false;
        }
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_imageUrl", this.imageUrl);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.imageUrl = bundle.getString("_wximageobject_imageUrl");
    }
}
