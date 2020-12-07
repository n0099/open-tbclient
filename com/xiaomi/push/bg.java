package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes18.dex */
public class bg extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f4582a;

    public bg(Context context) {
        this.f4582a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f4582a).m51a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public int mo159a() {
        return 100886;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f4582a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f4582a).m53b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
