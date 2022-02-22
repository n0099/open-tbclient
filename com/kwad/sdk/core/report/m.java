package com.kwad.sdk.core.report;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.baidu.walletfacesdk.LightInvokerImpl;
import com.kwad.sdk.utils.t;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class m extends ReportAction {
    public static final SparseArray<com.kwad.sdk.core.report.kwai.b> bP;
    public String bN;
    public final Map<String, Object> bO;

    static {
        SparseArray<com.kwad.sdk.core.report.kwai.b> sparseArray = new SparseArray<>();
        bP = sparseArray;
        sparseArray.put(1, new com.kwad.sdk.core.report.kwai.a());
    }

    public m(long j2, Map<String, Object> map) {
        super(j2);
        this.bN = com.kwad.sdk.core.network.k.c();
        this.bO = new HashMap();
        if (map != null && !map.isEmpty()) {
            this.bO.putAll(map);
        }
        this.bK = 2;
    }

    public m(JSONObject jSONObject) {
        super(jSONObject);
        this.bN = com.kwad.sdk.core.network.k.c();
        this.bO = new HashMap();
        com.kwad.sdk.core.report.kwai.b a = a(jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE));
        if (a != null) {
            a.a(jSONObject, this.bO);
        }
        this.bK = 2;
    }

    private com.kwad.sdk.core.report.kwai.b a(int i2) {
        return bP.get(b(i2));
    }

    private int b(int i2) {
        return 1;
    }

    @Override // com.kwad.sdk.core.report.ReportAction, com.kwad.sdk.core.report.c, com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        com.kwad.sdk.core.report.kwai.b a;
        super.afterToJson(jSONObject);
        if (this.bO.isEmpty() || (a = a(jSONObject.optInt(LightInvokerImpl.VOICE_ACTIONTYPE))) == null) {
            return;
        }
        a.b(jSONObject, this.bO);
        try {
            jSONObject.put("ecIdentityFlag", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.bN = jSONObject.optString("ua");
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "ua", this.bN);
        return json;
    }
}
