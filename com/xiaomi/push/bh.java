package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
public class bh extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14181a;

    public bh(Context context) {
        this.f14181a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f14181a).m88a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo196a() {
        return 100887;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f14181a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f14181a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
