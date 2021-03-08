package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes5.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al.b f8259a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f104a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f104a = alVar;
        this.f8259a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f104a.a(this.f8259a);
    }
}
