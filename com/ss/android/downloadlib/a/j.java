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
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Context f12964a;
    private static com.ss.android.a.a.a.f qbO;
    private static com.ss.android.a.a.a.c qbP;
    private static com.ss.android.a.a.a.k qbQ;
    private static com.ss.android.a.a.a.g qbR;
    private static com.ss.android.a.a.a.h qbS;
    private static com.ss.android.a.a.a.i qbT;
    private static com.ss.android.a.a.d.a qbU;
    private static com.ss.android.a.a.a.b qbV;
    private static com.ss.android.socialbase.appdownloader.c.h qbW;
    private static com.ss.android.a.a.a.d qbX;
    private static com.ss.android.a.a.a.e qbY;
    private static o qbZ;
    private static com.ss.android.a.a.a.j qca;
    private static r qcb;
    private static n qcc;
    private static m qcd;
    private static com.ss.android.a.a.a.l qce;
    private static com.ss.android.a.a.c.a qcf;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f12964a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f12964a == null && context != null && context.getApplicationContext() != null) {
            f12964a = context.getApplicationContext();
        }
    }

    public static Context a() {
        if (f12964a == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return f12964a;
    }

    public static void b(@NonNull com.ss.android.a.a.a.f fVar) {
        qbO = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        qbQ = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        qbR = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        qbS = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        qbT = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eFn().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        qbU = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        qbV = bVar;
    }

    public static com.ss.android.a.a.a.f eED() {
        return qbO;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eEE() {
        if (qbP == null) {
            qbP = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return qbP;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eEF() {
        if (qbQ == null) {
            qbQ = new com.ss.android.downloadlib.c.a();
        }
        return qbQ;
    }

    public static com.ss.android.a.a.a.g eEG() {
        return qbR;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eEH() {
        if (qbS == null) {
            qbS = new com.ss.android.downloadlib.c.b();
        }
        return qbS;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eEI() {
        if (qbW == null) {
            qbW = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return qbW;
    }

    public static o eEJ() {
        return qbZ;
    }

    @NonNull
    public static JSONObject i() {
        if (qbT == null) {
            qbT = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.M(qbT.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eEK() {
        if (qbU == null) {
            qbU = new a.C1217a().eEb();
        }
        return qbU;
    }

    public static m eEL() {
        return qcd;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eEM() {
        return qbV;
    }

    @Nullable
    public static n eEN() {
        return qcc;
    }

    public static com.ss.android.a.a.a.l eEO() {
        return qce;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eFn().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eEP() {
        return qbX;
    }

    public static com.ss.android.a.a.a.e eEQ() {
        return qbY;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eER() {
        if (qcf == null) {
            qcf = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a qcg = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.qcg = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.qcg.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.qcg != null && this.qcg.isShowing()) {
                        this.qcg.dismiss();
                    }
                }
            };
        }
        return qcf;
    }

    public static com.ss.android.a.a.a.j eES() {
        return qca;
    }

    public static r eET() {
        return qcb;
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

    public static long eoj() {
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
