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
public class bd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bd4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public bd4() {
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

    public static bd4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (bd4.class) {
                    if (a == null) {
                        a = new bd4();
                    }
                }
            }
            return a;
        }
        return (bd4) invokeV.objValue;
    }

    public static void b(g94 g94Var, qd4 qd4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, g94Var, qd4Var) == null) || g94Var == null) {
            return;
        }
        qd4Var.a(g94Var, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, d84 d84Var, d84 d84Var2, d84 d84Var3) {
        char c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, jSONArray, d84Var, d84Var2, d84Var3) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        ad4 ad4Var = new ad4();
        ad4 ad4Var2 = new ad4();
        ad4 ad4Var3 = new ad4();
        qd4 qd4Var = new qd4();
        qd4 qd4Var2 = new qd4();
        qd4 qd4Var3 = new qd4();
        cd4 x = d84Var3 != null ? d84Var3.x("so") : null;
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
                            f94 f94Var = (f94) pd4.j(jSONObject2, new f94());
                            if (f94Var != null) {
                                b(f94Var, qd4Var);
                                ad4Var.b = f94Var;
                            }
                        } else if (c == 1) {
                            f94 f94Var2 = (f94) pd4.j(jSONObject2, new f94());
                            if (f94Var2 != null) {
                                b(f94Var2, qd4Var2);
                                ad4Var2.a = f94Var2;
                            }
                        } else if (c == 2) {
                            d94 d94Var = (d94) pd4.j(jSONObject2, new d94());
                            if (d94Var != null) {
                                b(d94Var, qd4Var);
                                ad4Var.c = d94Var;
                            }
                        } else if (c == 3) {
                            d94 d94Var2 = (d94) pd4.j(jSONObject2, new d94());
                            if (d94Var2 != null) {
                                b(d94Var2, qd4Var2);
                                ad4Var2.c = d94Var2;
                            }
                        } else if (c != 4) {
                            if (c == 5) {
                                if (ad4Var3.e == null) {
                                    ad4Var3.e = new ArrayList();
                                }
                                j94 j94Var = (j94) pd4.j(jSONObject2, new j94());
                                b(j94Var, qd4Var3);
                                ad4Var3.e.add(j94Var);
                            }
                        } else if (x != null) {
                            x.l(jSONObject2);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (d84Var != null) {
            if (qd4Var.n() == 0) {
                d84Var.G();
            } else {
                d84Var.H(qd4Var);
                t94.e(ad4Var, d84Var);
            }
        }
        if (d84Var2 != null) {
            if (qd4Var2.n() == 0) {
                d84Var2.G();
            } else {
                d84Var2.H(qd4Var2);
                t94.e(ad4Var2, d84Var2);
            }
        }
        if (x != null) {
            x.p();
        }
        if (qd4Var3.n() <= 0 || t74.b() == null) {
            return;
        }
        t74.b().t(ad4Var3, qd4Var3);
    }
}
