package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class wc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sc8 a(op opVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, opVar, i, i2)) == null) {
            if (opVar == null) {
                return null;
            }
            return b(opVar.k(), i, i2);
        }
        return (sc8) invokeLII.objValue;
    }

    public static sc8 b(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            sc8 sc8Var = new sc8();
            String str = advertAppInfo.k;
            if (advertAppInfo.f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            sc8Var.h(str);
            sc8Var.i(i);
            sc8Var.v(advertAppInfo.h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                sc8Var.d(-1);
                sc8Var.x(-1);
            } else {
                sc8Var.d(advertAppInfo.position + 1);
                sc8Var.x(i2);
            }
            return sc8Var;
        }
        return (sc8) invokeLII.objValue;
    }

    public static sc8 c(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            sc8 sc8Var = new sc8();
            String str = advertAppInfo.k;
            if (advertAppInfo.f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            sc8Var.h(str);
            sc8Var.i(i);
            sc8Var.v(advertAppInfo.h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                sc8Var.d(-1);
                sc8Var.x(-1);
            } else {
                sc8Var.d(advertAppInfo.position + 1);
                sc8Var.x(i2);
            }
            return sc8Var;
        }
        return (sc8) invokeLII.objValue;
    }

    public static sc8 d(DownloadStaticsData downloadStaticsData, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, downloadStaticsData, i, i2)) == null) {
            if (downloadStaticsData == null) {
                return null;
            }
            sc8 sc8Var = new sc8();
            sc8Var.t(downloadStaticsData);
            sc8Var.i(i);
            sc8Var.x(i2);
            return sc8Var;
        }
        return (sc8) invokeLII.objValue;
    }

    public static sc8 e(vk8 vk8Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, vk8Var, i)) == null) {
            if (vk8Var == null || vk8Var.getAdvertAppInfo() == null) {
                return null;
            }
            AdvertAppInfo advertAppInfo = vk8Var.getAdvertAppInfo();
            String O0 = vk8Var.O0();
            if (vk8Var.O0) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                O0 = "RETARGET";
            }
            sc8 sc8Var = new sc8();
            sc8Var.v(advertAppInfo.h);
            if (vk8Var.G0) {
                sc8Var.d(-1);
                sc8Var.x(-1);
            } else {
                sc8Var.d(vk8Var.N0 + 1);
                sc8Var.x(vk8Var.L0);
            }
            sc8Var.i(i);
            sc8Var.e(vk8Var.I0);
            sc8Var.f(vk8Var.J0);
            sc8Var.g(vk8Var.H0);
            sc8Var.h(O0);
            return sc8Var;
        }
        return (sc8) invokeLI.objValue;
    }

    public static sc8 f(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aqVar)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(aqVar.a);
            sc8Var.d(aqVar.c);
            sc8Var.h(aqVar.b);
            sc8Var.v(aqVar.d);
            return sc8Var;
        }
        return (sc8) invokeL.objValue;
    }

    public static sc8 g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(i);
            sc8Var.d(i2);
            sc8Var.x(i3);
            return sc8Var;
        }
        return (sc8) invokeIII.objValue;
    }

    public static sc8 h(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, advertAppInfo, i, i2, i3)) == null) {
            sc8 b = b(advertAppInfo, i, i2);
            b.j(i3);
            return b;
        }
        return (sc8) invokeLIII.objValue;
    }

    public static sc8 i(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, advertAppInfo, i, i2, i3)) == null) {
            sc8 c = c(advertAppInfo, i, i2);
            c.j(i3);
            return c;
        }
        return (sc8) invokeLIII.objValue;
    }

    public static sc8 j(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i, str2)) == null) ? k(str, i, str2, "") : (sc8) invokeLIL.objValue;
    }

    public static sc8 k(String str, int i, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65546, null, str, i, str2, str3)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(i);
            sc8Var.y(str2);
            sc8Var.h("HOMEPAGE");
            sc8Var.v(str);
            sc8Var.c(str3);
            return sc8Var;
        }
        return (sc8) invokeLILL.objValue;
    }

    public static sc8 l(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            sc8 b = b(advertAppInfo, i, i2);
            b.j(i3);
            b.l(Math.round(i5 / 1000.0f));
            b.n(i4);
            if (i6 != -1 && i == 32) {
                b.r(i6);
            }
            b.h(advertAppInfo.k);
            if (i == 2) {
                b.w("video");
            }
            if (i == 34) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", i4);
                    jSONObject.put("position", i5);
                    jSONObject.put("start_type", i3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                b.z(jSONObject.toString());
            }
            if (i == 102) {
                b.c("replaybtn");
            }
            return b;
        }
        return (sc8) invokeCommon.objValue;
    }

    public static sc8 m(op opVar, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{opVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            sc8 a = a(opVar, i, i2);
            a.j(i3);
            a.l(i5);
            a.n(i4);
            if (i6 != -1 && i == 32) {
                a.r(i6);
            }
            if (opVar != null) {
                a.h(opVar.k().k);
            }
            if (i == 2) {
                a.w("video");
            }
            return a;
        }
        return (sc8) invokeCommon.objValue;
    }

    public static sc8 n(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aqVar)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(aqVar.a);
            sc8Var.d(aqVar.c);
            sc8Var.h(aqVar.b);
            sc8Var.v(aqVar.d);
            return sc8Var;
        }
        return (sc8) invokeL.objValue;
    }

    public static sc8 o(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, aqVar)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(aqVar.a);
            sc8Var.d(aqVar.c);
            sc8Var.h(aqVar.b);
            sc8Var.v(aqVar.d);
            sc8Var.j(aqVar.k);
            if (!TextUtils.isEmpty(aqVar.j)) {
                sc8Var.u(aqVar.j);
            }
            sc8Var.n(aqVar.l);
            return sc8Var;
        }
        return (sc8) invokeL.objValue;
    }

    public static sc8 p(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, aqVar)) == null) {
            sc8 sc8Var = new sc8();
            sc8Var.i(aqVar.a);
            sc8Var.d(aqVar.c);
            sc8Var.h(aqVar.b);
            sc8Var.v(aqVar.d);
            sc8Var.j(0);
            sc8Var.l(aqVar.f);
            sc8Var.n(aqVar.e);
            sc8Var.p(aqVar.g);
            return sc8Var;
        }
        return (sc8) invokeL.objValue;
    }
}
