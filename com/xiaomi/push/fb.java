package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
/* loaded from: classes6.dex */
public class fb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile fb f14305a;

    /* renamed from: a  reason: collision with other field name */
    private Context f391a;

    private fb(Context context) {
        this.f391a = context;
    }

    public static fb a(Context context) {
        if (f14305a == null) {
            synchronized (fb.class) {
                if (f14305a == null) {
                    f14305a = new fb(context);
                }
            }
        }
        return f14305a;
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f391a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f391a, (EventClientReport) aVar);
        }
    }

    public void a(String str, int i, long j, long j2) {
        if (i < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport a2 = fa.a(this.f391a, i, j, j2);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_7_5");
        a(a2);
    }

    public void a(String str, Intent intent, int i, String str2) {
        if (intent == null) {
            return;
        }
        a(str, fa.m301a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, fa.m301a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), ARPMessageType.MSG_TYPE_RES_REQUEST, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport a2 = fa.a(this.f391a, str2, str3, i, j, str4);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_7_5");
        a(a2);
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ARPMessageType.MSG_TYPE_RES_REQUEST, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
