package d.o.a.d.f;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.f;
import d.o.a.a.a.a.r;
import d.o.a.d.h;
import d.o.a.e.a.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    public static Context f66871b;

    /* renamed from: d  reason: collision with root package name */
    public static f f66873d;

    /* renamed from: e  reason: collision with root package name */
    public static d.o.a.a.a.a.c f66874e;

    /* renamed from: f  reason: collision with root package name */
    public static d.o.a.a.a.a.k f66875f;

    /* renamed from: g  reason: collision with root package name */
    public static d.o.a.a.a.a.g f66876g;

    /* renamed from: h  reason: collision with root package name */
    public static d.o.a.a.a.a.h f66877h;

    /* renamed from: i  reason: collision with root package name */
    public static d.o.a.a.a.a.i f66878i;
    public static d.o.a.a.a.a.b j;
    public static d.j k;
    public static d.o.a.a.a.a.d l;
    public static d.o.a.a.a.a.e m;
    public static d.o.a.a.a.a.o n;
    public static d.o.a.a.a.a.j o;
    public static r p;
    public static d.o.a.a.a.a.m q;
    public static d.o.a.a.a.a.l r;

    /* renamed from: a  reason: collision with root package name */
    public static final JSONObject f66870a = new JSONObject();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f66872c = false;

    /* loaded from: classes7.dex */
    public static class a implements d.o.a.a.a.a.c {
        @Override // d.o.a.a.a.a.c
        public void a(@Nullable Context context, @NonNull d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar, String str, @NonNull String str2) {
        }

        @Override // d.o.a.a.a.a.c
        public void b(@Nullable Context context, @NonNull d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.j {
        @Override // d.o.a.e.a.d.j
        public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements d.o.a.a.a.a.i {
        @Override // d.o.a.a.a.a.i
        public JSONObject a() {
            return n.f66870a;
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
        Context context = f66871b;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void b(Context context) {
        if (context != null && context.getApplicationContext() != null) {
            f66871b = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("Context is null");
    }

    public static void c(@NonNull d.o.a.a.a.a.b bVar) {
        j = bVar;
    }

    public static void d(@NonNull f fVar) {
        f66873d = fVar;
    }

    public static void e(@NonNull d.o.a.a.a.a.g gVar) {
        f66876g = gVar;
    }

    public static void f(@NonNull d.o.a.a.a.a.h hVar) {
        f66877h = hVar;
    }

    public static void g(@NonNull d.o.a.a.a.a.i iVar) {
        f66878i = iVar;
        try {
            d.o.a.e.a.e.F().w(F());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void h(@NonNull d.o.a.a.a.a.k kVar) {
        f66875f = kVar;
    }

    public static void i(@NonNull d.o.a.a.a.d.a aVar) {
    }

    public static void j(String str) {
        d.o.a.e.a.e.F().r(str);
    }

    public static f k() {
        return f66873d;
    }

    public static void l(Context context) {
        if (f66871b != null || context == null || context.getApplicationContext() == null) {
            return;
        }
        f66871b = context.getApplicationContext();
    }

    @NonNull
    public static d.o.a.a.a.a.c m() {
        if (f66874e == null) {
            f66874e = new a();
        }
        return f66874e;
    }

    @NonNull
    public static d.o.a.a.a.a.k n() {
        if (f66875f == null) {
            f66875f = new h.d();
        }
        return f66875f;
    }

    public static d.o.a.a.a.a.g o() {
        return f66876g;
    }

    @NonNull
    public static d.o.a.a.a.a.h p() {
        if (f66877h == null) {
            f66877h = new h.e();
        }
        return f66877h;
    }

    public static d.j q() {
        if (k == null) {
            k = new b();
        }
        return k;
    }

    public static d.o.a.a.a.a.o r() {
        return n;
    }

    @NonNull
    public static JSONObject s() {
        if (f66878i == null) {
            f66878i = new c();
        }
        return (JSONObject) d.o.a.d.n.k.k(f66878i.a(), f66870a);
    }

    public static d.o.a.a.a.a.l t() {
        return r;
    }

    @Nullable
    public static d.o.a.a.a.a.b u() {
        return j;
    }

    @Nullable
    public static d.o.a.a.a.a.m v() {
        return q;
    }

    public static String w() {
        return "1.9.5.1";
    }

    public static d.o.a.a.a.a.d x() {
        return l;
    }

    public static d.o.a.a.a.a.e y() {
        return m;
    }

    public static d.o.a.a.a.a.j z() {
        return o;
    }
}
