package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes18.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al.b f4796a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f107a = alVar;
        this.f4796a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f107a.a(this.f4796a);
    }
}
