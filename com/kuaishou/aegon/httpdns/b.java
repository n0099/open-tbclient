package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final /* synthetic */ class b implements a.InterfaceC1062a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8113a;

    private b(String str) {
        this.f8113a = str;
    }

    public static a.InterfaceC1062a YP(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC1062a
    public Object get() {
        List nativeResolve;
        nativeResolve = HttpDnsResolver.nativeResolve(this.f8113a);
        return nativeResolve;
    }
}
