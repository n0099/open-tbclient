package com.kwad.sdk.d.kwai;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.p;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.z;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class g extends b implements com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f58870b;

    /* renamed from: c  reason: collision with root package name */
    public c f58871c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f58872d;

    /* renamed from: e  reason: collision with root package name */
    public KSFrameLayout f58873e;

    /* renamed from: f  reason: collision with root package name */
    public KSFrameLayout f58874f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f58875g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f58876h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f58877i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f58878j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public KsAdVideoPlayConfig f58879k;
    public ImageView l;
    public com.kwad.sdk.core.download.a.b m;
    public com.kwad.sdk.d.a.c n;
    public final a.InterfaceC2088a o;

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
        this.f58876h = false;
        this.o = new a.InterfaceC2088a(this) { // from class: com.kwad.sdk.d.kwai.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC2088a
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
                    aVar2.f58267g = aVar;
                    aVar2.f58262b = i5;
                    com.kwad.sdk.core.download.a.a.a(new a.C2076a(bb.a(this.a.f58878j)).a(this.a.f58872d).a(this.a.m).a(i6).a(z).c(true).a(aVar2).a(new a.b(this) { // from class: com.kwad.sdk.d.kwai.g.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this};
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
                                this.a.a.f();
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
            List<Integer> list = this.f58877i;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f58877i.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f58872d, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i2;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f58876h = this.f58879k.isVideoSoundEnable();
            String a2 = com.kwad.sdk.core.response.a.a.aa(this.f58870b).a();
            if (TextUtils.isEmpty(a2)) {
                imageView = this.l;
                i2 = 8;
            } else {
                this.l.setImageDrawable(null);
                KSImageLoader.loadImage(this.l, a2, this.f58872d);
                imageView = this.l;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            int C = com.kwad.sdk.core.config.b.C();
            if (C < 0) {
                File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.a(this.f58870b));
                a = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
            } else {
                a = C == 0 ? com.kwad.sdk.core.response.a.a.a(this.f58870b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.a(this.f58870b));
            }
            if (TextUtils.isEmpty(a)) {
                return;
            }
            this.f58878j.a(new c.a(this.f58872d).a(a).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.k(this.f58872d))).a(this.f58872d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f58872d, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.f58878j.setVideoSoundEnable(this.f58876h);
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.d.kwai.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ g a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f58880b;

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
                    this.f58880b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j2) == null) {
                        this.a.a(j2);
                        for (a.b bVar : this.a.f58871c.f58836h) {
                            bVar.a(j2);
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.a.f58872d);
                        if (this.a.f58871c.f58830b != null) {
                            this.a.f58871c.f58830b.onVideoPlayStart();
                        }
                        for (a.b bVar : this.a.f58871c.f58836h) {
                            bVar.b_();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.f58880b) {
                            this.f58880b = true;
                            com.kwad.sdk.core.report.d.a(this.a.f58872d, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.a.f58871c.f58836h) {
                            bVar.e();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.j(this.a.f58872d);
                        if (this.a.f58871c.f58830b != null) {
                            this.a.f58871c.f58830b.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.a.f58871c.f58836h) {
                            bVar.f();
                        }
                    }
                }
            });
            this.f58878j.setController(this.n);
            this.f58874f.setClickable(true);
            new com.kwad.sdk.widget.f(this.f58874f.getContext(), this.f58874f, this);
            this.f58874f.addView(this.f58878j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (adInteractionListener = this.f58871c.f58830b) == null) {
            return;
        }
        adInteractionListener.onAdClicked();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) p();
            this.f58871c = cVar;
            this.f58875g = cVar.f58831c;
            this.f58879k = cVar.f58835g;
            AdTemplate adTemplate = cVar.a;
            this.f58872d = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f58870b = j2;
            List<Integer> S = com.kwad.sdk.core.response.a.a.S(j2);
            this.f58877i = S;
            com.kwad.sdk.core.video.videoview.b bVar = this.f58871c.f58837i;
            this.f58878j = bVar;
            bVar.setTag(S);
            com.kwad.sdk.d.a.c cVar2 = new com.kwad.sdk.d.a.c(this.a, this.f58872d, this.f58878j);
            this.n = cVar2;
            cVar2.setDataFlowAutoStart(this.f58879k.isDataFlowAutoStart());
            this.n.setAdClickListener(this.o);
            this.n.j();
            this.m = this.f58871c.f58832d;
            e();
            float dimension = q().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
            this.f58874f.a(dimension, dimension, 0.0f, 0.0f);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            this.f58871c.a(view, false, 3, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.f58871c.a)) {
            this.f58871c.a(view, false, 3, false);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c_();
            this.f58873e = (KSFrameLayout) m().findViewById(R.id.ksad_container);
            this.f58874f = (KSFrameLayout) m().findViewById(R.id.ksad_video_container);
            this.l = (ImageView) m().findViewById(R.id.ksad_video_first_frame_container);
            this.f58874f.setVisibility(4);
            this.a = q();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d_();
        }
    }
}
