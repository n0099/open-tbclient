package com.repackage;

import android.text.TextUtils;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ld4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ld4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ld4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ld4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ld4.class) {
                    if (a == null) {
                        a = new ld4();
                    }
                }
            }
            return a;
        }
        return (ld4) invokeV.objValue;
    }

    public static void b(q94 q94Var, ae4 ae4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, q94Var, ae4Var) == null) || q94Var == null) {
            return;
        }
        ae4Var.a(q94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, n84 n84Var, n84 n84Var2, n84 n84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, n84Var, n84Var2, n84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        kd4 kd4Var = new kd4();
        kd4 kd4Var2 = new kd4();
        kd4 kd4Var3 = new kd4();
        ae4 ae4Var = new ae4();
        ae4 ae4Var2 = new ae4();
        ae4 ae4Var3 = new ae4();
        md4 x = n84Var3 != null ? n84Var3.x("so") : null;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
                        switch (string.hashCode()) {
                            case -612557761:
                                if (string.equals(ETAG.KEY_EXTENSION)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 3676:
                                if (string.equals("so")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 99308:
                                if (string.equals("ddl")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 54573042:
                                if (string.equals("extension_game")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 714512640:
                                if (string.equals("bbasp_core")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 714618195:
                                if (string.equals("bbasp_game")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0) {
                            p94 p94Var = (p94) zd4.j(jSONObject2, new p94());
                            if (p94Var != null) {
                                b(p94Var, ae4Var);
                                kd4Var.b = p94Var;
                            }
                        } else if (c == 1) {
                            p94 p94Var2 = (p94) zd4.j(jSONObject2, new p94());
                            if (p94Var2 != null) {
                                b(p94Var2, ae4Var2);
                                kd4Var2.a = p94Var2;
                            }
                        } else if (c == 2) {
                            n94 n94Var = (n94) zd4.j(jSONObject2, new n94());
                            if (n94Var != null) {
                                b(n94Var, ae4Var);
                                kd4Var.c = n94Var;
                            }
                        } else if (c == 3) {
                            n94 n94Var2 = (n94) zd4.j(jSONObject2, new n94());
                            if (n94Var2 != null) {
                                b(n94Var2, ae4Var2);
                                kd4Var2.c = n94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (kd4Var3.e == null) {
                                    kd4Var3.e = new ArrayList();
                                }
                                t94 t94Var = (t94) zd4.j(jSONObject2, new t94());
                                b(t94Var, ae4Var3);
                                kd4Var3.e.add(t94Var);
                            }
                        } else if (x != null) {
                            x.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (n84Var != null) {
            if (ae4Var.n() == 0) {
                n84Var.G();
            } else {
                n84Var.H(ae4Var);
                da4.e(kd4Var, n84Var);
            }
        }
        if (n84Var2 != null) {
            if (ae4Var2.n() == 0) {
                n84Var2.G();
            } else {
                n84Var2.H(ae4Var2);
                da4.e(kd4Var2, n84Var2);
            }
        }
        if (x != null) {
            x.p();
        }
        if (ae4Var3.n() <= 0 || d84.b() == null) {
            return;
        }
        d84.b().t(kd4Var3, ae4Var3);
    }
}
