package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes6.dex */
public class bg extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14180a;

    public bg(Context context) {
        this.f14180a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f14180a).m88a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public int mo196a() {
        return 100886;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f14180a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f14180a).m90b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
