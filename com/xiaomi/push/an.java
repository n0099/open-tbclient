package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes6.dex */
class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al.b f13859a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f183a = alVar;
        this.f13859a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f183a.a(this.f13859a);
    }
}
