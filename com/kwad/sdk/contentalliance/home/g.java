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
/* loaded from: classes3.dex */
public class g extends KsFragment {
    private i A;

    /* renamed from: a  reason: collision with root package name */
    public KsContentPage.PageListener f5823a;
    public KsContentPage.VideoListener b;
    private View c;
    private SwipeLayout d;
    private com.kwad.sdk.contentalliance.home.swipe.c e;
    private SlidePlayViewPager f;
    private KsAdHotRefreshView g;
    private SceneImpl h;
    private String j;
    private String k;
    private String l;
    private ProfileVideoDetailParam m;
    private LiveSlidHomeParam n;
    private TubeEpisodeDetailParam o;
    @Nullable
    private RelatedVideoDetailParam p;
    private FeedSlideParam q;
    private f r;
    private Presenter s;
    private com.kwad.sdk.core.i.a t;
    private com.kwad.sdk.contentalliance.home.a.d v;
    private String i = "unknown";
    private com.kwad.sdk.contentalliance.detail.b.b u = new com.kwad.sdk.contentalliance.detail.b.b();
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    private g() {
    }

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
            this.h = new SceneImpl((KsScene) serializable);
            b(arguments);
            a(arguments);
            c(arguments);
            d(arguments);
            e(arguments);
            if (!TextUtils.isEmpty(this.k)) {
                this.h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 2));
                this.w = false;
                this.y = false;
                this.z = false;
            } else if (this.m != null) {
                URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 4);
                uRLPackage.putParams(URLPackage.KEY_AUTHOR_ID, this.m.mAuthorId);
                this.h.setUrlPackage(uRLPackage);
                this.w = false;
                this.y = false;
                this.z = false;
            } else if (this.n != null) {
                this.h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 9));
                this.w = false;
                this.y = false;
                this.z = false;
            } else if (this.o != null) {
                URLPackage uRLPackage2 = new URLPackage(String.valueOf(hashCode()), 5);
                uRLPackage2.putParams(URLPackage.KEY_TUBE_ID, this.o.mTubeId);
                this.h.setUrlPackage(uRLPackage2);
                this.w = false;
                this.y = false;
                this.z = false;
            } else if (this.p != null) {
                this.h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 10));
                this.w = false;
                this.y = false;
                this.z = false;
            } else if (this.q != null) {
                this.h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 12));
                this.w = com.kwad.sdk.core.config.c.G();
                this.y = com.kwad.sdk.core.config.c.N() || com.kwad.sdk.core.config.c.O();
                this.z = false;
            } else {
                this.h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 1));
                this.y = com.kwad.sdk.core.config.c.N() || com.kwad.sdk.core.config.c.O();
                if (com.kwad.sdk.entry.a.a() != null) {
                    this.i = "entry";
                    com.kwad.sdk.core.scene.a.a().a(this.i, com.kwad.sdk.entry.a.a().f6469a.e, this.h);
                    this.w = com.kwad.sdk.core.config.c.G();
                    this.z = com.kwad.sdk.core.config.c.I();
                } else if (ag.a(this.j)) {
                    this.w = false;
                    this.z = false;
                } else {
                    this.i = "push";
                    com.kwad.sdk.core.scene.a.a().a(this.i, this.h);
                    this.w = com.kwad.sdk.core.config.c.G();
                    this.z = com.kwad.sdk.core.config.c.I();
                }
            }
            return true;
        }
        return false;
    }

    public void a() {
        if (this.A == null || this.f == null || this.f.getSourceType() != 0) {
            return;
        }
        if (!com.kwad.sdk.core.config.c.H()) {
            com.kwad.sdk.core.d.a.b("HomeFragment", "tryToRefresh is disable");
        } else if (this.g.a()) {
            com.kwad.sdk.core.d.a.a("HomeFragment", "tryToRefresh is mRefreshLayout isRefreshViewShowing");
        } else {
            this.A.a(2);
        }
    }

    public void a(KsContentPage.PageListener pageListener) {
        this.f5823a = pageListener;
    }

    public void a(KsContentPage.VideoListener videoListener) {
        this.b = videoListener;
    }

    public void a(com.kwad.sdk.contentalliance.home.a.d dVar) {
        this.v = dVar;
    }

    public void a(List<KsContentPage.SubShowItem> list) {
        this.u.a(list);
    }

    public boolean b() {
        if (this.f.getSourceType() == 0 || this.e == null || !this.e.b()) {
            return false;
        }
        this.e.c();
        return true;
    }

    public SlidePlayViewPager c() {
        return this.f;
    }

    public SceneImpl d() {
        return this.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected f e() {
        TrendInfo trendInfo;
        f fVar = new f();
        fVar.f5822a = this;
        fVar.c = this.f;
        fVar.d = this.u;
        fVar.e = this.h;
        fVar.l = this.w;
        fVar.m = this.z;
        if (this.m != null) {
            fVar.b = new j(new com.kwad.sdk.contentalliance.home.a.g(this.h, this.m));
            fVar.k = false;
            fVar.j = this.m.mSelectedPosition;
        } else if (this.n != null) {
            fVar.b = new j(new com.kwad.sdk.contentalliance.home.a.f(this.h, this.n.mIsFromLiveSquare));
            fVar.k = false;
            fVar.j = this.n.mSelectedPosition;
        } else if (!TextUtils.isEmpty(this.k)) {
            if (TextUtils.isEmpty(this.l)) {
                trendInfo = null;
            } else {
                try {
                    trendInfo = new TrendInfo();
                } catch (Exception e) {
                    e = e;
                    trendInfo = null;
                }
                try {
                    trendInfo.parseJson(new JSONObject(this.l));
                } catch (Exception e2) {
                    e = e2;
                    fVar.i = null;
                    com.kwad.sdk.core.d.a.a(e);
                    com.kwad.sdk.contentalliance.trends.a aVar = new com.kwad.sdk.contentalliance.trends.a(this.h);
                    aVar.a(this.k);
                    aVar.a(trendInfo);
                    fVar.b = new j(aVar);
                    fVar.k = false;
                    fVar.j = 0;
                    fVar.h = TrendInfo.asList(this.k);
                    fVar.i = trendInfo;
                    this.A = fVar.b;
                    this.e = new com.kwad.sdk.contentalliance.home.swipe.c(this.c.getContext());
                    this.e.a(this.w);
                    this.d.setTouchDetector(this.e);
                    this.t = new com.kwad.sdk.core.i.a(this, this.c, 70);
                    this.t.a();
                    final h hVar = new h();
                    hVar.f5826a = this.t;
                    hVar.b = this.f5823a;
                    hVar.c = this.b;
                    hVar.d = this.n;
                    hVar.g = this.e;
                    hVar.h = fVar.b;
                    hVar.i = this.w;
                    hVar.j = this.y;
                    hVar.k = this.h;
                    fVar.f = hVar;
                    fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c() { // from class: com.kwad.sdk.contentalliance.home.g.2
                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void a() {
                            for (com.kwad.sdk.contentalliance.trends.view.c cVar : hVar.e) {
                                cVar.a();
                            }
                        }

                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void a(View view, TrendInfo trendInfo2, int i) {
                            for (com.kwad.sdk.contentalliance.trends.view.c cVar : hVar.e) {
                                cVar.a(view, trendInfo2, i);
                            }
                        }

                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void b() {
                            for (com.kwad.sdk.contentalliance.trends.view.c cVar : hVar.e) {
                                cVar.b();
                            }
                        }
                    });
                    if (this.v != null) {
                    }
                    return fVar;
                }
            }
            com.kwad.sdk.contentalliance.trends.a aVar2 = new com.kwad.sdk.contentalliance.trends.a(this.h);
            aVar2.a(this.k);
            aVar2.a(trendInfo);
            fVar.b = new j(aVar2);
            fVar.k = false;
            fVar.j = 0;
            fVar.h = TrendInfo.asList(this.k);
            fVar.i = trendInfo;
        } else if (this.o != null) {
            fVar.b = new j(new com.kwad.sdk.contentalliance.tube.a(this.h, this.o));
            fVar.k = false;
            fVar.j = this.o.mSelectedPosition;
        } else if (this.p != null) {
            fVar.b = new j(new com.kwad.sdk.contentalliance.home.a.h(this.h, this.p));
            fVar.k = false;
            fVar.j = this.p.mSelectedPosition;
        } else if (this.q != null) {
            fVar.b = new j(new com.kwad.sdk.contentalliance.home.a.c(this.h));
            fVar.k = true;
            fVar.j = this.q.mSelectedPosition;
        } else {
            com.kwad.sdk.contentalliance.home.a.c cVar = new com.kwad.sdk.contentalliance.home.a.c(this.h);
            cVar.a(this.j);
            cVar.a(this.x);
            fVar.b = new j(cVar);
            fVar.k = true;
            fVar.g = this.j;
            com.kwad.sdk.entry.model.a a2 = com.kwad.sdk.entry.a.a();
            if (a2 != null) {
                fVar.j = a2.b;
            } else {
                fVar.j = 0;
            }
        }
        this.A = fVar.b;
        this.e = new com.kwad.sdk.contentalliance.home.swipe.c(this.c.getContext());
        this.e.a(this.w);
        this.d.setTouchDetector(this.e);
        this.t = new com.kwad.sdk.core.i.a(this, this.c, 70);
        this.t.a();
        final h hVar2 = new h();
        hVar2.f5826a = this.t;
        hVar2.b = this.f5823a;
        hVar2.c = this.b;
        hVar2.d = this.n;
        hVar2.g = this.e;
        hVar2.h = fVar.b;
        hVar2.i = this.w;
        hVar2.j = this.y;
        hVar2.k = this.h;
        fVar.f = hVar2;
        fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c() { // from class: com.kwad.sdk.contentalliance.home.g.2
            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar2 : hVar2.e) {
                    cVar2.a();
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void a(View view, TrendInfo trendInfo2, int i) {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar2 : hVar2.e) {
                    cVar2.a(view, trendInfo2, i);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                for (com.kwad.sdk.contentalliance.trends.view.c cVar2 : hVar2.e) {
                    cVar2.b();
                }
            }
        });
        if (this.v != null) {
            fVar.b.a(this.v);
        }
        return fVar;
    }

    protected Presenter f() {
        Presenter presenter = new Presenter();
        if (2 == this.h.getPageScene()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.b());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
        } else if (4 == this.h.getPageScene()) {
            presenter.a((Presenter) new l());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
        } else if (5 == this.h.getPageScene()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.d());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
        } else if (9 == this.h.getPageScene()) {
            presenter.a((Presenter) new k());
            if (this.n.mIsFromLiveSquare) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
            }
        } else if (10 == this.h.getPageScene()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.h());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
        } else if (12 == this.h.getPageScene()) {
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.d());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
            if (com.kwad.sdk.core.config.c.A()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.e());
            }
        } else {
            if ("push".equals(this.i)) {
                if (this.z) {
                    presenter.a((Presenter) new n());
                }
            } else if ("entry".equals(this.i)) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.a());
                if (this.z) {
                    presenter.a((Presenter) new n());
                }
            }
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
            if (com.kwad.sdk.core.config.c.A()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.e());
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
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        com.kwad.sdk.core.d.a.b("HomeFragment", "onCreateView");
        if (this.c == null) {
            this.c = layoutInflater.inflate(R.layout.ksad_content_alliance_home_fragment, viewGroup, false);
            this.d = (SwipeLayout) this.c.findViewById(R.id.ksad_swipe);
            this.f = (SlidePlayViewPager) this.c.findViewById(R.id.ksad_slide_play_view_pager);
            this.g = (KsAdHotRefreshView) this.c.findViewById(R.id.ksad_refresh_layout);
            if (com.kwad.sdk.utils.d.a(getActivity())) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                marginLayoutParams.topMargin = ao.a((Context) getActivity());
                this.g.setLayoutParams(marginLayoutParams);
            }
        }
        this.c.post(new Runnable() { // from class: com.kwad.sdk.contentalliance.home.g.1
            @Override // java.lang.Runnable
            public void run() {
                ReportAction.b.a(g.this.c.getWidth());
                ReportAction.b.b(g.this.c.getHeight());
            }
        });
        return this.c;
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
        if (this.r != null) {
            this.r.a();
        }
        if (this.s != null) {
            this.s.j();
        }
        this.d.setTouchDetector(null);
        this.d.a();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.kwad.sdk.core.d.a.b("HomeFragment", "onHiddenChanged hidden: " + z);
        if (this.t != null) {
            this.t.b(z);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_PAUSE);
        if (this.t != null) {
            this.t.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_RESUME);
        if (this.t != null) {
            this.t.c();
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
        this.s = f();
        this.s.a(this.c);
        this.s.a(this.r);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.kwad.sdk.core.d.a.b("HomeFragment", "setUserVisibleHint isVisibleToUser: " + z);
        if (this.t != null) {
            this.t.a(z);
        }
    }
}
