package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public g0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                d1 d1Var = new d1(str, q0.f55426f);
                d1Var.e(l1.g(this.a));
                d1Var.j(l1.l());
                d1Var.c(l1.e(this.a));
                d1Var.b(l1.d(this.a));
                d1Var.h(l1.f(this.a));
                d1Var.k("2.8.3");
                d1Var.f("");
                d1Var.a(l1.a);
                JSONObject a = d1Var.a(this.a);
                JSONObject a2 = a();
                if (a != null && a2 != null) {
                    a.put("module_section", a2);
                    return a.toString();
                }
                return null;
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                j0 j0Var = new j0(this.a);
                jSONObject.put("0", j0Var.e());
                jSONObject.put("1", j0Var.a());
                jSONObject.put("3", j0Var.c());
                jSONObject.put("24", j0Var.d());
                jSONObject.put("35", a0.a() ? 1 : 0);
                jSONObject.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, a0.a(this.a) ? 1 : 0);
                Object a = i0.a(this.a);
                if (a != null) {
                    jSONObject.put("4", a);
                }
                jSONObject.put("5", i0.a());
                jSONObject.put("49", new y().a(this.a));
                jSONObject.put("22", a0.c());
                b0 b0Var = new b0();
                jSONObject.put("7", b0Var.a() ? 1 : 0);
                boolean d2 = b0Var.d(this.a);
                jSONObject.put("8", d2 ? 1 : 0);
                if (d2) {
                    jSONObject.put("61", b0Var.c(this.a));
                }
                jSONObject.put("9", b0Var.a(this.a));
                jSONObject.put("10", b0Var.e(this.a));
                jSONObject.put("11", b0Var.b(this.a));
                e0 e0Var = new e0();
                jSONObject.put("26", e0Var.a("cpuinfo") ? 1 : 0);
                jSONObject.put("27", e0Var.a("meminfo") ? 1 : 0);
                jSONObject.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, e0Var.b("/proc/cpuinfo") ? 1 : 0);
                jSONObject.put("29", e0Var.b(HardwareInfoUtils.MEM_INFO_FILE) ? 1 : 0);
                jSONObject.put("96", e0Var.a());
                m0 m0Var = new m0();
                Set<String> c2 = m0Var.c();
                Set<String> d3 = m0Var.d();
                if (d3 != null) {
                    jSONObject.put("30", 1);
                    jSONObject.put("32", new JSONArray((Collection) d3));
                } else {
                    jSONObject.put("30", 0);
                }
                if (c2 != null) {
                    jSONObject.put("31", 1);
                    jSONObject.put("33", new JSONArray((Collection) c2));
                } else {
                    jSONObject.put("31", 0);
                }
                Object b2 = m0Var.b();
                if (b2 != null) {
                    jSONObject.put("34", b2);
                    if (c2 != null || d3 != null) {
                        HashSet hashSet = new HashSet();
                        if (c2 != null) {
                            hashSet.add(c2);
                        }
                        if (d3 != null) {
                            hashSet.add(d3);
                        }
                        jSONObject.put("13", m0Var.a(this.a, 13, hashSet));
                        jSONObject.put("14", m0Var.a(this.a, 14, hashSet));
                        jSONObject.put("15", m0Var.a(this.a, 15, hashSet));
                        jSONObject.put("16", m0Var.a(this.a, 16, hashSet));
                        jSONObject.put("17", m0Var.a(this.a, 17, hashSet));
                        jSONObject.put("18", m0Var.a(this.a, 18, hashSet));
                        jSONObject.put("19", m0Var.a(this.a, 19, hashSet));
                        jSONObject.put(UVEventType.PAY_WALLET_BANNER_SHOW, m0Var.a(this.a, 20, hashSet));
                        jSONObject.put("21", m0Var.a(this.a, 21, hashSet));
                    }
                }
                l0 l0Var = new l0();
                jSONObject.put("65", l0Var.f() ? 1 : 0);
                boolean e2 = l0Var.e();
                jSONObject.put("66", e2 ? 1 : 0);
                if (e2) {
                    jSONObject.put("67", l0Var.g() ? 1 : 0);
                }
                jSONObject.put("68", l0Var.c() ? 1 : 0);
                jSONObject.put("69", l0Var.b());
                jSONObject.put("101", l0Var.d() ? 1 : 0);
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY, l0Var.a() ? 1 : 0);
                jSONObject.put("99", new h0().a());
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, new c0().a() ? 1 : 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", w1.c(this.a));
                jSONObject2.put("03014", x0.y(this.a));
                jSONObject2.put("03020", w1.a(this.a));
                jSONObject2.put("03030", x0.u(this.a));
                jSONObject.put("51", jSONObject2);
                jSONObject.put("58", e0.a(this.a));
                jSONObject.put("59", e0.b(this.a));
                jSONObject.put("60", a0.b(this.a) ? 1 : 0);
                jSONObject.put("128", c0.b() ? 1 : 0);
                jSONObject.put("151", k0.a());
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            } catch (Throwable th) {
                x0.a(th);
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
