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
/* loaded from: classes10.dex */
public class c extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public Context f70998a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f70999b;

    /* renamed from: c  reason: collision with root package name */
    public a f71000c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f71001d;

    /* renamed from: e  reason: collision with root package name */
    public RatioFrameLayout f71002e;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f71003f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f71004g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f71005h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f71006i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f71007j;
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
        this.f71005h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f71006i;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f71006i.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f71001d, ceil, null);
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
            this.f71005h = this.k.isVideoSoundEnable();
            String a3 = com.kwad.sdk.core.response.b.a.T(this.f70999b).a();
            if (TextUtils.isEmpty(a3)) {
                imageView = this.l;
                i2 = 8;
            } else {
                this.l.setImageDrawable(null);
                KSImageLoader.loadImage(this.l, a3, this.f71001d);
                imageView = this.l;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            int C = com.kwad.sdk.core.config.c.C();
            if (C < 0) {
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(com.kwad.sdk.core.response.b.a.a(this.f70999b));
                a2 = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
            } else {
                a2 = C == 0 ? com.kwad.sdk.core.response.b.a.a(this.f70999b) : com.kwad.sdk.core.videocache.c.a.a(this.f70998a).a(com.kwad.sdk.core.response.b.a.a(this.f70999b));
            }
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.f71007j.a(new c.a().a(a2).b(e.b(com.kwad.sdk.core.response.b.c.j(this.f71001d))).a(this.f71001d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f71001d, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.f71007j.setVideoSoundEnable(this.f71005h);
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.a.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f71008a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f71009b;

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
                    this.f71008a = this;
                    this.f71009b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.f71008a.f71001d);
                        if (this.f71008a.f71000c.f70967b != null) {
                            this.f71008a.f71000c.f70967b.onVideoPlayStart();
                        }
                        for (a.b bVar : this.f71008a.f71000c.f70972g) {
                            bVar.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f71008a.a(j2);
                        for (a.b bVar : this.f71008a.f71000c.f70972g) {
                            bVar.a(j2);
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.f71009b) {
                            this.f71009b = true;
                            com.kwad.sdk.core.report.d.a(this.f71008a.f71001d, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.f71008a.f71000c.f70972g) {
                            bVar.b();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f71008a.n.g();
                        com.kwad.sdk.core.report.a.j(this.f71008a.f71001d);
                        if (this.f71008a.f71000c.f70967b != null) {
                            this.f71008a.f71000c.f70967b.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.f71008a.f71000c.f70972g) {
                            bVar.c();
                        }
                    }
                }
            });
            this.f71007j.setController(this.n);
            this.f71003f.setClickable(true);
            this.f71003f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f71010a;

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
                    this.f71010a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71010a.f71000c.a(view, false);
                    }
                }
            });
            this.f71003f.addView(this.f71007j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f71000c = aVar;
            this.f71004g = aVar.f70968c;
            this.k = aVar.f70971f;
            AdTemplate adTemplate = aVar.f70966a;
            this.f71001d = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f70999b = i2;
            List<Integer> I = com.kwad.sdk.core.response.b.a.I(i2);
            this.f71006i = I;
            com.kwad.sdk.core.video.videoview.b bVar = this.f71000c.f70973h;
            this.f71007j = bVar;
            bVar.setTag(I);
            com.kwad.sdk.a.b.c cVar = new com.kwad.sdk.a.b.c(this.f70998a, this.f71001d, this.f71007j);
            this.n = cVar;
            cVar.setDataFlowAutoStart(true);
            this.n.i();
            this.m = this.f71000c.f70969d;
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f71002e = (RatioFrameLayout) j().findViewById(R.id.ksad_container);
            this.f71003f = (RatioFrameLayout) j().findViewById(R.id.ksad_video_container);
            this.l = (ImageView) j().findViewById(R.id.ksad_video_first_frame_container);
            this.f71003f.setVisibility(4);
            this.f70998a = m();
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
