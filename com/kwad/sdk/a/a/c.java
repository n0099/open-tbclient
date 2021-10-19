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
    public Context f71352a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f71353b;

    /* renamed from: c  reason: collision with root package name */
    public a f71354c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f71355d;

    /* renamed from: e  reason: collision with root package name */
    public RatioFrameLayout f71356e;

    /* renamed from: f  reason: collision with root package name */
    public RatioFrameLayout f71357f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f71358g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public boolean f71359h;

    /* renamed from: i  reason: collision with root package name */
    public List<Integer> f71360i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f71361j;
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
        this.f71359h = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f71360i;
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<Integer> it = this.f71360i.iterator();
            while (it.hasNext()) {
                if (ceil >= it.next().intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f71355d, ceil, null);
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
            this.f71359h = this.k.isVideoSoundEnable();
            String a3 = com.kwad.sdk.core.response.b.a.T(this.f71353b).a();
            if (TextUtils.isEmpty(a3)) {
                imageView = this.l;
                i2 = 8;
            } else {
                this.l.setImageDrawable(null);
                KSImageLoader.loadImage(this.l, a3, this.f71355d);
                imageView = this.l;
                i2 = 0;
            }
            imageView.setVisibility(i2);
            int C = com.kwad.sdk.core.config.c.C();
            if (C < 0) {
                File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(com.kwad.sdk.core.response.b.a.a(this.f71353b));
                a2 = (b2 == null || !b2.exists()) ? null : b2.getAbsolutePath();
            } else {
                a2 = C == 0 ? com.kwad.sdk.core.response.b.a.a(this.f71353b) : com.kwad.sdk.core.videocache.c.a.a(this.f71352a).a(com.kwad.sdk.core.response.b.a.a(this.f71353b));
            }
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            this.f71361j.a(new c.a().a(a2).b(e.b(com.kwad.sdk.core.response.b.c.j(this.f71355d))).a(this.f71355d.mVideoPlayerStatus).a(new com.kwad.sdk.contentalliance.detail.video.b(this.f71355d, System.currentTimeMillis())).a(), (Map<String, String>) null);
            this.f71361j.setVideoSoundEnable(this.f71359h);
            this.n.setVideoPlayCallback(new a.b(this) { // from class: com.kwad.sdk.a.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f71362a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f71363b;

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
                    this.f71362a = this;
                    this.f71363b = false;
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.i(this.f71362a.f71355d);
                        if (this.f71362a.f71354c.f71321b != null) {
                            this.f71362a.f71354c.f71321b.onVideoPlayStart();
                        }
                        for (a.b bVar : this.f71362a.f71354c.f71326g) {
                            bVar.a();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void a(long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        this.f71362a.a(j2);
                        for (a.b bVar : this.f71362a.f71354c.f71326g) {
                            bVar.a(j2);
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        if (!this.f71363b) {
                            this.f71363b = true;
                            com.kwad.sdk.core.report.d.a(this.f71362a.f71355d, System.currentTimeMillis(), 0);
                        }
                        for (a.b bVar : this.f71362a.f71354c.f71326g) {
                            bVar.b();
                        }
                    }
                }

                @Override // com.kwad.sdk.core.video.videoview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.f71362a.n.g();
                        com.kwad.sdk.core.report.a.j(this.f71362a.f71355d);
                        if (this.f71362a.f71354c.f71321b != null) {
                            this.f71362a.f71354c.f71321b.onVideoPlayEnd();
                        }
                        for (a.b bVar : this.f71362a.f71354c.f71326g) {
                            bVar.c();
                        }
                    }
                }
            });
            this.f71361j.setController(this.n);
            this.f71357f.setClickable(true);
            this.f71357f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.a.a.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f71364a;

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
                    this.f71364a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f71364a.f71354c.a(view, false);
                    }
                }
            });
            this.f71357f.addView(this.f71361j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            a aVar = (a) l();
            this.f71354c = aVar;
            this.f71358g = aVar.f71322c;
            this.k = aVar.f71325f;
            AdTemplate adTemplate = aVar.f71320a;
            this.f71355d = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f71353b = i2;
            List<Integer> I = com.kwad.sdk.core.response.b.a.I(i2);
            this.f71360i = I;
            com.kwad.sdk.core.video.videoview.b bVar = this.f71354c.f71327h;
            this.f71361j = bVar;
            bVar.setTag(I);
            com.kwad.sdk.a.b.c cVar = new com.kwad.sdk.a.b.c(this.f71352a, this.f71355d, this.f71361j);
            this.n = cVar;
            cVar.setDataFlowAutoStart(true);
            this.n.i();
            this.m = this.f71354c.f71323d;
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f71356e = (RatioFrameLayout) j().findViewById(R.id.ksad_container);
            this.f71357f = (RatioFrameLayout) j().findViewById(R.id.ksad_video_container);
            this.l = (ImageView) j().findViewById(R.id.ksad_video_first_frame_container);
            this.f71357f.setVisibility(4);
            this.f71352a = m();
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
