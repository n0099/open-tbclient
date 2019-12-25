package com.xiaomi.push;

import android.content.Context;
/* loaded from: classes5.dex */
public class az implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.data.a f140a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.clientreport.processor.d f141a;

    public az(Context context, com.xiaomi.clientreport.data.a aVar, com.xiaomi.clientreport.processor.d dVar) {
        this.a = context;
        this.f140a = aVar;
        this.f141a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f141a != null) {
            this.f141a.mo38a(this.f140a);
        }
    }
}
