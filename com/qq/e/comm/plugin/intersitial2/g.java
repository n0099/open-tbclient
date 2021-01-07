package com.qq.e.comm.plugin.intersitial2;

import android.content.Context;
import android.util.Pair;
import com.baidu.mobstat.Config;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.w.e;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g extends com.qq.e.comm.plugin.gdtnativead.f implements com.qq.e.comm.plugin.r.a {
    private JSONObject g;

    public g(Context context, ADSize aDSize, String str, String str2, l lVar, ADListener aDListener) {
        super(context, aDSize, str, str2, lVar, aDListener, com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL);
        this.g = null;
    }

    public g(Context context, ADSize aDSize, String str, String str2, l lVar, ADListener aDListener, com.qq.e.comm.plugin.ad.e eVar) {
        super(context, aDSize, str, str2, lVar, aDListener, eVar);
        this.g = null;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f
    protected void a(JSONObject jSONObject) {
        Pair<Object, Object> b2 = b(jSONObject);
        if (b2 == null || b2.first == null || b2.second == null) {
            c(6000);
            c.a(this.f, 6000);
        } else if (b2.first instanceof Integer) {
            c(((Integer) b2.first).intValue());
            c.a(this.f, ((Integer) b2.second).intValue());
        } else {
            List<NativeExpressADView> a2 = a((JSONObject) b2.first, (JSONArray) b2.second);
            if (a2 == null || a2.size() <= 0) {
                c(501);
                c.a(this.f, 5011);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a2.get(0).getBoundData().getProperty("ad_info"));
                this.f.b(jSONObject2.optString(Config.CELL_LOCATION));
                this.f.c(jSONObject2.optString("traceid"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.a(this.f12316a, this.f);
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.f
    public com.qq.e.comm.plugin.ad.e d() {
        return com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f, com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return super.getMediationPrice();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f, com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return super.isContractAd();
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f, com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        c.c(this.f);
        this.e = i;
        com.qq.e.comm.plugin.w.e.a(a(i), new com.qq.e.comm.plugin.w.b(this.c, this.f12316a, this.f12317b), new e.a() { // from class: com.qq.e.comm.plugin.intersitial2.g.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                ai.a("LoadGDTNativeExpressADFail", aVar);
                c.a(aVar, g.this.f);
                g.this.c(aVar.a());
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                ai.a("gdt_tag_net", "LoadUnifiedInterstitialADResponse: ", jSONObject);
                c.d(g.this.f);
                g.this.a(jSONObject);
            }
        });
    }
}
