package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m2 implements H1 {

    /* renamed from: a */
    public String f40359a;

    /* renamed from: b */
    public Context f40360b;

    /* renamed from: c */
    public boolean f40361c;

    /* renamed from: d */
    public boolean f40362d;

    /* renamed from: e */
    public boolean f40363e;

    /* renamed from: f */
    public Info f40364f;

    /* renamed from: g */
    public S f40365g;

    /* renamed from: h */
    public PBVideoListener f40366h;
    public n1 i;
    public long j;
    public Handler k = new i2(this);

    public m2(Context context, String str) {
        this.f40360b = context;
        this.f40359a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j2.a(java.lang.Object):void] */
    public static /* synthetic */ void a(m2 m2Var, Info info) {
        m2Var.a(info);
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40363e = false;
        this.f40364f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40364f.getType() == 41) {
            if (a()) {
                this.f40366h.onLoaded();
                return;
            }
            S s = new S(this.f40360b);
            this.f40365g = s;
            s.f40170a = new k2(this);
            this.f40365g.a(this.f40364f.getLoad(), this.f40364f);
            this.k.sendEmptyMessageDelayed(11, this.f40364f.getWt() * 1000);
            return;
        }
        if (b() && this.f40364f.getType() == 42) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40366h.onLoaded();
                return;
            }
            E0.a().a(this.f40360b, B2.a(this.f40364f.getTraceid(), this.f40364f.getId(), this.f40364f.getPid()), K0.Video, this.f40364f.getLoad(), new l2(this));
            this.k.sendEmptyMessageDelayed(11, this.f40364f.getWt() * 1000);
            return;
        }
        this.f40366h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f40364f.getId() + this.f40359a)) {
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
                this.f40366h.onClicked();
            } else if (c2 == 1) {
                this.f40366h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f40366h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!G.g(this.f40360b)) {
                    pBVideoListener = this.f40366h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f40366h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f40366h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!G.g(this.f40360b) || obj == null) {
                this.f40366h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f40366h.onUserEarnedReward(false, j);
                } else {
                    this.f40366h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f40361c && !this.f40363e && b() && !this.f40364f.isShown() && this.f40364f.isEffective();
    }

    public final boolean b() {
        return this.f40364f != null;
    }

    public final boolean c() {
        return b() && this.f40364f.getType() == 41;
    }

    public final boolean d() {
        return b() && this.f40364f.getType() == 42;
    }

    public final boolean e() {
        return this.f40362d && !this.f40363e && b() && !this.f40364f.isShown() && this.f40364f.isEffective();
    }

    public final void f() {
        this.f40364f.setShown(true);
        E.a().a(B2.a(this.f40364f.getTraceid(), this.f40364f.getId(), this.f40359a), this.f40364f);
        H5Activity.a(this.f40360b, this.f40364f, this.f40359a);
        I1.a(this.f40364f.getId() + this.f40359a, this);
    }
}
