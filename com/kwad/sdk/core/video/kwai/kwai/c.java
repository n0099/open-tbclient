package com.kwad.sdk.core.video.kwai.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.utils.t;
import java.util.UUID;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends com.kwad.sdk.core.report.c implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f56448b;

    /* renamed from: c  reason: collision with root package name */
    public String f56449c;

    /* renamed from: d  reason: collision with root package name */
    public long f56450d;

    /* renamed from: e  reason: collision with root package name */
    public String f56451e;

    /* renamed from: f  reason: collision with root package name */
    public long f56452f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.f56450d = System.currentTimeMillis();
        this.f56451e = n.b();
        this.f56452f = n.d();
        this.f56448b = str;
        this.f56449c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f56450d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.f56451e = jSONObject.optString("sessionId");
            }
            this.f56452f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f56448b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f56449c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.f56450d);
        t.a(json, "sessionId", this.f56451e);
        t.a(json, "seq", this.f56452f);
        t.a(json, "mediaPlayerAction", this.f56448b);
        t.a(json, "mediaPlayerMsg", this.f56449c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f56450d + ", sessionId='" + this.f56451e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f56452f + ", mediaPlayerAction='" + this.f56448b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f56449c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
