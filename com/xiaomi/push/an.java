package com.xiaomi.push;

import com.xiaomi.push.al;
/* loaded from: classes7.dex */
public class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ al.b f41087a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ al f114a;

    public an(al alVar, al.b bVar) {
        this.f114a = alVar;
        this.f41087a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f114a.a(this.f41087a);
    }
}
