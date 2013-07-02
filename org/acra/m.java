package org.acra;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.format.Time;
import android.util.Log;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.acra.collector.CrashReportData;
/* loaded from: classes.dex */
public class m implements Thread.UncaughtExceptionHandler {
    private static boolean j = true;
    private boolean a;
    private final Context b;
    private final SharedPreferences c;
    private final org.acra.collector.c e;
    private final Thread.UncaughtExceptionHandler g;
    private Thread h;
    private Throwable i;
    private final List d = new ArrayList();
    private final i f = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, SharedPreferences sharedPreferences, boolean z) {
        this.a = false;
        this.b = context;
        this.c = sharedPreferences;
        this.a = z;
        String a = org.acra.collector.b.a(this.b);
        Time time = new Time();
        time.setToNow();
        this.e = new org.acra.collector.c(this.b, sharedPreferences, time, a);
        this.g = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        c();
    }

    public String a(String str, String str2) {
        return this.e.a(str, str2);
    }

    public void a(org.acra.sender.e eVar) {
        this.d.add(eVar);
    }

    public void a() {
        this.d.clear();
    }

    public void b(org.acra.sender.e eVar) {
        a();
        a(eVar);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (!this.a) {
                if (this.g != null) {
                    Log.e(a.a, "ACRA is disabled for " + this.b.getPackageName() + " - forwarding uncaught Exception on to default ExceptionHandler");
                    this.g.uncaughtException(thread, th);
                } else {
                    Log.e(a.a, "ACRA is disabled for " + this.b.getPackageName() + " - no default ExceptionHandler");
                }
            } else {
                this.h = thread;
                this.i = th;
                Log.e(a.a, "ACRA caught a " + th.getClass().getSimpleName() + " exception for " + this.b.getPackageName() + ". Building report.");
                a(th, a.d().q(), false, true);
            }
        } catch (Throwable th2) {
            if (this.g != null) {
                this.g.uncaughtException(thread, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (a.d().q() == ReportingInteractionMode.SILENT || (a.d().q() == ReportingInteractionMode.TOAST && a.d().h())) {
            this.g.uncaughtException(this.h, this.i);
            return;
        }
        Log.e(a.a, this.b.getPackageName() + " fatal error : " + this.i.getMessage(), this.i);
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    public void a(boolean z) {
        Log.i(a.a, "ACRA is " + (z ? "enabled" : "disabled") + " for " + this.b.getPackageName());
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q a(boolean z, boolean z2) {
        q qVar = new q(this.b, this.d, z, z2);
        qVar.start();
        return qVar;
    }

    void b() {
        a(true, true, 0);
    }

    public void c() {
        long j2 = this.c.getInt("acra.lastVersionNr", 0);
        PackageInfo a = new org.acra.util.g(this.b).a();
        if (a != null && ((long) a.versionCode) > j2) {
            if (a.d().f()) {
                b();
            }
            SharedPreferences.Editor edit = this.c.edit();
            edit.putInt("acra.lastVersionNr", a.versionCode);
            edit.commit();
        }
        if ((a.d().q() == ReportingInteractionMode.NOTIFICATION || a.d().q() == ReportingInteractionMode.DIALOG) && a.d().e()) {
            b(true);
        }
        j jVar = new j(this.b);
        String[] a2 = jVar.a();
        if (a2 != null && a2.length > 0) {
            ReportingInteractionMode q = a.d().q();
            String[] a3 = jVar.a();
            boolean b = b(a3);
            if (q == ReportingInteractionMode.SILENT || q == ReportingInteractionMode.TOAST || (b && (q == ReportingInteractionMode.NOTIFICATION || q == ReportingInteractionMode.DIALOG))) {
                if (q == ReportingInteractionMode.TOAST && !b) {
                    org.acra.util.i.a(this.b, a.d().B(), 1);
                }
                Log.v(a.a, "About to start ReportSenderWorker from #checkReportOnApplicationStart");
                a(false, false);
            } else if (a.d().q() == ReportingInteractionMode.NOTIFICATION) {
                b(a(a3));
            } else if (a.d().q() == ReportingInteractionMode.DIALOG) {
                a(a(a3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        a(false, true, z ? 1 : 0);
    }

    private void a(Throwable th, ReportingInteractionMode reportingInteractionMode, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        if (this.a) {
            if (reportingInteractionMode == null) {
                reportingInteractionMode = a.d().q();
                z3 = false;
            } else {
                z3 = reportingInteractionMode == ReportingInteractionMode.SILENT && a.d().q() != ReportingInteractionMode.SILENT;
            }
            if (th == null) {
                th = new Exception("Report requested by developer");
            }
            boolean z5 = reportingInteractionMode == ReportingInteractionMode.TOAST || (a.d().B() != 0 && (reportingInteractionMode == ReportingInteractionMode.NOTIFICATION || reportingInteractionMode == ReportingInteractionMode.DIALOG));
            if (z5) {
                new n(this).start();
            }
            CrashReportData a = this.e.a(th, z, this.h);
            String a2 = a(a);
            a(a2, a);
            q qVar = null;
            if (reportingInteractionMode == ReportingInteractionMode.SILENT || reportingInteractionMode == ReportingInteractionMode.TOAST || this.c.getBoolean("acra.alwaysaccept", false)) {
                Log.d(a.a, "About to start ReportSenderWorker from #handleException");
                qVar = a(z3, true);
            } else if (reportingInteractionMode == ReportingInteractionMode.NOTIFICATION) {
                Log.d(a.a, "About to send status bar notification from #handleException");
                b(a2);
            }
            if (z5) {
                j = false;
                new o(this).start();
            }
            if (reportingInteractionMode != ReportingInteractionMode.DIALOG || this.c.getBoolean("acra.alwaysaccept", false)) {
                z4 = false;
            }
            new p(this, qVar, z4, a2, z2).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        Log.d(a.a, "Creating Dialog for " + str);
        Intent intent = new Intent(this.b, CrashReportDialog.class);
        intent.putExtra("REPORT_FILE_NAME", str);
        intent.setFlags(268435456);
        this.b.startActivity(intent);
    }

    private void b(String str) {
        NotificationManager notificationManager = (NotificationManager) this.b.getSystemService("notification");
        d d = a.d();
        Notification notification = new Notification(d.x(), this.b.getText(d.z()), System.currentTimeMillis());
        CharSequence text = this.b.getText(d.A());
        CharSequence text2 = this.b.getText(d.y());
        Intent intent = new Intent(this.b, CrashReportDialog.class);
        Log.d(a.a, "Creating Notification for " + str);
        intent.putExtra("REPORT_FILE_NAME", str);
        notification.setLatestEventInfo(this.b, text, text2, PendingIntent.getActivity(this.b, 0, intent, 134217728));
        notificationManager.cancelAll();
        notificationManager.notify(666, notification);
    }

    private String a(CrashReportData crashReportData) {
        Time time = new Time();
        time.setToNow();
        return "" + time.toMillis(false) + (crashReportData.getProperty(ReportField.IS_SILENT) != null ? e.a : "") + ".stacktrace";
    }

    private void a(String str, CrashReportData crashReportData) {
        try {
            Log.d(a.a, "Writing crash report file " + str + ".");
            new l(this.b).a(crashReportData, str);
        } catch (Exception e) {
            Log.e(a.a, "An error occurred while writing the report file...", e);
        }
    }

    private String a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            for (int length = strArr.length - 1; length >= 0; length--) {
                if (!this.f.a(strArr[length])) {
                    return strArr[length];
                }
            }
            return strArr[strArr.length - 1];
        }
        return null;
    }

    private void a(boolean z, boolean z2, int i) {
        String[] a = new j(this.b).a();
        Arrays.sort(a);
        if (a != null) {
            for (int i2 = 0; i2 < a.length - i; i2++) {
                String str = a[i2];
                boolean b = this.f.b(str);
                if ((b && z) || (!b && z2)) {
                    File file = new File(this.b.getFilesDir(), str);
                    if (!file.delete()) {
                        Log.e(a.a, "Could not delete report : " + file);
                    }
                }
            }
        }
    }

    private boolean b(String[] strArr) {
        for (String str : strArr) {
            if (!this.f.b(str)) {
                return false;
            }
        }
        return true;
    }

    public void d() {
        d d = a.d();
        Application f = a.f();
        a();
        if (!"".equals(d.o())) {
            Log.w(a.a, f.getPackageName() + " reports will be sent by email (if accepted by user).");
            b(new org.acra.sender.a(f));
        } else if (!new org.acra.util.g(f).a("android.permission.INTERNET")) {
            Log.e(a.a, f.getPackageName() + " should be granted permission android.permission.INTERNET if you want your crash reports to be sent. If you don't want to add this permission to your application you can also enable sending reports by email. If this is your will then provide your email address in @ReportsCrashes(mailTo=\"your.account@domain.com\"");
        } else if (d.j() != null && !"".equals(d.j())) {
            b(new org.acra.sender.d(null));
        } else if (d.i() != null && !"".equals(d.i().trim())) {
            a(new org.acra.sender.b());
        }
    }
}
