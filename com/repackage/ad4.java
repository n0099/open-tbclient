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
/* loaded from: classes5.dex */
public class ad4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ad4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public ad4() {
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

    public static ad4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (ad4.class) {
                    if (a == null) {
                        a = new ad4();
                    }
                }
            }
            return a;
        }
        return (ad4) invokeV.objValue;
    }

    public static void b(f94 f94Var, pd4 pd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, f94Var, pd4Var) == null) || f94Var == null) {
            return;
        }
        pd4Var.a(f94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, c84 c84Var, c84 c84Var2, c84 c84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, c84Var, c84Var2, c84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        zc4 zc4Var = new zc4();
        zc4 zc4Var2 = new zc4();
        zc4 zc4Var3 = new zc4();
        pd4 pd4Var = new pd4();
        pd4 pd4Var2 = new pd4();
        pd4 pd4Var3 = new pd4();
        bd4 x = c84Var3 != null ? c84Var3.x("so") : null;
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
                            e94 e94Var = (e94) od4.j(jSONObject2, new e94());
                            if (e94Var != null) {
                                b(e94Var, pd4Var);
                                zc4Var.b = e94Var;
                            }
                        } else if (c == 1) {
                            e94 e94Var2 = (e94) od4.j(jSONObject2, new e94());
                            if (e94Var2 != null) {
                                b(e94Var2, pd4Var2);
                                zc4Var2.a = e94Var2;
                            }
                        } else if (c == 2) {
                            c94 c94Var = (c94) od4.j(jSONObject2, new c94());
                            if (c94Var != null) {
                                b(c94Var, pd4Var);
                                zc4Var.c = c94Var;
                            }
                        } else if (c == 3) {
                            c94 c94Var2 = (c94) od4.j(jSONObject2, new c94());
                            if (c94Var2 != null) {
                                b(c94Var2, pd4Var2);
                                zc4Var2.c = c94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (zc4Var3.e == null) {
                                    zc4Var3.e = new ArrayList();
                                }
                                i94 i94Var = (i94) od4.j(jSONObject2, new i94());
                                b(i94Var, pd4Var3);
                                zc4Var3.e.add(i94Var);
                            }
                        } else if (x != null) {
                            x.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (c84Var != null) {
            if (pd4Var.n() == 0) {
                c84Var.G();
            } else {
                c84Var.H(pd4Var);
                s94.e(zc4Var, c84Var);
            }
        }
        if (c84Var2 != null) {
            if (pd4Var2.n() == 0) {
                c84Var2.G();
            } else {
                c84Var2.H(pd4Var2);
                s94.e(zc4Var2, c84Var2);
            }
        }
        if (x != null) {
            x.p();
        }
        if (pd4Var3.n() <= 0 || s74.b() == null) {
            return;
        }
        s74.b().t(zc4Var3, pd4Var3);
    }
}
