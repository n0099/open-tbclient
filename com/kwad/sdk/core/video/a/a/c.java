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
    public String f34836b;

    /* renamed from: c  reason: collision with root package name */
    public String f34837c;

    /* renamed from: d  reason: collision with root package name */
    public long f34838d;

    /* renamed from: e  reason: collision with root package name */
    public String f34839e;

    /* renamed from: f  reason: collision with root package name */
    public long f34840f;

    public c(String str, String str2) {
        this.f34772a = UUID.randomUUID().toString();
        this.f34838d = System.currentTimeMillis();
        this.f34839e = m.b();
        this.f34840f = m.d();
        this.f34836b = str;
        this.f34837c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f34838d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f34839e = jSONObject.optString("sessionId");
            }
            this.f34840f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f34836b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f34837c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f34838d);
        o.a(json, "sessionId", this.f34839e);
        o.a(json, IAdRequestParam.SEQ, this.f34840f);
        o.a(json, "mediaPlayerAction", this.f34836b);
        o.a(json, "mediaPlayerMsg", this.f34837c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f34772a + "', timestamp=" + this.f34838d + ", sessionId='" + this.f34839e + "', seq=" + this.f34840f + ", mediaPlayerAction='" + this.f34836b + "', mediaPlayerMsg='" + this.f34837c + "'}";
    }
}
