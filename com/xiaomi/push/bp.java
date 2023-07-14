package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class bp extends aj.a {
    public Context a;

    public bp(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m182a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo297a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).m184b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
