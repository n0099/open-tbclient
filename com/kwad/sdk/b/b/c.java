package com.kwad.sdk.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.b.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f71573b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f71574c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f71575d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f71576e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f71577f;

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
        this.f71576e = false;
        this.f71577f = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f71578a;

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
                this.f71578a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f71578a.a(j3);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f71578a.f71576e = false;
                    if (!this.f71578a.f71573b.mPvReported) {
                        ((com.kwad.sdk.b.a.a) this.f71578a).f71544a.f71545a.onAdShow(null);
                    }
                    com.kwad.sdk.core.report.a.a(this.f71578a.f71573b, (JSONObject) null);
                    com.kwad.sdk.core.report.a.i(this.f71578a.f71573b);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f71578a.f71576e) {
                    return;
                }
                this.f71578a.f71576e = true;
                com.kwad.sdk.core.report.d.a(this.f71578a.f71573b, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    com.kwad.sdk.core.report.a.j(this.f71578a.f71573b);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f71575d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f71575d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f71573b, ceil, null);
                    this.f71575d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.b.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.b.a.a) this).f71544a.f71548d;
            this.f71573b = adTemplate;
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f71574c = i2;
            this.f71575d = com.kwad.sdk.core.response.b.a.I(i2);
            ((com.kwad.sdk.b.a.a) this).f71544a.f71550f.a(this.f71577f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((com.kwad.sdk.b.a.a) this).f71544a.f71550f.b(this.f71577f);
        }
    }
}
