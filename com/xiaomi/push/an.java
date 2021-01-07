package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes6.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al.b f14159a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f184a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f184a = alVar;
        this.f14159a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f184a.a(this.f14159a);
    }
}
