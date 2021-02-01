package com.kwad.sdk.contentalliance.home;

import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.b.f;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.trends.a.b.c;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public KsFragment f8737a;

    /* renamed from: b  reason: collision with root package name */
    public i f8738b;
    public SlidePlayViewPager c;
    public com.kwad.sdk.contentalliance.detail.b.b d;
    public SceneImpl e;
    public h f;
    public String g;
    public List<TrendInfo> h;
    public TrendInfo i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public List<c.a> n = new ArrayList();
    public List<com.kwad.sdk.contentalliance.trends.view.c> o = new ArrayList();
    public List<f.a> p = new ArrayList();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        if (this.f != null) {
            this.f.a();
        }
    }
}
