package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.database.ContentObserver;
/* loaded from: classes5.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f14668a;

    /* renamed from: b  reason: collision with root package name */
    private int f14669b;
    private b qgm;

    public a(b bVar, int i, String str) {
        super(null);
        this.qgm = bVar;
        this.f14669b = i;
        this.f14668a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.qgm != null) {
            this.qgm.a(this.f14669b, this.f14668a);
        }
    }
}
