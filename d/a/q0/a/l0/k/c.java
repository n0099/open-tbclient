package d.a.q0.a.l0.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.j2.l;
import d.a.q0.a.k;
import d.a.q0.a.p.b.a.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c implements V8Engine.JavaScriptExceptionDelegate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.a f49249a;

    /* renamed from: b  reason: collision with root package name */
    public String f49250b;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static final boolean f49251d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public JSEvent f49252a;

        /* renamed from: b  reason: collision with root package name */
        public String f49253b;

        /* renamed from: c  reason: collision with root package name */
        public String f49254c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(775770321, "Ld/a/q0/a/l0/k/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(775770321, "Ld/a/q0/a/l0/k/c$a;");
                    return;
                }
            }
            f49251d = k.f49133a;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f49252a = new JSEvent("error");
        }

        public JSEvent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("message", this.f49253b);
                    jSONObject.put("stack", this.f49254c);
                } catch (JSONException e2) {
                    if (f49251d) {
                        Log.e("V8Exception", Log.getStackTraceString(e2));
                    }
                }
                if (jSONObject.length() > 0) {
                    this.f49252a.data = jSONObject;
                }
                return this.f49252a;
            }
            return (JSEvent) invokeV.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f49253b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f49254c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-39416146, "Ld/a/q0/a/l0/k/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-39416146, "Ld/a/q0/a/l0/k/c;");
                return;
            }
        }
        boolean z = k.f49133a;
    }

    public c(d.a.q0.a.l0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f49250b = "";
        this.f49249a = aVar;
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || this.f49249a.p() == null) {
            return;
        }
        EventTarget p = this.f49249a.p();
        a aVar = new a();
        aVar.b(str + "\n" + str2);
        aVar.c("");
        p.dispatchEvent(aVar.a());
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.JavaScriptExceptionDelegate
    @SuppressLint({"SwanDebugLog"})
    public void onV8ExceptionCallBack(V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8ExceptionInfo) == null) || v8ExceptionInfo == null) {
            return;
        }
        String str = TextUtils.isEmpty(v8ExceptionInfo.exceptionMsg) ? "" : v8ExceptionInfo.exceptionMsg;
        String str2 = TextUtils.isEmpty(v8ExceptionInfo.exceptionTrace) ? "" : v8ExceptionInfo.exceptionTrace;
        Log.e("V8Exception", this.f49249a.m0() + "msg: " + str + " ,stack: " + str2);
        this.f49249a.A().a(str);
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || this.f49250b.equals(str)) {
            return;
        }
        this.f49250b = str;
        a(str, str2);
        h j = d.a.q0.a.c1.b.j();
        j.e(str + ";" + str2);
        l.b(v8ExceptionInfo);
        d.a.q0.a.c1.b.i().s(v8ExceptionInfo);
    }
}
