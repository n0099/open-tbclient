package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.m;
import com.qq.e.comm.plugin.ad.n;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements NEADI, com.qq.e.comm.plugin.r.a {

    /* renamed from: a  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.ad.e f12016a;

    /* renamed from: b  reason: collision with root package name */
    protected final String f12017b;
    protected final String c;
    protected final ADListener d;
    protected int e;
    protected com.qq.e.comm.plugin.y.c f;
    private final Context g;
    private final String h;
    private final ADSize i;
    private l j;
    private VideoOption k;
    private volatile int l;
    private volatile int m;
    private int n;
    private int o;
    private boolean p;
    private int q;
    private int r;

    public f(Context context, ADSize aDSize, String str, String str2, ADListener aDListener) {
        this(context, aDSize, str, str2, l.DEFAULT, aDListener);
    }

    public f(Context context, ADSize aDSize, String str, String str2, l lVar, ADListener aDListener) {
        this(context, aDSize, str, str2, lVar, aDListener, com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD);
    }

    public f(Context context, ADSize aDSize, String str, String str2, l lVar, ADListener aDListener, com.qq.e.comm.plugin.ad.e eVar) {
        this.o = -1;
        this.q = -1;
        this.f = new com.qq.e.comm.plugin.y.c();
        this.r = 0;
        this.f12016a = eVar;
        this.g = context;
        this.h = str;
        this.f12017b = str2;
        this.i = aDSize;
        this.d = aDListener;
        this.j = lVar;
        this.c = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        this.f.a(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.ad.b a(int i) {
        return a(i, (LoadAdParams) null);
    }

    protected com.qq.e.comm.plugin.ad.b a(int i, LoadAdParams loadAdParams) {
        com.qq.e.comm.plugin.ad.b bVar = new com.qq.e.comm.plugin.ad.b();
        bVar.a(this.f12017b);
        bVar.c(1);
        bVar.d(i);
        bVar.e(2);
        bVar.h(this.f12016a.b());
        bVar.a(this.i.getWidth());
        bVar.b(this.i.getHeight());
        bVar.k(this.m);
        bVar.l(this.l);
        bVar.o(this.n);
        bVar.a(this.j);
        bVar.p(1);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<NativeExpressADView> a(JSONObject jSONObject, JSONArray jSONArray) {
        JSONArray optJSONArray = jSONObject.optJSONArray("template");
        boolean z = optJSONArray != null;
        boolean z2 = (!z || jSONArray.length() == optJSONArray.length()) ? z : false;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length() > this.e ? this.e : jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            JSONObject optJSONObject2 = z2 ? optJSONArray.optJSONObject(i) : null;
            HashMap hashMap = new HashMap();
            if (SDKStatus.getSDKVersionCode() >= 3) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(Constants.KEYS.AD_INFO, c(optJSONObject));
                    hashMap.put(Constants.KEYS.AD_INFO, jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                hashMap.put(Constants.KEYS.AD_INFO, optJSONObject);
            }
            arrayList.add(new NativeExpressADView(this, this.g, this.i, this.h, this.f12017b, optJSONObject2, hashMap));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final List<NativeExpressADView> list) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.f.2
            @Override // java.lang.Runnable
            public void run() {
                f.this.d.onADEvent(new ADEvent(2, new Object[]{list}));
            }
        });
    }

    protected void a(JSONObject jSONObject) {
        ai.a("gdt_tag_net", "LoadGDTNativeExpressADResponse: ", jSONObject);
        Pair<Object, Object> b2 = b(jSONObject);
        if (b2 == null || b2.first == null || b2.second == null) {
            c(SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            c.a(this.f12016a, false, this.f, (int) SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
        } else if (b2.first instanceof Integer) {
            c(((Integer) b2.first).intValue());
            c.a(this.f12016a, false, this.f, ((Integer) b2.second).intValue());
        } else {
            List<NativeExpressADView> a2 = a((JSONObject) b2.first, (JSONArray) b2.second);
            if (a2 == null || a2.size() <= 0) {
                c(501);
                c.a(this.f12016a, false, this.f, 5011);
                return;
            }
            c.a(this.f12016a, true, this.f, 0);
            a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<Object, Object> b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray jSONArray;
        int optInt = jSONObject.optInt(Constants.KEYS.RET);
        if (optInt != 0) {
            return new Pair<>(Integer.valueOf(optInt), Integer.valueOf(optInt));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(this.f12017b)) != null) {
            int optInt2 = optJSONObject.optInt(Constants.KEYS.RET);
            if (optInt2 != 0) {
                return new Pair<>(Integer.valueOf(optInt2), Integer.valueOf(optInt2));
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return new Pair<>(501, 5025);
            }
            boolean[] zArr = new boolean[optJSONArray.length()];
            if ((this.f12016a == com.qq.e.comm.plugin.ad.e.UNIFIED_BANNER || this.f12016a == com.qq.e.comm.plugin.ad.e.UNIFIED_INTERSTITIAL || this.f12016a == com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD) && b.a()) {
                List<JSONObject> a2 = com.qq.e.comm.plugin.util.b.a(optJSONArray, new m(this.f12017b, this.f12016a, (com.qq.e.comm.plugin.ad.d) null), this.c, zArr);
                jSONArray = new JSONArray();
                if (a2 != null) {
                    for (JSONObject jSONObject2 : a2) {
                        jSONArray.put(jSONObject2);
                    }
                }
            } else {
                jSONArray = optJSONArray;
            }
            if (jSONArray.length() <= 0) {
                return new Pair<>(501, 5014);
            }
            if (zArr.length > jSONArray.length()) {
                JSONArray jSONArray2 = new JSONArray();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("template");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        if (!zArr[i]) {
                            jSONArray2.put(optJSONArray2.opt(i));
                        }
                    }
                    try {
                        optJSONObject.putOpt("template", jSONArray2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            return new Pair<>(optJSONObject, jSONArray);
        }
        return new Pair<>(501, 5004);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdData c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.qq.e.comm.plugin.ad.o oVar = new com.qq.e.comm.plugin.ad.o();
        oVar.a(LegoListActivityConfig.AD_ID, jSONObject.optString(Config.CELL_LOCATION));
        oVar.a("ad_desc", jSONObject.optString("desc"));
        oVar.a("ad_title", jSONObject.optString(DocumentOpenUtil.TXT));
        oVar.a("ad_ecpm", com.qq.e.comm.plugin.s.a.d(jSONObject));
        oVar.a("ad_ecpm_level", jSONObject.optString("ecpm_level"));
        oVar.a(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, jSONObject.optString(Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO));
        if (!com.qq.e.comm.plugin.util.m.a(jSONObject.optString("video"))) {
            oVar.a("ad_pattern_type", 2);
        }
        oVar.a("ad_video_duration", jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION) * 1000);
        oVar.a("ad_info", jSONObject.toString());
        this.q = com.qq.e.comm.plugin.s.i.b(jSONObject);
        oVar.a("ad_rt_priority", this.q);
        this.p = com.qq.e.comm.plugin.s.a.f(jSONObject);
        oVar.a("ad_contract_ad", this.p);
        this.o = com.qq.e.comm.plugin.s.a.e(jSONObject);
        oVar.a("ad_mp", this.o);
        return new n(oVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(final int i) {
        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.gdtnativead.f.3
            @Override // java.lang.Runnable
            public void run() {
                f.this.d.onADEvent(new ADEvent(1, new Object[]{Integer.valueOf(i)}));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.ad.e d() {
        return com.qq.e.comm.plugin.ad.e.NATIVEEXPRESSAD;
    }

    public void e() {
        if (this.d != null) {
            this.d.onADEvent(new ADEvent(21));
        }
    }

    public int f() {
        return this.q;
    }

    public String g() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ADListener h() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.p;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        loadAd(i, null);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i, LoadAdParams loadAdParams) {
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
        c.d(this.f12016a, this.f);
        this.e = i2;
        com.qq.e.comm.plugin.w.e.a(a(i2, loadAdParams), new com.qq.e.comm.plugin.w.b(this.c, this.f12016a, this.f12017b), new e.a() { // from class: com.qq.e.comm.plugin.gdtnativead.f.1
            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(com.qq.e.comm.plugin.k.a aVar) {
                ai.a("LoadGDTNativeExpressADFail", aVar);
                c.a(f.this.f12016a, aVar, f.this.f);
                f.this.c(aVar.a());
            }

            @Override // com.qq.e.comm.plugin.w.e.a
            public void a(JSONObject jSONObject) {
                c.e(f.this.f12016a, f.this.f);
                f.this.a(jSONObject);
            }
        });
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setBrowserType(int i) {
        this.r = i;
    }

    @Override // com.qq.e.comm.pi.ADI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        b.a(this.f12017b, downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMaxVideoDuration(int i) {
        if (com.qq.e.comm.plugin.util.m.a(i)) {
            this.l = i;
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setMinVideoDuration(int i) {
        this.m = i;
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoOption(VideoOption videoOption) {
        this.k = videoOption;
        if (videoOption != null) {
            b.a(this.f12017b, videoOption);
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void setVideoPlayPolicy(int i) {
        this.n = i;
        u.a(60582, i, this.f);
    }
}
