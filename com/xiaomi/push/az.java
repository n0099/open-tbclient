package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class az implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.data.a f136a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f137a;

    public az(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f136a = aVar;
        this.f137a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f137a != null) {
            this.f137a.mo52a(this.f136a);
        }
    }
}
