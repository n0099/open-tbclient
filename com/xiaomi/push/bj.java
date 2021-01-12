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
/* loaded from: classes6.dex */
public class bj {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String a2 = bm.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (TextUtils.isEmpty(a2)) {
            String a3 = bf.a(20);
            bm.a(context).m197a("sp_client_report_status", "sp_client_report_key", a3);
            return a3;
        }
        return a2;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, String str, String str2) {
        Throwable th;
        File file;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        File file2;
        FileLock lock;
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
                File[] listFiles = externalFilesDir2.listFiles(new bk());
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                int length = listFiles.length;
                int i = 0;
                File file3 = null;
                FileLock fileLock2 = null;
                RandomAccessFile randomAccessFile2 = null;
                while (i < length) {
                    File file4 = listFiles[i];
                    if (file4 != null) {
                        try {
                        } catch (Exception e) {
                            e = e;
                            file2 = file3;
                            randomAccessFile = randomAccessFile2;
                        } catch (Throwable th2) {
                            th = th2;
                            file = file3;
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                        }
                        if (!TextUtils.isEmpty(file4.getAbsolutePath())) {
                            file2 = new File(file4.getAbsolutePath() + ".lock");
                            try {
                                y.m616a(file2);
                                randomAccessFile = new RandomAccessFile(file2, "rw");
                                try {
                                    try {
                                        lock = randomAccessFile.getChannel().lock();
                                    } catch (Throwable th3) {
                                        th = th3;
                                        file = file2;
                                        fileLock = fileLock2;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                randomAccessFile = randomAccessFile2;
                            } catch (Throwable th4) {
                                th = th4;
                                file = file2;
                                fileLock = fileLock2;
                                randomAccessFile = randomAccessFile2;
                            }
                            try {
                                File file5 = new File(externalFilesDir.getAbsolutePath() + File.separator + file4.getName() + currentTimeMillis);
                                try {
                                    y.b(file4, file5);
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    file4.delete();
                                    file5.delete();
                                }
                                file4.delete();
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException e5) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e5);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file2 != null) {
                                    file2.delete();
                                    fileLock2 = lock;
                                } else {
                                    fileLock2 = lock;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                fileLock2 = lock;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
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
                                i++;
                                file3 = file2;
                                randomAccessFile2 = randomAccessFile;
                            } catch (Throwable th5) {
                                th = th5;
                                file = file2;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e8) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e8);
                                    }
                                }
                                y.a(randomAccessFile);
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                            i++;
                            file3 = file2;
                            randomAccessFile2 = randomAccessFile;
                        }
                    }
                    if (fileLock2 != null && fileLock2.isValid()) {
                        try {
                            fileLock2.release();
                        } catch (IOException e9) {
                            com.xiaomi.channel.commonutils.logger.b.a(e9);
                        }
                    }
                    y.a(randomAccessFile2);
                    if (file3 != null) {
                        file3.delete();
                        file2 = file3;
                        randomAccessFile = randomAccessFile2;
                    } else {
                        file2 = file3;
                        randomAccessFile = randomAccessFile2;
                    }
                    i++;
                    file3 = file2;
                    randomAccessFile2 = randomAccessFile;
                }
            }
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !m193a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m193a(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m194a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m84a().getMaxFileLength();
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
            y.m616a(file);
        }
        return true;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(bc.m188a(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m195a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new bl());
        }
        return null;
    }
}
