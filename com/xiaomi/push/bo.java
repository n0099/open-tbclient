package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class bo extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f40288a;

    public bo(Context context) {
        this.f40288a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f40288a).m56a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f40288a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f40288a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e2);
        }
    }
}
