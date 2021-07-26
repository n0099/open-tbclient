package d.a.o0.a.e0.h;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44648h;

    /* renamed from: i  reason: collision with root package name */
    public static String f44649i;
    public static String j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44650a;
    @SuppressLint({"BDOfflineUrl"})

    /* renamed from: b  reason: collision with root package name */
    public String f44651b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44652c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44653d;

    /* renamed from: e  reason: collision with root package name */
    public int f44654e;

    /* renamed from: f  reason: collision with root package name */
    public int f44655f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44656g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2079737837, "Ld/a/o0/a/e0/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2079737837, "Ld/a/o0/a/e0/h/b;");
                return;
            }
        }
        f44648h = k.f46335a;
        f44649i = "V8Master";
        j = "page";
        k = "runtime/index.js";
        l = "ws://localhost:4000";
    }

    public b() {
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
        this.f44650a = String.valueOf(System.currentTimeMillis());
        this.f44651b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.f44652c = false;
        this.f44653d = true;
        this.f44654e = 0;
        this.f44655f = 0;
        this.f44656g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", f44649i);
                jSONObject.putOpt("type", j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.f44650a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.f44651b);
                jSONObject.putOpt("swanJsVersion", d.a.o0.a.m2.b.h(0));
                jSONObject.putOpt("appVersion", q0.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.f44652c));
                jSONObject2.putOpt("empty", Boolean.valueOf(this.f44653d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.f44654e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f44655f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.f44656g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                if (f44648h) {
                    Log.e("V8Module", "Build V8 module fail", e2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
