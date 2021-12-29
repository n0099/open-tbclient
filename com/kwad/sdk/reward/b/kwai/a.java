package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public b f59465b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final C2117a f59466c = new C2117a(com.kwad.sdk.core.config.b.aA());

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2117a extends com.kwad.sdk.reward.b.a {
        public C2117a(int i2) {
            this.a = String.format("浏览详情页%s秒", i2 + "");
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b() {
            this.a = "观看视频";
        }
    }

    private void k() {
        if (this.f59465b.d() && this.f59466c.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f59465b.d() && this.f59466c.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
        this.f59465b.a();
        k();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
        this.f59466c.a();
        k();
    }

    public int i() {
        int i2 = 0;
        for (com.kwad.sdk.reward.b.b bVar : j()) {
            if (!bVar.d()) {
                i2++;
            }
        }
        return i2;
    }

    public List<com.kwad.sdk.reward.b.b> j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f59465b);
        arrayList.add(this.f59466c);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f59465b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f59466c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f59465b);
        t.a(jSONObject, "mOpenNsTask", this.f59466c);
        return jSONObject;
    }
}
