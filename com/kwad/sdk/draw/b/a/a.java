package com.kwad.sdk.draw.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f37052b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f37053c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f37054d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37055e;

    /* renamed from: f  reason: collision with root package name */
    public e f37056f;

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
        this.f37055e = false;
        this.f37056f = new f(this) { // from class: com.kwad.sdk.draw.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f37057a;

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
                this.f37057a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    b.i(this.f37057a.f37052b);
                    if (((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onVideoPlayEnd();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    super.a(i4, i5);
                    if (((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onVideoPlayError();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f37057a.a(j2);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    if (!this.f37057a.f37052b.mPvReported && ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                        ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onAdShow();
                    }
                    if (((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onVideoPlayStart();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                        this.f37057a.f37055e = false;
                    }
                    b.a(this.f37057a.f37052b, (JSONObject) null);
                    b.h(this.f37057a.f37052b);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.c();
                    if (((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                        try {
                            ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onVideoPlayPause();
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                    this.f37057a.f37055e = true;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.d();
                    if (this.f37057a.f37055e) {
                        this.f37057a.f37055e = false;
                        if (((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a != null) {
                            try {
                                ((com.kwad.sdk.draw.a.a) this.f37057a).f37034a.f37035a.onVideoPlayResume();
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.a.b(th);
                            }
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
            List<Integer> list = this.f37054d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f37054d) {
                if (ceil >= num.intValue()) {
                    b.b(this.f37052b, ceil, null);
                    this.f37054d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.draw.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.draw.a.a) this).f37034a.f37037c;
            this.f37052b = adTemplate;
            AdInfo j = c.j(adTemplate);
            this.f37053c = j;
            this.f37054d = com.kwad.sdk.core.response.b.a.M(j);
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37039e.a(this.f37056f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.draw.a.a) this).f37034a.f37039e.b(this.f37056f);
        }
    }
}
