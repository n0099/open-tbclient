package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements a.InterfaceC1149a {

    /* renamed from: a  reason: collision with root package name */
    private final long f6724a;
    private final a b;

    /* loaded from: classes3.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f6724a = j;
        this.b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC1149a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        File a2 = this.b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f6724a);
        }
        return null;
    }
}
