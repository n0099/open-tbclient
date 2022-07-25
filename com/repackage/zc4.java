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
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public zc4() {
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

    public static zc4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (zc4.class) {
                    if (a == null) {
                        a = new zc4();
                    }
                }
            }
            return a;
        }
        return (zc4) invokeV.objValue;
    }

    public static void b(e94 e94Var, od4 od4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, e94Var, od4Var) == null) || e94Var == null) {
            return;
        }
        od4Var.a(e94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, b84 b84Var, b84 b84Var2, b84 b84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, b84Var, b84Var2, b84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        yc4 yc4Var = new yc4();
        yc4 yc4Var2 = new yc4();
        yc4 yc4Var3 = new yc4();
        od4 od4Var = new od4();
        od4 od4Var2 = new od4();
        od4 od4Var3 = new od4();
        ad4 w = b84Var3 != null ? b84Var3.w("so") : null;
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
                            d94 d94Var = (d94) nd4.j(jSONObject2, new d94());
                            if (d94Var != null) {
                                b(d94Var, od4Var);
                                yc4Var.b = d94Var;
                            }
                        } else if (c == 1) {
                            d94 d94Var2 = (d94) nd4.j(jSONObject2, new d94());
                            if (d94Var2 != null) {
                                b(d94Var2, od4Var2);
                                yc4Var2.a = d94Var2;
                            }
                        } else if (c == 2) {
                            b94 b94Var = (b94) nd4.j(jSONObject2, new b94());
                            if (b94Var != null) {
                                b(b94Var, od4Var);
                                yc4Var.c = b94Var;
                            }
                        } else if (c == 3) {
                            b94 b94Var2 = (b94) nd4.j(jSONObject2, new b94());
                            if (b94Var2 != null) {
                                b(b94Var2, od4Var2);
                                yc4Var2.c = b94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (yc4Var3.e == null) {
                                    yc4Var3.e = new ArrayList();
                                }
                                h94 h94Var = (h94) nd4.j(jSONObject2, new h94());
                                b(h94Var, od4Var3);
                                yc4Var3.e.add(h94Var);
                            }
                        } else if (w != null) {
                            w.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (b84Var != null) {
            if (od4Var.n() == 0) {
                b84Var.F();
            } else {
                b84Var.G(od4Var);
                r94.e(yc4Var, b84Var);
            }
        }
        if (b84Var2 != null) {
            if (od4Var2.n() == 0) {
                b84Var2.F();
            } else {
                b84Var2.G(od4Var2);
                r94.e(yc4Var2, b84Var2);
            }
        }
        if (w != null) {
            w.o();
        }
        if (od4Var3.n() <= 0 || r74.b() == null) {
            return;
        }
        r74.b().t(yc4Var3, od4Var3);
    }
}
