package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
public class bd implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f144a;

    public bd(Context context, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f144a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f144a != null) {
                this.f144a.b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
