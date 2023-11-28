package com.xiaomi.push.service;

import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public final class al extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ax f893a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f894a;

    public al(String str, ax axVar, int i) {
        this.f894a = str;
        this.f893a = axVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo310a() {
        return this.f894a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f893a.a(this.a);
    }
}
