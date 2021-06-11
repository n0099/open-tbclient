package d.a.l0.a.h0.r;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.a1.e;
import d.a.l0.a.a1.h.a;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import d.a.l0.a.v2.j0;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.w;
import d.a.l0.t.g;
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
    public static final boolean f46219a = k.f46875a;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f46220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f46221f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f46222g;

        public a(HybridUbcFlow hybridUbcFlow, c cVar, d dVar) {
            this.f46220e = hybridUbcFlow;
            this.f46221f = cVar;
            this.f46222g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HybridUbcFlow hybridUbcFlow = this.f46220e;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp#run-start");
            ubcFlowEvent.a(true);
            hybridUbcFlow.C(ubcFlowEvent);
            String f2 = b.this.f(this.f46221f.f51686g);
            if (TextUtils.isEmpty(f2)) {
                this.f46222g.onFailed(0);
                return;
            }
            JSONObject d2 = w.d(f2);
            HybridUbcFlow hybridUbcFlow2 = this.f46220e;
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp#run-appInfoJson");
            ubcFlowEvent2.a(true);
            hybridUbcFlow2.C(ubcFlowEvent2);
            PMSAppInfo l = b.this.l(this.f46221f, d2);
            if (l == null) {
                this.f46222g.onFailed(1);
                return;
            }
            HybridUbcFlow hybridUbcFlow3 = this.f46220e;
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("loadPresetApp#run-PMSAppInfo");
            ubcFlowEvent3.a(true);
            hybridUbcFlow3.C(ubcFlowEvent3);
            this.f46222g.a(l);
            long currentTimeMillis = System.currentTimeMillis();
            boolean e2 = b.this.e(this.f46221f);
            if (b.f46219a) {
                Log.d("PresetController", "签名+解压 耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            }
            HybridUbcFlow hybridUbcFlow4 = this.f46220e;
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("loadPresetApp#run-doUnzipBundle");
            ubcFlowEvent4.a(true);
            hybridUbcFlow4.C(ubcFlowEvent4);
            if (e2) {
                b bVar = b.this;
                c cVar = this.f46221f;
                l.n(bVar.g(cVar.f51687h, cVar.f51686g, cVar.f51688i));
                l.o(3);
                d.a.l0.n.g.a.h().a(this.f46221f, l);
                HybridUbcFlow hybridUbcFlow5 = this.f46220e;
                UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("loadPresetApp#run-bulkInsert");
                ubcFlowEvent5.a(true);
                hybridUbcFlow5.C(ubcFlowEvent5);
                this.f46222g.b(l);
            } else {
                this.f46222g.onFailed(2);
            }
            HybridUbcFlow hybridUbcFlow6 = this.f46220e;
            UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("loadPresetApp#run-return");
            ubcFlowEvent6.a(true);
            hybridUbcFlow6.C(ubcFlowEvent6);
        }
    }

    public boolean d(ReadableByteChannel readableByteChannel, String str) {
        if (readableByteChannel == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            boolean c2 = j0.c(readableByteChannel, str);
            if (f46219a) {
                Log.d("PresetController", "签名校验结果：" + c2 + " ,耗时：" + (System.currentTimeMillis() - currentTimeMillis));
            }
            return c2;
        } catch (IOException e2) {
            if (f46219a) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            d.a.l0.t.d.d(readableByteChannel);
        }
    }

    public abstract boolean e(c cVar);

    public abstract String f(String str);

    public final int g(int i2, String str, long j) {
        if (i2 == 1) {
            return d.a.l0.a.c1.b.i().v(str, j);
        }
        return 0;
    }

    public HashMap<String, c> h() {
        JSONArray optJSONArray;
        String i2 = i();
        if (TextUtils.isEmpty(i2) || (optJSONArray = w.d(i2).optJSONArray("list")) == null) {
            return null;
        }
        HashMap<String, c> hashMap = new HashMap<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            c m = m(optJSONArray.optJSONObject(i3));
            if (m != null) {
                hashMap.put(m.f51686g, m);
            }
        }
        return hashMap;
    }

    public abstract String i();

    public File j(int i2, String str, long j) {
        if (i2 == 0) {
            return e.C0617e.i(str, String.valueOf(j));
        }
        if (i2 == 1) {
            return d.a.l0.a.c1.b.g().a(str, String.valueOf(j));
        }
        return null;
    }

    public void k(c cVar, d dVar) {
        HybridUbcFlow p = h.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("loadPresetApp-start");
        ubcFlowEvent.a(true);
        p.C(ubcFlowEvent);
        if (dVar == null) {
            return;
        }
        if (cVar == null) {
            dVar.onFailed(0);
            return;
        }
        q.j(new a(p, cVar, dVar), "加载小程序预置包");
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("loadPresetApp-return");
        ubcFlowEvent2.a(true);
        p.C(ubcFlowEvent2);
    }

    public final PMSAppInfo l(c cVar, JSONObject jSONObject) {
        PMSAppInfo a2;
        if (jSONObject == null || cVar == null || (a2 = d.a.l0.n.o.e.a(jSONObject)) == null) {
            return null;
        }
        a2.c(cVar);
        a2.createTime = System.currentTimeMillis();
        return a2;
    }

    public final c m(JSONObject jSONObject) {
        c cVar;
        if (jSONObject == null || (cVar = (c) d.a.l0.n.o.e.i(jSONObject, new c())) == null) {
            return null;
        }
        cVar.o = jSONObject.optInt("pkg_type");
        cVar.q = jSONObject.optString("bundle_name");
        if (cVar.a()) {
            return cVar;
        }
        return null;
    }

    public boolean n(BufferedInputStream bufferedInputStream, File file) {
        if (bufferedInputStream != null) {
            try {
                if (file != null) {
                    a.b h2 = d.a.l0.a.a1.h.a.h(bufferedInputStream);
                    if ((h2 == null || h2.f44391b == -1) ? false : true) {
                        return d.a.l0.a.a1.h.a.c(bufferedInputStream, file, h2.f44391b).f44388a;
                    }
                    return g.d(bufferedInputStream, file.getPath());
                }
            } catch (IOException e2) {
                if (f46219a) {
                    e2.printStackTrace();
                }
                return false;
            } finally {
                d.a.l0.t.d.d(bufferedInputStream);
            }
        }
        return false;
    }
}
