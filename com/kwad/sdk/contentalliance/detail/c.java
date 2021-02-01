package com.kwad.sdk.contentalliance.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.a.e;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public h f8404a;
    public boolean g;
    public boolean h;
    public int i;
    @NonNull
    public AdTemplate j;
    public KsFragment k;
    public SlidePlayViewPager l;
    @Nullable
    public com.kwad.sdk.contentalliance.detail.video.b m;
    @Nullable
    public com.kwad.sdk.core.download.b.b o;
    @Nullable
    public com.kwad.sdk.c.c p;
    public com.kwad.sdk.contentalliance.detail.b.b q;
    @Nullable
    public com.kwad.sdk.live.slide.detail.a.a r;

    /* renamed from: b  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.a.a> f8405b = new LinkedList();
    public List<com.kwad.sdk.contentalliance.a.c> c = new ArrayList();
    public List<e> d = new ArrayList();
    public List<com.kwad.sdk.contentalliance.home.swipe.a> e = new LinkedList();
    public List<f.a> f = new ArrayList();
    public boolean n = false;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.m != null) {
            this.m.i();
        }
        if (this.r != null) {
            this.r.a();
        }
        if (this.o != null) {
            this.o.f();
        }
    }

    public void a(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        if (!com.kwad.sdk.core.response.b.c.B(this.j) || this.f8404a == null) {
            return;
        }
        this.f8404a.e.add(cVar);
    }

    public void b(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        if (!com.kwad.sdk.core.response.b.c.B(this.j) || this.f8404a == null) {
            return;
        }
        this.f8404a.e.remove(cVar);
    }

    public boolean b() {
        return this.g;
    }
}
