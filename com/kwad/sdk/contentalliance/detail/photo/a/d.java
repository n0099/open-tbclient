package com.kwad.sdk.contentalliance.detail.photo.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.g.a.f;
import com.kwad.sdk.core.g.a.l;
import com.kwad.sdk.core.g.f;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.p;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.contentalliance.a.a A;
    public Runnable B;
    public Runnable C;
    public Runnable D;
    public Runnable E;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f34607b;

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f34608c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f34609d;

    /* renamed from: e  reason: collision with root package name */
    public WebView f34610e;

    /* renamed from: f  reason: collision with root package name */
    public ViewStub f34611f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f34612g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34613h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f34614i;
    public View j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public AdTemplate n;
    public boolean o;
    public boolean p;
    public boolean q;
    public AdTemplate r;
    public AdStyleInfo.PlayDetailInfo.PatchAdInfo s;
    @Nullable
    public com.kwad.sdk.core.download.b.b t;
    @Nullable
    public KsAppDownloadListener u;
    @Nullable
    public b v;
    public ValueAnimator w;
    public ValueAnimator x;
    public boolean y;
    public boolean z;

    public d() {
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
        this.p = false;
        this.q = false;
        this.y = false;
        this.z = false;
        this.A = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34615a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34615a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    this.f34615a.p = true;
                    this.f34615a.f();
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    this.f34615a.p = false;
                    this.f34615a.e();
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34618a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34618a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    int i4 = -this.f34618a.f34612g.getWidth();
                    this.f34618a.f34612g.setTranslationX(i4);
                    this.f34618a.f34612g.setVisibility(0);
                    this.f34618a.h();
                    d dVar = this.f34618a;
                    dVar.w = am.c(dVar.f34612g, i4, 0);
                    this.f34618a.w.start();
                    this.f34618a.w();
                    this.f34618a.f34612g.setOnClickListener(this.f34618a);
                }
            }
        };
        this.B = runnable;
        this.C = new aq(runnable);
        Runnable runnable2 = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f34620a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34620a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f34620a.y || this.f34620a.v == null || this.f34620a.u()) {
                    return;
                }
                this.f34620a.v.c();
            }
        };
        this.D = runnable2;
        this.E = new aq(runnable2);
    }

    private KsAppDownloadListener a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, adInfo)) == null) {
            com.kwad.sdk.core.download.b.c cVar = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f34619a;

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
                    this.f34619a = this;
                }

                @Override // com.kwad.sdk.core.download.b.c
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        d dVar = this.f34619a;
                        String str = dVar.s.weakStyleDownloadingTitle;
                        dVar.a(str, "继续下载 " + i2 + "%");
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        d dVar = this.f34619a;
                        dVar.a(dVar.s.weakStyleTitle, "");
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        d dVar = this.f34619a;
                        dVar.a(dVar.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.a(this.f34619a.r));
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        d dVar = this.f34619a;
                        dVar.a(dVar.s.weakStyleTitle, "");
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        d dVar = this.f34619a;
                        dVar.a(dVar.s.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.b());
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public void onProgressUpdate(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) {
                        d dVar = this.f34619a;
                        String str = dVar.s.weakStyleDownloadingTitle;
                        dVar.a(str, "正在下载 " + i2 + "%");
                    }
                }
            };
            this.u = cVar;
            return cVar;
        }
        return (KsAppDownloadListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, adTemplate) == null) && this.p) {
            this.r = adTemplate;
            this.s = com.kwad.sdk.core.response.b.b.a(adTemplate);
            q();
            r();
            t();
            g();
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        View view;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            int c2 = ((ao.c(o()) - ao.a(o(), 12.0f)) - ao.a(o(), 93.0f)) - (ao.a(o(), 8.0f) * 2);
            if (!TextUtils.isEmpty(this.s.weakStyleIcon)) {
                c2 -= ao.a(o(), 22.0f);
            }
            if (!TextUtils.isEmpty(this.s.weakStyleAdMark)) {
                c2 -= ao.a(o(), 20.0f);
            }
            if (this.s.weakStyleEnableClose) {
                c2 -= ao.a(o(), 20.0f);
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                view = this.j;
                i2 = 8;
            } else {
                if (!ag.a(str)) {
                    this.k.setText(str2);
                    c2 -= (int) (ao.a(o(), 17.0f) + this.k.getPaint().measureText(str2));
                    int measureText = (int) this.f34614i.getPaint().measureText(str);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.j.getLayoutParams();
                    if (measureText > c2) {
                        marginLayoutParams.leftMargin = ao.a(o(), 4.0f);
                        c2 += ao.a(o(), 4.0f);
                    } else {
                        marginLayoutParams.leftMargin = ao.a(o(), 8.0f);
                    }
                }
                view = this.j;
                i2 = 0;
            }
            view.setVisibility(i2);
            this.k.setVisibility(i2);
            this.f34614i.setMaxWidth(c2);
            this.f34614i.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            this.q = false;
            this.y = false;
            this.z = false;
            ViewGroup viewGroup = this.f34612g;
            if (viewGroup != null) {
                viewGroup.removeCallbacks(this.C);
                this.f34612g.setVisibility(8);
            }
            this.f34609d.setTranslationX(0.0f);
            this.f34607b.setVisibility(8);
            this.f34607b.removeCallbacks(this.E);
            b bVar = this.v;
            if (bVar != null) {
                bVar.b();
                this.v = null;
            }
            h();
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || this.q) {
            return;
        }
        this.q = true;
        SceneImpl sceneImpl = this.n.mAdScene;
        f fVar = new f(sceneImpl);
        if (sceneImpl instanceof SceneImpl) {
            fVar.f36139b = this.n.mAdScene.getPageScene();
        }
        fVar.f36140c = 101L;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.n);
        long k2 = com.kwad.sdk.core.response.b.d.k(k);
        l lVar = new l();
        lVar.f36161a = k2;
        lVar.f36162b = com.kwad.sdk.core.response.b.d.o(k);
        com.kwad.sdk.core.g.f.a(k2, fVar, lVar, new f.a(this, k2) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f34616a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f34617b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Long.valueOf(k2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34617b = this;
                this.f34616a = k2;
            }

            @Override // com.kwad.sdk.core.g.f.a
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f34617b.q = false;
                }
            }

            @Override // com.kwad.sdk.core.g.f.a
            public void a(long j, AdTemplate adTemplate) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, adTemplate) == null) {
                    this.f34617b.q = false;
                    if (adTemplate == null || j != this.f34616a) {
                        return;
                    }
                    this.f34617b.a(adTemplate);
                }
            }
        });
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f34612g.removeCallbacks(this.C);
            long j = this.s.weakStyleAppearTime;
            if (j <= 0) {
                j = 0;
            }
            this.f34612g.postDelayed(this.C, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ValueAnimator valueAnimator = this.w;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.x;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && ao.a((View) this.f34612g, 50, false)) {
            ValueAnimator c2 = am.c(this.f34612g, 0, -this.f34612g.getWidth());
            this.x = c2;
            c2.start();
            this.m.setOnClickListener(null);
            this.f34612g.setOnClickListener(null);
            s();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || this.f34611f.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.f34611f.inflate();
        this.f34612g = viewGroup;
        viewGroup.setVisibility(8);
        this.f34613h = (ImageView) b(R.id.ksad_patch_icon);
        this.f34614i = (TextView) b(R.id.ksad_patch_ad_title);
        this.j = b(R.id.ksad_patch_ad_mid_line);
        this.k = (TextView) b(R.id.ksad_patch_ad_app_status);
        this.l = (ImageView) b(R.id.ksad_patch_ad_mark);
        this.m = (ImageView) b(R.id.ksad_patch_ad_close_btn);
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.r);
            String str = this.s.weakStyleIcon;
            if (ag.a(str)) {
                this.f34613h.setVisibility(8);
            } else {
                KSImageLoader.loadImage(this.f34613h, str, this.r);
                this.f34613h.setVisibility(0);
            }
            if (com.kwad.sdk.core.response.b.a.y(j)) {
                s();
                com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(this.r);
                this.t = bVar;
                bVar.a(a(j));
            } else {
                a(this.s.weakStyleTitle, "");
            }
            String str2 = this.s.weakStyleAdMark;
            if (ag.a(str2)) {
                this.l.setVisibility(8);
            } else {
                KSImageLoader.loadImage(this.l, str2, this.r);
                this.l.setVisibility(0);
            }
            if (this.s.weakStyleEnableClose) {
                this.m.setOnClickListener(this);
                this.m.setVisibility(0);
            } else {
                this.m.setVisibility(8);
            }
            this.f34612g.setVisibility(4);
        }
    }

    private void s() {
        com.kwad.sdk.core.download.b.b bVar;
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || (bVar = this.t) == null || (ksAppDownloadListener = this.u) == null) {
            return;
        }
        bVar.b(ksAppDownloadListener);
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || ag.a(this.s.strongStyleCardUrl)) {
            return;
        }
        b bVar = new b();
        this.v = bVar;
        bVar.a(this.f34609d, this.f34612g, this.f34607b, this.f34610e, this.f34608c, this.r, this.t);
        this.v.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u() {
        InterceptResult invokeV;
        DOWNLOADSTAUS downloadstaus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            if (com.kwad.sdk.core.config.c.z()) {
                return false;
            }
            if (this.z) {
                return true;
            }
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.r);
            return (!com.kwad.sdk.core.response.b.a.y(j) || (downloadstaus = j.status) == DOWNLOADSTAUS.UNKNOWN || downloadstaus == DOWNLOADSTAUS.FAILED) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || u()) {
            return;
        }
        this.f34607b.removeCallbacks(this.E);
        long j = this.s.strongStyleAppearTime;
        if (j <= 0) {
            j = 5000;
        }
        this.f34607b.postDelayed(this.E, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            com.kwad.sdk.core.report.b.a(this.r, (JSONObject) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            AdTemplate adTemplate = this.r;
            AdBaseFrameLayout adBaseFrameLayout = this.f34608c;
            com.kwad.sdk.core.report.b.a(adTemplate, 51, adBaseFrameLayout == null ? null : adBaseFrameLayout.getTouchCoords());
        }
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            com.kwad.sdk.core.report.b.a(this.r, 9, (JSONObject) null);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.n = adTemplate;
            if (!com.kwad.sdk.core.response.b.d.H(com.kwad.sdk.core.response.b.c.k(adTemplate))) {
                this.o = false;
                return;
            }
            this.o = true;
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.A);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (this.o) {
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.A);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34608c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34609d = (ViewGroup) b(R.id.ksad_bottom_content_container);
            this.f34607b = (FrameLayout) b(R.id.ksad_web_card_container);
            this.f34610e = (WebView) b(R.id.ksad_actionbar_web_card);
            this.f34611f = (ViewStub) b(R.id.ksad_patch_ad_view_stub);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view == this.m) {
                p();
                this.y = true;
                this.f34607b.removeCallbacks(this.E);
                y();
            } else if (view == this.f34612g) {
                if (!com.ksad.download.d.b.a(view.getContext())) {
                    p.a(view.getContext(), "网络错误");
                }
                com.kwad.sdk.core.download.b.b.a(this.t, true);
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.r, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.a.d.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f34621a;

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
                        this.f34621a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f34621a.z = true;
                            this.f34621a.x();
                        }
                    }
                }, this.t);
            }
        }
    }
}
