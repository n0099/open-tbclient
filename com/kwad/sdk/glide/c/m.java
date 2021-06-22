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
/* loaded from: classes7.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final Set<com.kwad.sdk.glide.request.c> f35890a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.request.c> f35891b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f35892c;

    private boolean a(@Nullable com.kwad.sdk.glide.request.c cVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f35890a.remove(cVar);
        if (!this.f35891b.remove(cVar) && !remove) {
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
        this.f35892c = true;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35890a)) {
            if (cVar.c()) {
                cVar.b();
                this.f35891b.add(cVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.glide.request.c cVar) {
        this.f35890a.add(cVar);
        if (!this.f35892c) {
            cVar.a();
            return;
        }
        cVar.b();
        if (Log.isLoggable(RequestTracker.TAG, 2)) {
            Log.v(RequestTracker.TAG, "Paused, delaying request");
        }
        this.f35891b.add(cVar);
    }

    public void b() {
        this.f35892c = false;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35890a)) {
            if (!cVar.e_() && !cVar.c()) {
                cVar.a();
            }
        }
        this.f35891b.clear();
    }

    public boolean b(@Nullable com.kwad.sdk.glide.request.c cVar) {
        return a(cVar, true);
    }

    public void c() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35890a)) {
            a(cVar, false);
        }
        this.f35891b.clear();
    }

    public void d() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f35890a)) {
            if (!cVar.e_() && !cVar.f()) {
                cVar.b();
                if (this.f35892c) {
                    this.f35891b.add(cVar);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f35890a.size() + ", isPaused=" + this.f35892c + "}";
    }
}
