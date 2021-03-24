package d.b.g0.h.a.g;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import d.b.g0.a.a1.c.h.d;
import d.b.g0.a.k;
import d.b.g0.h.a.i.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48745a = k.f45050a;

    /* renamed from: d.b.g0.h.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1005a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f48746a = new JSONObject();

        public static C1005a a() {
            return new C1005a();
        }

        public JSONObject b() {
            return this.f48746a;
        }

        public C1005a c(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f48746a.put(str, obj);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return this;
        }
    }

    public static void a(c cVar, d dVar) {
        C1005a a2 = C1005a.a();
        a2.c("mapId", cVar.j);
        a2.c("id", dVar.f43192e);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", b2.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "callouttap", jSONObject);
    }

    public static void b(View view, c cVar) {
        d.b.g0.a.a1.c.h.b bVar;
        d.b.g0.h.a.i.a I = cVar.I(view);
        String str = (I == null || (bVar = I.f48754a) == null) ? "" : bVar.f43186e;
        C1005a a2 = C1005a.a();
        a2.c("mapId", cVar.j);
        a2.c("controlId", str);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", b2.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "controltap", jSONObject);
    }

    public static void c(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C1005a a2 = C1005a.a();
        a2.c("latitude", Double.valueOf(position.latitude));
        a2.c("longitude", Double.valueOf(position.longitude));
        a2.b();
        C1005a a3 = C1005a.a();
        a3.c("mapId", cVar.j);
        a3.c("name", mapPoi.getName());
        a3.c("latitude", Double.valueOf(position.latitude));
        a3.c("longitude", Double.valueOf(position.longitude));
        JSONObject b2 = a3.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", b2.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "poitap", jSONObject);
    }

    public static void d(c cVar, LatLng latLng) {
        C1005a a2 = C1005a.a();
        a2.c("latitude", Double.valueOf(latLng.latitude));
        a2.c("longitude", Double.valueOf(latLng.longitude));
        JSONObject b2 = a2.b();
        C1005a a3 = C1005a.a();
        a3.c("mapId", cVar.j);
        a3.c("position", b2);
        JSONObject b3 = a3.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", b3.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "tap", jSONObject);
    }

    public static void e(c cVar) {
        C1005a a2 = C1005a.a();
        a2.c("mapId", cVar.j);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", b2.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "updated", jSONObject);
    }

    public static void f(Marker marker, c cVar) {
        d dVar;
        d.b.g0.h.a.i.b J = cVar.J(marker);
        String str = (J == null || (dVar = J.f48757a) == null) ? "" : dVar.f43192e;
        C1005a a2 = C1005a.a();
        a2.c("mapId", cVar.j);
        a2.c("id", str);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", b2.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "markertap", jSONObject);
    }

    public static void g(c cVar, MapStatus mapStatus) {
        C1005a a2 = C1005a.a();
        a2.c("latitude", Double.valueOf(mapStatus.bound.northeast.latitude));
        a2.c("longitude", Double.valueOf(mapStatus.bound.northeast.longitude));
        JSONObject b2 = a2.b();
        C1005a a3 = C1005a.a();
        a3.c("latitude", Double.valueOf(mapStatus.bound.southwest.latitude));
        a3.c("longitude", Double.valueOf(mapStatus.bound.southwest.longitude));
        JSONObject b3 = a3.b();
        C1005a a4 = C1005a.a();
        a4.c("mapId", cVar.j);
        a4.c("northeast", b2);
        a4.c("southwest", b3);
        a4.c("scale", Float.valueOf(mapStatus.zoom));
        JSONObject b4 = a4.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", b4.toString());
            jSONObject.put("wvID", cVar.i);
        } catch (JSONException e2) {
            if (f48745a) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.j2.f.c.a.d(cVar.i, cVar.j, "map", "regionchange", jSONObject);
    }
}
