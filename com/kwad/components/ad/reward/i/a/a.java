package com.kwad.components.ad.reward.i.a;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a extends com.kwad.components.ad.reward.i.a {
    public c uc = new c();
    public C0617a ud = new C0617a();
    public final b ue = new b(com.kwad.components.ad.reward.kwai.b.fX());

    /* renamed from: com.kwad.components.ad.reward.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0617a extends com.kwad.components.ad.reward.i.b {
        public C0617a() {
            this.tY = "安装应用";
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends com.kwad.components.ad.reward.i.b {
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r5v0 int)] */
        public b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.tY = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.tZ = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends com.kwad.components.ad.reward.i.b {
        public c() {
            this.tY = "基础奖励：观看视频";
            this.tZ = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (ai.U(context, com.kwad.sdk.core.response.a.a.ag(d.bQ(adTemplate)))) {
            aVar.iF();
        } else {
            aVar.iG();
        }
    }

    private void iE() {
        if (this.uc.isCompleted() && this.ud.isCompleted() && this.ue.isCompleted()) {
            it();
        } else {
            iu();
        }
    }

    private void iG() {
        com.kwad.sdk.core.e.b.d("LaunchAppTask", "markInstallUncompleted");
        this.ud.iu();
        iE();
    }

    public final void iB() {
        com.kwad.sdk.core.e.b.d("LaunchAppTask", "markWatchVideoCompleted");
        this.uc.it();
        iE();
    }

    public final boolean iC() {
        return this.uc.isCompleted();
    }

    public final void iF() {
        com.kwad.sdk.core.e.b.d("LaunchAppTask", "markInstallCompleted");
        this.ud.it();
        iE();
    }

    public final void iH() {
        com.kwad.sdk.core.e.b.d("LaunchAppTask", "markUseAppCompleted");
        this.ue.it();
        iE();
    }

    public final boolean iI() {
        com.kwad.sdk.core.e.b.d("LaunchAppTask", "isInstallCompleted");
        return this.ud.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final List<com.kwad.components.ad.reward.i.c> ir() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.uc);
        arrayList.add(this.ue);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.i.a
    public final int is() {
        int i = 0;
        for (com.kwad.components.ad.reward.i.c cVar : ir()) {
            if (!cVar.isCompleted()) {
                i++;
            }
        }
        return i;
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.components.ad.reward.i.c
    public final boolean isCompleted() {
        return this.ud.isCompleted() && this.ue.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.uc.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.ue.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "mWatchVideoTask", this.uc);
        r.a(jSONObject, "mInstallAppTask", this.ud);
        r.a(jSONObject, "mUseAppTask", this.ue);
        return jSONObject;
    }
}
