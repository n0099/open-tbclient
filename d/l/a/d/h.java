package d.l.a.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import com.sina.weibo.sdk.constant.WBConstants;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.v;
import d.l.a.d.b.c;
import d.l.a.d.c;
import d.l.a.d.d;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.g;
import d.l.a.e.a.j;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static volatile h f74462f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.l.a.a.a.b f74463a;

    /* renamed from: b  reason: collision with root package name */
    public final d.l.a.d.g f74464b;

    /* renamed from: c  reason: collision with root package name */
    public final d.l.a.b.a.b f74465c;

    /* renamed from: d  reason: collision with root package name */
    public d.l.a.b.a.d f74466d;

    /* renamed from: e  reason: collision with root package name */
    public long f74467e;

    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f74468e;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74468e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h unused = h.f74462f = new h(this.f74468e, null);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f74470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f74471g;

        public b(h hVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74471g = hVar;
            this.f74469e = str;
            this.f74470f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74471g.s().m(this.f74469e, this.f74470f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f74472e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f74473f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.e f74474g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f74475h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f74476i;

        public c(h hVar, Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, context, Integer.valueOf(i2), eVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74476i = hVar;
            this.f74472e = context;
            this.f74473f = i2;
            this.f74474g = eVar;
            this.f74475h = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74476i.s().d(this.f74472e, this.f74473f, this.f74474g, this.f74475h);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f74478f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f74479g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74480h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74481i;
        public final /* synthetic */ v j;
        public final /* synthetic */ d.l.a.a.a.c.n k;
        public final /* synthetic */ h l;

        public d(h hVar, String str, long j, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, v vVar, d.l.a.a.a.c.n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Long.valueOf(j), Integer.valueOf(i2), cVar, bVar, vVar, nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f74477e = str;
            this.f74478f = j;
            this.f74479g = i2;
            this.f74480h = cVar;
            this.f74481i = bVar;
            this.j = vVar;
            this.k = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.l.s().l(this.f74477e, this.f74478f, this.f74479g, this.f74480h, this.f74481i, this.j, this.k);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f74483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f74484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.c f74485h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.b f74486i;
        public final /* synthetic */ h j;

        public e(h hVar, String str, long j, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Long.valueOf(j), Integer.valueOf(i2), cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = hVar;
            this.f74482e = str;
            this.f74483f = j;
            this.f74484g = i2;
            this.f74485h = cVar;
            this.f74486i = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.s().k(this.f74482e, this.f74483f, this.f74484g, this.f74485h, this.f74486i);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f74487e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f74488f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h f74489g;

        public f(h hVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74489g = hVar;
            this.f74487e = str;
            this.f74488f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f74489g.s().j(this.f74487e, this.f74488f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
                    d.l.a.e.a.h.e.k();
                    g.g();
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b implements InvocationHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public Object f74490e;

            public /* synthetic */ b(Object obj, a aVar) {
                this(obj);
            }

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                InterceptResult invokeLLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                    try {
                        if (WBConstants.SHARE_START_ACTIVITY.contains(method.getName())) {
                            g.d(objArr);
                        }
                    } catch (Throwable unused) {
                    }
                    return method.invoke(this.f74490e, objArr);
                }
                return invokeLLL.objValue;
            }

            public b(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {obj};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74490e = obj;
            }
        }

        public static int a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
                if (TextUtils.isEmpty(str2)) {
                    return 5;
                }
                return d.l.a.c.c.a(str, new File(str2));
            }
            return invokeLL.intValue;
        }

        public static String b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return d.l.a.c.c.f(new File(str));
            }
            return (String) invokeL.objValue;
        }

        public static void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65538, null) == null) && d.l.a.d.b.l.v().optInt("hook", 0) == 1) {
                d.l.a.d.e.a().c(new a(), 10000L);
            }
        }

        public static void d(Object[] objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, objArr) == null) {
                if (d.l.a.d.b.l.v().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
                    Intent intent = (Intent) objArr[2];
                    if ("android.intent.action.VIEW".equals(intent.getAction()) && d.l.a.e.b.d.c.f74684a.equals(intent.getType())) {
                        if (d.l.a.e.a.h.e.f()) {
                            String optString = d.l.a.d.b.l.v().optString("hook_vivo_arg", "com.android.settings");
                            if (StringUtil.NULL_STRING.equals(optString)) {
                                return;
                            }
                            objArr[1] = optString;
                        } else if (d.l.a.e.a.h.e.h()) {
                            JSONObject v = d.l.a.d.b.l.v();
                            String optString2 = v.optString("hook_kllk_arg1", "com." + d.l.a.e.b.d.c.f74686c + ".market");
                            if (!StringUtil.NULL_STRING.equals(optString2)) {
                                objArr[1] = optString2;
                            }
                            String optString3 = d.l.a.d.b.l.v().optString("hook_kllk_arg2", "com.android.browser");
                            JSONObject v2 = d.l.a.d.b.l.v();
                            String optString4 = v2.optString("hook_kllk_arg3", "m.store." + d.l.a.e.b.d.c.f74686c + "mobile.com");
                            StringBuilder sb = new StringBuilder();
                            sb.append(d.l.a.e.b.d.c.f74686c);
                            sb.append("_extra_pkg_name");
                            intent.putExtra(sb.toString(), optString3);
                            intent.putExtra("refererHost", optString4);
                            if (d.l.a.d.b.l.v().optInt("hook_kllk_arg4", 0) == 1) {
                                Intent intent2 = new Intent();
                                intent2.putExtra(d.l.a.e.b.d.c.f74686c + "_extra_pkg_name", optString3);
                                intent2.putExtra("refererHost", optString4);
                                intent.putExtra("android.intent.extra.INTENT", intent2);
                            }
                        } else if (d.l.a.e.a.h.e.a()) {
                            String optString5 = d.l.a.d.b.l.v().optString("hook_huawei_arg1", "com.huawei.appmarket");
                            if (!StringUtil.NULL_STRING.equals(optString5)) {
                                objArr[1] = optString5;
                            }
                            intent.putExtra("caller_package", d.l.a.d.b.l.v().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                        }
                    }
                }
            }
        }

        public static String e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    ApplicationInfo applicationInfo = d.l.a.d.b.l.a().getPackageManager().getApplicationInfo(str, 0);
                    if (applicationInfo != null) {
                        return applicationInfo.sourceDir;
                    }
                } catch (Exception unused) {
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public static void g() {
            Field declaredField;
            Class<?> cls;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
                try {
                    if (Build.VERSION.SDK_INT < 26) {
                        declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
                    } else {
                        declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
                    }
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(null);
                    Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(obj);
                    if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                        return;
                    }
                    declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new b(obj2, null)));
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: d.l.a.d.h$h  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C2065h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f74491a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.l.a.d.h$h$a */
        /* loaded from: classes10.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* renamed from: d.l.a.d.h$h$b */
        /* loaded from: classes10.dex */
        public static class b {
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

            public abstract <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr);

            public /* synthetic */ b(a aVar) {
                this();
            }
        }

        @TargetApi(11)
        /* renamed from: d.l.a.d.h$h$c */
        /* loaded from: classes10.dex */
        public static class c extends b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c() {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // d.l.a.d.h.C2065h.b
            public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048576, this, asyncTask, tArr) == null) {
                    try {
                        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
                    } catch (Throwable unused) {
                    }
                }
            }

            public /* synthetic */ c(a aVar) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(768941538, "Ld/l/a/d/h$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(768941538, "Ld/l/a/d/h$h;");
                    return;
                }
            }
            f74491a = new c(null);
        }

        public static <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, asyncTask, tArr) == null) {
                f74491a.a(asyncTask, tArr);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i<P, R> implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public P f74492e;

        /* renamed from: f  reason: collision with root package name */
        public R f74493f;

        /* renamed from: g  reason: collision with root package name */
        public int f74494g;

        /* renamed from: h  reason: collision with root package name */
        public SoftReference<a<P, R>> f74495h;

        /* renamed from: i  reason: collision with root package name */
        public i<?, P> f74496i;
        public i<R, ?> j;

        /* loaded from: classes10.dex */
        public interface a<PARAM, RESULT> {
            RESULT a(PARAM param);
        }

        public i(int i2, a<P, R> aVar, P p) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), aVar, p};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74494g = i2;
            this.f74495h = new SoftReference<>(aVar);
            this.f74492e = p;
        }

        public static <P, R> i<P, R> c(a<P, R> aVar, P p) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, p)) == null) ? new i<>(2, aVar, p) : (i) invokeLL.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: d.l.a.d.h$i<P, R> */
        /* JADX WARN: Multi-variable type inference failed */
        public <NR> i<R, NR> a(int i2, a<R, NR> aVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, aVar)) == null) {
                i iVar = (i<R, ?>) new i(i2, aVar, null);
                this.j = iVar;
                iVar.f74496i = this;
                return iVar;
            }
            return (i) invokeIL.objValue;
        }

        public <NR> i<R, NR> b(a<R, NR> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? a(0, aVar) : (i) invokeL.objValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                i<?, P> iVar = this.f74496i;
                if (iVar != null) {
                    iVar.d();
                } else {
                    run();
                }
            }
        }

        public final R e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f74493f : (R) invokeV.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            i<?, P> iVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                if (this.f74494g == 0 && !r.r()) {
                    d.l.a.d.g.b().n().post(this);
                } else if (this.f74494g == 1 && r.r()) {
                    d.l.a.d.e.a().b(this);
                } else if (this.f74494g == 2 && r.r()) {
                    d.l.a.d.e.a().f(this);
                } else {
                    if (this.f74492e == null && (iVar = this.f74496i) != null) {
                        this.f74492e = iVar.e();
                    }
                    a<P, R> aVar = this.f74495h.get();
                    if (aVar == null) {
                        return;
                    }
                    this.f74493f = aVar.a(this.f74492e);
                    i<R, ?> iVar2 = this.j;
                    if (iVar2 != null) {
                        iVar2.run();
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str, String str2, boolean z, String str3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, Boolean.valueOf(z), str3})) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("extra", str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("notification_jump_url", str2);
                    }
                    jSONObject.put("show_toast", z);
                    jSONObject.put(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, str3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeCommon.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static double a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).a("clean_min_install_size", 0.0d) : invokeI.doubleValue;
        }

        public static int b(@NonNull d.l.a.e.b.j.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) ? aVar.b("external_storage_permission_path_type", 0) : invokeL.intValue;
        }

        @NonNull
        public static d.l.a.e.b.j.a c(d.l.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
                if (aVar == null) {
                    return d.l.a.e.b.j.a.r();
                }
                if (aVar.s() != 0) {
                    return d.l.a.e.b.j.a.d(aVar.s());
                }
                if (aVar.c()) {
                    return d.l.a.e.b.j.a.g(d());
                }
                if (aVar.r() != null) {
                    return d.l.a.e.b.j.a.g(aVar.r());
                }
                return d.l.a.e.b.j.a.r();
            }
            return (d.l.a.e.b.j.a) invokeL.objValue;
        }

        @Nullable
        public static JSONObject d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.l.a.d.b.l.v().optJSONObject("ad") : (JSONObject) invokeV.objValue;
        }

        public static JSONObject e(d.l.a.a.a.d.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, dVar)) == null) {
                if (dVar == null) {
                    return null;
                }
                if (dVar.t()) {
                    return d();
                }
                return dVar.p();
            }
            return (JSONObject) invokeL.objValue;
        }

        public static long f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).c("storage_min_size", 0L) : invokeI.longValue;
        }

        @NonNull
        public static d.l.a.e.b.j.a g(d.l.a.a.a.d.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, dVar)) == null) ? d.l.a.e.b.j.a.g(e(dVar)) : (d.l.a.e.b.j.a) invokeL.objValue;
        }

        public static boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.l.a.e.b.j.a.r().l("fix_notification_anr") : invokeV.booleanValue;
        }

        public static boolean i(d.l.a.b.a.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) ? c(aVar).b("pause_reserve_on_wifi", 0) == 1 && aVar.q() : invokeL.booleanValue;
        }

        public static boolean j(d.l.a.e.b.j.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aVar)) == null) ? aVar != null && aVar.b("kllk_need_rename_apk", 0) == 1 : invokeL.booleanValue;
        }

        public static int k(@NonNull d.l.a.a.a.d.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, dVar)) == null) ? b(g(dVar)) : invokeL.intValue;
        }

        public static long l(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).c("clean_fetch_apk_head_time_out", 800L) : invokeI.longValue;
        }

        public static boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? d.l.a.d.b.l.v().optInt("is_enable_start_install_again") == 1 : invokeV.booleanValue;
        }

        public static long n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
                long optLong = d.l.a.d.b.l.v().optLong("start_install_interval");
                if (optLong == 0) {
                    return 300000L;
                }
                return optLong;
            }
            return invokeV.longValue;
        }

        public static boolean o(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).c("clean_fetch_apk_switch", 0L) == 1 : invokeI.booleanValue;
        }

        public static long p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
                long optLong = d.l.a.d.b.l.v().optLong("next_install_min_interval");
                if (optLong == 0) {
                    return 10000L;
                }
                return optLong;
            }
            return invokeV.longValue;
        }

        public static boolean q(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).c("clean_space_before_download_switch", 0L) == 1 : invokeI.booleanValue;
        }

        public static boolean r(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("clean_space_switch", 0) == 1 : invokeI.booleanValue;
        }

        public static boolean s(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) ? d.l.a.e.b.j.a.d(i2).b("clean_app_cache_dir", 0) == 1 : invokeI.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static JSONObject a(@NonNull JSONObject jSONObject, d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jSONObject, aVar)) == null) {
                r.q(jSONObject, "open_url", r.m(aVar.f(), "open_url_not_exist"));
                return jSONObject;
            }
            return (JSONObject) invokeLL.objValue;
        }

        public static void b(d.l.a.b.a.c.b bVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65537, null, bVar, jSONObject) == null) || jSONObject == null || bVar == null) {
                return;
            }
            try {
                jSONObject.put("is_patch_apply_handled", bVar.U() ? 1 : 0);
                jSONObject.put("origin_mime_type", bVar.T());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, downloadInfo, jSONObject) == null) {
                try {
                    g(downloadInfo, jSONObject);
                    d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                    if (c2 == null) {
                        return;
                    }
                    jSONObject.put("is_update_download", c2.S() ? 1 : 2);
                    b(c2, jSONObject);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public static void d(JSONObject jSONObject, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(65539, null, jSONObject, i2) == null) || jSONObject == null) {
                return;
            }
            JSONArray v = d.l.a.e.b.j.a.d(i2).v("ah_report_config");
            if (v != null) {
                for (int i3 = 0; i3 < v.length(); i3++) {
                    try {
                        String string = v.getString(i3);
                        j.a a2 = d.l.a.e.a.h.b.a(string);
                        if (a2 != null) {
                            String replaceAll = string.replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "_");
                            jSONObject.put(replaceAll, a2.m() + "_" + a2.n());
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                jSONObject.put("is_unknown_source_enabled", d.l.a.e.a.c.l(d.l.a.e.b.g.e.n()) ? 1 : 2);
            } catch (Throwable unused) {
            }
        }

        public static JSONObject e(@NonNull JSONObject jSONObject, d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, jSONObject, aVar)) == null) {
                r.q(jSONObject, d.l.a.e.a.h.e.m().replaceAll(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, "_"), Integer.valueOf(r.y(d.l.a.d.b.l.a(), d.l.a.e.a.h.e.m())));
                return jSONObject;
            }
            return (JSONObject) invokeLL.objValue;
        }

        public static void f(DownloadInfo downloadInfo, JSONObject jSONObject) {
            d.l.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, downloadInfo, jSONObject) == null) || jSONObject == null || (c2 = c.g.e().c(downloadInfo)) == null) {
                return;
            }
            try {
                g(downloadInfo, jSONObject);
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - c2.Q()));
                jSONObject.putOpt("click_download_size", Long.valueOf(c2.R()));
                jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
                c2.x();
                c.j.b().c(c2);
                jSONObject.put("click_pause_times", c2.m1());
                long totalBytes = downloadInfo.getTotalBytes();
                long curBytes = downloadInfo.getCurBytes();
                jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
                jSONObject.put("download_status", downloadInfo.getRealStatus());
                long currentTimeMillis = System.currentTimeMillis();
                long E = c2.E();
                if (E > 0) {
                    jSONObject.put("time_from_start_download", currentTimeMillis - E);
                }
                long y = c2.y();
                if (y > 0) {
                    jSONObject.put("time_from_download_resume", currentTimeMillis - y);
                }
                jSONObject.putOpt("fail_status", Integer.valueOf(c2.B()));
                jSONObject.putOpt("fail_msg", c2.C());
                jSONObject.put("download_failed_times", c2.k1());
                jSONObject.put("can_show_notification", d.l.a.e.a.f.c.d() ? 1 : 2);
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void g(DownloadInfo downloadInfo, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, downloadInfo, jSONObject) == null) {
                if (downloadInfo != null) {
                    try {
                        jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                        jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                        jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                        jSONObject.putOpt("app_name", downloadInfo.getTitle());
                        jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                        jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                        jSONObject.putOpt("file_name", downloadInfo.getName());
                        jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                        d.l.a.b.a.c.b b2 = c.g.e().b(downloadInfo.getId());
                        if (b2 != null) {
                            jSONObject.putOpt("click_download_time", Long.valueOf(b2.Q()));
                            jSONObject.putOpt("click_download_size", Long.valueOf(b2.R()));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                int i2 = 1;
                jSONObject.putOpt("permission_notification", Integer.valueOf(d.l.a.e.a.f.c.d() ? 1 : 2));
                jSONObject.putOpt("network_available", Integer.valueOf(d.l.a.e.b.l.f.r0(d.l.a.d.b.l.a()) ? 1 : 2));
                if (!d.l.a.e.b.l.f.g0(d.l.a.d.b.l.a())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_is_wifi", Integer.valueOf(i2));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static long a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
                if (file == null || !file.exists()) {
                    return 0L;
                }
                return b(file, file.lastModified(), 0);
            }
            return invokeL.longValue;
        }

        public static long b(File file, long j, int i2) {
            InterceptResult invokeCommon;
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{file, Long.valueOf(j), Integer.valueOf(i2)})) == null) {
                if (file != null && file.exists()) {
                    j = Math.max(j, file.lastModified());
                    int i3 = i2 + 1;
                    if (i3 >= 50) {
                        return j;
                    }
                    if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                        for (File file2 : listFiles) {
                            j = Math.max(j, b(file2, j, i3));
                        }
                    }
                }
                return j;
            }
            return invokeCommon.longValue;
        }
    }

    /* loaded from: classes10.dex */
    public class n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f74497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f74498f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.f f74499g;

            /* renamed from: d.l.a.d.h$n$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public class C2066a implements d.l.a.a.a.c.r {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f74500a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ JSONObject f74501b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f74502c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f74503d;

                public C2066a(a aVar, JSONObject jSONObject, JSONObject jSONObject2, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, jSONObject, jSONObject2, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74503d = aVar;
                    this.f74500a = jSONObject;
                    this.f74501b = jSONObject2;
                    this.f74502c = str;
                }

                @Override // d.l.a.a.a.c.r
                public void a(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                        a aVar = this.f74503d;
                        n.r(aVar.f74498f, aVar.f74497e, str, aVar.f74499g, this.f74500a, this.f74501b, this.f74502c);
                    }
                }

                @Override // d.l.a.a.a.c.r
                public void a(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        Context context = this.f74503d.f74498f;
                        c.d.b(n.a(context, Uri.parse("market://details?id=" + this.f74503d.f74497e)), this.f74503d.f74499g, true);
                        r.q(this.f74500a, "ttdownloader_message", th != null ? th.getMessage() : StringUtil.NULL_STRING);
                        n.s(this.f74503d.f74499g, this.f74500a, 4, 1);
                    }
                }
            }

            public a(String str, Context context, c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, context, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74497e = str;
                this.f74498f = context;
                this.f74499g = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    JSONObject v = d.l.a.d.b.l.v();
                    String optString = v.optString("s");
                    JSONObject jSONObject = new JSONObject();
                    String b2 = d.l.a.e.a.h.d.b(v.optString("x"), optString);
                    JSONObject jSONObject2 = new JSONObject();
                    r.q(jSONObject2, "p", this.f74497e);
                    r.q(jSONObject2, "i", Build.VERSION.INCREMENTAL);
                    r.q(jSONObject2, "m", Build.MODEL);
                    r.q(jSONObject2, "im", d.l.a.d.a$h.b.b(this.f74498f));
                    r.q(jSONObject2, "d", d.l.a.d.a$h.b.d(this.f74498f));
                    r.q(jSONObject2, "t", "m");
                    byte[] bytes = jSONObject2.toString().getBytes();
                    d.l.a.d.b.l.q().a(b2, d.l.a.d.b.l.D().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new C2066a(this, jSONObject, v, optString));
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f74504e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f74505f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.f f74506g;

            public b(Context context, String str, c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, str, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74504e = context;
                this.f74505f = str;
                this.f74506g = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    Context context = this.f74504e;
                    c.d.b(n.a(context, Uri.parse("market://details?id=" + this.f74505f)), this.f74506g, true);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject v = d.l.a.d.b.l.v();
                        Thread.sleep(v.optInt("m2_delay_millis", 1000));
                        d.l.a.d.a$i.a.b().e(this.f74504e, true);
                        com.ss.android.downloadlib.a.b.b bVar = new com.ss.android.downloadlib.a.b.b();
                        bVar.f41290a = 1;
                        bVar.f41291b = 0;
                        bVar.f41292c = String.format(d.l.a.e.a.h.d.b(v.optString("v"), v.optString("s")), this.f74505f);
                        d.l.a.d.a$i.a.b().c(bVar, null);
                        d.l.a.d.a$i.a.b().f();
                        n.s(this.f74506g, jSONObject, -1, 2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        n.s(this.f74506g, jSONObject, 1, 2);
                    }
                }
            }
        }

        /* loaded from: classes10.dex */
        public static class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f74507e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Context f74508f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ c.f f74509g;

            /* loaded from: classes10.dex */
            public class a implements d.l.a.a.a.c.r {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ JSONObject f74510a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f74511b;

                public a(c cVar, JSONObject jSONObject) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {cVar, jSONObject};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f74511b = cVar;
                    this.f74510a = jSONObject;
                }

                @Override // d.l.a.a.a.c.r
                public void a(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                        c cVar = this.f74511b;
                        n.q(cVar.f74508f, cVar.f74507e, str, cVar.f74509g, this.f74510a);
                    }
                }

                @Override // d.l.a.a.a.c.r
                public void a(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        Context context = this.f74511b.f74508f;
                        c.d.b(n.a(context, Uri.parse("market://details?id=" + this.f74511b.f74507e)), this.f74511b.f74509g, true);
                        r.q(this.f74510a, "ttdownloader_message", th != null ? th.getMessage() : StringUtil.NULL_STRING);
                        n.s(this.f74511b.f74509g, this.f74510a, 7, 5);
                    }
                }
            }

            public c(String str, Context context, c.f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, context, fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f74507e = str;
                this.f74508f = context;
                this.f74509g = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    JSONObject v = d.l.a.d.b.l.v();
                    String optString = v.optString("s");
                    JSONObject jSONObject = new JSONObject();
                    String b2 = d.l.a.e.a.h.d.b(v.optString("x"), optString);
                    JSONObject jSONObject2 = new JSONObject();
                    r.q(jSONObject2, "t", "v");
                    r.q(jSONObject2, "p", this.f74507e);
                    byte[] bytes = jSONObject2.toString().getBytes();
                    d.l.a.d.b.l.q().a(b2, d.l.a.d.b.l.D().a(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new a(this, jSONObject));
                }
            }
        }

        public static c.h a(Context context, Uri uri) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, uri)) == null) {
                if (context != null && uri != null && "market".equals(uri.getScheme())) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", uri);
                        if (!r.t(context, intent)) {
                            return new c.h(6, 13);
                        }
                        String m = d.l.a.e.a.h.e.m();
                        if (r.G(context, m) && !d.l.a.e.a.h.e.j()) {
                            intent.setPackage(m);
                        }
                        if (d.l.a.e.b.j.a.r().l("fix_jump_market")) {
                            intent.addFlags(335544320);
                        } else if (!(context instanceof Activity)) {
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                        }
                        intent.putExtra("start_only_for_android", true);
                        context.startActivity(intent);
                        return new c.h(5);
                    } catch (Exception unused) {
                        return new c.h(6, 14);
                    }
                }
                return new c.h(6, 12);
            }
            return (c.h) invokeLL.objValue;
        }

        public static c.h b(Context context, c.f fVar, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, fVar, str)) == null) {
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (d.l.a.e.a.h.e.j() && r.G(context, "com.sec.android.app.samsungapps")) {
                        return v(context, str);
                    }
                    if (fVar.f74225b.t() && fVar.f74227d.i()) {
                        JSONArray optJSONArray = d.l.a.d.b.l.v().optJSONArray("am_plans");
                        if (d.l.a.e.a.h.e.d() && d.l.a.e.a.h.b.c(optJSONArray, "am_0")) {
                            p(context, fVar, str);
                            return new c.h(7, "am_m1");
                        } else if (d.l.a.e.a.h.e.h() && d.l.a.e.a.h.b.c(optJSONArray, "am_3")) {
                            return t(context, fVar, str);
                        } else {
                            if (d.l.a.e.a.h.e.i() && d.l.a.e.a.h.b.c(optJSONArray, "am_2")) {
                                w(context, fVar, str);
                                return new c.h(7, "am_m2");
                            } else if (d.l.a.e.a.h.e.f() && d.l.a.e.a.h.b.c(optJSONArray, "am_5")) {
                                x(context, fVar, str);
                                return new c.h(7, "am_v1");
                            } else {
                                return a(context, Uri.parse("market://details?id=" + str));
                            }
                        }
                    }
                    return a(context, Uri.parse("market://details?id=" + str));
                }
                return new c.h(6, 11);
            }
            return (c.h) invokeLLL.objValue;
        }

        public static c.h c(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
                if (context != null && !TextUtils.isEmpty(str)) {
                    if (d.l.a.e.a.h.e.j() && r.G(context, "com.sec.android.app.samsungapps")) {
                        return v(context, str);
                    }
                    return a(context, Uri.parse("market://details?id=" + str));
                }
                return new c.h(6, 11);
            }
            return (c.h) invokeLL.objValue;
        }

        public static c.h d(Context context, String str, d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, aVar)) == null) {
                Intent I = r.I(context, str);
                if (I == null) {
                    return new c.h(4, 22);
                }
                if (Build.VERSION.SDK_INT >= 26 && d.l.a.d.b.l.v().optInt("open_package_mode") == 1 && d.l.a.d.b.l.x() != null && d.l.a.d.b.l.x().a() && aVar.q()) {
                    TTDelegateActivity.b(str, aVar);
                    return new c.h(3);
                }
                I.putExtra("start_only_for_android", true);
                try {
                    context.startActivity(I);
                    return new c.h(3);
                } catch (Exception unused) {
                    return new c.h(4, 23);
                }
            }
            return (c.h) invokeLLL.objValue;
        }

        public static c.h e(@NonNull d.l.a.b.a.c.b bVar, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, bVar, str, str2)) == null) {
                c.h o = o(str, bVar);
                return (c.i.c(bVar) && o.a() == 2) ? f(str2, bVar) : o;
            }
            return (c.h) invokeLLL.objValue;
        }

        public static c.h f(String str, d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, aVar)) == null) ? d(d.l.a.d.b.l.a(), str, aVar) : (c.h) invokeLL.objValue;
        }

        public static String g(String str, @NonNull JSONObject jSONObject, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, jSONObject, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String b2 = d.l.a.e.a.h.d.b(jSONObject.optString("g"), str2);
                String b3 = d.l.a.e.a.h.d.b(jSONObject.optString("h"), str2);
                return (TextUtils.isEmpty(b2) || TextUtils.isEmpty(b3)) ? str : str.replace(b2, b3);
            }
            return (String) invokeLLL.objValue;
        }

        public static void h(@NonNull Activity activity, String str, long j, String str2, String str3) {
            JSONObject jSONObject;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{activity, str, Long.valueOf(j), str2, str3}) == null) {
                try {
                    jSONObject = new JSONObject(str3);
                } catch (JSONException unused) {
                    jSONObject = new JSONObject();
                }
                c.f v = c.g.e().v(j);
                try {
                    JSONObject v2 = d.l.a.d.b.l.v();
                    boolean f2 = d.l.a.e.a.h.b.f(v2, activity, d.l.a.e.a.h.d.b(v2.optString("bg"), v2.optString("s")));
                    HashMap<String, String> z = r.z(new JSONObject(str2));
                    if (f2 && !z.isEmpty() && m(activity, str, z)) {
                        s(v, jSONObject, -1, 5);
                        c.d.e("am_v1", jSONObject, v, true);
                        return;
                    }
                    if (f2) {
                        i2 = z.isEmpty() ? 1 : 2;
                    } else {
                        i2 = 3;
                    }
                    s(v, jSONObject, i2, 5);
                    c.d.b(a(activity, Uri.parse("market://details?id=" + str)), v, true);
                } catch (Exception unused2) {
                    Context a2 = d.l.a.d.b.l.a();
                    c.d.b(a(a2, Uri.parse("market://details?id=" + str)), v, true);
                    s(v, jSONObject, 4, 5);
                }
            }
        }

        public static void i(Context context, String str, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                JSONObject jSONObject = new JSONObject();
                c.f v = c.g.e().v(j);
                try {
                    JSONObject v2 = d.l.a.d.b.l.v();
                    String optString = v2.optString("s");
                    String b2 = d.l.a.e.a.h.d.b(v2.optString("aa"), optString);
                    String b3 = d.l.a.e.a.h.d.b(v2.optString("ac"), optString);
                    String b4 = d.l.a.e.a.h.d.b(v2.optString("af"), optString);
                    boolean f2 = d.l.a.e.a.h.b.f(v2, context, b3);
                    StringBuilder sb = new StringBuilder(String.format(b2, str, b4, b3));
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String m = d.l.a.e.a.h.e.m();
                    if (r.G(context, m)) {
                        intent.setPackage(m);
                    }
                    if (z) {
                        sb.append(d.l.a.e.a.h.d.b(v2.optString("ae"), optString));
                    } else {
                        intent.addFlags(335544320);
                    }
                    r.q(jSONObject, "mf", Boolean.valueOf(f2));
                    r.q(jSONObject, "if", Boolean.valueOf(z));
                    intent.setData(Uri.parse(sb.toString()));
                    intent.putExtra("start_only_for_android", true);
                    context.startActivity(intent);
                    c.d.e("am_kllk2", jSONObject, v, true);
                    if (f2) {
                        s(v, jSONObject, -1, 3);
                    } else {
                        s(v, jSONObject, 3, 3);
                    }
                } catch (Exception unused) {
                    Context a2 = d.l.a.d.b.l.a();
                    c.d.b(a(a2, Uri.parse("market://details?id=" + str)), v, true);
                    s(v, jSONObject, 2, 3);
                }
            }
        }

        public static boolean m(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, activity, str, hashMap)) == null) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("market://details?id=" + str));
                intent.putExtra("start_only_for_android", true);
                intent.putExtra("param", hashMap);
                String m = d.l.a.e.a.h.e.m();
                if (r.G(d.l.a.d.b.l.a(), m)) {
                    intent.setPackage(m);
                }
                if (r.t(d.l.a.d.b.l.a(), intent)) {
                    try {
                        activity.startActivity(intent);
                        return true;
                    } catch (Exception e2) {
                        f.e.b().a(e2, "start v1");
                        return false;
                    }
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        public static c.h n(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return new c.h(4, 11);
                }
                if (context == null) {
                    context = d.l.a.d.b.l.a();
                }
                Intent I = r.I(context, str);
                if (I == null) {
                    return new c.h(4, 22);
                }
                I.putExtra("start_only_for_android", true);
                try {
                    context.startActivity(I);
                    return new c.h(3);
                } catch (Exception unused) {
                    return new c.h(4, 23);
                }
            }
            return (c.h) invokeLL.objValue;
        }

        public static c.h o(String str, @NonNull d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, aVar)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return new c.h(2, 21);
                }
                Context a2 = d.l.a.d.b.l.a();
                Uri parse = Uri.parse(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.putExtra("open_url", str);
                intent.putExtra("start_only_for_android", true);
                if (d.l.a.e.b.j.a.r().l("fix_app_link_flag")) {
                    intent.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                }
                if (r.B(a2, intent)) {
                    if (d.l.a.d.b.l.v().optInt("open_url_mode") == 0 && d.l.a.d.b.l.x() != null && d.l.a.d.b.l.x().a() && Build.VERSION.SDK_INT >= 26 && aVar.q()) {
                        TTDelegateActivity.a(str, aVar);
                    } else {
                        try {
                            d.l.a.d.b.l.a().startActivity(intent);
                        } catch (Exception unused) {
                            return new c.h(2);
                        }
                    }
                    return new c.h(1);
                }
                return new c.h(2, 24);
            }
            return (c.h) invokeLL.objValue;
        }

        public static void p(Context context, c.f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65551, null, context, fVar, str) == null) {
                d.l.a.d.e.a().b(new a(str, context, fVar));
            }
        }

        public static void q(Context context, String str, String str2, @NonNull c.f fVar, @NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLLL(65552, null, context, str, str2, fVar, jSONObject) == null) {
                r.q(jSONObject, "ttdownloader_type", 5);
                try {
                    String a2 = d.l.a.e.a.h.d.a(new JSONObject(str2).optString("a"));
                    if (!TextUtils.isEmpty(a2)) {
                        TTDelegateActivity.a(str, fVar.f74224a, a2, jSONObject);
                    } else {
                        c.d.b(a(context, Uri.parse("market://details?id=" + str)), fVar, true);
                        s(fVar, jSONObject, 5, 5);
                    }
                } catch (Exception unused) {
                    c.d.b(a(context, Uri.parse("market://details?id=" + str)), fVar, true);
                    s(fVar, jSONObject, 6, 5);
                }
            }
        }

        public static void r(Context context, String str, String str2, @NonNull c.f fVar, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, fVar, jSONObject, jSONObject2, str3}) == null) {
                r.q(jSONObject, "ttdownloader_type", 1);
                try {
                    String g2 = g(d.l.a.e.a.h.d.a(new JSONObject(str2).optString("a")), jSONObject2, str3);
                    r.q(jSONObject, "open_url", g2);
                    if (y(context, g2)) {
                        s(fVar, jSONObject, -1, 1);
                        c.d.e("am_m1", jSONObject, fVar, true);
                    } else {
                        c.d.b(a(context, Uri.parse("market://details?id=" + str)), fVar, true);
                        s(fVar, jSONObject, 2, 1);
                    }
                } catch (Exception unused) {
                    c.d.b(a(context, Uri.parse("market://details?id=" + str)), fVar, true);
                    s(fVar, jSONObject, 3, 1);
                }
            }
        }

        public static void s(c.f fVar, JSONObject jSONObject, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(65554, null, fVar, jSONObject, i2, i3) == null) {
                r.q(jSONObject, "error_code", Integer.valueOf(i2));
                r.q(jSONObject, "ttdownloader_type", Integer.valueOf(i3));
                r.q(jSONObject, d.l.a.e.a.h.e.m(), Integer.valueOf(r.y(d.l.a.d.b.l.a(), d.l.a.e.a.h.e.m())));
                e.c.a().w("am_result", jSONObject, fVar);
            }
        }

        public static c.h t(Context context, c.f fVar, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, context, fVar, str)) == null) {
                Intent intent = new Intent(context, JumpKllkActivity.class);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                intent.putExtra("p", str);
                intent.putExtra("id", fVar.f74224a);
                intent.putExtra("start_only_for_android", true);
                JSONObject jSONObject = new JSONObject();
                try {
                    context.startActivity(intent);
                    return new c.h(7, "am_kllk2");
                } catch (Throwable unused) {
                    s(fVar, jSONObject, 1, 3);
                    return a(context, Uri.parse("market://details?id=" + str));
                }
            }
            return (c.h) invokeLLL.objValue;
        }

        public static boolean u(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
                if (context == null) {
                    return false;
                }
                try {
                    Uri parse = Uri.parse(str);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    intent.putExtra("open_url", str);
                    intent.putExtra("start_only_for_android", true);
                    context.startActivity(intent);
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static c.h v(@NonNull Context context, @NonNull String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
                try {
                    Uri parse = Uri.parse("http://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
                    Intent intent = new Intent();
                    intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
                    intent.setData(parse);
                    if (!(context instanceof Activity)) {
                        intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    }
                    intent.putExtra("start_only_for_android", true);
                    context.startActivity(intent);
                    return new c.h(5);
                } catch (Exception unused) {
                    return new c.h(6, 14);
                }
            }
            return (c.h) invokeLL.objValue;
        }

        public static void w(Context context, c.f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65558, null, context, fVar, str) == null) {
                d.l.a.d.e.a().b(new b(context, str, fVar));
            }
        }

        public static void x(Context context, c.f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65559, null, context, fVar, str) == null) {
                d.l.a.d.e.a().b(new c(str, context, fVar));
            }
        }

        public static boolean y(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
                if (context == null) {
                    context = d.l.a.d.b.l.a();
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW");
                if (!(context instanceof Activity)) {
                    intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    if (d.l.a.e.b.j.a.r().l("fix_app_link_flag")) {
                        intent.addFlags(32768);
                    }
                }
                intent.setData(Uri.parse(str));
                intent.putExtra("start_only_for_android", true);
                String m = d.l.a.e.a.h.e.m();
                if (r.G(d.l.a.d.b.l.a(), m)) {
                    intent.setPackage(m);
                }
                if (r.t(d.l.a.d.b.l.a(), intent)) {
                    try {
                        context.startActivity(intent);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static c.h a(Context context, Uri uri) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, uri)) == null) ? n.a(context, uri) : (c.h) invokeLL.objValue;
        }

        public static c.h b(Context context, c.f fVar, String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, fVar, str)) == null) ? n.b(context, fVar, str) : (c.h) invokeLLL.objValue;
        }

        public static c.h c(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) ? n.c(context, str) : (c.h) invokeLL.objValue;
        }

        public static c.h d(Context context, String str, d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, aVar)) == null) ? n.d(context, str, aVar) : (c.h) invokeLLL.objValue;
        }

        public static c.h e(@NonNull d.l.a.b.a.c.b bVar, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, bVar, str, str2)) == null) ? n.e(bVar, str, str2) : (c.h) invokeLLL.objValue;
        }

        public static c.h f(String str, @NonNull d.l.a.b.a.c.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, aVar)) == null) ? n.o(str, aVar) : (c.h) invokeLL.objValue;
        }

        public static c.h g(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? n.n(context, str) : (c.h) invokeLL.objValue;
        }

        public static boolean h(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? n.u(context, str) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public class p {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, a> f74512a;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public interface a {
            void a();

            void a(String str);
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(768941786, "Ld/l/a/d/h$p;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(768941786, "Ld/l/a/d/h$p;");
                    return;
                }
            }
            f74512a = Collections.synchronizedMap(new HashMap());
        }

        public static void a(String str) {
            a f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str) || (f2 = f(str)) == null) {
                return;
            }
            f2.a();
        }

        public static void b(String str, a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65538, null, str, aVar) == null) || TextUtils.isEmpty(str) || aVar == null) {
                return;
            }
            f74512a.put(str, aVar);
        }

        public static void c(String str, String str2) {
            a f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || TextUtils.isEmpty(str) || (f2 = f(str)) == null) {
                return;
            }
            f2.a(str2);
        }

        public static void d(String[] strArr, a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65540, null, strArr, aVar) == null) || strArr == null || strArr.length <= 0) {
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            b(valueOf, aVar);
            TTDelegateActivity.a(valueOf, strArr);
        }

        public static boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? d.l.a.d.b.l.r().a(d.l.a.d.b.l.a(), str) : invokeL.booleanValue;
        }

        public static a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return f74512a.remove(str);
            }
            return (a) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, str, str2) == null) {
                d(str, str2, null);
            }
        }

        public static void b(String str, String str2, JSONObject jSONObject) {
            d.l.a.a.a.c.j C;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65537, null, str, str2, jSONObject) == null) || (C = d.l.a.d.b.l.C()) == null) {
                return;
            }
            C.a(2, str, str2, jSONObject);
        }

        public static void c(String str, String str2, JSONObject jSONObject) {
            d.l.a.a.a.c.j C;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, jSONObject) == null) || (C = d.l.a.d.b.l.C()) == null) {
                return;
            }
            C.a(3, str, str2, jSONObject);
        }

        public static void d(String str, String str2, JSONObject jSONObject) {
            d.l.a.a.a.c.j C;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, jSONObject) == null) || (C = d.l.a.d.b.l.C()) == null) {
                return;
            }
            C.a(6, str, str2, jSONObject);
        }
    }

    /* loaded from: classes10.dex */
    public class r {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static Object[] f74513a;

        /* renamed from: b  reason: collision with root package name */
        public static Object[] f74514b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(768941848, "Ld/l/a/d/h$r;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(768941848, "Ld/l/a/d/h$r;");
                    return;
                }
            }
            f74513a = new Object[0];
            f74514b = new Object[73];
        }

        @SuppressLint({"MissingPermission"})
        public static void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                try {
                    if (d.l.a.d.b.l.r().a(d.l.a.d.b.l.a(), "android.permission.REORDER_TASKS")) {
                        ActivityManager activityManager = (ActivityManager) d.l.a.d.b.l.a().getSystemService("activity");
                        for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                            if (d.l.a.d.b.l.a().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                                activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                                return;
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public static boolean B(Context context, Intent intent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
                if (intent == null) {
                    return false;
                }
                if (context == null) {
                    context = d.l.a.d.b.l.a();
                }
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                return queryIntentActivities != null && queryIntentActivities.size() > 0;
            }
            return invokeLL.booleanValue;
        }

        public static boolean C(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
                if (bVar == null) {
                    return false;
                }
                return j(bVar.e(), bVar.F(), bVar.G()).b();
            }
            return invokeL.booleanValue;
        }

        public static boolean D(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) ? !TextUtils.isEmpty(str) && new File(str).exists() : invokeL.booleanValue;
        }

        public static Drawable E(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
                if (context != null && !TextUtils.isEmpty(str)) {
                    try {
                        PackageManager packageManager = context.getPackageManager();
                        return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                return null;
            }
            return (Drawable) invokeLL.objValue;
        }

        @WorkerThread
        public static boolean F(String str) {
            InterceptResult invokeL;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
                Context a2 = d.l.a.d.b.l.a();
                if (!TextUtils.isEmpty(str) && G(a2, str)) {
                    int i2 = a2.getApplicationInfo().targetSdkVersion;
                    if (d.l.a.d.b.l.v().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i2 != 29 || Environment.isExternalStorageLegacy()) && i2 <= 29)) {
                        try {
                            if (Build.VERSION.SDK_INT >= 29 && a2.getApplicationInfo().targetSdkVersion >= 29 && d.l.a.d.b.l.v().optInt("get_ext_dir_mode") == 1) {
                                file = L(a2, str);
                            } else {
                                String path = Environment.getExternalStorageDirectory().getPath();
                                file = new File(path, "android/data/" + str);
                            }
                            if (file.exists()) {
                                long a3 = m.a(file);
                                PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(str, 0);
                                if (packageInfo != null) {
                                    if (packageInfo.lastUpdateTime < a3) {
                                        return true;
                                    }
                                }
                                return false;
                            }
                            return false;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    }
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public static boolean G(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
                if (context == null) {
                    context = d.l.a.d.b.l.a();
                }
                if (context == null || TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    return context.getPackageManager().getPackageInfo(str, 0) != null;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static boolean H(Context context, String str) {
            InterceptResult invokeLL;
            PackageInfo packageArchiveInfo;
            PackageInfo packageInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
                if (context == null || str == null || TextUtils.isEmpty(str)) {
                    return false;
                }
                try {
                    File file = new File(str);
                    if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                        return false;
                    }
                    String str2 = packageArchiveInfo.packageName;
                    int i2 = packageArchiveInfo.versionCode;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                    } catch (PackageManager.NameNotFoundException unused) {
                        packageInfo = null;
                    }
                    if (packageInfo == null) {
                        return false;
                    }
                    return i2 <= packageInfo.versionCode;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static Intent I(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage == null) {
                    return null;
                }
                if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
                    launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
                }
                launchIntentForPackage.setPackage(null);
                launchIntentForPackage.addFlags(2097152);
                launchIntentForPackage.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                return launchIntentForPackage;
            }
            return (Intent) invokeLL.objValue;
        }

        public static Signature[] J(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                    if (packageInfo != null) {
                        return packageInfo.signatures;
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (Signature[]) invokeLL.objValue;
        }

        public static Signature[] K(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
                try {
                    PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
                    if (packageArchiveInfo != null) {
                        return packageArchiveInfo.signatures;
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (Signature[]) invokeLL.objValue;
        }

        public static File L(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
                File parentFile = context.getExternalFilesDir(null).getParentFile();
                String parent = parentFile != null ? parentFile.getParent() : null;
                File file = new File(parent + File.separator + str);
                StringBuilder sb = new StringBuilder();
                sb.append("getExtDir: file.toString()-->");
                sb.append(file.toString());
                d.l.a.e.b.c.a.g("ToolUtils", sb.toString());
                return file;
            }
            return (File) invokeLL.objValue;
        }

        public static int a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
                try {
                    return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            return invokeL.intValue;
        }

        public static int b(Context context, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(65550, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
        }

        public static int c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
                try {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        if (str.equals(str2)) {
                            return 0;
                        }
                        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                        String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                        int min = Math.min(split.length, split2.length);
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < min) {
                            i3 = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                            if (i3 != 0) {
                                break;
                            }
                            i2++;
                        }
                        if (i3 != 0) {
                            return i3 > 0 ? 1 : -1;
                        }
                        for (int i4 = i2; i4 < split.length; i4++) {
                            if (Integer.parseInt(split[i4]) > 0) {
                                return 1;
                            }
                        }
                        while (i2 < split2.length) {
                            if (Integer.parseInt(split2[i2]) > 0) {
                                return -1;
                            }
                            i2++;
                        }
                        return 0;
                    }
                } catch (Exception unused) {
                }
                return -2;
            }
            return invokeLL.intValue;
        }

        public static long d(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, null, j)) == null) {
                try {
                    return f(Environment.getExternalStorageDirectory(), j);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return j;
                }
            }
            return invokeJ.longValue;
        }

        public static long e(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
                if (file == null) {
                    return -1L;
                }
                try {
                    StatFs statFs = new StatFs(file.getAbsolutePath());
                    if (Build.VERSION.SDK_INT >= 18) {
                        return statFs.getTotalBytes();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return -1L;
                }
            }
            return invokeL.longValue;
        }

        public static long f(File file, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65554, null, file, j)) == null) {
                if (file == null) {
                    return j;
                }
                try {
                    return d.l.a.e.b.l.f.y0(file.getAbsolutePath());
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return j;
                }
            }
            return invokeLJ.longValue;
        }

        public static long g(JSONObject jSONObject, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, jSONObject, str)) == null) ? d.l.a.a.a.g.b.a(jSONObject, str) : invokeLL.longValue;
        }

        public static PackageInfo h(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bVar)) == null) {
                if (bVar == null || (f2 = d.l.a.e.b.g.a.H(d.l.a.d.b.l.a()).f(bVar.s())) == null) {
                    return null;
                }
                try {
                    return d.l.a.e.a.d.h(d.l.a.d.b.l.a(), f2, f2.getSavePath(), f2.getName());
                } catch (Throwable unused) {
                    return null;
                }
            }
            return (PackageInfo) invokeL.objValue;
        }

        public static Drawable i(Context context, String str) {
            InterceptResult invokeLL;
            PackageManager packageManager;
            PackageInfo packageArchiveInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
                if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
                    ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                    applicationInfo.sourceDir = str;
                    applicationInfo.publicSourceDir = str;
                    try {
                        return applicationInfo.loadIcon(packageManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
            return (Drawable) invokeLL.objValue;
        }

        public static c.d j(String str, int i2, String str2) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, str, i2, str2)) == null) {
                c.d dVar = new c.d();
                if (TextUtils.isEmpty(str)) {
                    return dVar;
                }
                try {
                    PackageInfo packageInfo = d.l.a.d.b.l.a().getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        dVar.d(packageInfo.versionCode);
                        dVar.a(c.d.f74211d);
                        d.l.a.a.a.c.o t = d.l.a.d.b.l.t();
                        if (t != null && t.a() && !s(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                            dVar.a(c.d.f74212e);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return dVar;
            }
            return (c.d) invokeLIL.objValue;
        }

        @NonNull
        public static <T> T k(T... tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, tArr)) == null) {
                if (tArr != null) {
                    for (T t : tArr) {
                        if (t != null) {
                            return t;
                        }
                    }
                    throw new IllegalArgumentException("args is null");
                }
                throw new IllegalArgumentException("args is null");
            }
            return (T) invokeL.objValue;
        }

        public static String l(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65560, null, str, i2)) == null) ? i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2) : (String) invokeLI.objValue;
        }

        public static String m(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, strArr)) == null) ? d.l.a.a.a.g.b.b(strArr) : (String) invokeL.objValue;
        }

        @NonNull
        public static JSONObject n(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, jSONObject)) == null) ? d.l.a.a.a.g.b.c(jSONObject) : (JSONObject) invokeL.objValue;
        }

        public static JSONObject o(JSONObject jSONObject, JSONObject jSONObject2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, jSONObject, jSONObject2)) == null) {
                d.l.a.a.a.g.b.d(jSONObject, jSONObject2);
                return jSONObject2;
            }
            return (JSONObject) invokeLL.objValue;
        }

        @NonNull
        public static JSONObject p(JSONObject... jSONObjectArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65564, null, jSONObjectArr)) == null) ? d.l.a.a.a.g.b.e(jSONObjectArr) : (JSONObject) invokeL.objValue;
        }

        public static void q(JSONObject jSONObject, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(65565, null, jSONObject, str, obj) == null) || jSONObject == null || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                jSONObject.putOpt(str, obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }

        public static boolean r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
        }

        public static boolean s(int i2, int i3, String str, String str2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2})) == null) {
                if (i3 == 0 && TextUtils.isEmpty(str2)) {
                    return true;
                }
                return (i3 > 0 && i2 >= i3) || c(str, str2) >= 0;
            }
            return invokeCommon.booleanValue;
        }

        public static boolean t(Context context, Intent intent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, intent)) == null) {
                try {
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
                    if (queryIntentActivities != null) {
                        return !queryIntentActivities.isEmpty();
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }

        public static boolean u(Context context, String str, String str2) {
            InterceptResult invokeLLL;
            PackageInfo packageArchiveInfo;
            PackageInfo packageInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, null, context, str, str2)) == null) {
                if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return false;
                }
                try {
                    File file = new File(str);
                    if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                        int i2 = packageArchiveInfo.versionCode;
                        try {
                            packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                        } catch (PackageManager.NameNotFoundException unused) {
                            packageInfo = null;
                        }
                        if (packageInfo == null) {
                            return false;
                        }
                        return i2 == packageInfo.versionCode;
                    }
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return false;
                }
            }
            return invokeLLL.booleanValue;
        }

        public static boolean v(d.l.a.a.a.d.d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, dVar)) == null) {
                if (dVar == null) {
                    return false;
                }
                return j(dVar.v(), dVar.r(), dVar.s()).b();
            }
            return invokeL.booleanValue;
        }

        public static boolean w(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return new File(str).exists();
            }
            return invokeL.booleanValue;
        }

        public static boolean x(Signature[] signatureArr, Signature[] signatureArr2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, signatureArr, signatureArr2)) == null) {
                if (signatureArr == signatureArr2) {
                    return true;
                }
                if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
                    return false;
                }
                for (int i2 = 0; i2 < signatureArr.length; i2++) {
                    if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                        return false;
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public static int y(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, context, str)) == null) {
                if (context == null || TextUtils.isEmpty(str)) {
                    return -1;
                }
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        return packageInfo.versionCode;
                    }
                    return -1;
                } catch (PackageManager.NameNotFoundException unused) {
                    return -1;
                }
            }
            return invokeLL.intValue;
        }

        @NonNull
        public static HashMap<String, String> z(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, jSONObject)) == null) {
                HashMap<String, String> hashMap = new HashMap<>();
                if (jSONObject != null) {
                    try {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, jSONObject.optString(next));
                        }
                        return hashMap;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return hashMap;
            }
            return (HashMap) invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class s extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a> f74515a;

        /* loaded from: classes10.dex */
        public interface a {
            void a(Message message);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Looper looper, a aVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74515a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (aVar = this.f74515a.get()) == null || message == null) {
                return;
            }
            aVar.a(message);
        }
    }

    public /* synthetic */ h(Context context, a aVar) {
        this(context);
    }

    public static h b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f74462f == null) {
                synchronized (h.class) {
                    if (f74462f == null) {
                        f.d.c(new a(context));
                    }
                }
            }
            return f74462f;
        }
        return (h) invokeL.objValue;
    }

    public d.l.a.a.a.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74463a : (d.l.a.a.a.b) invokeV.objValue;
    }

    public DownloadInfo d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return d.l.a.e.a.e.G().e(d.l.a.d.b.l.a(), str);
        }
        return (DownloadInfo) invokeL.objValue;
    }

    @MainThread
    public void e(Context context, int i2, d.l.a.a.a.d.e eVar, d.l.a.a.a.d.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, eVar, dVar) == null) {
            f.d.c(new c(this, context, i2, eVar, dVar));
        }
    }

    public void f(d.l.a.a.a.d.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            s().e(aVar);
        }
    }

    @MainThread
    public void g(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
            f.d.c(new f(this, str, i2));
        }
    }

    @MainThread
    public void h(String str, long j2, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), cVar, bVar}) == null) {
            f.d.c(new e(this, str, j2, i2, cVar, bVar));
        }
    }

    @MainThread
    public void i(String str, long j2, int i2, d.l.a.a.a.d.c cVar, d.l.a.a.a.d.b bVar, v vVar, d.l.a.a.a.c.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), cVar, bVar, vVar, nVar}) == null) {
            f.d.c(new d(this, str, j2, i2, cVar, bVar, vVar, nVar));
        }
    }

    @MainThread
    public void j(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            f.d.c(new b(this, str, z));
        }
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f74467e : invokeV.longValue;
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            d.l.a.d.b.l.b(context);
            d.l.a.e.b.g.a.H(d.l.a.d.b.l.a());
            c.g.e().q();
            d.l.a.e.a.e.G().k(d.l.a.d.b.l.a(), "misc_config", new d.j(), new d.i(context), new d.l.a.d.d());
            d.g gVar = new d.g();
            d.l.a.e.a.e.G().l(gVar);
            d.l.a.e.b.g.a.H(context).w(gVar);
            d.l.a.e.a.e.G().q(new d.l.a.d.b.m());
            d.l.a.e.b.g.e.F(new d.h());
            d.l.a.e.a.e.G().m(g.h.b());
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f74467e = System.currentTimeMillis();
        }
    }

    public d.l.a.b.a.b o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f74465c : (d.l.a.b.a.b) invokeV.objValue;
    }

    public d.l.a.b.a.d p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f74466d == null) {
                this.f74466d = d.l.a.d.c.f();
            }
            return this.f74466d;
        }
        return (d.l.a.b.a.d) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? d.l.a.d.b.l.z() : (String) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            d.l.a.d.e.a().j();
        }
    }

    public final d.l.a.d.g s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f74464b : (d.l.a.d.g) invokeV.objValue;
    }

    public h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74464b = d.l.a.d.g.b();
        this.f74463a = new d.l.a.d.f();
        this.f74467e = System.currentTimeMillis();
        m(context);
        this.f74465c = d.l.a.d.a.d();
    }
}
