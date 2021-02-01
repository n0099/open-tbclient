package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwai.sodler.lib.ext.PluginError;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class i implements NUADI {

    /* renamed from: a  reason: collision with root package name */
    private String f12307a;

    /* renamed from: b  reason: collision with root package name */
    private String f12308b;
    private String c;
    private com.qq.e.comm.plugin.ad.l d;
    private int e;
    private ADListener f;
    private List<String> g;
    private int h;
    private com.qq.e.comm.plugin.y.c i;
    private Handler j;
    private volatile int k;
    private volatile int l;
    private int m;
    private int n;

    public i(Context context, String str, String str2, ADListener aDListener) {
        this(context, str, str2, com.qq.e.comm.plugin.ad.l.DEFAULT, aDListener);
    }

    public i(Context context, String str, String str2, com.qq.e.comm.plugin.ad.l lVar, ADListener aDListener) {
        this.e = BrowserType.Default.value();
        this.h = -1;
        this.i = new com.qq.e.comm.plugin.y.c();
        this.j = new Handler(Looper.getMainLooper());
        this.m = 0;
        this.n = 0;
        this.f12307a = str;
        this.f12308b = str2;
        this.c = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        this.d = lVar;
        this.f = aDListener;
        this.i.a(str2);
    }

    private com.qq.e.comm.plugin.ad.b a(int i, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.ad.b bVar = new com.qq.e.comm.plugin.ad.b();
        bVar.a(this.f12308b);
        bVar.c(1);
        bVar.d(i);
        bVar.a(this.d);
        bVar.e(2);
        bVar.h(com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD.b());
        bVar.a(this.g);
        bVar.k(this.k);
        bVar.l(this.l);
        bVar.o(this.m);
        bVar.p(this.n);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        this.j.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.i.3
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f != null) {
                    i.this.f.onADEvent(new ADEvent(2, new Object[]{Integer.valueOf(i)}));
                }
            }
        });
    }

    private void a(final List<NativeUnifiedADData> list) {
        this.j.post(new Runnable() { // from class: com.qq.e.comm.plugin.nativeadunified.i.2
            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f != null) {
                    i.this.f.onADEvent(new ADEvent(1, new Object[]{list}));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        boolean z;
        ai.a("gdt_tag_net", "LoadGDTNativeUnifiedADResponse: ", jSONObject);
        int optInt = jSONObject.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            a(optInt);
            l.a(false, this.i, optInt);
            return;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(this.f12308b)) == null) {
            a(501);
            l.a(false, this.i, 5004);
            return;
        }
        int optInt2 = optJSONObject.optInt(Constants.KEYS.RET);
        if (optInt2 != 0) {
            a(optInt2);
            l.a(false, this.i, optInt2);
            return;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            a(501);
            l.a(false, this.i, 5025);
            return;
        }
        List<NativeUnifiedADData> arrayList = new ArrayList<>();
        boolean z2 = false;
        for (JSONObject jSONObject2 : com.qq.e.comm.plugin.util.b.a(optJSONArray, new m(this.f12308b, com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, (com.qq.e.comm.plugin.ad.d) null), this.c)) {
            g gVar = new g(jSONObject2, this);
            if (z2) {
                z = z2;
            } else {
                this.h = gVar.r();
                z = true;
            }
            arrayList.add(gVar);
            z2 = z;
        }
        if (arrayList.size() <= 0) {
            l.a(false, this.i, 5014);
            a(501);
            return;
        }
        l.a(true, this.i, 0);
        a(arrayList);
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.f12307a;
    }

    public String c() {
        return this.f12308b;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.h;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i) {
        loadData(i, null);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i, LoadAdParams loadAdParams) {
        int i2 = 10;
        int i3 = 1;
        l.a(this.i);
        if (Build.VERSION.SDK_INT < 16) {
            a(PluginError.ERROR_LOA_CLASS);
            l.a((int) PluginError.ERROR_LOA_CLASS, this.i);
            return;
        }
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
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        com.qq.e.comm.plugin.w.e.a(a(i2, loadAdParams), new com.qq.e.comm.plugin.w.b(this.c, com.qq.e.comm.plugin.ad.e.NATIVEUNIFIEDAD, this.f12308b), new e.a() { // from class: com.qq.e.comm.plugin.nativeadunified.i.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                GDTLogger.w("load NativeAd failed");
                l.a(aVar, i.this.i);
                i.this.a(aVar.a());
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                l.a(i.this.i, elapsedRealtime);
                i.this.a(jSONObject);
            }
        });
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        this.e = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                this.g.add(str);
            }
        }
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.DownConfirm, Integer.valueOf(downAPPConfirmPolicy.value()), this.f12308b);
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i) {
        if (com.qq.e.comm.plugin.util.m.a(i)) {
            this.l = i;
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i) {
        this.k = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoADContainerRender(int i) {
        this.n = i;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVideoPlayPolicy(int i) {
        this.m = i;
    }
}
