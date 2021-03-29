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
    public String f34101b;

    /* renamed from: c  reason: collision with root package name */
    public String f34102c;

    /* renamed from: d  reason: collision with root package name */
    public long f34103d;

    /* renamed from: e  reason: collision with root package name */
    public String f34104e;

    /* renamed from: f  reason: collision with root package name */
    public long f34105f;

    public c(String str, String str2) {
        this.f34039a = UUID.randomUUID().toString();
        this.f34103d = System.currentTimeMillis();
        this.f34104e = m.b();
        this.f34105f = m.d();
        this.f34101b = str;
        this.f34102c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34103d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34104e = jSONObject.optString("sessionId");
            }
            this.f34105f = jSONObject.optLong("seq");
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34101b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34102c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34103d);
        o.a(json, "sessionId", this.f34104e);
        o.a(json, "seq", this.f34105f);
        o.a(json, "mediaPlayerAction", this.f34101b);
        o.a(json, "mediaPlayerMsg", this.f34102c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34039a + "', timestamp=" + this.f34103d + ", sessionId='" + this.f34104e + "', seq=" + this.f34105f + ", mediaPlayerAction='" + this.f34101b + "', mediaPlayerMsg='" + this.f34102c + "'}";
    }
}
