package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes5.dex */
public class bc implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f144a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f144a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f144a != null) {
                this.f144a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f144a instanceof IEventProcessor) {
                bh.a(this.a).m147a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f144a instanceof IPerfProcessor) {
                bh.a(this.a).m147a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
