package com.kwad.sdk.glide.c;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.kwad.sdk.glide.request.c> f9953a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<com.kwad.sdk.glide.request.c> f9954b = new ArrayList();
    private boolean c;

    private boolean a(@Nullable com.kwad.sdk.glide.request.c cVar, boolean z) {
        boolean z2 = true;
        if (cVar != null) {
            boolean remove = this.f9953a.remove(cVar);
            if (!this.f9954b.remove(cVar) && !remove) {
                z2 = false;
            }
            if (z2) {
                cVar.b();
                if (z) {
                    cVar.h();
                }
            }
        }
        return z2;
    }

    public void a() {
        this.c = true;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f9953a)) {
            if (cVar.c()) {
                cVar.b();
                this.f9954b.add(cVar);
            }
        }
    }

    public void a(@NonNull com.kwad.sdk.glide.request.c cVar) {
        this.f9953a.add(cVar);
        if (!this.c) {
            cVar.a();
            return;
        }
        cVar.b();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f9954b.add(cVar);
    }

    public void b() {
        this.c = false;
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f9953a)) {
            if (!cVar.e_() && !cVar.c()) {
                cVar.a();
            }
        }
        this.f9954b.clear();
    }

    public boolean b(@Nullable com.kwad.sdk.glide.request.c cVar) {
        return a(cVar, true);
    }

    public void c() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f9953a)) {
            a(cVar, false);
        }
        this.f9954b.clear();
    }

    public void d() {
        for (com.kwad.sdk.glide.request.c cVar : com.kwad.sdk.glide.g.k.a(this.f9953a)) {
            if (!cVar.e_() && !cVar.f()) {
                cVar.b();
                if (this.c) {
                    this.f9954b.add(cVar);
                } else {
                    cVar.a();
                }
            }
        }
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f9953a.size() + ", isPaused=" + this.c + "}";
    }
}
