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
    public String f33472b;

    /* renamed from: c  reason: collision with root package name */
    public String f33473c;

    /* renamed from: d  reason: collision with root package name */
    public long f33474d;

    /* renamed from: e  reason: collision with root package name */
    public String f33475e;

    /* renamed from: f  reason: collision with root package name */
    public long f33476f;

    public c(String str, String str2) {
        this.f33409a = UUID.randomUUID().toString();
        this.f33474d = System.currentTimeMillis();
        this.f33475e = m.b();
        this.f33476f = m.d();
        this.f33472b = str;
        this.f33473c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f33474d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f33475e = jSONObject.optString("sessionId");
            }
            this.f33476f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f33472b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f33473c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f33474d);
        o.a(json, "sessionId", this.f33475e);
        o.a(json, IAdRequestParam.SEQ, this.f33476f);
        o.a(json, "mediaPlayerAction", this.f33472b);
        o.a(json, "mediaPlayerMsg", this.f33473c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f33409a + "', timestamp=" + this.f33474d + ", sessionId='" + this.f33475e + "', seq=" + this.f33476f + ", mediaPlayerAction='" + this.f33472b + "', mediaPlayerMsg='" + this.f33473c + "'}";
    }
}
