package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.ss.android.download.api.config.m;
import com.ss.android.download.api.config.n;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j {
    public static final JSONObject a = new JSONObject();
    public static Context b;
    public static com.ss.android.download.api.config.f c;
    public static com.ss.android.download.api.config.c d;
    public static com.ss.android.download.api.config.k e;
    public static com.ss.android.download.api.config.g f;
    public static com.ss.android.download.api.config.h g;
    public static com.ss.android.download.api.config.i h;
    public static com.ss.android.download.api.model.a i;
    public static com.ss.android.download.api.config.b j;
    public static com.ss.android.socialbase.appdownloader.c.h k;
    public static com.ss.android.download.api.config.d l;
    public static com.ss.android.download.api.config.e m;
    public static n n;
    public static com.ss.android.download.api.config.j o;
    public static t p;
    public static m q;
    public static com.ss.android.download.api.config.l r;
    public static o s;
    public static com.ss.android.download.api.b.a t;
    public static p u;
    public static r v;

    public static String m() {
        return "1.7.0";
    }

    public static com.ss.android.download.api.config.f a() {
        return c;
    }

    public static com.ss.android.download.api.config.c b() {
        if (d == null) {
            d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
                @Override // com.ss.android.download.api.config.c
                public void a(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, String str2) {
                }
            };
        }
        return d;
    }

    public static com.ss.android.download.api.config.k c() {
        if (e == null) {
            e = new com.ss.android.download.api.a.a();
        }
        return e;
    }

    public static com.ss.android.download.api.config.g d() {
        return f;
    }

    public static com.ss.android.download.api.config.h e() {
        if (g == null) {
            g = new com.ss.android.download.api.a.b();
        }
        return g;
    }

    public static com.ss.android.socialbase.appdownloader.c.h f() {
        if (k == null) {
            k = new com.ss.android.socialbase.appdownloader.c.h() { // from class: com.ss.android.downloadlib.addownload.j.2
                @Override // com.ss.android.socialbase.appdownloader.c.h
                public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                }
            };
        }
        return k;
    }

    public static n g() {
        return n;
    }

    public static Context getContext() {
        Context context = b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static o h() {
        if (s == null) {
            s = new o() { // from class: com.ss.android.downloadlib.addownload.j.3
                @Override // com.ss.android.download.api.config.o
                public void a(String str, int i2, JSONObject jSONObject) {
                }
            };
        }
        return s;
    }

    public static JSONObject i() {
        com.ss.android.download.api.config.i iVar = h;
        if (iVar != null && iVar.a() != null) {
            return h.a();
        }
        return a;
    }

    public static com.ss.android.download.api.config.l j() {
        return r;
    }

    public static com.ss.android.download.api.config.b k() {
        return j;
    }

    public static m l() {
        return q;
    }

    public static com.ss.android.download.api.config.d n() {
        return l;
    }

    public static com.ss.android.download.api.config.e o() {
        return m;
    }

    public static com.ss.android.download.api.config.j p() {
        return o;
    }

    public static p q() {
        return u;
    }

    public static t r() {
        return p;
    }

    public static com.ss.android.download.api.b.a s() {
        if (t == null) {
            t = new com.ss.android.download.api.b.a() { // from class: com.ss.android.downloadlib.addownload.j.4
                @Override // com.ss.android.download.api.b.a
                public void a(Throwable th, String str) {
                }
            };
        }
        return t;
    }

    public static r t() {
        if (v == null) {
            v = new r() { // from class: com.ss.android.downloadlib.addownload.j.5
                @Override // com.ss.android.download.api.config.r
                public void a(Context context, DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return v;
    }

    public static boolean v() {
        if (c != null && f != null && h != null && j != null && u != null) {
            return true;
        }
        return false;
    }

    public static void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (b == null && context != null && context.getApplicationContext() != null) {
            b = context.getApplicationContext();
        }
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }

    public static void a(com.ss.android.download.api.config.b bVar) {
        j = bVar;
    }

    public static void a(com.ss.android.download.api.config.f fVar) {
        c = fVar;
    }

    public static void a(com.ss.android.download.api.config.g gVar) {
        f = gVar;
    }

    public static void a(com.ss.android.download.api.config.h hVar) {
        g = hVar;
    }

    public static void a(com.ss.android.download.api.config.i iVar) {
        h = iVar;
    }

    public static void a(com.ss.android.download.api.config.k kVar) {
        e = kVar;
    }

    public static void a(p pVar) {
        u = pVar;
    }

    public static void a(com.ss.android.download.api.model.a aVar) {
        i = aVar;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static String u() {
        try {
            int i2 = getContext().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + i().optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
        } catch (Throwable unused) {
            return null;
        }
    }
}
