package com.xiaomi.push;

import com.xiaomi.push.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class an implements Runnable {
    final /* synthetic */ al.b a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ al f129a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar, al.b bVar) {
        this.f129a = alVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f129a.a(this.a);
    }
}
