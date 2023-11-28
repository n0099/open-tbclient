package com.xiaomi.push;

import com.xiaomi.push.am;
/* loaded from: classes10.dex */
public class ao implements Runnable {
    public final /* synthetic */ am.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ am f104a;

    public ao(am amVar, am.b bVar) {
        this.f104a = amVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f104a.a(this.a);
    }
}
