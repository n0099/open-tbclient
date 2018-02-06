package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class ImageUtils {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x008f */
    private static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
        Bitmap createBitmap;
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (!BitmapHelper.verifyBitmap(str)) {
            throw new IOException("");
        } else {
            int i3 = i * 2;
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i4 = 0;
            while (true) {
                if ((options.outWidth >> i4) <= i3 && (options.outHeight >> i4) <= i3) {
                    break;
                }
                i4++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, i4);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            float width = i / (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight());
            int i5 = (width > 1.0f ? 1 : (width == 1.0f ? 0 : -1));
            int i6 = i5;
            if (i5 < 0) {
                while (true) {
                    try {
                        i6 = width;
                        createBitmap = Bitmap.createBitmap((int) (safeDecodeBimtapFile.getWidth() * i6), (int) (safeDecodeBimtapFile.getHeight() * i6), Bitmap.Config.ARGB_8888);
                        break;
                    } catch (OutOfMemoryError e2) {
                        System.gc();
                        width = (float) (i6 * 0.8d);
                        i6 = i6;
                    }
                }
                if (createBitmap == null) {
                    safeDecodeBimtapFile.recycle();
                }
                Canvas canvas = new Canvas(createBitmap);
                Matrix matrix = new Matrix();
                matrix.setScale(i6, i6);
                canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                safeDecodeBimtapFile.recycle();
                safeDecodeBimtapFile = createBitmap;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options != null && options.outMimeType != null && options.outMimeType.contains("png")) {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
            } else {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            safeDecodeBimtapFile.recycle();
        }
    }

    private static void revitionImageSize(String str, int i, int i2) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        }
        if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (!BitmapHelper.verifyBitmap(str)) {
            throw new IOException("");
        } else {
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i3 = 0;
            while (true) {
                if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                    break;
                }
                i3++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, i3);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile == null) {
                throw new IOException("Bitmap decode error!");
            }
            deleteDependon(str);
            makesureFileExist(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            if (options != null && options.outMimeType != null && options.outMimeType.contains("png")) {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
            } else {
                safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            }
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            safeDecodeBimtapFile.recycle();
        }
    }

    public static boolean revitionPostImageSize(Context context, String str) {
        try {
            if (NetworkHelper.isWifiValid(context)) {
                revitionImageSizeHD(str, 1600, 75);
            } else {
                revitionImageSize(str, 1024, 75);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0019 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: android.graphics.Bitmap */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.graphics.Bitmap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        Bitmap bitmap;
        OutOfMemoryError outOfMemoryError;
        FileInputStream fileInputStream;
        BitmapFactory.Options options3;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inSampleSize = 1;
        } else {
            options2 = options;
        }
        int i = 0;
        Bitmap bitmap2 = null;
        Bitmap bitmap3 = options2;
        while (i < 5) {
            try {
                try {
                    fileInputStream2 = new FileInputStream(str);
                } catch (OutOfMemoryError e) {
                    bitmap = bitmap2;
                    outOfMemoryError = e;
                    fileInputStream = fileInputStream3;
                    options3 = bitmap3;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                    try {
                        fileInputStream2.close();
                        bitmap3 = decodeStream;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        bitmap3 = decodeStream;
                    }
                    return bitmap3;
                } catch (OutOfMemoryError e3) {
                    fileInputStream = fileInputStream2;
                    bitmap = bitmap2;
                    outOfMemoryError = e3;
                    options3 = bitmap3;
                    outOfMemoryError.printStackTrace();
                    options3.inSampleSize *= 2;
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    i++;
                    fileInputStream3 = fileInputStream;
                    bitmap2 = bitmap;
                    bitmap3 = options3;
                }
            } catch (FileNotFoundException e5) {
                return bitmap2;
            }
        }
        return bitmap2;
    }

    private static void delete(File file) {
        if (file != null && file.exists() && !file.delete()) {
            throw new RuntimeException(String.valueOf(file.getAbsolutePath()) + " doesn't be deleted!");
        }
    }

    private static boolean deleteDependon(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            int i = 1;
            if (file != null) {
                while (!z && i <= 5 && file.isFile() && file.exists()) {
                    z = file.delete();
                    if (!z) {
                        i++;
                    }
                }
            }
        }
        return z;
    }

    private static boolean isFileExisted(String str) {
        File file;
        return (TextUtils.isEmpty(str) || (file = new File(str)) == null || !file.exists()) ? false : true;
    }

    private static boolean isParentExist(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    private static void makesureFileExist(String str) {
        File file;
        if (str != null && (file = new File(str)) != null && !file.exists() && isParentExist(file)) {
            if (file.exists()) {
                delete(file);
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
