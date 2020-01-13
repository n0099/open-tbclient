package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
/* loaded from: classes5.dex */
public final class ShareUtils {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [65=4] */
    /* JADX INFO: Access modifiers changed from: protected */
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
                    packageName = "com.sina.weibo";
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
                                        LogUtil.e("weibo sdk copy", e.toString());
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
}
