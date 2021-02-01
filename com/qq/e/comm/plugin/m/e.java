package com.qq.e.comm.plugin.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.ala.helper.AlaConstants;
import com.baidu.mobstat.Config;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.m.i;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e implements i {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12200a;

    /* renamed from: b  reason: collision with root package name */
    protected c f12201b;
    protected com.qq.e.comm.plugin.y.c c;
    private com.qq.e.comm.plugin.ab.d.a e;
    private f f;
    private i.a g;
    private AtomicBoolean h;
    private a i;
    private MediaView j;
    private com.qq.e.comm.plugin.aa.b.f k;
    private com.qq.e.comm.plugin.gdtnativead.a.c l;
    private String m;
    private Handler n;
    private long o;
    protected boolean d = true;
    private com.qq.e.comm.plugin.ab.f.a.b p = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.1
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "getAdInfo";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adInfo", e.this.d());
                jSONObject.put("adSize", e.this.f());
                jSONObject.put("setting", e.this.e());
                jSONObject.put("cfg", e.this.f12201b.Z().a());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", 0);
                jSONObject2.put("data", jSONObject);
                ai.a(e.this.m, "getAdInfoActionHandler result: " + jSONObject2);
                eVar.a(str3, 0, jSONObject2.toString(), 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e.this.a(System.currentTimeMillis() - e.this.o);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b q = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.3
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "renderDidFinish";
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0159  */
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            boolean z;
            JSONObject optJSONObject;
            e.this.n.removeCallbacks(e.this.x);
            boolean z2 = false;
            try {
                ai.a(e.this.m, "renderDidFinishActionHandler param: " + str2);
                JSONObject jSONObject = new JSONObject(str2);
                z2 = jSONObject.optBoolean("isRenderSuc", false);
                if (z2) {
                    try {
                        if (e.this.f12201b.ah() && e.this.j != null && (optJSONObject = jSONObject.optJSONObject(AlaConstants.STAT_VIDEO_INFO)) != null) {
                            float a2 = ak.a(e.this.f12200a, (float) optJSONObject.optDouble(Config.EVENT_HEAT_X, 0.0d));
                            float a3 = ak.a(e.this.f12200a, (float) optJSONObject.optDouble("y", 0.0d));
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Math.round(ak.a(e.this.f12200a, (float) optJSONObject.optDouble("width", 0.0d))), Math.round(ak.a(e.this.f12200a, (float) optJSONObject.optDouble("height", 0.0d))));
                            layoutParams.leftMargin = Math.round(a2);
                            layoutParams.topMargin = Math.round(a3);
                            e.this.j.setLayoutParams(layoutParams);
                        }
                        JSONObject optJSONObject2 = jSONObject.optJSONObject("adSize");
                        if (optJSONObject2 != null) {
                            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(Math.round(ak.a(e.this.f12200a, (float) optJSONObject2.optDouble("width", 0.0d)) + 0.5f), Math.round(ak.a(e.this.f12200a, (float) optJSONObject2.optDouble("height", 0.0d)) + 0.5f));
                            layoutParams2.gravity = 17;
                            e.this.i.setLayoutParams(layoutParams2);
                        } else {
                            z2 = false;
                        }
                    } catch (JSONException e) {
                        e = e;
                        e.printStackTrace();
                        if (z2) {
                        }
                        if (z) {
                        }
                        e.this.f.a(z);
                        e.this.b(System.currentTimeMillis() - e.this.o);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            z = (z2 || e.this.h.get()) ? false : true;
            if (z) {
                e.this.a(103);
            } else if (e.this.g != null) {
                e.this.g.a(e.this.f);
            }
            e.this.f.a(z);
            e.this.b(System.currentTimeMillis() - e.this.o);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b r = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.4
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "getVideoState";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b s = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.5
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "changeVideoState";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b t = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.6
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "changeVideoMute";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b u = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.7
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "clickAdEvent";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b v = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.8
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "clickCloseEvent";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private com.qq.e.comm.plugin.ab.f.a.b w = new com.qq.e.comm.plugin.ab.f.a.b() { // from class: com.qq.e.comm.plugin.m.e.9
        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public String a() {
            return "clickLogoEvent";
        }

        @Override // com.qq.e.comm.plugin.ab.f.a.b
        public void a(com.qq.e.comm.plugin.ab.f.e eVar, String str, String str2, String str3) {
            e.this.f.a(eVar, str, str2, str3);
        }
    };
    private Runnable x = new Runnable() { // from class: com.qq.e.comm.plugin.m.e.10
        @Override // java.lang.Runnable
        public void run() {
            e.this.h.set(true);
            e.this.a(102);
            ai.a(e.this.m, "RenderOverTime");
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, c cVar, VideoOption2 videoOption2, i.a aVar, com.qq.e.comm.plugin.y.c cVar2) {
        this.f12200a = context;
        this.f12201b = cVar;
        this.g = aVar;
        this.m = e.class.getSimpleName() + this.f12201b.m();
        this.i = new a(this.f12200a);
        a();
        g();
        this.f = new f(this.f12200a, this.i, this.j, this.k, this.l, this.e, this.f12201b.m(), videoOption2);
        this.c = cVar2;
        this.n = new Handler(Looper.getMainLooper());
        this.h = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.g != null) {
            this.g.a(i);
        }
        this.n.post(new Runnable() { // from class: com.qq.e.comm.plugin.m.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.f.x();
            }
        });
    }

    private void g() {
        this.e = new com.qq.e.comm.plugin.ab.d.e(this.f12200a, null, true).a();
        a(this.e.c());
        View b2 = this.e.b();
        b2.setBackgroundColor(0);
        this.e.a(false);
        this.i.addView(b2, -1, -1);
    }

    private boolean h() {
        return this.f12201b.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (this.f12201b.ah()) {
            this.j = new MediaView(this.f12200a);
            this.k = new com.qq.e.comm.plugin.aa.b.f(this.f12200a);
            this.l = new com.qq.e.comm.plugin.gdtnativead.a.c(this.f12200a, 1, this.f12201b.o(), this.d, false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.j.addView(this.k, layoutParams);
            this.j.addView(this.l, layoutParams);
            this.l.b();
            this.i.addView(this.j);
        }
    }

    protected void a(long j) {
        h.a(j, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.qq.e.comm.plugin.ab.f.e eVar) {
        eVar.a(this.p).a(this.q).a(this.r).a(this.s).a(this.t).a(this.u).a(this.v).a(this.w).a(new com.qq.e.comm.plugin.m.a.a()).a(new com.qq.e.comm.plugin.m.a.b()).a(new com.qq.e.comm.plugin.m.a.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.n.removeCallbacks(this.x);
        this.h.set(false);
        this.n.postDelayed(this.x, GDTADManager.getInstance().getSM().getInteger("EXPRESS2_RENDER_TIMEOUT", 5000));
        this.e.a(str);
        this.o = System.currentTimeMillis();
    }

    @Override // com.qq.e.comm.plugin.m.i
    public void b() {
        a(com.qq.e.comm.plugin.z.c.a().c());
    }

    protected void b(long j) {
        h.b(j, this.c);
    }

    @Override // com.qq.e.comm.plugin.m.i
    public void c() {
        this.f.x();
        this.n.removeCallbacks(this.x);
    }

    protected JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.f12201b.E().toString());
        jSONObject.put("tpl_info", this.f12201b.m_());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        VideoOption2 f = this.f12201b.f();
        if (f != null) {
            jSONObject.put("autoPlayOnWWAN", f.getAutoPlayPolicy() != null && f.getAutoPlayPolicy().getPolicy() == VideoOption2.AutoPlayPolicy.ALWAYS.getPolicy());
            jSONObject.put("videoMuted", f.isAutoPlayMuted());
            if (this.f12201b.v()) {
                jSONObject.put("apkStatus", com.qq.e.comm.plugin.a.l.a().a(this.f12201b.z().d()));
            }
        }
        return jSONObject;
    }

    protected JSONObject f() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", this.f12201b.c());
        jSONObject.put("height", this.f12201b.d());
        jSONObject.put("isLandscape", h());
        return jSONObject;
    }
}
