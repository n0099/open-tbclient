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
public class yc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public yc4() {
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

    public static yc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (yc4.class) {
                    if (a == null) {
                        a = new yc4();
                    }
                }
            }
            return a;
        }
        return (yc4) invokeV.objValue;
    }

    public static void b(d94 d94Var, nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, d94Var, nd4Var) == null) || d94Var == null) {
            return;
        }
        nd4Var.a(d94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, a84 a84Var, a84 a84Var2, a84 a84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, a84Var, a84Var2, a84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        xc4 xc4Var = new xc4();
        xc4 xc4Var2 = new xc4();
        xc4 xc4Var3 = new xc4();
        nd4 nd4Var = new nd4();
        nd4 nd4Var2 = new nd4();
        nd4 nd4Var3 = new nd4();
        zc4 w = a84Var3 != null ? a84Var3.w("so") : null;
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
                            c94 c94Var = (c94) md4.j(jSONObject2, new c94());
                            if (c94Var != null) {
                                b(c94Var, nd4Var);
                                xc4Var.b = c94Var;
                            }
                        } else if (c == 1) {
                            c94 c94Var2 = (c94) md4.j(jSONObject2, new c94());
                            if (c94Var2 != null) {
                                b(c94Var2, nd4Var2);
                                xc4Var2.a = c94Var2;
                            }
                        } else if (c == 2) {
                            a94 a94Var = (a94) md4.j(jSONObject2, new a94());
                            if (a94Var != null) {
                                b(a94Var, nd4Var);
                                xc4Var.c = a94Var;
                            }
                        } else if (c == 3) {
                            a94 a94Var2 = (a94) md4.j(jSONObject2, new a94());
                            if (a94Var2 != null) {
                                b(a94Var2, nd4Var2);
                                xc4Var2.c = a94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (xc4Var3.e == null) {
                                    xc4Var3.e = new ArrayList();
                                }
                                g94 g94Var = (g94) md4.j(jSONObject2, new g94());
                                b(g94Var, nd4Var3);
                                xc4Var3.e.add(g94Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (a84Var != null) {
            if (nd4Var.n() == 0) {
                a84Var.F();
            } else {
                a84Var.G(nd4Var);
                q94.e(xc4Var, a84Var);
            }
        }
        if (a84Var2 != null) {
            if (nd4Var2.n() == 0) {
                a84Var2.F();
            } else {
                a84Var2.G(nd4Var2);
                q94.e(xc4Var2, a84Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (nd4Var3.n() <= 0 || q74.b() == null) {
            return;
        }
        q74.b().t(xc4Var3, nd4Var3);
    }
}
