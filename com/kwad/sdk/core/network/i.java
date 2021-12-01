package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class i<R extends g, T extends BaseResultData> extends a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public h<R, T> a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.core.network.a.b f57517b;

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
        this.a = null;
        this.f57517b = new com.kwad.sdk.core.network.a.b();
    }

    private void a(@NonNull R r) {
        h<R, T> hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, r) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.a(r);
    }

    private void a(@NonNull R r, int i2, String str) {
        h<R, T> hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65538, this, r, i2, str) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.a(r, i2, str);
    }

    private void a(@NonNull R r, T t) {
        h<R, T> hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, r, t) == null) || (hVar = this.a) == null) {
            return;
        }
        hVar.a(r, t);
    }

    private void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2) == null) {
            try {
                l.a().a(str, new JSONObject(str2).optString("requestSessionData"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void a(R r, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, r, cVar) == null) {
            if (cVar == null) {
                f fVar = f.f57508c;
                a(r, fVar.n, fVar.o);
                this.f57517b.a("responseBase is null");
                com.kwad.sdk.core.d.a.e("Networking", "request responseBase is null");
            } else if (TextUtils.isEmpty(cVar.f57506b) || cVar.a != 200) {
                a(r, cVar.a, "网络错误");
                com.kwad.sdk.core.network.a.b bVar = this.f57517b;
                bVar.a("httpCodeError:" + cVar.a + ":" + cVar.f57506b);
                StringBuilder sb = new StringBuilder();
                sb.append("request responseBase httpCodeError:");
                sb.append(cVar.a);
                com.kwad.sdk.core.d.a.e("Networking", sb.toString());
            } else {
                try {
                    a(r.a(), cVar.f57506b);
                    T b2 = b(cVar.f57506b);
                    this.f57517b.d();
                    if (b2.isResultOk()) {
                        if (!b2.isDataEmpty()) {
                            a((i<R, T>) r, (R) b2);
                            return;
                        }
                        f fVar2 = f.f57510e;
                        a(r, fVar2.n, fVar2.o);
                        return;
                    }
                    a(r, b2.result, b2.errorMsg);
                    com.kwad.sdk.core.network.a.b bVar2 = this.f57517b;
                    bVar2.a("serverCodeError:" + b2.result + ":" + b2.errorMsg);
                } catch (Exception e2) {
                    f fVar3 = f.f57509d;
                    a(r, fVar3.n, fVar3.o);
                    com.kwad.sdk.core.d.a.b(e2);
                    com.kwad.sdk.core.network.a.b bVar3 = this.f57517b;
                    bVar3.a("parseDataError:" + e2.getMessage());
                }
            }
        }
    }

    public void a(@NonNull h<R, T> hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            this.f57517b.a();
            this.a = hVar;
            d();
        }
    }

    @NonNull
    public abstract T b(String str);

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.e();
            this.a = null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00bc: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x00bc */
    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void f() {
        g gVar;
        R r;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g gVar2 = null;
            c cVar = null;
            try {
            } catch (Throwable th) {
                th = th;
                gVar2 = gVar;
            }
            try {
                try {
                    r = b();
                    try {
                        this.f57517b.b();
                        a((i<R, T>) r);
                        if (com.ksad.download.c.b.a(KsAdSDKImpl.get().getContext())) {
                            try {
                                String a = r.a();
                                AdHttpProxy proxyForHttp = KsAdSDKImpl.get().getProxyForHttp();
                                cVar = g() ? proxyForHttp.doPost(a, r.c(), r.e()) : proxyForHttp.doPost(a, r.c(), r.d());
                            } catch (Exception e3) {
                                com.kwad.sdk.core.d.a.b(e3);
                                this.f57517b.a("requestError:" + e3.getMessage());
                            }
                            this.f57517b.c();
                            try {
                                a((i<R, T>) r, cVar);
                            } catch (Exception e4) {
                                this.f57517b.a("onResponseError:" + e4.getMessage());
                                com.kwad.sdk.core.d.a.b(e4);
                            }
                        } else {
                            a(r, f.f57508c.n, f.f57508c.o);
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        try {
                            this.f57517b.a("requestError:" + e2.getMessage());
                        } catch (Exception unused) {
                        }
                        com.kwad.sdk.core.d.a.a(e2);
                        if (c() && com.kwad.sdk.core.config.b.ap()) {
                            this.f57517b.a(r.a(), r.b());
                            this.f57517b.e();
                        }
                        return;
                    }
                } catch (Exception unused2) {
                    return;
                }
            } catch (Exception e6) {
                r = null;
                e2 = e6;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (c() && com.kwad.sdk.core.config.b.ap()) {
                        this.f57517b.a(gVar2.a(), gVar2.b());
                        this.f57517b.e();
                    }
                } catch (Exception unused3) {
                }
                throw th;
            }
            if (c() && com.kwad.sdk.core.config.b.ap()) {
                this.f57517b.a(r.a(), r.b());
                this.f57517b.e();
            }
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
