package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.database.ContentObserver;
/* loaded from: classes3.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f14370a;

    /* renamed from: b  reason: collision with root package name */
    private int f14371b;
    private b qmq;

    public a(b bVar, int i, String str) {
        super(null);
        this.qmq = bVar;
        this.f14371b = i;
        this.f14370a = str;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.qmq != null) {
            this.qmq.a(this.f14371b, this.f14370a);
        }
    }
}
