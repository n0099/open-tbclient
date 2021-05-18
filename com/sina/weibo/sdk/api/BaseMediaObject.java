package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public abstract class BaseMediaObject implements Parcelable {
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MULITI_IMAGE = 6;
    public static final int MEDIA_TYPE_SOURCE_VIDEO = 7;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public BaseMediaObject() {
    }

    public boolean checkArgs() {
        String str = this.actionUrl;
        if (str != null && str.length() <= 512) {
            String str2 = this.identify;
            if (str2 != null && str2.length() <= 512) {
                byte[] bArr = this.thumbData;
                if (bArr != null && bArr.length <= 32768) {
                    String str3 = this.title;
                    if (str3 != null && str3.length() <= 512) {
                        String str4 = this.description;
                        if (str4 == null || str4.length() > 1024) {
                            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
                            return false;
                        }
                        return true;
                    }
                    LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
                    return false;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("checkArgs fail, thumbData is invalid,size is ");
                byte[] bArr2 = this.thumbData;
                sb.append(bArr2 != null ? bArr2.length : -1);
                sb.append("! more then 32768.");
                LogUtil.e("Weibo.BaseMediaObject", sb.toString());
                return false;
            }
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        }
        LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract int getObjType();

    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                this.thumbData = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public abstract BaseMediaObject toExtraMediaObject(String str);

    public abstract String toExtraMediaString();

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }
}
