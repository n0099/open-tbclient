package com.repackage;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.b;
import com.repackage.u59;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b69 extends g69 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public b69() {
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

    public static void b(k59 k59Var, o59 o59Var, m59 m59Var, e59 e59Var, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{k59Var, o59Var, m59Var, e59Var, list, list2, list3}) == null) {
            k59Var.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
            o59Var.a(d69.f().I());
            m59Var.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
            e59Var.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
        }
    }

    @Override // com.repackage.g69
    public final void a() {
        u59 u59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u59Var = u59.a.a;
            if (u59Var.a().size() == 0) {
                e69.b(" 线程轮询  app 应该是退出了");
            }
            if (a == null && Environment.getExternalStorageState().equals("mounted")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
                stringBuffer.append("/baidu/ab/");
                stringBuffer.append(z59.l(d59.h().getContext()));
                stringBuffer.append("/");
                a = stringBuffer.toString();
            }
            k59 k59Var = new k59();
            o59 o59Var = new o59();
            m59 m59Var = new m59();
            e59 e59Var = new e59();
            List<com.baidu.ubs.analytics.a.i> a2 = k59Var.a();
            List<com.baidu.ubs.analytics.a.n> d = o59Var.d();
            List<com.baidu.ubs.analytics.a.l> a3 = m59Var.a();
            List<com.baidu.ubs.analytics.a.a> a4 = e59Var.a();
            e69.b("这次查询结果       session ：    " + d.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
            if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
                e69.b("这次记录 json 为空的，就不传了  ………………");
                if (d.size() > 1) {
                    for (int i = 0; i < d.size(); i++) {
                        if (d.get(i).O() == null) {
                            o59Var.c(d.get(i).I());
                        }
                    }
                    return;
                }
                return;
            }
            JSONArray jSONArray = new JSONArray();
            String j = d59.h().j();
            if (d59.h().k() != null) {
                for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : d59.h().k().entrySet()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("exp_id", entry.getKey());
                        jSONObject.put("sid", entry.getValue().L());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        m69.d(e);
                    }
                }
            }
            com.baidu.ubs.analytics.b bVar = new com.baidu.ubs.analytics.b();
            b.a aVar = new b.a();
            aVar.r(z59.l(d59.h().getContext()));
            aVar.b(j);
            aVar.q(jSONArray.toString());
            aVar.g(Build.VERSION.RELEASE);
            aVar.d(z59.g(d59.h().getContext()));
            aVar.f(Build.MODEL);
            aVar.e(Build.BRAND);
            aVar.f(Build.MODEL);
            aVar.h(z59.h(d59.h().getContext()));
            aVar.i(com.baidu.ubs.analytics.d.a.c());
            aVar.j(w59.d() ? "1" : "0");
            aVar.k(z59.i(d59.h().getContext()));
            aVar.m(z59.j(d59.h().getContext()));
            aVar.n(z59.m());
            aVar.o(z59.n());
            aVar.p(z59.a());
            int f = z59.f(d59.h().getContext());
            aVar.l(f == 1 ? "WIFI" : f == 2 ? "2G" : f == 3 ? "3G" : f == 4 ? "4G" : f == 5 ? "unKnow" : "noNet");
            d59.h();
            aVar.setPhone("");
            bVar.a(aVar);
            bVar.c(a4);
            bVar.e(a2);
            bVar.b(d);
            bVar.d(a3);
            String a5 = k69.a(bVar);
            String e2 = j69.e(a, "ABJson.log");
            if (!e2.equals("")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer2.append(e2);
                stringBuffer2.append(a5);
                stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
                if (p59.a(d59.h().getContext(), stringBuffer2.toString())) {
                    e69.b("上传成功，删除本地文件的       ");
                    j69.b(a + "ABJson.log");
                    b(k59Var, o59Var, m59Var, e59Var, a3, a2, a4);
                    return;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
                stringBuffer3.append(a5);
                stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
                if (p59.a(d59.h().getContext(), stringBuffer3.toString())) {
                    b(k59Var, o59Var, m59Var, e59Var, a3, a2, a4);
                    return;
                } else if (j69.d(a5, a, "ABJson.log")) {
                    b(k59Var, o59Var, m59Var, e59Var, a3, a2, a4);
                    return;
                } else {
                    return;
                }
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer4.append(a5);
            stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
            if (p59.a(d59.h().getContext(), stringBuffer4.toString())) {
                b(k59Var, o59Var, m59Var, e59Var, a3, a2, a4);
            } else if (j69.d(a5, a, "ABJson.log")) {
                b(k59Var, o59Var, m59Var, e59Var, a3, a2, a4);
            }
        }
    }
}
