package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes5.dex */
public class d implements a.InterfaceC1102a {

    /* renamed from: a  reason: collision with root package name */
    private final long f10459a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10460b;

    /* loaded from: classes5.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f10459a = j;
        this.f10460b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC1102a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        File a2 = this.f10460b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f10459a);
        }
        return null;
    }
}
