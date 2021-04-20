package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class n1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f40273a;

    /* renamed from: b  reason: collision with root package name */
    public String f40274b;

    /* renamed from: e  reason: collision with root package name */
    public F f40277e;

    /* renamed from: f  reason: collision with root package name */
    public int f40278f;

    /* renamed from: g  reason: collision with root package name */
    public o1 f40279g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40280h;
    public s1 i;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40276d = false;
    public Handler j = new i1(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public h1 f40275c = new h1();

    public n1(Context context, String str, F f2) {
        this.f40278f = 5;
        this.f40273a = context;
        this.f40274b = str;
        this.f40277e = f2;
        this.f40278f = V1.s(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i) {
        return (i == 100 || i == 101) ? PBError.SERVER_ERROR : (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (this.f40280h) {
            return;
        }
        this.f40280h = true;
        Y1.f40129a.post(new k1(this, pBError));
    }

    public void b() {
        Y1.f40129a.post(new m1(this));
        boolean z = false;
        this.f40280h = false;
        Context context = this.f40273a;
        String str = this.f40274b;
        String k = V1.k(context);
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
            } catch (Exception unused) {
            }
        }
        if (!z) {
            Z0 a2 = a1.a(this.f40273a);
            String str2 = this.f40274b;
            try {
                a2.f40139b = a1.c();
                a2.a("e", "Ld").a("pid", str2).a("timeis", a1.a());
            } catch (JSONException unused2) {
            }
            a2.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info b2 = this.f40275c.b();
        if (b2 == null) {
            if (this.f40276d) {
                a(PBError.LOAD_TOO_FREQUENTLY);
                return;
            }
            this.f40276d = true;
            s1 s1Var = new s1(this.f40273a);
            s1Var.f40316b = this.f40274b;
            s1 a3 = s1Var.a(new j1(this));
            this.i = a3;
            F f2 = this.f40277e;
            if (f2 == F.BANNER) {
                a3.a();
                return;
            } else if (f2 == F.INTERSTITIAL) {
                a3.b();
                return;
            } else if (f2 == F.NATIVE) {
                a3.c();
                return;
            } else if (f2 == F.Video) {
                a3.e();
                return;
            } else if (f2 == F.SPLASH) {
                a3.d();
                return;
            } else {
                return;
            }
        }
        a(b2);
    }

    public final void a(Info info) {
        if (this.f40280h) {
            return;
        }
        this.f40280h = true;
        Y1.f40129a.post(new l1(this, info));
    }

    public void a() {
        try {
            if (this.i != null) {
                this.i.f40318d = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.f40275c != null) {
                this.f40275c.a();
            }
            if (this.f40279g != null) {
                this.f40279g = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void a(D d2) {
        if (d2 != null) {
            try {
                List list = d2.f39942a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f40275c.a(d2.f39942a);
            } catch (Exception unused) {
            }
        }
    }
}
