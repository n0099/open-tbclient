package com.repackage;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @SuppressLint({"BDOfflineUrl"})
    public String b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755809800, "Lcom/repackage/bz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755809800, "Lcom/repackage/bz1;");
                return;
            }
        }
        h = jh1.a;
        i = "V8Master";
        j = "page";
        k = "runtime/index.js";
        l = "ws://localhost:4000";
    }

    public bz1() {
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
        this.a = String.valueOf(System.currentTimeMillis());
        this.b = "http://chrome-devtools-frontend.appspot.com/serve_rev/@74dd8d5ea19a92d0e6092e59a0c8bd3a40877b71/inspector.html?ws=localhost:4000";
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = 0;
        this.g = true;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("title", i);
                jSONObject.putOpt("type", j);
                jSONObject.putOpt("url", k);
                jSONObject.putOpt("webSocketDebuggerUrl", l);
                jSONObject.putOpt("id", this.a);
                jSONObject.putOpt("devtoolsFrontendUrl", this.b);
                jSONObject.putOpt("swanJsVersion", ea3.h(0));
                jSONObject.putOpt("appVersion", te3.D());
                jSONObject2.putOpt("attached", Boolean.valueOf(this.c));
                jSONObject2.putOpt(SchemeCollecter.CLASSIFY_EMPTY, Boolean.valueOf(this.d));
                jSONObject2.putOpt("screenX", Integer.valueOf(this.e));
                jSONObject2.putOpt("screenY", Integer.valueOf(this.f));
                jSONObject2.putOpt("visible", Boolean.valueOf(this.g));
                jSONObject.putOpt("description", jSONObject2.toString());
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                if (h) {
                    Log.e("V8Module", "Build V8 module fail", e);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }
}
