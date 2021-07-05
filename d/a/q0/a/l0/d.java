package d.a.q0.a.l0;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends d.a.q0.a.l0.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public static final Object t;
    public static String u;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c f49237e;
        @V8JavascriptField
        public b env;

        /* renamed from: f  reason: collision with root package name */
        public d.a.q0.a.r0.e f49238f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, String str) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49237e = cVar;
            b bVar = new b();
            this.env = bVar;
            bVar.basePath = str;
        }

        @JavascriptInterface
        public String getAPIs(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (d.s) {
                    String d2 = d.a.q0.a.u1.a.a.p() ? d.a.q0.a.v2.j.d(i2, true) : "";
                    Log.d("SwanAppV8Engine", "getAPIs res:" + d2);
                    return d2;
                }
                String d3 = d.a.q0.a.v2.j.d(i2, true);
                if (d.s) {
                    Log.d("SwanAppV8Engine", "getAPIs description:" + d3);
                }
                if (TextUtils.isEmpty(d3)) {
                    if (!d.s) {
                        d.a.q0.a.v2.a.c(d.a.q0.a.v2.j.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i2), d3, Boolean.TRUE)));
                    } else {
                        d.a.q0.a.v2.j.g();
                        throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i2), d3));
                    }
                } else {
                    d.a.q0.a.v2.a.d();
                }
                return d3;
            }
            return (String) invokeI.objValue;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (d.s) {
                    Log.d("SwanAppV8Engine", "getDevToolsResponse = " + d.u);
                }
                return d.u;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? d.a.q0.a.d1.b.b.a(this.f49237e) : (String) invokeV.objValue;
        }

        @JavascriptInterface
        public d.a.q0.a.r0.e getFileSystemManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f49238f == null) {
                    this.f49238f = new d.a.q0.a.r0.e((d.a.q0.a.l0.a) this.f49237e);
                }
                return this.f49238f;
            }
            return (d.a.q0.a.r0.e) invokeV.objValue;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                d.K0(jSONObject);
                d.a.q0.a.e0.d.h("SwanAppV8Engine", "getNACanIUseMap - " + jSONObject.toString());
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                d.a.q0.a.e0.d.h("SwanAppV8Engine", "lockMaster");
                synchronized (d.t) {
                    try {
                        try {
                            d.t.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                if (d.s) {
                    Log.d("SwanAppV8Engine", "setDevToolsResponse = " + str);
                }
                d.u = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(120629033, "Ld/a/q0/a/l0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(120629033, "Ld/a/q0/a/l0/d;");
                return;
            }
        }
        s = k.f49133a;
        t = new Object();
        u = "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull String str, @NonNull d.a.q0.a.l0.n.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (d.a.q0.a.l0.n.b) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void K0(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) && d.a.q0.a.l2.b.l().o()) {
            try {
                jSONObject.put("swanCookie", new JSONObject());
            } catch (JSONException e2) {
                if (s) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // d.a.q0.a.l0.c, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.q0.a.l0.a
    @NonNull
    public EventTarget w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this, this.f49228f.getInitBasePath());
            aVar.env.config = d.a.q0.a.m2.c.a.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }
}
