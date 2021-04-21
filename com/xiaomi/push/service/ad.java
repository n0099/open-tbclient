package com.xiaomi.push.service;

import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public final class ad extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f41322a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ao f876a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f877a;

    public ad(String str, ao aoVar, int i) {
        this.f877a = str;
        this.f876a = aoVar;
        this.f41322a = i;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo169a() {
        return this.f877a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f876a.a(this.f41322a);
    }
}
