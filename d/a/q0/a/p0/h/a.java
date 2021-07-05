package d.a.q0.a.p0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.t.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50021c;

    /* renamed from: d  reason: collision with root package name */
    public static a f50022d;

    /* renamed from: e  reason: collision with root package name */
    public static a f50023e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50024a;

    /* renamed from: b  reason: collision with root package name */
    public long f50025b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-784458153, "Ld/a/q0/a/p0/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-784458153, "Ld/a/q0/a/p0/h/a;");
                return;
            }
        }
        f50021c = k.f49133a;
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

    @NonNull
    public static a a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (f50022d == null) {
                f50022d = d(e(str));
            }
            return f50022d;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a b(@NonNull d.a.q0.a.p0.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aVar)) == null) {
            if (aVar.c() == 1) {
                return c(aVar.d());
            }
            return a(aVar.d());
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a c(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (f50023e == null) {
                f50023e = d(e(str));
            }
            return f50023e;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject)) == null) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.f50024a = jSONObject.optString("extension-core-version-name");
                aVar.f50025b = jSONObject.optLong("extension-core-version-code");
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static JSONObject e(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (f50021c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
            }
            String C = d.C(AppRuntime.getAppContext(), str);
            if (TextUtils.isEmpty(C)) {
                if (f50021c) {
                    Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
                }
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(C);
                if (f50021c) {
                    Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f50021c) {
                    throw new RuntimeException(e2);
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
