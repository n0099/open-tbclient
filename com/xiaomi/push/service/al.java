package com.xiaomi.push.service;

import com.xiaomi.push.aj;
/* loaded from: classes8.dex */
public final class al extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ax f897a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f898a;

    public al(String str, ax axVar, int i) {
        this.f898a = str;
        this.f897a = axVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo221a() {
        return this.f898a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f897a.a(this.a);
    }
}
