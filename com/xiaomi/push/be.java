package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class be {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String a = bh.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (TextUtils.isEmpty(a)) {
            String a2 = ay.a(20);
            bh.a(context).m165a("sp_client_report_status", "sp_client_report_key", a2);
            return a2;
        }
        return a;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) {
        RandomAccessFile randomAccessFile;
        Exception exc;
        File file;
        FileLock fileLock;
        RandomAccessFile randomAccessFile2;
        File externalFilesDir = context.getExternalFilesDir(str2);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            File externalFilesDir2 = context.getExternalFilesDir(str);
            if (externalFilesDir2 != null) {
                if (!externalFilesDir2.exists()) {
                    externalFilesDir2.mkdirs();
                    return;
                }
                File[] listFiles = externalFilesDir2.listFiles(new bf());
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                RandomAccessFile randomAccessFile3 = null;
                FileLock fileLock2 = null;
                File file2 = null;
                long currentTimeMillis = System.currentTimeMillis();
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file3 = listFiles[i];
                    if (file3 != null) {
                        try {
                        } catch (Exception e) {
                            exc = e;
                            file = file2;
                            fileLock = fileLock2;
                            randomAccessFile2 = randomAccessFile3;
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile3;
                        }
                        if (!TextUtils.isEmpty(file3.getAbsolutePath())) {
                            file = new File(file3.getAbsolutePath() + ".lock");
                            try {
                                y.m571a(file);
                                randomAccessFile = new RandomAccessFile(file, "rw");
                                try {
                                    fileLock = randomAccessFile.getChannel().lock();
                                } catch (Exception e2) {
                                    fileLock = fileLock2;
                                    randomAccessFile2 = randomAccessFile;
                                    exc = e2;
                                } catch (Throwable th2) {
                                    file2 = file;
                                    th = th2;
                                }
                                try {
                                    File file4 = new File(externalFilesDir.getAbsolutePath() + File.separator + file3.getName() + currentTimeMillis);
                                    try {
                                        y.b(file3, file4);
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        file3.delete();
                                        file4.delete();
                                    }
                                    file3.delete();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e4) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e4);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                    if (file != null) {
                                        file.delete();
                                        randomAccessFile2 = randomAccessFile;
                                    } else {
                                        randomAccessFile2 = randomAccessFile;
                                    }
                                } catch (Exception e5) {
                                    randomAccessFile2 = randomAccessFile;
                                    exc = e5;
                                    try {
                                        com.xiaomi.channel.commonutils.logger.b.a(exc);
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException e6) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e6);
                                            }
                                        }
                                        y.a(randomAccessFile2);
                                        if (file != null) {
                                            file.delete();
                                        }
                                        i++;
                                        randomAccessFile3 = randomAccessFile2;
                                        fileLock2 = fileLock;
                                        file2 = file;
                                    } catch (Throwable th3) {
                                        randomAccessFile = randomAccessFile2;
                                        fileLock2 = fileLock;
                                        file2 = file;
                                        th = th3;
                                        if (fileLock2 != null && fileLock2.isValid()) {
                                            try {
                                                fileLock2.release();
                                            } catch (IOException e7) {
                                                com.xiaomi.channel.commonutils.logger.b.a(e7);
                                            }
                                        }
                                        y.a(randomAccessFile);
                                        if (file2 != null) {
                                            file2.delete();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    fileLock2 = fileLock;
                                    file2 = file;
                                    th = th4;
                                    if (fileLock2 != null) {
                                        fileLock2.release();
                                    }
                                    y.a(randomAccessFile);
                                    if (file2 != null) {
                                    }
                                    throw th;
                                }
                            } catch (Exception e8) {
                                exc = e8;
                                fileLock = fileLock2;
                                randomAccessFile2 = randomAccessFile3;
                            } catch (Throwable th5) {
                                randomAccessFile = randomAccessFile3;
                                th = th5;
                                file2 = file;
                            }
                            i++;
                            randomAccessFile3 = randomAccessFile2;
                            fileLock2 = fileLock;
                            file2 = file;
                        }
                    }
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e9) {
                            com.xiaomi.channel.commonutils.logger.b.a(e9);
                        }
                    }
                    y.a(randomAccessFile3);
                    if (file2 != null) {
                        file2.delete();
                        file = file2;
                        fileLock = fileLock2;
                        randomAccessFile2 = randomAccessFile3;
                    } else {
                        file = file2;
                        fileLock = fileLock2;
                        randomAccessFile2 = randomAccessFile3;
                    }
                    i++;
                    randomAccessFile3 = randomAccessFile2;
                    fileLock2 = fileLock;
                    file2 = file;
                }
            }
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m161a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m161a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m162a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        } else {
            y.m571a(file);
        }
        return true;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(av.a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m163a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new bg());
        }
        return null;
    }
}
