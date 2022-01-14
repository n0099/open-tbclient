package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public b f57216b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final C2134a f57217c = new C2134a(com.kwad.sdk.core.config.b.aA());

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2134a extends com.kwad.sdk.reward.b.a {
        public C2134a(int i2) {
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
        if (this.f57216b.d() && this.f57217c.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f57216b.d() && this.f57217c.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
        this.f57216b.a();
        k();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
        this.f57217c.a();
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
        arrayList.add(this.f57216b);
        arrayList.add(this.f57217c);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f57216b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f57217c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f57216b);
        t.a(jSONObject, "mOpenNsTask", this.f57217c);
        return jSONObject;
    }
}
