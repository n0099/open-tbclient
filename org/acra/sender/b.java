package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
/* loaded from: classes.dex */
public class b implements e {
    private final Uri a = null;

    @Override // org.acra.sender.e
    public void a(CrashReportData crashReportData) {
        Uri parse = this.a == null ? Uri.parse(String.format(org.acra.a.d().K(), org.acra.a.d().i())) : this.a;
        Map a = a((Map) crashReportData);
        a.put("pageNumber", "0");
        a.put("backupCache", "");
        a.put("submit", "Envoyer");
        try {
            URL url = new URL(parse.toString());
            Log.d(org.acra.a.a, "Sending report " + ((String) crashReportData.get(ReportField.REPORT_ID)));
            Log.d(org.acra.a.a, "Connect to " + url);
            org.acra.util.b bVar = new org.acra.util.b();
            bVar.a(org.acra.a.d().c());
            bVar.b(org.acra.a.d().E());
            bVar.c(org.acra.a.d().p());
            bVar.a(url, a);
        } catch (IOException e) {
            throw new ReportSenderException("Error while sending report to Google Form.", e);
        }
    }

    private Map a(Map map) {
        ReportField[] d = org.acra.a.d().d();
        ReportField[] reportFieldArr = d.length == 0 ? org.acra.a.d : d;
        HashMap hashMap = new HashMap();
        int i = 0;
        for (ReportField reportField : reportFieldArr) {
            switch (c.a[reportField.ordinal()]) {
                case 1:
                    hashMap.put("entry." + i + ".single", "'" + ((String) map.get(reportField)));
                    break;
                case 2:
                    hashMap.put("entry." + i + ".single", "'" + ((String) map.get(reportField)));
                    break;
                default:
                    hashMap.put("entry." + i + ".single", map.get(reportField));
                    break;
            }
            i++;
        }
        return hashMap;
    }
}
