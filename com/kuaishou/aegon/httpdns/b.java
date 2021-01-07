package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class b implements a.InterfaceC1079a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8413a;

    private b(String str) {
        this.f8413a = str;
    }

    public static a.InterfaceC1079a ZX(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC1079a
    public Object get() {
        List nativeResolve;
        nativeResolve = HttpDnsResolver.nativeResolve(this.f8413a);
        return nativeResolve;
    }
}
