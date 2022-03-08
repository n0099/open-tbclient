package com.kwad.sdk.reward.b.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.reward.b.a {

    /* renamed from: b  reason: collision with root package name */
    public b f55778b = new b();

    /* renamed from: c  reason: collision with root package name */
    public final C2129a f55779c = new C2129a(com.kwad.sdk.core.config.b.aA());

    /* renamed from: com.kwad.sdk.reward.b.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2129a extends com.kwad.sdk.reward.b.a {
        public C2129a(int i2) {
            this.a = String.format("浏览详情页%s秒", i2 + "");
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends com.kwad.sdk.reward.b.a {
        public b() {
            this.a = "观看视频";
        }
    }

    private void k() {
        if (this.f55778b.d() && this.f55779c.d()) {
            a();
        } else {
            b();
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.reward.b.b
    public boolean d() {
        return this.f55778b.d() && this.f55779c.d();
    }

    public void g() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markWatchVideoCompleted");
        this.f55778b.a();
        k();
    }

    public void h() {
        com.kwad.sdk.core.d.a.a("LandPageOpenTask", "markOpenNsCompleted");
        this.f55779c.a();
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
        arrayList.add(this.f55778b);
        arrayList.add(this.f55779c);
        return arrayList;
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.f55778b.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.f55779c.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.reward.b.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.f55778b);
        t.a(jSONObject, "mOpenNsTask", this.f55779c);
        return jSONObject;
    }
}
