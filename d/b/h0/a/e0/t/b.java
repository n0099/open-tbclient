package d.b.h0.a.e0.t;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.i2.e0;
import d.b.h0.a.i2.p;
import d.b.h0.a.i2.v;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.a.u0.d;
import d.b.h0.a.u0.g.a;
import d.b.h0.g.q.a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44996a = k.f45772a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f44997e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f44998f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f44999g;

        public a(HybridUbcFlow hybridUbcFlow, c cVar, d dVar) {
            this.f44997e = hybridUbcFlow;
            this.f44998f = cVar;
            this.f44999g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow hybridUbcFlow = this.f44997e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
            ubcFlowEvent.a(true);
            hybridUbcFlow.A(ubcFlowEvent);
            String f2 = b.this.f(this.f44998f.f49644g);
            if (TextUtils.isEmpty(f2)) {
                this.f44999g.onFailed(0);
                return;
            }
            JSONObject b2 = v.b(f2);
            HybridUbcFlow hybridUbcFlow2 = this.f44997e;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.A(ubcFlowEvent2);
            PMSAppInfo l = b.this.l(this.f44998f, b2);
            if (l == null) {
                this.f44999g.onFailed(1);
                return;
            }
            HybridUbcFlow hybridUbcFlow3 = this.f44997e;
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
            ubcFlowEvent3.a(true);
            hybridUbcFlow3.A(ubcFlowEvent3);
            this.f44999g.a(l);
            long currentTimeMillis = System.currentTimeMillis();
            boolean e2 = b.this.e(this.f44998f);
            if (b.f44996a) {
                Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            }
            HybridUbcFlow hybridUbcFlow4 = this.f44997e;
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
            ubcFlowEvent4.a(true);
            hybridUbcFlow4.A(ubcFlowEvent4);
            if (e2) {
                b bVar = b.this;
                c cVar = this.f44998f;
                l.m(bVar.g(cVar.f49645h, cVar.f49644g, cVar.i));
                l.n(3);
                d.b.h0.l.i.a.h().a(this.f44998f, l);
                HybridUbcFlow hybridUbcFlow5 = this.f44997e;
                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                ubcFlowEvent5.a(true);
                hybridUbcFlow5.A(ubcFlowEvent5);
                this.f44999g.b(l);
            } else {
                this.f44999g.onFailed(2);
            }
            HybridUbcFlow hybridUbcFlow6 = this.f44997e;
            UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
            ubcFlowEvent6.a(true);
            hybridUbcFlow6.A(ubcFlowEvent6);
        }
    }

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        if (readableByteChannel == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean c2 = e0.c(readableByteChannel, str);
            if (f44996a) {
                Log.d("PresetController", "签名校验结果：" + c2 + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return c2;
        } catch (IOException e2) {
            if (f44996a) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            d.b.h0.p.d.a(readableByteChannel);
        }
    }

    public abstract boolean e(c cVar);

    public abstract String f(String str);

    public final int g(int i, String str, long j) {
        d.b.h0.g.z.a.a i2;
        if (i != 1 || (i2 = d.b.h0.a.e0.p.r.a.i(str, j)) == null) {
            return 0;
        }
        return i2.f49415a;
    }

    public HashMap<String, c> h() {
        JSONArray optJSONArray;
        String i = i();
        if (TextUtils.isEmpty(i) || (optJSONArray = v.b(i).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            c m = m(optJSONArray.optJSONObject(i2));
            if (m != null) {
                hashMap.put(m.f49644g, m);
            }
        }
        return hashMap;
    }

    public abstract String i();

    public File j(int i, String str, long j) {
        if (i == 0) {
            return d.e.h(str, String.valueOf(j));
        }
        if (i == 1) {
            return a.d.h(str, String.valueOf(j));
        }
        return null;
    }

    public void k(c cVar, d dVar) {
        HybridUbcFlow o = i.o("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
        ubcFlowEvent.a(true);
        o.A(ubcFlowEvent);
        if (dVar == null) {
            return;
        }
        if (cVar == null) {
            dVar.onFailed(0);
            return;
        }
        p.k(new a(o, cVar, dVar), "加载小程序预置包");
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
        ubcFlowEvent2.a(true);
        o.A(ubcFlowEvent2);
    }

    public final PMSAppInfo l(c cVar, JSONObject jSONObject) {
        PMSAppInfo a2;
        if (jSONObject == null || cVar == null || (a2 = d.b.h0.l.r.e.a(jSONObject)) == null) {
            return null;
        }
        a2.c(cVar);
        a2.createTime = System.currentTimeMillis();
        return a2;
    }

    public final c m(JSONObject jSONObject) {
        c cVar;
        if (jSONObject == null || (cVar = (c) d.b.h0.l.r.e.i(jSONObject, new c())) == null) {
            return null;
        }
        cVar.o = jSONObject.optInt("pkg_type");
        cVar.p = jSONObject.optString("bundle_name");
        if (cVar.a()) {
            return cVar;
        }
        return null;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b e2 = d.b.h0.a.u0.g.a.e(bufferedInputStream);
                    if ((e2 == null || e2.f47340b == -1) ? false : true) {
                        return d.b.h0.a.u0.g.a.a(bufferedInputStream, file, e2.f47340b).f47337a;
                    }
                    return d.b.h0.p.f.d(bufferedInputStream, file.getPath());
                }
            } catch (IOException e3) {
                if (f44996a) {
                    e3.printStackTrace();
                }
                return false;
            } finally {
                d.b.h0.p.d.a(bufferedInputStream);
            }
        }
        return false;
    }
}
