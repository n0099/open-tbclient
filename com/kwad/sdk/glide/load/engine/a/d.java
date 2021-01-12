package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes4.dex */
public class d implements a.InterfaceC1126a {

    /* renamed from: a  reason: collision with root package name */
    private final long f10160a;

    /* renamed from: b  reason: collision with root package name */
    private final a f10161b;

    /* loaded from: classes4.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f10160a = j;
        this.f10161b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC1126a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        File a2 = this.f10161b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f10160a);
        }
        return null;
    }
}
