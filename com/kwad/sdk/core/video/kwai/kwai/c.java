package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f58442b;

    /* renamed from: c  reason: collision with root package name */
    public String f58443c;

    /* renamed from: d  reason: collision with root package name */
    public long f58444d;

    /* renamed from: e  reason: collision with root package name */
    public String f58445e;

    /* renamed from: f  reason: collision with root package name */
    public long f58446f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.f58444d = System.currentTimeMillis();
        this.f58445e = n.b();
        this.f58446f = n.d();
        this.f58442b = str;
        this.f58443c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f58444d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.f58445e = jSONObject.optString("sessionId");
            }
            this.f58446f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f58442b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f58443c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.f58444d);
        t.a(json, "sessionId", this.f58445e);
        t.a(json, "seq", this.f58446f);
        t.a(json, "mediaPlayerAction", this.f58442b);
        t.a(json, "mediaPlayerMsg", this.f58443c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f58444d + ", sessionId='" + this.f58445e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f58446f + ", mediaPlayerAction='" + this.f58442b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f58443c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
