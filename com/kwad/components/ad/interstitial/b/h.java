package com.kwad.components.ad.interstitial.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.y;
import com.kwad.sdk.widget.KSFrameLayout;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class h extends b implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Context a;
    public AdInfo b;
    public c c;
    public AdTemplate d;
    public KSFrameLayout e;
    public KSFrameLayout f;
    @Nullable
    public boolean g;
    public List<Integer> h;
    public com.kwad.sdk.core.video.videoview.a i;
    @NonNull
    public KsAdVideoPlayConfig j;
    public ImageView k;
    public com.kwad.components.core.c.a.b l;
    public com.kwad.components.core.video.d m;
    public final a.InterfaceC0518a n;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.n = new a.InterfaceC0518a(this) { // from class: com.kwad.components.ad.interstitial.b.h.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.a.InterfaceC0518a
            public final void a(int i3, y.a aVar) {
                int i4;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, aVar) == null) {
                    int i5 = 2;
                    boolean z = false;
                    if (i3 == 1) {
                        i4 = 13;
                    } else if (i3 == 2) {
                        i4 = 82;
                    } else if (i3 != 3) {
                        i4 = 108;
                    } else {
                        i4 = 83;
                        i5 = 1;
                        z = true;
                    }
                    u.b bVar = new u.b();
                    bVar.i = aVar;
                    bVar.c = i4;
                    com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this.a.i)).a(this.a.d).a(this.a.l).a(i5).a(z).c(true).a(bVar).a(new a.b(this) { // from class: com.kwad.components.ad.interstitial.b.h.2.1
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
                                int i6 = newInitContext2.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.components.core.c.a.a.b
                        public final void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.a.a.h();
                            }
                        }
                    }));
                }
            }
        };
    }

    private c.b a(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, this, view2, z)) == null) ? new c.b(view2.getContext()).a(z).a(this.e.getTouchCoords()).a(3).b(85) : (c.b) invokeLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.h;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.h.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.d, ceil, (JSONObject) null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void g() {
        ImageView imageView;
        int i;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.g = this.j.isVideoSoundEnable();
            String a = com.kwad.sdk.core.response.a.a.ae(this.b).a();
            if (TextUtils.isEmpty(a)) {
                imageView = this.k;
                i = 8;
            } else {
                this.k.setImageDrawable(null);
                KSImageLoader.loadImage(this.k, a, this.d);
                imageView = this.k;
                i = 0;
            }
            imageView.setVisibility(i);
            int J = com.kwad.sdk.core.config.d.J();
            if (J < 0) {
                File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.b(this.b));
                b = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
            } else {
                b = J == 0 ? com.kwad.sdk.core.response.a.a.b(this.b) : com.kwad.sdk.core.videocache.b.a.a(this.a).a(com.kwad.sdk.core.response.a.a.b(this.b));
            }
            if (TextUtils.isEmpty(b)) {
                return;
            }
            this.i.a(new b.a(this.d).a(b).b(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.j(this.d))).a(this.d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.d, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.i.setVideoSoundEnable(this.g);
            this.m.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.components.ad.interstitial.b.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h a;
                public boolean b;

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
                    this.a = this;
                    this.b = false;
                }

                @Override // com.kwad.components.core.video.a.b
                public final void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(1048576, this, j) == null) {
                        this.a.a(j);
                        for (a.b bVar : this.a.c.k) {
                            bVar.a(j);
                        }
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void f_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.h(this.a.d);
                        if (!this.a.c.h && this.a.c.b != null) {
                            this.a.c.b.onVideoPlayStart();
                        }
                        for (a.b bVar : this.a.c.k) {
                            bVar.f_();
                        }
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void g_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.b) {
                            this.b = true;
                            com.kwad.components.core.i.a.a().a(this.a.d, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.a.c.k) {
                            bVar.g_();
                        }
                    }
                }

                @Override // com.kwad.components.core.video.a.b
                public final void h_() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.a.d);
                        if (!this.a.c.h && this.a.c.b != null) {
                            this.a.c.b.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.a.c.k) {
                            bVar.h_();
                        }
                    }
                }
            });
            this.i.setController(this.m);
            this.f.setClickable(true);
            new com.kwad.sdk.widget.f(this.f.getContext(), this.f, this);
            this.f.addView(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            c cVar = this.c;
            if (!cVar.h && (adInteractionListener = cVar.b) != null) {
                adInteractionListener.onAdClicked();
            }
            c cVar2 = this.c;
            cVar2.f = true;
            if (cVar2.h) {
                return;
            }
            cVar2.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            c cVar = (c) t();
            this.c = cVar;
            this.j = cVar.j;
            AdTemplate adTemplate = cVar.a;
            this.d = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            this.b = i;
            List<Integer> Z = com.kwad.sdk.core.response.a.a.Z(i);
            this.h = Z;
            com.kwad.sdk.core.video.videoview.a aVar = this.c.l;
            this.i = aVar;
            aVar.setTag(Z);
            com.kwad.components.core.video.d dVar = new com.kwad.components.core.video.d(this.a, this.d, this.i);
            this.m = dVar;
            dVar.setDataFlowAutoStart(this.j.isDataFlowAutoStart());
            this.m.setAdClickListener(this.n);
            this.m.l();
            this.l = this.c.d;
            g();
            float dimension = u().getResources().getDimension(R.dimen.obfuscated_res_0x7f070374);
            this.f.a(dimension, dimension, 0.0f, 0.0f);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.c.a(a(view2, true));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.c.a(a(view2, false));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e_();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.i_();
            this.e = (KSFrameLayout) q().findViewById(R.id.obfuscated_res_0x7f09101b);
            this.f = (KSFrameLayout) q().findViewById(R.id.obfuscated_res_0x7f0911c3);
            this.k = (ImageView) q().findViewById(R.id.obfuscated_res_0x7f0911d3);
            this.f.setVisibility(4);
            this.a = u();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.k_();
        }
    }
}
