package d.a.m0.a.a0.b;

import androidx.core.app.NotificationCompat;
import d.a.m0.a.a0.a.j.a0;
import d.a.m0.a.a0.a.j.b0;
import d.a.m0.a.a0.a.j.c0;
import d.a.m0.a.a0.a.j.d0;
import d.a.m0.a.a0.a.j.e0;
import d.a.m0.a.a0.a.j.f0;
import d.a.m0.a.a0.a.j.g;
import d.a.m0.a.a0.a.j.g0;
import d.a.m0.a.a0.a.j.h;
import d.a.m0.a.a0.a.j.h0;
import d.a.m0.a.a0.a.j.i0;
import d.a.m0.a.a0.a.j.j0;
import d.a.m0.a.a0.a.j.k;
import d.a.m0.a.a0.a.j.l;
import d.a.m0.a.a0.a.j.l0;
import d.a.m0.a.a0.a.j.m;
import d.a.m0.a.a0.a.j.m0;
import d.a.m0.a.a0.a.j.n;
import d.a.m0.a.a0.a.j.n0;
import d.a.m0.a.a0.a.j.o;
import d.a.m0.a.a0.a.j.o0;
import d.a.m0.a.a0.a.j.p;
import d.a.m0.a.a0.a.j.p0;
import d.a.m0.a.a0.a.j.q;
import d.a.m0.a.a0.a.j.q0;
import d.a.m0.a.a0.a.j.r;
import d.a.m0.a.a0.a.j.s;
import d.a.m0.a.a0.a.j.t;
import d.a.m0.a.a0.a.j.u;
import d.a.m0.a.a0.a.j.v;
import d.a.m0.a.a0.a.j.w;
import d.a.m0.a.a0.a.j.x;
import d.a.m0.a.a0.a.j.y;
import d.a.m0.a.a0.a.j.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends a {
    public static Map<String, Class<? extends d.a.m0.a.a0.a.j.a>> q;
    public List<d.a.m0.a.a0.a.j.a> o;
    public boolean p;

    static {
        HashMap hashMap = new HashMap();
        q = hashMap;
        hashMap.put("setFillStyle", x.class);
        q.put("fillRect", m.class);
        q.put("setStrokeStyle", g0.class);
        q.put("strokeStyle", n0.class);
        q.put("setLineCap", a0.class);
        q.put("setLineJoin", c0.class);
        q.put("setLineWidth", d0.class);
        q.put("setLineDash", b0.class);
        q.put("setMiterLimit", e0.class);
        q.put("strokeRect", m0.class);
        q.put("moveTo", q.class);
        q.put("lineTo", p.class);
        q.put("stroke", l0.class);
        q.put("fill", l.class);
        q.put("beginPath", d.a.m0.a.a0.a.j.d.class);
        q.put("rect", s.class);
        q.put("clearRect", d.a.m0.a.a0.a.j.f.class);
        q.put("closePath", h.class);
        q.put("arc", d.a.m0.a.a0.a.j.c.class);
        q.put("bezierCurveTo", d.a.m0.a.a0.a.j.e.class);
        q.put("quadraticCurveTo", r.class);
        q.put("scale", w.class);
        q.put("rotate", u.class);
        q.put("translate", q0.class);
        q.put("transform", p0.class);
        q.put("setTransform", j0.class);
        q.put("font", o.class);
        q.put("setFontSize", y.class);
        q.put("setTextAlign", h0.class);
        q.put("setTextBaseline", i0.class);
        q.put("fillText", n.class);
        q.put("strokeText", o0.class);
        q.put("clip", g.class);
        q.put("drawImage", k.class);
        q.put("save", v.class);
        q.put("restore", t.class);
        q.put("setShadow", f0.class);
        q.put("setGlobalAlpha", z.class);
    }

    public b(String str) {
        super(str);
        this.o = new ArrayList();
        this.p = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends d.a.m0.a.a0.a.j.a> cls = q.get(optString);
                if (cls != null) {
                    d.a.m0.a.a0.a.j.a newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.o.add(newInstance);
                }
            }
            this.p = jSONObject.optInt("reserve") != 0;
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }

    public List<d.a.m0.a.a0.a.j.a> h() {
        return this.o;
    }

    public boolean i() {
        return this.p;
    }

    @Override // d.a.m0.a.a0.b.a, d.a.m0.a.c0.b.b, d.a.m0.a.l1.a
    public boolean isValid() {
        return super.isValid();
    }
}
