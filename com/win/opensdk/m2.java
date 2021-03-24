package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m2 implements H1 {

    /* renamed from: a */
    public String f39974a;

    /* renamed from: b */
    public Context f39975b;

    /* renamed from: c */
    public boolean f39976c;

    /* renamed from: d */
    public boolean f39977d;

    /* renamed from: e */
    public boolean f39978e;

    /* renamed from: f */
    public Info f39979f;

    /* renamed from: g */
    public S f39980g;

    /* renamed from: h */
    public PBVideoListener f39981h;
    public n1 i;
    public long j;
    public Handler k = new i2(this);

    public m2(Context context, String str) {
        this.f39975b = context;
        this.f39974a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j2.a(java.lang.Object):void] */
    public static /* synthetic */ void a(m2 m2Var, Info info) {
        m2Var.a(info);
    }

    public final void a(Info info) {
        boolean z = false;
        this.f39978e = false;
        this.f39979f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f39979f.getType() == 41) {
            if (a()) {
                this.f39981h.onLoaded();
                return;
            }
            S s = new S(this.f39975b);
            this.f39980g = s;
            s.f39785a = new k2(this);
            this.f39980g.a(this.f39979f.getLoad(), this.f39979f);
            this.k.sendEmptyMessageDelayed(11, this.f39979f.getWt() * 1000);
            return;
        }
        if (b() && this.f39979f.getType() == 42) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f39981h.onLoaded();
                return;
            }
            E0.a().a(this.f39975b, B2.a(this.f39979f.getTraceid(), this.f39979f.getId(), this.f39979f.getPid()), K0.Video, this.f39979f.getLoad(), new l2(this));
            this.k.sendEmptyMessageDelayed(11, this.f39979f.getWt() * 1000);
            return;
        }
        this.f39981h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f39979f.getId() + this.f39974a)) {
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
                this.f39981h.onClicked();
            } else if (c2 == 1) {
                this.f39981h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f39981h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!G.g(this.f39975b)) {
                    pBVideoListener = this.f39981h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f39981h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f39981h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!G.g(this.f39975b) || obj == null) {
                this.f39981h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f39981h.onUserEarnedReward(false, j);
                } else {
                    this.f39981h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f39976c && !this.f39978e && b() && !this.f39979f.isShown() && this.f39979f.isEffective();
    }

    public final boolean b() {
        return this.f39979f != null;
    }

    public final boolean c() {
        return b() && this.f39979f.getType() == 41;
    }

    public final boolean d() {
        return b() && this.f39979f.getType() == 42;
    }

    public final boolean e() {
        return this.f39977d && !this.f39978e && b() && !this.f39979f.isShown() && this.f39979f.isEffective();
    }

    public final void f() {
        this.f39979f.setShown(true);
        E.a().a(B2.a(this.f39979f.getTraceid(), this.f39979f.getId(), this.f39974a), this.f39979f);
        H5Activity.a(this.f39975b, this.f39979f, this.f39974a);
        I1.a(this.f39979f.getId() + this.f39974a, this);
    }
}
