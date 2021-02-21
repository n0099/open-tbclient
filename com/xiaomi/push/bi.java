package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
/* loaded from: classes6.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f13884a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f205a;

    public void a(Context context) {
        this.f13884a = context;
    }

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f205a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f205a != null) {
                this.f205a.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            if (this.f205a instanceof IEventProcessor) {
                bm.a(this.f13884a).m195a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f205a instanceof IPerfProcessor) {
                bm.a(this.f13884a).m195a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
