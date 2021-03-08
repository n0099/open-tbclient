package com.ss.android.downloadlib.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    private static Context f7713a;
    private static com.ss.android.a.a.a.f qdb;
    private static com.ss.android.a.a.a.c qdc;
    private static com.ss.android.a.a.a.k qdd;
    private static com.ss.android.a.a.a.g qde;
    private static com.ss.android.a.a.a.h qdf;
    private static com.ss.android.a.a.a.i qdg;
    private static com.ss.android.a.a.d.a qdh;
    private static com.ss.android.a.a.a.b qdi;
    private static com.ss.android.socialbase.appdownloader.c.h qdj;
    private static com.ss.android.a.a.a.d qdk;
    private static com.ss.android.a.a.a.e qdl;
    private static o qdm;
    private static com.ss.android.a.a.a.j qdn;
    private static r qdo;
    private static n qdp;
    private static m qdq;
    private static com.ss.android.a.a.a.l qdr;
    private static com.ss.android.a.a.c.a qds;

    public static void a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            throw new IllegalArgumentException("Context is null");
        }
        f7713a = context.getApplicationContext();
    }

    public static void b(Context context) {
        if (f7713a == null && context != null && context.getApplicationContext() != null) {
            f7713a = context.getApplicationContext();
        }
    }

    public static Context a() {
        if (f7713a == null) {
            throw new IllegalArgumentException("Context is null");
        }
        return f7713a;
    }

    public static void b(@NonNull com.ss.android.a.a.a.f fVar) {
        qdb = fVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.k kVar) {
        qdd = kVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.g gVar) {
        qde = gVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.h hVar) {
        qdf = hVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.i iVar) {
        qdg = iVar;
        try {
            com.ss.android.socialbase.appdownloader.d.eFz().b(y());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(@NonNull com.ss.android.a.a.d.a aVar) {
        qdh = aVar;
    }

    public static void b(@NonNull com.ss.android.a.a.a.b bVar) {
        qdi = bVar;
    }

    public static com.ss.android.a.a.a.f eEP() {
        return qdb;
    }

    @NonNull
    public static com.ss.android.a.a.a.c eEQ() {
        if (qdc == null) {
            qdc = new com.ss.android.a.a.a.c() { // from class: com.ss.android.downloadlib.a.j.1
                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
                }

                @Override // com.ss.android.a.a.a.c
                public void a(@Nullable Context context, @NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar, String str) {
                }
            };
        }
        return qdc;
    }

    @NonNull
    public static com.ss.android.a.a.a.k eER() {
        if (qdd == null) {
            qdd = new com.ss.android.downloadlib.c.a();
        }
        return qdd;
    }

    public static com.ss.android.a.a.a.g eES() {
        return qde;
    }

    @NonNull
    public static com.ss.android.a.a.a.h eET() {
        if (qdf == null) {
            qdf = new com.ss.android.downloadlib.c.b();
        }
        return qdf;
    }

    public static com.ss.android.socialbase.appdownloader.c.h eEU() {
        if (qdj == null) {
            qdj = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.a.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
                }
            };
        }
        return qdj;
    }

    public static o eEV() {
        return qdm;
    }

    @NonNull
    public static JSONObject i() {
        if (qdg == null) {
            qdg = new com.ss.android.a.a.a.i() { // from class: com.ss.android.downloadlib.a.j.3
                @Override // com.ss.android.a.a.a.i
                public JSONObject a() {
                    return new JSONObject();
                }
            };
        }
        return (JSONObject) com.ss.android.downloadlib.f.i.L(qdg.a(), new JSONObject());
    }

    @NonNull
    public static com.ss.android.a.a.d.a eEW() {
        if (qdh == null) {
            qdh = new a.C1209a().eEn();
        }
        return qdh;
    }

    public static m eEX() {
        return qdq;
    }

    @Nullable
    public static com.ss.android.a.a.a.b eEY() {
        return qdi;
    }

    @Nullable
    public static n eEZ() {
        return qdp;
    }

    public static com.ss.android.a.a.a.l eFa() {
        return qdr;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.eFz().a(str);
    }

    public static String o() {
        return "1.9.5.1";
    }

    public static com.ss.android.a.a.a.d eFb() {
        return qdk;
    }

    public static com.ss.android.a.a.a.e eFc() {
        return qdl;
    }

    @NonNull
    public static com.ss.android.a.a.c.a eFd() {
        if (qds == null) {
            qds = new com.ss.android.a.a.c.a() { // from class: com.ss.android.downloadlib.a.j.4
                com.ss.android.downloadlib.guide.install.a qdt = null;

                @Override // com.ss.android.a.a.c.a
                public void a(Activity activity, int i, String str, Drawable drawable, String str2, long j, com.ss.android.socialbase.appdownloader.c.m mVar) {
                    this.qdt = new com.ss.android.downloadlib.guide.install.a(activity, i, str, drawable, str2, j, mVar);
                    this.qdt.show();
                }

                @Override // com.ss.android.a.a.c.a
                public void a() {
                    if (this.qdt != null && this.qdt.isShowing()) {
                        this.qdt.dismiss();
                    }
                }
            };
        }
        return qds;
    }

    public static com.ss.android.a.a.a.j eFe() {
        return qdn;
    }

    public static r eFf() {
        return qdo;
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

    public static long eoy() {
        long optLong = i().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static String y() {
        try {
            int i = a().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i == 29 && !Environment.isExternalStorageLegacy()) || i > 29)) {
                return a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable th) {
            return null;
        }
    }
}
