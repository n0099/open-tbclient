package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes8.dex */
public class az implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.data.a f135a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f136a;

    public az(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f135a = aVar;
        this.f136a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f136a != null) {
            this.f136a.mo52a(this.f135a);
        }
    }
}
