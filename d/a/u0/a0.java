package d.a.u0;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes9.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, i0Var) == null) || i0Var == null || i0Var.j()) {
            return;
        }
        JSONArray d2 = i0Var.d();
        int length = d2.length();
        boolean l = i0Var.l();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                if (l != g.m().e(d2.getJSONObject(i2).getString("id"))) {
                    Log.w("UBCDebug", " data is " + l + "  content " + i0Var.i().toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }
}
