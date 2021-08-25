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
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a.b f72730a;

    /* renamed from: f  reason: collision with root package name */
    public TextView f72731f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f72732g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f72733h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f72734i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f72735j;
    public ImageView k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public DownloadProgressView o;
    public boolean p;
    public volatile boolean q;
    public com.kwad.sdk.widget.d r;
    public final a.InterfaceC1996a s;

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
        this.p = false;
        this.q = false;
        this.r = new com.kwad.sdk.widget.d(this) { // from class: com.kwad.sdk.feed.widget.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72736a;

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
                this.f72736a = this;
            }

            @Override // com.kwad.sdk.widget.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.utils.j.c(((com.kwad.sdk.feed.widget.base.a) this.f72736a).f72749b);
                }
            }
        };
        this.f72730a = new a.b(this) { // from class: com.kwad.sdk.feed.widget.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72737a;

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
                this.f72737a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f72737a.q = false;
                    com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.f72737a).f72749b);
                    if (this.f72737a.m == null || this.f72737a.m.getParent() != this.f72737a.f72732g) {
                        return;
                    }
                    this.f72737a.m.setVideoSoundEnable(this.f72737a.p);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                    this.f72737a.a(j2);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72737a.q) {
                    return;
                }
                this.f72737a.q = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.f72737a).f72749b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.f72737a).f72749b);
                }
            }
        };
        this.s = new a.InterfaceC1996a(this) { // from class: com.kwad.sdk.feed.widget.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72738a;

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
                this.f72738a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1996a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f72738a.l();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.l;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.l.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f72749b, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65539, this, bVar, z) == null) || bVar == null) {
            return;
        }
        String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
        this.n.setAutoRelease(false);
        AdVideoPlayerViewCache.a().a(a2, this.m);
        com.kwad.sdk.core.download.b.a.b(av.a(this), ((com.kwad.sdk.feed.widget.base.a) this).f72749b, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.feed.widget.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f72740a;

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
                this.f72740a = this;
            }

            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f72740a.k();
                }
            }
        }, this.f72735j, z);
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
            ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
            textView.setText(com.kwad.sdk.core.response.b.a.u(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
            findViewById(R.id.ksad_h5_open_cover).setOnClickListener(this);
            textView.setOnClickListener(this);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.ksad_app_icon);
            ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.b.a.o(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.b.a.n(((com.kwad.sdk.feed.widget.base.a) this).f72750c), ((com.kwad.sdk.feed.widget.base.a) this).f72749b, 8);
            ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
            this.o.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
            this.o.setOnClickListener(this);
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.feed.widget.base.a) this).f72749b, null, this.o.getAppDownloadListener());
            this.f72735j = bVar;
            bVar.c(this.o.getAppDownloadListener());
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
        }
    }

    public void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ksAdVideoPlayConfig) == null) {
            this.p = ksAdVideoPlayConfig.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.b.a.T(((com.kwad.sdk.feed.widget.base.a) this).f72750c).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.k;
                i2 = 8;
            } else {
                this.k.setImageDrawable(null);
                KSImageLoader.loadImage(this.k, a2, ((com.kwad.sdk.feed.widget.base.a) this).f72749b);
                imageView = this.k;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l = com.kwad.sdk.core.response.b.a.I(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f72752e);
            this.m = bVar;
            bVar.setVisibleListener(this.r);
            this.m.setTag(this.l);
            String a3 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            this.m.a(new c.a().a(a3).b(com.kwad.sdk.core.response.b.e.b(com.kwad.sdk.core.response.b.c.j(((com.kwad.sdk.feed.widget.base.a) this).f72749b))).a(((com.kwad.sdk.feed.widget.base.a) this).f72749b.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b)).a(), (Map<String, String>) null);
            this.m.setVideoSoundEnable(this.p);
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f72752e, ((com.kwad.sdk.feed.widget.base.a) this).f72749b, this.m);
            this.n = jVar;
            jVar.setVideoPlayCallback(this.f72730a);
            this.n.setVideoClickListener(this.s);
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.m.setController(this.n);
            if (this.f72732g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f72732g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f72732g.setTag(null);
            }
            this.f72732g.addView(this.m);
            this.f72732g.setTag(this.m);
            this.f72732g.setClickable(true);
            this.f72732g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f72739a;

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
                    this.f72739a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f72739a.m.d()) {
                            a aVar = this.f72739a;
                            aVar.a(aVar.m, false);
                            return;
                        }
                        com.kwad.sdk.utils.j.b(((com.kwad.sdk.feed.widget.base.a) this.f72739a).f72749b);
                        this.f72739a.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this.f72739a).f72749b));
                        this.f72739a.m.a();
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            super.a(adTemplate);
            this.f72731f.setText(com.kwad.sdk.core.response.b.a.m(((com.kwad.sdk.feed.widget.base.a) this).f72750c));
            this.f72734i.a(adTemplate);
            if (com.kwad.sdk.core.response.b.a.v(((com.kwad.sdk.feed.widget.base.a) this).f72750c)) {
                g();
            } else {
                d();
            }
            this.f72733h.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b();
            com.kwad.sdk.utils.j.a(((com.kwad.sdk.feed.widget.base.a) this).f72749b);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f72731f = (TextView) findViewById(R.id.ksad_ad_desc);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.f72732g = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f72733h = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.k = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.f72734i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
            this.o = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.e();
            if (this.p) {
                com.kwad.sdk.utils.b.a(getContext()).a(false);
                if (com.kwad.sdk.utils.b.a(getContext()).a()) {
                    this.p = false;
                    this.m.setVideoSoundEnable(false);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.f72733h) {
                m();
            } else {
                a(this.m, view == this.o);
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || (bVar = this.m) == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) bVar.getParent();
            if (this.m.getParent() != this.f72732g) {
                viewGroup.removeView(this.m);
                if (this.f72732g.getTag() != null) {
                    RatioFrameLayout ratioFrameLayout = this.f72732g;
                    ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                    this.f72732g.setTag(null);
                }
                this.f72732g.addView(this.m);
                this.f72732g.setTag(this.m);
                String a2 = com.kwad.sdk.core.response.b.a.a(((com.kwad.sdk.feed.widget.base.a) this).f72750c);
                this.m.setVideoSoundEnable(this.p);
                this.n.setVideoPlayCallback(this.f72730a);
                this.n.setVideoClickListener(this.s);
                this.n.o();
                this.n.setAutoRelease(true);
                AdVideoPlayerViewCache.a().a(a2);
            }
        }
    }
}
