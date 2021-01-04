package com.kwad.sdk.contentalliance.home.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    protected final List<AdTemplate> f8921a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    protected Handler f8922b = new Handler(Looper.getMainLooper());
    private List<d> c = new LinkedList();

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public int a(AdTemplate adTemplate) {
        return this.f8921a.indexOf(adTemplate);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a() {
        a(false, true, 4);
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public final void a(int i) {
        switch (i) {
            case 0:
                a(false, false, i);
                return;
            case 1:
            case 2:
            case 3:
                a(true, false, i);
                return;
            default:
                a(false, true, i);
                return;
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(int i, AdTemplate adTemplate) {
        if (i < 0 || this.f8921a.size() <= i) {
            return;
        }
        this.f8921a.set(i, adTemplate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void a(int i, String str) {
        for (d dVar : this.c) {
            dVar.a(i, str);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void a(d dVar) {
        this.c.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void a(boolean z, int i) {
        for (d dVar : this.c) {
            dVar.a(z, i);
        }
    }

    public abstract void a(boolean z, boolean z2, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @MainThread
    public void a(boolean z, boolean z2, int i, int i2) {
        for (d dVar : this.c) {
            dVar.a(z, z2, i, i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public List<AdTemplate> b() {
        return this.f8921a;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void b(d dVar) {
        this.c.remove(dVar);
    }

    public boolean c() {
        return this.f8921a == null || this.f8921a.isEmpty();
    }

    @Override // com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        this.f8922b.removeCallbacksAndMessages(null);
    }
}
