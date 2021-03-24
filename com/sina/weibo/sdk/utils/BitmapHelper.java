package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public final class BitmapHelper {
    public static int getSampleSizeAutoFitToScreen(int i, int i2, int i3, int i4) {
        if (i2 == 0 || i == 0) {
            return 1;
        }
        return Math.min(Math.max(i3 / i, i4 / i2), Math.max(i4 / i, i3 / i2));
    }

    public static int getSampleSizeOfNotTooLarge(Rect rect) {
        double width = rect.width();
        double height = rect.height();
        Double.isNaN(width);
        Double.isNaN(height);
        double d2 = ((width * height) * 2.0d) / 5242880.0d;
        if (d2 >= 1.0d) {
            return (int) d2;
        }
        return 1;
    }

    public static boolean makesureSizeNotTooLarge(Rect rect) {
        return (rect.width() * rect.height()) * 2 <= 5242880;
    }

    public static boolean verifyBitmap(byte[] bArr) {
        return verifyBitmap(new ByteArrayInputStream(bArr));
    }

    public static boolean verifyBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        BitmapFactory.decodeStream(inputStream, null, options);
        try {
            inputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return options.outHeight > 0 && options.outWidth > 0;
    }

    public static boolean verifyBitmap(String str) {
        try {
            return verifyBitmap(new FileInputStream(str));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
