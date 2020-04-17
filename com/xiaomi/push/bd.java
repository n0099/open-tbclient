package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class bd implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f141a;

    public bd(Context context, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f141a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f141a != null) {
                this.f141a.b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
