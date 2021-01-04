package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f14667a;

    /* renamed from: b  reason: collision with root package name */
    private int f14668b;
    private b qeE;

    public a(b bVar, int i, String str) {
        super(null);
        this.qeE = bVar;
        this.f14668b = i;
        this.f14667a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.qeE != null) {
            this.qeE.a(this.f14668b, this.f14667a);
        }
    }
}
