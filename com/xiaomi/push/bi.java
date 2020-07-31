package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes9.dex */
public class bi implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f128a;

    public void a(Context context) {
        this.a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f128a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f128a != null) {
                this.f128a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f128a instanceof IEventProcessor) {
                bm.a(this.a).m165a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f128a instanceof IPerfProcessor) {
                bm.a(this.a).m165a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
