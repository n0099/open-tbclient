package d.a.i0.a.c0.b;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import d.a.i0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b implements d.a.i0.a.l1.a, Cloneable {
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public String f40670e;

    /* renamed from: f  reason: collision with root package name */
    public String f40671f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f40672g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f40673h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f40674i = "";
    public boolean j = false;
    public boolean k = false;
    @Nullable
    public d.a.i0.a.l1.e.a.a l;
    public String m;

    static {
        boolean z = k.f43025a;
    }

    public b(@NonNull String str, @NonNull String str2) {
        this.f40670e = "unknown";
        this.m = "id";
        if (!TextUtils.isEmpty(str)) {
            this.f40670e = str;
        } else {
            d.a.i0.a.c0.g.a.a("Component-Model-Base", "component type is empty");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.m = str2;
        } else {
            d.a.i0.a.c0.g.a.a("Component-Model-Base", "component id key is empty");
        }
    }

    @Override // d.a.i0.a.l1.a
    @CallSuper
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f40671f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f40671f = jSONObject.optString(this.m);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f40671f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f40671f = jSONObject.optString("componentId");
            }
        }
        if (TextUtils.isEmpty(this.f40671f)) {
            d.b("Component-Model-Base", this.f40670e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId");
        this.f40672g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f40670e + " component slaveId is empty");
        }
        this.f40673h = jSONObject.optString("parentId");
        this.f40674i = jSONObject.optString("cb");
        this.j = jSONObject.optBoolean("hide", false);
        this.k = TextUtils.equals(jSONObject.optString("gesture"), "1");
        f(jSONObject);
    }

    public final FrameLayout.LayoutParams b() {
        d.a.i0.a.l1.e.a.a aVar = this.l;
        int g2 = aVar != null ? aVar.g() : -1;
        d.a.i0.a.l1.e.a.a aVar2 = this.l;
        int d2 = aVar2 != null ? aVar2.d() : -1;
        d.a.i0.a.l1.e.a.a aVar3 = this.l;
        int e2 = aVar3 != null ? aVar3.e() : 0;
        d.a.i0.a.l1.e.a.a aVar4 = this.l;
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
        d.a.i0.a.l1.e.a.a aVar = this.l;
        if (aVar != null) {
            bVar.l = (d.a.i0.a.l1.e.a.a) aVar.clone();
        } else {
            bVar.l = null;
        }
        return bVar;
    }

    @NonNull
    public final String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("【");
        sb.append(this.f40670e);
        sb.append("#");
        sb.append(TextUtils.isEmpty(this.f40671f) ? "" : this.f40671f);
        sb.append("】");
        return sb.toString();
    }

    public final void e(JSONObject jSONObject, @NonNull b bVar) {
        if (jSONObject == null) {
            return;
        }
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f40671f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f40671f = jSONObject.optString(this.m, bVar.f40671f);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f40671f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f40671f = jSONObject.optString("componentId", bVar.f40671f);
            }
        }
        if (TextUtils.isEmpty(this.f40671f)) {
            d.b("Component-Model-Base", this.f40670e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", bVar.f40672g);
        this.f40672g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f40670e + " component slaveId is empty");
        }
        this.f40673h = jSONObject.optString("parentId", bVar.f40673h);
        this.f40674i = jSONObject.optString("cb", bVar.f40674i);
        this.j = jSONObject.optBoolean("hide", bVar.j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", bVar.k ? "1" : "0"), "1");
        d.a.i0.a.l1.e.a.a aVar = bVar.l;
        this.l = aVar;
        if (aVar == null) {
            this.l = new d.a.i0.a.l1.e.a.a();
        }
        f(jSONObject);
    }

    public final void f(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        if (optJSONObject != null) {
            d.a.i0.a.l1.e.a.a aVar = new d.a.i0.a.l1.e.a.a();
            this.l = aVar;
            aVar.m(n0.g(c(optJSONObject, CustomDialogData.POS_LEFT, 0.0f)));
            this.l.n(n0.g(c(optJSONObject, "top", 0.0f)));
            this.l.o(n0.g(c(optJSONObject, "width", 0.0f)));
            this.l.k(n0.g(c(optJSONObject, "height", 0.0f)));
        }
    }

    public void g(JSONObject jSONObject) {
        if (!TextUtils.equals(this.m, "ARCameraId")) {
            String optString = jSONObject.optString("componentId");
            this.f40671f = optString;
            if (TextUtils.isEmpty(optString)) {
                this.f40671f = jSONObject.optString(this.m, this.f40671f);
            }
        } else {
            String optString2 = jSONObject.optString(this.m);
            this.f40671f = optString2;
            if (TextUtils.isEmpty(optString2)) {
                this.f40671f = jSONObject.optString("componentId", this.f40671f);
            }
        }
        if (TextUtils.isEmpty(this.f40671f)) {
            d.b("Component-Model-Base", this.f40670e + " component componentId is empty");
        }
        String optString3 = jSONObject.optString("slaveId", this.f40672g);
        this.f40672g = optString3;
        if (TextUtils.isEmpty(optString3)) {
            d.b("Component-Model-Base", this.f40670e + " component slaveId is empty");
        }
        this.f40673h = jSONObject.optString("parentId", this.f40673h);
        this.f40674i = jSONObject.optString("cb", this.f40674i);
        this.j = jSONObject.optBoolean("hide", this.j);
        this.k = TextUtils.equals(jSONObject.optString("gesture", this.k ? "1" : "0"), "1");
        f(jSONObject);
    }

    @Override // d.a.i0.a.l1.a
    public boolean isValid() {
        d.a.i0.a.l1.e.a.a aVar;
        return (TextUtils.isEmpty(this.f40671f) || TextUtils.isEmpty(this.f40672g) || (aVar = this.l) == null || !aVar.i()) ? false : true;
    }

    public String toString() {
        return "SwanAppBaseComponentModel{componentType='" + this.f40670e + "', componentId='" + this.f40671f + "', slaveId='" + this.f40672g + "', parentId='" + this.f40673h + "', callback='" + this.f40674i + "', hidden=" + this.j + ", gesture=" + this.k + ", position=" + this.l + ", mComponentIdKey='" + this.m + "'}";
    }
}
