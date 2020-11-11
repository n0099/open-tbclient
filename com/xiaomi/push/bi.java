package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes12.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f4814a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f126a;

    public void a(Context context) {
        this.f4814a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f126a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f126a != null) {
                this.f126a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f126a instanceof IEventProcessor) {
                bm.a(this.f4814a).m170a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f126a instanceof IPerfProcessor) {
                bm.a(this.f4814a).m170a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
