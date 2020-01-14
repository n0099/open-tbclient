package com.kascend.chushou.toolkit.c;

import android.app.Application;
import android.support.v4.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
/* loaded from: classes4.dex */
public final class a implements tv.chushou.basis.d.a.b.b {
    private final String b = "CSAndroidSDK";
    private final String c = "5.5.6";
    private final HashMap<String, String> d = new HashMap<>();
    private final String e = "Android ChushouTV SDK/" + this.c;
    public static final C0703a ndW = new C0703a(null);
    private static final int[] f = new int[3];

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
        q.j(application, "application");
        this.d.put("User-Agent", this.e);
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getAppKey() {
        return this.b;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String dCX() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String dCY() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xsecret", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String OM() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getSdkVersion() {
        return this.c;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getToken() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            return aVar.getString("token", "");
        }
        return null;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public boolean MT(int i) {
        int length = ndW.a().length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (i == ndW.a()[i2]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            a(ndW.a()[i2]);
            return true;
        }
        return false;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> dCZ() {
        return this.d;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> dDa() {
        return com.kascend.cstvsdk.utils.a.njI.a();
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
                tv.chushou.basis.d.b.dOF().d(null, "1801");
            }
        } else if (i == 401) {
            if (e == null) {
                e = tv.chushou.basis.d.b.dOE();
            }
            com.kascend.chushou.d.e.b(e, (String) null);
        } else if (i != 602 || (cVar = (tv.chushou.basis.d.a.b.c) tv.chushou.basis.d.b.dOG().T(tv.chushou.basis.d.a.b.c.class)) == null) {
        } else {
            cVar.dDd();
        }
    }

    /* renamed from: com.kascend.chushou.toolkit.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0703a {
        private C0703a() {
        }

        public /* synthetic */ C0703a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] a() {
            return a.f;
        }
    }

    static {
        ndW.a()[0] = 401;
        ndW.a()[1] = 1801;
        ndW.a()[2] = 602;
    }
}
