package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes12.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f4812a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f124a;

    public void a(Context context) {
        this.f4812a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f124a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f124a != null) {
                this.f124a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f124a instanceof IEventProcessor) {
                bm.a(this.f4812a).m170a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f124a instanceof IPerfProcessor) {
                bm.a(this.f4812a).m170a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
