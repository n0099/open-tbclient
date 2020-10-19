package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes12.dex */
public class bh extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4813a;

    public bh(Context context) {
        this.f4813a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f4813a).m59a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo167a() {
        return 100887;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.f4813a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.f4813a.getPackageName() + "perf  begin upload");
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
