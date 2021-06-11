package com.kwad.sdk.core.video.a.a;

import androidx.annotation.Nullable;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.utils.o;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d implements com.kwad.sdk.core.b {

    /* renamed from: b  reason: collision with root package name */
    public String f34738b;

    /* renamed from: c  reason: collision with root package name */
    public String f34739c;

    /* renamed from: d  reason: collision with root package name */
    public long f34740d;

    /* renamed from: e  reason: collision with root package name */
    public String f34741e;

    /* renamed from: f  reason: collision with root package name */
    public long f34742f;

    public c(String str, String str2) {
        this.f34674a = UUID.randomUUID().toString();
        this.f34740d = System.currentTimeMillis();
        this.f34741e = m.b();
        this.f34742f = m.d();
        this.f34738b = str;
        this.f34739c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34740d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34741e = jSONObject.optString("sessionId");
            }
            this.f34742f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34738b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34739c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34740d);
        o.a(json, "sessionId", this.f34741e);
        o.a(json, IAdRequestParam.SEQ, this.f34742f);
        o.a(json, "mediaPlayerAction", this.f34738b);
        o.a(json, "mediaPlayerMsg", this.f34739c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34674a + "', timestamp=" + this.f34740d + ", sessionId='" + this.f34741e + "', seq=" + this.f34742f + ", mediaPlayerAction='" + this.f34738b + "', mediaPlayerMsg='" + this.f34739c + "'}";
    }
}
