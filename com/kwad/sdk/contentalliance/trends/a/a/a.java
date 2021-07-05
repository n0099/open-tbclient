package com.kwad.sdk.contentalliance.trends.a.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.trends.TrendsParams;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.core.i.d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f35458b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f35459c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35460d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35461e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35462f;

    /* renamed from: g  reason: collision with root package name */
    public View f35463g;

    /* renamed from: h  reason: collision with root package name */
    public View f35464h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public ViewStub f35465i;
    @Nullable
    public View j;
    @Nullable
    public View k;
    @Nullable
    public TextView l;
    @Nullable
    public ImageView m;
    public ImageView n;
    public Animation o;
    public AdTemplate p;
    public int q;
    public AtomicBoolean r;
    public c s;
    public com.kwad.sdk.contentalliance.a.a t;

    public a() {
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
        this.r = new AtomicBoolean(false);
        this.s = new d(this) { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35466a;

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
                this.f35466a = this;
            }

            @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35466a.r.getAndSet(true)) {
                    return;
                }
                if (this.f35466a.a(com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this.f35466a).f34553a.j)))) {
                    e.j(this.f35466a.p);
                }
            }
        };
        this.t = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35467a;

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
                this.f35467a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35467a.r.set(false);
                }
            }
        };
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            this.f35461e.setText(String.format(o().getString(this.q == 2 ? R.string.ksad_photo_hot_enter_watch_extra_button_format_v2 : R.string.ksad_photo_hot_enter_watch_count_format), ag.b(j)));
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, str) == null) {
            this.f35460d.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, TrendInfo trendInfo) {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(AdIconUtil.AD_TEXT_ID, this, z, trendInfo) == null) || o() == null) {
            return;
        }
        e.c(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j, z ? 2 : 1);
        TrendsParams trendsParams = new TrendsParams();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
            trendsParams.mEntryScene = sceneImpl.entryScene;
        }
        trendsParams.trendInfo = trendInfo;
        com.kwad.sdk.contentalliance.trends.b.a(o(), trendsParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(TrendInfo trendInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, trendInfo)) == null) {
            boolean z2 = true;
            boolean z3 = com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) && !((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mIsTubeEpisodeList;
            if (trendInfo != null) {
                long j = trendInfo.offlineTime;
                if (j > 0 && j < System.currentTimeMillis()) {
                    z = true;
                    z2 = (trendInfo != null || TextUtils.isEmpty(trendInfo.name) || com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j) || z3 || z) ? false : false;
                    com.kwad.sdk.core.d.a.a("PhotoTrendEnterPresenter", ">> isShowTrendEnterView() showTrendEnter=" + z2);
                    return z2;
                }
            }
            z = false;
            if (trendInfo != null) {
            }
            com.kwad.sdk.core.d.a.a("PhotoTrendEnterPresenter", ">> isShowTrendEnterView() showTrendEnter=" + z2);
            return z2;
        }
        return invokeL.booleanValue;
    }

    private void b(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(65545, this, j) == null) || this.l == null) {
            return;
        }
        this.l.setText(String.format(o().getString(R.string.ksad_photo_hot_enter_watch_extra_button_format), ag.b(j)));
    }

    private void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, view) == null) || view == null) {
            return;
        }
        this.o = this.q == 0 ? new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f) : new TranslateAnimation(-2.0f, 4.0f, 0.0f, 0.0f);
        this.o.setDuration(250L);
        view.setAnimation(this.o);
        this.o.setRepeatCount(Integer.MAX_VALUE);
        this.o.setRepeatMode(2);
        this.o.startNow();
    }

    private void b(TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, trendInfo) == null) {
            int i2 = this.q;
            if (i2 == 1) {
                c(trendInfo);
            } else if (i2 != 2) {
                e(trendInfo);
            } else {
                d(trendInfo);
            }
        }
    }

    private void c(TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, trendInfo) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35459c.getLayoutParams();
            marginLayoutParams.rightMargin = ao.a(o(), 0.0f);
            marginLayoutParams.width = -1;
            marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
            this.f35459c.setLayoutParams(marginLayoutParams);
            this.f35463g.setVisibility(8);
            this.f35464h.setVisibility(8);
            this.f35461e.setVisibility(8);
            this.f35462f.setVisibility(8);
            e();
            if (this.j == null) {
                return;
            }
            View view = this.k;
            if (view != null) {
                view.setVisibility(0);
            }
            this.j.setOnClickListener(new View.OnClickListener(this, trendInfo) { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendInfo f35470a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f35471b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trendInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35471b = this;
                    this.f35470a = trendInfo;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.f35471b.a(true, this.f35470a);
                    }
                }
            });
            this.j.setVisibility(0);
            b(trendInfo.viewCount);
            b(this.m);
        }
    }

    private void d(TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, trendInfo) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35459c.getLayoutParams();
            marginLayoutParams.rightMargin = ao.a(o(), 57.0f);
            marginLayoutParams.width = -2;
            marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
            this.f35459c.setLayoutParams(marginLayoutParams);
            a(trendInfo.viewCount);
            this.f35463g.setVisibility(8);
            this.f35464h.setVisibility(0);
            this.f35461e.setVisibility(0);
            this.f35462f.setVisibility(8);
            e();
            if (this.j == null) {
                return;
            }
            View view = this.k;
            if (view != null) {
                view.setVisibility(0);
            }
            this.j.setOnClickListener(new View.OnClickListener(this, trendInfo) { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TrendInfo f35472a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f35473b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, trendInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35473b = this;
                    this.f35472a = trendInfo;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.f35473b.a(true, this.f35472a);
                    }
                }
            });
            this.j.setVisibility(0);
            b(this.m);
        }
    }

    private void e() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (viewStub = this.f35465i) == null || viewStub.getParent() == null || this.j != null) {
            return;
        }
        this.j = this.f35465i.inflate();
        this.k = b(R.id.ksad_photo_hot_extra_button);
        this.l = (TextView) b(R.id.ksad_photo_hot_extra_button_text);
        this.m = (ImageView) b(R.id.ksad_photo_hot_extra_button_arrow);
    }

    private void e(TrendInfo trendInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, trendInfo) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35459c.getLayoutParams();
            marginLayoutParams.rightMargin = ao.a(o(), 43.0f);
            marginLayoutParams.width = -2;
            marginLayoutParams.height = ao.a(o(), R.dimen.ksad_content_trend_bottom_layout_height);
            this.f35459c.setLayoutParams(marginLayoutParams);
            this.f35463g.setVisibility(0);
            this.f35464h.setVisibility(8);
            this.f35461e.setVisibility(0);
            this.f35462f.setVisibility(0);
            a(trendInfo.viewCount);
            b(this.f35462f);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.p = adTemplate;
            TrendInfo K = com.kwad.sdk.core.response.b.d.K(com.kwad.sdk.core.response.b.c.k(adTemplate));
            if (a(K)) {
                a(K.name);
                if (TextUtils.isEmpty(K.iconUrl)) {
                    this.n.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_trend_hot_icon));
                } else {
                    KSImageLoader.loadImage(this.n, K.iconUrl, null);
                }
                b(K);
                this.f35458b.setOnClickListener(new View.OnClickListener(this, K) { // from class: com.kwad.sdk.contentalliance.trends.a.a.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TrendInfo f35468a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f35469b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, K};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f35469b = this;
                        this.f35468a = K;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f35469b.a(false, this.f35468a);
                        }
                    }
                });
                viewGroup = this.f35458b;
                i2 = 0;
            } else {
                viewGroup = this.f35458b;
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.t);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.a(this.s);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            Animation animation = this.o;
            if (animation != null) {
                animation.cancel();
            }
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.s);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.t);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.q = com.kwad.sdk.core.config.c.x();
            this.f35458b = (ViewGroup) b(R.id.ksad_photo_hot_enter_container);
            this.f35462f = (ImageView) b(R.id.ksad_trend_enter_arrow);
            this.f35460d = (TextView) b(R.id.ksad_photo_hot_enter_trend_name);
            this.f35461e = (TextView) b(R.id.ksad_photo_hot_enter_watch_count);
            this.f35459c = (ViewGroup) b(R.id.ksad_photo_hot_bottom_enter);
            this.f35463g = b(R.id.ksad_photo_hot_divider);
            this.f35464h = b(R.id.ksad_photo_hot_divider_v2);
            int i3 = this.q;
            if (i3 != 1) {
                if (i3 == 2) {
                    i2 = R.id.ksad_trend_enter_extra_button_vs_v2;
                }
                this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
            }
            i2 = R.id.ksad_trend_enter_extra_button_vs;
            this.f35465i = (ViewStub) b(i2);
            this.n = (ImageView) b(R.id.ksad_photo_hot_enter_label);
        }
    }
}
