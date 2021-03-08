package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements a.InterfaceC1085a {

    /* renamed from: a  reason: collision with root package name */
    private final String f5412a;

    private b(String str) {
        this.f5412a = str;
    }

    public static a.InterfaceC1085a aai(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC1085a
    public Object get() {
        List nativeResolve;
        nativeResolve = HttpDnsResolver.nativeResolve(this.f5412a);
        return nativeResolve;
    }
}
