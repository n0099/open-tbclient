package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f37738a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f37739b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f37740c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f37738a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f37739b = i1;
        i1.f37668h = new o(this);
    }

    public void destroy() {
        I1 i1 = this.f37739b;
        i1.f37665e = false;
        i1.f37663c = false;
        i1.f37664d = false;
        K0 k0 = i1.f37669i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f37738a;
    }

    public boolean isReady() {
        I1 i1 = this.f37739b;
        if (!i1.a()) {
            if (!(i1.f37664d && !i1.f37665e && i1.b() && !i1.f37666f.isShown() && i1.f37666f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        I1 i1 = this.f37739b;
        if (i1.b() && i1.f37666f.isEffective() && !i1.f37666f.isShown()) {
            i1.a(i1.f37666f);
            return;
        }
        if (i1.f37669i == null) {
            i1.f37669i = new K0(i1.f37662b, i1.f37661a, y.Video);
        }
        i1.f37669i.f37686g = new G1(i1);
        i1.f37669i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f37740c = pBVideoListener;
    }

    public void show() {
        I1 i1 = this.f37739b;
        if (!z.d(i1.f37662b)) {
            PBVideoListener pBVideoListener = i1.f37668h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (i1.c() && i1.a() && i1.b()) {
            i1.f37663c = false;
            W1.a().a(W1.a(i1.f37666f.getTraceid(), i1.f37666f.getId(), i1.f37666f.getPid()), i1.f37667g);
            i1.f37666f.setShown(true);
            x.a().a(W1.a(i1.f37666f.getTraceid(), i1.f37666f.getId(), i1.f37661a), i1.f37666f);
            H5Activity.a(i1.f37662b, i1.f37666f, i1.f37661a);
            f1.a(i1.f37666f.getId() + i1.f37661a, i1);
        }
    }
}
