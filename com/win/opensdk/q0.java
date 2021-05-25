package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class q0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f37096a;

    /* renamed from: b  reason: collision with root package name */
    public Context f37097b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37098c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37099d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37100e;

    /* renamed from: f  reason: collision with root package name */
    public Info f37101f;

    /* renamed from: g  reason: collision with root package name */
    public K f37102g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f37103h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f37104i;
    public long j;
    public Handler k = new n0(this);

    public q0(Context context, String str) {
        this.f37097b = context;
        this.f37096a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f37100e = false;
        this.f37101f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f37101f.getType() == 21) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f37103h.onLoaded();
                return;
            }
            K k = new K(this.f37097b);
            this.f37102g = k;
            k.f36849a = new p0(this);
            this.f37102g.a(this.f37101f.getLoad(), this.f37101f);
            this.k.sendEmptyMessageDelayed(11, this.f37101f.getWt() * 1000);
            return;
        }
        this.f37103h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f37101f.getId() + this.f37096a)) {
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != -1122984843) {
                if (hashCode != -1122893139) {
                    if (hashCode == 109719091 && str2.equals("is_click")) {
                        c2 = 0;
                    }
                } else if (str2.equals("is_display")) {
                    c2 = 2;
                }
            } else if (str2.equals("is_dismiss")) {
                c2 = 1;
            }
            if (c2 == 0) {
                this.f37103h.onClicked();
            } else if (c2 == 1) {
                this.f37103h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f37103h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f37098c && !this.f37100e && b() && !this.f37101f.isShown() && this.f37101f.isEffective();
    }

    public final boolean b() {
        return this.f37101f != null;
    }

    public final boolean c() {
        return b() && this.f37101f.getType() == 21;
    }
}
