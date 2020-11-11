package com.kascend.chushou.toolkit.c;

import android.app.Application;
import android.support.v4.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes6.dex */
public final class a implements tv.chushou.basis.d.a.b.b {
    private final String b = "CSAndroidSDK";
    private final String c = "5.5.6";
    private final HashMap<String, String> d = new HashMap<>();
    private final String e = "Android ChushouTV SDK/" + this.c + "/Tieba/1.0.2";
    public static final C1009a pxg = new C1009a(null);
    private static final int[] amu = new int[3];

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
        q.n(application, "application");
        this.d.put("User-Agent", this.e);
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getAppKey() {
        return this.b;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String evY() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String evZ() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xsecret", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String asG() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getSdkVersion() {
        return this.c;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getToken() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            return aVar.getString("token", "");
        }
        return null;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public boolean QL(int i) {
        int length = pxg.a().length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (i == pxg.a()[i2]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            a(pxg.a()[i2]);
            return true;
        }
        return false;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> ewa() {
        return this.d;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String ewb() {
        return "1.0.2";
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> ewc() {
        return com.kascend.cstvsdk.utils.a.pCO.a();
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getUserAgent() {
        return this.e;
    }

    private final void a(int i) {
        tv.chushou.basis.d.a.b.c cVar;
        Application etU = com.kascend.chushou.d.b.etU();
        if (i == 1801) {
            if (etU instanceof FragmentActivity) {
                tv.chushou.basis.d.b.eHp().d(null, "1801");
            }
        } else if (i == 401) {
            if (etU == null) {
                etU = tv.chushou.basis.d.b.eHo();
            }
            com.kascend.chushou.d.e.b(etU, (String) null);
        } else if (i != 602 || (cVar = (tv.chushou.basis.d.a.b.c) tv.chushou.basis.d.b.eHq().S(tv.chushou.basis.d.a.b.c.class)) == null) {
        } else {
            cVar.ewf();
        }
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1009a {
        private C1009a() {
        }

        public /* synthetic */ C1009a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] a() {
            return a.amu;
        }
    }

    static {
        pxg.a()[0] = 401;
        pxg.a()[1] = 1801;
        pxg.a()[2] = 602;
    }
}
