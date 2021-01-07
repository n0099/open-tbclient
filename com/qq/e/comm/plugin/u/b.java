package com.qq.e.comm.plugin.u;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.NetworkType;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.ad.d;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.q;
import com.qq.e.comm.plugin.s.f;
import com.qq.e.comm.plugin.s.h;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f12844a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final Object f12845b = new Object();

    private b() {
    }

    public static b a() {
        return f12844a;
    }

    private File a(String str) {
        return ah.b(str);
    }

    public static List<f> a(List<f> list) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTime());
            for (f fVar : list) {
                ArrayList arrayList2 = new ArrayList();
                List<h> j = fVar.j();
                if (j == null || j.size() <= 0) {
                    z = false;
                } else {
                    z = false;
                    for (h hVar : j) {
                        if (format.equals(hVar.a())) {
                            arrayList2.add(hVar);
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
                if (z) {
                    fVar.e(arrayList2);
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    private void a(String str, String str2, boolean z, q qVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (z && (GDTADManager.getInstance().getSM().getInteger("preloadResNetwork", NetworkType.WIFI.getPermValue()) & GDTADManager.getInstance().getDeviceStatus().getNetworkType().getPermValue()) <= 0) {
            GDTLogger.i("当前设备的网络类型不符合预加载广告资源的条件，请尝试WIFI环境。如仍有问题请联系客服");
            return;
        }
        File a2 = a(str, str2);
        GDTLogger.i("准备缓存 url " + str2);
        GDTLogger.i("准备缓存 fileName " + a2.getAbsolutePath());
        if (a2.exists()) {
            GDTLogger.i("闪屏资源已经缓存在");
            return;
        }
        com.qq.e.comm.plugin.aa.a.b a3 = new b.a().b(str2).a(a(str)).a(b(str2)).a();
        com.qq.e.comm.plugin.aa.a.a.a().a(a3, str2, new a(a3, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, e eVar, String str, String str2, m mVar, String str3) {
        a(jSONObject, eVar, str, str2, mVar, str3, (f) null);
    }

    private void a(JSONObject jSONObject, e eVar, String str, String str2, m mVar, String str3, f fVar) {
        c a2 = new c().a(str2);
        int optInt = jSONObject.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            u.a(100062, optInt, a2);
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            u.a(100072, 0, a2);
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
        if (optJSONObject2 == null) {
            u.a(100082, 0, a2);
            return;
        }
        int optInt2 = optJSONObject2.optInt(Constants.KEYS.RET);
        if (optInt2 != 0) {
            u.a(100092, optInt2, a2);
            return;
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            u.a(100102, optInt2, a2);
            return;
        }
        synchronized (this.f12845b) {
            ah.b();
            ah.a(ah.c(str2), optJSONArray.toString());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return;
            }
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
            f fVar2 = new f(str, str2, str3, eVar);
            fVar2.g(optJSONObject3);
            if (!TextUtils.isEmpty(fVar2.al()) && !TextUtils.isEmpty(fVar2.ak()) && !str2.equals(fVar2.al())) {
                a(jSONObject, eVar, str, fVar2.al(), mVar, str3, fVar2);
            }
            switch (fVar2.F()) {
                case 0:
                    a(str2, fVar2.o(), false, q.IMG);
                    break;
                case 1:
                    a(str2, fVar2.o(), false, q.IMG);
                    a(str2, fVar2.G(), true, q.VIDEO);
                    break;
            }
            if (fVar != null && fVar.am() == null && fVar2.B().equals(fVar.al()) && fVar2.f().equals(fVar.ak())) {
                fVar.a(fVar2);
                return;
            }
            i = i2 + 1;
        }
    }

    private String b(String str) {
        return ah.a(str);
    }

    public File a(String str, String str2) {
        return new File(a(str).getAbsolutePath() + File.separator + b(str2));
    }

    public List<f> a(String str, String str2, String str3, e eVar) {
        return a(str, str2, str3, eVar, null);
    }

    public List<f> a(String str, String str2, String str3, e eVar, f fVar) {
        String c;
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            synchronized (this.f12845b) {
                c = ah.c(ah.c(str2));
            }
            if (!TextUtils.isEmpty(c)) {
                try {
                    jSONArray = new JSONArray(c);
                } catch (JSONException e) {
                    jSONArray = null;
                }
                if (jSONArray != null && jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        f fVar2 = new f(str, str2, str3, eVar);
                        fVar2.g(optJSONObject);
                        arrayList.add(fVar2);
                        if (!TextUtils.isEmpty(fVar2.al()) && !TextUtils.isEmpty(fVar2.ak()) && !str2.equals(fVar2.al())) {
                            a(str, fVar2.al(), str3, eVar, fVar2);
                        }
                        if (fVar != null && fVar.am() == null && fVar2.B().equals(fVar.al()) && fVar2.f().equals(fVar.ak())) {
                            fVar.a(fVar2);
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        return arrayList;
    }

    public void a(final e eVar, final String str, final String str2, final m mVar, final String str3, LoadAdParams loadAdParams, int i) {
        int integer = GDTADManager.getInstance().getSM().getInteger("preloadNetwork", -1);
        NetworkType networkType = GDTADManager.getInstance().getDeviceStatus().getNetworkType();
        if ((integer & networkType.getPermValue()) <= 0) {
            u.a(100052, networkType.getPermValue(), new c().a(str2));
            GDTLogger.i("当前设备的网络类型不符合预加载广告的条件，请尝试WIFI环境。如仍有问题请联系客服");
            return;
        }
        com.qq.e.comm.plugin.w.b bVar = new com.qq.e.comm.plugin.w.b(str3, eVar, str2);
        com.qq.e.comm.plugin.ad.b bVar2 = new com.qq.e.comm.plugin.ad.b();
        bVar2.a(true);
        bVar2.a(str2);
        bVar2.c(1);
        bVar2.d(GDTADManager.getInstance().getSM().getInteger("splashPreloadAdCount", 5));
        bVar2.e(2);
        bVar2.h(eVar.b());
        d a2 = com.qq.e.comm.plugin.ad.c.a(eVar, GDTADManager.getInstance().getDeviceStatus().getDeviceDensity());
        bVar2.f(a2.a());
        bVar2.g(a2.b());
        bVar2.n(i);
        bVar2.q(1);
        if (loadAdParams != null) {
            bVar2.f(loadAdParams.getUin());
            bVar2.e(loadAdParams.getLoginOpenid());
            bVar2.g(loadAdParams.getLoginAppId());
            bVar2.m(loadAdParams.getBlockEffectValue());
        }
        com.qq.e.comm.plugin.w.e.a(bVar2, bVar, new e.a() { // from class: com.qq.e.comm.plugin.u.b.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                GDTLogger.e("预加载失败！", aVar);
                u.a(100042, 0, new c().a(str2));
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                b.this.a(jSONObject, eVar, str, str2, mVar, str3);
            }
        });
    }

    public List<f> b(String str, String str2, String str3, com.qq.e.comm.plugin.ad.e eVar) {
        return a(a(str, str2, str3, eVar));
    }
}
