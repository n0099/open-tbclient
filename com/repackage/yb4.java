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
public class yb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public yb4() {
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

    public static yb4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (yb4.class) {
                    if (a == null) {
                        a = new yb4();
                    }
                }
            }
            return a;
        }
        return (yb4) invokeV.objValue;
    }

    public static void b(d84 d84Var, nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, d84Var, nc4Var) == null) || d84Var == null) {
            return;
        }
        nc4Var.a(d84Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, a74 a74Var, a74 a74Var2, a74 a74Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, a74Var, a74Var2, a74Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        xb4 xb4Var = new xb4();
        xb4 xb4Var2 = new xb4();
        xb4 xb4Var3 = new xb4();
        nc4 nc4Var = new nc4();
        nc4 nc4Var2 = new nc4();
        nc4 nc4Var3 = new nc4();
        zb4 x = a74Var3 != null ? a74Var3.x("so") : null;
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
                            c84 c84Var = (c84) mc4.j(jSONObject2, new c84());
                            if (c84Var != null) {
                                b(c84Var, nc4Var);
                                xb4Var.b = c84Var;
                            }
                        } else if (c == 1) {
                            c84 c84Var2 = (c84) mc4.j(jSONObject2, new c84());
                            if (c84Var2 != null) {
                                b(c84Var2, nc4Var2);
                                xb4Var2.a = c84Var2;
                            }
                        } else if (c == 2) {
                            a84 a84Var = (a84) mc4.j(jSONObject2, new a84());
                            if (a84Var != null) {
                                b(a84Var, nc4Var);
                                xb4Var.c = a84Var;
                            }
                        } else if (c == 3) {
                            a84 a84Var2 = (a84) mc4.j(jSONObject2, new a84());
                            if (a84Var2 != null) {
                                b(a84Var2, nc4Var2);
                                xb4Var2.c = a84Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (xb4Var3.e == null) {
                                    xb4Var3.e = new ArrayList();
                                }
                                g84 g84Var = (g84) mc4.j(jSONObject2, new g84());
                                b(g84Var, nc4Var3);
                                xb4Var3.e.add(g84Var);
                            }
                        } else if (x != null) {
                            x.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (a74Var != null) {
            if (nc4Var.n() == 0) {
                a74Var.G();
            } else {
                a74Var.H(nc4Var);
                q84.e(xb4Var, a74Var);
            }
        }
        if (a74Var2 != null) {
            if (nc4Var2.n() == 0) {
                a74Var2.G();
            } else {
                a74Var2.H(nc4Var2);
                q84.e(xb4Var2, a74Var2);
            }
        }
        if (x != null) {
            x.p();
        }
        if (nc4Var3.n() <= 0 || q64.b() == null) {
            return;
        }
        q64.b().t(xb4Var3, nc4Var3);
    }
}
