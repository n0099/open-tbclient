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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public h f32151a;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32157g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32158h;
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
    public List<com.kwad.sdk.contentalliance.a.a> f32152b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.a.c> f32153c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<e> f32154d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<com.kwad.sdk.contentalliance.home.swipe.a> f32155e = new LinkedList();

    /* renamed from: f  reason: collision with root package name */
    public List<f.a> f32156f = new ArrayList();
    public boolean n = false;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        com.kwad.sdk.contentalliance.detail.video.b bVar = this.m;
        if (bVar != null) {
            bVar.i();
        }
        com.kwad.sdk.live.slide.detail.a.a aVar = this.r;
        if (aVar != null) {
            aVar.a();
        }
        com.kwad.sdk.core.download.b.b bVar2 = this.o;
        if (bVar2 != null) {
            bVar2.f();
        }
    }

    public void a(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        h hVar;
        if (!com.kwad.sdk.core.response.b.c.B(this.j) || (hVar = this.f32151a) == null) {
            return;
        }
        hVar.f32792e.add(cVar);
    }

    public void b(com.kwad.sdk.contentalliance.trends.view.c cVar) {
        h hVar;
        if (!com.kwad.sdk.core.response.b.c.B(this.j) || (hVar = this.f32151a) == null) {
            return;
        }
        hVar.f32792e.remove(cVar);
    }

    public boolean b() {
        return this.f32157g;
    }
}
