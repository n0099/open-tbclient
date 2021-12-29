package com.kwad.sdk.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f59450b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.reward.a.d f59451c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public KsVideoPlayConfig f59452d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f59453e;

    /* renamed from: f  reason: collision with root package name */
    public int f59454f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f59455g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public Activity f59456h;

    /* renamed from: i  reason: collision with root package name */
    public Context f59457i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public AdBaseFrameLayout f59458j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public com.kwad.sdk.reward.c.a f59459k;
    @Nullable
    public com.kwad.sdk.core.download.a.b l;
    @Nullable
    public com.kwad.sdk.widget.e m;
    @NonNull
    public RewardActionBarControl n;
    @Nullable
    public com.kwad.sdk.i.b o;
    @Nullable
    public com.kwad.sdk.i.a p;
    public boolean r;
    public boolean s;
    @Nullable
    public com.kwad.sdk.reward.b.a.a y;
    @Nullable
    public com.kwad.sdk.reward.b.kwai.a z;
    public List<com.kwad.sdk.reward.a.a> a = new ArrayList();
    public Set<com.kwad.sdk.reward.a.f> A = new HashSet();
    public Set<com.kwad.sdk.reward.a.e> q = new HashSet();
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public List<Integer> w = new ArrayList();
    public boolean x = false;
    public Handler B = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.core.report.a.a(this.f59455g, i2, this.f59458j.getTouchCoords(), this.f59453e);
        this.f59450b.a();
    }

    private boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void d() {
        for (com.kwad.sdk.reward.a.f fVar : this.A) {
            fVar.a();
        }
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.a.clear();
        this.A.clear();
        com.kwad.sdk.reward.c.a aVar = this.f59459k;
        if (aVar != null) {
            aVar.e();
        }
        com.kwad.sdk.core.download.a.b bVar = this.l;
        if (bVar != null) {
            bVar.i();
        }
        com.kwad.sdk.i.b bVar2 = this.o;
        if (bVar2 != null) {
            bVar2.f();
        }
        Set<com.kwad.sdk.reward.a.e> set = this.q;
        if (set != null) {
            set.clear();
        }
    }

    public void a(long j2, long j3, int i2) {
        for (com.kwad.sdk.reward.a.e eVar : this.q) {
            eVar.a(j2, j3, i2);
        }
    }

    public void a(Context context, final int i2, int i3) {
        com.kwad.sdk.core.download.a.a.a(new a.C2083a(context).a(this.f59455g).a(this.l).a(false).a(i3).a(new a.b() { // from class: com.kwad.sdk.reward.a.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                a.this.a(i2);
            }
        }));
    }

    @MainThread
    public void a(com.kwad.sdk.reward.a.f fVar) {
        this.A.add(fVar);
    }

    public void b() {
        if (c()) {
            d();
        } else {
            this.B.post(new Runnable() { // from class: com.kwad.sdk.reward.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b();
                }
            });
        }
    }

    @MainThread
    public void b(com.kwad.sdk.reward.a.f fVar) {
        this.A.remove(fVar);
    }
}
