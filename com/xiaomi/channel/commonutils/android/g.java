package com.xiaomi.channel.commonutils.android;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/* loaded from: classes2.dex */
public class g {
    private static int a = 0;

    public static synchronized boolean a() {
        boolean z;
        synchronized (g.class) {
            z = c() == 1;
        }
        return z;
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (g.class) {
            z = c() == 2;
        }
        return z;
    }

    public static synchronized int c() {
        FileInputStream fileInputStream;
        Properties properties;
        synchronized (g.class) {
            if (a == 0) {
                try {
                    properties = new Properties();
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
                try {
                    properties.load(fileInputStream);
                    a = properties.getProperty("ro.miui.ui.version.code", null) != null || properties.getProperty("ro.miui.ui.version.name", null) != null ? 1 : 2;
                    com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                    a = 0;
                    com.xiaomi.channel.commonutils.file.a.a(fileInputStream);
                    com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
                    return a;
                }
                com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + a);
            }
        }
        return a;
    }
}
