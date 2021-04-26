package com.win.opensdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.win.opensdk.core.Info;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONStringer;
/* loaded from: classes6.dex */
public class K0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f37680a;

    /* renamed from: b  reason: collision with root package name */
    public String f37681b;

    /* renamed from: e  reason: collision with root package name */
    public y f37684e;

    /* renamed from: f  reason: collision with root package name */
    public int f37685f;

    /* renamed from: g  reason: collision with root package name */
    public L0 f37686g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37687h;

    /* renamed from: i  reason: collision with root package name */
    public P0 f37688i;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37683d = false;
    public Handler j = new F0(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public E0 f37682c = new E0();

    public K0(Context context, String str, y yVar) {
        this.f37685f = 5;
        this.f37680a = context;
        this.f37681b = str;
        this.f37684e = yVar;
        this.f37685f = s1.q(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i2) {
        return (i2 == 100 || i2 == 101) ? PBError.SERVER_ERROR : (i2 == 406 || i2 == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (this.f37687h) {
            return;
        }
        this.f37687h = true;
        v1.f37961a.post(new H0(this, pBError));
    }

    public void b() {
        JSONStringer object;
        v1.f37961a.post(new J0(this));
        boolean z = false;
        this.f37687h = false;
        Context context = this.f37680a;
        String str = this.f37681b;
        String k = s1.k(context);
        if (!TextUtils.isEmpty(k)) {
            try {
                JSONArray jSONArray = new JSONArray(k);
                if (jSONArray.length() > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        String optString = jSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString) && optString.equals(str)) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (!z) {
            w0 a2 = x0.a(this.f37680a);
            String str2 = this.f37681b;
            try {
                object = new JSONStringer().object();
                a2.f37984b = object;
                a2.a("e", "Ld").a("pid", str2).a("timeis", x0.b());
            } catch (JSONException unused2) {
            }
            a2.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info b2 = this.f37682c.b();
        if (b2 == null) {
            if (this.f37683d) {
                a(PBError.LOAD_TOO_FREQUENTLY);
                return;
            }
            this.f37683d = true;
            P0 p0 = new P0(this.f37680a);
            p0.f37718b = this.f37681b;
            P0 a3 = p0.a(new G0(this));
            this.f37688i = a3;
            y yVar = this.f37684e;
            if (yVar == y.BANNER) {
                a3.a();
                return;
            } else if (yVar == y.INTERSTITIAL) {
                a3.b();
                return;
            } else if (yVar == y.NATIVE) {
                a3.c();
                return;
            } else if (yVar == y.Video) {
                a3.e();
                return;
            } else if (yVar == y.SPLASH) {
                a3.d();
                return;
            } else {
                return;
            }
        }
        a(b2);
    }

    public final void a(Info info) {
        if (this.f37687h) {
            return;
        }
        this.f37687h = true;
        v1.f37961a.post(new I0(this, info));
    }

    public void a() {
        try {
            if (this.f37688i != null) {
                this.f37688i.f37720d = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.f37682c != null) {
                this.f37682c.a();
            }
            if (this.f37686g != null) {
                this.f37686g = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void a(w wVar) {
        if (wVar != null) {
            try {
                List list = wVar.f37980a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f37682c.a(wVar.f37980a);
            } catch (Exception unused) {
            }
        }
    }
}
