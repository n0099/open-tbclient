package com.kascend.chushou.toolkit.c;

import android.app.Application;
import android.support.v4.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes5.dex */
public final class a implements tv.chushou.basis.d.a.b.b {
    private final String b = "CSAndroidSDK";
    private final String c = "5.5.6";
    private final HashMap<String, String> d = new HashMap<>();
    private final String e = "Android ChushouTV SDK/" + this.c + "/Tieba/1.0.2";
    public static final C0836a nup = new C0836a(null);
    private static final int[] akq = new int[3];

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
        q.m(application, "application");
        this.d.put("User-Agent", this.e);
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getAppKey() {
        return this.b;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String dKT() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String dKU() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xsecret", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String ada() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getSdkVersion() {
        return this.c;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getToken() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            return aVar.getString("token", "");
        }
        return null;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public boolean Kq(int i) {
        int length = nup.a().length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (i == nup.a()[i2]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            a(nup.a()[i2]);
            return true;
        }
        return false;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> dKV() {
        return this.d;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String dKW() {
        return "1.0.2";
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> dKX() {
        return com.kascend.cstvsdk.utils.a.nzY.a();
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getUserAgent() {
        return this.e;
    }

    private final void a(int i) {
        tv.chushou.basis.d.a.b.c cVar;
        Application e = com.kascend.chushou.d.b.e();
        if (i == 1801) {
            if (e instanceof FragmentActivity) {
                tv.chushou.basis.d.b.dWj().d(null, "1801");
            }
        } else if (i == 401) {
            if (e == null) {
                e = tv.chushou.basis.d.b.dWi();
            }
            com.kascend.chushou.d.e.b(e, (String) null);
        } else if (i != 602 || (cVar = (tv.chushou.basis.d.a.b.c) tv.chushou.basis.d.b.dWk().S(tv.chushou.basis.d.a.b.c.class)) == null) {
        } else {
            cVar.dLa();
        }
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0836a {
        private C0836a() {
        }

        public /* synthetic */ C0836a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] a() {
            return a.akq;
        }
    }

    static {
        nup.a()[0] = 401;
        nup.a()[1] = 1801;
        nup.a()[2] = 602;
    }
}
