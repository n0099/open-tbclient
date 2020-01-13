package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
public class bd implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f143a;

    public bd(Context context, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f143a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f143a != null) {
                this.f143a.b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
