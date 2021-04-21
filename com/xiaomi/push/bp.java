package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes7.dex */
public class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f40674a;

    /* renamed from: a  reason: collision with other field name */
    public com.xiaomi.clientreport.processor.c f155a;

    public void a(Context context) {
        this.f40674a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f155a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt a2;
        String str;
        long currentTimeMillis;
        try {
            if (this.f155a != null) {
                this.f155a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f155a instanceof IEventProcessor) {
                a2 = bt.a(this.f40674a);
                str = "event_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            } else if (!(this.f155a instanceof IPerfProcessor)) {
                return;
            } else {
                a2 = bt.a(this.f40674a);
                str = "perf_last_upload_time";
                currentTimeMillis = System.currentTimeMillis();
            }
            a2.m173a("sp_client_report_status", str, currentTimeMillis);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
