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
    public static final C0903a nWQ = new C0903a(null);
    private static final int[] alA = new int[3];

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
    public String ear() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String eas() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xsecret", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String akP() {
        String string;
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.a.class);
        return (aVar == null || (string = aVar.getString("xappkey", "")) == null) ? "" : string;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getSdkVersion() {
        return this.c;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getToken() {
        tv.chushou.basis.d.a.a.a aVar = (tv.chushou.basis.d.a.a.a) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.a.a.class);
        if (aVar != null) {
            return aVar.getString("token", "");
        }
        return null;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public boolean No(int i) {
        int length = nWQ.a().length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (i == nWQ.a()[i2]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            a(nWQ.a()[i2]);
            return true;
        }
        return false;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> eat() {
        return this.d;
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String eau() {
        return "1.0.2";
    }

    @Override // tv.chushou.basis.d.a.b.b
    public Map<String, String> eav() {
        return com.kascend.cstvsdk.utils.a.ocC.a();
    }

    @Override // tv.chushou.basis.d.a.b.b
    public String getUserAgent() {
        return this.e;
    }

    private final void a(int i) {
        tv.chushou.basis.d.a.b.c cVar;
        Application dYn = com.kascend.chushou.d.b.dYn();
        if (i == 1801) {
            if (dYn instanceof FragmentActivity) {
                tv.chushou.basis.d.b.elK().d(null, "1801");
            }
        } else if (i == 401) {
            if (dYn == null) {
                dYn = tv.chushou.basis.d.b.elJ();
            }
            com.kascend.chushou.d.e.b(dYn, (String) null);
        } else if (i != 602 || (cVar = (tv.chushou.basis.d.a.b.c) tv.chushou.basis.d.b.elL().S(tv.chushou.basis.d.a.b.c.class)) == null) {
        } else {
            cVar.eay();
        }
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0903a {
        private C0903a() {
        }

        public /* synthetic */ C0903a(o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] a() {
            return a.alA;
        }
    }

    static {
        nWQ.a()[0] = 401;
        nWQ.a()[1] = 1801;
        nWQ.a()[2] = 602;
    }
}
