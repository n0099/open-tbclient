package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class HeifExifUtil {
    public static final String TAG = "HeifExifUtil";

    /* loaded from: classes6.dex */
    public static class HeifExifUtilAndroidN {
        @RequiresApi(api = 24)
        public static int getOrientation(InputStream inputStream) {
            try {
                return new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
            } catch (IOException e2) {
                FLog.d(HeifExifUtil.TAG, "Failed reading Heif Exif orientation -> ignoring", (Throwable) e2);
                return 0;
            }
        }
    }

    public static int getOrientation(InputStream inputStream) {
        if (Build.VERSION.SDK_INT >= 24) {
            return HeifExifUtilAndroidN.getOrientation(inputStream);
        }
        FLog.d(TAG, "Trying to read Heif Exif information before Android N -> ignoring");
        return 0;
    }
}
