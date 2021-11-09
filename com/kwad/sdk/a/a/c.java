package com.kwad.sdk.a.a;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.feed.widget.base.RatioFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f63834a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f63835b;

    /* renamed from: c  reason: collision with root package name */
    public a f63836c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f63837d;

    /* renamed from: e  reason: collision with root package name */
    public RatioFrameLayout f63838e;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f63839f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f63840g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f63841h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f63842i;
    public com.kwad.sdk.core.video.videoview.b j;
    @NonNull
    public KsAdVideoPlayConfig k;
    public ImageView l;
    public com.kwad.sdk.core.download.b.b m;
    public com.kwad.sdk.a.b.c n;

    public c() {
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
        this.f63841h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f63842i;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f63842i.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f63837d, ceil, null);
                    it.remove();
                    return;
                }
            }
        }
    }

    private void e() {
        ImageView imageView;
        int i2;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            this.f63841h = this.k.isVideoSoundEnable();
            String a3 = com.kwad.sdk.core.response.b.a.T(this.f63835b).a();
            if (TextUtils.isEmpty(a3)) {
                imageView = this.l;
                i2 = 8;
            } else {
                this.l.setImageDrawable(null);
                KSImageLoader.loadImage(this.l, a3, this.f63837d);
                imageView = this.l;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            int C = com.kwad.sdk.core.config.c.C();
            if (C < 0) {
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(com.kwad.sdk.core.response.b.a.a(this.f63835b));
                a2 = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
            } else {
                a2 = C == 0 ? com.kwad.sdk.core.response.b.a.a(this.f63835b) : com.kwad.sdk.core.videocache.c.a.a(this.f63834a).a(com.kwad.sdk.core.response.b.a.a(this.f63835b));
            }
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.j.a(new c.a().a(a2).b(e.b(com.kwad.sdk.core.response.b.c.j(this.f63837d))).a(this.f63837d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f63837d, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.j.setVideoSoundEnable(this.f63841h);
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.a.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f63843a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f63844b;

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
                    this.f63843a = this;
                    this.f63844b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.f63843a.f63837d);
                        if (this.f63843a.f63836c.f63805b != null) {
                            this.f63843a.f63836c.f63805b.onVideoPlayStart();
                        }
                        for (a.b bVar : this.f63843a.f63836c.f63810g) {
                            bVar.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                        this.f63843a.a(j);
                        for (a.b bVar : this.f63843a.f63836c.f63810g) {
                            bVar.a(j);
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.f63844b) {
                            this.f63844b = true;
                            com.kwad.sdk.core.report.d.a(this.f63843a.f63837d, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.f63843a.f63836c.f63810g) {
                            bVar.b();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f63843a.n.g();
                        com.kwad.sdk.core.report.a.j(this.f63843a.f63837d);
                        if (this.f63843a.f63836c.f63805b != null) {
                            this.f63843a.f63836c.f63805b.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.f63843a.f63836c.f63810g) {
                            bVar.c();
                        }
                    }
                }
            });
            this.j.setController(this.n);
            this.f63839f.setClickable(true);
            this.f63839f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f63845a;

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
                    this.f63845a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f63845a.f63836c.a(view, false);
                    }
                }
            });
            this.f63839f.addView(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f63836c = aVar;
            this.f63840g = aVar.f63806c;
            this.k = aVar.f63809f;
            AdTemplate adTemplate = aVar.f63804a;
            this.f63837d = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f63835b = i2;
            List<Integer> I = com.kwad.sdk.core.response.b.a.I(i2);
            this.f63842i = I;
            com.kwad.sdk.core.video.videoview.b bVar = this.f63836c.f63811h;
            this.j = bVar;
            bVar.setTag(I);
            com.kwad.sdk.a.b.c cVar = new com.kwad.sdk.a.b.c(this.f63834a, this.f63837d, this.j);
            this.n = cVar;
            cVar.setDataFlowAutoStart(true);
            this.n.i();
            this.m = this.f63836c.f63807d;
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f63838e = (RatioFrameLayout) j().findViewById(R.id.ksad_container);
            this.f63839f = (RatioFrameLayout) j().findViewById(R.id.ksad_video_container);
            this.l = (ImageView) j().findViewById(R.id.ksad_video_first_frame_container);
            this.f63839f.setVisibility(4);
            this.f63834a = m();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
        }
    }
}
