package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.database.ContentObserver;
/* loaded from: classes4.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f14368a;

    /* renamed from: b  reason: collision with root package name */
    private int f14369b;
    private b qbM;

    public a(b bVar, int i, String str) {
        super(null);
        this.qbM = bVar;
        this.f14369b = i;
        this.f14368a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.qbM != null) {
            this.qbM.a(this.f14369b, this.f14368a);
        }
    }
}
