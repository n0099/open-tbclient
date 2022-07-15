package com.repackage;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import com.repackage.e49;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class l49 extends q49 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public l49() {
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

    public static void b(u39 u39Var, y39 y39Var, w39 w39Var, o39 o39Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{u39Var, y39Var, w39Var, o39Var, list, list2, list3}) == null) {
            u39Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            y39Var.a(n49.e().I());
            w39Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            o39Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.q49
    public final void a() {
        e49 e49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e49Var = e49.a.a;
            if (e49Var.a().size() == 0) {
                o49.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(j49.l(n39.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            u39 u39Var = new u39();
            y39 y39Var = new y39();
            w39 w39Var = new w39();
            o39 o39Var = new o39();
            List<com.baidu.ubs.analytics.a.i> a2 = u39Var.a();
            List<com.baidu.ubs.analytics.a.n> d = y39Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = w39Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = o39Var.a();
            o49.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                o49.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            y39Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = n39.h().j();
            if (n39.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : n39.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        w49.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(j49.l(n39.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(j49.g(n39.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(j49.h(n39.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(g49.d() ? "1" : "0");
            aVar.k(j49.i(n39.h().getContext()));
            aVar.m(j49.j(n39.h().getContext()));
            aVar.n(j49.m());
            aVar.o(j49.n());
            aVar.p(j49.a());
            int f = j49.f(n39.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            n39.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = u49.a(bVar);
            String e2 = t49.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (z39.a(n39.h().getContext(), stringBuffer2.toString())) {
                    o49.b("上传成功，删除本地文件的       ");
                    t49.b(a + "ABJson.log");
                    b(u39Var, y39Var, w39Var, o39Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (z39.a(n39.h().getContext(), stringBuffer3.toString())) {
                    b(u39Var, y39Var, w39Var, o39Var, a3, a2, a4);
                    return;
                } else if (t49.d(a5, a, "ABJson.log")) {
                    b(u39Var, y39Var, w39Var, o39Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (z39.a(n39.h().getContext(), stringBuffer4.toString())) {
                b(u39Var, y39Var, w39Var, o39Var, a3, a2, a4);
            } else if (t49.d(a5, a, "ABJson.log")) {
                b(u39Var, y39Var, w39Var, o39Var, a3, a2, a4);
            }
        }
    }
}
