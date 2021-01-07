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
    private static Context f13262a;
    private static com.ss.android.a.a.a.l pWA;
    private static com.ss.android.a.a.c.a pWB;
    private static com.ss.android.a.a.a.f pWk;
    private static com.ss.android.a.a.a.c pWl;
    private static com.ss.android.a.a.a.k pWm;
    private static com.ss.android.a.a.a.g pWn;
    private static com.ss.android.a.a.a.h pWo;
    private static com.ss.android.a.a.a.i pWp;
    private static com.ss.android.a.a.d.a pWq;
    private static com.ss.android.a.a.a.b pWr;
    private static com.ss.android.socialbase.appdownloader.c.h pWs;
    private static com.ss.android.a.a.a.d pWt;
    private static com.ss.android.a.a.a.e pWu;
    private static o pWv;
    private static com.ss.android.a.a.a.j pWw;
    private static r pWx;
    private static n pWy;
    private static m pWz;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f13262a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f13262a == null && context != null && context.getApplicationContext() != null) {
            f13262a = context.getApplicationContext();
        }
    }

    public static Context a() {
        if (f13262a == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return f13262a;
    }

    public static void b(@NonNull com.ss.android.a.a.a.f fVar) {
        pWk = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        pWm = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        pWn = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        pWo = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        pWp = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eGM().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        pWq = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        pWr = bVar;
    }

    public static com.ss.android.a.a.a.f eGd() {
        return pWk;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eGe() {
        if (pWl == null) {
            pWl = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return pWl;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eGf() {
        if (pWm == null) {
            pWm = new com.ss.android.downloadlib.c.a();
        }
        return pWm;
    }

    public static com.ss.android.a.a.a.g eGg() {
        return pWn;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eGh() {
        if (pWo == null) {
            pWo = new com.ss.android.downloadlib.c.b();
        }
        return pWo;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eGi() {
        if (pWs == null) {
            pWs = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return pWs;
    }

    public static o eGj() {
        return pWv;
    }

    @NonNull
    public static JSONObject i() {
        if (pWp == null) {
            pWp = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.M(pWp.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eGk() {
        if (pWq == null) {
            pWq = new a.C1230a().eFB();
        }
        return pWq;
    }

    public static m eGl() {
        return pWz;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eGm() {
        return pWr;
    }

    @Nullable
    public static n eGn() {
        return pWy;
    }

    public static com.ss.android.a.a.a.l eGo() {
        return pWA;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eGM().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eGp() {
        return pWt;
    }

    public static com.ss.android.a.a.a.e eGq() {
        return pWu;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eGr() {
        if (pWB == null) {
            pWB = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a pWC = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.pWC = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.pWC.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.pWC != null && this.pWC.isShowing()) {
                        this.pWC.dismiss();
                    }
                }
            };
        }
        return pWB;
    }

    public static com.ss.android.a.a.a.j eGs() {
        return pWw;
    }

    public static r eGt() {
        return pWx;
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

    public static long epL() {
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
