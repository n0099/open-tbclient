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
public class jc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public jc4() {
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

    public static jc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (jc4.class) {
                    if (a == null) {
                        a = new jc4();
                    }
                }
            }
            return a;
        }
        return (jc4) invokeV.objValue;
    }

    public static void b(o84 o84Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, o84Var, yc4Var) == null) || o84Var == null) {
            return;
        }
        yc4Var.a(o84Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, l74 l74Var, l74 l74Var2, l74 l74Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, l74Var, l74Var2, l74Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        ic4 ic4Var = new ic4();
        ic4 ic4Var2 = new ic4();
        ic4 ic4Var3 = new ic4();
        yc4 yc4Var = new yc4();
        yc4 yc4Var2 = new yc4();
        yc4 yc4Var3 = new yc4();
        kc4 w = l74Var3 != null ? l74Var3.w("so") : null;
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
                            n84 n84Var = (n84) xc4.j(jSONObject2, new n84());
                            if (n84Var != null) {
                                b(n84Var, yc4Var);
                                ic4Var.b = n84Var;
                            }
                        } else if (c == 1) {
                            n84 n84Var2 = (n84) xc4.j(jSONObject2, new n84());
                            if (n84Var2 != null) {
                                b(n84Var2, yc4Var2);
                                ic4Var2.a = n84Var2;
                            }
                        } else if (c == 2) {
                            l84 l84Var = (l84) xc4.j(jSONObject2, new l84());
                            if (l84Var != null) {
                                b(l84Var, yc4Var);
                                ic4Var.c = l84Var;
                            }
                        } else if (c == 3) {
                            l84 l84Var2 = (l84) xc4.j(jSONObject2, new l84());
                            if (l84Var2 != null) {
                                b(l84Var2, yc4Var2);
                                ic4Var2.c = l84Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (ic4Var3.e == null) {
                                    ic4Var3.e = new ArrayList();
                                }
                                r84 r84Var = (r84) xc4.j(jSONObject2, new r84());
                                b(r84Var, yc4Var3);
                                ic4Var3.e.add(r84Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (l74Var != null) {
            if (yc4Var.n() == 0) {
                l74Var.F();
            } else {
                l74Var.G(yc4Var);
                b94.e(ic4Var, l74Var);
            }
        }
        if (l74Var2 != null) {
            if (yc4Var2.n() == 0) {
                l74Var2.F();
            } else {
                l74Var2.G(yc4Var2);
                b94.e(ic4Var2, l74Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (yc4Var3.n() <= 0 || b74.b() == null) {
            return;
        }
        b74.b().t(ic4Var3, yc4Var3);
    }
}
