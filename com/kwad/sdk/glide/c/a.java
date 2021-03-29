package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final Set<i> f35096a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public boolean f35097b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35098c;

    public void a() {
        this.f35097b = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35096a)) {
            iVar.c();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void a(@NonNull i iVar) {
        this.f35096a.add(iVar);
        if (this.f35098c) {
            iVar.e();
        } else if (this.f35097b) {
            iVar.c();
        } else {
            iVar.d();
        }
    }

    public void b() {
        this.f35097b = false;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35096a)) {
            iVar.d();
        }
    }

    @Override // com.kwad.sdk.glide.c.h
    public void b(@NonNull i iVar) {
        this.f35096a.remove(iVar);
    }

    public void c() {
        this.f35098c = true;
        for (i iVar : com.kwad.sdk.glide.g.k.a(this.f35096a)) {
            iVar.e();
        }
    }
}
