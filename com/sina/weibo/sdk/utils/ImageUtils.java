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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes6.dex */
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

    private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        FileInputStream fileInputStream;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inSampleSize = 1;
        } else {
            options2 = options;
        }
        int i = 0;
        FileInputStream fileInputStream2 = null;
        while (i < 5) {
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return decodeStream;
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        e.printStackTrace();
                        options2.inSampleSize *= 2;
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        i++;
                        fileInputStream2 = fileInputStream;
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    fileInputStream = fileInputStream2;
                }
            } catch (FileNotFoundException e5) {
                return null;
            }
        }
        return null;
    }

    private static void delete(File file) {
        if (file != null && file.exists() && !file.delete()) {
            throw new RuntimeException(file.getAbsolutePath() + " doesn't be deleted!");
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

    @TargetApi(10)
    public static long getVideoDuring(String str) {
        if (new File(str).exists()) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            } catch (Exception e) {
                return 0L;
            }
        }
        return 0L;
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
