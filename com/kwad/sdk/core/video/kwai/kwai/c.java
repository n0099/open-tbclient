package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f54798b;

    /* renamed from: c  reason: collision with root package name */
    public String f54799c;

    /* renamed from: d  reason: collision with root package name */
    public long f54800d;

    /* renamed from: e  reason: collision with root package name */
    public String f54801e;

    /* renamed from: f  reason: collision with root package name */
    public long f54802f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.f54800d = System.currentTimeMillis();
        this.f54801e = n.b();
        this.f54802f = n.d();
        this.f54798b = str;
        this.f54799c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54800d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.f54801e = jSONObject.optString("sessionId");
            }
            this.f54802f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f54798b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f54799c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.f54800d);
        t.a(json, "sessionId", this.f54801e);
        t.a(json, "seq", this.f54802f);
        t.a(json, "mediaPlayerAction", this.f54798b);
        t.a(json, "mediaPlayerMsg", this.f54799c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f54800d + ", sessionId='" + this.f54801e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f54802f + ", mediaPlayerAction='" + this.f54798b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f54799c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
