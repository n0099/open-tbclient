package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
public class az implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.data.a f138a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f139a;

    public az(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f138a = aVar;
        this.f139a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f139a != null) {
            this.f139a.mo47a(this.f138a);
        }
    }
}
