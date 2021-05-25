package d.a.l0.n.j.k;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSPkgStatus;
import com.baidu.webkit.internal.ETAG;
import d.a.l0.n.f.g;
import d.a.l0.n.h.h;
import d.a.l0.n.o.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48178a = d.a.l0.n.c.f47984a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f48179b;

    public static b a() {
        if (f48179b == null) {
            synchronized (b.class) {
                if (f48179b == null) {
                    f48179b = new b();
                }
            }
        }
        return f48179b;
    }

    public static void b(d.a.l0.n.h.e eVar, f fVar) {
        if (eVar == null) {
            return;
        }
        fVar.a(eVar, PMSPkgStatus.WAIT);
    }

    public void c(JSONArray jSONArray, g gVar, g gVar2, g gVar3) {
        char c2;
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: soCallback=" + gVar3);
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        f fVar = new f();
        f fVar2 = new f();
        f fVar3 = new f();
        c v = gVar3 != null ? gVar3.v("so") : null;
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: soNodeHandler=" + v);
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("type");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    if (!TextUtils.isEmpty(jSONObject2.getString("version_name"))) {
                        switch (string.hashCode()) {
                            case -612557761:
                                if (string.equals(ETAG.KEY_EXTENSION)) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 3676:
                                if (string.equals("so")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 99308:
                                if (string.equals("ddl")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 54573042:
                                if (string.equals("extension_game")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 714512640:
                                if (string.equals("bbasp_core")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 714618195:
                                if (string.equals("bbasp_game")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 == 0) {
                            d.a.l0.n.h.d dVar = (d.a.l0.n.h.d) d.a.l0.n.o.e.i(jSONObject2, new d.a.l0.n.h.d());
                            if (dVar != null) {
                                b(dVar, fVar);
                                aVar.f48174b = dVar;
                            }
                        } else if (c2 == 1) {
                            d.a.l0.n.h.d dVar2 = (d.a.l0.n.h.d) d.a.l0.n.o.e.i(jSONObject2, new d.a.l0.n.h.d());
                            if (dVar2 != null) {
                                b(dVar2, fVar2);
                                aVar2.f48173a = dVar2;
                            }
                        } else if (c2 == 2) {
                            d.a.l0.n.h.b bVar = (d.a.l0.n.h.b) d.a.l0.n.o.e.i(jSONObject2, new d.a.l0.n.h.b());
                            if (bVar != null) {
                                b(bVar, fVar);
                                aVar.f48175c = bVar;
                            }
                        } else if (c2 == 3) {
                            d.a.l0.n.h.b bVar2 = (d.a.l0.n.h.b) d.a.l0.n.o.e.i(jSONObject2, new d.a.l0.n.h.b());
                            if (bVar2 != null) {
                                b(bVar2, fVar2);
                                aVar2.f48175c = bVar2;
                            }
                        } else if (c2 == 4) {
                            if (f48178a) {
                                Log.i("SoBundleId", "updateConfig: case so= " + jSONObject2 + " soNodeHandler=" + v);
                            }
                            if (v != null) {
                                v.l(jSONObject2);
                            }
                        } else if (c2 == 5) {
                            if (aVar3.f48177e == null) {
                                aVar3.f48177e = new ArrayList();
                            }
                            h hVar = (h) d.a.l0.n.o.e.i(jSONObject2, new h());
                            b(hVar, fVar3);
                            aVar3.f48177e.add(hVar);
                        }
                    }
                }
            } catch (JSONException e2) {
                if (f48178a) {
                    Log.i("SoBundleId", "updateConfig: end parse by catch=" + e2);
                }
            }
        }
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: end parse soNodeHandler=" + v);
        }
        if (gVar != null) {
            if (fVar.l() == 0) {
                gVar.E();
            } else {
                gVar.F(fVar);
                d.a.l0.n.i.i.a.e(aVar, gVar);
            }
        }
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: handle core end");
        }
        if (gVar2 != null) {
            if (fVar2.l() == 0) {
                gVar2.E();
            } else {
                gVar2.F(fVar2);
                d.a.l0.n.i.i.a.e(aVar2, gVar2);
            }
        }
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: handle game end");
        }
        if (v != null) {
            v.handle();
        }
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: handle so end");
        }
        if (fVar3.l() > 0 && d.a.l0.n.c.b() != null) {
            d.a.l0.n.c.b().s(aVar3, fVar3);
        }
        if (f48178a) {
            Log.i("SoBundleId", "updateConfig: handle ddl end");
        }
    }
}
