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
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.e.b {
    @NonNull
    public com.kwad.sdk.reward.a.b b;
    @NonNull
    public com.kwad.sdk.reward.a.d c;
    @NonNull
    public KsVideoPlayConfig d;
    @Nullable
    public JSONObject e;
    public int f;
    @NonNull
    public AdTemplate g;
    @Deprecated
    public Activity h;
    public Context i;
    @NonNull
    public AdBaseFrameLayout j;
    @NonNull
    public com.kwad.sdk.reward.c.a k;
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
    public void a(int i) {
        com.kwad.sdk.core.report.a.a(this.g, i, this.j.getTouchCoords(), this.e);
        this.b.a();
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
        com.kwad.sdk.reward.c.a aVar = this.k;
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

    public void a(long j, long j2, int i) {
        for (com.kwad.sdk.reward.a.e eVar : this.q) {
            eVar.a(j, j2, i);
        }
    }

    public void a(Context context, final int i, int i2) {
        com.kwad.sdk.core.download.a.a.a(new a.C0304a(context).a(this.g).a(this.l).a(false).a(i2).a(new a.b() { // from class: com.kwad.sdk.reward.a.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                a.this.a(i);
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
