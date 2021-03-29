package com.kwad.sdk.contentalliance.home.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final List<AdTemplate> f32562a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Handler f32563b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public List<d> f32564c = new LinkedList();

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public int a(AdTemplate adTemplate) {
        return this.f32562a.indexOf(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a() {
        a(false, true, 4);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a(int i) {
        if (i == 0) {
            a(false, false, i);
        } else if (i == 1 || i == 2 || i == 3) {
            a(true, false, i);
        } else {
            a(false, true, i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(int i, AdTemplate adTemplate) {
        if (i < 0 || this.f32562a.size() <= i) {
            return;
        }
        this.f32562a.set(i, adTemplate);
    }

    @MainThread
    public void a(int i, String str) {
        for (d dVar : this.f32564c) {
            dVar.a(i, str);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(d dVar) {
        this.f32564c.add(dVar);
    }

    @MainThread
    public void a(boolean z, int i) {
        for (d dVar : this.f32564c) {
            dVar.a(z, i);
        }
    }

    public abstract void a(boolean z, boolean z2, int i);

    @MainThread
    public void a(boolean z, boolean z2, int i, int i2) {
        for (d dVar : this.f32564c) {
            dVar.a(z, z2, i, i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public List<AdTemplate> b() {
        return this.f32562a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void b(d dVar) {
        this.f32564c.remove(dVar);
    }

    public boolean c() {
        List<AdTemplate> list = this.f32562a;
        return list == null || list.isEmpty();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        this.f32563b.removeCallbacksAndMessages(null);
    }
}
