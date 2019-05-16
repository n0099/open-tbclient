package com.xiaomi.clientreport.job;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
public class b extends h.a {
    private Context a;

    public b(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 100886;
    }

    public boolean b() {
        if (com.xiaomi.clientreport.manager.a.a(this.a).a().isEventUploadSwitchOpen()) {
            r0 = ((int) ((System.currentTimeMillis() - com.xiaomi.clientreport.util.d.a(this.a).b("sp_client_report_status", "event_last_upload_time", 0L)) / 1000)) >= ((int) com.xiaomi.clientreport.manager.a.a(this.a).a().getEventUploadFrequency()) + (-5);
            com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " event upload result " + r0);
        }
        return r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).c();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
