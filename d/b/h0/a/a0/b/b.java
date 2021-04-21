package d.b.h0.a.a0.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.h0.a.i2.h0;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b implements d.b.h0.a.e1.a, Cloneable {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f43833e;

    /* renamed from: f  reason: collision with root package name */
    public String f43834f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f43835g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f43836h = "";
    public String i = "";
    public boolean j = false;
    public boolean k = false;
    @Nullable
    public d.b.h0.a.e1.d.a.a l;
    public String m;

    static {
        boolean z = k.f45772a;
    }

    public b(@NonNull String str, @NonNull String str2) {
        this.f43833e = "unknown";
        this.m = "id";
        if (!TextUtils.isEmpty(str)) {
            this.f43833e = str;
        } else {
            d.b.h0.a.a0.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.m = str2;
        } else {
            d.b.h0.a.a0.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // d.b.h0.a.e1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(this.m);
        this.f43834f = optString;
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component componentId is empty");
        }
        String optString2 = jSONObject.optString("slaveId");
        this.f43835g = optString2;
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component slaveId is empty");
        }
        this.f43836h = jSONObject.optString("parentId");
        this.i = jSONObject.optString("cb");
        this.j = jSONObject.optBoolean("hide", false);
        this.k = TextUtils.equals(jSONObject.optString("gesture"), "1");
        f(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        d.b.h0.a.e1.d.a.a aVar = this.l;
        int g2 = aVar != null ? aVar.g() : -1;
        d.b.h0.a.e1.d.a.a aVar2 = this.l;
        int d2 = aVar2 != null ? aVar2.d() : -1;
        d.b.h0.a.e1.d.a.a aVar3 = this.l;
        int e2 = aVar3 != null ? aVar3.e() : 0;
        d.b.h0.a.e1.d.a.a aVar4 = this.l;
        int f2 = aVar4 != null ? aVar4.f() : 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g2, d2);
        layoutParams.setMargins(e2, f2, 0, 0);
        return layoutParams;
    }

    public final float c(JSONObject jSONObject, String str, float f2) {
        return jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2);
    }

    @CallSuper
    public Object clone() throws CloneNotSupportedException {
        b bVar = (b) super.clone();
        d.b.h0.a.e1.d.a.a aVar = this.l;
        if (aVar != null) {
            bVar.l = (d.b.h0.a.e1.d.a.a) aVar.clone();
        } else {
            bVar.l = null;
        }
        return bVar;
    }

    @NonNull
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("【");
        sb.append(this.f43833e);
        sb.append("#");
        sb.append(TextUtils.isEmpty(this.f43834f) ? "" : this.f43834f);
        sb.append("】");
        return sb.toString();
    }

    public final void e(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(this.m, bVar.f43834f);
        this.f43834f = optString;
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component componentId is empty");
        }
        String optString2 = jSONObject.optString("slaveId", bVar.f43835g);
        this.f43835g = optString2;
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component slaveId is empty");
        }
        this.f43836h = jSONObject.optString("parentId", bVar.f43836h);
        this.i = jSONObject.optString("cb", bVar.i);
        this.j = jSONObject.optBoolean("hide", bVar.j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", bVar.k ? "1" : "0"), "1");
        d.b.h0.a.e1.d.a.a aVar = bVar.l;
        this.l = aVar;
        if (aVar == null) {
            this.l = new d.b.h0.a.e1.d.a.a();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            d.b.h0.a.e1.d.a.a aVar = new d.b.h0.a.e1.d.a.a();
            this.l = aVar;
            aVar.m(h0.f(c(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
            this.l.n(h0.f(c(optJSONObject, "top", 0.0f)));
            this.l.o(h0.f(c(optJSONObject, "width", 0.0f)));
            this.l.k(h0.f(c(optJSONObject, "height", 0.0f)));
        }
    }

    public void g(JSONObject jSONObject) {
        String optString = jSONObject.optString(this.m, this.f43834f);
        this.f43834f = optString;
        if (TextUtils.isEmpty(optString)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component componentId is empty");
        }
        String optString2 = jSONObject.optString("slaveId", this.f43835g);
        this.f43835g = optString2;
        if (TextUtils.isEmpty(optString2)) {
            d.b.h0.a.c0.c.b("Component-Model-Base", this.f43833e + " component slaveId is empty");
        }
        this.f43836h = jSONObject.optString("parentId", this.f43836h);
        this.i = jSONObject.optString("cb", this.i);
        this.j = jSONObject.optBoolean("hide", this.j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", this.k ? "1" : "0"), "1");
        f(jSONObject);
    }

    @Override // d.b.h0.a.e1.a
    public boolean isValid() {
        d.b.h0.a.e1.d.a.a aVar;
        return (TextUtils.isEmpty(this.f43834f) || TextUtils.isEmpty(this.f43835g) || (aVar = this.l) == null || !aVar.i()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.f43833e + "', componentId='" + this.f43834f + "', slaveId='" + this.f43835g + "', parentId='" + this.f43836h + "', callback='" + this.i + "', hidden=" + this.j + ", gesture=" + this.k + ", position=" + this.l + ", mComponentIdKey='" + this.m + "'}";
    }
}
