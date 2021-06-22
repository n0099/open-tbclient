package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Set<i> f35872a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public boolean f35873b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35874c;

    public void a() {
        this.f35873b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35872a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f35872a.add(iVar);
        if (this.f35874c) {
            iVar.e();
        } else if (this.f35873b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    public void b() {
        this.f35873b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35872a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f35872a.remove(iVar);
    }

    public void c() {
        this.f35874c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35872a)) {
            iVar.e();
        }
    }
}
