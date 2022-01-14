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
    public String f56236b;

    /* renamed from: c  reason: collision with root package name */
    public String f56237c;

    /* renamed from: d  reason: collision with root package name */
    public long f56238d;

    /* renamed from: e  reason: collision with root package name */
    public String f56239e;

    /* renamed from: f  reason: collision with root package name */
    public long f56240f;

    public c(String str, String str2) {
        this.a = UUID.randomUUID().toString();
        this.f56238d = System.currentTimeMillis();
        this.f56239e = n.b();
        this.f56240f = n.d();
        this.f56236b = str;
        this.f56237c = str2;
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f56238d = jSONObject.optLong("timestamp");
            if (jSONObject.has("actionId")) {
                this.a = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.f56239e = jSONObject.optString("sessionId");
            }
            this.f56240f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f56236b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f56237c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "actionId", this.a);
        t.a(json, "timestamp", this.f56238d);
        t.a(json, "sessionId", this.f56239e);
        t.a(json, "seq", this.f56240f);
        t.a(json, "mediaPlayerAction", this.f56236b);
        t.a(json, "mediaPlayerMsg", this.f56237c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.a + ExtendedMessageFormat.QUOTE + ", timestamp=" + this.f56238d + ", sessionId='" + this.f56239e + ExtendedMessageFormat.QUOTE + ", seq=" + this.f56240f + ", mediaPlayerAction='" + this.f56236b + ExtendedMessageFormat.QUOTE + ", mediaPlayerMsg='" + this.f56237c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}
