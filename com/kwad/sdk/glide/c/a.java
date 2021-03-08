package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f6586a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f6586a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f6586a.add(iVar);
        if (this.c) {
            iVar.e();
        } else if (this.b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f6586a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f6586a.remove(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f6586a)) {
            iVar.e();
        }
    }
}
