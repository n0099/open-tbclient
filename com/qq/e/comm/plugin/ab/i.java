package com.qq.e.comm.plugin.ab;

import com.qq.e.comm.pi.WRI;
/* loaded from: classes15.dex */
public class i implements WRI {

    /* renamed from: a  reason: collision with root package name */
    private final b f11818a;

    public i(String str, long j) {
        this.f11818a = new b(str, j);
    }

    @Override // com.qq.e.comm.pi.WRI
    public void report(String str, int i) {
        this.f11818a.a(str, i);
    }
}
