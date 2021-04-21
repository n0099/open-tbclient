package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.utils.o;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends d implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f34485b;

    /* renamed from: c  reason: collision with root package name */
    public String f34486c;

    /* renamed from: d  reason: collision with root package name */
    public long f34487d;

    /* renamed from: e  reason: collision with root package name */
    public String f34488e;

    /* renamed from: f  reason: collision with root package name */
    public long f34489f;

    public c(String str, String str2) {
        this.f34423a = UUID.randomUUID().toString();
        this.f34487d = System.currentTimeMillis();
        this.f34488e = m.b();
        this.f34489f = m.d();
        this.f34485b = str;
        this.f34486c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34487d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34488e = jSONObject.optString("sessionId");
            }
            this.f34489f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34485b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34486c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34487d);
        o.a(json, "sessionId", this.f34488e);
        o.a(json, IAdRequestParam.SEQ, this.f34489f);
        o.a(json, "mediaPlayerAction", this.f34485b);
        o.a(json, "mediaPlayerMsg", this.f34486c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34423a + "', timestamp=" + this.f34487d + ", sessionId='" + this.f34488e + "', seq=" + this.f34489f + ", mediaPlayerAction='" + this.f34485b + "', mediaPlayerMsg='" + this.f34486c + "'}";
    }
}
