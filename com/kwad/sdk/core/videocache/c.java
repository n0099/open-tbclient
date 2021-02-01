package com.kwad.sdk.core.videocache;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f9481a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.videocache.a.c f9482b;
    public final com.kwad.sdk.core.videocache.a.a c;
    public final com.kwad.sdk.core.videocache.d.b d;
    public final com.kwad.sdk.core.videocache.b.b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.b bVar, com.kwad.sdk.core.videocache.b.b bVar2) {
        this.f9481a = file;
        this.f9482b = cVar;
        this.c = aVar;
        this.d = bVar;
        this.e = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f9481a, this.f9482b.a(str));
    }
}
