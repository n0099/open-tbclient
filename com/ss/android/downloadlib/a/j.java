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
    private static Context f12962a;
    private static com.ss.android.a.a.a.f pRJ;
    private static com.ss.android.a.a.a.c pRK;
    private static com.ss.android.a.a.a.k pRL;
    private static com.ss.android.a.a.a.g pRM;
    private static com.ss.android.a.a.a.h pRN;
    private static com.ss.android.a.a.a.i pRO;
    private static com.ss.android.a.a.d.a pRP;
    private static com.ss.android.a.a.a.b pRQ;
    private static com.ss.android.socialbase.appdownloader.c.h pRR;
    private static com.ss.android.a.a.a.d pRS;
    private static com.ss.android.a.a.a.e pRT;
    private static o pRU;
    private static com.ss.android.a.a.a.j pRV;
    private static r pRW;
    private static n pRX;
    private static m pRY;
    private static com.ss.android.a.a.a.l pRZ;
    private static com.ss.android.a.a.c.a pSa;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f12962a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f12962a == null && context != null && context.getApplicationContext() != null) {
            f12962a = context.getApplicationContext();
        }
    }

    public static Context a() {
        if (f12962a == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return f12962a;
    }

    public static void b(@NonNull com.ss.android.a.a.a.f fVar) {
        pRJ = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        pRL = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        pRM = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        pRN = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        pRO = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eCW().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        pRP = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        pRQ = bVar;
    }

    public static com.ss.android.a.a.a.f eCm() {
        return pRJ;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eCn() {
        if (pRK == null) {
            pRK = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return pRK;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eCo() {
        if (pRL == null) {
            pRL = new com.ss.android.downloadlib.c.a();
        }
        return pRL;
    }

    public static com.ss.android.a.a.a.g eCp() {
        return pRM;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eCq() {
        if (pRN == null) {
            pRN = new com.ss.android.downloadlib.c.b();
        }
        return pRN;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eCr() {
        if (pRR == null) {
            pRR = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return pRR;
    }

    public static o eCs() {
        return pRU;
    }

    @NonNull
    public static JSONObject i() {
        if (pRO == null) {
            pRO = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.M(pRO.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eCt() {
        if (pRP == null) {
            pRP = new a.C1213a().eBK();
        }
        return pRP;
    }

    public static m eCu() {
        return pRY;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eCv() {
        return pRQ;
    }

    @Nullable
    public static n eCw() {
        return pRX;
    }

    public static com.ss.android.a.a.a.l eCx() {
        return pRZ;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eCW().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eCy() {
        return pRS;
    }

    public static com.ss.android.a.a.a.e eCz() {
        return pRT;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eCA() {
        if (pSa == null) {
            pSa = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a pSb = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.pSb = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.pSb.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.pSb != null && this.pSb.isShowing()) {
                        this.pSb.dismiss();
                    }
                }
            };
        }
        return pSa;
    }

    public static com.ss.android.a.a.a.j eCB() {
        return pRV;
    }

    public static r eCC() {
        return pRW;
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

    public static long elP() {
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
