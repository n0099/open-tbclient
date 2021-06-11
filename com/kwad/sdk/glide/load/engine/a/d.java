package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.a;
import java.io.File;
/* loaded from: classes7.dex */
public class d implements a.InterfaceC0417a {

    /* renamed from: a  reason: collision with root package name */
    public final long f36107a;

    /* renamed from: b  reason: collision with root package name */
    public final a f36108b;

    /* loaded from: classes7.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f36107a = j;
        this.f36108b = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.a.InterfaceC0417a
    public com.kwad.sdk.glide.load.engine.a.a a() {
        File a2 = this.f36108b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f36107a);
        }
        return null;
    }
}
