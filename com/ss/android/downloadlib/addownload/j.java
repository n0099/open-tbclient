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
    public static Context f59767b;

    /* renamed from: c  reason: collision with root package name */
    public static com.ss.android.download.api.config.f f59768c;

    /* renamed from: d  reason: collision with root package name */
    public static com.ss.android.download.api.config.c f59769d;

    /* renamed from: e  reason: collision with root package name */
    public static com.ss.android.download.api.config.k f59770e;

    /* renamed from: f  reason: collision with root package name */
    public static com.ss.android.download.api.config.g f59771f;

    /* renamed from: g  reason: collision with root package name */
    public static com.ss.android.download.api.config.h f59772g;

    /* renamed from: h  reason: collision with root package name */
    public static com.ss.android.download.api.config.i f59773h;

    /* renamed from: i  reason: collision with root package name */
    public static com.ss.android.download.api.model.a f59774i;

    /* renamed from: j  reason: collision with root package name */
    public static com.ss.android.download.api.config.b f59775j;
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
            f59767b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (f59767b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f59767b = context.getApplicationContext();
    }

    @NonNull
    public static com.ss.android.download.api.config.k c() {
        if (f59770e == null) {
            f59770e = new com.ss.android.download.api.a.a();
        }
        return f59770e;
    }

    public static com.ss.android.download.api.config.g d() {
        return f59771f;
    }

    @NonNull
    public static com.ss.android.download.api.config.h e() {
        if (f59772g == null) {
            f59772g = new com.ss.android.download.api.a.b();
        }
        return f59772g;
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
        Context context = f59767b;
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
        com.ss.android.download.api.config.i iVar = f59773h;
        if (iVar != null && iVar.a() != null) {
            return f59773h.a();
        }
        return a;
    }

    public static com.ss.android.download.api.config.l j() {
        return r;
    }

    @Nullable
    public static com.ss.android.download.api.config.b k() {
        return f59775j;
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
        return (f59768c == null || f59771f == null || f59773h == null || f59775j == null || u == null) ? false : true;
    }

    @NonNull
    public static com.ss.android.download.api.config.c b() {
        if (f59769d == null) {
            f59769d = new com.ss.android.download.api.config.c() { // from class: com.ss.android.downloadlib.addownload.j.1
                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
                }

                @Override // com.ss.android.download.api.config.c
                public void a(@Nullable Context context, @NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig, String str, @NonNull String str2) {
                }
            };
        }
        return f59769d;
    }

    public static void a(@NonNull com.ss.android.download.api.config.f fVar) {
        f59768c = fVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.k kVar) {
        f59770e = kVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.g gVar) {
        f59771f = gVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.h hVar) {
        f59772g = hVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.i iVar) {
        f59773h = iVar;
    }

    public static void a(@NonNull com.ss.android.download.api.model.a aVar) {
        f59774i = aVar;
    }

    public static void a(@NonNull com.ss.android.download.api.config.b bVar) {
        f59775j = bVar;
    }

    public static com.ss.android.download.api.config.f a() {
        return f59768c;
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
