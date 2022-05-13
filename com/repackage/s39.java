package com.repackage;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class s39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(d49 d49Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, d49Var) == null) || d49Var == null || d49Var.y()) {
            return;
        }
        JSONArray n = d49Var.n();
        int length = n.length();
        boolean B = d49Var.B();
        for (int i = 0; i < length; i++) {
            try {
                if (B != y29.o().e(n.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + B + "  content " + d49Var.u().toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
        }
    }
}
