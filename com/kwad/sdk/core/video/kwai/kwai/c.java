package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.s;
import com.kwad.sdk.utils.r;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {
    public String b;
    public String c;
    public long d;
    public String e;
    public long f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.d = System.currentTimeMillis();
        this.e = s.b();
        this.f = s.d();
        this.b = str;
        this.c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
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
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "actionId", this.a);
        r.a(jSONObject, "timestamp", this.d);
        r.a(jSONObject, "sessionId", this.e);
        r.a(jSONObject, "seq", this.f);
        r.a(jSONObject, "mediaPlayerAction", this.b);
        r.a(jSONObject, "mediaPlayerMsg", this.c);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + "', timestamp=" + this.d + ", sessionId='" + this.e + "', seq=" + this.f + ", mediaPlayerAction='" + this.b + "', mediaPlayerMsg='" + this.c + "'}";
    }
}
