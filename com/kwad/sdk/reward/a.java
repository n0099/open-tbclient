package com.kwad.sdk.reward;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f33491b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f33492c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f33493d;

    /* renamed from: e  reason: collision with root package name */
    public int f33494e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33495f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f33496g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public AdBaseFrameLayout f33497h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f33498i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
    @NonNull
    public com.kwad.sdk.reward.b.b.a.a k;
    @Nullable
    public com.kwad.sdk.c.c l;
    @Nullable
    public com.kwad.sdk.c.a m;
    @Nullable
    public com.kwad.sdk.c.b n;
    public boolean q;
    public boolean r;

    /* renamed from: a  reason: collision with root package name */
    public List<com.kwad.sdk.reward.a.a> f33490a = new ArrayList();
    public Set<com.kwad.sdk.reward.a.f> u = new HashSet();
    public Set<com.kwad.sdk.reward.a.e> o = new HashSet();
    public Set<com.kwad.sdk.reward.a.d> p = new HashSet();
    public boolean s = false;
    public Handler v = new Handler(Looper.getMainLooper());
    public boolean t = false;

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void d() {
        for (com.kwad.sdk.reward.a.f fVar : this.u) {
            fVar.a();
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f33490a.clear();
        this.u.clear();
        this.f33498i.h();
        com.kwad.sdk.core.download.b.b bVar = this.j;
        if (bVar != null) {
            bVar.g();
        }
        com.kwad.sdk.c.c cVar = this.l;
        if (cVar != null) {
            cVar.f();
        }
        com.kwad.sdk.c.b bVar2 = this.n;
        if (bVar2 != null) {
            bVar2.f();
        }
        Set<com.kwad.sdk.reward.a.d> set = this.p;
        if (set != null) {
            set.clear();
        }
    }

    public void a(long j, long j2, int i2) {
        for (com.kwad.sdk.reward.a.d dVar : this.p) {
            dVar.a(j, j2, i2);
        }
    }

    @MainThread
    public void a(com.kwad.sdk.reward.a.f fVar) {
        this.u.add(fVar);
    }

    public void b() {
        if (c()) {
            d();
            return;
        }
        Activity activity = this.f33496g;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.reward.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b();
                }
            });
        } else {
            this.v.post(new Runnable() { // from class: com.kwad.sdk.reward.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b();
                }
            });
        }
    }

    @MainThread
    public void b(com.kwad.sdk.reward.a.f fVar) {
        this.u.remove(fVar);
    }
}
