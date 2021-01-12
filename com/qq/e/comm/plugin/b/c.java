package com.qq.e.comm.plugin.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.mobstat.Config;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.gdtnativead.f;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.n;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class c extends f {
    private volatile int g;
    private final Runnable h;
    private volatile boolean i;
    private LoadAdParams j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        super(context, aDSize, str, str2, l.DEFAULT, aDListener, e.UNIFIED_BANNER);
        this.g = 30;
        this.h = new Runnable() { // from class: com.qq.e.comm.plugin.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.i) {
                    c.this.loadAd(c.this.e);
                }
            }
        };
        this.i = true;
        this.j = null;
    }

    private void i() {
        if (this.g == 0) {
            c();
        } else if (this.i) {
            if (this.g < 30 || this.g > 120) {
                w.a(this.h, 30000L);
            } else {
                w.a(this.h, this.g * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.f
    public com.qq.e.comm.plugin.ad.b a(int i) {
        com.qq.e.comm.plugin.ad.b a2 = super.a(i);
        if (com.qq.e.comm.plugin.a.a().d() && this.j != null) {
            a2.g(this.j.getLoginAppId());
            a2.a(this.j.getLoginType());
            a2.e(this.j.getLoginOpenid());
            a2.c(this.j.getExtraInfo());
            u.a(100402, 1, new com.qq.e.comm.plugin.y.c().a(this.f12017b), n.a(this.j));
            GDTLogger.d("Banner 2.0: " + this.j.toString());
        }
        return a2;
    }

    public void a() {
        b();
        loadAd(this.f12016a.c());
    }

    public void a(LoadAdParams loadAdParams) {
        this.j = loadAdParams;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f
    protected void a(JSONObject jSONObject) {
        Pair<Object, Object> b2 = b(jSONObject);
        if (b2 == null || b2.first == null || b2.second == null) {
            c(SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            b.a(false, this.f, (int) SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
        } else if (b2.first instanceof Integer) {
            c(((Integer) b2.first).intValue());
            b.a(false, this.f, ((Integer) b2.second).intValue());
        } else {
            List<NativeExpressADView> a2 = a((JSONObject) b2.first, (JSONArray) b2.second);
            if (a2 == null || a2.size() <= 0) {
                c(501);
                b.a(false, this.f, 5011);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a2.get(0).getBoundData().getProperty("ad_info"));
                this.f.b(jSONObject2.optString(Config.CELL_LOCATION));
                this.f.c(jSONObject2.optString("traceid"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            b.a(true, this.f, 0);
            a(a2);
        }
    }

    public void b() {
        w.c(this.h);
        this.i = true;
    }

    public void b(int i) {
        this.g = i;
    }

    public void c() {
        w.c(this.h);
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.gdtnativead.f
    public e d() {
        return e.UNIFIED_BANNER;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.f, com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        b.b(this.f);
        this.e = i;
        com.qq.e.comm.plugin.w.e.a(a(i), new com.qq.e.comm.plugin.w.b(this.c, this.f12016a, this.f12017b), new e.a() { // from class: com.qq.e.comm.plugin.b.c.2
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                ai.a("LoadGDTNativeExpressADFail", aVar);
                b.a(aVar, c.this.f);
                c.this.c(aVar.a());
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                ai.a("gdt_tag_net", "LoadGDTUnifiedBannerADResponse: ", jSONObject);
                b.c(c.this.f);
                c.this.a(jSONObject);
            }
        });
        i();
    }
}
