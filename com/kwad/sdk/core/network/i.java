package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.export.proxy.AdHttpProxy;
/* loaded from: classes7.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public h f36367a;

    public i() {
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
        this.f36367a = null;
    }

    @Override // com.kwad.sdk.core.network.a
    public void a(R r, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, r, cVar) == null) {
            if (cVar == null) {
                com.kwad.sdk.core.d.a.d("Networking", "request responseBase is null");
                h hVar = this.f36367a;
                if (hVar != null) {
                    f fVar = f.f36358a;
                    hVar.a(r, fVar.k, fVar.l);
                }
            } else if (TextUtils.isEmpty(cVar.f36356b) || cVar.f36355a != 200) {
                h hVar2 = this.f36367a;
                if (hVar2 != null) {
                    hVar2.a(r, cVar.f36355a, "网络错误");
                }
            } else {
                try {
                    T b2 = b(cVar.f36356b);
                    if (b2 == null) {
                        h hVar3 = this.f36367a;
                        if (hVar3 != null) {
                            f fVar2 = f.f36359b;
                            hVar3.a(r, fVar2.k, fVar2.l);
                        }
                    } else if (!b2.isResultOk()) {
                        h hVar4 = this.f36367a;
                        if (hVar4 != null) {
                            hVar4.a(r, b2.result, b2.errorMsg);
                        }
                    } else if (!b2.isDataEmpty()) {
                        h hVar5 = this.f36367a;
                        if (hVar5 != null) {
                            hVar5.a(r, b2);
                        }
                    } else {
                        h hVar6 = this.f36367a;
                        if (hVar6 != null) {
                            f fVar3 = f.f36360c;
                            hVar6.a(r, fVar3.k, fVar3.l);
                        }
                    }
                } catch (Exception e2) {
                    h hVar7 = this.f36367a;
                    if (hVar7 != null) {
                        f fVar4 = f.f36359b;
                        hVar7.a(r, fVar4.k, fVar4.l);
                    }
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        }
    }

    public void a(@NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            this.f36367a = hVar;
            d();
        }
    }

    public boolean a_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public abstract T b(String str);

    @Override // com.kwad.sdk.core.network.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.e();
            this.f36367a = null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0059 -> B:29:0x005c). Please submit an issue!!! */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            R b2 = b();
            h hVar = this.f36367a;
            if (hVar != null) {
                hVar.a(b2);
            }
            if (!com.ksad.download.d.b.a(KsAdSDKImpl.get().getContext())) {
                h hVar2 = this.f36367a;
                if (hVar2 != null) {
                    f fVar = f.f36358a;
                    hVar2.a(b2, fVar.k, fVar.l);
                    return;
                }
                return;
            }
            c cVar = null;
            try {
                String a2 = b2.a();
                AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
                cVar = a_() ? proxyForHttp.doPost(a2, b2.b(), b2.d()) : proxyForHttp.doPost(a2, b2.b(), b2.c());
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            try {
                a(b2, cVar);
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.a(e3);
            }
        }
    }
}
