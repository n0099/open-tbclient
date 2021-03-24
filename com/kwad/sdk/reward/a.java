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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.e.b {
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.reward.a.b f36217b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public KsVideoPlayConfig f36218c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f36219d;

    /* renamed from: e  reason: collision with root package name */
    public int f36220e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36221f;

    /* renamed from: g  reason: collision with root package name */
    public Activity f36222g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public AdBaseFrameLayout f36223h;
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
    public List<com.kwad.sdk.reward.a.a> f36216a = new ArrayList();
    public Set<com.kwad.sdk.reward.a.e> n = new HashSet();
    public Set<com.kwad.sdk.reward.a.d> o = new HashSet();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f36216a.clear();
        this.n.clear();
        this.i.h();
        com.kwad.sdk.core.download.b.b bVar = this.j;
        if (bVar != null) {
            bVar.f();
        }
        com.kwad.sdk.c.c cVar = this.l;
        if (cVar != null) {
            cVar.c();
        }
        com.kwad.sdk.c.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.c();
        }
    }

    public void b() {
        for (com.kwad.sdk.reward.a.e eVar : this.n) {
            eVar.a();
        }
    }
}
