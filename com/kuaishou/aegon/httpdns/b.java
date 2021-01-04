package com.kuaishou.aegon.httpdns;

import com.kuaishou.aegon.a.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class b implements a.InterfaceC1038a {

    /* renamed from: a  reason: collision with root package name */
    private final String f8412a;

    private b(String str) {
        this.f8412a = str;
    }

    public static a.InterfaceC1038a ZW(String str) {
        return new b(str);
    }

    @Override // com.kuaishou.aegon.a.a.InterfaceC1038a
    public Object get() {
        List nativeResolve;
        nativeResolve = HttpDnsResolver.nativeResolve(this.f8412a);
        return nativeResolve;
    }
}
