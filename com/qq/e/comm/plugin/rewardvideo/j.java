package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobstat.Config;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.plugin.aa.a.b;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.aq;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.az;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.util.w;
import com.qq.e.comm.plugin.w.e;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import yaq.gdtadv;
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes4.dex */
public class j implements RVADI, com.qq.e.comm.plugin.r.a {
    private static HashMap<Integer, WeakReference<j>> v = new HashMap<>();
    private LoadAdParams A;
    private boolean B;
    private final Map<String, m> C;

    /* renamed from: a  reason: collision with root package name */
    private final String f12709a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12710b;
    private final com.qq.e.comm.plugin.ad.l c;
    private final ADListener d;
    private final String e;
    private int f;
    private int g;
    private String[] h;
    private volatile boolean i;
    private long j;
    private int k;
    private int l;
    private boolean m;
    private String n;
    private int o;
    private int p;
    private b q;
    private final Handler r;
    private e s;
    private com.qq.e.comm.plugin.y.c t;
    private final int u;
    private volatile WeakReference<l> w;
    private volatile WeakReference<g> x;
    private String y;
    private boolean z;

    /* renamed from: com.qq.e.comm.plugin.rewardvideo.j$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements e.a {
        AnonymousClass1() {
        }

        @Override // com.qq.e.comm.plugin.w.e.a
        public void a(com.qq.e.comm.plugin.k.a aVar) {
            ai.a("LoadGDTRewardVideoADFail", aVar);
            j.this.a(aVar.a());
            h.a(aVar, j.this.t);
        }

        @Override // com.qq.e.comm.plugin.w.e.a
        public void a(JSONObject jSONObject) {
            j.this.b(jSONObject);
            h.e(j.this.t);
        }
    }

    /* loaded from: classes4.dex */
    private class a extends Handler {
        a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    j.this.d.onADEvent(new ADEvent(9, new Object[]{Integer.valueOf(message.arg1)}));
                    return;
                case 2:
                    j.this.d.onADEvent(new ADEvent(2));
                    return;
                case 3:
                    Bundle data = message.getData();
                    String string = data != null ? data.getString("click_url") : null;
                    ADListener aDListener = j.this.d;
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    aDListener.onADEvent(new ADEvent(6, new Object[]{string}));
                    return;
                case 4:
                    j.this.d.onADEvent(new ADEvent(8));
                    return;
                case 5:
                    j.this.d.onADEvent(new ADEvent(4));
                    return;
                case 6:
                    j.this.d.onADEvent(new ADEvent(5));
                    return;
                case 7:
                    j.this.d.onADEvent(new ADEvent(7));
                    return;
                case 8:
                    j.this.d.onADEvent(new ADEvent(1));
                    return;
                case 9:
                    j.this.d.onADEvent(new ADEvent(3));
                    return;
                default:
                    return;
            }
        }
    }

    public j(Context context, String str, String str2, ADListener aDListener) {
        this(context, str, str2, com.qq.e.comm.plugin.ad.l.DEFAULT, aDListener);
    }

    public j(Context context, String str, String str2, com.qq.e.comm.plugin.ad.l lVar, ADListener aDListener) {
        this.f12709a = getClass().getSimpleName();
        this.i = false;
        this.j = 0L;
        this.k = -1;
        this.l = -1;
        this.p = -1;
        this.r = new a();
        this.s = e.VIDEO;
        this.t = new com.qq.e.comm.plugin.y.c();
        this.z = true;
        this.A = null;
        this.B = false;
        this.C = new HashMap(2);
        this.f12710b = str2;
        this.t.a(str2);
        this.c = lVar;
        this.f = n.b();
        this.d = aDListener;
        this.e = com.qq.e.comm.plugin.util.a.a(str, str2, o.b());
        this.u = ac.a();
        v.put(Integer.valueOf(this.u), new WeakReference<>(this));
        this.q = new b();
    }

    private com.qq.e.comm.plugin.y.c a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.y.c cVar = new com.qq.e.comm.plugin.y.c();
        cVar.a(this.f12710b);
        if (jSONObject != null) {
            cVar.b(jSONObject.optString(Config.CELL_LOCATION));
            cVar.c(jSONObject.optString("traceid"));
        }
        return cVar;
    }

    private void a(Context context, boolean z) {
        h.c(this.s, this.t);
        int i = this.h == null ? 4014 : this.i ? 4015 : SystemClock.elapsedRealtime() > this.j ? 5012 : 0;
        if (i != 0) {
            a(i);
            h.a(this.s, i, this.t);
        } else if (this.s != e.PAGE) {
            b(context, z);
        } else {
            a(context, z, this.h[0]);
        }
    }

    private void a(Context context, boolean z, String str) {
        ai.a(this.f12709a, "jumpToRewardPage");
        Intent intent = new Intent();
        intent.setClassName(context, ar.b());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "rewardPage");
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        intent.putExtra("objectId", this.u);
        intent.putExtra("clickStartTime", System.currentTimeMillis());
        intent.putExtra(Constants.KEYS.AD_INFO, str);
        intent.putExtra("posId", this.f12710b);
        intent.putExtra("adThreadId", this.e);
        if (z) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void a(List<JSONObject> list) {
        this.g = list.size();
        this.j = n.c();
        this.h = new String[this.g];
        this.i = false;
        for (int i = 0; i < this.g; i++) {
            this.h[i] = list.get(i).toString();
        }
        if (list.size() <= 0) {
            c(5014);
            return;
        }
        JSONObject jSONObject = list.get(0);
        if (TextUtils.isEmpty(jSONObject.optString("video"))) {
            this.s = e.PAGE;
        } else {
            this.s = e.VIDEO;
        }
        this.t.b(jSONObject.optString(Config.CELL_LOCATION));
        this.t.c(jSONObject.optString("traceid"));
        this.k = com.qq.e.comm.plugin.s.a.d(jSONObject);
        this.l = -1;
        String optString = jSONObject.optString("mp");
        if (!TextUtils.isEmpty(optString)) {
            try {
                this.l = Integer.parseInt(new String(aq.b(Base64.decode(optString, 0)), com.qq.e.comm.plugin.f.a.f12290a));
            } catch (aq.b e) {
                e.printStackTrace();
            }
        }
        GDTLogger.d("ad response mp origin value: " + optString + " decryption value: " + this.l);
        this.n = jSONObject.optString("ecpm_level");
        this.o = jSONObject.optInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION);
        this.p = com.qq.e.comm.plugin.s.i.b(jSONObject);
        this.m = com.qq.e.comm.plugin.s.a.f(jSONObject);
    }

    private void a(boolean z) {
        ai.a(this.f12709a, "callbackADCache, realAdCount : " + this.g);
        this.r.sendEmptyMessage(2);
        h.a(this.s, z, true, this.t, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j b(int i) {
        WeakReference<j> weakReference = v.get(Integer.valueOf(i));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void b(Context context, boolean z) {
        ai.a(this.f12709a, "jumpToRewardVideo");
        Intent intent = new Intent();
        if ("l".equals(GDTADManager.getInstance().getDeviceStatus().getScreenOrientation())) {
            if (m()) {
                intent.setClassName(context, ar.e());
            } else {
                intent.setClassName(context, ar.d());
            }
        } else if (m()) {
            intent.setClassName(context, ar.c());
        } else {
            intent.setClassName(context, ar.b());
        }
        intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
        intent.putExtra(ACTD.DELEGATE_NAME_KEY, "rewardVideo");
        intent.putExtra("adThreadId", this.e);
        intent.putExtra("posId", this.f12710b);
        intent.putExtra(Constants.KEYS.AD_INFO, this.h[0]);
        intent.putExtra("objectId", this.u);
        intent.putExtra("rewardVideoExpireTime", this.j);
        if (!TextUtils.isEmpty(this.y)) {
            intent.putExtra("styleUrl", this.y);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private void b(final String str) {
        ai.b("gdt_tag_reward_video", "downloadHtmlFile（%s）", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final File e = ah.e(str);
        if (e == null || e.exists()) {
            ai.b("gdt_tag_reward_video", "downloadHtmlFile is null or already exsits , downloadHtmlFile = %s", e);
            return;
        }
        ai.b("gdt_tag_reward_video", "start download , styleUrl = %s , file = %s", str, e);
        com.qq.e.comm.plugin.t.b.c cVar = new com.qq.e.comm.plugin.t.b.c(str, e.a.GET, (byte[]) null);
        ai.a("gdt_tag_net", ai.a(cVar));
        com.qq.e.comm.plugin.t.d.a().a(cVar, c.a.High, new com.qq.e.comm.plugin.t.b() { // from class: com.qq.e.comm.plugin.rewardvideo.j.2
            @Override // com.qq.e.comm.plugin.t.b
            public void a(com.qq.e.comm.plugin.t.b.e eVar, com.qq.e.comm.plugin.t.b.f fVar) {
                if (fVar.e() == 200) {
                    ai.b("gdt_tag_reward_video", "onResponse ok : %s  ", str);
                    try {
                        final String d = fVar.d();
                        if (TextUtils.isEmpty(d)) {
                            return;
                        }
                        w.a(new Runnable() { // from class: com.qq.e.comm.plugin.rewardvideo.j.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                long currentTimeMillis = System.currentTimeMillis();
                                ah.a(e, d);
                                ai.b("gdt_tag_reward_video", "HtmlFile write cost : %d  ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    } catch (IOException e2) {
                        ai.b("gdt_tag_reward_video", "onResponse exception (%s)  ", e2);
                    }
                }
            }

            @Override // com.qq.e.comm.plugin.t.b
            public void a(Exception exc) {
                ai.b("gdt_tag_reward_video", "onException (%s)  ", exc);
            }
        });
    }

    private void b(String str, com.qq.e.comm.plugin.j.c cVar) {
        synchronized (this) {
            if (!this.B) {
                this.B = true;
                h.a(this.s, false, false, this.t, str, cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        gdtadv.getVresult(118, 0, this, jSONObject);
    }

    private m c(String str) {
        m mVar = this.C.get(str);
        if (mVar == null) {
            m mVar2 = new m();
            this.C.put(str, mVar2);
            return mVar2;
        }
        return mVar;
    }

    private void c(int i) {
        if (this.q.b()) {
            ai.a(this.f12709a, "reward Ad retry load");
            k();
        } else {
            a(501);
        }
        h.a(i, this.t);
    }

    private void c(JSONObject jSONObject) {
        boolean z = true;
        if (this.s == e.PAGE) {
            a(false);
            return;
        }
        com.qq.e.comm.plugin.y.c a2 = a(jSONObject);
        String optString = jSONObject.optString("video");
        File d = ah.d(optString);
        if (d == null || !d.exists()) {
            a(optString, a2);
            z = false;
        } else {
            a(true);
        }
        h.b(this.s, z, a2);
    }

    private void k() {
        gdtadv.getVresult(119, 0, this);
    }

    private void l() {
        this.y = null;
        String stringForPlacement = GDTADManager.getInstance().getSM().getStringForPlacement("rewardVideoExp", this.f12710b);
        if (TextUtils.isEmpty(stringForPlacement)) {
            return;
        }
        String a2 = az.a(stringForPlacement, "expId");
        if (TextUtils.isEmpty(a2)) {
            ai.b("gdt_tag_reward_video", "error , expIdString cannot be empty ,styleUrl = %s", stringForPlacement);
            return;
        }
        try {
            int intValue = Integer.valueOf(a2).intValue();
            if (intValue > 0) {
                this.y = stringForPlacement;
                ai.b("gdt_tag_reward_video", "hit the experiment， expId = %d , styleUrl = %s", Integer.valueOf(intValue), stringForPlacement);
                b(this.y);
            }
        } catch (Throwable th) {
            ai.b("gdt_tag_reward_video", "error , expIdString = %s ,styleUrl = %s , throwable = %s", a2, stringForPlacement, th);
        }
    }

    private boolean m() {
        return (SDKStatus.getSDKVersionCode() < 60 || Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.qq.e.comm.plugin.ad.b a() {
        return (com.qq.e.comm.plugin.ad.b) gdtadv.getobjresult(120, 0, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        this.r.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar) {
        this.x = new WeakReference<>(gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.w = new WeakReference<>(lVar);
        for (m mVar : this.C.values()) {
            mVar.a(lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a(5002);
        b(str, (com.qq.e.comm.plugin.j.c) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, com.qq.e.comm.plugin.j.c cVar) {
        a(5002);
        b(str, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, com.qq.e.comm.plugin.y.c cVar) {
        l lVar;
        File f = ah.f();
        File d = ah.d(str);
        if (f == null) {
            a(str, (com.qq.e.comm.plugin.j.c) null);
            if (this.w == null || (lVar = this.w.get()) == null) {
                return;
            }
            lVar.f();
        } else if (d == null || !d.exists()) {
            com.qq.e.comm.plugin.aa.a.b a2 = new b.a().b(str).a(ah.a(str)).a(f).a();
            m c = c(str);
            c.a(this);
            c.a(str);
            c.a(cVar);
            com.qq.e.comm.plugin.aa.a.a.a().a(a2, str, c);
        }
    }

    public int b() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        a(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.r.sendEmptyMessage(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        Message obtain = Message.obtain(this.r, 3);
        Bundle bundle = new Bundle();
        bundle.putString("click_url", "");
        obtain.setData(bundle);
        this.r.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.r.sendEmptyMessage(6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.i = true;
        this.r.sendEmptyMessage(9);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getECPM() {
        return this.k;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public String getECPMLevel() {
        return this.n;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public long getExpireTimestamp() {
        return this.j;
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.l;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getRewardAdType() {
        return this.s == e.PAGE ? 1 : 0;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public int getVideoDuration() {
        return this.o * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.r.sendEmptyMessage(5);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public boolean hasShown() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.r.sendEmptyMessage(7);
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.m;
    }

    public boolean j() {
        return this.z;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void loadAD() {
        this.q.a();
        k();
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.A = loadAdParams;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void setVolumeOn(boolean z) {
        this.z = z;
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD() {
        a(GDTADManager.getInstance().getAppContext(), true);
    }

    @Override // com.qq.e.comm.pi.RVADI
    public void showAD(Activity activity) {
        if (activity != null) {
            a((Context) activity, false);
            return;
        }
        GDTLogger.e("showAd(Activity activity) param activity can't be null");
        a(4001);
    }
}
