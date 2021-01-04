package com.ss.android.downloadlib.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.a.a.a.m;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.a.o;
import com.ss.android.a.a.a.r;
import com.ss.android.a.a.d.a;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Context f13261a;
    private static com.ss.android.a.a.a.f pUC;
    private static com.ss.android.a.a.a.c pUD;
    private static com.ss.android.a.a.a.k pUE;
    private static com.ss.android.a.a.a.g pUF;
    private static com.ss.android.a.a.a.h pUG;
    private static com.ss.android.a.a.a.i pUH;
    private static com.ss.android.a.a.d.a pUI;
    private static com.ss.android.a.a.a.b pUJ;
    private static com.ss.android.socialbase.appdownloader.c.h pUK;
    private static com.ss.android.a.a.a.d pUL;
    private static com.ss.android.a.a.a.e pUM;
    private static o pUN;
    private static com.ss.android.a.a.a.j pUO;
    private static r pUP;
    private static n pUQ;
    private static m pUR;
    private static com.ss.android.a.a.a.l pUS;
    private static com.ss.android.a.a.c.a pUT;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f13261a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f13261a == null && context != null && context.getApplicationContext() != null) {
            f13261a = context.getApplicationContext();
        }
    }

    public static Context a() {
        if (f13261a == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return f13261a;
    }

    public static void b(@NonNull com.ss.android.a.a.a.f fVar) {
        pUC = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        pUE = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        pUF = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        pUG = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        pUH = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eGi().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        pUI = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        pUJ = bVar;
    }

    public static com.ss.android.a.a.a.f eFz() {
        return pUC;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eFA() {
        if (pUD == null) {
            pUD = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return pUD;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eFB() {
        if (pUE == null) {
            pUE = new com.ss.android.downloadlib.c.a();
        }
        return pUE;
    }

    public static com.ss.android.a.a.a.g eFC() {
        return pUF;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eFD() {
        if (pUG == null) {
            pUG = new com.ss.android.downloadlib.c.b();
        }
        return pUG;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eFE() {
        if (pUK == null) {
            pUK = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return pUK;
    }

    public static o eFF() {
        return pUN;
    }

    @NonNull
    public static JSONObject i() {
        if (pUH == null) {
            pUH = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.M(pUH.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eFG() {
        if (pUI == null) {
            pUI = new a.C1189a().eEX();
        }
        return pUI;
    }

    public static m eFH() {
        return pUR;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eFI() {
        return pUJ;
    }

    @Nullable
    public static n eFJ() {
        return pUQ;
    }

    public static com.ss.android.a.a.a.l eFK() {
        return pUS;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eGi().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eFL() {
        return pUL;
    }

    public static com.ss.android.a.a.a.e eFM() {
        return pUM;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eFN() {
        if (pUT == null) {
            pUT = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a pUU = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.pUU = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.pUU.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.pUU != null && this.pUU.isShowing()) {
                        this.pUU.dismiss();
                    }
                }
            };
        }
        return pUT;
    }

    public static com.ss.android.a.a.a.j eFO() {
        return pUO;
    }

    public static r eFP() {
        return pUP;
    }

    public static boolean u() {
        return i().optInt("is_enable_start_install_again") == 1 || v();
    }

    public static boolean v() {
        return false;
    }

    public static long w() {
        long optLong = i().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long epK() {
        long optLong = i().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static String y() {
        try {
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable th) {
            return null;
        }
    }
}
