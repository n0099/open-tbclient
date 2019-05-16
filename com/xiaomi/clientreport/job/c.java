package com.xiaomi.clientreport.job;

import android.content.Context;
import com.xiaomi.channel.commonutils.misc.h;
/* loaded from: classes3.dex */
public class c extends h.a {
    private Context a;

    public c(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.channel.commonutils.misc.h.a
    public int a() {
        return 100887;
    }

    public boolean b() {
        if (com.xiaomi.clientreport.manager.a.a(this.a).a().isPerfUploadSwitchOpen()) {
            r0 = ((int) ((System.currentTimeMillis() - com.xiaomi.clientreport.util.d.a(this.a).b("sp_client_report_status", "perf_last_upload_time", 0L)) / 1000)) >= ((int) com.xiaomi.clientreport.manager.a.a(this.a).a().getPerfUploadFrequency()) + (-5);
            com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + "perf upload result " + r0);
        }
        return r0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                com.xiaomi.clientreport.manager.a.a(this.a).d();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
