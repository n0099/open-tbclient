package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
/* loaded from: classes14.dex */
public class bx {

    /* renamed from: a  reason: collision with root package name */
    public Context f8135a;
    public JSONStringer qlo = new JSONStringer();
    public String c = "";

    public bx(ca caVar, Context context) {
        this.f8135a = context;
    }

    public bx H(int i, long j) {
        try {
            this.qlo = ca.eJe();
            hD("e", "bce").hD("timeis", ca.a()).P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx P(String str, long j) {
        try {
            this.qlo.key(str).value(j);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar) {
        try {
            this.qlo = ca.a("as", cdVar);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, int i) {
        try {
            this.qlo = ca.a("wdin", cdVar);
            P(BdStatsConstant.StatsKey.COUNT, i);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, int i, int i2) {
        try {
            this.qlo = ca.a("asr", cdVar);
            P("width", i);
            P("height", i2);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, int i, long j) {
        try {
            this.qlo = ca.a("bpe", cdVar);
            P(BdStatsConstant.StatsKey.COUNT, i).P("dr", j);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, int i, String str) {
        try {
            this.qlo = ca.a("wbe", cdVar);
            P(BdStatsConstant.StatsKey.COUNT, i).hD("msg", ca.a(str));
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, long j, int i, int i2) {
        try {
            this.qlo = ca.a("be", cdVar);
            P("dr", j).P(BdStatsConstant.StatsKey.COUNT, i).P("num", i2);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, String str) {
        try {
            this.qlo = ca.a("ac", cdVar);
            hD("msg", ca.a(str));
        } catch (JSONException e) {
        }
        return this;
    }

    public bx a(cd cdVar, String str, int i) {
        try {
            this.qlo = ca.a("dplop", cdVar);
            hD("msg", ca.a(str));
            P(BdStatsConstant.StatsKey.COUNT, i);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx b(cd cdVar) {
        try {
            this.qlo = ca.a("ao", cdVar);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx b(cd cdVar, int i) {
        try {
            this.qlo = ca.a("wde", cdVar);
            P(BdStatsConstant.StatsKey.COUNT, i);
        } catch (JSONException e) {
        }
        return this;
    }

    public bx hD(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.qlo.key(str).value(str2);
            }
        } catch (JSONException e) {
        }
        return this;
    }

    public final boolean a(String str) {
        if (bp.iQ(this.f8135a) < 0) {
            return false;
        }
        return v.a(ca.f8138a, str) ? bp.iQ(this.f8135a) < 1 : v.a(ca.b, str) ? bp.iQ(this.f8135a) < 2 : v.a(ca.c, str) ? bp.iQ(this.f8135a) < 3 : v.a(ca.d, str) && bp.iQ(this.f8135a) < 4;
    }

    public void a() {
        JSONArray jSONArray = new JSONArray();
        try {
            if (!TextUtils.isEmpty(this.qlo.toString())) {
                this.qlo.endObject();
                this.c = this.qlo.toString();
            }
            JSONObject jSONObject = new JSONObject(this.c);
            String optString = jSONObject.optString("e");
            if (!a(optString)) {
                boolean z = !v.a(ca.f8138a, optString);
                jSONArray.put(jSONObject);
                bt.a(new bu(this, z, jSONArray.toString()));
            }
        } catch (JSONException e) {
        }
    }

    public bx a(cd cdVar, String str, int i, int i2) {
        try {
            this.qlo = ca.a("wdre", cdVar);
            try {
                str = v.a(str);
            } catch (Exception e) {
            }
            hD(Config.INPUT_DEF_PKG, str);
            P("vsc", i);
            P(BdStatsConstant.StatsKey.COUNT, i2);
        } catch (JSONException e2) {
        }
        return this;
    }
}
