package com.sina.weibo.sdk.share;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
/* loaded from: classes6.dex */
public final class ShareUtils {
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b6 A[Catch: all -> 0x0143, Exception -> 0x0146, TryCatch #13 {Exception -> 0x0146, all -> 0x0143, blocks: (B:3:0x0003, B:6:0x0013, B:20:0x0097, B:30:0x00b0, B:32:0x00b6, B:36:0x00cd, B:37:0x00d4, B:28:0x00ac, B:58:0x013f, B:59:0x0142), top: B:92:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0111 A[Catch: all -> 0x0136, Exception -> 0x0139, TryCatch #11 {Exception -> 0x0139, all -> 0x0136, blocks: (B:38:0x00ec, B:40:0x0111, B:41:0x0114), top: B:94:0x00ec }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0124 A[Catch: Exception -> 0x0134, all -> 0x015d, LOOP:0: B:44:0x011d->B:46:0x0124, LOOP_END, TryCatch #2 {Exception -> 0x0134, blocks: (B:43:0x011b, B:44:0x011d, B:46:0x0124, B:47:0x0129), top: B:82:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013f A[Catch: all -> 0x0143, Exception -> 0x0146, TRY_ENTER, TryCatch #13 {Exception -> 0x0146, all -> 0x0143, blocks: (B:3:0x0003, B:6:0x0013, B:20:0x0097, B:30:0x00b0, B:32:0x00b6, B:36:0x00cd, B:37:0x00d4, B:28:0x00ac, B:58:0x013f, B:59:0x0142), top: B:92:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166 A[Catch: Exception -> 0x0169, TRY_LEAVE, TryCatch #1 {Exception -> 0x0169, blocks: (B:73:0x0161, B:75:0x0166), top: B:80:0x0161 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129 A[EDGE_INSN: B:96:0x0129->B:47:0x0129 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String copyFileToWeiboTem(Context context, Uri uri, int i) {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        String str;
        Cursor cursor;
        String str2;
        File file;
        byte[] bArr;
        int read;
        BufferedInputStream bufferedInputStream2 = null;
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
                            } catch (Exception e2) {
                                e = e2;
                                Log.v("weibo sdk rename", e.toString());
                                if (cursor != null) {
                                    cursor.close();
                                }
                                str2 = null;
                                if (TextUtils.isEmpty(str2)) {
                                }
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, r.f7699a).getFileDescriptor()));
                                file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str + str2);
                                if (file.exists()) {
                                }
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    try {
                                        bArr = new byte[1444];
                                        while (true) {
                                            read = bufferedInputStream.read(bArr);
                                            if (read != -1) {
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        String path = file.getPath();
                                        try {
                                            bufferedInputStream.close();
                                            fileOutputStream.close();
                                        } catch (Exception unused) {
                                        }
                                        return path;
                                    } catch (Exception e3) {
                                        e = e3;
                                        LogUtil.e("weibo sdk copy", e.toString());
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (Exception unused2) {
                                                return null;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        return null;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream2 = bufferedInputStream;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception unused3) {
                                            throw th;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
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
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(Calendar.getInstance().getTimeInMillis());
                sb.append(i == 0 ? "_sdk_temp.mp4" : "_sdk_temp.jpg");
                str2 = sb.toString();
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(context.getContentResolver().openFileDescriptor(uri, r.f7699a).getFileDescriptor()));
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (bufferedInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
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
            bufferedInputStream.close();
            fileOutputStream.close();
            return path2;
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }
}
