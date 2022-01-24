package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
/* loaded from: classes4.dex */
public class j {
    public static final JSONObject a = new JSONObject();

    /* renamed from: b  reason: collision with root package name */
    public static Context f59600b;

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.download.api.config.f f59601c;

    /* renamed from: d  reason: collision with root package name */
    public static com.ss.android.download.api.config.c f59602d;

    /* renamed from: e  reason: collision with root package name */
    public static com.ss.android.download.api.config.k f59603e;

    /* renamed from: f  reason: collision with root package name */
    public static com.ss.android.download.api.config.g f59604f;

    /* renamed from: g  reason: collision with root package name */
    public static com.ss.android.download.api.config.h f59605g;

    /* renamed from: h  reason: collision with root package name */
    public static com.ss.android.download.api.config.i f59606h;

    /* renamed from: i  reason: collision with root package name */
    public static com.ss.android.download.api.model.a f59607i;

    /* renamed from: j  reason: collision with root package name */
    public static com.ss.android.download.api.config.b f59608j;
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

    public static void a(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            f59600b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (f59600b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f59600b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.k c() {
        if (f59603e == null) {
            f59603e = new com.ss.android.download.api.a.a();
        }
        return f59603e;
    }

    public static com.ss.android.download.api.config.g d() {
        return f59604f;
    }

    @NonNull
    public static com.ss.android.download.api.config.h e() {
        if (f59605g == null) {
            f59605g = new com.ss.android.download.api.a.b();
        }
        return f59605g;
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
        Context context = f59600b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    @NonNull
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

    @NonNull
    public static JSONObject i() {
        com.ss.android.download.api.config.i iVar = f59606h;
        if (iVar != null && iVar.a() != null) {
            return f59606h.a();
        }
        return a;
    }

    public static com.ss.android.download.api.config.l j() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b k() {
        return f59608j;
    }

    @Nullable
    public static m l() {
        return q;
    }

    public static String m() {
        return "1.7.0";
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

    @NonNull
    public static p q() {
        return u;
    }

    public static t r() {
        return p;
    }

    @NonNull
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

    @NonNull
    public static r t() {
        if (v == null) {
            v = new r() { // from class: com.ss.android.downloadlib.addownload.j.5
                @Override // com.ss.android.download.api.config.r
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, int i2) {
                }
            };
        }
        return v;
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

    public static boolean v() {
        return (f59601c == null || f59604f == null || f59606h == null || f59608j == null || u == null) ? false : true;
    }

    @NonNull
    public static com.ss.android.download.api.config.c b() {
        if (f59602d == null) {
            f59602d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f59602d;
    }

    public static void a(@NonNull com.ss.android.download.api.config.f fVar) {
        f59601c = fVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.k kVar) {
        f59603e = kVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f59604f = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f59605g = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        f59606h = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        f59607i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        f59608j = bVar;
    }

    public static com.ss.android.download.api.config.f a() {
        return f59601c;
    }

    public static void a(String str) {
        com.ss.android.socialbase.appdownloader.d.j().a(str);
    }

    public static void a(p pVar) {
        u = pVar;
    }

    public static void a(com.ss.android.download.api.b.a aVar) {
        t = aVar;
    }
}
