package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class q0 implements e1 {

    /* renamed from: a  reason: collision with root package name */
    public String f40775a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40776b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f40777c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40778d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40779e;

    /* renamed from: f  reason: collision with root package name */
    public Info f40780f;

    /* renamed from: g  reason: collision with root package name */
    public K f40781g;

    /* renamed from: h  reason: collision with root package name */
    public PBInterstitialListener f40782h;

    /* renamed from: i  reason: collision with root package name */
    public K0 f40783i;
    public long j;
    public Handler k = new n0(this);

    public q0(Context context, String str) {
        this.f40776b = context;
        this.f40775a = str;
    }

    public final void a(Info info) {
        boolean z = false;
        this.f40779e = false;
        this.f40780f = info;
        this.j = System.currentTimeMillis();
        if (b() && this.f40780f.getType() == 21) {
            z = true;
        }
        if (z) {
            if (a()) {
                this.f40782h.onLoaded();
                return;
            }
            K k = new K(this.f40776b);
            this.f40781g = k;
            k.f40528a = new p0(this);
            this.f40781g.a(this.f40780f.getLoad(), this.f40780f);
            this.k.sendEmptyMessageDelayed(11, this.f40780f.getWt() * 1000);
            return;
        }
        this.f40782h.onFail(PBError.PID_TYPE_ERROR);
    }

    @Override // com.win.opensdk.e1
    public void a(String str, String str2, Object obj) {
        if (TextUtils.equals(str, this.f40780f.getId() + this.f40775a)) {
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
                this.f40782h.onClicked();
            } else if (c2 == 1) {
                this.f40782h.onInterstitialDismissed();
            } else if (c2 != 2) {
            } else {
                this.f40782h.onInterstitialDisplayed();
            }
        }
    }

    public final boolean a() {
        return this.f40777c && !this.f40779e && b() && !this.f40780f.isShown() && this.f40780f.isEffective();
    }

    public final boolean b() {
        return this.f40780f != null;
    }

    public final boolean c() {
        return b() && this.f40780f.getType() == 21;
    }
}
