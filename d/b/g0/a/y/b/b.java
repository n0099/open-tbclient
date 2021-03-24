package d.b.g0.a.y.b;

import androidx.core.app.NotificationCompat;
import d.b.g0.a.y.a.j.a0;
import d.b.g0.a.y.a.j.b0;
import d.b.g0.a.y.a.j.c0;
import d.b.g0.a.y.a.j.d0;
import d.b.g0.a.y.a.j.e0;
import d.b.g0.a.y.a.j.f0;
import d.b.g0.a.y.a.j.g;
import d.b.g0.a.y.a.j.g0;
import d.b.g0.a.y.a.j.h;
import d.b.g0.a.y.a.j.h0;
import d.b.g0.a.y.a.j.i0;
import d.b.g0.a.y.a.j.j0;
import d.b.g0.a.y.a.j.k;
import d.b.g0.a.y.a.j.l;
import d.b.g0.a.y.a.j.l0;
import d.b.g0.a.y.a.j.m;
import d.b.g0.a.y.a.j.m0;
import d.b.g0.a.y.a.j.n;
import d.b.g0.a.y.a.j.n0;
import d.b.g0.a.y.a.j.o;
import d.b.g0.a.y.a.j.o0;
import d.b.g0.a.y.a.j.p;
import d.b.g0.a.y.a.j.p0;
import d.b.g0.a.y.a.j.q;
import d.b.g0.a.y.a.j.q0;
import d.b.g0.a.y.a.j.r;
import d.b.g0.a.y.a.j.s;
import d.b.g0.a.y.a.j.t;
import d.b.g0.a.y.a.j.u;
import d.b.g0.a.y.a.j.v;
import d.b.g0.a.y.a.j.w;
import d.b.g0.a.y.a.j.x;
import d.b.g0.a.y.a.j.y;
import d.b.g0.a.y.a.j.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends a {
    public static Map<String, Class<? extends d.b.g0.a.y.a.j.a>> q;
    public List<d.b.g0.a.y.a.j.a> o;
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
        q.put("beginPath", d.b.g0.a.y.a.j.d.class);
        q.put("rect", s.class);
        q.put("clearRect", d.b.g0.a.y.a.j.f.class);
        q.put("closePath", h.class);
        q.put("arc", d.b.g0.a.y.a.j.c.class);
        q.put("bezierCurveTo", d.b.g0.a.y.a.j.e.class);
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
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends d.b.g0.a.y.a.j.a> cls = q.get(optString);
                if (cls != null) {
                    d.b.g0.a.y.a.j.a newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.o.add(newInstance);
                }
            }
            this.p = jSONObject.optInt("reserve") != 0;
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }

    public List<d.b.g0.a.y.a.j.a> h() {
        return this.o;
    }

    public boolean i() {
        return this.p;
    }

    @Override // d.b.g0.a.y.b.a, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public boolean isValid() {
        return super.isValid();
    }
}
