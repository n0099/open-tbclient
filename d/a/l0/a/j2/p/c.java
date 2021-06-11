package d.a.l0.a.j2.p;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.j2.j;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends f {
    public static final boolean E = k.f46875a;
    public String A;
    public String B;
    public long C;
    public long D;
    public int v;
    public String w;
    public String x;
    public int y;
    public String z;

    public c(String str, int i2, long j, long j2) {
        this.w = str;
        this.y = i2;
        this.C = j;
        this.D = j2;
        this.B = "0";
    }

    @Override // d.a.l0.a.j2.p.f, d.a.l0.a.j2.p.e
    public JSONObject f() {
        if (this.f46868h == null) {
            this.f46868h = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                this.f46868h.put("errorno", this.v);
            }
            String a2 = j.a(this.w);
            this.w = a2;
            this.f46868h.put("url", a2);
            this.f46868h.put("netStatus", this.y);
            if (!TextUtils.isEmpty(this.x)) {
                this.f46868h.put("msg", this.x);
            }
            if (!TextUtils.isEmpty(this.z)) {
                this.f46868h.put("pagetype", this.z);
            }
            if (!TextUtils.isEmpty(this.A)) {
                this.f46868h.put("curpage", this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                this.f46868h.put("requesttype", this.B);
            }
            if (this.D - this.C > 0) {
                this.f46868h.put("startTime", this.C);
                this.f46868h.put("endTime", this.D);
            }
            ExtensionCore M = d.a.l0.a.h0.u.g.N().M();
            if (M != null) {
                this.f46868h.put("extension_ver", M.extensionCoreVersionName);
            }
        } catch (JSONException e2) {
            if (E) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e2));
            }
        }
        return super.f();
    }

    public long l() {
        return this.C;
    }

    public String m() {
        return this.B;
    }

    public String n() {
        return this.w;
    }

    public void o(@NonNull JSONObject jSONObject) {
        try {
            if (TextUtils.equals(this.B, "1") || TextUtils.equals(this.B, "2")) {
                jSONObject.put("errorno", this.v);
            }
            jSONObject.put("url", j.a(this.w));
            jSONObject.put("netStatus", this.y);
            if (!TextUtils.isEmpty(this.x)) {
                jSONObject.put("msg", this.x);
            }
            if (!TextUtils.isEmpty(this.B)) {
                jSONObject.put("requesttype", this.B);
            }
            if (this.D - this.C > 0) {
                jSONObject.put("startTime", this.C);
                jSONObject.put("endTime", this.D);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void p(String str) {
        this.A = str;
    }

    public void q(String str) {
        this.z = str;
    }

    public c(int i2, String str, String str2, int i3) {
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.B = "1";
    }

    public c(int i2, String str, String str2, int i3, long j, long j2) {
        this.v = i2;
        this.w = str;
        this.x = str2;
        this.y = i3;
        this.C = j;
        this.D = j2;
        if (i2 == 200 && j2 - j >= 5000) {
            this.B = "2";
        } else {
            this.B = "1";
        }
    }
}
