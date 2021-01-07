package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.util.Pair;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l implements NEIADI {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12523a;

    /* renamed from: b  reason: collision with root package name */
    protected String f12524b;
    protected String c;
    private ADListener e;
    private String f;
    private int g;
    private int h;
    private VideoOption2 i;
    private com.qq.e.comm.plugin.ad.e j = com.qq.e.comm.plugin.ad.e.EXPRESS2;
    private int k = BrowserType.Default.value();
    protected com.qq.e.comm.plugin.y.c d = new com.qq.e.comm.plugin.y.c();
    private com.qq.e.comm.plugin.y.d l = new com.qq.e.comm.plugin.y.d();

    public l(Context context, String str, String str2, ADListener aDListener) {
        this.f12523a = context;
        this.f12524b = str;
        this.c = str2;
        this.e = aDListener;
        this.f = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        this.d.a(this.c);
        this.l.a("posId", str2);
        this.l.a("appid", str);
    }

    private com.qq.e.comm.plugin.ad.b b(int i) {
        int i2 = 0;
        com.qq.e.comm.plugin.ad.b bVar = new com.qq.e.comm.plugin.ad.b();
        bVar.a(this.c);
        bVar.c(1);
        bVar.d(i);
        bVar.e(2);
        bVar.h(this.j.b());
        bVar.k(this.i == null ? 0 : com.qq.e.comm.plugin.util.m.a(this.i.getMinVideoDuration()) ? this.i.getMinVideoDuration() : 0);
        if (this.i != null && com.qq.e.comm.plugin.util.m.a(this.i.getMaxVideoDuration())) {
            i2 = this.i.getMaxVideoDuration();
        }
        bVar.l(i2);
        bVar.a(com.qq.e.comm.plugin.z.c.a().a(bVar.c()));
        return bVar;
    }

    protected void a() {
        h.a(this.d);
    }

    protected void a(int i) {
        h.a(i, this.d);
    }

    protected void a(final int i, boolean z) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.m.l.3
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.e != null) {
                    l.this.e.onADEvent(new ADEvent(2, new Object[]{Integer.valueOf(i)}));
                }
            }
        });
    }

    public void a(com.qq.e.comm.plugin.ad.e eVar) {
        this.j = eVar;
    }

    protected void a(List<JSONObject> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (JSONObject jSONObject : list) {
            b bVar = new b(this.f12523a, this.f12524b, this.c, jSONObject, this.k, this.g, this.h, this.i);
            arrayList2.add(bVar.n().b());
            arrayList.add(new NativeExpressADDataAdapter(bVar));
        }
        com.qq.e.comm.plugin.z.c.a().a(this.c, arrayList2, this.d);
        b(arrayList);
        u.a(1210002, this.d);
    }

    protected void b(final List<NativeExpressADData2> list) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.m.l.2
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.e != null) {
                    l.this.e.onADEvent(new ADEvent(1, new Object[]{list}));
                }
            }
        });
    }

    @Override // com.qq.e.comm.pi.NEIADI
    public void loadAd(int i) {
        int i2 = 10;
        int i3 = 1;
        if (i < 1) {
            GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为1", null);
        } else {
            i3 = i;
        }
        if (i3 > 10) {
            GDTLogger.w("原生广告请求数量范围为[1, 10]，已将本次广告请求的广告数量设为10", null);
        } else {
            i2 = i3;
        }
        com.qq.e.comm.plugin.w.e.a(b(i2), new com.qq.e.comm.plugin.w.b(this.f, this.j, this.c), new e.a() { // from class: com.qq.e.comm.plugin.m.l.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                GDTLogger.e("NativeExpressAd2Impl: loadFailed", aVar);
                l.this.a(aVar.a(), false);
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                ai.a("gdt_tag_net", "LoadGDTNativeExpressAD2Response : ", jSONObject);
                Pair<JSONArray, Pair<Integer, Integer>> a2 = com.qq.e.comm.plugin.util.b.a(jSONObject, l.this.c);
                JSONArray jSONArray = (JSONArray) a2.first;
                if (jSONArray == null) {
                    Pair pair = (Pair) a2.second;
                    if (pair != null) {
                        l.this.a(((Integer) pair.first).intValue(), false);
                        l.this.a(((Integer) pair.second).intValue());
                        return;
                    }
                    return;
                }
                List<JSONObject> a3 = com.qq.e.comm.plugin.util.b.a(jSONArray, new com.qq.e.comm.plugin.ad.m(l.this.c, l.this.j, (com.qq.e.comm.plugin.ad.d) null), l.this.f);
                if (a3.size() > 0) {
                    l.this.a(a3);
                    return;
                }
                l.this.a(501, true);
                l.this.a(0);
            }
        });
        a();
    }

    @Override // com.qq.e.comm.pi.NEIADI
    public void setAdSize(int i, int i2) {
        this.g = i;
        this.h = i2;
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        this.k = i;
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.DownConfirm, Integer.valueOf(downAPPConfirmPolicy.value()), this.c);
    }

    @Override // com.qq.e.comm.pi.NEIADI
    public void setVideoOption(VideoOption2 videoOption2) {
        this.i = videoOption2;
    }
}
