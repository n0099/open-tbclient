package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40694a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f40695b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f40696c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40694a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f40695b = i1;
        i1.f40624h = new o(this);
    }

    public void destroy() {
        I1 i1 = this.f40695b;
        i1.f40621e = false;
        i1.f40619c = false;
        i1.f40620d = false;
        K0 k0 = i1.f40625i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f40694a;
    }

    public boolean isReady() {
        I1 i1 = this.f40695b;
        if (!i1.a()) {
            if (!(i1.f40620d && !i1.f40621e && i1.b() && !i1.f40622f.isShown() && i1.f40622f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        I1 i1 = this.f40695b;
        if (i1.b() && i1.f40622f.isEffective() && !i1.f40622f.isShown()) {
            i1.a(i1.f40622f);
            return;
        }
        if (i1.f40625i == null) {
            i1.f40625i = new K0(i1.f40618b, i1.f40617a, y.Video);
        }
        i1.f40625i.f40642g = new G1(i1);
        i1.f40625i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f40696c = pBVideoListener;
    }

    public void show() {
        I1 i1 = this.f40695b;
        if (!z.e(i1.f40618b)) {
            PBVideoListener pBVideoListener = i1.f40624h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (i1.c() && i1.a() && i1.b()) {
            i1.f40619c = false;
            W1.a().a(W1.a(i1.f40622f.getTraceid(), i1.f40622f.getId(), i1.f40622f.getPid()), i1.f40623g);
            i1.f40622f.setShown(true);
            x.a().a(W1.a(i1.f40622f.getTraceid(), i1.f40622f.getId(), i1.f40617a), i1.f40622f);
            H5Activity.a(i1.f40618b, i1.f40622f, i1.f40617a);
            f1.a(i1.f40622f.getId() + i1.f40617a, i1);
        }
    }
}
