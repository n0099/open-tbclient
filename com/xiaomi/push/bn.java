package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class bn extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f37433a;

    public bn(Context context) {
        this.f37433a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.f37433a).m62a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo171a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.f37433a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.f37433a).m64b();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
