package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes9.dex */
class an implements Runnable {
    final /* synthetic */ al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f106a = alVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f106a.a(this.a);
    }
}
