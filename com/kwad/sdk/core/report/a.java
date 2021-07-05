package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public String B;
    public long C;
    public String D;
    public int E;
    public int F;
    public int G;
    public String H;
    public String I;
    public JSONArray J;
    public JSONArray K;
    public JSONObject L;
    public int M;
    public String N;
    public String O;
    public int P;
    public int Q;
    public long R;
    public String S;
    public int T;
    public int U;
    public int V;
    public int W;
    public long X;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f36488a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f36489b;

    /* renamed from: c  reason: collision with root package name */
    public long f36490c;

    /* renamed from: d  reason: collision with root package name */
    public long f36491d;

    /* renamed from: e  reason: collision with root package name */
    public long f36492e;

    /* renamed from: f  reason: collision with root package name */
    public long f36493f;

    /* renamed from: g  reason: collision with root package name */
    public long f36494g;

    /* renamed from: h  reason: collision with root package name */
    public long f36495h;

    /* renamed from: i  reason: collision with root package name */
    public long f36496i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public JSONArray t;
    public JSONArray u;
    public String v;
    public String w;
    public String x;
    public long y;
    public long z;

    public a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.X = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.s = 0;
        this.C = -1L;
        this.E = -1;
        this.V = -1;
        this.W = -1;
        this.f36490c = j;
        this.f36488a = null;
    }

    public a(long j, @NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), adTemplate};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.X = -1L;
        this.k = 0L;
        this.n = -1L;
        this.o = 0;
        this.p = 0;
        this.s = 0;
        this.C = -1L;
        this.E = -1;
        this.V = -1;
        this.W = -1;
        this.f36490c = j;
        this.f36488a = adTemplate;
        a(adTemplate.getShowPosition());
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            this.X = j + 1;
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.X : invokeV.longValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.core.h.b a2 = com.kwad.sdk.core.h.b.a();
            this.U = a2.b() ? 1 : 0;
            this.V = a2.c();
            this.W = a2.d();
        }
    }
}
