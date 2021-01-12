package com.qq.e.comm.plugin.w;

import android.content.Context;
import android.net.Uri;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.util.aw;
import com.qq.e.comm.plugin.util.bj;
import com.qq.e.comm.plugin.util.v;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static aw f12679a = new aw(2048, 5, "loadad_limit_num");

    /* renamed from: com.qq.e.comm.plugin.w.e$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 extends com.qq.e.comm.plugin.t.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f12680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.ad.b f12681b;
        final /* synthetic */ AtomicLong c;
        final /* synthetic */ b d;
        final /* synthetic */ Map e;
        final /* synthetic */ a f;
        final /* synthetic */ m g;

        AnonymousClass1(long j, com.qq.e.comm.plugin.ad.b bVar, AtomicLong atomicLong, b bVar2, Map map, a aVar, m mVar) {
            this.f12680a = j;
            this.f12681b = bVar;
            this.c = atomicLong;
            this.d = bVar2;
            this.e = map;
            this.f = aVar;
            this.g = mVar;
        }

        @Override // com.qq.e.comm.plugin.t.i
        public void a(int i, Exception exc) {
            e.a(-1, -1, (int) (System.currentTimeMillis() - this.f12680a), "Exception:" + exc.getMessage(), this.d.f12668a, e.a(), this.g);
            this.f.a(new com.qq.e.comm.plugin.k.a(exc, i));
        }

        @Override // com.qq.e.comm.plugin.t.b
        public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
            String str;
            JSONException jSONException;
            long currentTimeMillis = System.currentTimeMillis() - this.f12680a;
            int e = fVar.e();
            if (e != 200) {
                e.a(e, -1, (int) currentTimeMillis, "HttpStatus error", this.d.f12668a, eVar.f(), this.g);
                this.f.a(new com.qq.e.comm.plugin.k.a("HttpStatus error", e));
                return;
            }
            try {
                try {
                    str = fVar.d();
                } catch (Throwable th) {
                    e.a(e, -1, (int) currentTimeMillis, "Exception:" + th.getMessage(), this.d.f12668a, eVar.f(), this.g);
                    this.f.a(new com.qq.e.comm.plugin.k.a(th, 3000));
                    return;
                }
            } catch (JSONException e2) {
                str = null;
                jSONException = e2;
            }
            try {
                e.a(this.f12681b.i(), this.c.get(), this.d.f12669b);
                String f = eVar.f();
                JSONObject jSONObject = new JSONObject(str);
                if (com.qq.e.comm.plugin.x.a.a().c() && jSONObject.has("seq")) {
                    com.qq.e.comm.plugin.x.a.a().a(jSONObject.optInt("seq"));
                }
                if (e.a(this.f12681b.j())) {
                    Uri.Builder buildUpon = Uri.parse(f).buildUpon();
                    for (Map.Entry entry : this.e.entrySet()) {
                        buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
                    }
                    f = buildUpon.build().toString();
                }
                this.f.a(e.a(jSONObject, this.d.f12669b, f));
                e.a(e, jSONObject.optInt(Constants.KEYS.RET, -1), (int) currentTimeMillis, "", this.d.f12668a, eVar.f(), this.g);
                com.qq.e.comm.plugin.util.b.a(jSONObject, GDTADManager.getInstance().getAppContext());
            } catch (JSONException e3) {
                jSONException = e3;
                e.a(e, -1, (int) currentTimeMillis, "Exception:" + jSONException.getMessage(), this.d.f12668a, eVar.f(), this.g);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("ej", bj.a(str));
                } catch (JSONException e4) {
                }
                this.f.a(new com.qq.e.comm.plugin.k.a(jSONObject2.toString(), jSONException, ARPMessageType.MSG_TYPE_RES_REQUEST));
            }
        }
    }

    /* renamed from: com.qq.e.comm.plugin.w.e$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f12682a;

        AnonymousClass2(Context context) {
            this.f12682a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.a(this.f12682a).b(this.f12682a);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.qq.e.comm.plugin.k.a aVar);

        void a(JSONObject jSONObject);
    }

    private static com.qq.e.comm.plugin.k.a a(String str) {
        return (com.qq.e.comm.plugin.k.a) gdtadv.getobjresult(74, 1, str);
    }

    public static String a() {
        return (String) gdtadv.getobjresult(75, 1, new Object[0]);
    }

    static /* synthetic */ JSONObject a(JSONObject jSONObject, String str, String str2) {
        return (JSONObject) gdtadv.getobjresult(76, 1, jSONObject, str, str2);
    }

    static /* synthetic */ void a(int i, int i2, int i3, String str, String str2, String str3, m mVar) {
        gdtadv.getVresult(77, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, mVar);
    }

    static /* synthetic */ void a(int i, long j, String str) {
        gdtadv.getVresult(78, 1, Integer.valueOf(i), Long.valueOf(j), str);
    }

    public static void a(com.qq.e.comm.plugin.ad.b bVar, b bVar2, a aVar) {
        gdtadv.getVresult(79, 1, bVar, bVar2, aVar);
    }

    private static void a(com.qq.e.comm.plugin.ad.b bVar, b bVar2, a aVar, String str) {
        gdtadv.getVresult(80, 1, bVar, bVar2, aVar, str);
    }

    private static void a(JSONObject jSONObject, String str) {
        gdtadv.getVresult(81, 1, jSONObject, str);
    }

    static /* synthetic */ boolean a(l lVar) {
        return gdtadv.getZresult(82, 1, lVar);
    }

    private static JSONObject b(JSONObject jSONObject, String str, String str2) {
        return (JSONObject) gdtadv.getobjresult(83, 1, jSONObject, str, str2);
    }

    private static void b() {
        gdtadv.getVresult(84, 1, new Object[0]);
    }

    private static void b(int i, int i2, int i3, String str, String str2, String str3, m mVar) {
        gdtadv.getVresult(85, 1, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, mVar);
    }

    private static void b(int i, long j, String str) {
        gdtadv.getVresult(86, 1, Integer.valueOf(i), Long.valueOf(j), str);
    }

    private static boolean b(l lVar) {
        return gdtadv.getZresult(87, 1, lVar);
    }
}
