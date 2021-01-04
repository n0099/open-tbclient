package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
public class bh extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14180a;

    public bh(Context context) {
        this.f14180a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f14180a).m77a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo185a() {
        return 100887;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f14180a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f14180a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
