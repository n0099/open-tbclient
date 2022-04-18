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
import com.repackage.z69;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g79 extends l79 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public g79() {
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

    public static void b(p69 p69Var, t69 t69Var, r69 r69Var, j69 j69Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{p69Var, t69Var, r69Var, j69Var, list, list2, list3}) == null) {
            p69Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            t69Var.a(i79.f().I());
            r69Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            j69Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.l79
    public final void a() {
        z69 z69Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            z69Var = z69.a.a;
            if (z69Var.a().size() == 0) {
                j79.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(e79.l(i69.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            p69 p69Var = new p69();
            t69 t69Var = new t69();
            r69 r69Var = new r69();
            j69 j69Var = new j69();
            List<com.baidu.ubs.analytics.a.i> a2 = p69Var.a();
            List<com.baidu.ubs.analytics.a.n> d = t69Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = r69Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = j69Var.a();
            j79.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                j79.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            t69Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = i69.h().j();
            if (i69.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : i69.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        r79.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(e79.l(i69.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(e79.g(i69.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(e79.h(i69.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(b79.d() ? "1" : "0");
            aVar.k(e79.i(i69.h().getContext()));
            aVar.m(e79.j(i69.h().getContext()));
            aVar.n(e79.m());
            aVar.o(e79.n());
            aVar.p(e79.a());
            int f = e79.f(i69.h().getContext());
            aVar.l(f == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            i69.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = p79.a(bVar);
            String e2 = o79.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (u69.a(i69.h().getContext(), stringBuffer2.toString())) {
                    j79.b("上传成功，删除本地文件的       ");
                    o79.b(a + "ABJson.log");
                    b(p69Var, t69Var, r69Var, j69Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (u69.a(i69.h().getContext(), stringBuffer3.toString())) {
                    b(p69Var, t69Var, r69Var, j69Var, a3, a2, a4);
                    return;
                } else if (o79.d(a5, a, "ABJson.log")) {
                    b(p69Var, t69Var, r69Var, j69Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (u69.a(i69.h().getContext(), stringBuffer4.toString())) {
                b(p69Var, t69Var, r69Var, j69Var, a3, a2, a4);
            } else if (o79.d(a5, a, "ABJson.log")) {
                b(p69Var, t69Var, r69Var, j69Var, a3, a2, a4);
            }
        }
    }
}
