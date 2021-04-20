package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes7.dex */
public class Z0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40138a;

    /* renamed from: b  reason: collision with root package name */
    public JSONStringer f40139b = new JSONStringer();

    /* renamed from: c  reason: collision with root package name */
    public String f40140c = "";

    public Z0(a1 a1Var, Context context) {
        this.f40138a = context;
    }

    public Z0 a(int i, long j) {
        try {
            this.f40139b = a1.c();
            a("e", "bce").a("timeis", a1.a()).a("co", i).a("dr", j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var) {
        try {
            this.f40139b = a1.a("ao", b1Var);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, int i) {
        try {
            this.f40139b = a1.a("wde", b1Var);
            a("co", i);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, int i, int i2) {
        try {
            this.f40139b = a1.a("asr", b1Var);
            a("width", i);
            a("height", i2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, int i, long j) {
        try {
            this.f40139b = a1.a("bpe", b1Var);
            a("co", i).a("dr", j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, int i, String str) {
        try {
            this.f40139b = a1.a("wbe", b1Var);
            a("co", i).a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, long j, int i, int i2) {
        try {
            this.f40139b = a1.a("be", b1Var);
            a("dr", j).a("co", i).a("num", i2);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, String str) {
        try {
            this.f40139b = a1.a("ac", b1Var);
            a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(b1 b1Var, String str, int i) {
        try {
            this.f40139b = a1.a("dplop", b1Var);
            a("msg", a1.a(str));
            a("co", i);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(String str, long j) {
        try {
            this.f40139b.key(str).value(j);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f40139b.key(str).value(str2);
            }
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 b(b1 b1Var) {
        try {
            this.f40139b = a1.a("as", b1Var);
        } catch (JSONException unused) {
        }
        return this;
    }

    public Z0 b(b1 b1Var, int i) {
        try {
            this.f40139b = a1.a("wdin", b1Var);
            a("co", i);
        } catch (JSONException unused) {
        }
        return this;
    }

    public final boolean a(String str) {
        if (V1.n(this.f40138a) < 0) {
            return false;
        }
        return G.a(a1.f40151a, str) ? V1.n(this.f40138a) < 1 : G.a(a1.f40152b, str) ? V1.n(this.f40138a) < 2 : G.a(a1.f40153c, str) ? V1.n(this.f40138a) < 3 : G.a(a1.f40154d, str) && V1.n(this.f40138a) < 4;
    }

    public void a() {
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(this.f40139b.toString())) {
                this.f40139b.endObject();
                this.f40140c = this.f40139b.toString();
            }
            JSONObject jSONObject = new JSONObject(this.f40140c);
            String optString = jSONObject.optString("e");
            if (a(optString)) {
                return;
            }
            boolean z = !G.a(a1.f40151a, optString);
            jSONArray.put(jSONObject);
            X1.a(new Y0(this, z, jSONArray.toString()));
        } catch (JSONException unused) {
        }
    }

    public Z0 a(b1 b1Var, String str, int i, int i2) {
        try {
            this.f40139b = a1.a("wdre", b1Var);
            try {
                str = G.a(str);
            } catch (Exception unused) {
            }
            a("pkg", str);
            a("vsc", i);
            a("co", i2);
        } catch (JSONException unused2) {
        }
        return this;
    }
}
