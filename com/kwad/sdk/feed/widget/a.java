package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TextView f37425f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f37426g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f37427h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f37428i;
    public com.kwad.sdk.core.download.b.b j;
    public TextProgressBar k;
    public TextView l;
    public ImageView m;
    public List<Integer> n;
    public com.kwad.sdk.core.video.videoview.b o;
    public j p;
    public View q;
    public boolean r;
    public KsAppDownloadListener s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = false;
        this.s = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.feed.widget.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37432a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f37432a = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f37432a.k.a(com.kwad.sdk.core.response.b.a.a(), i4);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f37432a.l.setText(com.kwad.sdk.core.response.b.a.w(this.f37432a.f37440b));
                    this.f37432a.l.setVisibility(0);
                    this.f37432a.k.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f37432a.l.setVisibility(8);
                    this.f37432a.k.setVisibility(0);
                    this.f37432a.k.a(com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this.f37432a).f37439a), this.f37432a.k.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f37432a.l.setText(com.kwad.sdk.core.response.b.a.w(this.f37432a.f37440b));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.f37432a.l.setVisibility(8);
                    this.f37432a.k.setVisibility(0);
                    this.f37432a.k.a(com.kwad.sdk.core.response.b.a.b(), this.f37432a.k.getMax());
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i4) == null) {
                    this.f37432a.l.setVisibility(8);
                    this.f37432a.k.setVisibility(0);
                    this.f37432a.k.a(com.kwad.sdk.core.response.b.a.a(i4), i4);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.n;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.n.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, bVar) == null) || bVar == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
        this.p.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.o);
        com.kwad.sdk.core.download.b.a.b(ao.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f37439a, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.feed.widget.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37433a;

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
                this.f37433a = this;
            }

            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f37433a.k();
                }
            }
        }, this.j);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
            ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f37440b));
            textView.setText(com.kwad.sdk.core.response.b.a.w(this.f37440b));
            findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
            textView.setOnClickListener(this);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.q(this.f37440b));
            KSImageLoader.loadAppIcon((ImageView) findViewById(R.id.ksad_app_icon), com.kwad.sdk.core.response.b.a.o(this.f37440b), ((com.kwad.sdk.feed.widget.base.a) this).f37439a, 8);
            ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.n(this.f37440b));
            TextView textView = (TextView) findViewById(R.id.ksad_app_download_before);
            this.l = textView;
            textView.setText(com.kwad.sdk.core.response.b.a.w(this.f37440b));
            this.l.setVisibility(0);
            this.l.setOnClickListener(this);
            TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.k = textProgressBar;
            textProgressBar.setTextDimen(ao.a(getContext(), 11.0f));
            this.k.a(-1, -45056);
            this.k.setVisibility(8);
            this.k.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.j = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f37439a, null, this.s);
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksAdVideoPlayConfig) == null) {
            this.r = ksAdVideoPlayConfig.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.b.a.U(this.f37440b).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.m;
                i2 = 8;
            } else {
                this.m.setImageDrawable(null);
                KSImageLoader.loadImage(this.m, a2, ((com.kwad.sdk.feed.widget.base.a) this).f37439a);
                imageView = this.m;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.n = com.kwad.sdk.core.response.b.a.M(this.f37440b);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(this.f37442d);
            this.o = bVar;
            bVar.setTag(this.n);
            String a3 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.o.a(new d.a().a(a3).a(((com.kwad.sdk.feed.widget.base.a) this).f37439a.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f37440b), System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.o.setVideoSoundEnable(this.r);
            j jVar = new j(this.f37442d, ((com.kwad.sdk.feed.widget.base.a) this).f37439a, this.o);
            this.p = jVar;
            jVar.setVideoPlayCallback(new a.InterfaceC0439a(this) { // from class: com.kwad.sdk.feed.widget.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37430a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37430a = this;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) this.f37430a).f37439a);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f37430a.a(j);
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) this.f37430a).f37439a);
                    }
                }
            });
            this.p.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.o.setController(this.p);
            if (this.f37426g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f37426g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f37426g.setTag(null);
            }
            this.f37426g.addView(this.o);
            this.f37426g.setTag(this.o);
            this.f37426g.setClickable(true);
            this.f37426g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f37431a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37431a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f37431a.o.d()) {
                            a aVar = this.f37431a;
                            aVar.a(aVar.o);
                            return;
                        }
                        this.f37431a.o.setKsPlayLogParam(new com.kwad.sdk.contentalliance.detail.video.c(com.kwad.sdk.core.response.b.a.k(this.f37431a.f37440b), System.currentTimeMillis()));
                        this.f37431a.o.a();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            super.a(adTemplate);
            this.f37425f.setText(com.kwad.sdk.core.response.b.a.n(this.f37440b));
            this.f37428i.a(adTemplate);
            if (com.kwad.sdk.core.response.b.a.y(this.f37440b)) {
                g();
            } else {
                f();
            }
            this.f37427h.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37425f = (TextView) findViewById(R.id.ksad_ad_desc);
            this.q = findViewById(R.id.ksad_app_download_cover);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.f37426g = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f37427h = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.m = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.f37428i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            if (this.r) {
                com.kwad.sdk.utils.b.a().a(false);
                if (com.kwad.sdk.utils.b.a().b()) {
                    this.r = false;
                    this.o.setVideoSoundEnable(false);
                }
            }
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.e();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.f37427h) {
                l();
                return;
            }
            com.kwad.sdk.core.download.b.b.a(this.j, view == this.q);
            a(this.o);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (bVar = this.o) == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) bVar.getParent();
            if (this.o.getParent() != this.f37426g) {
                viewGroup.removeView(this.o);
                if (this.f37426g.getTag() != null) {
                    RatioFrameLayout ratioFrameLayout = this.f37426g;
                    ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                    this.f37426g.setTag(null);
                }
                this.f37426g.addView(this.o);
                this.f37426g.setTag(this.o);
                String a2 = com.kwad.sdk.core.response.b.a.a(this.f37440b);
                this.o.setVideoSoundEnable(this.r);
                this.p.setVideoPlayCallback(new a.InterfaceC0439a(this) { // from class: com.kwad.sdk.feed.widget.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f37429a;

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
                        this.f37429a = this;
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.report.b.h(((com.kwad.sdk.feed.widget.base.a) this.f37429a).f37439a);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                    public void a(long j) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                            this.f37429a.a(j);
                        }
                    }

                    @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0439a
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            com.kwad.sdk.core.report.b.i(((com.kwad.sdk.feed.widget.base.a) this.f37429a).f37439a);
                        }
                    }
                });
                this.p.m();
                this.p.setAutoRelease(true);
                AdVideoPlayerViewCache.a().a(a2);
            }
        }
    }
}
