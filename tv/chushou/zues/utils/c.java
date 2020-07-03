package tv.chushou.zues.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class c {
    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize <= 8) {
            int i3 = 1;
            while (i3 < computeInitialSampleSize) {
                i3 <<= 1;
            }
            return i3;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    private static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / i), Math.floor(d2 / i));
        if (min >= ceil) {
            if (i2 == -1 && i == -1) {
                return 1;
            }
            return i != -1 ? min : ceil;
        }
        return ceil;
    }

    @Nullable
    public static Bitmap B(String str, int i, int i2) {
        if (h.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (i > 0 && i2 > 0) {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (options.outWidth * options.outHeight > i * i2) {
                    options.inSampleSize = computeSampleSize(options, -1, i * i2);
                }
            }
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [131=4] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static File a(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        File parentFile;
        FileOutputStream fileOutputStream;
        Throwable th;
        boolean z;
        if (bitmap == null || file == null) {
            return null;
        }
        if ((!file.exists() || file.delete()) && (parentFile = file.getParentFile()) != null) {
            if (parentFile.exists() || parentFile.mkdirs()) {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    th = th2;
                }
                try {
                    bitmap.compress(compressFormat, i, fileOutputStream);
                    fileOutputStream.flush();
                    tv.chushou.a.a.d.a.b(fileOutputStream);
                    z = true;
                } catch (Exception e2) {
                    tv.chushou.a.a.d.a.b(fileOutputStream);
                    z = false;
                    if (!z) {
                    }
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    tv.chushou.a.a.d.a.b(fileOutputStream);
                    throw th;
                }
                if (!z) {
                    file = null;
                }
                return file;
            }
            return null;
        }
        return null;
    }

    public static com.facebook.c.c s(InputStream inputStream) {
        if (inputStream == null) {
            return com.facebook.c.c.mQe;
        }
        try {
            return com.facebook.c.d.s(inputStream);
        } catch (IOException e) {
            return com.facebook.c.c.mQe;
        }
    }
}
