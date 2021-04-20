package d.b.g0.a.u1;

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
import d.b.g0.a.k;
import d.b.g0.a.z0.g;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static long f47027b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f47028c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f47029d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f47030e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f47031f;
    public static Runnable i;
    public static Uri k;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47026a = k.f45443a;

    /* renamed from: g  reason: collision with root package name */
    public static long f47032g = System.currentTimeMillis() - 10000;

    /* renamed from: h  reason: collision with root package name */
    public static List<d.b.g0.a.u1.a> f47033h = new ArrayList();
    public static int j = 0;
    public static String l = null;

    /* loaded from: classes3.dex */
    public static class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f47034a;

        /* renamed from: d.b.g0.a.u1.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0864a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f47035e;

            public RunnableC0864a(Uri uri) {
                this.f47035e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.q(a.this.f47034a, this.f47035e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            this.f47034a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            if (c.f47026a) {
                Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
            }
            ExecutorUtilsExt.postOnElastic(new RunnableC0864a(uri), "systemScreenShot", 1);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47037e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f47038f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f47039g;

        public b(String str, Handler handler, d dVar) {
            this.f47037e = str;
            this.f47038f = handler;
            this.f47039g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.e();
            if (c.f47026a) {
                Log.d("SYSTEM_SCREENSHOT", "mCount: " + c.j);
            }
            if (c.m(this.f47037e, c.k) || c.j > 10) {
                if (c.m(this.f47037e, c.k) && c.l() && !c.o(this.f47037e, c.k)) {
                    for (d.b.g0.a.u1.a aVar : c.f47033h) {
                        if (aVar != null) {
                            aVar.a(this.f47039g);
                        }
                    }
                    return;
                }
                return;
            }
            this.f47038f.postDelayed(c.i, 100L);
        }
    }

    /* renamed from: d.b.g0.a.u1.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0865c {

        /* renamed from: a  reason: collision with root package name */
        public static String f47040a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();

        /* renamed from: b  reason: collision with root package name */
        public static String[] f47041b = {"_display_name", "_data", "date_added", "_id"};

        public static boolean e(String str) {
            return str != null && (str.toLowerCase().contains("screenshot") || str.contains("截屏") || str.contains("截图"));
        }

        public static boolean f(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f47042a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f47043b;

        public /* synthetic */ d(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public d(String str, Long l, Uri uri) {
            this.f47042a = str;
            l.longValue();
            this.f47043b = uri;
        }
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(f47029d, uri);
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

    public static boolean k() {
        Uri uri = k;
        return uri == null || TextUtils.equals(l, uri.toString());
    }

    public static boolean l() {
        return g.a().b() && System.currentTimeMillis() - f47027b > 2000;
    }

    public static boolean m(String str, Uri uri) {
        if (d.b.g0.a.i2.c.a()) {
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
            return MediaStore.Images.Media.getBitmap(f47029d, uri) != null;
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
        double i3 = d.b.g0.a.i2.c.a() ? i(uri) : 0.0d;
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
        return Build.VERSION.SDK_INT < 23 || d.b.g0.m.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0151: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:42:0x0151 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        if (uri.toString().matches(C0865c.f47040a + ".*")) {
            if (t() && f47031f) {
                f47032g = System.currentTimeMillis();
                return;
            }
            j = 0;
            f47032g = System.currentTimeMillis();
            Closeable closeable2 = null;
            try {
                try {
                    cursor = f47029d.query(uri, C0865c.f47041b, null, null, "date_added DESC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                String string = cursor.getString(cursor.getColumnIndex("_data"));
                                long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                long currentTimeMillis = System.currentTimeMillis() / 1000;
                                k = uri;
                                if (d.b.g0.a.i2.c.a()) {
                                    k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                }
                                if (f47026a) {
                                    Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                    Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                    Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                    Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                }
                                if (k()) {
                                    d.b.g0.p.d.a(cursor);
                                    return;
                                }
                                l = k.toString();
                                if (C0865c.e(string) && C0865c.f(currentTimeMillis, j2)) {
                                    f47031f = true;
                                    b bVar = new b(string, handler, new d(string, Long.valueOf(j2), k, null));
                                    i = bVar;
                                    handler.post(bVar);
                                } else {
                                    f47031f = false;
                                }
                            }
                        } catch (RuntimeException unused) {
                            if (f47030e != null) {
                                List<ProviderInfo> queryContentProviders = f47030e.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", "SystemScreenshot");
                                hashMap.put("page", "SystemScreenshot");
                                hashMap.put("ext", queryContentProviders.toString());
                                d.b.g0.a.z1.b.i("460", hashMap);
                            }
                            d.b.g0.p.d.a(cursor);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    closeable2 = closeable;
                    d.b.g0.p.d.a(closeable2);
                    throw th;
                }
            } catch (RuntimeException unused2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.b.g0.p.d.a(closeable2);
                throw th;
            }
            d.b.g0.p.d.a(cursor);
        }
    }

    public static void r(d.b.g0.a.u1.a aVar) {
        if (aVar != null) {
            f47033h.add(aVar);
        }
    }

    public static void s(Context context) {
        f47030e = context.getPackageManager();
        Handler handler = new Handler(Looper.getMainLooper());
        f47029d = context.getContentResolver();
        f47028c = new a(handler, handler);
        if (p(context)) {
            f47029d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f47028c);
        }
    }

    public static boolean t() {
        return System.currentTimeMillis() - f47032g <= 1000;
    }

    public static void u(d.b.g0.a.u1.a aVar) {
        if (aVar != null) {
            f47033h.remove(aVar);
        }
    }
}
