package d.l.a.d.b.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.l.a.d.b.c;
import d.l.a.d.e;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.c.a().w("lp_compliance_error", jSONObject, c.g.e().v(j));
        }
    }

    public static void b(int i2, c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i2, fVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("error_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.c.a().w("lp_compliance_error", jSONObject, fVar);
        }
    }

    public static void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65538, null, str, j) == null) {
            c.f v = c.g.e().v(j);
            if (v.x()) {
                return;
            }
            v.f71732c.a(str);
            e.c.a().v("lp_app_dialog_click", v);
        }
    }

    public static void d(String str, c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, fVar) == null) {
            e.c.a().v(str, fVar);
        }
    }

    public static void e(String str, JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, jSONObject, Long.valueOf(j)}) == null) {
            e.c.a().w(str, jSONObject, c.g.e().v(j));
        }
    }

    public static void f(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, str, j) == null) {
            e(str, null, j);
        }
    }
}
