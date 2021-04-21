package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes7.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public static final int CONTENT_LENGTH_LIMIT = 10485760;
    public static final int PATH_LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXImageObject";
    public static final int URL_LENGTH_LIMIT = 10240;
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
        } catch (Exception e2) {
            e2.printStackTrace();
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
        String str;
        String str2;
        String str3;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && (((str = this.imagePath) == null || str.length() == 0) && ((str2 = this.imageUrl) == null || str2.length() == 0))) {
            str3 = "checkArgs fail, all arguments are null";
        } else {
            byte[] bArr2 = this.imageData;
            if (bArr2 == null || bArr2.length <= 10485760) {
                String str4 = this.imagePath;
                if (str4 == null || str4.length() <= 10240) {
                    String str5 = this.imagePath;
                    if (str5 == null || getFileSize(str5) <= 10485760) {
                        String str6 = this.imageUrl;
                        if (str6 == null || str6.length() <= 10240) {
                            return true;
                        }
                        str3 = "checkArgs fail, url is invalid";
                    } else {
                        str3 = "checkArgs fail, image content is too large";
                    }
                } else {
                    str3 = "checkArgs fail, path is invalid";
                }
            } else {
                str3 = "checkArgs fail, content is too large";
            }
        }
        a.a("MicroMsg.SDK.WXImageObject", str3);
        return false;
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
