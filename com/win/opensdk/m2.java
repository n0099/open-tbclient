package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class m2 implements H1 {

    /* renamed from: a */
    public String f40264a;

    /* renamed from: b */
    public Context f40265b;

    /* renamed from: c */
    public boolean f40266c;

    /* renamed from: d */
    public boolean f40267d;

    /* renamed from: e */
    public boolean f40268e;

    /* renamed from: f */
    public Info f40269f;

    /* renamed from: g */
    public S f40270g;

    /* renamed from: h */
    public PBVideoListener f40271h;
    public n1 i;
    public long j;
    public Handler k = new i2(this);

    public m2(Context context, String str) {
        this.f40265b = context;
        this.f40264a = str;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.j2.a(java.lang.Object):void] */
    public static /* synthetic */ void a(m2 m2Var, Info info) {
        m2Var.a(info);
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40268e = false;
        this.f40269f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40269f.getType() == 41) {
            if (a()) {
                this.f40271h.onLoaded();
                return;
            }
            S s = new S(this.f40265b);
            this.f40270g = s;
            s.f40075a = new k2(this);
            this.f40270g.a(this.f40269f.getLoad(), this.f40269f);
            this.k.sendEmptyMessageDelayed(11, this.f40269f.getWt() * 1000);
            return;
        }
        if (b() && this.f40269f.getType() == 42) {
            z = true;
        }
        if (z) {
            if (e()) {
                this.f40271h.onLoaded();
                return;
            }
            E0.a().a(this.f40265b, B2.a(this.f40269f.getTraceid(), this.f40269f.getId(), this.f40269f.getPid()), K0.Video, this.f40269f.getLoad(), new l2(this));
            this.k.sendEmptyMessageDelayed(11, this.f40269f.getWt() * 1000);
            return;
        }
        this.f40271h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.H1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f40269f.getId() + this.f40264a)) {
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
                this.f40271h.onClicked();
            } else if (c2 == 1) {
                this.f40271h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f40271h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!G.g(this.f40265b)) {
                    pBVideoListener = this.f40271h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f40271h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f40271h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!G.g(this.f40265b) || obj == null) {
                this.f40271h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f40271h.onUserEarnedReward(false, j);
                } else {
                    this.f40271h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f40266c && !this.f40268e && b() && !this.f40269f.isShown() && this.f40269f.isEffective();
    }

    public final boolean b() {
        return this.f40269f != null;
    }

    public final boolean c() {
        return b() && this.f40269f.getType() == 41;
    }

    public final boolean d() {
        return b() && this.f40269f.getType() == 42;
    }

    public final boolean e() {
        return this.f40267d && !this.f40268e && b() && !this.f40269f.isShown() && this.f40269f.isEffective();
    }

    public final void f() {
        this.f40269f.setShown(true);
        E.a().a(B2.a(this.f40269f.getTraceid(), this.f40269f.getId(), this.f40264a), this.f40269f);
        H5Activity.a(this.f40265b, this.f40269f, this.f40264a);
        I1.a(this.f40269f.getId() + this.f40264a, this);
    }
}
