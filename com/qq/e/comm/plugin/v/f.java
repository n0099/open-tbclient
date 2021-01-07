package com.qq.e.comm.plugin.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.kwai.video.player.PlayerPostEvent;
import com.qq.e.ads.nativ.express2.NativeExpressADData2;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.plugin.m.l;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.ac;
import com.qq.e.comm.plugin.util.ar;
import com.qq.e.comm.plugin.util.z;
import com.qq.e.comm.plugin.y.u;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f extends l implements RVADI2 {
    private final int e;
    private com.qq.e.comm.plugin.rewardvideo.b f;
    private int g;
    private b h;
    private long i;
    private i j;
    private VideoOption2 k;
    private ADListener l;
    private boolean m;
    private boolean n;
    private boolean o;
    private a p;
    private final Object q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum a {
        SUCCESS,
        FAILED,
        DEFAULT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private ADListener f12919a;

        b(ADListener aDListener) {
            super(Looper.getMainLooper());
            this.f12919a = aDListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 108:
                    this.f12919a.onADEvent(new ADEvent(message.what));
                    return;
                case 107:
                    this.f12919a.onADEvent(new ADEvent(message.what, new Object[]{Integer.valueOf(message.arg1)}));
                    return;
                default:
                    return;
            }
        }
    }

    public f(Context context, String str, String str2, ADListener aDListener) {
        super(context, str, str2, null);
        this.q = new Object();
        this.f = new com.qq.e.comm.plugin.rewardvideo.b();
        this.g = 1;
        this.h = new b(aDListener);
        setVolumeOn(true);
        a(com.qq.e.comm.plugin.ad.e.REWARDVIDEOAD2);
        this.e = ac.a();
        com.qq.e.comm.plugin.v.a.a(this.e, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        Message obtain = Message.obtain(this.h, 107);
        obtain.arg1 = i;
        this.h.sendMessage(obtain);
    }

    private void f() {
        this.h.removeMessages(100);
        this.h.removeMessages(101);
        this.h.removeMessages(102);
        this.h.removeMessages(103);
        this.h.removeMessages(104);
        this.h.removeMessages(105);
        this.h.removeMessages(106);
        this.h.removeMessages(108);
        this.h.removeMessages(107);
    }

    private void g() {
        synchronized (this.q) {
            if (this.j != null) {
                this.j.destroy();
            }
            this.j = null;
        }
    }

    private boolean h() {
        int i = this.j == null ? 4014 : hasShown() ? 4015 : SystemClock.elapsedRealtime() > getExpireTimestamp() ? 5012 : c() ? 5022 : this.j.b() ? 5002 : 0;
        if (i != 0) {
            b(i);
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.m.l
    protected void a() {
        g.a(this.d);
    }

    @Override // com.qq.e.comm.plugin.m.l
    protected void a(int i) {
        g.a(i, this.d);
    }

    @Override // com.qq.e.comm.plugin.m.l
    protected void a(int i, boolean z) {
        if (z && this.f.b()) {
            loadAd(this.g);
        } else {
            b(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view) {
        if (this.j != null) {
            this.j.a(view);
        }
        this.h.sendEmptyMessage(102);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ADListener aDListener) {
        this.l = aDListener;
    }

    @Override // com.qq.e.comm.plugin.m.l
    protected void a(List<JSONObject> list) {
        if (this.m) {
            return;
        }
        Pair<Integer, List<JSONObject>> a2 = com.qq.e.comm.plugin.rewardvideo.c.a(list);
        int intValue = ((Integer) a2.first).intValue();
        if (intValue != 0) {
            b(intValue);
            return;
        }
        List list2 = (List) a2.second;
        synchronized (this.q) {
            this.p = a.DEFAULT;
            this.o = false;
            this.j = new i(this.f12523a, this.f12524b, this.c, (JSONObject) list2.get(0), this.k, this);
            if (this.j.n() == null || TextUtils.isEmpty(this.j.n().G())) {
                b(5002);
            } else {
                this.j.setAdListener(new ADListener() { // from class: com.qq.e.comm.plugin.v.f.1
                    private void a() {
                        if (f.this.o && f.this.p == a.SUCCESS) {
                            f.this.h.sendEmptyMessage(101);
                        }
                    }

                    private void a(ADEvent aDEvent) {
                        if (f.this.l != null) {
                            f.this.l.onADEvent(aDEvent);
                        }
                    }

                    @Override // com.qq.e.comm.adevent.ADListener
                    public void onADEvent(ADEvent aDEvent) {
                        switch (aDEvent.getType()) {
                            case 101:
                                f.this.h.sendEmptyMessage(105);
                                return;
                            case 102:
                                f.this.h.sendEmptyMessage(103);
                                return;
                            case 103:
                                f.this.p = a.SUCCESS;
                                a();
                                a(aDEvent);
                                return;
                            case 104:
                                f.this.p = a.FAILED;
                                a(aDEvent);
                                f.this.b(5022);
                                return;
                            case 105:
                                a(aDEvent);
                                f.this.b();
                                return;
                            case 201:
                                f.this.o = true;
                                a();
                                return;
                            case 202:
                            case PlayerPostEvent.MEDIA_INFO_UNSUPPORTED_SUBTITLE /* 901 */:
                                a(aDEvent);
                                return;
                            case 206:
                                a(aDEvent);
                                f.this.h.sendEmptyMessage(108);
                                return;
                            case 207:
                                f.this.b(5002);
                                a(aDEvent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                this.j.render();
                this.i = n.c();
                this.n = false;
                b((List<NativeExpressADData2>) null);
                JSONObject b2 = this.j.n().b();
                ArrayList arrayList = new ArrayList();
                arrayList.add(b2);
                com.qq.e.comm.plugin.z.c.a().a(this.c, arrayList, this.d);
                u.a(1220002, this.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.h.sendEmptyMessage(106);
    }

    @Override // com.qq.e.comm.plugin.m.l
    protected void b(List<NativeExpressADData2> list) {
        this.h.sendMessage(Message.obtain(this.h, 100));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.p == a.FAILED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i d() {
        return this.j;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public void destroy() {
        g();
        this.m = true;
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.h.sendEmptyMessage(104);
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public String getECPMLevel() {
        if (this.j != null) {
            return this.j.getECPMLevel();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public long getExpireTimestamp() {
        return this.i;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public int getVideoDuration() {
        if (this.j != null) {
            return this.j.n().g();
        }
        return 0;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public boolean hasShown() {
        return this.n;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public boolean isVideoCached() {
        return this.o && this.p == a.SUCCESS;
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public void loadAD() {
        g();
        this.i = 0L;
        this.f.a();
        loadAd(this.g);
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public void setVolumeOn(boolean z) {
        this.k = new VideoOption2.Builder().setAutoPlayPolicy(VideoOption2.AutoPlayPolicy.ALWAYS).setAutoPlayMuted(!z).build();
    }

    @Override // com.qq.e.comm.pi.RVADI2
    public void showAD(Activity activity) {
        z.a().a(this.c);
        if (h()) {
            this.n = true;
            Intent intent = new Intent();
            intent.putExtra("appid", GDTADManager.getInstance().getAppStatus().getAPPID());
            intent.putExtra(ACTD.DELEGATE_NAME_KEY, "rewardVideo2");
            Context context = activity;
            if (activity == null) {
                intent.addFlags(268435456);
                context = GDTADManager.getInstance().getAppContext();
            }
            if (this.j.n().h()) {
                intent.setClassName(context, ar.d());
            } else {
                intent.setClassName(context, ar.b());
            }
            intent.putExtra("objectId", this.e);
            context.startActivity(intent);
        }
    }
}
