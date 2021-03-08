package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.Orange;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {
    private Context b;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private b qmy;
    private static int c = -1;

    /* renamed from: a  reason: collision with root package name */
    public static String f8593a = "KWE_NS";

    private a() {
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a(c cVar) {
        this();
    }

    private void a(Context context) {
        try {
            com.yxcorp.kuaishou.addfp.a.a.b.eJl().a(context, new d(this, context));
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        try {
            boolean a2 = new com.yxcorp.kuaishou.addfp.android.a.e(this.b).a();
            a(this.b);
            a(a2);
            this.f = com.yxcorp.kuaishou.addfp.android.a.a.eJr().c(this.b, this.g, TextUtils.isEmpty(this.e));
            if (bVar != null) {
                if (TextUtils.isEmpty(this.e) && TextUtils.isEmpty(this.f)) {
                    bVar.a(-2, "need check");
                    return;
                }
                try {
                    bVar.a(this.e, this.f);
                } catch (Throwable th) {
                }
            }
        } catch (Throwable th2) {
            if (bVar != null) {
                try {
                    bVar.a(-1, com.yxcorp.kuaishou.addfp.android.b.e.a(th2));
                } catch (Throwable th3) {
                    com.yxcorp.kuaishou.addfp.android.b.b.a(th2);
                }
            }
        }
    }

    private void a(boolean z) {
        String str;
        LinkedHashMap aca;
        try {
            Pair a2 = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).a();
            if (a2 != null && a2.second != null) {
                String str2 = (String) ((ConcurrentHashMap) a2.second).get("cache_e");
                if (!TextUtils.isEmpty(str2)) {
                    this.e = str2;
                }
            }
            if (TextUtils.isEmpty(this.e)) {
                String a3 = Build.VERSION.SDK_INT < 29 ? com.yxcorp.kuaishou.addfp.android.a.d.a(this.b, "k_w_o_d_out_dtt") : null;
                if (TextUtils.isEmpty(a3)) {
                    com.yxcorp.kuaishou.addfp.android.b.a.a();
                    if (com.yxcorp.kuaishou.addfp.android.b.e.d(this.b, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        str = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).b("Lm91a2R0ZnQ=");
                        if (TextUtils.isEmpty(a3) || !TextUtils.isEmpty(str)) {
                            aca = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).aca(a3);
                            if (aca != null || aca.size() == 0) {
                                aca = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).aca(str);
                            }
                            if (aca != null || aca.size() <= 0) {
                            }
                            String str3 = (String) aca.get(com.yxcorp.kuaishou.addfp.android.a.a.eJr().b());
                            if (TextUtils.isEmpty(str3)) {
                                return;
                            }
                            this.e = str3;
                            return;
                        }
                        return;
                    }
                }
                str = "";
                if (TextUtils.isEmpty(a3)) {
                }
                aca = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).aca(a3);
                if (aca != null) {
                }
                aca = com.yxcorp.kuaishou.addfp.android.a.c.iZ(this.b).aca(str);
                if (aca != null) {
                }
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public static String b(Context context, String str) {
        return Orange.eJq().a(context, str.getBytes(), 20);
    }

    public static final a eJk() {
        return e.eJk();
    }

    public void a(Context context, boolean z, b bVar) {
        try {
            this.qmy = bVar;
            this.b = context;
            this.g = z;
            Thread thread = new Thread(new c(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String a2 = com.yxcorp.kuaishou.addfp.android.b.e.a(th);
            if (bVar != null) {
                bVar.a(-1, a2);
            }
        }
    }

    public boolean a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
            com.yxcorp.kuaishou.addfp.android.a.c.iZ(context).a(str, "");
            return true;
        }
        return false;
    }

    public String k(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.e)) {
            return null;
        }
        return this.e;
    }
}
