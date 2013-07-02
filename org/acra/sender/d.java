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
public class d implements e {
    private final Uri a = null;
    private final Map b;

    public d(Map map) {
        this.b = map;
    }

    @Override // org.acra.sender.e
    public void a(CrashReportData crashReportData) {
        try {
            Map a = a((Map) crashReportData);
            URL url = this.a == null ? new URL(org.acra.a.d().j()) : new URL(this.a.toString());
            Log.d(org.acra.a.a, "Connect to " + url.toString());
            String k = a(org.acra.a.d().k()) ? null : org.acra.a.d().k();
            String l = a(org.acra.a.d().l()) ? null : org.acra.a.d().l();
            org.acra.util.b bVar = new org.acra.util.b();
            bVar.a(org.acra.a.d().c());
            bVar.b(org.acra.a.d().E());
            bVar.c(org.acra.a.d().p());
            bVar.a(k);
            bVar.b(l);
            bVar.a(url, a);
        } catch (IOException e) {
            throw new ReportSenderException("Error while sending report to Http Post Form.", e);
        }
    }

    private static boolean a(String str) {
        return str == null || "ACRA-NULL-STRING".equals(str);
    }

    private Map a(Map map) {
        ReportField[] d = org.acra.a.d().d();
        if (d.length == 0) {
            d = org.acra.a.d;
        }
        HashMap hashMap = new HashMap(map.size());
        for (ReportField reportField : d) {
            if (this.b == null || this.b.get(reportField) == null) {
                hashMap.put(reportField.toString(), map.get(reportField));
            } else {
                hashMap.put(this.b.get(reportField), map.get(reportField));
            }
        }
        return hashMap;
    }
}
