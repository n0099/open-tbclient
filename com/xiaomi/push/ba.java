package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ai;
/* loaded from: classes3.dex */
public class ba extends ai.a {
    private Context a;

    public ba(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public int mo140a() {
        return 100886;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
