package d.a.q0.v.j.a.c;

import android.util.Log;
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
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f54475g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54476a;

    /* renamed from: b  reason: collision with root package name */
    public int f54477b;

    /* renamed from: c  reason: collision with root package name */
    public int f54478c;

    /* renamed from: d  reason: collision with root package name */
    public int f54479d;

    /* renamed from: e  reason: collision with root package name */
    public int f54480e;

    /* renamed from: f  reason: collision with root package name */
    public int f54481f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(245672797, "Ld/a/q0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(245672797, "Ld/a/q0/v/j/a/c/a;");
                return;
            }
        }
        f54475g = k.f49133a;
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
            }
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("videoBitrate", this.f54476a);
                jSONObject.put("audioBitrate", this.f54477b);
                jSONObject.put("videoFPS", this.f54478c);
                jSONObject.put("netSpeed", this.f54479d);
                jSONObject.put("videoWidth", this.f54480e);
                jSONObject.put("videoHeight", this.f54481f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f54475g) {
                    Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
