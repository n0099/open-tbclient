package com.win.opensdk;

import android.content.Context;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBVideo implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f36983a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f36984b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f36985c;

    public PBVideo(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f36983a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f36984b = i1;
        i1.f36913h = new o(this);
    }

    public void destroy() {
        I1 i1 = this.f36984b;
        i1.f36910e = false;
        i1.f36908c = false;
        i1.f36909d = false;
        K0 k0 = i1.f36914i;
        if (k0 != null) {
            k0.a();
        }
    }

    public String getPid() {
        return this.f36983a;
    }

    public boolean isReady() {
        I1 i1 = this.f36984b;
        if (!i1.a()) {
            if (!(i1.f36909d && !i1.f36910e && i1.b() && !i1.f36911f.isShown() && i1.f36911f.isEffective())) {
                return false;
            }
        }
        return true;
    }

    public void load() {
        I1 i1 = this.f36984b;
        if (i1.b() && i1.f36911f.isEffective() && !i1.f36911f.isShown()) {
            i1.a(i1.f36911f);
            return;
        }
        if (i1.f36914i == null) {
            i1.f36914i = new K0(i1.f36907b, i1.f36906a, y.Video);
        }
        i1.f36914i.f36931g = new G1(i1);
        i1.f36914i.b();
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        this.f36985c = pBVideoListener;
    }

    public void show() {
        I1 i1 = this.f36984b;
        if (!z.d(i1.f36907b)) {
            PBVideoListener pBVideoListener = i1.f36913h;
            if (pBVideoListener != null) {
                pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
            }
        } else if (i1.c() && i1.a() && i1.b()) {
            i1.f36908c = false;
            W1.a().a(W1.a(i1.f36911f.getTraceid(), i1.f36911f.getId(), i1.f36911f.getPid()), i1.f36912g);
            i1.f36911f.setShown(true);
            x.a().a(W1.a(i1.f36911f.getTraceid(), i1.f36911f.getId(), i1.f36906a), i1.f36911f);
            H5Activity.a(i1.f36907b, i1.f36911f, i1.f36906a);
            f1.a(i1.f36911f.getId() + i1.f36906a, i1);
        }
    }
}
