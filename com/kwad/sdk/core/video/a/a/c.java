package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.utils.o;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d implements com.kwad.sdk.core.b {
    private String b;
    private String c;
    private long d;
    private String e;
    private long f;

    public c(String str, String str2) {
        this.f6245a = UUID.randomUUID().toString();
        this.d = System.currentTimeMillis();
        this.e = m.b();
        this.f = m.d();
        this.b = str;
        this.c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.d = jSONObject.optLong("timestamp");
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

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.d);
        o.a(json, "sessionId", this.e);
        o.a(json, "seq", this.f);
        o.a(json, "mediaPlayerAction", this.b);
        o.a(json, "mediaPlayerMsg", this.c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f6245a + "', timestamp=" + this.d + ", sessionId='" + this.e + "', seq=" + this.f + ", mediaPlayerAction='" + this.b + "', mediaPlayerMsg='" + this.c + "'}";
    }
}
