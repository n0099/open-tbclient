package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f36912a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f36913b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f36914c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f36912a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f36913b = i1;
        i1.f36842h = new o(this);
    }

    public void destroy() {
        I1 i1 = this.f36913b;
        i1.f36839e = false;
        i1.f36837c = false;
        i1.f36838d = false;
        K0 k0 = i1.f36843i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f36912a;
    }

    public boolean isReady() {
        I1 i1 = this.f36913b;
        if (!i1.a()) {
            if (!(i1.f36838d && !i1.f36839e && i1.b() && !i1.f36840f.isShown() && i1.f36840f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        I1 i1 = this.f36913b;
        if (i1.b() && i1.f36840f.isEffective() && !i1.f36840f.isShown()) {
            i1.a(i1.f36840f);
            return;
        }
        if (i1.f36843i == null) {
            i1.f36843i = new K0(i1.f36836b, i1.f36835a, y.Video);
        }
        i1.f36843i.f36860g = new G1(i1);
        i1.f36843i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f36914c = pBVideoListener;
    }

    public void show() {
        I1 i1 = this.f36913b;
        if (!z.d(i1.f36836b)) {
            PBVideoListener pBVideoListener = i1.f36842h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (i1.c() && i1.a() && i1.b()) {
            i1.f36837c = false;
            W1.a().a(W1.a(i1.f36840f.getTraceid(), i1.f36840f.getId(), i1.f36840f.getPid()), i1.f36841g);
            i1.f36840f.setShown(true);
            x.a().a(W1.a(i1.f36840f.getTraceid(), i1.f36840f.getId(), i1.f36835a), i1.f36840f);
            H5Activity.a(i1.f36836b, i1.f36840f, i1.f36835a);
            f1.a(i1.f36840f.getId() + i1.f36835a, i1);
        }
    }
}
