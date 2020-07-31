package com.kascend.chushou.bean;

import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.c.b;
import com.facebook.c.c;
import java.io.File;
import java.io.FileInputStream;
import pl.droidsonroids.gif.GifDrawable;
import tv.chushou.a.a.d.a;
import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class ImageInfo implements Parcelable {
    public static final Parcelable.Creator<ImageInfo> CREATOR = new Parcelable.Creator<ImageInfo>() { // from class: com.kascend.chushou.bean.ImageInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageInfo createFromParcel(Parcel parcel) {
            return new ImageInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageInfo[] newArray(int i) {
            return new ImageInfo[i];
        }
    };
    public int frameCount;
    public int height;
    public long size;
    public String type;
    public String url;
    public int width;

    public ImageInfo() {
        this.type = c.mYp.getName().toLowerCase();
        this.width = -1;
        this.height = -1;
        this.frameCount = 0;
        this.url = "";
        this.size = 0L;
    }

    protected ImageInfo(Parcel parcel) {
        this.type = c.mYp.getName().toLowerCase();
        this.width = -1;
        this.height = -1;
        this.frameCount = 0;
        this.url = "";
        this.size = 0L;
        this.type = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameCount = parcel.readInt();
        this.url = parcel.readString();
        this.size = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.type);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.frameCount);
        parcel.writeString(this.url);
        parcel.writeLong(this.size);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ImageInfo decodeSync(String str) {
        FileInputStream fileInputStream;
        ImageInfo imageInfo = new ImageInfo();
        if (h.isEmpty(str)) {
            return imageInfo;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return imageInfo;
        }
        c cVar = c.mYp;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                imageInfo.size = fileInputStream.available();
                cVar = tv.chushou.zues.utils.c.r(fileInputStream);
                a.b(fileInputStream);
            } catch (Exception e) {
                a.b(fileInputStream);
                imageInfo.type = cVar.getName().toLowerCase();
                if (cVar != c.mYp) {
                }
            } catch (Throwable th) {
                th = th;
                a.b(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        imageInfo.type = cVar.getName().toLowerCase();
        if (cVar != c.mYp) {
            return imageInfo;
        }
        if (cVar == b.mYh) {
            try {
                GifDrawable gifDrawable = new GifDrawable(file);
                imageInfo.frameCount = gifDrawable.getNumberOfFrames();
                imageInfo.width = gifDrawable.getIntrinsicWidth();
                imageInfo.height = gifDrawable.getIntrinsicHeight();
            } catch (Throwable th3) {
            }
            return imageInfo;
        } else if (cVar == b.mYn) {
            return imageInfo;
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth > 0 && options.outHeight > 0) {
                imageInfo.width = options.outWidth;
                imageInfo.height = options.outHeight;
            }
            return imageInfo;
        }
    }
}
