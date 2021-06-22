package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40939a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f40940b = new JSONStringer();

    /* renamed from: c  reason: collision with root package name */
    public String f40941c = "";

    public w0(x0 x0Var, Context context) {
        this.f40939a = context;
    }

    public w0 a(int i2, long j) {
        JSONStringer object;
        try {
            object = new JSONStringer().object();
            this.f40940b = object;
            a("e", "bce").a("timeis", x0.b()).a("co", i2).a("dr", j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var) {
        try {
            this.f40940b = x0.a("as", y0Var);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, int i2) {
        try {
            this.f40940b = x0.a("wde", y0Var);
            a("co", i2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, int i2, int i3) {
        try {
            this.f40940b = x0.a("asr", y0Var);
            a("width", i2);
            a("height", i3);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, int i2, long j) {
        try {
            this.f40940b = x0.a("bpe", y0Var);
            a("co", i2).a("dr", j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, int i2, String str) {
        try {
            this.f40940b = x0.a("wbe", y0Var);
            a("co", i2).a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, long j, int i2, int i3) {
        try {
            this.f40940b = x0.a("be", y0Var);
            a("dr", j).a("co", i2).a("num", i3);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, String str) {
        try {
            this.f40940b = x0.a("ac", y0Var);
            a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(y0 y0Var, String str, int i2) {
        try {
            this.f40940b = x0.a("dplop", y0Var);
            a("msg", x0.a(str));
            a("co", i2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(String str, long j) {
        try {
            this.f40940b.key(str).value(j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public w0 a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f40940b.key(str).value(str2);
            }
        } catch (JSONException unused) {
        }
        return this;
    }

    public final boolean a(String str) {
        if (s1.l(this.f40939a) < 0) {
            return false;
        }
        return z.a(x0.f40954a, str) ? s1.l(this.f40939a) < 1 : z.a(x0.f40955b, str) ? s1.l(this.f40939a) < 2 : z.a(x0.f40956c, str) ? s1.l(this.f40939a) < 3 : z.a(x0.f40957d, str) && s1.l(this.f40939a) < 4;
    }

    public w0 b(y0 y0Var, int i2) {
        try {
            this.f40940b = x0.a("wdin", y0Var);
            a("co", i2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public void a() {
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(this.f40940b.toString())) {
                this.f40940b.endObject();
                this.f40941c = this.f40940b.toString();
            }
            JSONObject jSONObject = new JSONObject(this.f40941c);
            String optString = jSONObject.optString("e");
            if (a(optString)) {
                return;
            }
            boolean z = !z.a(x0.f40954a, optString);
            jSONArray.put(jSONObject);
            u1.a(new v0(this, z, jSONArray.toString()));
        } catch (JSONException unused) {
        }
    }

    public w0 a(y0 y0Var, String str, int i2, int i3) {
        try {
            this.f40940b = x0.a("wdre", y0Var);
            try {
                str = z.a(str);
            } catch (Exception unused) {
            }
            a("pkg", str);
            a("vsc", i2);
            a("co", i3);
        } catch (JSONException unused2) {
        }
        return this;
    }
}
