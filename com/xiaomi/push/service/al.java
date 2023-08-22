package com.xiaomi.push.service;

import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public final class al extends aj.a {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ax f898a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f899a;

    public al(String str, ax axVar, int i) {
        this.f899a = str;
        this.f898a = axVar;
        this.a = i;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo300a() {
        return this.f899a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f898a.a(this.a);
    }
}
