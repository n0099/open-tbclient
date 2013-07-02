package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
/* loaded from: classes.dex */
public class a implements e {
    private final Context a;

    public a(Context context) {
        this.a = context;
    }

    @Override // org.acra.sender.e
    public void a(CrashReportData crashReportData) {
        String b = b(crashReportData);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", this.a.getPackageName() + " Crash Report");
        intent.putExtra("android.intent.extra.TEXT", b);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{org.acra.a.d().o()});
        this.a.startActivity(intent);
    }

    private String b(CrashReportData crashReportData) {
        ReportField[] d = org.acra.a.d().d();
        ReportField[] reportFieldArr = d.length == 0 ? org.acra.a.c : d;
        StringBuilder sb = new StringBuilder();
        for (ReportField reportField : reportFieldArr) {
            sb.append(reportField.toString()).append("=");
            sb.append((String) crashReportData.get(reportField));
            sb.append('\n');
        }
        return sb.toString();
    }
}
