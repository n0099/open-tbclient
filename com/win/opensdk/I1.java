package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class I1 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f40617a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40618b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40619c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40620d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40621e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40622f;

    /* renamed from: g  reason: collision with root package name */
    public K f40623g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f40624h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f40625i;
    public long j;
    public Handler k = new F1(this);

    public I1(Context context, String str) {
        this.f40618b = context;
        this.f40617a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40621e = false;
        this.f40622f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40622f.getType() == 41) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f40624h.onLoaded();
                return;
            }
            K k = new K(this.f40618b);
            this.f40623g = k;
            k.f40631a = new H1(this);
            this.f40623g.a(this.f40622f.getLoad(), this.f40622f);
            this.k.sendEmptyMessageDelayed(11, this.f40622f.getWt() * 1000);
            return;
        }
        this.f40624h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f40622f.getId() + this.f40617a)) {
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
                this.f40624h.onClicked();
            } else if (c2 == 1) {
                this.f40624h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f40624h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!z.e(this.f40618b)) {
                    pBVideoListener = this.f40624h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f40624h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f40624h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!z.e(this.f40618b) || obj == null) {
                this.f40624h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f40624h.onUserEarnedReward(false, j);
                } else {
                    this.f40624h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f40619c && !this.f40621e && b() && !this.f40622f.isShown() && this.f40622f.isEffective();
    }

    public final boolean b() {
        return this.f40622f != null;
    }

    public final boolean c() {
        return b() && this.f40622f.getType() == 41;
    }
}
