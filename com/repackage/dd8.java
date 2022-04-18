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
/* loaded from: classes5.dex */
public class dd8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zc8 a(op opVar, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, opVar, i, i2)) == null) {
            if (opVar == null) {
                return null;
            }
            return b(opVar.k(), i, i2);
        }
        return (zc8) invokeLII.objValue;
    }

    public static zc8 b(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            zc8 zc8Var = new zc8();
            String str = advertAppInfo.k;
            if (advertAppInfo.f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            zc8Var.h(str);
            zc8Var.i(i);
            zc8Var.v(advertAppInfo.h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                zc8Var.d(-1);
                zc8Var.x(-1);
            } else {
                zc8Var.d(advertAppInfo.position + 1);
                zc8Var.x(i2);
            }
            return zc8Var;
        }
        return (zc8) invokeLII.objValue;
    }

    public static zc8 c(AdvertAppInfo advertAppInfo, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, advertAppInfo, i, i2)) == null) {
            if (advertAppInfo == null) {
                return null;
            }
            zc8 zc8Var = new zc8();
            String str = advertAppInfo.k;
            if (advertAppInfo.f) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                str = "RETARGET";
            }
            zc8Var.h(str);
            zc8Var.i(i);
            zc8Var.v(advertAppInfo.h);
            if ("PB_BANNER".equals(advertAppInfo.k)) {
                zc8Var.d(-1);
                zc8Var.x(-1);
            } else {
                zc8Var.d(advertAppInfo.position + 1);
                zc8Var.x(i2);
            }
            return zc8Var;
        }
        return (zc8) invokeLII.objValue;
    }

    public static zc8 d(DownloadStaticsData downloadStaticsData, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, downloadStaticsData, i, i2)) == null) {
            if (downloadStaticsData == null) {
                return null;
            }
            zc8 zc8Var = new zc8();
            zc8Var.t(downloadStaticsData);
            zc8Var.i(i);
            zc8Var.x(i2);
            return zc8Var;
        }
        return (zc8) invokeLII.objValue;
    }

    public static zc8 e(cl8 cl8Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, cl8Var, i)) == null) {
            if (cl8Var == null || cl8Var.getAdvertAppInfo() == null) {
                return null;
            }
            AdvertAppInfo advertAppInfo = cl8Var.getAdvertAppInfo();
            String O0 = cl8Var.O0();
            if (cl8Var.O0) {
                if (i == 3) {
                    i = 103;
                } else if (i == 2) {
                    i = 102;
                }
                O0 = "RETARGET";
            }
            zc8 zc8Var = new zc8();
            zc8Var.v(advertAppInfo.h);
            if (cl8Var.G0) {
                zc8Var.d(-1);
                zc8Var.x(-1);
            } else {
                zc8Var.d(cl8Var.N0 + 1);
                zc8Var.x(cl8Var.L0);
            }
            zc8Var.i(i);
            zc8Var.e(cl8Var.I0);
            zc8Var.f(cl8Var.J0);
            zc8Var.g(cl8Var.H0);
            zc8Var.h(O0);
            return zc8Var;
        }
        return (zc8) invokeLI.objValue;
    }

    public static zc8 f(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aqVar)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(aqVar.a);
            zc8Var.d(aqVar.c);
            zc8Var.h(aqVar.b);
            zc8Var.v(aqVar.d);
            return zc8Var;
        }
        return (zc8) invokeL.objValue;
    }

    public static zc8 g(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(i);
            zc8Var.d(i2);
            zc8Var.x(i3);
            return zc8Var;
        }
        return (zc8) invokeIII.objValue;
    }

    public static zc8 h(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65543, null, advertAppInfo, i, i2, i3)) == null) {
            zc8 b = b(advertAppInfo, i, i2);
            b.j(i3);
            return b;
        }
        return (zc8) invokeLIII.objValue;
    }

    public static zc8 i(AdvertAppInfo advertAppInfo, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, null, advertAppInfo, i, i2, i3)) == null) {
            zc8 c = c(advertAppInfo, i, i2);
            c.j(i3);
            return c;
        }
        return (zc8) invokeLIII.objValue;
    }

    public static zc8 j(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, str, i, str2)) == null) ? k(str, i, str2, "") : (zc8) invokeLIL.objValue;
    }

    public static zc8 k(String str, int i, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65546, null, str, i, str2, str3)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(i);
            zc8Var.y(str2);
            zc8Var.h("HOMEPAGE");
            zc8Var.v(str);
            zc8Var.c(str3);
            return zc8Var;
        }
        return (zc8) invokeLILL.objValue;
    }

    public static zc8 l(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            zc8 b = b(advertAppInfo, i, i2);
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
        return (zc8) invokeCommon.objValue;
    }

    public static zc8 m(op opVar, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{opVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            zc8 a = a(opVar, i, i2);
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
        return (zc8) invokeCommon.objValue;
    }

    public static zc8 n(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, aqVar)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(aqVar.a);
            zc8Var.d(aqVar.c);
            zc8Var.h(aqVar.b);
            zc8Var.v(aqVar.d);
            return zc8Var;
        }
        return (zc8) invokeL.objValue;
    }

    public static zc8 o(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, aqVar)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(aqVar.a);
            zc8Var.d(aqVar.c);
            zc8Var.h(aqVar.b);
            zc8Var.v(aqVar.d);
            zc8Var.j(aqVar.k);
            if (!TextUtils.isEmpty(aqVar.j)) {
                zc8Var.u(aqVar.j);
            }
            zc8Var.n(aqVar.l);
            return zc8Var;
        }
        return (zc8) invokeL.objValue;
    }

    public static zc8 p(@NonNull aq aqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, aqVar)) == null) {
            zc8 zc8Var = new zc8();
            zc8Var.i(aqVar.a);
            zc8Var.d(aqVar.c);
            zc8Var.h(aqVar.b);
            zc8Var.v(aqVar.d);
            zc8Var.j(0);
            zc8Var.l(aqVar.f);
            zc8Var.n(aqVar.e);
            zc8Var.p(aqVar.g);
            return zc8Var;
        }
        return (zc8) invokeL.objValue;
    }
}
