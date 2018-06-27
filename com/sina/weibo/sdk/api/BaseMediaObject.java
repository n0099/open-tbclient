package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
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

    public abstract int getObjType();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract BaseMediaObject toExtraMediaObject(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String toExtraMediaString();

    public BaseMediaObject() {
    }

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setThumbImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
                    this.thumbData = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    LogUtil.e("Weibo.BaseMediaObject", "put thumb failed");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkArgs() {
        if (this.actionUrl == null || this.actionUrl.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        } else if (this.identify == null || this.identify.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        } else if (this.thumbData == null || this.thumbData.length > 32768) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, thumbData is invalid,size is " + (this.thumbData != null ? this.thumbData.length : -1) + "! more then 32768.");
            return false;
        } else if (this.title == null || this.title.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        } else if (this.description == null || this.description.length() > 1024) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
            return false;
        } else {
            return true;
        }
    }
}
