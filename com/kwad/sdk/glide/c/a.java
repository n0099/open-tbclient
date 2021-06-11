package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Set<i> f35774a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public boolean f35775b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35776c;

    public void a() {
        this.f35775b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35774a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f35774a.add(iVar);
        if (this.f35776c) {
            iVar.e();
        } else if (this.f35775b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    public void b() {
        this.f35775b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35774a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f35774a.remove(iVar);
    }

    public void c() {
        this.f35776c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35774a)) {
            iVar.e();
        }
    }
}
