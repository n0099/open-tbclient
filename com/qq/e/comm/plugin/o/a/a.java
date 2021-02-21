package com.qq.e.comm.plugin.o.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.j;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<String, b> f12330a = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.comm.plugin.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C1206a extends j {

        /* renamed from: b  reason: collision with root package name */
        private final String f12332b;
        private final String c;

        public C1206a(Context context, String str, String str2, ADListener aDListener, String str3, String str4) {
            super(context, str, str2, aDListener);
            this.f12332b = str3;
            this.c = str4;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qq.e.comm.plugin.rewardvideo.j
        public com.qq.e.comm.plugin.ad.b a() {
            com.qq.e.comm.plugin.ad.b a2 = super.a();
            a2.j(1);
            a2.c(this.f12332b);
            a2.d(this.c);
            return a2;
        }
    }

    /* loaded from: classes15.dex */
    class b implements RewardVideoADListener {

        /* renamed from: b  reason: collision with root package name */
        private final String f12334b;
        private C1206a c;
        private final e d;

        public b(e eVar, String str) {
            this.d = eVar;
            this.f12334b = str;
        }

        public C1206a a() {
            return this.c;
        }

        public void a(C1206a c1206a) {
            this.c = c1206a;
        }

        public String b() {
            return this.f12334b;
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClick() {
            this.d.a(this.f12334b, 0, a.this.a("onADClick", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADClose() {
            this.d.a(this.f12334b, 0, a.this.a("onADClose", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADExpose() {
            this.d.a(this.f12334b, 0, a.this.a("onADExpose", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADLoad() {
            long currentTimeMillis;
            if (this.c == null) {
                currentTimeMillis = 0;
            } else {
                currentTimeMillis = (System.currentTimeMillis() / 1000) + (this.c.getExpireTimestamp() - SystemClock.elapsedRealtime());
            }
            this.d.a(this.f12334b, 0, a.this.a("onADLoad", 0, null, currentTimeMillis), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onADShow() {
            this.d.a(this.f12334b, 0, a.this.a("onADShow", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onError(AdError adError) {
            this.d.a(this.f12334b, 0, a.this.a("onError", adError.getErrorCode(), adError.getErrorMsg(), 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onReward() {
            this.d.a(this.f12334b, 0, a.this.a("onReward", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoCached() {
            this.d.a(this.f12334b, 0, a.this.a("onVideoCached", 0, null, 0L), 1);
        }

        @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
        public void onVideoComplete() {
            this.d.a(this.f12334b, 0, a.this.a("onVideoComplete", 0, null, 0L), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, int i, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("data", jSONObject2);
            jSONObject2.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("message", str2);
            }
            if (j > 0) {
                jSONObject2.put("expiredTimestamp", j);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.qq.e.comm.plugin.ab.f.a.c
    public f<String> a(e eVar, View view, String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        C1206a c1206a;
        C1206a c1206a2;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            eVar.a(str4, 1, "Params Empty !", 1);
            GDTLogger.e(str2 + ": Params Empty !");
            u.a(21072, 1, null);
            return new f<>(null);
        }
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null) {
            eVar.a(str4, 3, "Json 解析结果为空 !", 1);
            GDTLogger.e(str2 + ": Json 解析结果为空 !");
            u.a(21072, 4, null);
            return new f<>(null);
        }
        String optString = jSONObject.optString("instance_id");
        String optString2 = jSONObject.optString("placement_id");
        String optString3 = jSONObject.optString("ext_url");
        String optString4 = jSONObject.optString("xflow_pos_id");
        com.qq.e.comm.plugin.y.c a2 = new com.qq.e.comm.plugin.y.c().a(optString2);
        if ("registerRewardVideoAD".equals(str2)) {
            u.a(21012, 0, a2);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                eVar.a(str4, 0, a("onError", 4001, "传入的参数有错误", 0L), 1);
                u.a(21072, 6, a2);
                return new f<>(null);
            }
            b bVar = new b(eVar, str4);
            bVar.a(new C1206a(GDTADManager.getInstance().getAppContext(), GDTADManager.getInstance().getAppStatus().getAPPID(), optString2, new RewardVideoAD.ADListenerAdapter(bVar), optString3, optString4));
            if (this.f12330a.size() < GDTADManager.getInstance().getSM().getInteger("maxRewardVideoAdsPerWebview", 100)) {
                this.f12330a.put(optString, bVar);
                eVar.a(str4, 0, a("onRegisterSuccess", 0, null, 0L), 1);
            } else {
                eVar.a(str4, 0, a("onError", 4001, "传入的参数有错误", 0L), 1);
                u.a(RequestResponseCode.START_GAME_COMMENT_REQUEST_CODE, 0, a2);
            }
            return new f<>(null);
        } else if ("loadRewardVideoAD".equals(str2)) {
            u.a(21022, 0, a2);
            if (TextUtils.isEmpty(optString)) {
                u.a(21072, 2, a2);
                GDTLogger.e("loadRewardVideoAD : instanceID is empty !");
                return new f<>(null);
            }
            b bVar2 = this.f12330a.get(optString);
            if (bVar2 != null) {
                C1206a a3 = bVar2.a();
                str4 = bVar2.b();
                c1206a2 = a3;
            } else {
                c1206a2 = null;
            }
            if (c1206a2 == null) {
                eVar.a(str4, 0, a("onError", 4017, "广告实例尚未准备好", 0L), 1);
            } else {
                c1206a2.loadAD();
            }
            return new f<>(null);
        } else if (!"showRewardVideoAD".equals(str2)) {
            u.a(21072, 5, a2);
            return new f<>(1000, "Unsupported action");
        } else {
            u.a(21032, 0, a2);
            if (TextUtils.isEmpty(optString)) {
                u.a(21072, 3, a2);
                GDTLogger.e("showRewardVideoAD : instanceID is empty !");
                return new f<>(null);
            }
            b bVar3 = this.f12330a.get(optString);
            if (bVar3 != null) {
                C1206a a4 = bVar3.a();
                str4 = bVar3.b();
                c1206a = a4;
            } else {
                c1206a = null;
            }
            if (c1206a == null) {
                eVar.a(str4, 0, a("onError", 4017, "广告实例尚未准备好", 0L), 1);
            } else {
                c1206a.showAD();
            }
            return new f<>(null);
        }
    }

    public String a() {
        return "h5RewardVideo";
    }
}
