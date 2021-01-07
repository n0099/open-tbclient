package com.qq.e.comm.plugin.v;

import android.content.Context;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.plugin.m.i;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.p;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class h extends com.qq.e.comm.plugin.m.e {
    private a e;

    /* loaded from: classes4.dex */
    interface a extends i.a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, com.qq.e.comm.plugin.m.c cVar, VideoOption2 videoOption2, a aVar, com.qq.e.comm.plugin.y.c cVar2) {
        super(context, cVar, videoOption2, aVar, cVar2);
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.e
    public void a() {
        this.d = false;
        super.a();
    }

    @Override // com.qq.e.comm.plugin.m.e
    protected void a(long j) {
        g.a(j, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.e
    public void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        super.a(eVar);
        eVar.a(new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.v.h.1
            @Override // com.qq.e.comm.plugin.ab.f.a.b
            public String a() {
                return "onReward";
            }

            @Override // com.qq.e.comm.plugin.ab.f.a.b
            public void a(com.qq.e.comm.plugin.ab.f.e eVar2, String str, String str2, String str3) {
                if (h.this.e != null) {
                    h.this.e.a();
                }
            }
        });
    }

    @Override // com.qq.e.comm.plugin.m.e, com.qq.e.comm.plugin.m.i
    public void b() {
        a(com.qq.e.comm.plugin.z.c.a().d());
    }

    @Override // com.qq.e.comm.plugin.m.e
    protected void b(long j) {
        g.b(j, this.c);
    }

    @Override // com.qq.e.comm.plugin.m.e
    protected JSONObject d() throws JSONException {
        JSONObject a2 = n.a(this.f12498a, this.f12499b);
        a2.put("tpl_info", this.f12499b.m_());
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.m.e
    public JSONObject e() throws JSONException {
        JSONObject e = super.e();
        String B = this.f12499b.B();
        e.put("rewardVideoCardShowTime", n.a() * 1000);
        e.put("rewardVideoCloseShowTime", n.a(B) * 1000);
        e.put("rewardVideoEffectiveTime", n.b(B) * 1000);
        e.put("showRewardVideoTips", n.c(B));
        e.put("fullScreenClickable", n.a(this.f12499b));
        return e;
    }

    @Override // com.qq.e.comm.plugin.m.e
    protected JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        boolean h = this.f12499b.h();
        int a2 = p.a(this.f12498a);
        int b2 = p.b(this.f12498a);
        int a3 = b.a().a(this.f12498a, ak.b(this.f12498a, Math.max(a2, b2)));
        int b3 = ak.b(this.f12498a, Math.min(a2, b2));
        if (h) {
            jSONObject.put("width", a3);
            jSONObject.put("height", b3);
        } else {
            jSONObject.put("width", b3);
            jSONObject.put("height", a3);
        }
        jSONObject.put("isLandscape", h);
        return jSONObject;
    }
}
