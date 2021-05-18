package d.a.i0.j.l;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.h1.c.h.d;
import d.a.i0.a.k;
import d.a.i0.j.n.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47692a = k.f43025a;

    /* renamed from: d.a.i0.j.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1056a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f47693a = new JSONObject();

        public static C1056a a() {
            return new C1056a();
        }

        public JSONObject b() {
            return this.f47693a;
        }

        public C1056a c(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f47693a.put(str, obj);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return this;
        }
    }

    public static void a(c cVar, d dVar) {
        C1056a a2 = C1056a.a();
        a2.c("mapId", cVar.j);
        a2.c("markerId", dVar.f42501e);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "callouttap");
            jSONObject.put("data", b2.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "callouttap", jSONObject);
    }

    public static void b(View view, c cVar) {
        d.a.i0.a.h1.c.h.b bVar;
        d.a.i0.j.n.a I = cVar.I(view);
        String str = (I == null || (bVar = I.f47702a) == null) ? "" : bVar.f42495e;
        C1056a a2 = C1056a.a();
        a2.c("mapId", cVar.j);
        a2.c("controlId", str);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "controltap");
            jSONObject.put("data", b2.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "controltap", jSONObject);
    }

    public static void c(c cVar, MapPoi mapPoi) {
        LatLng position = mapPoi.getPosition();
        C1056a a2 = C1056a.a();
        a2.c("latitude", Double.valueOf(position.latitude));
        a2.c("longitude", Double.valueOf(position.longitude));
        a2.b();
        C1056a a3 = C1056a.a();
        a3.c("mapId", cVar.j);
        a3.c("name", mapPoi.getName());
        a3.c("latitude", Double.valueOf(position.latitude));
        a3.c("longitude", Double.valueOf(position.longitude));
        JSONObject b2 = a3.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "poitap");
            jSONObject.put("data", b2.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "poitap", jSONObject);
    }

    public static void d(c cVar, LatLng latLng) {
        C1056a a2 = C1056a.a();
        a2.c("latitude", Double.valueOf(latLng.latitude));
        a2.c("longitude", Double.valueOf(latLng.longitude));
        JSONObject b2 = a2.b();
        C1056a a3 = C1056a.a();
        a3.c("mapId", cVar.j);
        a3.c("position", b2);
        JSONObject b3 = a3.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "tap");
            jSONObject.put("data", b3.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "tap", jSONObject);
    }

    public static void e(c cVar) {
        C1056a a2 = C1056a.a();
        a2.c("mapId", cVar.j);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "updated");
            jSONObject.put("data", b2.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "updated", jSONObject);
    }

    public static void f(Marker marker, c cVar) {
        d dVar;
        d.a.i0.j.n.b J = cVar.J(marker);
        String str = (J == null || (dVar = J.f47705a) == null) ? "" : dVar.f42501e;
        C1056a a2 = C1056a.a();
        a2.c("mapId", cVar.j);
        a2.c("markerId", str);
        JSONObject b2 = a2.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "markertap");
            jSONObject.put("data", b2.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "markertap", jSONObject);
    }

    public static void g(c cVar, MapStatus mapStatus, int i2) {
        C1056a a2 = C1056a.a();
        a2.c("latitude", Double.valueOf(mapStatus.bound.northeast.latitude));
        a2.c("longitude", Double.valueOf(mapStatus.bound.northeast.longitude));
        JSONObject b2 = a2.b();
        C1056a a3 = C1056a.a();
        a3.c("latitude", Double.valueOf(mapStatus.bound.southwest.latitude));
        a3.c("longitude", Double.valueOf(mapStatus.bound.southwest.longitude));
        JSONObject b3 = a3.b();
        C1056a a4 = C1056a.a();
        a4.c("mapId", cVar.j);
        a4.c("northeast", b2);
        a4.c("southwest", b3);
        a4.c("scale", Float.valueOf(mapStatus.zoom));
        a4.c("reason", Integer.valueOf(i2));
        JSONObject b4 = a4.b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vtype", "regionchange");
            jSONObject.put("data", b4.toString());
            jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, cVar.f47716i);
        } catch (JSONException e2) {
            if (f47692a) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.w2.g.c.a.d(cVar.f47716i, cVar.j, "map", "regionchange", jSONObject);
    }
}
