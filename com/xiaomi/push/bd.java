package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes5.dex */
public class bd implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f145a;

    public bd(Context context, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f145a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f145a != null) {
                this.f145a.b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
