package d.a.r0.s.c;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f56366a = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-457221942, "Ld/a/r0/s/c/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-457221942, "Ld/a/r0/s/c/e;");
        }
    }

    public e() {
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int k = d.a.r0.r.d0.b.j().k("pref_key_fun_ad_first_floor_min", 2);
            int k2 = d.a.r0.r.d0.b.j().k("pref_key_fun_ad_first_floor_max", 3);
            if (k < k2) {
                f56366a = d.a.s0.f1.a.a.a(k, k2);
            } else {
                f56366a = d.a.s0.f1.a.a.a(k2, k);
            }
            if (f56366a < 0) {
                f56366a = 2;
            }
            return f56366a;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f56366a < 0) {
                f56366a = 2;
            }
            return f56366a;
        }
        return invokeV.intValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            int k = d.a.r0.r.d0.b.j().k("pref_key_fun_ad_density", 6);
            if (k > 0) {
                return k;
            }
            return 6;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? d.a.r0.r.d0.b.j().k("pref_key_fun_ad_frs_density", 5) : invokeV.intValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? d.a.r0.r.d0.b.j().k("pref_key_fun_ad_frs_first_floor", 2) : invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.a.r0.r.d0.b.j().k("key_video_middle_density", 4) : invokeV.intValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int k = d.a.r0.r.d0.b.j().k("key_video_middle_first", 2);
            if (k <= 0) {
                return 2;
            }
            return k;
        }
        return invokeV.intValue;
    }

    public void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("frs_bear_first_floor", 2);
            int optInt2 = jSONObject.optInt("frs_bear_density", 5);
            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_frs_first_floor", optInt);
            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_frs_density", optInt2);
            int optInt3 = jSONObject.optInt("index_bear_density", 6);
            int optInt4 = jSONObject.optInt("index_bear_first_floor_max", 3);
            int optInt5 = jSONObject.optInt("index_bear_first_floor_min", 2);
            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_density", optInt3);
            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_first_floor_max", optInt4);
            d.a.r0.r.d0.b.j().v("pref_key_fun_ad_first_floor_min", optInt5);
            int optInt6 = jSONObject.optInt("video_bear_density", 4);
            int optInt7 = jSONObject.optInt("video_bear_first_floor", 2);
            d.a.r0.r.d0.b.j().v("key_video_middle_density", optInt6);
            d.a.r0.r.d0.b.j().v("key_video_middle_first", optInt7);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
