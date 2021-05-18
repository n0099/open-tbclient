package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class I1 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f36906a;

    /* renamed from: b  reason: collision with root package name */
    public Context f36907b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36908c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36909d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36910e;

    /* renamed from: f  reason: collision with root package name */
    public Info f36911f;

    /* renamed from: g  reason: collision with root package name */
    public K f36912g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f36913h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f36914i;
    public long j;
    public Handler k = new F1(this);

    public I1(Context context, String str) {
        this.f36907b = context;
        this.f36906a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f36910e = false;
        this.f36911f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f36911f.getType() == 41) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f36913h.onLoaded();
                return;
            }
            K k = new K(this.f36907b);
            this.f36912g = k;
            k.f36920a = new H1(this);
            this.f36912g.a(this.f36911f.getLoad(), this.f36911f);
            this.k.sendEmptyMessageDelayed(11, this.f36911f.getWt() * 1000);
            return;
        }
        this.f36913h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f36911f.getId() + this.f36906a)) {
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
                this.f36913h.onClicked();
            } else if (c2 == 1) {
                this.f36913h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f36913h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!z.d(this.f36907b)) {
                    pBVideoListener = this.f36913h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f36913h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f36913h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!z.d(this.f36907b) || obj == null) {
                this.f36913h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f36913h.onUserEarnedReward(false, j);
                } else {
                    this.f36913h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f36908c && !this.f36910e && b() && !this.f36911f.isShown() && this.f36911f.isEffective();
    }

    public final boolean b() {
        return this.f36911f != null;
    }

    public final boolean c() {
        return b() && this.f36911f.getType() == 41;
    }
}
