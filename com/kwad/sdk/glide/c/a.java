package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f9948a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f9949b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f9949b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f9948a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f9948a.add(iVar);
        if (this.c) {
            iVar.e();
        } else if (this.f9949b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f9949b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f9948a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f9948a.remove(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f9948a)) {
            iVar.e();
        }
    }
}
