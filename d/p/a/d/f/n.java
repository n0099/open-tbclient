package d.p.a.d.f;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.a.a.a.f;
import d.p.a.a.a.a.r;
import d.p.a.d.h;
import d.p.a.e.a.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    public static Context f67794b;

    /* renamed from: d  reason: collision with root package name */
    public static f f67796d;

    /* renamed from: e  reason: collision with root package name */
    public static d.p.a.a.a.a.c f67797e;

    /* renamed from: f  reason: collision with root package name */
    public static d.p.a.a.a.a.k f67798f;

    /* renamed from: g  reason: collision with root package name */
    public static d.p.a.a.a.a.g f67799g;

    /* renamed from: h  reason: collision with root package name */
    public static d.p.a.a.a.a.h f67800h;
    public static d.p.a.a.a.a.i i;
    public static d.p.a.a.a.a.b j;
    public static d.j k;
    public static d.p.a.a.a.a.d l;
    public static d.p.a.a.a.a.e m;
    public static d.p.a.a.a.a.o n;
    public static d.p.a.a.a.a.j o;
    public static r p;
    public static d.p.a.a.a.a.m q;
    public static d.p.a.a.a.a.l r;

    /* renamed from: a  reason: collision with root package name */
    public static final JSONObject f67793a = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f67795c = false;

    /* loaded from: classes6.dex */
    public static class a implements d.p.a.a.a.a.c {
        @Override // d.p.a.a.a.a.c
        public void a(@Nullable Context context, @NonNull d.p.a.a.a.c.d dVar, @Nullable d.p.a.a.a.c.b bVar, @Nullable d.p.a.a.a.c.c cVar, String str, @NonNull String str2) {
        }

        @Override // d.p.a.a.a.a.c
        public void b(@Nullable Context context, @NonNull d.p.a.a.a.c.d dVar, @Nullable d.p.a.a.a.c.b bVar, @Nullable d.p.a.a.a.c.c cVar) {
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d.j {
        @Override // d.p.a.e.a.d.j
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i) {
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements d.p.a.a.a.a.i {
        @Override // d.p.a.a.a.a.i
        public JSONObject a() {
            return n.f67793a;
        }
    }

    public static r A() {
        return p;
    }

    public static boolean B() {
        return s().optInt("is_enable_start_install_again") == 1 || C();
    }

    public static boolean C() {
        return false;
    }

    public static long D() {
        long optLong = s().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long E() {
        long optLong = s().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static String F() {
        try {
            int i2 = a().getApplicationInfo().targetSdkVersion;
            if (Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
                return a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            return Environment.getExternalStorageDirectory().getPath() + File.separator + s().optString("default_save_dir_name", "ByteDownload");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context a() {
        Context context = f67794b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            f67794b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void c(@NonNull d.p.a.a.a.a.b bVar) {
        j = bVar;
    }

    public static void d(@NonNull f fVar) {
        f67796d = fVar;
    }

    public static void e(@NonNull d.p.a.a.a.a.g gVar) {
        f67799g = gVar;
    }

    public static void f(@NonNull d.p.a.a.a.a.h hVar) {
        f67800h = hVar;
    }

    public static void g(@NonNull d.p.a.a.a.a.i iVar) {
        i = iVar;
        try {
            d.p.a.e.a.e.F().w(F());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void h(@NonNull d.p.a.a.a.a.k kVar) {
        f67798f = kVar;
    }

    public static void i(@NonNull d.p.a.a.a.d.a aVar) {
    }

    public static void j(String str) {
        d.p.a.e.a.e.F().r(str);
    }

    public static f k() {
        return f67796d;
    }

    public static void l(Context context) {
        if (f67794b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f67794b = context.getApplicationContext();
    }

    @NonNull
    public static d.p.a.a.a.a.c m() {
        if (f67797e == null) {
            f67797e = new a();
        }
        return f67797e;
    }

    @NonNull
    public static d.p.a.a.a.a.k n() {
        if (f67798f == null) {
            f67798f = new h.d();
        }
        return f67798f;
    }

    public static d.p.a.a.a.a.g o() {
        return f67799g;
    }

    @NonNull
    public static d.p.a.a.a.a.h p() {
        if (f67800h == null) {
            f67800h = new h.e();
        }
        return f67800h;
    }

    public static d.j q() {
        if (k == null) {
            k = new b();
        }
        return k;
    }

    public static d.p.a.a.a.a.o r() {
        return n;
    }

    @NonNull
    public static JSONObject s() {
        if (i == null) {
            i = new c();
        }
        return (JSONObject) d.p.a.d.n.k.k(i.a(), f67793a);
    }

    public static d.p.a.a.a.a.l t() {
        return r;
    }

    @Nullable
    public static d.p.a.a.a.a.b u() {
        return j;
    }

    @Nullable
    public static d.p.a.a.a.a.m v() {
        return q;
    }

    public static String w() {
        return "1.9.5.1";
    }

    public static d.p.a.a.a.a.d x() {
        return l;
    }

    public static d.p.a.a.a.a.e y() {
        return m;
    }

    public static d.p.a.a.a.a.j z() {
        return o;
    }
}
