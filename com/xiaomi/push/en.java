package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
/* loaded from: classes10.dex */
public class en {
    public static volatile en a;

    /* renamed from: a  reason: collision with other field name */
    public Context f315a;

    public en(Context context) {
        this.f315a = context;
    }

    public static en a(Context context) {
        if (a == null) {
            synchronized (en.class) {
                if (a == null) {
                    a = new en(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f315a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f315a, (EventClientReport) aVar);
        }
    }

    public void a(String str, int i, long j, long j2) {
        if (i < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport a2 = em.a(this.f315a, i, j, j2);
        a2.setAppPackageName(str);
        a2.setSdkVersion(BuildConfig.VERSION_NAME);
        a(a2);
    }

    public void a(String str, Intent intent, int i, String str2) {
        if (intent == null) {
            return;
        }
        a(str, em.m450a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), i, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, em.m450a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), 5001, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport a2 = em.a(this.f315a, str2, str3, i, j, str4);
        a2.setAppPackageName(str);
        a2.setSdkVersion(BuildConfig.VERSION_NAME);
        a(a2);
    }

    public void a(String str, String str2, String str3, int i, String str4) {
        a(str, str2, str3, i, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
