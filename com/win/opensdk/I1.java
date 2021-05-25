package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class I1 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f36835a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36836b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36838d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36839e;

    /* renamed from: f  reason: collision with root package name */
    public Info f36840f;

    /* renamed from: g  reason: collision with root package name */
    public K f36841g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f36842h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f36843i;
    public long j;
    public Handler k = new F1(this);

    public I1(Context context, String str) {
        this.f36836b = context;
        this.f36835a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f36839e = false;
        this.f36840f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f36840f.getType() == 41) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f36842h.onLoaded();
                return;
            }
            K k = new K(this.f36836b);
            this.f36841g = k;
            k.f36849a = new H1(this);
            this.f36841g.a(this.f36840f.getLoad(), this.f36840f);
            this.k.sendEmptyMessageDelayed(11, this.f36840f.getWt() * 1000);
            return;
        }
        this.f36842h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f36840f.getId() + this.f36835a)) {
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
                this.f36842h.onClicked();
            } else if (c2 == 1) {
                this.f36842h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f36842h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!z.d(this.f36836b)) {
                    pBVideoListener = this.f36842h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f36842h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f36842h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!z.d(this.f36836b) || obj == null) {
                this.f36842h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f36842h.onUserEarnedReward(false, j);
                } else {
                    this.f36842h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f36837c && !this.f36839e && b() && !this.f36840f.isShown() && this.f36840f.isEffective();
    }

    public final boolean b() {
        return this.f36840f != null;
    }

    public final boolean c() {
        return b() && this.f36840f.getType() == 41;
    }
}
