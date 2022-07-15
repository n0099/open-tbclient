package com.kwad.components.ad.draw.a.kwai;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.l.c;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate b;
    public AdInfo c;
    public List<Integer> d;
    public boolean e;
    public volatile boolean f;
    public j g;
    public g h;

    public a() {
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
        this.e = false;
        this.f = false;
        this.g = new j(this) { // from class: com.kwad.components.ad.draw.a.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.sdk.widget.j
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    k.c(this.a.b);
                }
            }
        };
        this.h = new h(this) { // from class: com.kwad.components.ad.draw.a.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onVideoPlayPause();
                        } catch (Throwable th) {
                            b.b(th);
                        }
                    }
                    this.a.e = true;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    super.a(i3, i4);
                    if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onVideoPlayError();
                        } catch (Throwable th) {
                            b.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.a.a(j2);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.b();
                    if (!this.a.e) {
                        if (this.a.f) {
                            return;
                        }
                        this.a.f = true;
                        com.kwad.components.core.i.a.a().a(this.a.b, System.currentTimeMillis(), 1);
                        return;
                    }
                    this.a.e = false;
                    if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onVideoPlayResume();
                        } catch (Throwable th) {
                            b.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.f = false;
                    if (!this.a.b.mPvReported && ((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onAdShow();
                    }
                    if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onVideoPlayStart();
                        } catch (Throwable th) {
                            b.b(th);
                        }
                        this.a.e = false;
                    }
                    c.a().a(this.a.b, null, null);
                    com.kwad.sdk.core.report.a.h(this.a.b);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    com.kwad.sdk.core.report.a.i(this.a.b);
                    if (((com.kwad.components.ad.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.components.ad.draw.kwai.a) this.a).a.a.onVideoPlayEnd();
                        } catch (Throwable th) {
                            b.b(th);
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.b, ceil, (JSONObject) null);
                    this.d.remove(num);
                    return;
                }
            }
        }
    }

    private void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, jVar) == null) {
            View q = q();
            if (q instanceof AdBasePvFrameLayout) {
                ((AdBasePvFrameLayout) q).setVisibleListener(jVar);
            }
        }
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.components.ad.draw.kwai.a) this).a.c;
            this.b = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.c = i;
            this.d = com.kwad.sdk.core.response.a.a.Z(i);
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.a(this.h);
            a(this.g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k_();
            ((com.kwad.components.ad.draw.kwai.a) this).a.e.b(this.h);
            a((j) null);
        }
    }
}
