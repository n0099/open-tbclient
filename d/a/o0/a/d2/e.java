package d.a.o0.a.d2;

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
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.g1.g;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44463a;

    /* renamed from: b  reason: collision with root package name */
    public static long f44464b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f44465c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f44466d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f44467e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44468f;

    /* renamed from: g  reason: collision with root package name */
    public static long f44469g;

    /* renamed from: h  reason: collision with root package name */
    public static List<d.a.o0.a.d2.c> f44470h;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f44471i;
    public static int j;
    public static Uri k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f44472a;

        /* renamed from: d.a.o0.a.d2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0671a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f44473e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f44474f;

            public RunnableC0671a(a aVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44474f = aVar;
                this.f44473e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e.q(this.f44474f.f44472a, this.f44473e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, handler2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44472a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                super.onChange(z, uri);
                if (e.f44463a) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                ExecutorUtilsExt.postOnElastic(new RunnableC0671a(this, uri), "systemScreenShot", 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").F();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f44476f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ C0672e f44477g;

        public c(String str, Handler handler, C0672e c0672e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, handler, c0672e};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44475e = str;
            this.f44476f = handler;
            this.f44477g = c0672e;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.e();
                if (e.f44463a) {
                    Log.d("SYSTEM_SCREENSHOT", "mCount: " + e.j);
                }
                long j = d.a.o0.a.v2.d.a() ? 500L : 100L;
                if (e.m(this.f44475e, e.k) || e.j > 10) {
                    if (e.m(this.f44475e, e.k) && e.l() && !e.o(this.f44475e, e.k)) {
                        for (d.a.o0.a.d2.c cVar : e.f44470h) {
                            if (cVar != null) {
                                cVar.a(this.f44477g);
                            }
                        }
                        return;
                    }
                    return;
                }
                this.f44476f.postDelayed(e.f44471i, j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static String f44478a;

        /* renamed from: b  reason: collision with root package name */
        public static String[] f44479b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1249392576, "Ld/a/o0/a/d2/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1249392576, "Ld/a/o0/a/d2/e$d;");
                    return;
                }
            }
            f44478a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            f44479b = new String[]{"_display_name", "_data", "date_added", "_id"};
        }

        public static boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str != null && (str.toLowerCase().contains(StatisticConstants.SCREENSHOT) || str.contains("截屏") || str.contains("截图")) : invokeL.booleanValue;
        }

        public static boolean f(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? Math.abs(j - j2) <= 10 : invokeCommon.booleanValue;
        }
    }

    /* renamed from: d.a.o0.a.d2.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0672e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f44480a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f44481b;

        public /* synthetic */ C0672e(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public C0672e(String str, Long l, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44480a = str;
            l.longValue();
            this.f44481b = uri;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(506327488, "Ld/a/o0/a/d2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(506327488, "Ld/a/o0/a/d2/e;");
                return;
            }
        }
        f44463a = k.f46335a;
        f44469g = System.currentTimeMillis() - 10000;
        f44470h = new ArrayList();
        j = 0;
        l = null;
        m = null;
    }

    public static /* synthetic */ int e() {
        int i2 = j;
        j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(f44466d, uri);
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
        return invokeL.doubleValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return invokeV.intValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!d.a.o0.a.v2.d.a()) {
                return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
            }
            Uri uri = k;
            return uri == null || TextUtils.equals(l, uri.toString());
        }
        return invokeL.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return g.a().b() && System.currentTimeMillis() - f44464b > 2000;
        }
        return invokeV.booleanValue;
    }

    public static boolean m(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, uri)) == null) {
            if (d.a.o0.a.v2.d.a()) {
                return n(uri);
            }
            new BitmapFactory.Options().inJustDecodeBounds = true;
            return BitmapFactory.decodeFile(str) != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean n(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                return MediaStore.Images.Media.getBitmap(f44466d, uri) != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, uri)) == null) {
            Point point = new Point();
            WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int j2 = point.y + j();
            int i2 = point.x;
            double d2 = (i2 != 0 ? j2 / (i2 * 1.0d) : 0.0d) * 1.2d;
            double i3 = d.a.o0.a.v2.d.a() ? i(uri) : 0.0d;
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
        return invokeLL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? Build.VERSION.SDK_INT < 23 || d.a.o0.o.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 : invokeL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0157: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:44:0x0157 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, handler, uri) == null) {
            if (uri.toString().matches(d.f44478a + ".*")) {
                if (t() && f44468f) {
                    f44469g = System.currentTimeMillis();
                    return;
                }
                j = 0;
                f44469g = System.currentTimeMillis();
                Closeable closeable2 = null;
                try {
                    try {
                        cursor = f44466d.query(uri, d.f44479b, null, null, "date_added DESC");
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                                    long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                                    k = uri;
                                    if (d.a.o0.a.v2.d.a()) {
                                        k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                    }
                                    if (f44463a) {
                                        Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                        Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j2);
                                        Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis);
                                        Log.d("SYSTEM_SCREENSHOT", "imageUri: " + k.toString());
                                    }
                                    if (k(string)) {
                                        d.a.o0.t.d.d(cursor);
                                        return;
                                    }
                                    l = k.toString();
                                    m = string;
                                    if (d.e(string) && d.f(currentTimeMillis, j2)) {
                                        f44468f = true;
                                        c cVar = new c(string, handler, new C0672e(string, Long.valueOf(j2), k, null));
                                        f44471i = cVar;
                                        handler.post(cVar);
                                    } else {
                                        f44468f = false;
                                    }
                                }
                            } catch (RuntimeException unused) {
                                if (f44467e != null) {
                                    List<ProviderInfo> queryContentProviders = f44467e.queryContentProviders(null, 0, 131072);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("from", "SystemScreenshot");
                                    hashMap.put("page", "SystemScreenshot");
                                    hashMap.put("ext", queryContentProviders.toString());
                                    d.a.o0.a.j2.b.j("460", hashMap);
                                }
                                d.a.o0.t.d.d(cursor);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        d.a.o0.t.d.d(closeable2);
                        throw th;
                    }
                } catch (RuntimeException unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.o0.t.d.d(closeable2);
                    throw th;
                }
                d.a.o0.t.d.d(cursor);
            }
        }
    }

    public static void r(d.a.o0.a.d2.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, cVar) == null) || cVar == null) {
            return;
        }
        f44470h.add(cVar);
    }

    public static void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            f44467e = context.getPackageManager();
            Handler handler = new Handler(Looper.getMainLooper());
            f44466d = context.getContentResolver();
            f44465c = new a(handler, handler);
            if (p(context)) {
                f44466d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f44465c);
            } else if (f44463a && q0.G()) {
                q0.b0(new b());
            }
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? System.currentTimeMillis() - f44469g <= 1000 : invokeV.booleanValue;
    }

    public static void u(d.a.o0.a.d2.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, cVar) == null) || cVar == null) {
            return;
        }
        f44470h.remove(cVar);
    }
}
