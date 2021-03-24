package d.b.g0.a.a0.a.c;

import android.graphics.Color;
import androidx.annotation.NonNull;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.a0.a.d.b {
    public double A;
    public int B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String x;
    public int y;
    public boolean z;

    public b(String str, @NonNull String str2) {
        super(str, str2);
        this.x = "";
        this.z = false;
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
    }

    private void i() {
        JSONObject jSONObject = this.n;
        if (jSONObject != null) {
            try {
                this.y = Color.parseColor(jSONObject.optString("color"));
                this.z = true;
            } catch (Exception unused) {
                c.l("Component-Model-TextView", "text color occurs exception");
                this.z = false;
            }
            this.A = this.n.optDouble("fontSize", 0.0d);
            this.B = h0.f((float) this.n.optDouble("lineSpace", 0.0d));
            this.C = this.n.optString("textAlign");
            this.D = this.n.optString("fontWeight");
            this.E = this.n.optString("whiteSpace");
            this.F = this.n.optString("lineBreak");
        }
    }

    @Override // d.b.g0.a.a0.a.d.b, d.b.g0.a.a0.b.b, d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("text");
        i();
    }

    @Override // d.b.g0.a.a0.a.d.b, d.b.g0.a.a0.b.b
    public void g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.x = jSONObject.optString("text", this.x);
        i();
    }

    public void j(String str) {
        this.x = str;
    }
}
