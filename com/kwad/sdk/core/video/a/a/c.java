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
    public String f32717b;

    /* renamed from: c  reason: collision with root package name */
    public String f32718c;

    /* renamed from: d  reason: collision with root package name */
    public long f32719d;

    /* renamed from: e  reason: collision with root package name */
    public String f32720e;

    /* renamed from: f  reason: collision with root package name */
    public long f32721f;

    public c(String str, String str2) {
        this.f32654a = UUID.randomUUID().toString();
        this.f32719d = System.currentTimeMillis();
        this.f32720e = m.b();
        this.f32721f = m.d();
        this.f32717b = str;
        this.f32718c = str2;
    }

    @Override // com.kwad.sdk.core.report.d
    public void a(@Nullable JSONObject jSONObject) {
        super.a(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.f32719d = jSONObject.optLong("timestamp");
            if (jSONObject.has("sessionId")) {
                this.f32720e = jSONObject.optString("sessionId");
            }
            this.f32721f = jSONObject.optLong(IAdRequestParam.SEQ);
            if (jSONObject.has("mediaPlayerAction")) {
                this.f32717b = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.f32718c = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.d, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "timestamp", this.f32719d);
        o.a(json, "sessionId", this.f32720e);
        o.a(json, IAdRequestParam.SEQ, this.f32721f);
        o.a(json, "mediaPlayerAction", this.f32717b);
        o.a(json, "mediaPlayerMsg", this.f32718c);
        return json;
    }

    public String toString() {
        return "MediaPlayerReportAction{actionId='" + this.f32654a + "', timestamp=" + this.f32719d + ", sessionId='" + this.f32720e + "', seq=" + this.f32721f + ", mediaPlayerAction='" + this.f32717b + "', mediaPlayerMsg='" + this.f32718c + "'}";
    }
}
