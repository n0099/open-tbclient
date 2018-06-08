package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes3.dex */
public class a {
    private static int a(List<String> list, String str) {
        for (int i = 0; list != null && i < list.size(); i++) {
            if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(list.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private static String a(String str) {
        String[] split;
        return (str == null || (split = str.split("/")) == null || split.length <= 0) ? str : split[split.length - 1];
    }

    public static List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        String b = b(context);
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(b);
        }
        String a = i.a("ro.product.cpu.abi", "");
        if (!TextUtils.isEmpty(a)) {
            arrayList.add(a);
        }
        String a2 = i.a("ro.product.cpu.abi2", "");
        if (!TextUtils.isEmpty(a2)) {
            arrayList.add(a2);
        }
        String a3 = i.a("ro.product.cpu.abilist", "");
        if (!TextUtils.isEmpty(a3)) {
            String[] split = a3.split(",");
            for (int i = 0; split != null && i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i])) {
                    arrayList.add(split[i]);
                }
            }
        }
        arrayList.add(com.baidu.fsg.biometrics.base.d.h.a);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2) {
        ZipFile zipFile;
        Exception e;
        int a;
        ZipFile zipFile2 = null;
        if (str != null) {
            try {
                if (!str.endsWith(File.separator)) {
                    str = str + File.separator;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (zipFile2 == null) {
                        try {
                            zipFile2.close();
                            return;
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zipFile = null;
                if (zipFile != null) {
                }
                throw th;
            }
        }
        if (str2 != null && !str2.endsWith(File.separator)) {
            str2 = str2 + File.separator;
        }
        HashMap hashMap = new HashMap();
        List<String> a2 = a(context);
        zipFile = new ZipFile(str);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            byte[] bArr = new byte[1024];
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                com.xiaomi.channel.commonutils.logger.b.b("ze.getName() = " + nextElement.getName());
                if (nextElement.getName().startsWith(PluginInstallerService.APK_LIB_DIR_PREFIX) && !nextElement.isDirectory()) {
                    String a3 = a(nextElement.getName());
                    String b = b(nextElement.getName());
                    String str3 = (String) hashMap.get(a3);
                    if (TextUtils.isEmpty(str3) || ((a = a(a2, b)) >= 0 && a < a(a2, str3))) {
                        com.xiaomi.channel.commonutils.logger.b.b("use abi " + b);
                        hashMap.put(a3, b);
                        File file = new File(str2 + a3);
                        if (file.exists()) {
                            file.delete();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
                        com.xiaomi.channel.commonutils.file.a.a(fileOutputStream);
                    }
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Exception e6) {
            e = e6;
            zipFile2 = zipFile;
            e.printStackTrace();
            if (zipFile2 == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipFile != null) {
            }
            throw th;
        }
    }

    public static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field declaredField = Class.forName("android.content.pm.ApplicationInfo").getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable th) {
            return null;
        }
    }

    private static String b(String str) {
        String[] split;
        return (str == null || (split = str.split("/")) == null || split.length <= 1) ? com.baidu.fsg.biometrics.base.d.h.a : split[split.length - 2];
    }
}
