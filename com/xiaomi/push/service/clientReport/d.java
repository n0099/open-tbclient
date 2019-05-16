package com.xiaomi.push.service.clientReport;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
/* loaded from: classes3.dex */
public class d {
    private static volatile d a;
    private Context b;

    private d(Context context) {
        this.b = context;
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.b, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.b, (EventClientReport) aVar);
        }
    }

    public void a(int i, long j, long j2) {
        if (i < 0 || j2 < 0 || j <= 0) {
            return;
        }
        a(c.a(this.b, i, j, j2));
    }

    public void a(Intent intent, int i, String str) {
        if (intent == null) {
            return;
        }
        a(c.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str);
    }

    public void a(Intent intent, String str) {
        if (intent == null) {
            return;
        }
        a(c.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str);
    }

    public void a(Intent intent, Throwable th) {
        if (intent == null) {
            return;
        }
        a(c.a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), th.getMessage());
    }

    public void a(String str, String str2, int i, long j, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a(c.a(this.b, str, str2, i, j, str3));
    }

    public void a(String str, String str2, int i, String str3) {
        a(str, str2, i, System.currentTimeMillis(), str3);
    }

    public void a(String str, String str2, String str3) {
        a(str, str2, 5002, System.currentTimeMillis(), str3);
    }

    public void a(String str, String str2, Throwable th) {
        a(str, str2, 5001, System.currentTimeMillis(), th.getMessage());
    }

    public void b(String str, String str2, String str3) {
        a(str, str2, 5001, System.currentTimeMillis(), str3);
    }

    public void c(String str, String str2, String str3) {
        a(str, str2, 4002, System.currentTimeMillis(), str3);
    }
}
