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
/* loaded from: classes7.dex */
public class qd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public qd4() {
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

    public static qd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (qd4.class) {
                    if (a == null) {
                        a = new qd4();
                    }
                }
            }
            return a;
        }
        return (qd4) invokeV.objValue;
    }

    public static void b(v94 v94Var, fe4 fe4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, v94Var, fe4Var) == null) || v94Var == null) {
            return;
        }
        fe4Var.a(v94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, s84 s84Var, s84 s84Var2, s84 s84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, s84Var, s84Var2, s84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        pd4 pd4Var = new pd4();
        pd4 pd4Var2 = new pd4();
        pd4 pd4Var3 = new pd4();
        fe4 fe4Var = new fe4();
        fe4 fe4Var2 = new fe4();
        fe4 fe4Var3 = new fe4();
        rd4 w = s84Var3 != null ? s84Var3.w("so") : null;
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
                            u94 u94Var = (u94) ee4.j(jSONObject2, new u94());
                            if (u94Var != null) {
                                b(u94Var, fe4Var);
                                pd4Var.b = u94Var;
                            }
                        } else if (c == 1) {
                            u94 u94Var2 = (u94) ee4.j(jSONObject2, new u94());
                            if (u94Var2 != null) {
                                b(u94Var2, fe4Var2);
                                pd4Var2.a = u94Var2;
                            }
                        } else if (c == 2) {
                            s94 s94Var = (s94) ee4.j(jSONObject2, new s94());
                            if (s94Var != null) {
                                b(s94Var, fe4Var);
                                pd4Var.c = s94Var;
                            }
                        } else if (c == 3) {
                            s94 s94Var2 = (s94) ee4.j(jSONObject2, new s94());
                            if (s94Var2 != null) {
                                b(s94Var2, fe4Var2);
                                pd4Var2.c = s94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (pd4Var3.e == null) {
                                    pd4Var3.e = new ArrayList();
                                }
                                y94 y94Var = (y94) ee4.j(jSONObject2, new y94());
                                b(y94Var, fe4Var3);
                                pd4Var3.e.add(y94Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (s84Var != null) {
            if (fe4Var.n() == 0) {
                s84Var.F();
            } else {
                s84Var.G(fe4Var);
                ia4.e(pd4Var, s84Var);
            }
        }
        if (s84Var2 != null) {
            if (fe4Var2.n() == 0) {
                s84Var2.F();
            } else {
                s84Var2.G(fe4Var2);
                ia4.e(pd4Var2, s84Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (fe4Var3.n() <= 0 || i84.b() == null) {
            return;
        }
        i84.b().t(pd4Var3, fe4Var3);
    }
}
