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
    public Context f36854a;

    /* renamed from: b  reason: collision with root package name */
    public String f36855b;

    /* renamed from: e  reason: collision with root package name */
    public y f36858e;

    /* renamed from: f  reason: collision with root package name */
    public int f36859f;

    /* renamed from: g  reason: collision with root package name */
    public L0 f36860g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36861h;

    /* renamed from: i  reason: collision with root package name */
    public P0 f36862i;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36857d = false;
    public Handler j = new F0(this, Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public E0 f36856c = new E0();

    public K0(Context context, String str, y yVar) {
        this.f36859f = 5;
        this.f36854a = context;
        this.f36855b = str;
        this.f36858e = yVar;
        this.f36859f = s1.q(context);
    }

    public static /* synthetic */ int c() {
        return 100101;
    }

    public final PBError a(int i2) {
        return (i2 == 100 || i2 == 101) ? PBError.SERVER_ERROR : (i2 == 406 || i2 == 2003) ? PBError.PID_INVALID : PBError.UNKNOWN;
    }

    public final void a(PBError pBError) {
        if (this.f36861h) {
            return;
        }
        this.f36861h = true;
        v1.f37135a.post(new H0(this, pBError));
    }

    public void b() {
        JSONStringer object;
        v1.f37135a.post(new J0(this));
        boolean z = false;
        this.f36861h = false;
        Context context = this.f36854a;
        String str = this.f36855b;
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
            w0 a2 = x0.a(this.f36854a);
            String str2 = this.f36855b;
            try {
                object = new JSONStringer().object();
                a2.f37158b = object;
                a2.a("e", "Ld").a("pid", str2).a("timeis", x0.b());
            } catch (JSONException unused2) {
            }
            a2.a();
            a(PBError.PID_INVALID);
            return;
        }
        Info b2 = this.f36856c.b();
        if (b2 == null) {
            if (this.f36857d) {
                a(PBError.LOAD_TOO_FREQUENTLY);
                return;
            }
            this.f36857d = true;
            P0 p0 = new P0(this.f36854a);
            p0.f36892b = this.f36855b;
            P0 a3 = p0.a(new G0(this));
            this.f36862i = a3;
            y yVar = this.f36858e;
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
        if (this.f36861h) {
            return;
        }
        this.f36861h = true;
        v1.f37135a.post(new I0(this, info));
    }

    public void a() {
        try {
            if (this.f36862i != null) {
                this.f36862i.f36894d = null;
            }
            if (this.j != null) {
                this.j.removeCallbacksAndMessages(null);
            }
            if (this.f36856c != null) {
                this.f36856c.a();
            }
            if (this.f36860g != null) {
                this.f36860g = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void a(w wVar) {
        if (wVar != null) {
            try {
                List list = wVar.f37154a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                this.f36856c.a(wVar.f37154a);
            } catch (Exception unused) {
            }
        }
    }
}
