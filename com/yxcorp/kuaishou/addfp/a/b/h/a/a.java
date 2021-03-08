package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.database.ContentObserver;
/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f8613a;
    private int b;
    private b qmS;

    public a(b bVar, int i, String str) {
        super(null);
        this.qmS = bVar;
        this.b = i;
        this.f8613a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.qmS != null) {
            this.qmS.a(this.b, this.f8613a);
        }
    }
}
