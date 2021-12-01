package com.kwad.sdk.draw.a.kwai;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.k;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.draw.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f58362b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f58363c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f58364d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58365e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f58366f;

    /* renamed from: g  reason: collision with root package name */
    public k f58367g;

    /* renamed from: h  reason: collision with root package name */
    public d f58368h;

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
        this.f58365e = false;
        this.f58366f = false;
        this.f58367g = new k(this) { // from class: com.kwad.sdk.draw.a.kwai.a.1
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
                    m.c(this.a.f58362b);
                }
            }
        };
        this.f58368h = new e(this) { // from class: com.kwad.sdk.draw.a.kwai.a.2
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

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i4, i5) == null) {
                    super.a(i4, i5);
                    if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.a.a(j3);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.f58366f = false;
                    if (!this.a.f58362b.mPvReported && ((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onAdShow();
                    }
                    if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                        this.a.f58365e = false;
                    }
                    com.kwad.sdk.core.report.a.a(this.a.f58362b, (JSONObject) null);
                    com.kwad.sdk.core.report.a.i(this.a.f58362b);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.d();
                    if (!this.a.f58365e) {
                        if (this.a.f58366f) {
                            return;
                        }
                        this.a.f58366f = true;
                        com.kwad.sdk.core.report.d.a(this.a.f58362b, System.currentTimeMillis(), 1);
                        return;
                    }
                    this.a.f58365e = false;
                    if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onVideoPlayResume();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.e();
                    if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                    this.a.f58365e = true;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    com.kwad.sdk.core.report.a.j(this.a.f58362b);
                    if (((com.kwad.sdk.draw.kwai.a) this.a).a.a != null) {
                        try {
                            ((com.kwad.sdk.draw.kwai.a) this.a).a.a.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f58364d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f58364d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f58362b, ceil, null);
                    this.f58364d.remove(num);
                    return;
                }
            }
        }
    }

    private void a(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, kVar) == null) {
            View m = m();
            if (m instanceof AdBasePvFrameLayout) {
                ((AdBasePvFrameLayout) m).setVisibleListener(kVar);
            }
        }
    }

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.kwai.a) this).a.f58379c;
            this.f58362b = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f58363c = j2;
            this.f58364d = com.kwad.sdk.core.response.a.a.S(j2);
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.a(this.f58368h);
            a(this.f58367g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.draw.kwai.a) this).a.f58381e.b(this.f58368h);
            a((k) null);
        }
    }
}
