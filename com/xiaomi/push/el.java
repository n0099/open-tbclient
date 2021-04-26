package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.e.comm.constants.ErrorCode;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.mipush.sdk.MiPushMessage;
/* loaded from: classes7.dex */
public class el {

    /* renamed from: a  reason: collision with root package name */
    public static volatile el f38348a;

    /* renamed from: a  reason: collision with other field name */
    public Context f318a;

    public el(Context context) {
        this.f318a = context;
    }

    public static el a(Context context) {
        if (f38348a == null) {
            synchronized (el.class) {
                if (f38348a == null) {
                    f38348a = new el(context);
                }
            }
        }
        return f38348a;
    }

    private void a(com.xiaomi.clientreport.data.a aVar) {
        if (aVar instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f318a, (PerfClientReport) aVar);
        } else if (aVar instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f318a, (EventClientReport) aVar);
        }
    }

    public void a(String str, int i2, long j, long j2) {
        if (i2 < 0 || j2 < 0 || j <= 0) {
            return;
        }
        PerfClientReport a2 = ek.a(this.f318a, i2, j, j2);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_8_5");
        a(a2);
    }

    public void a(String str, Intent intent, int i2, String str2) {
        if (intent == null) {
            return;
        }
        a(str, ek.m274a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), i2, System.currentTimeMillis(), str2);
    }

    public void a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        a(str, ek.m274a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID), ErrorCode.SERVER_JSON_PARSE_ERROR, System.currentTimeMillis(), str2);
    }

    public void a(String str, String str2, String str3, int i2, long j, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport a2 = ek.a(this.f318a, str2, str3, i2, j, str4);
        a2.setAppPackageName(str);
        a2.setSdkVersion("3_8_5");
        a(a2);
    }

    public void a(String str, String str2, String str3, int i2, String str4) {
        a(str, str2, str3, i2, System.currentTimeMillis(), str4);
    }

    public void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ErrorCode.VIDEO_DOWNLOAD_FAIL, System.currentTimeMillis(), str4);
    }

    public void b(String str, String str2, String str3, String str4) {
        a(str, str2, str3, ErrorCode.SERVER_JSON_PARSE_ERROR, System.currentTimeMillis(), str4);
    }

    public void c(String str, String str2, String str3, String str4) {
        a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
