package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes6.dex */
public class d implements a.InterfaceC0417a {

    /* renamed from: a  reason: collision with root package name */
    public final long f35423a;

    /* renamed from: b  reason: collision with root package name */
    public final a f35424b;

    /* loaded from: classes6.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f35423a = j;
        this.f35424b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC0417a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        File a2 = this.f35424b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f35423a);
        }
        return null;
    }
}
