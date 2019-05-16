package com.xiaomi.clientreport.job;

import android.content.Context;
/* loaded from: classes3.dex */
public class a implements Runnable {
    private Context a;
    private com.xiaomi.clientreport.data.a b;
    private com.xiaomi.clientreport.processor.d c;

    public a(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.b = aVar;
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c != null) {
            this.c.b(this.b);
        }
    }
}
