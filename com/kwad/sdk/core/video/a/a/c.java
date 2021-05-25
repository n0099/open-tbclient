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
    public String f32646b;

    /* renamed from: c  reason: collision with root package name */
    public String f32647c;

    /* renamed from: d  reason: collision with root package name */
    public long f32648d;

    /* renamed from: e  reason: collision with root package name */
    public String f32649e;

    /* renamed from: f  reason: collision with root package name */
    public long f32650f;

    public c(String str, String str2) {
        this.f32583a = UUID.randomUUID().toString();
        this.f32648d = System.currentTimeMillis();
        this.f32649e = m.b();
        this.f32650f = m.d();
        this.f32646b = str;
        this.f32647c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f32648d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f32649e = jSONObject.optString("sessionId");
            }
            this.f32650f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f32646b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f32647c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f32648d);
        o.a(json, "sessionId", this.f32649e);
        o.a(json, IAdRequestParam.SEQ, this.f32650f);
        o.a(json, "mediaPlayerAction", this.f32646b);
        o.a(json, "mediaPlayerMsg", this.f32647c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f32583a + "', timestamp=" + this.f32648d + ", sessionId='" + this.f32649e + "', seq=" + this.f32650f + ", mediaPlayerAction='" + this.f32646b + "', mediaPlayerMsg='" + this.f32647c + "'}";
    }
}
