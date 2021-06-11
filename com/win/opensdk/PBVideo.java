package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f40591a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f40592b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f40593c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f40591a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f40592b = i1;
        i1.f40521h = new o(this);
    }

    public void destroy() {
        I1 i1 = this.f40592b;
        i1.f40518e = false;
        i1.f40516c = false;
        i1.f40517d = false;
        K0 k0 = i1.f40522i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f40591a;
    }

    public boolean isReady() {
        I1 i1 = this.f40592b;
        if (!i1.a()) {
            if (!(i1.f40517d && !i1.f40518e && i1.b() && !i1.f40519f.isShown() && i1.f40519f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        I1 i1 = this.f40592b;
        if (i1.b() && i1.f40519f.isEffective() && !i1.f40519f.isShown()) {
            i1.a(i1.f40519f);
            return;
        }
        if (i1.f40522i == null) {
            i1.f40522i = new K0(i1.f40515b, i1.f40514a, y.Video);
        }
        i1.f40522i.f40539g = new G1(i1);
        i1.f40522i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f40593c = pBVideoListener;
    }

    public void show() {
        I1 i1 = this.f40592b;
        if (!z.e(i1.f40515b)) {
            PBVideoListener pBVideoListener = i1.f40521h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (i1.c() && i1.a() && i1.b()) {
            i1.f40516c = false;
            W1.a().a(W1.a(i1.f40519f.getTraceid(), i1.f40519f.getId(), i1.f40519f.getPid()), i1.f40520g);
            i1.f40519f.setShown(true);
            x.a().a(W1.a(i1.f40519f.getTraceid(), i1.f40519f.getId(), i1.f40514a), i1.f40519f);
            H5Activity.a(i1.f40515b, i1.f40519f, i1.f40514a);
            f1.a(i1.f40519f.getId() + i1.f40514a, i1);
        }
    }
}
