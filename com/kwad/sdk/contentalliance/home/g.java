package com.kwad.sdk.contentalliance.home;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class g extends KsFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i A;

    /* renamed from: a  reason: collision with root package name */
    public KsContentPage.PageListener f35228a;

    /* renamed from: b  reason: collision with root package name */
    public KsContentPage.VideoListener f35229b;

    /* renamed from: c  reason: collision with root package name */
    public View f35230c;

    /* renamed from: d  reason: collision with root package name */
    public SwipeLayout f35231d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.swipe.c f35232e;

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayViewPager f35233f;

    /* renamed from: g  reason: collision with root package name */
    public KsAdHotRefreshView f35234g;

    /* renamed from: h  reason: collision with root package name */
    public SceneImpl f35235h;

    /* renamed from: i  reason: collision with root package name */
    public String f35236i;
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
    public com.kwad.sdk.contentalliance.detail.b.b u;
    public com.kwad.sdk.contentalliance.home.a.d v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35236i = "unknown";
        this.u = new com.kwad.sdk.contentalliance.detail.b.b();
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
    }

    public static g a(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ksScene)) == null) {
            g gVar = new g();
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_AdScene", ksScene);
            gVar.setArguments(bundle);
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    private void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            Serializable serializable = bundle.getSerializable(LiveSlidHomeParam.KEY_LIVE_SLIDE_HOME_PARAM);
            if (serializable instanceof LiveSlidHomeParam) {
                this.n = (LiveSlidHomeParam) serializable;
            }
        }
    }

    private void b(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, bundle) == null) {
            Serializable serializable = bundle.getSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM");
            if (serializable instanceof ProfileVideoDetailParam) {
                this.m = (ProfileVideoDetailParam) serializable;
            }
        }
    }

    private void c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, bundle) == null) {
            Serializable serializable = bundle.getSerializable("KEY_TUBE_EPISODE_DETAIL_PARAM");
            if (serializable instanceof TubeEpisodeDetailParam) {
                this.o = (TubeEpisodeDetailParam) serializable;
            }
        }
    }

    private void d(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bundle) == null) {
            Serializable serializable = bundle.getSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM");
            if (serializable instanceof RelatedVideoDetailParam) {
                this.p = (RelatedVideoDetailParam) serializable;
            }
        }
    }

    private void e(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bundle) == null) {
            Serializable serializable = bundle.getSerializable("KEY_FEED_SLIDE_PARAM");
            if (serializable instanceof FeedSlideParam) {
                this.q = (FeedSlideParam) serializable;
            }
        }
    }

    private boolean g() {
        InterceptResult invokeV;
        URLPackage uRLPackage;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
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
                this.f35235h = new SceneImpl((KsScene) serializable);
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
                            this.f35235h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 1));
                            this.y = com.kwad.sdk.core.config.c.N() || com.kwad.sdk.core.config.c.O();
                            if (com.kwad.sdk.entry.a.a() != null) {
                                this.f35236i = "entry";
                                com.kwad.sdk.core.scene.a.a().a(this.f35236i, com.kwad.sdk.entry.a.a().f37235a.f36566e, this.f35235h);
                            } else if (ag.a(this.j)) {
                                this.w = false;
                            } else {
                                this.f35236i = "push";
                                com.kwad.sdk.core.scene.a.a().a(this.f35236i, this.f35235h);
                            }
                            this.w = com.kwad.sdk.core.config.c.G();
                            this.z = com.kwad.sdk.core.config.c.I();
                            return true;
                        }
                        this.f35235h.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 12));
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
                this.f35235h.setUrlPackage(uRLPackage);
                this.w = false;
                this.y = false;
                this.z = false;
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        SlidePlayViewPager slidePlayViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.A == null || (slidePlayViewPager = this.f35233f) == null || slidePlayViewPager.getSourceType() != 0) {
            return;
        }
        if (!com.kwad.sdk.core.config.c.H()) {
            com.kwad.sdk.core.d.a.b("HomeFragment", "tryToRefresh is disable");
        } else if (this.f35234g.a()) {
            com.kwad.sdk.core.d.a.a("HomeFragment", "tryToRefresh is mRefreshLayout isRefreshViewShowing");
        } else {
            this.A.a(2);
        }
    }

    public void a(KsContentPage.PageListener pageListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pageListener) == null) {
            this.f35228a = pageListener;
        }
    }

    public void a(KsContentPage.VideoListener videoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoListener) == null) {
            this.f35229b = videoListener;
        }
    }

    public void a(com.kwad.sdk.contentalliance.home.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            this.v = dVar;
        }
    }

    public void a(List<KsContentPage.SubShowItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.u.a(list);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        com.kwad.sdk.contentalliance.home.swipe.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f35233f.getSourceType() == 0 || (cVar = this.f35232e) == null || !cVar.b()) {
                return false;
            }
            this.f35232e.c();
            return true;
        }
        return invokeV.booleanValue;
    }

    public SlidePlayViewPager c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f35233f : (SlidePlayViewPager) invokeV.objValue;
    }

    public SceneImpl d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f35235h : (SceneImpl) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f e() {
        InterceptResult invokeV;
        int i2;
        TrendInfo trendInfo;
        com.kwad.sdk.contentalliance.home.a.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            f fVar = new f();
            fVar.f35219a = this;
            fVar.f35221c = this.f35233f;
            fVar.f35222d = this.u;
            SceneImpl sceneImpl = this.f35235h;
            fVar.f35223e = sceneImpl;
            fVar.l = this.w;
            fVar.m = this.z;
            ProfileVideoDetailParam profileVideoDetailParam = this.m;
            if (profileVideoDetailParam != null) {
                fVar.f35220b = new j(new com.kwad.sdk.contentalliance.home.a.g(sceneImpl, profileVideoDetailParam));
                fVar.k = false;
                i2 = this.m.mSelectedPosition;
            } else {
                LiveSlidHomeParam liveSlidHomeParam = this.n;
                if (liveSlidHomeParam == null) {
                    if (TextUtils.isEmpty(this.k)) {
                        TubeEpisodeDetailParam tubeEpisodeDetailParam = this.o;
                        if (tubeEpisodeDetailParam != null) {
                            fVar.f35220b = new j(new com.kwad.sdk.contentalliance.tube.a(this.f35235h, tubeEpisodeDetailParam));
                            fVar.k = false;
                            i2 = this.o.mSelectedPosition;
                        } else {
                            RelatedVideoDetailParam relatedVideoDetailParam = this.p;
                            if (relatedVideoDetailParam != null) {
                                fVar.f35220b = new j(new com.kwad.sdk.contentalliance.home.a.h(this.f35235h, relatedVideoDetailParam));
                                fVar.k = false;
                                i2 = this.p.mSelectedPosition;
                            } else if (this.q != null) {
                                fVar.f35220b = new j(new com.kwad.sdk.contentalliance.home.a.c(this.f35235h));
                                fVar.k = true;
                                i2 = this.q.mSelectedPosition;
                            } else {
                                com.kwad.sdk.contentalliance.home.a.c cVar = new com.kwad.sdk.contentalliance.home.a.c(this.f35235h);
                                cVar.a(this.j);
                                cVar.a(this.x);
                                fVar.f35220b = new j(cVar);
                                fVar.k = true;
                                fVar.f35225g = this.j;
                                com.kwad.sdk.entry.model.a a2 = com.kwad.sdk.entry.a.a();
                                if (a2 != null) {
                                    i2 = a2.f37236b;
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
                            } catch (Exception e2) {
                                e = e2;
                                trendInfo = null;
                            }
                            try {
                                trendInfo.parseJson(new JSONObject(this.l));
                            } catch (Exception e3) {
                                e = e3;
                                fVar.f35227i = null;
                                com.kwad.sdk.core.d.a.a(e);
                                trendInfo2 = trendInfo;
                                com.kwad.sdk.contentalliance.trends.a aVar = new com.kwad.sdk.contentalliance.trends.a(this.f35235h);
                                aVar.a(this.k);
                                aVar.a(trendInfo2);
                                fVar.f35220b = new j(aVar);
                                fVar.k = false;
                                fVar.j = 0;
                                fVar.f35226h = TrendInfo.asList(this.k);
                                fVar.f35227i = trendInfo2;
                                this.A = fVar.f35220b;
                                com.kwad.sdk.contentalliance.home.swipe.c cVar2 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f35230c.getContext());
                                this.f35232e = cVar2;
                                cVar2.a(this.w);
                                this.f35231d.setTouchDetector(this.f35232e);
                                com.kwad.sdk.core.i.a aVar2 = new com.kwad.sdk.core.i.a(this, this.f35230c, 70);
                                this.t = aVar2;
                                aVar2.a();
                                h hVar = new h();
                                hVar.f35240a = this.t;
                                hVar.f35241b = this.f35228a;
                                hVar.f35242c = this.f35229b;
                                hVar.f35243d = this.n;
                                hVar.f35246g = this.f35232e;
                                hVar.f35247h = fVar.f35220b;
                                hVar.f35248i = this.w;
                                hVar.j = this.y;
                                hVar.k = this.f35235h;
                                fVar.f35224f = hVar;
                                fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c(this, hVar) { // from class: com.kwad.sdk.contentalliance.home.g.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ h f35238a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ g f35239b;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, hVar};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f35239b = this;
                                        this.f35238a = hVar;
                                    }

                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void a() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                                cVar3.a();
                                            }
                                        }
                                    }

                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void a(View view, TrendInfo trendInfo3, int i3) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, trendInfo3, i3) == null) {
                                            for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                                cVar3.a(view, trendInfo3, i3);
                                            }
                                        }
                                    }

                                    @Override // com.kwad.sdk.contentalliance.trends.view.c
                                    public void b() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                            for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                                cVar3.b();
                                            }
                                        }
                                    }
                                });
                                dVar = this.v;
                                if (dVar != null) {
                                }
                                return fVar;
                            }
                            trendInfo2 = trendInfo;
                        }
                        com.kwad.sdk.contentalliance.trends.a aVar3 = new com.kwad.sdk.contentalliance.trends.a(this.f35235h);
                        aVar3.a(this.k);
                        aVar3.a(trendInfo2);
                        fVar.f35220b = new j(aVar3);
                        fVar.k = false;
                        fVar.j = 0;
                        fVar.f35226h = TrendInfo.asList(this.k);
                        fVar.f35227i = trendInfo2;
                    }
                    this.A = fVar.f35220b;
                    com.kwad.sdk.contentalliance.home.swipe.c cVar22 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f35230c.getContext());
                    this.f35232e = cVar22;
                    cVar22.a(this.w);
                    this.f35231d.setTouchDetector(this.f35232e);
                    com.kwad.sdk.core.i.a aVar22 = new com.kwad.sdk.core.i.a(this, this.f35230c, 70);
                    this.t = aVar22;
                    aVar22.a();
                    h hVar2 = new h();
                    hVar2.f35240a = this.t;
                    hVar2.f35241b = this.f35228a;
                    hVar2.f35242c = this.f35229b;
                    hVar2.f35243d = this.n;
                    hVar2.f35246g = this.f35232e;
                    hVar2.f35247h = fVar.f35220b;
                    hVar2.f35248i = this.w;
                    hVar2.j = this.y;
                    hVar2.k = this.f35235h;
                    fVar.f35224f = hVar2;
                    fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c(this, hVar2) { // from class: com.kwad.sdk.contentalliance.home.g.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ h f35238a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ g f35239b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = objArr;
                                Object[] objArr = {this, hVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35239b = this;
                            this.f35238a = hVar2;
                        }

                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                    cVar3.a();
                                }
                            }
                        }

                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void a(View view, TrendInfo trendInfo3, int i3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, trendInfo3, i3) == null) {
                                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                    cVar3.a(view, trendInfo3, i3);
                                }
                            }
                        }

                        @Override // com.kwad.sdk.contentalliance.trends.view.c
                        public void b() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                                    cVar3.b();
                                }
                            }
                        }
                    });
                    dVar = this.v;
                    if (dVar != null) {
                        fVar.f35220b.a(dVar);
                    }
                    return fVar;
                }
                fVar.f35220b = new j(new com.kwad.sdk.contentalliance.home.a.f(sceneImpl, liveSlidHomeParam.mIsFromLiveSquare));
                fVar.k = false;
                i2 = this.n.mSelectedPosition;
            }
            fVar.j = i2;
            this.A = fVar.f35220b;
            com.kwad.sdk.contentalliance.home.swipe.c cVar222 = new com.kwad.sdk.contentalliance.home.swipe.c(this.f35230c.getContext());
            this.f35232e = cVar222;
            cVar222.a(this.w);
            this.f35231d.setTouchDetector(this.f35232e);
            com.kwad.sdk.core.i.a aVar222 = new com.kwad.sdk.core.i.a(this, this.f35230c, 70);
            this.t = aVar222;
            aVar222.a();
            h hVar22 = new h();
            hVar22.f35240a = this.t;
            hVar22.f35241b = this.f35228a;
            hVar22.f35242c = this.f35229b;
            hVar22.f35243d = this.n;
            hVar22.f35246g = this.f35232e;
            hVar22.f35247h = fVar.f35220b;
            hVar22.f35248i = this.w;
            hVar22.j = this.y;
            hVar22.k = this.f35235h;
            fVar.f35224f = hVar22;
            fVar.o.add(new com.kwad.sdk.contentalliance.trends.view.c(this, hVar22) { // from class: com.kwad.sdk.contentalliance.home.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f35238a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f35239b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, hVar22};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35239b = this;
                    this.f35238a = hVar22;
                }

                @Override // com.kwad.sdk.contentalliance.trends.view.c
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                            cVar3.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.contentalliance.trends.view.c
                public void a(View view, TrendInfo trendInfo3, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, trendInfo3, i3) == null) {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                            cVar3.a(view, trendInfo3, i3);
                        }
                    }
                }

                @Override // com.kwad.sdk.contentalliance.trends.view.c
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        for (com.kwad.sdk.contentalliance.trends.view.c cVar3 : this.f35238a.f35244e) {
                            cVar3.b();
                        }
                    }
                }
            });
            dVar = this.v;
            if (dVar != null) {
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Presenter f() {
        InterceptResult invokeV;
        n nVar;
        Presenter eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Presenter presenter = new Presenter();
            if (2 == this.f35235h.getPageScene()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.c());
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.trends.a.b.b());
                eVar = new com.kwad.sdk.contentalliance.home.b.f();
            } else if (4 == this.f35235h.getPageScene()) {
                presenter.a((Presenter) new l());
                eVar = new com.kwad.sdk.contentalliance.home.b.f();
            } else if (5 == this.f35235h.getPageScene()) {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.tube.a.d());
                eVar = new com.kwad.sdk.contentalliance.home.b.f();
            } else if (9 == this.f35235h.getPageScene()) {
                presenter.a((Presenter) new k());
                if (this.n.mIsFromLiveSquare) {
                    eVar = new com.kwad.sdk.contentalliance.home.b.f();
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
            } else if (10 != this.f35235h.getPageScene()) {
                if (12 == this.f35235h.getPageScene()) {
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.d());
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                    if (com.kwad.sdk.core.config.c.A()) {
                        eVar = new com.kwad.sdk.contentalliance.home.b.e();
                    }
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
                } else if ("push".equals(this.f35236i)) {
                    if (this.z) {
                        nVar = new n();
                        presenter.a((Presenter) nVar);
                    }
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                    if (com.kwad.sdk.core.config.c.A()) {
                        eVar = new com.kwad.sdk.contentalliance.home.b.e();
                    }
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.c());
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.i());
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.j());
                    if (com.kwad.sdk.core.config.c.aj()) {
                    }
                    if (com.kwad.sdk.core.config.c.J()) {
                    }
                    presenter.a((Presenter) new m());
                    if (com.kwad.sdk.core.config.c.ac()) {
                    }
                    return presenter;
                } else {
                    if ("entry".equals(this.f35236i)) {
                        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.a());
                        if (this.z) {
                            nVar = new n();
                            presenter.a((Presenter) nVar);
                        }
                    }
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.f());
                    if (com.kwad.sdk.core.config.c.A()) {
                    }
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.c());
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.i());
                    presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.j());
                    if (com.kwad.sdk.core.config.c.aj()) {
                    }
                    if (com.kwad.sdk.core.config.c.J()) {
                    }
                    presenter.a((Presenter) new m());
                    if (com.kwad.sdk.core.config.c.ac()) {
                    }
                    return presenter;
                }
            } else {
                presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.h());
                eVar = new com.kwad.sdk.contentalliance.home.b.f();
            }
            presenter.a(eVar);
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.c());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.i());
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.b.j());
            if (com.kwad.sdk.core.config.c.aj()) {
            }
            if (com.kwad.sdk.core.config.c.J()) {
            }
            presenter.a((Presenter) new m());
            if (com.kwad.sdk.core.config.c.ac()) {
            }
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            com.kwad.sdk.core.d.a.b("HomeFragment", "onCreateView");
            if (this.f35230c == null) {
                View inflate = layoutInflater.inflate(R.layout.ksad_content_alliance_home_fragment, viewGroup, false);
                this.f35230c = inflate;
                this.f35231d = (SwipeLayout) inflate.findViewById(R.id.ksad_swipe);
                this.f35233f = (SlidePlayViewPager) this.f35230c.findViewById(R.id.ksad_slide_play_view_pager);
                this.f35234g = (KsAdHotRefreshView) this.f35230c.findViewById(R.id.ksad_refresh_layout);
                if (com.kwad.sdk.utils.d.a(getActivity())) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35234g.getLayoutParams();
                    marginLayoutParams.topMargin = ao.a((Context) getActivity());
                    this.f35234g.setLayoutParams(marginLayoutParams);
                }
            }
            this.f35230c.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f35237a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35237a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ReportAction.b.a(this.f35237a.f35230c.getWidth());
                        ReportAction.b.b(this.f35237a.f35230c.getHeight());
                    }
                }
            });
            return this.f35230c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
            com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_DESTROY);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
            this.f35231d.setTouchDetector(null);
            this.f35231d.a();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onHiddenChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            super.onHiddenChanged(z);
            com.kwad.sdk.core.d.a.b("HomeFragment", "onHiddenChanged hidden: " + z);
            com.kwad.sdk.core.i.a aVar = this.t;
            if (aVar != null) {
                aVar.b(z);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPause();
            com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_PAUSE);
            com.kwad.sdk.core.i.a aVar = this.t;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            com.kwad.sdk.core.d.a.b("HomeFragment", MissionEvent.MESSAGE_RESUME);
            com.kwad.sdk.core.i.a aVar = this.t;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, view, bundle) == null) {
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
            f2.a(this.f35230c);
            this.s.a(this.r);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            super.setUserVisibleHint(z);
            com.kwad.sdk.core.d.a.b("HomeFragment", "setUserVisibleHint isVisibleToUser: " + z);
            com.kwad.sdk.core.i.a aVar = this.t;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }
}
