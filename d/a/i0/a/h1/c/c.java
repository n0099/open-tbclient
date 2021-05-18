package d.a.i0.a.h1.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.a.c0.b.b {
    public boolean A;
    public boolean B;
    public String C;
    public d.a.i0.a.h1.c.h.c n;
    public double o;
    public List<d.a.i0.a.h1.c.h.d> p;
    public List<d.a.i0.a.h1.c.h.f> q;
    public List<d.a.i0.a.h1.c.h.a> r;
    public List<d.a.i0.a.h1.c.h.b> s;
    public List<d.a.i0.a.h1.c.h.c> t;
    public List<d.a.i0.a.h1.c.h.e> u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public c() {
        super("map", "mapId");
        this.o = 16.0d;
        this.v = true;
        this.C = "";
    }

    @Override // d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        String str = "markers";
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (jSONObject.has("longitude") && jSONObject.has("latitude")) {
            d.a.i0.a.h1.c.h.c cVar = new d.a.i0.a.h1.c.h.c();
            this.n = cVar;
            cVar.a(jSONObject);
        }
        if (jSONObject.has("scale")) {
            this.o = jSONObject.optDouble("scale", 16.0d);
        }
        jSONObject.optString("subkey", "");
        jSONObject.optString("layerStyle", "");
        this.C = jSONObject.optString("cb");
        this.v = jSONObject.optBoolean("showLocation", true);
        this.w = jSONObject.optBoolean("enableZoom", true);
        this.x = jSONObject.optBoolean("enableScroll", true);
        this.y = jSONObject.optBoolean("enableRotate", false);
        this.z = jSONObject.optBoolean("showCompass", false);
        this.A = jSONObject.optBoolean("enableOverlooking", false);
        this.B = jSONObject.optBoolean("enable3D", false);
        try {
            if (!jSONObject.has("markers")) {
                str = "covers";
            }
            this.p = h(jSONObject, str, d.a.i0.a.h1.c.h.d.class);
            this.r = h(jSONObject, "circles", d.a.i0.a.h1.c.h.a.class);
            this.q = h(jSONObject, "polyline", d.a.i0.a.h1.c.h.f.class);
            this.s = h(jSONObject, "controls", d.a.i0.a.h1.c.h.b.class);
            this.t = h(jSONObject, "includePoints", d.a.i0.a.h1.c.h.c.class);
            this.u = h(jSONObject, "polygons", d.a.i0.a.h1.c.h.e.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final <T extends d.a.i0.a.l1.a> List<T> h(JSONObject jSONObject, String str, Class<T> cls) throws IllegalAccessException, InstantiationException, JSONException {
        if (jSONObject.has(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            int length = optJSONArray == null ? 0 : optJSONArray.length();
            if (length > 0) {
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        T newInstance = cls.newInstance();
                        newInstance.a(optJSONObject);
                        if (newInstance.isValid()) {
                            arrayList.add(newInstance);
                        }
                    }
                }
                return arrayList;
            }
        }
        return null;
    }
}
