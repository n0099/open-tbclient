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
    public Context f39983a;

    /* renamed from: b  reason: collision with root package name */
    public String f39984b;

    /* renamed from: e  reason: collision with root package name */
    public F f39987e;

    /* renamed from: f  reason: collision with root package name */
    public int f39988f;

    /* renamed from: g  reason: collision with root package name */
    public o1 f39989g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39990h;
    public s1 i;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39986d = false;
    public Handler j = new i1(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public h1 f39985c = new h1();

    public n1(Context context, String str, F f2) {
        this.f39988f = 5;
        this.f39983a = context;
        this.f39984b = str;
        this.f39987e = f2;
        this.f39988f = V1.s(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i) {
        return (i == 100 || i == 101) ? PBError.SERVER_ERROR : (i == 406 || i == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (this.f39990h) {
            return;
        }
        this.f39990h = true;
        Y1.f39839a.post(new k1(this, pBError));
    }

    public void b() {
        Y1.f39839a.post(new m1(this));
        boolean z = false;
        this.f39990h = false;
        Context context = this.f39983a;
        String str = this.f39984b;
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
            Z0 a2 = a1.a(this.f39983a);
            String str2 = this.f39984b;
            try {
                a2.f39849b = a1.c();
                a2.a("e", "Ld").a("pid", str2).a("timeis", a1.a());
            } catch (JSONException unused2) {
            }
            a2.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info b2 = this.f39985c.b();
        if (b2 == null) {
            if (this.f39986d) {
                a(PBError.LOAD_TOO_FREQUENTLY);
                return;
            }
            this.f39986d = true;
            s1 s1Var = new s1(this.f39983a);
            s1Var.f40026b = this.f39984b;
            s1 a3 = s1Var.a(new j1(this));
            this.i = a3;
            F f2 = this.f39987e;
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
        if (this.f39990h) {
            return;
        }
        this.f39990h = true;
        Y1.f39839a.post(new l1(this, info));
    }

    public void a() {
        try {
            if (this.i != null) {
                this.i.f40028d = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.f39985c != null) {
                this.f39985c.a();
            }
            if (this.f39989g != null) {
                this.f39989g = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void a(D d2) {
        if (d2 != null) {
            try {
                List list = d2.f39652a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f39985c.a(d2.f39652a);
            } catch (Exception unused) {
            }
        }
    }
}
