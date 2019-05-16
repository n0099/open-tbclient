package com.xiaomi.clientreport.job;

import android.content.Context;
/* loaded from: classes3.dex */
public class e implements Runnable {
    private com.xiaomi.clientreport.processor.d a;
    private Context b;

    public e(Context context, com.xiaomi.clientreport.processor.d dVar) {
        this.b = context;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a != null) {
                this.a.b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
