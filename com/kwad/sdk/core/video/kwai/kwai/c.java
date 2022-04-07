package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
    public String b;
    public String c;
    public long d;
    public String e;
    public long f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.d = System.currentTimeMillis();
        this.e = n.b();
        this.f = n.d();
        this.b = str;
        this.c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.e = jSONObject.optString("sessionId");
            }
            this.f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.d);
        t.a(json, "sessionId", this.e);
        t.a(json, "seq", this.f);
        t.a(json, "mediaPlayerAction", this.b);
        t.a(json, "mediaPlayerMsg", this.c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + "', timestamp=" + this.d + ", sessionId='" + this.e + "', seq=" + this.f + ", mediaPlayerAction='" + this.b + "', mediaPlayerMsg='" + this.c + "'}";
    }
}
