package d.a.m0.a.d2;

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
import d.a.m0.a.g1.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static long f45112b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f45113c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f45114d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f45115e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f45116f;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f45119i;
    public static Uri k;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45111a = k.f46983a;

    /* renamed from: g  reason: collision with root package name */
    public static long f45117g = System.currentTimeMillis() - 10000;

    /* renamed from: h  reason: collision with root package name */
    public static List<d.a.m0.a.d2.c> f45118h = new ArrayList();
    public static int j = 0;
    public static String l = null;
    public static String m = null;

    /* loaded from: classes3.dex */
    public static class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f45120a;

        /* renamed from: d.a.m0.a.d2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0653a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f45121e;

            public RunnableC0653a(Uri uri) {
                this.f45121e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.q(a.this.f45120a, this.f45121e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            this.f45120a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (e.f45111a) {
                Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
            }
            ExecutorUtilsExt.postOnElastic(new RunnableC0653a(uri), "systemScreenShot", 1);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").F();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f45124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ C0654e f45125g;

        public c(String str, Handler handler, C0654e c0654e) {
            this.f45123e = str;
            this.f45124f = handler;
            this.f45125g = c0654e;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.e();
            if (e.f45111a) {
                Log.d("SYSTEM_SCREENSHOT", "mCount: " + e.j);
            }
            long j = d.a.m0.a.v2.d.a() ? 500L : 100L;
            if (e.m(this.f45123e, e.k) || e.j > 10) {
                if (e.m(this.f45123e, e.k) && e.l() && !e.o(this.f45123e, e.k)) {
                    for (d.a.m0.a.d2.c cVar : e.f45118h) {
                        if (cVar != null) {
                            cVar.a(this.f45125g);
                        }
                    }
                    return;
                }
                return;
            }
            this.f45124f.postDelayed(e.f45119i, j);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static String f45126a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

        /* renamed from: b  reason: collision with root package name */
        public static String[] f45127b = {"_display_name", "_data", "date_added", "_id"};

        public static boolean e(String str) {
            return str != null && (str.toLowerCase().contains("screenshot") || str.contains("截屏") || str.contains("截图"));
        }

        public static boolean f(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }

    /* renamed from: d.a.m0.a.d2.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0654e {

        /* renamed from: a  reason: collision with root package name */
        public String f45128a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f45129b;

        public /* synthetic */ C0654e(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public C0654e(String str, Long l, Uri uri) {
            this.f45128a = str;
            l.longValue();
            this.f45129b = uri;
        }
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(f45114d, uri);
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
        if (!d.a.m0.a.v2.d.a()) {
            return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
        }
        Uri uri = k;
        return uri == null || TextUtils.equals(l, uri.toString());
    }

    public static boolean l() {
        return g.a().b() && System.currentTimeMillis() - f45112b > 2000;
    }

    public static boolean m(String str, Uri uri) {
        if (d.a.m0.a.v2.d.a()) {
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
            return MediaStore.Images.Media.getBitmap(f45114d, uri) != null;
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
        double i3 = d.a.m0.a.v2.d.a() ? i(uri) : 0.0d;
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
        return Build.VERSION.SDK_INT < 23 || d.a.m0.o.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0153: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x0153 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        if (uri.toString().matches(d.f45126a + ".*")) {
            if (t() && f45116f) {
                f45117g = System.currentTimeMillis();
                return;
            }
            j = 0;
            f45117g = System.currentTimeMillis();
            Closeable closeable2 = null;
            try {
                try {
                    cursor = f45114d.query(uri, d.f45127b, null, null, "date_added DESC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                k = uri;
                                if (d.a.m0.a.v2.d.a()) {
                                    k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                }
                                if (f45111a) {
                                    Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                    Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                    Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                    Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                }
                                if (k(string)) {
                                    d.a.m0.t.d.d(cursor);
                                    return;
                                }
                                l = k.toString();
                                m = string;
                                if (d.e(string) && d.f(currentTimeMillis, j2)) {
                                    f45116f = true;
                                    c cVar = new c(string, handler, new C0654e(string, Long.valueOf(j2), k, null));
                                    f45119i = cVar;
                                    handler.post(cVar);
                                } else {
                                    f45116f = false;
                                }
                            }
                        } catch (RuntimeException unused) {
                            if (f45115e != null) {
                                List<ProviderInfo> queryContentProviders = f45115e.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", "SystemScreenshot");
                                hashMap.put("page", "SystemScreenshot");
                                hashMap.put("ext", queryContentProviders.toString());
                                d.a.m0.a.j2.b.j("460", hashMap);
                            }
                            d.a.m0.t.d.d(cursor);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    d.a.m0.t.d.d(closeable2);
                    throw th;
                }
            } catch (RuntimeException unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.m0.t.d.d(closeable2);
                throw th;
            }
            d.a.m0.t.d.d(cursor);
        }
    }

    public static void r(d.a.m0.a.d2.c cVar) {
        if (cVar != null) {
            f45118h.add(cVar);
        }
    }

    public static void s(Context context) {
        f45115e = context.getPackageManager();
        Handler handler = new Handler(Looper.getMainLooper());
        f45114d = context.getContentResolver();
        f45113c = new a(handler, handler);
        if (p(context)) {
            f45114d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f45113c);
        } else if (f45111a && q0.G()) {
            q0.b0(new b());
        }
    }

    public static boolean t() {
        return System.currentTimeMillis() - f45117g <= 1000;
    }

    public static void u(d.a.m0.a.d2.c cVar) {
        if (cVar != null) {
            f45118h.remove(cVar);
        }
    }
}
