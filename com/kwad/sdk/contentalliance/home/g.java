package com.kwad.sdk.contentalliance.home;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.a.j;
import com.kwad.sdk.contentalliance.home.b.k;
import com.kwad.sdk.contentalliance.home.b.l;
import com.kwad.sdk.contentalliance.home.b.m;
import com.kwad.sdk.contentalliance.home.b.n;
import com.kwad.sdk.contentalliance.home.b.o;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.contentalliance.refreshview.KsAdHotRefreshView;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.contentalliance.tube.episode.TubeEpisodeDetailParam;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.report.ReportAction;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.feed.detail.FeedSlideParam;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.slide.LiveSlidHomeParam;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g extends KsFragment {
    public i A;

    /* renamed from: a  reason: collision with root package name */
    public KsContentPage.PageListener f33067a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.VideoListener f33068b;

    /* renamed from: c  reason: collision with root package name */
    public View f33069c;

    /* renamed from: d  reason: collision with root package name */
    public SwipeLayout f33070d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f33071e;

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayViewPager f33072f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdHotRefreshView f33073g;

    /* renamed from: h  reason: collision with root package name */
    public SceneImpl f33074h;
    public String j;
    public String k;
    public String l;
    public ProfileVideoDetailParam m;
    public LiveSlidHomeParam n;
    public TubeEpisodeDetailParam o;
    @Nullable
    public RelatedVideoDetailParam p;
    public FeedSlideParam q;
    public f r;
    public Presenter s;
    public com.kwad.sdk.core.i.a t;
    public com.kwad.sdk.contentalliance.home.a.d v;
    public String i = "unknown";
    public com.kwad.sdk.contentalliance.detail.b.b u = new com.kwad.sdk.contentalliance.detail.b.b();
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;

    public static g a(KsScene ksScene) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", ksScene);
        gVar.setArguments(bundle);
        return gVar;
    }

    private void a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable(LiveSlidHomeParam.KEY_LIVE_SLIDE_HOME_PARAM);
        if (serializable instanceof LiveSlidHomeParam) {
            this.n = (LiveSlidHomeParam) serializable;
        }
    }

    private void b(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM");
        if (serializable instanceof ProfileVideoDetailParam) {
            this.m = (ProfileVideoDetailParam) serializable;
        }
    }

    private void c(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM");
        if (serializable instanceof TubeEpisodeDetailParam) {
            this.o = (TubeEpisodeDetailParam) serializable;
        }
    }

    private void d(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM");
        if (serializable instanceof RelatedVideoDetailParam) {
            this.p = (RelatedVideoDetailParam) serializable;
        }
    }

    private void e(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_FEED_SLIDE_PARAM");
        if (serializable instanceof FeedSlideParam) {
            this.q = (FeedSlideParam) serializable;
        }
    }

    private boolean g() {
        URLPackage uRLPackage;
        long j;
        String str;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("key_AdScene");
        if (serializable instanceof KsScene) {
            this.j = arguments.getString("KEY_PushLINK");
            this.k = arguments.getString("KEY_TREND_LIST_DATA");
            this.l = arguments.getString("KEY_CURRENT_TREND");
            this.x = arguments.getBoolean("KEY_INSERTAD_ENABLE");
            this.f33074h = new SceneImpl((KsScene) serializable);
            b(arguments);
            a(arguments);
            c(arguments);
            d(arguments);
            e(arguments);
            if (TextUtils.isEmpty(this.k)) {
                if (this.m != null) {
                    uRLPackage = new URLPackage(String.valueOf(hashCode()), 4);
                    j = this.m.mAuthorId;
                    str = URLPackage.KEY_AUTHOR_ID;
                } else if (this.n != null) {
                    uRLPackage = new URLPackage(String.valueOf(hashCode()), 9);
                } else if (this.o != null) {
                    uRLPackage = new URLPackage(String.valueOf(hashCode()), 5);
                    j = this.o.mTubeId;
                    str = URLPackage.KEY_TUBE_ID;
                } else if (this.p == null) {
                    if (this.q == null) {
                        this.f33074h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 1));
                        this.y = com.kwad.sdk.core.config.c.N() || com.kwad.sdk.core.config.c.O();
                        if (com.kwad.sdk.entry.a.a() != null) {
                            this.i = "entry";
                            com.kwad.sdk.core.scene.a.a().a(this.i, com.kwad.sdk.entry.a.a().f35006a.f34358e, this.f33074h);
                        } else if (ag.a(this.j)) {
                            this.w = false;
                        } else {
                            this.i = "push";
                            com.kwad.sdk.core.scene.a.a().a(this.i, this.f33074h);
                        }
                        this.w = com.kwad.sdk.core.config.c.G();
                        this.z = com.kwad.sdk.core.config.c.I();
                        return true;
                    }
                    this.f33074h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 12));
                    this.w = com.kwad.sdk.core.config.c.G();
                    this.y = com.kwad.sdk.core.config.c.N() || com.kwad.sdk.core.config.c.O();
                    this.z = false;
                    return true;
                } else {
                    uRLPackage = new URLPackage(String.valueOf(hashCode()), 10);
                }
                uRLPackage.putParams(str, j);
            } else {
                uRLPackage = new URLPackage(String.valueOf(hashCode()), 2);
            }
            this.f33074h.setUrlPackage(uRLPackage);
            this.w = false;
            this.y = false;
            this.z = false;
            return true;
        }
        return false;
    }

    public void a() {
        SlidePlayViewPager slidePlayViewPager;
        if (this.A == null || (slidePlayViewPager = this.f33072f) == null || slidePlayViewPager.getSourceType() != 0) {
            return;
        }
        if (!com.kwad.sdk.core.config.c.H()) {
            com.kwad.sdk.core.d.a.b("HomeFragment", "tryToRefresh is disable");
        } else if (this.f33073g.a()) {
            com.kwad.sdk.core.d.a.a("HomeFragment", "tryToRefresh is mRefreshLayout isRefreshViewShowing");
        } else {
            this.A.a(2);
        }
    }

    public void a(KsContentPage.PageListener pageListener) {
        this.f33067a = pageListener;
    }

    public void a(KsContentPage.VideoListener videoListener) {
        this.f33068b = videoListener;
    }

    public void a(com.kwad.sdk.contentalliance.home.a.d dVar) {
        this.v = dVar;
    }

    public void a(List<KsContentPage.SubShowItem> list) {
        this.u.a(list);
    }

    public boolean b() {
        com.kwad.sdk.contentalliance.home.swipe.c cVar;
        if (this.f33072f.getSourceType() == 0 || (cVar = this.f33071e) == null || !cVar.b()) {
            return false;
        }
        this.f33071e.c();
        return true;
    }

    public SlidePlayViewPager c() {
        return this.f33072f;
    }

    public SceneImpl d() {
        return this.f33074h;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f e() {
        int i;
        TrendInfo trendInfo;
        com.kwad.sdk.contentalliance.home.a.d dVar;
        f fVar = new f();
        fVar.f33059a = this;
        fVar.f33061c = this.f33072f;
        fVar.f33062d = this.u;
        SceneImpl sceneImpl = this.f33074h;
        fVar.f33063e = sceneImpl;
        fVar.l = this.w;
        fVar.m = this.z;
        ProfileVideoDetailParam profileVideoDetailParam = this.m;
        if (profileVideoDetailParam != null) {
            fVar.f33060b = new j(new com.kwad.sdk.contentalliance.home.a.g(sceneImpl, profileVideoDetailParam));
            fVar.k = false;
            i = this.m.mSelectedPosition;
        } else {
            LiveSlidHomeParam liveSlidHomeParam = this.n;
            if (liveSlidHomeParam == null) {
                if (TextUtils.isEmpty(this.k)) {
                    TubeEpisodeDetailParam tubeEpisodeDetailParam = this.o;
                    if (tubeEpisodeDetailParam != null) {
                        fVar.f33060b = new j(new com.kwad.sdk.contentalliance.tube.a(this.f33074h, tubeEpisodeDetailParam));
                        fVar.k = false;
                        i = this.o.mSelectedPosition;
                    } else {
                        RelatedVideoDetailParam relatedVideoDetailParam = this.p;
                        if (relatedVideoDetailParam != null) {
                            fVar.f33060b = new j(new com.kwad.sdk.contentalliance.home.a.h(this.f33074h, relatedVideoDetailParam));
                            fVar.k = false;
                            i = this.p.mSelectedPosition;
                        } else if (this.q != null) {
                            fVar.f33060b = new j(new com.kwad.sdk.contentalliance.home.a.c(this.f33074h));
                            fVar.k = true;
                            i = this.q.mSelectedPosition;
                        } else {
                            com.kwad.sdk.contentalliance.home.a.c cVar = new com.kwad.sdk.contentalliance.home.a.c(this.f33074h);
                            cVar.a(this.j);
                            cVar.a(this.x);
                            fVar.f33060b = new j(cVar);
                            fVar.k = true;
                            fVar.f33065g = this.j;
                            com.kwad.sdk.entry.model.a a2 = com.kwad.sdk.entry.a.a();
                            if (a2 != null) {
                                i = a2.f35007b;
                            } else {
                                fVar.j = 0;
                            }
                        }
                    }
                } else {
                    TrendInfo trendInfo2 = null;
                    if (!TextUtils.isEmpty(this.l)) {
                        try {
                            trendInfo = new TrendInfo();
                            try {
                                trendInfo.parseJson(new JSONObject(this.l));
                            } catch (Exception e2) {
                                e = e2;
                                fVar.i = null;
                                com.kwad.sdk.core.d.a.a(e);
                                trendInfo2 = trendInfo;
                                com.kwad.sdk.contentalliance.trends.a aVar = new com.kwad.sdk.contentalliance.trends.a(this.f33074h);
                                aVar.a(this.k);
                                aVar.a(trendInfo2);
                                fVar.f33060b = new j(aVar);
                                fVar.k = false;
                                fVar.j = 0;
                                fVar.f33066h = TrendInfo.asList(this.k);
                                fVar.i = trendInfo2;
                                this.A = fVar.f33060b;
                                com.kwad.sdk.contentalliance.home.swipe.c cVar2 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f33069c.getContext());
                                this.f33071e = cVar2;
                                cVar2.a(this.w);
                                this.f33070d.setTouchDetector(this.f33071e);
                                com.kwad.sdk.core.i.a aVar2 = new com.kwad.sdk.core.i.a(this, this.f33069c, 70);
                                this.t = aVar2;
                                aVar2.a();
                                final h hVar = new h();
                                hVar.f33078a = this.t;
                                hVar.f33079b = this.f33067a;
                                hVar.f33080c = this.f33068b;
                                hVar.f33081d = this.n;
                                hVar.f33084g = this.f33071e;
                                hVar.f33085h = fVar.f33060b;
                                hVar.i = this.w;
                                hVar.j = this.y;
                                hVar.k = this.f33074h;
                                fVar.f33064f = hVar;
                                fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c() { // from class: com.kwad.sdk.contentalliance.home.g.2
                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void a() {
                                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar.f33082e) {
                                            cVar3.a();
                                        }
                                    }

                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void a(View view, TrendInfo trendInfo3, int i2) {
                                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar.f33082e) {
                                            cVar3.a(view, trendInfo3, i2);
                                        }
                                    }

                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void b() {
                                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar.f33082e) {
                                            cVar3.b();
                                        }
                                    }
                                });
                                dVar = this.v;
                                if (dVar != null) {
                                }
                                return fVar;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            trendInfo = null;
                        }
                        trendInfo2 = trendInfo;
                    }
                    com.kwad.sdk.contentalliance.trends.a aVar3 = new com.kwad.sdk.contentalliance.trends.a(this.f33074h);
                    aVar3.a(this.k);
                    aVar3.a(trendInfo2);
                    fVar.f33060b = new j(aVar3);
                    fVar.k = false;
                    fVar.j = 0;
                    fVar.f33066h = TrendInfo.asList(this.k);
                    fVar.i = trendInfo2;
                }
                this.A = fVar.f33060b;
                com.kwad.sdk.contentalliance.home.swipe.c cVar22 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f33069c.getContext());
                this.f33071e = cVar22;
                cVar22.a(this.w);
                this.f33070d.setTouchDetector(this.f33071e);
                com.kwad.sdk.core.i.a aVar22 = new com.kwad.sdk.core.i.a(this, this.f33069c, 70);
                this.t = aVar22;
                aVar22.a();
                final h hVar2 = new h();
                hVar2.f33078a = this.t;
                hVar2.f33079b = this.f33067a;
                hVar2.f33080c = this.f33068b;
                hVar2.f33081d = this.n;
                hVar2.f33084g = this.f33071e;
                hVar2.f33085h = fVar.f33060b;
                hVar2.i = this.w;
                hVar2.j = this.y;
                hVar2.k = this.f33074h;
                fVar.f33064f = hVar2;
                fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c() { // from class: com.kwad.sdk.contentalliance.home.g.2
                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                    public void a() {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar2.f33082e) {
                            cVar3.a();
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                    public void a(View view, TrendInfo trendInfo3, int i2) {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar2.f33082e) {
                            cVar3.a(view, trendInfo3, i2);
                        }
                    }

                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                    public void b() {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar2.f33082e) {
                            cVar3.b();
                        }
                    }
                });
                dVar = this.v;
                if (dVar != null) {
                    fVar.f33060b.a(dVar);
                }
                return fVar;
            }
            fVar.f33060b = new j(new com.kwad.sdk.contentalliance.home.a.f(sceneImpl, liveSlidHomeParam.mIsFromLiveSquare));
            fVar.k = false;
            i = this.n.mSelectedPosition;
        }
        fVar.j = i;
        this.A = fVar.f33060b;
        com.kwad.sdk.contentalliance.home.swipe.c cVar222 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f33069c.getContext());
        this.f33071e = cVar222;
        cVar222.a(this.w);
        this.f33070d.setTouchDetector(this.f33071e);
        com.kwad.sdk.core.i.a aVar222 = new com.kwad.sdk.core.i.a(this, this.f33069c, 70);
        this.t = aVar222;
        aVar222.a();
        final h hVar22 = new h();
        hVar22.f33078a = this.t;
        hVar22.f33079b = this.f33067a;
        hVar22.f33080c = this.f33068b;
        hVar22.f33081d = this.n;
        hVar22.f33084g = this.f33071e;
        hVar22.f33085h = fVar.f33060b;
        hVar22.i = this.w;
        hVar22.j = this.y;
        hVar22.k = this.f33074h;
        fVar.f33064f = hVar22;
        fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c() { // from class: com.kwad.sdk.contentalliance.home.g.2
            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar22.f33082e) {
                    cVar3.a();
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void a(View view, TrendInfo trendInfo3, int i2) {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar22.f33082e) {
                    cVar3.a(view, trendInfo3, i2);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : hVar22.f33082e) {
                    cVar3.b();
                }
            }
        });
        dVar = this.v;
        if (dVar != null) {
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter f() {
        n nVar;
        Presenter eVar;
        Presenter presenter = new Presenter();
        if (2 == this.f33074h.getPageScene()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.b());
            eVar = new com.kwad.sdk.contentalliance.home.b.f();
        } else if (4 == this.f33074h.getPageScene()) {
            presenter.a((Presenter) new l());
            eVar = new com.kwad.sdk.contentalliance.home.b.f();
        } else if (5 != this.f33074h.getPageScene()) {
            if (9 == this.f33074h.getPageScene()) {
                presenter.a((Presenter) new k());
                if (this.n.mIsFromLiveSquare) {
                    eVar = new com.kwad.sdk.contentalliance.home.b.f();
                }
            } else if (10 == this.f33074h.getPageScene()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.h());
                eVar = new com.kwad.sdk.contentalliance.home.b.f();
            } else if (12 == this.f33074h.getPageScene()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.d());
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                if (com.kwad.sdk.core.config.c.A()) {
                    eVar = new com.kwad.sdk.contentalliance.home.b.e();
                }
            } else if ("push".equals(this.i)) {
                if (this.z) {
                    nVar = new n();
                    presenter.a((Presenter) nVar);
                }
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                if (com.kwad.sdk.core.config.c.A()) {
                    eVar = new com.kwad.sdk.contentalliance.home.b.e();
                }
            } else {
                if ("entry".equals(this.i)) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.a());
                    if (this.z) {
                        nVar = new n();
                        presenter.a((Presenter) nVar);
                    }
                }
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                if (com.kwad.sdk.core.config.c.A()) {
                }
            }
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.i());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.j());
            if (com.kwad.sdk.core.config.c.aj() && (ae.c(getContext()) || (ae.a(getContext()) && this.w))) {
                presenter.a((Presenter) new o());
            }
            if (com.kwad.sdk.core.config.c.J() && NetworkMonitor.a().b()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.g());
            }
            presenter.a((Presenter) new m());
            if (com.kwad.sdk.core.config.c.ac()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.b());
            }
            return presenter;
        } else {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.d());
            eVar = new com.kwad.sdk.contentalliance.home.b.f();
        }
        presenter.a(eVar);
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.c());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.i());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.j());
        if (com.kwad.sdk.core.config.c.aj()) {
            presenter.a((Presenter) new o());
        }
        if (com.kwad.sdk.core.config.c.J()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.g());
        }
        presenter.a((Presenter) new m());
        if (com.kwad.sdk.core.config.c.ac()) {
        }
        return presenter;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        com.kwad.sdk.core.d.a.b("HomeFragment", "onCreateView");
        if (this.f33069c == null) {
            View inflate = layoutInflater.inflate(R.layout.ksad_content_alliance_home_fragment, viewGroup, false);
            this.f33069c = inflate;
            this.f33070d = (SwipeLayout) inflate.findViewById(R.id.ksad_swipe);
            this.f33072f = (SlidePlayViewPager) this.f33069c.findViewById(R.id.ksad_slide_play_view_pager);
            this.f33073g = (KsAdHotRefreshView) this.f33069c.findViewById(R.id.ksad_refresh_layout);
            if (com.kwad.sdk.utils.d.a(getActivity())) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f33073g.getLayoutParams();
                marginLayoutParams.topMargin = ao.a((Context) getActivity());
                this.f33073g.setLayoutParams(marginLayoutParams);
            }
        }
        this.f33069c.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.g.1
            @Override // java.lang.Runnable
            public void run() {
                ReportAction.b.a(g.this.f33069c.getWidth());
                ReportAction.b.b(g.this.f33069c.getHeight());
            }
        });
        return this.f33069c;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_DESTROY);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        com.kwad.sdk.core.d.a.b("HomeFragment", "onDestroyView");
        com.kwad.sdk.core.report.g.c().a();
        com.kwad.sdk.core.video.a.a.a.c().a();
        f fVar = this.r;
        if (fVar != null) {
            fVar.a();
        }
        Presenter presenter = this.s;
        if (presenter != null) {
            presenter.j();
        }
        this.f33070d.setTouchDetector(null);
        this.f33070d.a();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.kwad.sdk.core.d.a.b("HomeFragment", "onHiddenChanged hidden: " + z);
        com.kwad.sdk.core.i.a aVar = this.t;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_PAUSE);
        com.kwad.sdk.core.i.a aVar = this.t;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_RESUME);
        com.kwad.sdk.core.i.a aVar = this.t;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!g()) {
            com.kwad.sdk.core.d.a.d("HomeFragment", "handleHomeParam fail");
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        this.r = e();
        Presenter f2 = f();
        this.s = f2;
        f2.a(this.f33069c);
        this.s.a(this.r);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.kwad.sdk.core.d.a.b("HomeFragment", "setUserVisibleHint isVisibleToUser: " + z);
        com.kwad.sdk.core.i.a aVar = this.t;
        if (aVar != null) {
            aVar.a(z);
        }
    }
}
