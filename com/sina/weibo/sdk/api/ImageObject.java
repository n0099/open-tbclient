package com.sina.weibo.sdk.api;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/* loaded from: classes6.dex */
public class ImageObject extends BaseMediaObject {
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() { // from class: com.sina.weibo.sdk.api.ImageObject.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageObject[] newArray(int i2) {
            return new ImageObject[i2];
        }
    };
    public static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    public ImageObject() {
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        }
        byte[] bArr = this.imageData;
        if (bArr != null && bArr.length > 2097152) {
            LogUtil.e("Weibo.ImageObject", "imageData is too large");
            return false;
        }
        String str = this.imagePath;
        if (str != null && str.length() > 512) {
            LogUtil.e("Weibo.ImageObject", "imagePath is too length");
            return false;
        } else if (this.imagePath != null) {
            File file = new File(this.imagePath);
            try {
                if (!file.exists() || file.length() == 0 || file.length() > Config.FULL_TRACE_LOG_LIMIT) {
                    LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                }
                return true;
            } catch (SecurityException unused) {
                LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                return false;
            }
        } else {
            return true;
        }
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public int getObjType() {
        return 2;
    }

    public final void setImageObject(Bitmap bitmap) {
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
                this.imageData = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                LogUtil.e("Weibo.ImageObject", "put thumb failed");
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

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject
    public String toExtraMediaString() {
        return "";
    }

    @Override // com.sina.weibo.sdk.api.BaseMediaObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }
}
