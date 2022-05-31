package com.repackage;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import com.repackage.x29;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class e39 extends j39 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public e39() {
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

    public static void b(n29 n29Var, r29 r29Var, p29 p29Var, h29 h29Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{n29Var, r29Var, p29Var, h29Var, list, list2, list3}) == null) {
            n29Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            r29Var.a(g39.f().I());
            p29Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            h29Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.j39
    public final void a() {
        x29 x29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            x29Var = x29.a.a;
            if (x29Var.a().size() == 0) {
                h39.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(c39.l(g29.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            n29 n29Var = new n29();
            r29 r29Var = new r29();
            p29 p29Var = new p29();
            h29 h29Var = new h29();
            List<com.baidu.ubs.analytics.a.i> a2 = n29Var.a();
            List<com.baidu.ubs.analytics.a.n> d = r29Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = p29Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = h29Var.a();
            h39.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                h39.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            r29Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = g29.h().j();
            if (g29.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : g29.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        p39.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(c39.l(g29.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(c39.g(g29.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(c39.h(g29.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(z29.d() ? "1" : "0");
            aVar.k(c39.i(g29.h().getContext()));
            aVar.m(c39.j(g29.h().getContext()));
            aVar.n(c39.m());
            aVar.o(c39.n());
            aVar.p(c39.a());
            int f = c39.f(g29.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            g29.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = n39.a(bVar);
            String e2 = m39.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (s29.a(g29.h().getContext(), stringBuffer2.toString())) {
                    h39.b("上传成功，删除本地文件的       ");
                    m39.b(a + "ABJson.log");
                    b(n29Var, r29Var, p29Var, h29Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (s29.a(g29.h().getContext(), stringBuffer3.toString())) {
                    b(n29Var, r29Var, p29Var, h29Var, a3, a2, a4);
                    return;
                } else if (m39.d(a5, a, "ABJson.log")) {
                    b(n29Var, r29Var, p29Var, h29Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (s29.a(g29.h().getContext(), stringBuffer4.toString())) {
                b(n29Var, r29Var, p29Var, h29Var, a3, a2, a4);
            } else if (m39.d(a5, a, "ABJson.log")) {
                b(n29Var, r29Var, p29Var, h29Var, a3, a2, a4);
            }
        }
    }
}
