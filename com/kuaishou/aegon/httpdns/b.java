package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;
import java.util.List;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements a.InterfaceC0353a {

    /* renamed from: a  reason: collision with root package name */
    public final String f31621a;

    public b(String str) {
        this.f31621a = str;
    }

    public static a.InterfaceC0353a a(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC0353a
    public Object get() {
        List nativeResolve;
        nativeResolve = HttpDnsResolver.nativeResolve(this.f31621a);
        return nativeResolve;
    }
}
