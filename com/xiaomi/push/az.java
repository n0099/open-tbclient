package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes6.dex */
public class az implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.data.a f139a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f140a;

    public az(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f139a = aVar;
        this.f140a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f140a != null) {
            this.f140a.mo47a(this.f139a);
        }
    }
}
