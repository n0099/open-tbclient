package org.acra;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSenderException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q extends Thread {
    private final Context a;
    private final boolean b;
    private final boolean c;
    private final i d = new i();
    private final List e;

    public q(Context context, List list, boolean z, boolean z2) {
        this.a = context;
        this.e = list;
        this.b = z;
        this.c = z2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.c) {
            a();
        }
        a(this.a, this.b);
    }

    private void a() {
        String[] a;
        Log.d(a.a, "Mark all pending reports as approved.");
        for (String str : new j(this.a).a()) {
            if (!this.d.b(str)) {
                File file = new File(this.a.getFilesDir(), str);
                File file2 = new File(this.a.getFilesDir(), str.replace(".stacktrace", "-approved.stacktrace"));
                if (!file.renameTo(file2)) {
                    Log.e(a.a, "Could not rename approved report from " + file + " to " + file2);
                }
            }
        }
    }

    private void a(Context context, boolean z) {
        int i = 0;
        Log.d(a.a, "#checkAndSendReports - start");
        String[] a = new j(context).a();
        Arrays.sort(a);
        for (String str : a) {
            if (!z || this.d.a(str)) {
                if (i >= 5) {
                    break;
                }
                Log.i(a.a, "Sending file " + str);
                try {
                    a(new l(context).a(str));
                    a(context, str);
                    i++;
                } catch (IOException e) {
                    Log.e(a.a, "Failed to load crash report for " + str, e);
                    a(context, str);
                } catch (RuntimeException e2) {
                    Log.e(a.a, "Failed to send crash reports for " + str, e2);
                    a(context, str);
                } catch (ReportSenderException e3) {
                    Log.e(a.a, "Failed to send crash report for " + str, e3);
                }
            }
        }
        Log.d(a.a, "#checkAndSendReports - finish");
    }

    private void a(CrashReportData crashReportData) {
        if (!a.e() || a.d().G()) {
            boolean z = false;
            Iterator it = this.e.iterator();
            while (true) {
                boolean z2 = z;
                if (it.hasNext()) {
                    org.acra.sender.e eVar = (org.acra.sender.e) it.next();
                    try {
                        eVar.a(crashReportData);
                        z = true;
                    } catch (ReportSenderException e) {
                        if (!z2) {
                            throw e;
                        }
                        Log.w(a.a, "ReportSender of class " + eVar.getClass().getName() + " failed but other senders completed their task. ACRA will not send this report again.");
                        z = z2;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void a(Context context, String str) {
        if (!context.deleteFile(str)) {
            Log.w(a.a, "Could not delete error report : " + str);
        }
    }
}
