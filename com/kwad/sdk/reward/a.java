package com.kwad.sdk.reward;

import android.app.Activity;
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
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f10824b;
    @NonNull
    public KsVideoPlayConfig c;
    @Nullable
    public JSONObject d;
    public int e;
    @NonNull
    public AdTemplate f;
    public Activity g;
    @NonNull
    public AdBaseFrameLayout h;
    @NonNull
    public com.kwad.sdk.reward.c.a i;
    @Nullable
    public com.kwad.sdk.core.download.b.b j;
    @NonNull
    public com.kwad.sdk.reward.b.b.a.a k;
    @Nullable
    public com.kwad.sdk.c.c l;
    @Nullable
    public com.kwad.sdk.c.b m;
    public boolean p;
    public boolean q;

    /* renamed from: a  reason: collision with root package name */
    public List<com.kwad.sdk.reward.a.a> f10823a = new ArrayList();
    public Set<com.kwad.sdk.reward.a.e> n = new HashSet();
    public Set<com.kwad.sdk.reward.a.d> o = new HashSet();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f10823a.clear();
        this.n.clear();
        this.i.h();
        if (this.j != null) {
            this.j.f();
        }
        if (this.l != null) {
            this.l.c();
        }
        if (this.m != null) {
            this.m.c();
        }
    }

    public void b() {
        for (com.kwad.sdk.reward.a.e eVar : this.n) {
            eVar.a();
        }
    }
}
