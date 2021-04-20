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
    public String f34390b;

    /* renamed from: c  reason: collision with root package name */
    public String f34391c;

    /* renamed from: d  reason: collision with root package name */
    public long f34392d;

    /* renamed from: e  reason: collision with root package name */
    public String f34393e;

    /* renamed from: f  reason: collision with root package name */
    public long f34394f;

    public c(String str, String str2) {
        this.f34328a = UUID.randomUUID().toString();
        this.f34392d = System.currentTimeMillis();
        this.f34393e = m.b();
        this.f34394f = m.d();
        this.f34390b = str;
        this.f34391c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34392d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34393e = jSONObject.optString("sessionId");
            }
            this.f34394f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34390b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34391c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34392d);
        o.a(json, "sessionId", this.f34393e);
        o.a(json, IAdRequestParam.SEQ, this.f34394f);
        o.a(json, "mediaPlayerAction", this.f34390b);
        o.a(json, "mediaPlayerMsg", this.f34391c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34328a + "', timestamp=" + this.f34392d + ", sessionId='" + this.f34393e + "', seq=" + this.f34394f + ", mediaPlayerAction='" + this.f34390b + "', mediaPlayerMsg='" + this.f34391c + "'}";
    }
}
