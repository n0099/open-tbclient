package d.a.i0.a.d2;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.a.g1.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static long f41154b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f41155c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f41156d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f41157e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f41158f;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f41161i;
    public static Uri k;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41153a = k.f43025a;

    /* renamed from: g  reason: collision with root package name */
    public static long f41159g = System.currentTimeMillis() - 10000;

    /* renamed from: h  reason: collision with root package name */
    public static List<d.a.i0.a.d2.c> f41160h = new ArrayList();
    public static int j = 0;
    public static String l = null;
    public static String m = null;

    /* loaded from: classes3.dex */
    public static class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f41162a;

        /* renamed from: d.a.i0.a.d2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0583a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f41163e;

            public RunnableC0583a(Uri uri) {
                this.f41163e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.q(a.this.f41162a, this.f41163e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            this.f41162a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (e.f41153a) {
                Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
            }
            ExecutorUtilsExt.postOnElastic(new RunnableC0583a(uri), "systemScreenShot", 1);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").F();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f41165e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f41166f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ C0584e f41167g;

        public c(String str, Handler handler, C0584e c0584e) {
            this.f41165e = str;
            this.f41166f = handler;
            this.f41167g = c0584e;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.e();
            if (e.f41153a) {
                Log.d("SYSTEM_SCREENSHOT", "mCount: " + e.j);
            }
            long j = d.a.i0.a.v2.d.a() ? 500L : 100L;
            if (e.m(this.f41165e, e.k) || e.j > 10) {
                if (e.m(this.f41165e, e.k) && e.l() && !e.o(this.f41165e, e.k)) {
                    for (d.a.i0.a.d2.c cVar : e.f41160h) {
                        if (cVar != null) {
                            cVar.a(this.f41167g);
                        }
                    }
                    return;
                }
                return;
            }
            this.f41166f.postDelayed(e.f41161i, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static String f41168a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

        /* renamed from: b  reason: collision with root package name */
        public static String[] f41169b = {"_display_name", "_data", "date_added", "_id"};

        public static boolean e(String str) {
            return str != null && (str.toLowerCase().contains("screenshot") || str.contains("截屏") || str.contains("截图"));
        }

        public static boolean f(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }

    /* renamed from: d.a.i0.a.d2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0584e {

        /* renamed from: a  reason: collision with root package name */
        public String f41170a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f41171b;

        public /* synthetic */ C0584e(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public C0584e(String str, Long l, Uri uri) {
            this.f41170a = str;
            l.longValue();
            this.f41171b = uri;
        }
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(f41156d, uri);
            if (bitmap == null) {
                return 0.0d;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width != 0) {
                return height / (width * 1.0d);
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static int j() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static boolean k(String str) {
        if (!d.a.i0.a.v2.d.a()) {
            return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
        }
        Uri uri = k;
        return uri == null || TextUtils.equals(l, uri.toString());
    }

    public static boolean l() {
        return g.a().b() && System.currentTimeMillis() - f41154b > 2000;
    }

    public static boolean m(String str, Uri uri) {
        if (d.a.i0.a.v2.d.a()) {
            return n(uri);
        }
        new BitmapFactory.Options().inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(str) != null;
    }

    public static boolean n(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            return MediaStore.Images.Media.getBitmap(f41156d, uri) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(String str, Uri uri) {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int j2 = point.y + j();
        int i2 = point.x;
        double d2 = (i2 != 0 ? j2 / (i2 * 1.0d) : 0.0d) * 1.2d;
        double i3 = d.a.i0.a.v2.d.a() ? i(uri) : 0.0d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i5 != 0) {
            i3 = i4 / (i5 * 1.0d);
        }
        return i3 > d2;
    }

    public static boolean p(Context context) {
        return Build.VERSION.SDK_INT < 23 || d.a.i0.o.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0153: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x0153 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        if (uri.toString().matches(d.f41168a + ".*")) {
            if (t() && f41158f) {
                f41159g = System.currentTimeMillis();
                return;
            }
            j = 0;
            f41159g = System.currentTimeMillis();
            Closeable closeable2 = null;
            try {
                try {
                    cursor = f41156d.query(uri, d.f41169b, null, null, "date_added DESC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                k = uri;
                                if (d.a.i0.a.v2.d.a()) {
                                    k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                }
                                if (f41153a) {
                                    Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                    Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                    Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                    Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                }
                                if (k(string)) {
                                    d.a.i0.t.d.d(cursor);
                                    return;
                                }
                                l = k.toString();
                                m = string;
                                if (d.e(string) && d.f(currentTimeMillis, j2)) {
                                    f41158f = true;
                                    c cVar = new c(string, handler, new C0584e(string, Long.valueOf(j2), k, null));
                                    f41161i = cVar;
                                    handler.post(cVar);
                                } else {
                                    f41158f = false;
                                }
                            }
                        } catch (RuntimeException unused) {
                            if (f41157e != null) {
                                List<ProviderInfo> queryContentProviders = f41157e.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", "SystemScreenshot");
                                hashMap.put("page", "SystemScreenshot");
                                hashMap.put("ext", queryContentProviders.toString());
                                d.a.i0.a.j2.b.j("460", hashMap);
                            }
                            d.a.i0.t.d.d(cursor);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    d.a.i0.t.d.d(closeable2);
                    throw th;
                }
            } catch (RuntimeException unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.i0.t.d.d(closeable2);
                throw th;
            }
            d.a.i0.t.d.d(cursor);
        }
    }

    public static void r(d.a.i0.a.d2.c cVar) {
        if (cVar != null) {
            f41160h.add(cVar);
        }
    }

    public static void s(Context context) {
        f41157e = context.getPackageManager();
        Handler handler = new Handler(Looper.getMainLooper());
        f41156d = context.getContentResolver();
        f41155c = new a(handler, handler);
        if (p(context)) {
            f41156d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f41155c);
        } else if (f41153a && q0.G()) {
            q0.b0(new b());
        }
    }

    public static boolean t() {
        return System.currentTimeMillis() - f41159g <= 1000;
    }

    public static void u(d.a.i0.a.d2.c cVar) {
        if (cVar != null) {
            f41160h.remove(cVar);
        }
    }
}
