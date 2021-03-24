package com.kwad.sdk.glide.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.RequestTracker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Set<com.kwad.sdk.glide.request.c> f35112a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.c> f35113b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f35114c;

    private boolean a(@Nullable com.kwad.sdk.glide.request.c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f35112a.remove(cVar);
        if (!this.f35113b.remove(cVar) && !remove) {
            z2 = false;
        }
        if (z2) {
            cVar.b();
            if (z) {
                cVar.h();
            }
        }
        return z2;
    }

    public void a() {
        this.f35114c = true;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35112a)) {
            if (cVar.c()) {
                cVar.b();
                this.f35113b.add(cVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.glide.request.c cVar) {
        this.f35112a.add(cVar);
        if (!this.f35114c) {
            cVar.a();
            return;
        }
        cVar.b();
        if (Log.isLoggable(RequestTracker.TAG, 2)) {
            Log.v(RequestTracker.TAG, "Paused, delaying request");
        }
        this.f35113b.add(cVar);
    }

    public void b() {
        this.f35114c = false;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35112a)) {
            if (!cVar.e_() && !cVar.c()) {
                cVar.a();
            }
        }
        this.f35113b.clear();
    }

    public boolean b(@Nullable com.kwad.sdk.glide.request.c cVar) {
        return a(cVar, true);
    }

    public void c() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35112a)) {
            a(cVar, false);
        }
        this.f35113b.clear();
    }

    public void d() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35112a)) {
            if (!cVar.e_() && !cVar.f()) {
                cVar.b();
                if (this.f35114c) {
                    this.f35113b.add(cVar);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f35112a.size() + ", isPaused=" + this.f35114c + "}";
    }
}
