package com.kwad.sdk.reward.widget;

import android.app.Activity;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.j;
import com.kwad.sdk.reward.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static j.b a(j.a aVar, com.kwad.sdk.reward.a aVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, aVar, aVar2)) == null) {
            Activity activity = aVar2.f58875h;
            com.kwad.sdk.reward.c.a aVar3 = aVar2.f58878k;
            AdTemplate adTemplate = aVar2.f58874g;
            return new j.c(aVar3, aVar, adTemplate, aVar2.f58872e, d.j(adTemplate), activity, aVar2) { // from class: com.kwad.sdk.reward.widget.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.reward.c.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ j.a f59294b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f59295c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ JSONObject f59296d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdInfo f59297e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ Activity f59298f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.reward.a f59299g;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar3, aVar, adTemplate, r9, r10, activity, aVar2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar3;
                    this.f59294b = aVar;
                    this.f59295c = adTemplate;
                    this.f59296d = r9;
                    this.f59297e = r10;
                    this.f59298f = activity;
                    this.f59299g = aVar2;
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.c();
                        if (this.f59294b.a() == 0) {
                            com.kwad.sdk.core.report.a.j(this.f59295c, this.f59296d);
                        } else {
                            com.kwad.sdk.core.report.a.c(this.f59295c, Opcodes.FCMPL, this.f59296d);
                        }
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.f(this.f59295c, (int) Opcodes.DCMPL);
                        if (com.kwad.sdk.core.response.a.a.aG(this.f59297e)) {
                            this.f59298f.finish();
                            return;
                        }
                        com.kwad.sdk.core.report.a.a(this.f59295c, (int) (com.kwad.sdk.core.response.a.a.o(this.f59297e) / 1000), (int) (this.a.h() / 1000));
                        this.f59299g.u = true;
                        this.a.a(true);
                        k.a(this.f59299g);
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.b();
                        if (this.f59294b.a() == 1 || this.f59294b.a() == 2) {
                            com.kwad.sdk.core.report.a.f(this.f59295c, 150);
                        } else {
                            com.kwad.sdk.core.report.a.k(this.f59295c, this.f59296d);
                        }
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        super.d();
                        com.kwad.sdk.core.report.a.f(this.f59295c, 150);
                        com.kwad.sdk.reward.a aVar4 = this.f59299g;
                        aVar4.a(aVar4.f58876i, 156, 1);
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        super.e();
                        com.kwad.sdk.core.report.a.f(this.f59295c, 150);
                        com.kwad.sdk.reward.a aVar4 = this.f59299g;
                        aVar4.a(aVar4.f58876i, 156, 1);
                    }
                }
            };
        }
        return (j.b) invokeLL.objValue;
    }

    public static void a(com.kwad.sdk.reward.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            Activity activity = aVar.f58875h;
            AdTemplate adTemplate = aVar.f58874g;
            AdInfo j2 = d.j(adTemplate);
            long b2 = com.kwad.sdk.core.response.a.a.b(j2) * 1000;
            long n = com.kwad.sdk.core.response.a.a.n(j2);
            String str = "观看完整视频即可获取奖励";
            if (n > 0 && b2 > n) {
                str = "观看视频" + n + "s即可获取奖励";
            }
            j.a a = j.a(adTemplate, str, aVar.y, aVar.z);
            j.a(activity, adTemplate, a, a(a, aVar));
        }
    }
}
