package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.win.opensdk.activitys.H5Activity;
import com.win.opensdk.core.Info;
/* renamed from: com.win.opensdk.do  reason: invalid class name */
/* loaded from: classes14.dex */
public class Cdo implements ab {

    /* renamed from: a  reason: collision with root package name */
    public String f8154a;
    public Context b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long j;
    public Handler k = new db(this);
    public Info qlN;
    public bg qlO;
    public az qlP;
    public dq qlQ;

    public Cdo(Context context, String str) {
        this.b = context;
        this.f8154a = str;
    }

    @Override // com.win.opensdk.ab
    public void a(String str, String str2, Object obj) {
        long j;
        if (TextUtils.equals(str, this.qlN.getId() + this.f8154a)) {
            char c = 65535;
            switch (str2.hashCode()) {
                case -1398725913:
                    if (str2.equals("VIDEO_USER_EARNED_REWARD")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1122984843:
                    if (str2.equals("is_dismiss")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1122893139:
                    if (str2.equals("is_display")) {
                        c = 2;
                        break;
                    }
                    break;
                case -707154884:
                    if (str2.equals("VIDEO_SHOW_FAIL")) {
                        c = 4;
                        break;
                    }
                    break;
                case 109719091:
                    if (str2.equals("is_click")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.qlP.onClicked();
                    return;
                case 1:
                    this.qlP.ht();
                    return;
                case 2:
                    this.qlP.hu();
                    return;
                case 3:
                    if (!v.g(this.b) || obj == null) {
                        this.qlP.b(false, 0L);
                        return;
                    }
                    try {
                        j = ((Long) obj).longValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        j = 0;
                    }
                    if (j <= 0) {
                        this.qlP.b(false, j);
                        return;
                    } else {
                        this.qlP.b(true, j);
                        return;
                    }
                case 4:
                    if (!v.g(this.b)) {
                        this.qlP.bb(PBError.NO_NETWORK.getMsg());
                        return;
                    } else if (obj == null) {
                        this.qlP.bb(PBError.UNKNOWN.getMsg());
                        return;
                    } else {
                        this.qlP.bb((String) obj);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public final boolean a() {
        return this.c && !this.e && b() && !this.qlN.isShown() && this.qlN.isEffective();
    }

    public final boolean b() {
        return this.qlN != null;
    }

    public final boolean c() {
        return b() && this.qlN.getType() == 41;
    }

    public final void d(Info info) {
        boolean z = true;
        this.e = false;
        this.qlN = info;
        this.j = System.currentTimeMillis();
        if (b() && this.qlN.getType() == 41) {
            if (!a()) {
                this.qlO = new bg(this.b);
                this.qlO.qlb = new dh(this);
                this.qlO.a(this.qlN.getLoad(), this.qlN);
                this.k.sendEmptyMessageDelayed(11, this.qlN.getWt() * 1000);
                return;
            }
            this.qlP.onLoaded();
            return;
        }
        if (!b() || this.qlN.getType() != 42) {
            z = false;
        }
        if (z) {
            if (!e()) {
                r.eIZ().a(this.b, j.a(this.qlN.getTraceid(), this.qlN.getId(), this.qlN.getPid()), K0.Video, this.qlN.getLoad(), new dl(this));
                this.k.sendEmptyMessageDelayed(11, this.qlN.getWt() * 1000);
                return;
            }
            this.qlP.onLoaded();
            return;
        }
        this.qlP.onFail(PBError.PID_TYPE_ERROR);
    }

    public final boolean d() {
        return b() && this.qlN.getType() == 42;
    }

    public final boolean e() {
        return this.d && !this.e && b() && !this.qlN.isShown() && this.qlN.isEffective();
    }

    public final void f() {
        this.qlN.setShown(true);
        q.eIY().a(j.a(this.qlN.getTraceid(), this.qlN.getId(), this.f8154a), this.qlN);
        H5Activity.a(this.b, this.qlN, this.f8154a);
        ae.a(this.qlN.getId() + this.f8154a, this);
    }
}
