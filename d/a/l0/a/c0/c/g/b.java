package d.a.l0.a.c0.c.g;

import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends d.a.l0.a.c0.a.a.b {
    public String O;
    public int P;
    public String Q;
    public String R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public int Y;
    public boolean Z;
    public boolean a0;

    public b() {
        super("textArea", "inputId");
        this.O = "";
        this.Q = "";
        this.R = "";
    }

    private void i() {
        JSONObject jSONObject = this.n;
        if (jSONObject != null) {
            int g2 = n0.g(c(jSONObject, "minHeight", 0.0f));
            if (g2 < 0) {
                g2 = 0;
            }
            this.X = g2;
            int g3 = n0.g(c(this.n, "maxHeight", 2.1474836E9f));
            if (g3 < 0) {
                g3 = Integer.MAX_VALUE;
            }
            this.Y = g3;
        }
    }

    @Override // d.a.l0.a.c0.a.a.b, d.a.l0.a.c0.a.c.c, d.a.l0.a.c0.a.d.b, d.a.l0.a.c0.b.b, d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        d.a.l0.a.l1.e.a.a aVar;
        if (jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.x = jSONObject.optString("value");
        this.O = jSONObject.optString("placeholder");
        o(jSONObject);
        this.S = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, false);
        boolean optBoolean = jSONObject.optBoolean("autoHeight", false);
        this.T = optBoolean;
        if (optBoolean && (aVar = this.l) != null) {
            aVar.k(-2);
            this.l.l(true);
        }
        boolean optBoolean2 = jSONObject.optBoolean("fixed");
        this.U = optBoolean2;
        d.a.l0.a.l1.e.a.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.j(optBoolean2);
        }
        this.V = jSONObject.optBoolean("showConfirmBar", true);
        this.W = jSONObject.optBoolean("adjustPosition", true);
        this.Z = jSONObject.optBoolean("disabled", false);
        this.a0 = jSONObject.optInt("confirmHold") == 1;
        i();
    }

    @Override // d.a.l0.a.c0.a.a.b, d.a.l0.a.c0.a.c.c, d.a.l0.a.c0.a.d.b, d.a.l0.a.c0.b.b
    public void g(JSONObject jSONObject) {
        super.g(jSONObject);
        this.Z = jSONObject.optBoolean("disabled", this.Z);
        this.O = jSONObject.optString("placeholder", this.O);
        this.x = jSONObject.optString("value", this.x);
        this.S = jSONObject.optBoolean(AddFriendActivityConfig.TYPE_FOCUS, this.S);
        this.V = jSONObject.optBoolean("showConfirmBar", this.V);
        this.W = jSONObject.optBoolean("adjustPosition", this.W);
        n(jSONObject);
        p(jSONObject);
        o(jSONObject);
        i();
    }

    public final void n(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("autoHeight", this.T);
        this.T = optBoolean;
        d.a.l0.a.l1.e.a.a aVar = this.l;
        if (aVar != null) {
            if (optBoolean) {
                aVar.k(-2);
                this.l.l(true);
                return;
            }
            int d2 = aVar.d();
            int i2 = this.N;
            if (i2 > 0) {
                d2 = i2;
            }
            this.l.k(d2);
            this.l.l(false);
        }
    }

    public final void o(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("placeholderStyle");
        if (optJSONObject != null) {
            this.P = optJSONObject.optInt("fontSize");
            this.Q = optJSONObject.optString("fontWeight");
            this.R = optJSONObject.optString("color");
        }
    }

    public final void p(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("fixed", this.U);
        this.U = optBoolean;
        d.a.l0.a.l1.e.a.a aVar = this.l;
        if (aVar != null) {
            aVar.j(optBoolean);
        }
    }

    public void q(boolean z) {
        this.S = z;
    }
}
