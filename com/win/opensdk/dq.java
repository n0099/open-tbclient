package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class dq {

    /* renamed from: a  reason: collision with root package name */
    public Context f8157a;
    public String b;
    public F e;
    public int f;
    public boolean h;
    public du qlS;
    public eh qlT;
    public boolean d = false;
    public Handler j = new da(this, Looper.getMainLooper());
    public cx qlR = new cx();

    public dq(Context context, String str, F f) {
        this.f = 5;
        this.f8157a = context;
        this.b = str;
        this.e = f;
        this.f = bp.iO(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError Si(int i) {
        return (i == 100 || i == 101) ? PBError.SERVER_ERROR : (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (!this.h) {
            this.h = true;
            bv.f8133a.post(new dg(this, pBError));
        }
    }

    public void b() {
        boolean z = false;
        bv.f8133a.post(new dn(this));
        this.h = false;
        Context context = this.f8157a;
        String str = this.b;
        String k = bp.k(context);
        if (!TextUtils.isEmpty(k)) {
            try {
                JSONArray jSONArray = new JSONArray(k);
                if (jSONArray.length() > 0) {
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        String optString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                }
            } catch (Exception e) {
            }
        }
        if (!z) {
            bx iT = ca.iT(this.f8157a);
            String str2 = this.b;
            try {
                iT.qlo = ca.eJe();
                iT.hD("e", "Ld").hD("pid", str2).hD("timeis", ca.a());
            } catch (JSONException e2) {
            }
            iT.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info eJj = this.qlR.eJj();
        if (eJj == null) {
            if (!this.d) {
                this.d = true;
                eh ehVar = new eh(this.f8157a);
                ehVar.b = this.b;
                this.qlT = ehVar.a(new dd(this));
                F f = this.e;
                if (f == F.BANNER) {
                    this.qlT.a();
                    return;
                } else if (f == F.INTERSTITIAL) {
                    this.qlT.b();
                    return;
                } else if (f == F.NATIVE) {
                    this.qlT.c();
                    return;
                } else if (f == F.Video) {
                    this.qlT.e();
                    return;
                } else if (f == F.SPLASH) {
                    this.qlT.d();
                    return;
                } else {
                    return;
                }
            }
            a(PBError.LOAD_TOO_FREQUENTLY);
            return;
        }
        d(eJj);
    }

    public final void d(Info info) {
        if (!this.h) {
            this.h = true;
            bv.f8133a.post(new dk(this, info));
        }
    }

    public void a() {
        try {
            if (this.qlT != null) {
                this.qlT.qmi = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.qlR != null) {
                this.qlR.a();
            }
            if (this.qlS != null) {
                this.qlS = null;
            }
        } catch (Exception e) {
        }
    }

    public final void a(n nVar) {
        if (nVar != null) {
            try {
                List list = nVar.f8169a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.qlR.a(nVar.f8169a);
            } catch (Exception e) {
            }
        }
    }
}
