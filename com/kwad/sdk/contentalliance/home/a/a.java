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
    public final List<AdTemplate> f33143a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Handler f33144b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public List<d> f33145c = new LinkedList();

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public int a(AdTemplate adTemplate) {
        return this.f33143a.indexOf(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a() {
        a(false, true, 4);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a(int i2) {
        if (i2 == 0) {
            a(false, false, i2);
        } else if (i2 == 1 || i2 == 2 || i2 == 3) {
            a(true, false, i2);
        } else {
            a(false, true, i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(int i2, AdTemplate adTemplate) {
        if (i2 < 0 || this.f33143a.size() <= i2) {
            return;
        }
        this.f33143a.set(i2, adTemplate);
    }

    @MainThread
    public void a(int i2, String str) {
        for (d dVar : this.f33145c) {
            dVar.a(i2, str);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(d dVar) {
        this.f33145c.add(dVar);
    }

    @MainThread
    public void a(boolean z, int i2) {
        for (d dVar : this.f33145c) {
            dVar.a(z, i2);
        }
    }

    public abstract void a(boolean z, boolean z2, int i2);

    @MainThread
    public void a(boolean z, boolean z2, int i2, int i3) {
        for (d dVar : this.f33145c) {
            dVar.a(z, z2, i2, i3);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public List<AdTemplate> b() {
        return this.f33143a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void b(d dVar) {
        this.f33145c.remove(dVar);
    }

    public boolean c() {
        List<AdTemplate> list = this.f33143a;
        return list == null || list.isEmpty();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        this.f33144b.removeCallbacksAndMessages(null);
    }
}
