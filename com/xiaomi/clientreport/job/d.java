package com.xiaomi.clientreport.job;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes3.dex */
public class d implements Runnable {
    private com.xiaomi.clientreport.processor.c a;
    private Context b;

    public void a(Context context) {
        this.b = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a != null) {
                this.a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.a instanceof IEventProcessor) {
                com.xiaomi.clientreport.util.d.a(this.b).a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.a instanceof IPerfProcessor) {
                com.xiaomi.clientreport.util.d.a(this.b).a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
