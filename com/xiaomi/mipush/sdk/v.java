package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.hr;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class v implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4780a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f82a = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};

    /* renamed from: a  reason: collision with other field name */
    private Context f83a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f84a;

    /* renamed from: a  reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f85a;

    public v(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public v(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f83a = context;
        this.f85a = uncaughtExceptionHandler;
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(3, stackTrace.length); i++) {
            sb.append(stackTrace[i].toString() + "\r\n");
        }
        String sb2 = sb.toString();
        return TextUtils.isEmpty(sb2) ? "" : bf.a(sb2);
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m119a() {
        com.xiaomi.push.ai.a(this.f83a).a(new w(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m121a(Throwable th) {
        String b = b(th);
        if (TextUtils.isEmpty(b)) {
            return;
        }
        String a2 = a(th);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        s.a(this.f83a).a(b, a2);
        if (m122a()) {
            m119a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m122a() {
        this.f84a = this.f83a.getSharedPreferences("mipush_extra", 4);
        if (az.e(this.f83a)) {
            if (com.xiaomi.push.service.ak.a(this.f83a).a(hr.Crash4GUploadSwitch.a(), true)) {
                return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.f84a.getLong("last_crash_upload_time_stamp", 0L))) >= ((float) Math.max(3600, com.xiaomi.push.service.ak.a(this.f83a).a(hr.Crash4GUploadFrequency.a(), 3600))) * 0.9f;
            }
            return false;
        } else if (az.d(this.f83a)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f84a.getLong("last_crash_upload_time_stamp", 0L)) >= ((long) Math.max(60, com.xiaomi.push.service.ak.a(this.f83a).a(hr.CrashWIFIUploadFrequency.a(), 1800)));
        } else {
            return true;
        }
    }

    private boolean a(boolean z, String str) {
        for (String str2 : f82a) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z;
    }

    private String b(Throwable th) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f84a = this.f83a.getSharedPreferences("mipush_extra", 4);
        SharedPreferences.Editor edit = this.f84a.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        com.xiaomi.push.r.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m121a(th);
        synchronized (f4780a) {
            try {
                f4780a.wait(IMConnection.RETRY_DELAY_TIMES);
            } catch (InterruptedException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        if (this.f85a != null) {
            this.f85a.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
