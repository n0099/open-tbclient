package d.b.g0.l.m.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.l.f;
import d.b.g0.l.h.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49444a = f.f49281a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f49445b;

    public static b a() {
        if (f49445b == null) {
            synchronized (b.class) {
                if (f49445b == null) {
                    f49445b = new b();
                }
            }
        }
        return f49445b;
    }

    public static void b(d.b.g0.l.k.e eVar, d.b.g0.l.r.f fVar) {
        if (eVar == null) {
            return;
        }
        fVar.a(eVar, PMSPkgStatus.WAIT);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0126 A[Catch: JSONException -> 0x0139, TryCatch #0 {JSONException -> 0x0139, blocks: (B:18:0x0068, B:21:0x007a, B:24:0x008e, B:53:0x00da, B:55:0x00de, B:57:0x00fc, B:58:0x0100, B:60:0x010d, B:61:0x0113, B:63:0x0120, B:64:0x0126, B:66:0x0133, B:33:0x00a7, B:36:0x00b1, B:39:0x00bb, B:42:0x00c3), top: B:98:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(JSONArray jSONArray, g gVar, g gVar2, g gVar3) {
        char c2;
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: soCallback=" + gVar3);
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        a aVar = new a();
        a aVar2 = new a();
        d.b.g0.l.r.f fVar = new d.b.g0.l.r.f();
        d.b.g0.l.r.f fVar2 = new d.b.g0.l.r.f();
        c v = gVar3 != null ? gVar3.v("so") : null;
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: soNodeHandler=" + v);
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
                        int hashCode = string.hashCode();
                        if (hashCode == -612557761) {
                            if (string.equals(ETAG.KEY_EXTENSION)) {
                                c2 = 2;
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        } else if (hashCode == 3676) {
                            if (string.equals("so")) {
                                c2 = 3;
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        } else if (hashCode != 714512640) {
                            if (hashCode == 714618195 && string.equals("bbasp_game")) {
                                c2 = 1;
                                if (c2 != 0) {
                                    d.b.g0.l.k.d dVar = (d.b.g0.l.k.d) d.b.g0.l.r.e.i(jSONObject2, new d.b.g0.l.k.d());
                                    if (dVar != null) {
                                        b(dVar, fVar);
                                        aVar.f49441b = dVar;
                                    }
                                } else if (c2 == 1) {
                                    d.b.g0.l.k.d dVar2 = (d.b.g0.l.k.d) d.b.g0.l.r.e.i(jSONObject2, new d.b.g0.l.k.d());
                                    if (dVar2 != null) {
                                        b(dVar2, fVar2);
                                        aVar2.f49440a = dVar2;
                                    }
                                } else if (c2 == 2) {
                                    d.b.g0.l.k.b bVar = (d.b.g0.l.k.b) d.b.g0.l.r.e.i(jSONObject2, new d.b.g0.l.k.b());
                                    if (bVar != null) {
                                        b(bVar, fVar);
                                        aVar.f49442c = bVar;
                                    }
                                } else if (c2 == 3) {
                                    if (f49444a) {
                                        Log.i("SoBundleId", "updateConfig: case so= " + jSONObject2 + " soNodeHandler=" + v);
                                    }
                                    if (v != null) {
                                        v.e(jSONObject2);
                                    }
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        } else {
                            if (string.equals("bbasp_core")) {
                                c2 = 0;
                                if (c2 != 0) {
                                }
                            }
                            c2 = 65535;
                            if (c2 != 0) {
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (f49444a) {
                    Log.i("SoBundleId", "updateConfig: end parse by catch=" + e2);
                }
            }
        }
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: end parse soNodeHandler=" + v);
        }
        if (gVar != null) {
            if (fVar.k() == 0) {
                gVar.E();
            } else {
                gVar.F(fVar);
                d.b.g0.l.l.h.a.e(aVar, gVar);
            }
        }
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: handle core end");
        }
        if (gVar2 != null) {
            if (fVar2.k() == 0) {
                gVar2.E();
            } else {
                gVar2.F(fVar2);
                d.b.g0.l.l.h.a.e(aVar2, gVar2);
            }
        }
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: handle game end");
        }
        if (v != null) {
            v.handle();
        }
        if (f49444a) {
            Log.i("SoBundleId", "updateConfig: handle so end");
        }
    }
}
