package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
@KsJson
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aFK = new ArrayList();
    public List<String> aFL = new ArrayList();
    public List<String> aFM = new ArrayList();
    public List<String> aFN = new ArrayList();
    public List<b> aFO = new ArrayList();
    public Map<String, b> aFP = new HashMap();
    public int aFQ;
    public int aFR;
    public int aFS;
    public double anQ;

    public final boolean GL() {
        if ((this.aFS & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean GM() {
        if ((this.aFS & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean GN() {
        if ((this.aFS & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean GO() {
        if (this.aFS == 0) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aFO;
        if (list != null) {
            for (b bVar : list) {
                this.aFP.put(bVar.appId, bVar);
            }
            this.aFO.clear();
        }
    }

    @Nullable
    public final b fd(String str) {
        b bVar = null;
        if (this.aFP == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            bVar = this.aFP.get(str);
        }
        if (bVar == null) {
            return this.aFP.get("000000000");
        }
        return bVar;
    }
}
