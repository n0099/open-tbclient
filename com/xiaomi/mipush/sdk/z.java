package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class z implements Thread.UncaughtExceptionHandler {
    private static final Object a = new Object();
    private static final String[] b = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};
    private Context c;
    private SharedPreferences d;
    private Thread.UncaughtExceptionHandler e;

    public z(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public z(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.c = context;
        this.e = uncaughtExceptionHandler;
    }

    private void a(Throwable th) {
        String c = c(th);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String b2 = b(th);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        s.a(this.c).a(c, b2);
        if (b()) {
            c();
        }
    }

    private boolean a(boolean z, String str) {
        for (String str2 : b) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z;
    }

    private String b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
            sb.append(stackTrace[i].toString() + "\r\n");
        }
        String sb2 = sb.toString();
        return TextUtils.isEmpty(sb2) ? "" : com.xiaomi.channel.commonutils.string.d.a(sb2);
    }

    private boolean b() {
        this.d = this.c.getSharedPreferences("mipush_extra", 4);
        if (com.xiaomi.channel.commonutils.network.d.f(this.c)) {
            if (com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.Crash4GUploadSwitch.a(), true)) {
                return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.d.getLong("last_crash_upload_time_stamp", 0L))) >= ((float) Math.max(3600, com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.Crash4GUploadFrequency.a(), 3600))) * 0.9f;
            }
            return false;
        } else if (com.xiaomi.channel.commonutils.network.d.e(this.c)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.d.getLong("last_crash_upload_time_stamp", 0L)) >= ((long) Math.max(60, com.xiaomi.push.service.an.a(this.c).a(com.xiaomi.xmpush.thrift.g.CrashWIFIUploadFrequency.a(), 1800)));
        } else {
            return true;
        }
    }

    private String c(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(th.toString());
        sb.append("\r\n");
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElement2 = stackTraceElement.toString();
            z = a(z, stackTraceElement2);
            sb.append(stackTraceElement2);
            sb.append("\r\n");
        }
        return z ? sb.toString() : "";
    }

    private void c() {
        com.xiaomi.channel.commonutils.misc.h.a(this.c).a(new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.d = this.c.getSharedPreferences("mipush_extra", 4);
        SharedPreferences.Editor edit = this.d.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        com.xiaomi.channel.commonutils.android.l.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        synchronized (a) {
            try {
                a.wait(3000L);
            } catch (InterruptedException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        if (this.e != null) {
            this.e.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
