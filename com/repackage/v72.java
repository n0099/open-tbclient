package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
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
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v72 extends r72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public static final Object p;
    public static String q;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public t72 a;
        public kc2 b;
        @V8JavascriptField
        public s72 env;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t72 t72Var, String str) {
            super(t72Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t72Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t72Var;
            s72 s72Var = new s72();
            this.env = s72Var;
            s72Var.basePath = str;
        }

        @JavascriptInterface
        @SuppressLint({"BDThrowableCheck"})
        public String getAPIs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (v72.o) {
                    String d = iw2.p() ? wc3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8) : "";
                    jx1.b("SwanAppV8Engine", "getAPIs res:" + d);
                    return d;
                }
                String d2 = wc3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8);
                jx1.b("SwanAppV8Engine", "getAPIs description:" + d2);
                if (TextUtils.isEmpty(d2)) {
                    if (!v72.o) {
                        nc3.c(wc3.b(String.format("index: %d, desc: %s, isV8: %b", Integer.valueOf(i), d2, Boolean.TRUE)));
                    } else {
                        wc3.i();
                        throw new RuntimeException(String.format("getAPIs cannot find index: %d, desc: %s", Integer.valueOf(i), d2));
                    }
                } else {
                    nc3.d();
                }
                return d2;
            }
            return (String) invokeI.objValue;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (v72.o) {
                    Log.d("SwanAppV8Engine", "getDevToolsResponse = " + v72.q);
                }
                return v72.q;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public String getEnvVariables() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? tk2.a(this.a) : (String) invokeV.objValue;
        }

        @JavascriptInterface
        public kc2 getFileSystemManager() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.b == null) {
                    this.b = new kc2((r72) this.a);
                }
                return this.b;
            }
            return (kc2) invokeV.objValue;
        }

        @JavascriptInterface
        public JSONObject getNACanIUseMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject b = kr2.b();
                jx1.k("SwanAppV8Engine", "getNACanIUseMap - " + b.toString());
                return b;
            }
            return (JSONObject) invokeV.objValue;
        }

        @JavascriptInterface
        public boolean lockMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                jx1.k("SwanAppV8Engine", "lockMaster");
                synchronized (v72.p) {
                    try {
                        try {
                            v72.p.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
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
                if (v72.o) {
                    Log.d("SwanAppV8Engine", "setDevToolsResponse = " + str);
                }
                v72.q = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755278336, "Lcom/repackage/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755278336, "Lcom/repackage/v72;");
                return;
            }
        }
        o = tg1.a;
        p = new Object();
        q = "";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v72(@NonNull String str, @NonNull o82 o82Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, o82Var, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, o82Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (o82) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.t72, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.r72
    @NonNull
    public EventTarget w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            a aVar = new a(this, this.b.getInitBasePath());
            aVar.env.config = p93.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }
}
