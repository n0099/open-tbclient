package com.kwad.sdk.feed.widget;

import android.content.Context;
import android.content.DialogInterface;
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
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.DownloadProgressView;
import com.kwad.sdk.widget.KsLogoView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class a extends com.kwad.sdk.feed.widget.base.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b a;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58517f;

    /* renamed from: g  reason: collision with root package name */
    public RatioFrameLayout f58518g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58519h;

    /* renamed from: i  reason: collision with root package name */
    public KsLogoView f58520i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f58521j;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f58522k;
    public List<Integer> l;
    public com.kwad.sdk.core.video.videoview.b m;
    public j n;
    public DownloadProgressView o;
    public boolean p;
    public volatile boolean q;
    public com.kwad.sdk.widget.k r;
    public final a.InterfaceC2027a s;

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
        this.r = new com.kwad.sdk.widget.k(this) { // from class: com.kwad.sdk.feed.widget.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.widget.k
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    m.c(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                }
            }
        };
        this.a = new a.b(this) { // from class: com.kwad.sdk.feed.widget.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void a(long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                    this.a.a(j2);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void b_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.q = false;
                    com.kwad.sdk.core.report.a.i(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                    if (this.a.m == null || this.a.m.getParent() != this.a.f58518g) {
                        return;
                    }
                    this.a.m.setVideoSoundEnable(this.a.p);
                }
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void e() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.q) {
                    return;
                }
                this.a.q = true;
                com.kwad.sdk.core.report.d.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.core.video.videoview.a.b
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.report.a.j(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                }
            }
        };
        this.s = new a.InterfaceC2027a(this) { // from class: com.kwad.sdk.feed.widget.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2027a
            public void a(int i4, z.a aVar) {
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, aVar) == null) {
                    int i6 = 2;
                    boolean z = false;
                    if (i4 == 1) {
                        i5 = 13;
                    } else if (i4 == 2) {
                        i5 = 82;
                    } else if (i4 != 3) {
                        i5 = 108;
                    } else {
                        i5 = 83;
                        i6 = 1;
                        z = true;
                    }
                    p.a aVar2 = new p.a();
                    aVar2.f57686g = aVar;
                    aVar2.f57681b = i5;
                    com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this.a.m)).a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b).a(this.a.f58521j).a(i6).a(z).c(true).e(true).a(aVar2).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.a.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass3 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i7 = newInitContext2.flag;
                                if ((i7 & 1) != 0) {
                                    int i8 = i7 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.sdk.core.download.a.a.b
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.l();
                            }
                        }
                    }));
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
                    com.kwad.sdk.core.report.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, ceil, null);
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
        String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
        this.n.setAutoRelease(false);
        int i2 = z ? 1 : 2;
        AdVideoPlayerViewCache.a().a(a, this.m);
        com.kwad.sdk.core.download.a.a.a(new a.C2015a(bb.a(this)).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(this.f58521j).a(z).a(i2).e(true).a(new a.b(this) { // from class: com.kwad.sdk.feed.widget.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.k();
                }
            }
        }));
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            TextView textView = (TextView) findViewById(R.id.ksad_h5_open_btn);
            ((TextView) findViewById(R.id.ksad_h5_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
            textView.setText(com.kwad.sdk.core.response.a.a.A(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
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
            ((TextView) findViewById(R.id.ksad_app_title)).setText(com.kwad.sdk.core.response.a.a.t(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
            imageView.setImageResource(R.drawable.ksad_default_app_icon);
            KSImageLoader.loadAppIcon(imageView, com.kwad.sdk.core.response.a.a.au(((com.kwad.sdk.feed.widget.base.a) this).f58529c), ((com.kwad.sdk.feed.widget.base.a) this).f58528b, 8);
            ((TextView) findViewById(R.id.ksad_app_desc)).setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
            this.o.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
            this.o.setOnClickListener(this);
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((com.kwad.sdk.feed.widget.base.a) this).f58528b, null, this.o.getAppDownloadListener());
            this.f58521j = bVar;
            bVar.c(this.o.getAppDownloadListener());
            this.f58521j.a((DialogInterface.OnShowListener) this);
            this.f58521j.a((DialogInterface.OnDismissListener) this);
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
            String a = com.kwad.sdk.core.response.a.a.aa(((com.kwad.sdk.feed.widget.base.a) this).f58529c).a();
            if (TextUtils.isEmpty(a)) {
                imageView = this.f58522k;
                i2 = 8;
            } else {
                this.f58522k.setImageDrawable(null);
                KSImageLoader.loadImage(this.f58522k, a, ((com.kwad.sdk.feed.widget.base.a) this).f58528b);
                imageView = this.f58522k;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            this.l = com.kwad.sdk.core.response.a.a.S(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            com.kwad.sdk.core.video.videoview.b bVar = new com.kwad.sdk.core.video.videoview.b(((com.kwad.sdk.feed.widget.base.a) this).f58531e);
            this.m = bVar;
            bVar.setVisibleListener(this.r);
            this.m.setTag(this.l);
            String a2 = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.m.a(new c.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b).a(a2).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(((com.kwad.sdk.feed.widget.base.a) this).f58528b))).a(((com.kwad.sdk.feed.widget.base.a) this).f58528b.mVideoPlayerStatus).a(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b)).a(), (Map<String, String>) null);
            this.m.setVideoSoundEnable(this.p);
            j jVar = new j(((com.kwad.sdk.feed.widget.base.a) this).f58531e, ((com.kwad.sdk.feed.widget.base.a) this).f58528b, this.m);
            this.n = jVar;
            jVar.setVideoPlayCallback(this.a);
            this.n.setAdClickListener(this.s);
            this.n.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.m.setController(this.n);
            if (this.f58518g.getTag() != null) {
                RatioFrameLayout ratioFrameLayout = this.f58518g;
                ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                this.f58518g.setTag(null);
            }
            this.f58518g.addView(this.m);
            this.f58518g.setTag(this.m);
            this.f58518g.setClickable(true);
            this.f58518g.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.feed.widget.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.a.m.d()) {
                            a aVar = this.a;
                            aVar.a(aVar.m, false);
                            return;
                        }
                        m.b(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b);
                        this.a.m.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(((com.kwad.sdk.feed.widget.base.a) this.a).f58528b));
                        this.a.m.a();
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
            this.f58517f.setText(com.kwad.sdk.core.response.a.a.s(((com.kwad.sdk.feed.widget.base.a) this).f58529c));
            this.f58520i.a(adTemplate);
            if (com.kwad.sdk.core.response.a.a.B(((com.kwad.sdk.feed.widget.base.a) this).f58529c)) {
                g();
            } else {
                d();
            }
            this.f58519h.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a, com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b();
            m.a(((com.kwad.sdk.feed.widget.base.a) this).f58528b);
        }
    }

    @Override // com.kwad.sdk.feed.widget.base.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f58517f = (TextView) findViewById(R.id.ksad_ad_desc);
            RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
            this.f58518g = ratioFrameLayout;
            ratioFrameLayout.setRatio(0.56f);
            this.f58519h = (ImageView) findViewById(R.id.ksad_ad_dislike);
            this.f58522k = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.f58520i = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
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
            if (view == this.f58519h) {
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
            if (this.m.getParent() != this.f58518g) {
                viewGroup.removeView(this.m);
                if (this.f58518g.getTag() != null) {
                    RatioFrameLayout ratioFrameLayout = this.f58518g;
                    ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
                    this.f58518g.setTag(null);
                }
                this.f58518g.addView(this.m);
                this.f58518g.setTag(this.m);
                String a = com.kwad.sdk.core.response.a.a.a(((com.kwad.sdk.feed.widget.base.a) this).f58529c);
                this.m.setVideoSoundEnable(this.p);
                this.n.setVideoPlayCallback(this.a);
                this.n.setAdClickListener(this.s);
                this.n.getAdTemplate().mAdWebVideoPageShowing = false;
                this.n.p();
                this.n.setAutoRelease(true);
                AdVideoPlayerViewCache.a().a(a);
            }
        }
    }
}
