package d.a.l0.a.d2;

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
import d.a.l0.a.g1.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static long f45004b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f45005c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f45006d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f45007e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f45008f;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f45011i;
    public static Uri k;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45003a = k.f46875a;

    /* renamed from: g  reason: collision with root package name */
    public static long f45009g = System.currentTimeMillis() - 10000;

    /* renamed from: h  reason: collision with root package name */
    public static List<d.a.l0.a.d2.c> f45010h = new ArrayList();
    public static int j = 0;
    public static String l = null;
    public static String m = null;

    /* loaded from: classes3.dex */
    public static class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f45012a;

        /* renamed from: d.a.l0.a.d2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0650a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f45013e;

            public RunnableC0650a(Uri uri) {
                this.f45013e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.q(a.this.f45012a, this.f45013e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            this.f45012a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (e.f45003a) {
                Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
            }
            ExecutorUtilsExt.postOnElastic(new RunnableC0650a(uri), "systemScreenShot", 1);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").F();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f45016f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ C0651e f45017g;

        public c(String str, Handler handler, C0651e c0651e) {
            this.f45015e = str;
            this.f45016f = handler;
            this.f45017g = c0651e;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.e();
            if (e.f45003a) {
                Log.d("SYSTEM_SCREENSHOT", "mCount: " + e.j);
            }
            long j = d.a.l0.a.v2.d.a() ? 500L : 100L;
            if (e.m(this.f45015e, e.k) || e.j > 10) {
                if (e.m(this.f45015e, e.k) && e.l() && !e.o(this.f45015e, e.k)) {
                    for (d.a.l0.a.d2.c cVar : e.f45010h) {
                        if (cVar != null) {
                            cVar.a(this.f45017g);
                        }
                    }
                    return;
                }
                return;
            }
            this.f45016f.postDelayed(e.f45011i, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static String f45018a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

        /* renamed from: b  reason: collision with root package name */
        public static String[] f45019b = {"_display_name", "_data", "date_added", "_id"};

        public static boolean e(String str) {
            return str != null && (str.toLowerCase().contains("screenshot") || str.contains("截屏") || str.contains("截图"));
        }

        public static boolean f(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }

    /* renamed from: d.a.l0.a.d2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0651e {

        /* renamed from: a  reason: collision with root package name */
        public String f45020a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f45021b;

        public /* synthetic */ C0651e(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public C0651e(String str, Long l, Uri uri) {
            this.f45020a = str;
            l.longValue();
            this.f45021b = uri;
        }
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(f45006d, uri);
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
        if (!d.a.l0.a.v2.d.a()) {
            return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
        }
        Uri uri = k;
        return uri == null || TextUtils.equals(l, uri.toString());
    }

    public static boolean l() {
        return g.a().b() && System.currentTimeMillis() - f45004b > 2000;
    }

    public static boolean m(String str, Uri uri) {
        if (d.a.l0.a.v2.d.a()) {
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
            return MediaStore.Images.Media.getBitmap(f45006d, uri) != null;
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
        double i3 = d.a.l0.a.v2.d.a() ? i(uri) : 0.0d;
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
        return Build.VERSION.SDK_INT < 23 || d.a.l0.o.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0153: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x0153 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        if (uri.toString().matches(d.f45018a + ".*")) {
            if (t() && f45008f) {
                f45009g = System.currentTimeMillis();
                return;
            }
            j = 0;
            f45009g = System.currentTimeMillis();
            Closeable closeable2 = null;
            try {
                try {
                    cursor = f45006d.query(uri, d.f45019b, null, null, "date_added DESC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                k = uri;
                                if (d.a.l0.a.v2.d.a()) {
                                    k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                }
                                if (f45003a) {
                                    Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                    Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                    Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                    Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                }
                                if (k(string)) {
                                    d.a.l0.t.d.d(cursor);
                                    return;
                                }
                                l = k.toString();
                                m = string;
                                if (d.e(string) && d.f(currentTimeMillis, j2)) {
                                    f45008f = true;
                                    c cVar = new c(string, handler, new C0651e(string, Long.valueOf(j2), k, null));
                                    f45011i = cVar;
                                    handler.post(cVar);
                                } else {
                                    f45008f = false;
                                }
                            }
                        } catch (RuntimeException unused) {
                            if (f45007e != null) {
                                List<ProviderInfo> queryContentProviders = f45007e.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", "SystemScreenshot");
                                hashMap.put("page", "SystemScreenshot");
                                hashMap.put("ext", queryContentProviders.toString());
                                d.a.l0.a.j2.b.j("460", hashMap);
                            }
                            d.a.l0.t.d.d(cursor);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    d.a.l0.t.d.d(closeable2);
                    throw th;
                }
            } catch (RuntimeException unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.l0.t.d.d(closeable2);
                throw th;
            }
            d.a.l0.t.d.d(cursor);
        }
    }

    public static void r(d.a.l0.a.d2.c cVar) {
        if (cVar != null) {
            f45010h.add(cVar);
        }
    }

    public static void s(Context context) {
        f45007e = context.getPackageManager();
        Handler handler = new Handler(Looper.getMainLooper());
        f45006d = context.getContentResolver();
        f45005c = new a(handler, handler);
        if (p(context)) {
            f45006d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f45005c);
        } else if (f45003a && q0.G()) {
            q0.b0(new b());
        }
    }

    public static boolean t() {
        return System.currentTimeMillis() - f45009g <= 1000;
    }

    public static void u(d.a.l0.a.d2.c cVar) {
        if (cVar != null) {
            f45010h.remove(cVar);
        }
    }
}
