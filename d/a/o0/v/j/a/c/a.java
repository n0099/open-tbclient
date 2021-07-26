package d.a.o0.v.j.a.c;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51677g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f51678a;

    /* renamed from: b  reason: collision with root package name */
    public int f51679b;

    /* renamed from: c  reason: collision with root package name */
    public int f51680c;

    /* renamed from: d  reason: collision with root package name */
    public int f51681d;

    /* renamed from: e  reason: collision with root package name */
    public int f51682e;

    /* renamed from: f  reason: collision with root package name */
    public int f51683f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(832478811, "Ld/a/o0/v/j/a/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(832478811, "Ld/a/o0/v/j/a/c/a;");
                return;
            }
        }
        f51677g = k.f46335a;
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
                jSONObject.put("videoBitrate", this.f51678a);
                jSONObject.put("audioBitrate", this.f51679b);
                jSONObject.put("videoFPS", this.f51680c);
                jSONObject.put("netSpeed", this.f51681d);
                jSONObject.put("videoWidth", this.f51682e);
                jSONObject.put("videoHeight", this.f51683f);
                jSONObject2.putOpt("info", jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                if (f51677g) {
                    Log.e("LiveNetworkStatus", "toJSONObject failed: " + Log.getStackTraceString(e2));
                    return null;
                }
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
