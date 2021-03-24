package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.utils.o;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends d implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f34100b;

    /* renamed from: c  reason: collision with root package name */
    public String f34101c;

    /* renamed from: d  reason: collision with root package name */
    public long f34102d;

    /* renamed from: e  reason: collision with root package name */
    public String f34103e;

    /* renamed from: f  reason: collision with root package name */
    public long f34104f;

    public c(String str, String str2) {
        this.f34038a = UUID.randomUUID().toString();
        this.f34102d = System.currentTimeMillis();
        this.f34103e = m.b();
        this.f34104f = m.d();
        this.f34100b = str;
        this.f34101c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34102d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34103e = jSONObject.optString("sessionId");
            }
            this.f34104f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34100b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34101c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34102d);
        o.a(json, "sessionId", this.f34103e);
        o.a(json, "seq", this.f34104f);
        o.a(json, "mediaPlayerAction", this.f34100b);
        o.a(json, "mediaPlayerMsg", this.f34101c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34038a + "', timestamp=" + this.f34102d + ", sessionId='" + this.f34103e + "', seq=" + this.f34104f + ", mediaPlayerAction='" + this.f34100b + "', mediaPlayerMsg='" + this.f34101c + "'}";
    }
}
