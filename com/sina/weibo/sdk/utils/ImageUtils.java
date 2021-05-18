package com.sina.weibo.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes7.dex */
public class ImageUtils {
    public static void delete(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        throw new RuntimeException(file.getAbsolutePath() + " doesn't be deleted!");
    }

    public static boolean deleteDependon(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        int i2 = 1;
        while (!z && i2 <= 5 && file.isFile() && file.exists()) {
            z = file.delete();
            if (!z) {
                i2++;
            }
        }
        return z;
    }

    @TargetApi(10)
    public static long getVideoDuring(String str) {
        if (new File(str).exists()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception unused) {
                return 0L;
            }
        }
        return 0L;
    }

    public static boolean isFileExisted(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean isParentExist(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void makesureFileExist(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists() || !isParentExist(file)) {
            return;
        }
        if (file.exists()) {
            delete(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void revitionImageSize(String str, int i2, int i3) throws IOException {
        if (i2 > 0) {
            if (!isFileExisted(str)) {
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                throw new FileNotFoundException(str);
            } else if (BitmapHelper.verifyBitmap(str)) {
                FileInputStream fileInputStream = new FileInputStream(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, null, options);
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int i4 = 0;
                while (true) {
                    if ((options.outWidth >> i4) <= i2 && (options.outHeight >> i4) <= i2) {
                        break;
                    }
                    i4++;
                }
                options.inSampleSize = (int) Math.pow(2.0d, i4);
                options.inJustDecodeBounds = false;
                Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                if (safeDecodeBimtapFile != null) {
                    deleteDependon(str);
                    makesureFileExist(str);
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    String str2 = options.outMimeType;
                    if (str2 != null && str2.contains("png")) {
                        safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i3, fileOutputStream);
                    } else {
                        safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    safeDecodeBimtapFile.recycle();
                    return;
                }
                throw new IOException("Bitmap decode error!");
            } else {
                throw new IOException("");
            }
        }
        throw new IllegalArgumentException("size must be greater than 0!");
    }

    public static void revitionImageSizeHD(String str, int i2, int i3) throws IOException {
        Bitmap createBitmap;
        if (i2 > 0) {
            if (!isFileExisted(str)) {
                if (str == null) {
                    str = StringUtil.NULL_STRING;
                }
                throw new FileNotFoundException(str);
            } else if (BitmapHelper.verifyBitmap(str)) {
                int i4 = i2 * 2;
                FileInputStream fileInputStream = new FileInputStream(str);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fileInputStream, null, options);
                try {
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                int i5 = 0;
                while (true) {
                    if ((options.outWidth >> i5) <= i4 && (options.outHeight >> i5) <= i4) {
                        break;
                    }
                    i5++;
                }
                options.inSampleSize = (int) Math.pow(2.0d, i5);
                options.inJustDecodeBounds = false;
                Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                if (safeDecodeBimtapFile != null) {
                    deleteDependon(str);
                    makesureFileExist(str);
                    float width = i2 / (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight());
                    if (width < 1.0f) {
                        while (true) {
                            try {
                                createBitmap = Bitmap.createBitmap((int) (safeDecodeBimtapFile.getWidth() * width), (int) (safeDecodeBimtapFile.getHeight() * width), Bitmap.Config.ARGB_8888);
                                break;
                            } catch (OutOfMemoryError unused) {
                                System.gc();
                                width = (float) (width * 0.8d);
                            }
                        }
                        if (createBitmap == null) {
                            safeDecodeBimtapFile.recycle();
                        }
                        Canvas canvas = new Canvas(createBitmap);
                        Matrix matrix = new Matrix();
                        matrix.setScale(width, width);
                        canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                        safeDecodeBimtapFile.recycle();
                        safeDecodeBimtapFile = createBitmap;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    String str2 = options.outMimeType;
                    if (str2 != null && str2.contains("png")) {
                        safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i3, fileOutputStream);
                    } else {
                        safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i3, fileOutputStream);
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    safeDecodeBimtapFile.recycle();
                    return;
                }
                throw new IOException("Bitmap decode error!");
            } else {
                throw new IOException("");
            }
        }
        throw new IllegalArgumentException("size must be greater than 0!");
    }

    public static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        FileInputStream fileInputStream;
        OutOfMemoryError e2;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inSampleSize = 1;
        } else {
            options2 = options;
        }
        int i2 = 0;
        Bitmap bitmap = null;
        FileInputStream fileInputStream2 = null;
        while (i2 < 5) {
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (FileNotFoundException unused) {
                }
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return bitmap;
                } catch (OutOfMemoryError e4) {
                    e2 = e4;
                    e2.printStackTrace();
                    options2.inSampleSize *= 2;
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    i2++;
                    fileInputStream2 = fileInputStream;
                }
            } catch (OutOfMemoryError e6) {
                fileInputStream = fileInputStream2;
                e2 = e6;
            }
        }
        return bitmap;
    }
}
