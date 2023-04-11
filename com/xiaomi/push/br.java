package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes8.dex */
public class br implements Runnable {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.clientreport.processor.c f150a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f150a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv a;
        String str;
        long currentTimeMillis;
        try {
            if (this.f150a != null) {
                this.f150a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f150a instanceof IEventProcessor) {
                a = bv.a(this.a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (!(this.f150a instanceof IPerfProcessor)) {
                return;
            } else {
                a = bv.a(this.a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a.m225a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
