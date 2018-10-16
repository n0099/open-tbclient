package com.sina.weibo.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
import com.sina.weibo.BuildConfig;
import com.sina.weibo.sdk.WeiboAppManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
/* loaded from: classes2.dex */
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
            if (options != null && options.outMimeType != null && options.outMimeType.contains(CanvasToTempFileModel.IMAGE_EXT_PNG)) {
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
            if (options != null && options.outMimeType != null && options.outMimeType.contains(CanvasToTempFileModel.IMAGE_EXT_PNG)) {
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

    private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        Bitmap bitmap;
        OutOfMemoryError outOfMemoryError;
        FileInputStream fileInputStream;
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
        while (i < 5) {
            try {
                try {
                    fileInputStream2 = new FileInputStream(str);
                } catch (OutOfMemoryError e) {
                    bitmap = bitmap2;
                    outOfMemoryError = e;
                    fileInputStream = fileInputStream3;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return decodeStream;
                } catch (OutOfMemoryError e3) {
                    fileInputStream = fileInputStream2;
                    bitmap = bitmap2;
                    outOfMemoryError = e3;
                    outOfMemoryError.printStackTrace();
                    options2.inSampleSize *= 2;
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    i++;
                    fileInputStream3 = fileInputStream;
                    bitmap2 = bitmap;
                }
            } catch (FileNotFoundException e5) {
                return bitmap2;
            }
        }
        return bitmap2;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [388=4] */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0184: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:78:0x0184 */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0161 A[EDGE_INSN: B:104:0x0161->B:58:0x0161 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: Exception -> 0x0158, all -> 0x0172, TryCatch #12 {Exception -> 0x0158, all -> 0x0172, blocks: (B:3:0x0001, B:6:0x0012, B:12:0x007b, B:13:0x007e, B:15:0x0084, B:18:0x009a, B:19:0x00a2, B:52:0x0154, B:53:0x0157, B:48:0x014a), top: B:93:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e3 A[Catch: all -> 0x0181, Exception -> 0x0188, TryCatch #13 {Exception -> 0x0188, all -> 0x0181, blocks: (B:20:0x00bb, B:22:0x00e3, B:23:0x00e6), top: B:101:0x00bb }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f6 A[Catch: Exception -> 0x00fb, all -> 0x0183, LOOP:0: B:26:0x00ef->B:28:0x00f6, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x0183, blocks: (B:25:0x00ed, B:26:0x00ef, B:28:0x00f6, B:58:0x0161, B:31:0x00fc), top: B:93:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0154 A[Catch: Exception -> 0x0158, all -> 0x0172, TryCatch #12 {Exception -> 0x0158, all -> 0x0172, blocks: (B:3:0x0001, B:6:0x0012, B:12:0x007b, B:13:0x007e, B:15:0x0084, B:18:0x009a, B:19:0x00a2, B:52:0x0154, B:53:0x0157, B:48:0x014a), top: B:93:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016c A[Catch: Exception -> 0x0170, TRY_LEAVE, TryCatch #0 {Exception -> 0x0170, blocks: (B:60:0x0167, B:62:0x016c), top: B:89:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String copyFileToWeiboTem(Context context, Uri uri, int i) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        OutputStream outputStream;
        String str;
        Cursor cursor;
        String str2;
        File file;
        byte[] bArr;
        int read;
        OutputStream outputStream2 = null;
        try {
            try {
                String packageName = WeiboAppManager.queryWbInfoInternal(context).getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    packageName = BuildConfig.APPLICATION_ID;
                }
                str = "/Android/data/" + packageName + "/files/.composerTem/";
                new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str).mkdirs();
                Calendar calendar = Calendar.getInstance();
                try {
                    if (uri.getScheme().equals("file")) {
                        str2 = calendar.getTimeInMillis() + uri.getLastPathSegment();
                        cursor = null;
                    } else {
                        cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                        if (cursor != null) {
                            try {
                                try {
                                    if (cursor.moveToFirst()) {
                                        str2 = cursor.getString(cursor.getColumnIndex("_display_name"));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    Log.v("weibo sdk rename", e.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                        str2 = null;
                                    } else {
                                        str2 = null;
                                    }
                                    if (TextUtils.isEmpty(str2)) {
                                    }
                                    bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
                                    file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                                    if (file.exists()) {
                                    }
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bArr = new byte[1444];
                                        while (true) {
                                            read = bufferedInputStream.read(bArr);
                                            if (read != -1) {
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        String path = file.getPath();
                                        if (bufferedInputStream != null) {
                                        }
                                        if (fileOutputStream == null) {
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        Log.v("weibo sdk copy", e.toString());
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Exception e3) {
                                                return null;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        return null;
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        str2 = null;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    throw th;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = Calendar.getInstance().getTimeInMillis() + (i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, "r").getFileDescriptor()));
            } catch (Throwable th3) {
                th = th3;
                outputStream2 = outputStream;
            }
            try {
                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[1444];
                while (true) {
                    read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                String path2 = file.getPath();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e5) {
                        return path2;
                    }
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                    return path2;
                }
                return path2;
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e7) {
                        throw th;
                    }
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            fileOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
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
