package d.a.o0.a.m2.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import d.a.o0.a.k2.g.h;
import d.a.o0.a.v2.l0;
import d.a.o0.t.d;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46638a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(646971800, "Ld/a/o0/a/m2/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(646971800, "Ld/a/o0/a/m2/d/a;");
                return;
            }
        }
        f46638a = k.f46335a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File c2 = c();
            if (c2.exists()) {
                d.i(c2);
            }
        }
    }

    public static long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? h.a().getLong("aiapps_cur_debug_ver_key", 0L) : invokeV.longValue;
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(d.a.o0.a.f1.c.a.d().get(0).f48553a, "/aiapps_debug_swan_core/") : (File) invokeV.objValue;
    }

    public static File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            File c2 = c();
            if (!c2.exists()) {
                c2.mkdirs();
            }
            return new File(c2, "debugSwanCore.zip");
        }
        return (File) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            File file = new File(c().getPath(), "pkginfo.json");
            if (file.exists()) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = new JSONObject(d.D(file));
                } catch (JSONException e2) {
                    if (f46638a) {
                        e2.printStackTrace();
                    }
                }
                if (jSONObject == null) {
                    return false;
                }
                String optString = jSONObject.optString("version_name");
                if (TextUtils.isEmpty(optString)) {
                    return true;
                }
                h.a().putLong("aiapps_cur_debug_ver_key", l0.b(optString));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
