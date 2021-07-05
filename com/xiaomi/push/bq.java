package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class bq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL;
        }
        return (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            String a2 = bt.a(context).a("sp_client_report_status", "sp_client_report_key", "");
            if (TextUtils.isEmpty(a2)) {
                String a3 = bm.a(20);
                bt.a(context).m189a("sp_client_report_status", "sp_client_report_key", a3);
                return a3;
            }
            return a2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
            intent.putExtra("pkgname", context.getPackageName());
            intent.putExtra("category", "category_client_report_data");
            intent.putExtra("name", "quality_support");
            intent.putExtra("data", str);
            context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e8, code lost:
        if (r7 == null) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) {
        File externalFilesDir;
        File file;
        RandomAccessFile randomAccessFile;
        Exception e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) || (externalFilesDir = context.getExternalFilesDir(str2)) == null) {
            return;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        File externalFilesDir2 = context.getExternalFilesDir(str);
        if (externalFilesDir2 != null) {
            if (!externalFilesDir2.exists()) {
                externalFilesDir2.mkdirs();
                return;
            }
            File[] listFiles = externalFilesDir2.listFiles(new br());
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            FileLock fileLock = null;
            RandomAccessFile randomAccessFile2 = null;
            File file2 = null;
            for (File file3 : listFiles) {
                if (file3 != null) {
                    try {
                    } catch (Exception e3) {
                        file = file2;
                        randomAccessFile = randomAccessFile2;
                        e2 = e3;
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (!TextUtils.isEmpty(file3.getAbsolutePath())) {
                        file = new File(file3.getAbsolutePath() + ".lock");
                        try {
                            y.m643a(file);
                            randomAccessFile = new RandomAccessFile(file, "rw");
                            try {
                                try {
                                    fileLock = randomAccessFile.getChannel().lock();
                                    File file4 = new File(externalFilesDir.getAbsolutePath() + File.separator + file3.getName() + currentTimeMillis);
                                    try {
                                        y.b(file3, file4);
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        file3.delete();
                                        file4.delete();
                                    }
                                    file3.delete();
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e5) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e5);
                                        }
                                    }
                                    y.a(randomAccessFile);
                                } catch (Throwable th2) {
                                    th = th2;
                                    randomAccessFile2 = randomAccessFile;
                                    file2 = file;
                                    if (fileLock != null && fileLock.isValid()) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e6) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e6);
                                        }
                                    }
                                    y.a(randomAccessFile2);
                                    if (file2 != null) {
                                        file2.delete();
                                    }
                                    throw th;
                                }
                            } catch (Exception e7) {
                                e2 = e7;
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e8) {
                                        com.xiaomi.channel.commonutils.logger.b.a(e8);
                                    }
                                }
                                y.a(randomAccessFile);
                            }
                        } catch (Exception e9) {
                            randomAccessFile = randomAccessFile2;
                            e2 = e9;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        file.delete();
                        randomAccessFile2 = randomAccessFile;
                        file2 = file;
                    }
                }
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e10) {
                        com.xiaomi.channel.commonutils.logger.b.a(e10);
                    }
                }
                y.a(randomAccessFile2);
                if (file2 != null) {
                    file2.delete();
                }
            }
        }
    }

    public static void a(Context context, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65540, null, context, list) == null) || list == null || list.size() <= 0 || !m185a(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m185a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m186a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            File file = new File(str);
            long maxFileLength = com.xiaomi.clientreport.manager.a.a(context).m75a().getMaxFileLength();
            if (file.exists()) {
                try {
                    if (file.length() > maxFileLength) {
                        return false;
                    }
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                    return false;
                }
            } else {
                y.m643a(file);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            byte[] copyOf = Arrays.copyOf(bj.m180a(str), 16);
            copyOf[0] = 68;
            copyOf[15] = 84;
            return copyOf;
        }
        return (byte[]) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m187a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            File externalFilesDir = context.getExternalFilesDir(str);
            if (externalFilesDir != null) {
                return externalFilesDir.listFiles(new bs());
            }
            return null;
        }
        return (File[]) invokeLL.objValue;
    }
}
