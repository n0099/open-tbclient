package com.repackage;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import com.repackage.f39;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class m39 extends r39 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public m39() {
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

    public static void b(v29 v29Var, z29 z29Var, x29 x29Var, p29 p29Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{v29Var, z29Var, x29Var, p29Var, list, list2, list3}) == null) {
            v29Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            z29Var.a(o39.f().I());
            x29Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            p29Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.r39
    public final void a() {
        f39 f39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f39Var = f39.a.a;
            if (f39Var.a().size() == 0) {
                p39.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(k39.l(o29.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            v29 v29Var = new v29();
            z29 z29Var = new z29();
            x29 x29Var = new x29();
            p29 p29Var = new p29();
            List<com.baidu.ubs.analytics.a.i> a2 = v29Var.a();
            List<com.baidu.ubs.analytics.a.n> d = z29Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = x29Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = p29Var.a();
            p39.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                p39.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            z29Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = o29.h().j();
            if (o29.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : o29.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        x39.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(k39.l(o29.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(k39.g(o29.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(k39.h(o29.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(h39.d() ? "1" : "0");
            aVar.k(k39.i(o29.h().getContext()));
            aVar.m(k39.j(o29.h().getContext()));
            aVar.n(k39.m());
            aVar.o(k39.n());
            aVar.p(k39.a());
            int f = k39.f(o29.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            o29.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = v39.a(bVar);
            String e2 = u39.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (a39.a(o29.h().getContext(), stringBuffer2.toString())) {
                    p39.b("上传成功，删除本地文件的       ");
                    u39.b(a + "ABJson.log");
                    b(v29Var, z29Var, x29Var, p29Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (a39.a(o29.h().getContext(), stringBuffer3.toString())) {
                    b(v29Var, z29Var, x29Var, p29Var, a3, a2, a4);
                    return;
                } else if (u39.d(a5, a, "ABJson.log")) {
                    b(v29Var, z29Var, x29Var, p29Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (a39.a(o29.h().getContext(), stringBuffer4.toString())) {
                b(v29Var, z29Var, x29Var, p29Var, a3, a2, a4);
            } else if (u39.d(a5, a, "ABJson.log")) {
                b(v29Var, z29Var, x29Var, p29Var, a3, a2, a4);
            }
        }
    }
}
