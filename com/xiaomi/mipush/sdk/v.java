package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.hr;
import java.lang.Thread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class v implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f14140a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f162a = {"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};

    /* renamed from: a  reason: collision with other field name */
    private Context f163a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f164a;

    /* renamed from: a  reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f165a;

    public v(Context context) {
        this(context, Thread.getDefaultUncaughtExceptionHandler());
    }

    public v(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f163a = context;
        this.f165a = uncaughtExceptionHandler;
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
    private void m149a() {
        com.xiaomi.push.ai.a(this.f163a).a(new w(this));
    }

    /* renamed from: a  reason: collision with other method in class */
    private void m151a(Throwable th) {
        String b2 = b(th);
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String a2 = a(th);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        s.a(this.f163a).a(b2, a2);
        if (m152a()) {
            m149a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m152a() {
        this.f164a = this.f163a.getSharedPreferences("mipush_extra", 4);
        if (az.e(this.f163a)) {
            if (com.xiaomi.push.service.ak.a(this.f163a).a(hr.Crash4GUploadSwitch.a(), true)) {
                return ((float) Math.abs((System.currentTimeMillis() / 1000) - this.f164a.getLong("last_crash_upload_time_stamp", 0L))) >= ((float) Math.max((int) SdkConfigData.DEFAULT_REQUEST_INTERVAL, com.xiaomi.push.service.ak.a(this.f163a).a(hr.Crash4GUploadFrequency.a(), SdkConfigData.DEFAULT_REQUEST_INTERVAL))) * 0.9f;
            }
            return false;
        } else if (az.d(this.f163a)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f164a.getLong("last_crash_upload_time_stamp", 0L)) >= ((long) Math.max(60, com.xiaomi.push.service.ak.a(this.f163a).a(hr.CrashWIFIUploadFrequency.a(), 1800)));
        } else {
            return true;
        }
    }

    private boolean a(boolean z, String str) {
        for (String str2 : f162a) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return z;
    }

    private String b(Throwable th) {
        boolean z;
        boolean z2 = false;
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder(th.toString());
        sb.append("\r\n");
        int i = 0;
        while (true) {
            z = z2;
            if (i >= stackTrace.length) {
                break;
            }
            String stackTraceElement = stackTrace[i].toString();
            z2 = a(z, stackTraceElement);
            sb.append(stackTraceElement);
            sb.append("\r\n");
            i++;
        }
        return z ? sb.toString() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f164a = this.f163a.getSharedPreferences("mipush_extra", 4);
        SharedPreferences.Editor edit = this.f164a.edit();
        edit.putLong("last_crash_upload_time_stamp", System.currentTimeMillis() / 1000);
        com.xiaomi.push.r.a(edit);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        m151a(th);
        synchronized (f14140a) {
            try {
                f14140a.wait(IMConnection.RETRY_DELAY_TIMES);
            } catch (InterruptedException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        if (this.f165a != null) {
            this.f165a.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
