package d.a.s0.a.e;

import android.os.Build;
import android.os.Environment;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.ubs.analytics.a.n;
import com.baidu.ubs.analytics.b;
import d.a.s0.a.c;
import d.a.s0.a.e.d;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class k extends d.a.s0.a.f.c {

    /* renamed from: e  reason: collision with root package name */
    public static String f68268e;

    public static void b(c.h hVar, c.l lVar, c.j jVar, c.b bVar, List<com.baidu.ubs.analytics.a.l> list, List<com.baidu.ubs.analytics.a.i> list2, List<com.baidu.ubs.analytics.a.a> list3) {
        hVar.b(list2.size() != 0 ? list2.get(list2.size() - 1).getId() : 0);
        lVar.a(m.d().I());
        jVar.b(list.size() != 0 ? list.get(list.size() - 1).getId() : 0);
        bVar.b(list3.size() != 0 ? list3.get(list3.size() - 1).getId() : 0);
    }

    @Override // d.a.s0.a.f.c
    public final void a() {
        d dVar;
        dVar = d.a.f68247a;
        if (dVar.a().size() == 0) {
            d.a.s0.a.f.a.b(" 线程轮询  app 应该是退出了");
        }
        if (f68268e == null && Environment.getExternalStorageState().equals("mounted")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Environment.getExternalStorageDirectory().getPath());
            stringBuffer.append("/baidu/ab/");
            stringBuffer.append(i.l(d.a.s0.a.c.i().g()));
            stringBuffer.append("/");
            f68268e = stringBuffer.toString();
        }
        c.h hVar = new c.h();
        c.l lVar = new c.l();
        c.j jVar = new c.j();
        c.b bVar = new c.b();
        List<com.baidu.ubs.analytics.a.i> a2 = hVar.a();
        List<n> d2 = lVar.d();
        List<com.baidu.ubs.analytics.a.l> a3 = jVar.a();
        List<com.baidu.ubs.analytics.a.a> a4 = bVar.a();
        d.a.s0.a.f.a.b("这次查询结果       session ：    " + d2.size() + "      点击事件   " + a4.size() + "    网络请求：  " + a2.size() + "    页面记录     " + a3.size());
        if (a2.size() == 0 && a3.size() == 0 && a4.size() == 0) {
            d.a.s0.a.f.a.b("这次记录 json 为空的，就不传了  ………………");
            if (d2.size() > 1) {
                for (int i2 = 0; i2 < d2.size(); i2++) {
                    if (d2.get(i2).O() == null) {
                        lVar.c(d2.get(i2).I());
                    }
                }
                return;
            }
            return;
        }
        JSONArray jSONArray = new JSONArray();
        String k = d.a.s0.a.c.i().k();
        if (d.a.s0.a.c.i().l() != null) {
            for (Map.Entry<String, com.baidu.ubs.analytics.a.g> entry : d.a.s0.a.c.i().l().entrySet()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("exp_id", entry.getKey());
                    jSONObject.put("sid", entry.getValue().L());
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    d.a.s0.a.f.i.d(e2);
                }
            }
        }
        com.baidu.ubs.analytics.b bVar2 = new com.baidu.ubs.analytics.b();
        b.a aVar = new b.a();
        aVar.r(i.l(d.a.s0.a.c.i().g()));
        aVar.b(k);
        aVar.q(jSONArray.toString());
        aVar.g(Build.VERSION.RELEASE);
        aVar.d(i.g(d.a.s0.a.c.i().g()));
        aVar.f(Build.MODEL);
        aVar.e(Build.BRAND);
        aVar.f(Build.MODEL);
        aVar.h(i.h(d.a.s0.a.c.i().g()));
        aVar.i(com.baidu.ubs.analytics.d.a.c());
        aVar.j(f.d() ? "1" : "0");
        aVar.k(i.i(d.a.s0.a.c.i().g()));
        aVar.m(i.j(d.a.s0.a.c.i().g()));
        aVar.n(i.m());
        aVar.o(i.n());
        aVar.p(i.a());
        int f2 = i.f(d.a.s0.a.c.i().g());
        aVar.l(f2 == 1 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : f2 == 2 ? "2G" : f2 == 3 ? com.baidu.apollon.statistics.g.f3985b : f2 == 4 ? "4G" : f2 == 5 ? "unKnow" : "noNet");
        d.a.s0.a.c.i();
        aVar.setPhone("");
        bVar2.a(aVar);
        bVar2.c(a4);
        bVar2.e(a2);
        bVar2.b(d2);
        bVar2.d(a3);
        String a5 = d.a.s0.a.f.g.a(bVar2);
        String e3 = d.a.s0.a.f.f.e(f68268e, "ABJson.log");
        if (!e3.equals("")) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer2.append(e3);
            stringBuffer2.append(a5);
            stringBuffer2.append(PreferencesUtil.RIGHT_MOUNT);
            if (d.a.s0.a.d.a.a(d.a.s0.a.c.i().g(), stringBuffer2.toString())) {
                d.a.s0.a.f.a.b("上传成功，删除本地文件的       ");
                d.a.s0.a.f.f.b(f68268e + "ABJson.log");
                b(hVar, lVar, jVar, bVar, a3, a2, a4);
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(PreferencesUtil.LEFT_MOUNT);
            stringBuffer3.append(a5);
            stringBuffer3.append(PreferencesUtil.RIGHT_MOUNT);
            if (d.a.s0.a.d.a.a(d.a.s0.a.c.i().g(), stringBuffer3.toString())) {
                b(hVar, lVar, jVar, bVar, a3, a2, a4);
                return;
            } else if (d.a.s0.a.f.f.d(a5, f68268e, "ABJson.log")) {
                b(hVar, lVar, jVar, bVar, a3, a2, a4);
                return;
            } else {
                return;
            }
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(PreferencesUtil.LEFT_MOUNT);
        stringBuffer4.append(a5);
        stringBuffer4.append(PreferencesUtil.RIGHT_MOUNT);
        if (d.a.s0.a.d.a.a(d.a.s0.a.c.i().g(), stringBuffer4.toString())) {
            b(hVar, lVar, jVar, bVar, a3, a2, a4);
        } else if (d.a.s0.a.f.f.d(a5, f68268e, "ABJson.log")) {
            b(hVar, lVar, jVar, bVar, a3, a2, a4);
        }
    }
}
