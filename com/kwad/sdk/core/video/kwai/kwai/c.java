package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f39897b;

    /* renamed from: c  reason: collision with root package name */
    public String f39898c;

    /* renamed from: d  reason: collision with root package name */
    public long f39899d;

    /* renamed from: e  reason: collision with root package name */
    public String f39900e;

    /* renamed from: f  reason: collision with root package name */
    public long f39901f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.f39899d = System.currentTimeMillis();
        this.f39900e = n.b();
        this.f39901f = n.d();
        this.f39897b = str;
        this.f39898c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f39899d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.f39900e = jSONObject.optString("sessionId");
            }
            this.f39901f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f39897b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f39898c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.f39899d);
        t.a(json, "sessionId", this.f39900e);
        t.a(json, "seq", this.f39901f);
        t.a(json, "mediaPlayerAction", this.f39897b);
        t.a(json, "mediaPlayerMsg", this.f39898c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + "', timestamp=" + this.f39899d + ", sessionId='" + this.f39900e + "', seq=" + this.f39901f + ", mediaPlayerAction='" + this.f39897b + "', mediaPlayerMsg='" + this.f39898c + "'}";
    }
}
