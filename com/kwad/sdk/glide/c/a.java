package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes5.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f10246a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f10247b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f10247b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f10246a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f10246a.add(iVar);
        if (this.c) {
            iVar.e();
        } else if (this.f10247b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f10247b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f10246a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f10246a.remove(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f10246a)) {
            iVar.e();
        }
    }
}
