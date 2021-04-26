package d.a.h0.a.z1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends f {
    public static final boolean F = k.f43101a;
    public String A;
    public String B;
    public String C;
    public long D;
    public long E;
    public int w;
    public String x;
    public String y;
    public int z;

    public c(String str, int i2) {
        this.x = str;
        this.z = i2;
        this.C = "0";
    }

    @Override // d.a.h0.a.z1.k.f, d.a.h0.a.z1.k.e
    public JSONObject f() {
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            if (TextUtils.equals(this.C, "1") || TextUtils.equals(this.C, "2")) {
                this.f45417g.put("errorno", this.w);
            }
            String a2 = d.a.h0.a.z1.g.a(this.x);
            this.x = a2;
            this.f45417g.put("url", a2);
            this.f45417g.put("netStatus", this.z);
            if (!TextUtils.isEmpty(this.y)) {
                this.f45417g.put("msg", this.y);
            }
            if (!TextUtils.isEmpty(this.A)) {
                this.f45417g.put("pagetype", this.A);
            }
            if (!TextUtils.isEmpty(this.B)) {
                this.f45417g.put("curpage", this.B);
            }
            if (!TextUtils.isEmpty(this.C)) {
                this.f45417g.put("requesttype", this.C);
            }
            if (this.E - this.D > 0) {
                this.f45417g.put("startTime", this.D);
                this.f45417g.put("endTime", this.E);
            }
        } catch (JSONException e2) {
            if (F) {
                Log.d("SwanAppRequestEvent", Log.getStackTraceString(e2));
            }
        }
        return super.f();
    }

    public String l() {
        return this.C;
    }

    public String m() {
        return this.x;
    }

    public void n(String str) {
        this.B = str;
    }

    public void o(String str) {
        this.A = str;
    }

    public c(int i2, String str, String str2, int i3) {
        this.w = i2;
        this.x = str;
        this.y = str2;
        this.z = i3;
        this.C = "1";
    }

    public c(int i2, String str, String str2, int i3, long j, long j2) {
        this.w = i2;
        this.x = str;
        this.y = str2;
        this.z = i3;
        this.D = j;
        this.E = j2;
        if (i2 == 200 && j2 - j >= 5000) {
            this.C = "2";
        } else {
            this.C = "1";
        }
    }
}
