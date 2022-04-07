package com.repackage;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import com.repackage.s69;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class z69 extends e79 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public z69() {
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

    public static void b(i69 i69Var, m69 m69Var, k69 k69Var, c69 c69Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{i69Var, m69Var, k69Var, c69Var, list, list2, list3}) == null) {
            i69Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            m69Var.a(b79.f().I());
            k69Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            c69Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.e79
    public final void a() {
        s69 s69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s69Var = s69.a.a;
            if (s69Var.a().size() == 0) {
                c79.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(x69.l(b69.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            i69 i69Var = new i69();
            m69 m69Var = new m69();
            k69 k69Var = new k69();
            c69 c69Var = new c69();
            List<com.baidu.ubs.analytics.a.i> a2 = i69Var.a();
            List<com.baidu.ubs.analytics.a.n> d = m69Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = k69Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = c69Var.a();
            c79.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                c79.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            m69Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = b69.h().j();
            if (b69.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : b69.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        k79.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(x69.l(b69.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(x69.g(b69.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(x69.h(b69.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(u69.d() ? "1" : "0");
            aVar.k(x69.i(b69.h().getContext()));
            aVar.m(x69.j(b69.h().getContext()));
            aVar.n(x69.m());
            aVar.o(x69.n());
            aVar.p(x69.a());
            int f = x69.f(b69.h().getContext());
            aVar.l(f == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            b69.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = i79.a(bVar);
            String e2 = h79.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (n69.a(b69.h().getContext(), stringBuffer2.toString())) {
                    c79.b("上传成功，删除本地文件的       ");
                    h79.b(a + "ABJson.log");
                    b(i69Var, m69Var, k69Var, c69Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (n69.a(b69.h().getContext(), stringBuffer3.toString())) {
                    b(i69Var, m69Var, k69Var, c69Var, a3, a2, a4);
                    return;
                } else if (h79.d(a5, a, "ABJson.log")) {
                    b(i69Var, m69Var, k69Var, c69Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (n69.a(b69.h().getContext(), stringBuffer4.toString())) {
                b(i69Var, m69Var, k69Var, c69Var, a3, a2, a4);
            } else if (h79.d(a5, a, "ABJson.log")) {
                b(i69Var, m69Var, k69Var, c69Var, a3, a2, a4);
            }
        }
    }
}
