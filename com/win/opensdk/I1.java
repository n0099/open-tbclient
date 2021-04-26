package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class I1 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f37661a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37662b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37663c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37664d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37665e;

    /* renamed from: f  reason: collision with root package name */
    public Info f37666f;

    /* renamed from: g  reason: collision with root package name */
    public K f37667g;

    /* renamed from: h  reason: collision with root package name */
    public PBVideoListener f37668h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f37669i;
    public long j;
    public Handler k = new F1(this);

    public I1(Context context, String str) {
        this.f37662b = context;
        this.f37661a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f37665e = false;
        this.f37666f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f37666f.getType() == 41) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f37668h.onLoaded();
                return;
            }
            K k = new K(this.f37662b);
            this.f37667g = k;
            k.f37675a = new H1(this);
            this.f37667g.a(this.f37666f.getLoad(), this.f37666f);
            this.k.sendEmptyMessageDelayed(11, this.f37666f.getWt() * 1000);
            return;
        }
        this.f37668h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        long j;
        PBVideoListener pBVideoListener;
        PBError pBError;
        if (TextUtils.equals(str, this.f37666f.getId() + this.f37661a)) {
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
                this.f37668h.onClicked();
            } else if (c2 == 1) {
                this.f37668h.onRewardedAdClosed();
            } else if (c2 == 2) {
                this.f37668h.onRewardedAdOpened();
            } else if (c2 != 3) {
                if (c2 != 4) {
                    return;
                }
                if (!z.d(this.f37662b)) {
                    pBVideoListener = this.f37668h;
                    pBError = PBError.NO_NETWORK;
                } else if (obj != null) {
                    this.f37668h.onRewardedShowFail((String) obj);
                    return;
                } else {
                    pBVideoListener = this.f37668h;
                    pBError = PBError.UNKNOWN;
                }
                pBVideoListener.onRewardedShowFail(pBError.getMsg());
            } else if (!z.d(this.f37662b) || obj == null) {
                this.f37668h.onUserEarnedReward(false, 0L);
            } else {
                try {
                    j = ((Long) obj).longValue();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j = 0;
                }
                if (j <= 0) {
                    this.f37668h.onUserEarnedReward(false, j);
                } else {
                    this.f37668h.onUserEarnedReward(true, j);
                }
            }
        }
    }

    public final boolean a() {
        return this.f37663c && !this.f37665e && b() && !this.f37666f.isShown() && this.f37666f.isEffective();
    }

    public final boolean b() {
        return this.f37666f != null;
    }

    public final boolean c() {
        return b() && this.f37666f.getType() == 41;
    }
}
