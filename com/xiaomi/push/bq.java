package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes8.dex */
public class bq extends aj.a {
    public Context a;

    public bq(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m106a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo221a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e);
        }
    }
}
