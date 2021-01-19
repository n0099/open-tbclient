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
    private static com.ss.android.a.a.a.f pRK;
    private static com.ss.android.a.a.a.c pRL;
    private static com.ss.android.a.a.a.k pRM;
    private static com.ss.android.a.a.a.g pRN;
    private static com.ss.android.a.a.a.h pRO;
    private static com.ss.android.a.a.a.i pRP;
    private static com.ss.android.a.a.d.a pRQ;
    private static com.ss.android.a.a.a.b pRR;
    private static com.ss.android.socialbase.appdownloader.c.h pRS;
    private static com.ss.android.a.a.a.d pRT;
    private static com.ss.android.a.a.a.e pRU;
    private static o pRV;
    private static com.ss.android.a.a.a.j pRW;
    private static r pRX;
    private static n pRY;
    private static m pRZ;
    private static com.ss.android.a.a.a.l pSa;
    private static com.ss.android.a.a.c.a pSb;

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
        pRK = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        pRM = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        pRN = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        pRO = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        pRP = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eCW().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        pRQ = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        pRR = bVar;
    }

    public static com.ss.android.a.a.a.f eCm() {
        return pRK;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eCn() {
        if (pRL == null) {
            pRL = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return pRL;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eCo() {
        if (pRM == null) {
            pRM = new com.ss.android.downloadlib.c.a();
        }
        return pRM;
    }

    public static com.ss.android.a.a.a.g eCp() {
        return pRN;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eCq() {
        if (pRO == null) {
            pRO = new com.ss.android.downloadlib.c.b();
        }
        return pRO;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eCr() {
        if (pRS == null) {
            pRS = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return pRS;
    }

    public static o eCs() {
        return pRV;
    }

    @NonNull
    public static JSONObject i() {
        if (pRP == null) {
            pRP = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.M(pRP.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eCt() {
        if (pRQ == null) {
            pRQ = new a.C1213a().eBK();
        }
        return pRQ;
    }

    public static m eCu() {
        return pRZ;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eCv() {
        return pRR;
    }

    @Nullable
    public static n eCw() {
        return pRY;
    }

    public static com.ss.android.a.a.a.l eCx() {
        return pSa;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eCW().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eCy() {
        return pRT;
    }

    public static com.ss.android.a.a.a.e eCz() {
        return pRU;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eCA() {
        if (pSb == null) {
            pSb = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a pSc = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.pSc = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.pSc.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.pSc != null && this.pSc.isShowing()) {
                        this.pSc.dismiss();
                    }
                }
            };
        }
        return pSb;
    }

    public static com.ss.android.a.a.a.j eCB() {
        return pRW;
    }

    public static r eCC() {
        return pRX;
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
