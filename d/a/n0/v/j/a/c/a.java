package d.a.n0.v.j.a.c;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51173g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51174a;

    /* renamed from: b  reason: collision with root package name */
    public int f51175b;

    /* renamed from: c  reason: collision with root package name */
    public int f51176c;

    /* renamed from: d  reason: collision with root package name */
    public int f51177d;

    /* renamed from: e  reason: collision with root package name */
    public int f51178e;

    /* renamed from: f  reason: collision with root package name */
    public int f51179f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1125881818, "Ld/a/n0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1125881818, "Ld/a/n0/v/j/a/c/a;");
                return;
            }
        }
        f51173g = k.f45831a;
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
                jSONObject.put("videoBitrate", this.f51174a);
                jSONObject.put("audioBitrate", this.f51175b);
                jSONObject.put("videoFPS", this.f51176c);
                jSONObject.put("netSpeed", this.f51177d);
                jSONObject.put("videoWidth", this.f51178e);
                jSONObject.put("videoHeight", this.f51179f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f51173g) {
                    Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
