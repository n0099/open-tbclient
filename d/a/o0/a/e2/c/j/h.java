package d.a.o0.a.e2.c.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.j2.k;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class h<ResultDataT> extends d.a.o0.a.e2.c.c<ResultDataT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f44891g;

    /* renamed from: h  reason: collision with root package name */
    public String f44892h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f44893i;
    public boolean j;
    public boolean k;
    public String l;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f44894e;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44894e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (d.a.o0.a.e2.c.c.f44810f) {
                    Log.d("OAuthRequest", "OAuthRequest.onExec in thread pool");
                }
                this.f44894e.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpRequest f44895a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f44896b;

        public b(h hVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44896b = hVar;
            this.f44895a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.f44896b.F()) {
                    this.f44896b.O(this.f44895a);
                } else {
                    this.f44896b.I(this.f44895a, exc);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f44896b.K(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HttpRequest f44897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f44898b;

        public c(h hVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44898b = hVar;
            this.f44897a = httpRequest;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                d.a.o0.a.e0.d.g("OAuthRequest", "retryRequest fail: ");
                this.f44898b.I(this.f44897a, exc);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                d.a.o0.a.e0.d.g("OAuthRequest", "retryRequest success: ");
                this.f44898b.K(response);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44899e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f44900f;

        public d(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44900f = hVar;
            this.f44899e = str;
        }

        @Override // d.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.f44900f.q();
                    this.f44900f.a();
                    return;
                }
                this.f44900f.D(null, this.f44899e);
            }
        }
    }

    public h() {
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
        this.f44891g = new HashMap();
    }

    public abstract SwanInterfaceType A();

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public Map<String, String> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44891g : (Map) invokeV.objValue;
    }

    public void D(Response response, String str) {
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, response, str) == null) {
            this.f44892h = str;
            try {
                JSONObject jSONObject = new JSONObject(this.f44892h);
                this.f44893i = jSONObject;
                optInt = jSONObject.optInt("errno");
            } catch (OAuthException e2) {
                H(e2.mErrorCode, str, response);
                e(e2);
            } catch (Exception e3) {
                d.a.o0.a.e2.c.d.j(e3.toString(), Boolean.TRUE);
                M(str, e3);
                H(2103, str, response);
                e(new OAuthException(10005));
                k.p(10005, null);
            }
            if ((this.j && optInt == 402) || (this.k && optInt == 401)) {
                this.j = false;
                this.k = false;
                if (d.a.o0.a.s.a.f.f47712d.f()) {
                    d.a.o0.a.s.a.f.f47712d.b();
                }
                P(str);
            } else if (G(optInt)) {
                if (d.a.o0.a.s.a.f.f47712d.f()) {
                    d.a.o0.a.s.a.f.f47712d.b();
                    P(str);
                } else if (d.a.o0.a.e2.c.c.f44810f) {
                    throw new RuntimeException("is not AllianceLogin, error number");
                }
            } else {
                if (response != null && optInt != 0) {
                    H(optInt, str, response);
                }
                s(n(this.f44893i));
                J();
                d();
            }
        }
    }

    public final void E() {
        HttpRequest x;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (x = x(this)) == null) {
            return;
        }
        x.executeAsync(new b(this, x));
        d.a.o0.a.j2.q.a.a(A());
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean G(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == 600101 || i2 == 600102 || i2 == 600103 || i2 == 402 || i2 == 401 : invokeI.booleanValue;
    }

    public final void H(int i2, String str, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048583, this, i2, str, response) == null) {
            d.a.o0.a.j2.q.a.c(A(), i2, str, response);
        }
    }

    public void I(HttpRequest httpRequest, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpRequest, exc) == null) {
            d.a.o0.a.e2.c.d.j(exc.toString(), Boolean.FALSE);
            d.a.o0.a.j2.q.a.b(A(), 2101, httpRequest.getOkRequest() == null ? null : httpRequest.getOkRequest().url().toString(), null, exc.getMessage());
            e(new OAuthException(10002));
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void K(Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, response) == null) {
            if (!response.isSuccessful()) {
                d.a.o0.a.e2.c.d.j("bad response", Boolean.TRUE);
                H(2104, null, null);
                e(new OAuthException(10002));
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d.a.o0.a.e2.c.d.j("empty response body", Boolean.TRUE);
                H(2103, null, null);
                e(new OAuthException(10001));
                return;
            }
            try {
                D(response, body.string());
            } catch (IOException e2) {
                if (d.a.o0.a.e2.c.c.f44810f) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void M(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, exc) == null) {
            if (this.f44893i == null) {
                d.a.o0.a.e2.c.d.s("OAuthRequest", "ex: " + exc.toString() + " ,strResponse: " + str);
                return;
            }
            d.a.o0.a.e2.c.d.s("OAuthRequest", "ex: " + exc.toString());
        }
    }

    @NonNull
    public d.a.o0.a.a2.e N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
            if (i2 == null) {
                if (!d.a.o0.a.e2.c.c.f44810f) {
                    return d.a.o0.a.a2.d.g().r();
                }
                throw new IllegalStateException("null SwanApp");
            }
            return i2;
        }
        return (d.a.o0.a.a2.e) invokeV.objValue;
    }

    public void O(HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, httpRequest) == null) {
            d.a.o0.a.e0.d.g("OAuthRequest", "retryRequest: " + httpRequest.toString());
            L();
            httpRequest.executeAsync(new c(this, httpRequest));
        }
    }

    public final void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            N().j().f(d.a.o0.a.g1.f.V().getActivity(), null, new d(this, str));
        }
    }

    @Override // d.a.o0.a.e2.c.c
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "OAuthRequest-onExec", 2);
        }
    }

    @Override // d.a.o0.a.e2.c.c
    public d.a.o0.a.e2.c.c<ResultDataT> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                this.l = "loginApi";
            } else {
                this.l = str;
            }
            super.r(str);
            return this;
        }
        return (d.a.o0.a.e2.c.c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            i<ResultDataT> iVar = this.f44811a;
            return String.format("%s \n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), f(), Integer.valueOf(this.f44811a.b()), this.f44892h, this.f44893i, iVar.f44872a, iVar.a());
        }
        return (String) invokeV.objValue;
    }

    public h<ResultDataT> w(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, str, str2)) == null) {
            this.f44891g.put(str, str2);
            return this;
        }
        return (h) invokeLL.objValue;
    }

    public abstract HttpRequest x(h hVar);

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.k = true;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.j = true;
        }
    }
}
