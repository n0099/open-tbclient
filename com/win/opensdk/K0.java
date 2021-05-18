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
/* loaded from: classes7.dex */
public class K0 {

    /* renamed from: a  reason: collision with root package name */
    public Context f36925a;

    /* renamed from: b  reason: collision with root package name */
    public String f36926b;

    /* renamed from: e  reason: collision with root package name */
    public y f36929e;

    /* renamed from: f  reason: collision with root package name */
    public int f36930f;

    /* renamed from: g  reason: collision with root package name */
    public L0 f36931g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36932h;

    /* renamed from: i  reason: collision with root package name */
    public P0 f36933i;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36928d = false;
    public Handler j = new F0(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public E0 f36927c = new E0();

    public K0(Context context, String str, y yVar) {
        this.f36930f = 5;
        this.f36925a = context;
        this.f36926b = str;
        this.f36929e = yVar;
        this.f36930f = s1.q(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i2) {
        return (i2 == 100 || i2 == 101) ? PBError.SERVER_ERROR : (i2 == 406 || i2 == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (this.f36932h) {
            return;
        }
        this.f36932h = true;
        v1.f37206a.post(new H0(this, pBError));
    }

    public void b() {
        JSONStringer object;
        v1.f37206a.post(new J0(this));
        boolean z = false;
        this.f36932h = false;
        Context context = this.f36925a;
        String str = this.f36926b;
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
            w0 a2 = x0.a(this.f36925a);
            String str2 = this.f36926b;
            try {
                object = new JSONStringer().object();
                a2.f37229b = object;
                a2.a("e", "Ld").a("pid", str2).a("timeis", x0.b());
            } catch (JSONException unused2) {
            }
            a2.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info b2 = this.f36927c.b();
        if (b2 == null) {
            if (this.f36928d) {
                a(PBError.LOAD_TOO_FREQUENTLY);
                return;
            }
            this.f36928d = true;
            P0 p0 = new P0(this.f36925a);
            p0.f36963b = this.f36926b;
            P0 a3 = p0.a(new G0(this));
            this.f36933i = a3;
            y yVar = this.f36929e;
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
        if (this.f36932h) {
            return;
        }
        this.f36932h = true;
        v1.f37206a.post(new I0(this, info));
    }

    public void a() {
        try {
            if (this.f36933i != null) {
                this.f36933i.f36965d = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.f36927c != null) {
                this.f36927c.a();
            }
            if (this.f36931g != null) {
                this.f36931g = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void a(w wVar) {
        if (wVar != null) {
            try {
                List list = wVar.f37225a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f36927c.a(wVar.f37225a);
            } catch (Exception unused) {
            }
        }
    }
}
