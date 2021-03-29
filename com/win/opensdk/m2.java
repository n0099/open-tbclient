package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m2 implements H1 {

    /* renamed from: a */
    public String f39975a;

    /* renamed from: b */
    public Context f39976b;

    /* renamed from: c */
    public boolean f39977c;

    /* renamed from: d */
    public boolean f39978d;

    /* renamed from: e */
    public boolean f39979e;

    /* renamed from: f */
    public Info f39980f;

    /* renamed from: g */
    public S f39981g;

    /* renamed from: h */
    public PBVideoListener f39982h;
    public n1 i;
    public long j;
    public Handler k = new i2(this);

    public m2(Context context, String str) {
        this.f39976b = context;
        this.f39975a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j2.a(java.lang.Object):void] */
    public static /* synthetic */ void a(m2 m2Var, Info info) {
        m2Var.a(info);
    }

    public final void a(Info info) {
        boolean z = false;
        this.f39979e = false;
        this.f39980f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f39980f.getType() == 41) {
            if (a()) {
                this.f39982h.onLoaded();
                return;
            }
            S s = new S(this.f39976b);
            this.f39981g = s;
            s.f39786a = new k2(this);
            this.f39981g.a(this.f39980f.getLoad(), this.f39980f);
            this.k.sendEmptyMessageDelayed(11, this.f39980f.getWt() * 1000);
            return;
        }
        if (b() && this.f39980f.getType() == 42) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f39982h.onLoaded();
                return;
            }
            E0.a().a(this.f39976b, B2.a(this.f39980f.getTraceid(), this.f39980f.getId(), this.f39980f.getPid()), K0.Video, this.f39980f.getLoad(), new l2(this));
            this.k.sendEmptyMessageDelayed(11, this.f39980f.getWt() * 1000);
            return;
        }
        this.f39982h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f39980f.getId() + this.f39975a)) {
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1398725913:
                    if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1122984843:
                    if (str2.equals("is_dismiss")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1122893139:
                    if (str2.equals("is_display")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -707154884:
                    if (str2.equals("VIDEO_SHOW_FAIL")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 109719091:
                    if (str2.equals("is_click")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                this.f39982h.onClicked();
            } else if (c2 == 1) {
                this.f39982h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f39982h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!G.g(this.f39976b)) {
                    pBVideoListener = this.f39982h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f39982h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f39982h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!G.g(this.f39976b) || obj == null) {
                this.f39982h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f39982h.onUserEarnedReward(false, j);
                } else {
                    this.f39982h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f39977c && !this.f39979e && b() && !this.f39980f.isShown() && this.f39980f.isEffective();
    }

    public final boolean b() {
        return this.f39980f != null;
    }

    public final boolean c() {
        return b() && this.f39980f.getType() == 41;
    }

    public final boolean d() {
        return b() && this.f39980f.getType() == 42;
    }

    public final boolean e() {
        return this.f39978d && !this.f39979e && b() && !this.f39980f.isShown() && this.f39980f.isEffective();
    }

    public final void f() {
        this.f39980f.setShown(true);
        E.a().a(B2.a(this.f39980f.getTraceid(), this.f39980f.getId(), this.f39975a), this.f39980f);
        H5Activity.a(this.f39976b, this.f39980f, this.f39975a);
        I1.a(this.f39980f.getId() + this.f39975a, this);
    }
}
