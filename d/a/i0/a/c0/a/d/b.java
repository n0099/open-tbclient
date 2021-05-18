package d.a.i0.a.c0.a.d;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import d.a.i0.a.e0.d;
import d.a.i0.a.v2.n0;
import d.a.i0.a.v2.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.c0.b.b {
    @Nullable
    public JSONObject n;
    public int o;
    public int p;
    public int q;
    public int r;
    public JSONArray s;
    public float t;
    @Nullable
    public JSONObject u;
    public long v;
    public String w;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.o = 0;
        this.q = 0;
        this.t = -1.0f;
        this.w = "";
    }

    @Override // d.a.i0.a.c0.b.b, d.a.i0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.n = jSONObject.optJSONObject("style");
        this.u = jSONObject.optJSONObject(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
        i();
        h();
    }

    @Override // d.a.i0.a.c0.b.b
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        if (this.n != null) {
            try {
                bVar.n = new JSONObject(this.n.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.s != null) {
            try {
                bVar.s = new JSONArray(this.s.toString());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (this.u != null) {
            try {
                bVar.u = new JSONObject(this.u.toString());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return bVar;
    }

    @Override // d.a.i0.a.c0.b.b
    public void g(JSONObject jSONObject) {
        super.g(jSONObject);
        i();
        h();
    }

    public final void h() {
        JSONObject jSONObject = this.u;
        if (jSONObject != null) {
            try {
                this.v = Long.parseLong(jSONObject.optString("duration"));
            } catch (Exception unused) {
                d.a("Component-Model-View", "duration occurs exception");
                this.v = 0L;
            }
            this.w = this.u.optString("easing");
        }
    }

    public final void i() {
        JSONObject jSONObject = this.n;
        if (jSONObject != null) {
            try {
                this.o = Color.parseColor(jSONObject.optString("bgColor"));
            } catch (Exception unused) {
                d.a("Component-Model-View", "backgroundColor occurs exception");
                this.o = 0;
            }
            this.p = this.n.optInt("borderWidth");
            try {
                this.q = Color.parseColor(this.n.optString("borderColor"));
            } catch (Exception unused2) {
                d.a("Component-Model-View", "borderColor occurs exception");
                this.q = 0;
            }
            this.r = n0.g(this.n.optInt("borderRadius"));
            this.t = w.b(this.n, "opacity", -1.0f);
            this.s = this.n.optJSONArray("padding");
        }
    }
}
