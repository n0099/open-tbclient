package d.l.a.d.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f71697b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f71698a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f71699e;

        public a(c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71699e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(3, l.a(), null, "下载失败，请重试！", null, 0);
                d.l.a.d.b.g a2 = d.l.a.d.g.b().a(this.f71699e);
                if (a2 != null) {
                    a2.H();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f71700a;

        /* renamed from: b  reason: collision with root package name */
        public long f71701b;

        /* renamed from: c  reason: collision with root package name */
        public long f71702c;

        /* renamed from: d  reason: collision with root package name */
        public String f71703d;

        /* renamed from: e  reason: collision with root package name */
        public String f71704e;

        /* renamed from: f  reason: collision with root package name */
        public String f71705f;

        /* renamed from: g  reason: collision with root package name */
        public String f71706g;

        /* renamed from: h  reason: collision with root package name */
        public volatile long f71707h;

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

        public static b a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.f71700a = h.r.g(jSONObject, "mDownloadId");
                    bVar.f71701b = h.r.g(jSONObject, "mAdId");
                    bVar.f71702c = h.r.g(jSONObject, "mExtValue");
                    bVar.f71703d = jSONObject.optString("mPackageName");
                    bVar.f71704e = jSONObject.optString("mAppName");
                    bVar.f71705f = jSONObject.optString("mLogExtra");
                    bVar.f71706g = jSONObject.optString("mFileName");
                    bVar.f71707h = h.r.g(jSONObject, "mTimeStamp");
                    return bVar;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }

        public JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mDownloadId", this.f71700a);
                    jSONObject.put("mAdId", this.f71701b);
                    jSONObject.put("mExtValue", this.f71702c);
                    jSONObject.put("mPackageName", this.f71703d);
                    jSONObject.put("mAppName", this.f71704e);
                    jSONObject.put("mLogExtra", this.f71705f);
                    jSONObject.put("mFileName", this.f71706g);
                    jSONObject.put("mTimeStamp", this.f71707h);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public b(long j, long j2, long j3, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, str4};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f71700a = j;
            this.f71701b = j2;
            this.f71702c = j3;
            this.f71703d = str;
            this.f71704e = str2;
            this.f71705f = str3;
            this.f71706g = str4;
        }
    }

    /* renamed from: d.l.a.d.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2016c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f71708a;

        /* renamed from: b  reason: collision with root package name */
        public long f71709b;

        /* renamed from: c  reason: collision with root package name */
        public String f71710c;

        /* renamed from: d  reason: collision with root package name */
        public String f71711d;

        /* renamed from: e  reason: collision with root package name */
        public String f71712e;

        /* renamed from: f  reason: collision with root package name */
        public String f71713f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Pair<String, String>> f71714g;

        /* renamed from: h  reason: collision with root package name */
        public String f71715h;

        public C2016c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71714g = new ArrayList();
        }

        public static long b(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? j > 0 ? j : j2 : invokeCommon.longValue;
        }

        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b(this.f71708a, this.f71709b) : invokeV.longValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: c  reason: collision with root package name */
        public static int f71716c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static int f71717d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static int f71718e = 2;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71719a;

        /* renamed from: b  reason: collision with root package name */
        public int f71720b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(56659032, "Ld/l/a/d/b/c$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(56659032, "Ld/l/a/d/b/c$d;");
            }
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f71719a = f71716c;
            this.f71720b = 0;
        }

        public d a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                this.f71719a = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71719a == f71717d : invokeV.booleanValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71720b : invokeV.intValue;
        }

        public d d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.f71720b = i2;
                return this;
            }
            return (d) invokeI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: b  reason: collision with root package name */
        public static volatile e f71721b;

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f71722c;

        /* renamed from: d  reason: collision with root package name */
        public static final int[] f71723d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<b> f71724a;

        /* loaded from: classes8.dex */
        public static /* synthetic */ class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
        }

        /* loaded from: classes8.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final String f71725a;

            /* renamed from: b  reason: collision with root package name */
            public final int f71726b;

            /* renamed from: c  reason: collision with root package name */
            public final String f71727c;

            /* renamed from: d  reason: collision with root package name */
            public final String f71728d;

            /* renamed from: e  reason: collision with root package name */
            public final long f71729e;

            public /* synthetic */ b(String str, int i2, String str2, String str3, long j, a aVar) {
                this(str, i2, str2, str3, j);
            }

            public b(String str, int i2, String str2, String str3, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2), str2, str3, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71725a = str;
                this.f71726b = i2;
                this.f71727c = str2 != null ? str2.toLowerCase() : null;
                this.f71728d = str3 != null ? str3.toLowerCase() : null;
                this.f71729e = j;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(56659063, "Ld/l/a/d/b/c$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(56659063, "Ld/l/a/d/b/c$e;");
                    return;
                }
            }
            f71722c = new String[]{"com", "android", "ss"};
            f71723d = new int[]{3101, 3102, 3103, 3201, 3202, 3203};
        }

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f71724a = new LinkedList<>();
        }

        public static e b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (f71721b == null) {
                    synchronized (e.class) {
                        if (f71721b == null) {
                            f71721b = new e();
                        }
                    }
                }
                return f71721b;
            }
            return (e) invokeV.objValue;
        }

        public static boolean d(String str, String str2) {
            InterceptResult invokeLL;
            String[] split;
            String[] split2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
                try {
                    split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                    split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (split.length != 0 && split2.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (String str3 : split) {
                        String[] strArr = f71722c;
                        int length = strArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                z = false;
                                break;
                            }
                            String str4 = strArr[i4];
                            if (str4.equals(str3)) {
                                if (i2 < split2.length && str4.equals(split2[i2])) {
                                    i2++;
                                }
                                z = true;
                            } else {
                                i4++;
                            }
                        }
                        if (!z) {
                            int i5 = i3;
                            int i6 = i2;
                            while (i2 < split2.length) {
                                if (str3.equals(split2[i2])) {
                                    if (i2 == i6) {
                                        i6++;
                                    }
                                    i5++;
                                    if (i5 >= 2) {
                                        return true;
                                    }
                                }
                                i2++;
                            }
                            i2 = i6;
                            i3 = i5;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }

        public b a(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar == null) {
                    return null;
                }
                f();
                synchronized (this.f71724a) {
                    Iterator<b> it = this.f71724a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next.f71729e > bVar.z()) {
                            return next;
                        }
                    }
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }

        public void c(String str) {
            b h2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                f();
                if (TextUtils.isEmpty(str) || (h2 = h(str)) == null) {
                    return;
                }
                synchronized (this.f71724a) {
                    this.f71724a.add(h2);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
            r7[1] = r11;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Pair<b, Integer> e(d.l.a.b.a.c.b bVar) {
            InterceptResult invokeL;
            int i2;
            b next;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
                if (bVar == null) {
                    return null;
                }
                try {
                    f();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.f71724a.isEmpty()) {
                    return null;
                }
                String K = bVar.K();
                String e2 = bVar.e();
                String G = bVar.G();
                int F = bVar.F();
                int length = f71723d.length;
                b[] bVarArr = new b[length];
                synchronized (this.f71724a) {
                    Iterator<b> it = this.f71724a.iterator();
                    PackageInfo packageInfo = null;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        next = it.next();
                        if (next.f71729e >= bVar.z()) {
                            if (TextUtils.isEmpty(K)) {
                                if (packageInfo == null) {
                                    packageInfo = h.r.h(bVar);
                                }
                                if (packageInfo != null) {
                                    try {
                                        K = (String) l.a().getPackageManager().getApplicationLabel(packageInfo.applicationInfo);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(K) && !TextUtils.isEmpty(next.f71728d)) {
                                K = K.toLowerCase();
                                if (K.equals(next.f71728d)) {
                                    bVarArr[0] = next;
                                    break;
                                } else if (K.contains(next.f71728d) || next.f71728d.contains(K)) {
                                    break;
                                }
                            }
                            if (TextUtils.isEmpty(e2)) {
                                if (packageInfo == null) {
                                    packageInfo = h.r.h(bVar);
                                }
                                if (packageInfo != null) {
                                    e2 = packageInfo.packageName;
                                }
                            }
                            if (!TextUtils.isEmpty(e2) && !TextUtils.isEmpty(next.f71725a)) {
                                e2 = e2.toLowerCase();
                                if (e2.contains(next.f71725a) || next.f71725a.contains(e2)) {
                                    break;
                                } else if (bVarArr[3] == null) {
                                    if (d(e2, next.f71725a)) {
                                        bVarArr[3] = next;
                                    }
                                }
                            }
                            if (bVarArr[4] == null) {
                                if (TextUtils.isEmpty(G)) {
                                    if (packageInfo == null) {
                                        packageInfo = h.r.h(bVar);
                                    }
                                    if (packageInfo != null) {
                                        G = packageInfo.versionName;
                                    }
                                }
                                if (!TextUtils.isEmpty(G) && !TextUtils.isEmpty(next.f71727c)) {
                                    G = G.toLowerCase();
                                    if (G.equals(next.f71727c)) {
                                        bVarArr[4] = next;
                                    }
                                }
                                if (bVarArr[5] == null) {
                                    if (F <= 0) {
                                        if (packageInfo == null) {
                                            packageInfo = h.r.h(bVar);
                                        }
                                        if (packageInfo != null) {
                                            F = packageInfo.versionCode;
                                        }
                                    }
                                    if (F == next.f71726b) {
                                        bVarArr[5] = next;
                                    }
                                }
                            }
                        }
                    }
                    bVarArr[2] = next;
                }
                for (i2 = 0; i2 < length; i2++) {
                    if (bVarArr[i2] != null) {
                        return new Pair<>(bVarArr[i2], Integer.valueOf(f71723d[i2]));
                    }
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.f71724a) {
                    Iterator<b> it = this.f71724a.iterator();
                    while (it.hasNext() && currentTimeMillis - it.next().f71729e > 1800000) {
                        it.remove();
                    }
                }
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                f();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                synchronized (this.f71724a) {
                    Iterator<b> it = this.f71724a.iterator();
                    while (it.hasNext()) {
                        if (str.equals(it.next().f71725a)) {
                            it.remove();
                            return;
                        }
                    }
                }
            }
        }

        public final b h(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                try {
                    PackageManager packageManager = l.a().getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                    if (packageInfo != null) {
                        return new b(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis(), null);
                    }
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class f implements d.l.a.b.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f71730a;

        /* renamed from: b  reason: collision with root package name */
        public d.l.a.a.a.d.d f71731b;

        /* renamed from: c  reason: collision with root package name */
        public d.l.a.a.a.d.c f71732c;

        /* renamed from: d  reason: collision with root package name */
        public d.l.a.a.a.d.b f71733d;

        public f() {
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

        @Override // d.l.a.b.a.c.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71731b.a() : (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71731b.d() : invokeV.longValue;
        }

        @Override // d.l.a.b.a.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71731b.t() : invokeV.booleanValue;
        }

        @Override // d.l.a.b.a.c.a
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f71731b.u() : (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f71731b.v() : (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f71731b.x() != null) {
                    return this.f71731b.x().d();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public JSONObject g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f71731b.z() : (JSONObject) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.f71733d.b() == 2) {
                    return 2;
                }
                return this.f71731b.G();
            }
            return invokeV.intValue;
        }

        @Override // d.l.a.b.a.c.a
        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f71732c.a() : (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public String j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f71732c.b() : (String) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public JSONObject k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f71732c.o() : (JSONObject) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f71731b.g() : invokeV.longValue;
        }

        @Override // d.l.a.b.a.c.a
        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f71732c.m() : invokeV.booleanValue;
        }

        @Override // d.l.a.b.a.c.a
        public List<String> n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f71731b.y() : (List) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public Object o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f71732c.j() : invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public JSONObject p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71732c.n() : (JSONObject) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f71733d.g() : invokeV.booleanValue;
        }

        @Override // d.l.a.b.a.c.a
        public JSONObject r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f71731b.p() : (JSONObject) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public int s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // d.l.a.b.a.c.a
        public int t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f71732c.k() : invokeV.intValue;
        }

        @Override // d.l.a.b.a.c.a
        public d.l.a.a.a.d.d u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f71731b : (d.l.a.a.a.d.d) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public d.l.a.a.a.d.c v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f71732c : (d.l.a.a.a.d.c) invokeV.objValue;
        }

        @Override // d.l.a.b.a.c.a
        public d.l.a.a.a.d.b w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f71733d : (d.l.a.a.a.d.b) invokeV.objValue;
        }

        public boolean x() {
            InterceptResult invokeV;
            d.l.a.a.a.d.d dVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                if (this.f71730a == 0 || (dVar = this.f71731b) == null || this.f71732c == null || this.f71733d == null) {
                    return true;
                }
                return dVar.t() && this.f71730a <= 0;
            }
            return invokeV.booleanValue;
        }

        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                if (x()) {
                    return false;
                }
                if (this.f71731b.t()) {
                    d.l.a.a.a.d.d dVar = this.f71731b;
                    return (dVar instanceof d.l.a.b.a.a.c) && !TextUtils.isEmpty(dVar.u()) && (this.f71732c instanceof d.l.a.b.a.a.b) && (this.f71733d instanceof d.l.a.b.a.a.a);
                }
                return this.f71731b instanceof d.l.a.b.a.a.c;
            }
            return invokeV.booleanValue;
        }

        public f(long j, @NonNull d.l.a.a.a.d.d dVar, @NonNull d.l.a.a.a.d.c cVar, @NonNull d.l.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), dVar, cVar, bVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f71730a = j;
            this.f71731b = dVar;
            this.f71732c = cVar;
            this.f71733d = bVar;
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f71734a;

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.l.a.a.a.d.d> f71735b;

        /* renamed from: c  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.l.a.a.a.d.c> f71736c;

        /* renamed from: d  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.l.a.a.a.d.b> f71737d;

        /* renamed from: e  reason: collision with root package name */
        public final ConcurrentHashMap<Long, d.l.a.b.a.c.b> f71738e;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f71739e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71739e = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f71739e.f71734a) {
                    return;
                }
                synchronized (g.class) {
                    if (!this.f71739e.f71734a) {
                        this.f71739e.f71738e.putAll(j.b().f());
                        this.f71739e.f71734a = true;
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static g f71740a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1385174729, "Ld/l/a/d/b/c$g$b;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1385174729, "Ld/l/a/d/b/c$g$b;");
                        return;
                    }
                }
                f71740a = new g(null);
            }
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public static g e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f71740a : (g) invokeV.objValue;
        }

        public d.l.a.a.a.d.d a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f71735b.get(Long.valueOf(j)) : (d.l.a.a.a.d.d) invokeJ.objValue;
        }

        public d.l.a.b.a.c.b b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                for (d.l.a.b.a.c.b bVar : this.f71738e.values()) {
                    if (bVar != null && bVar.s() == i2) {
                        return bVar;
                    }
                }
                return null;
            }
            return (d.l.a.b.a.c.b) invokeI.objValue;
        }

        public d.l.a.b.a.c.b c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo == null) {
                    return null;
                }
                for (d.l.a.b.a.c.b bVar : this.f71738e.values()) {
                    if (bVar != null && bVar.s() == downloadInfo.getId()) {
                        return bVar;
                    }
                }
                if (!TextUtils.isEmpty(downloadInfo.getExtra())) {
                    try {
                        long g2 = h.r.g(new JSONObject(downloadInfo.getExtra()), "extra");
                        if (g2 != 0) {
                            for (d.l.a.b.a.c.b bVar2 : this.f71738e.values()) {
                                if (bVar2 != null && bVar2.b() == g2) {
                                    return bVar2;
                                }
                            }
                            f.e.b().d("getNativeModelByInfo");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                for (d.l.a.b.a.c.b bVar3 : this.f71738e.values()) {
                    if (bVar3 != null && TextUtils.equals(bVar3.a(), downloadInfo.getUrl())) {
                        return bVar3;
                    }
                }
                return null;
            }
            return (d.l.a.b.a.c.b) invokeL.objValue;
        }

        public d.l.a.b.a.c.b d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                for (d.l.a.b.a.c.b bVar : this.f71738e.values()) {
                    if (bVar != null && str.equals(bVar.e())) {
                        return bVar;
                    }
                }
                return null;
            }
            return (d.l.a.b.a.c.b) invokeL.objValue;
        }

        @NonNull
        public Map<Long, d.l.a.b.a.c.b> f(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    for (d.l.a.b.a.c.b bVar : this.f71738e.values()) {
                        if (bVar != null && TextUtils.equals(bVar.a(), str)) {
                            bVar.n0(str2);
                            hashMap.put(Long.valueOf(bVar.b()), bVar);
                        }
                    }
                }
                return hashMap;
            }
            return (Map) invokeLL.objValue;
        }

        public void g(long j, d.l.a.a.a.d.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048581, this, j, bVar) == null) || bVar == null) {
                return;
            }
            this.f71737d.put(Long.valueOf(j), bVar);
        }

        public void h(long j, d.l.a.a.a.d.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048582, this, j, cVar) == null) || cVar == null) {
                return;
            }
            this.f71736c.put(Long.valueOf(j), cVar);
        }

        public void i(d.l.a.a.a.d.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) || dVar == null) {
                return;
            }
            this.f71735b.put(Long.valueOf(dVar.d()), dVar);
            if (dVar.x() != null) {
                dVar.x().b(dVar.d());
                dVar.x().g(dVar.v());
            }
        }

        public synchronized void j(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                synchronized (this) {
                    if (bVar == null) {
                        return;
                    }
                    this.f71738e.put(Long.valueOf(bVar.b()), bVar);
                    j.b().c(bVar);
                }
            }
        }

        public synchronized void k(List<Long> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
                synchronized (this) {
                    ArrayList arrayList = new ArrayList();
                    for (Long l : list) {
                        long longValue = l.longValue();
                        arrayList.add(String.valueOf(longValue));
                        this.f71738e.remove(Long.valueOf(longValue));
                    }
                    j.b().e(arrayList);
                }
            }
        }

        public d.l.a.a.a.d.c n(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) ? this.f71736c.get(Long.valueOf(j)) : (d.l.a.a.a.d.c) invokeJ.objValue;
        }

        public d.l.a.b.a.c.b o(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                for (d.l.a.b.a.c.b bVar : this.f71738e.values()) {
                    if (bVar != null && str.equals(bVar.a())) {
                        return bVar;
                    }
                }
                return null;
            }
            return (d.l.a.b.a.c.b) invokeL.objValue;
        }

        public void q() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
                d.l.a.d.e.a().d(new a(this), true);
            }
        }

        public void r(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            for (d.l.a.a.a.d.d dVar : this.f71735b.values()) {
                if ((dVar instanceof d.l.a.b.a.a.c) && TextUtils.equals(dVar.a(), str)) {
                    ((d.l.a.b.a.a.c) dVar).e(str2);
                }
            }
        }

        public d.l.a.a.a.d.b s(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048590, this, j)) == null) ? this.f71737d.get(Long.valueOf(j)) : (d.l.a.a.a.d.b) invokeJ.objValue;
        }

        public ConcurrentHashMap<Long, d.l.a.b.a.c.b> t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f71738e : (ConcurrentHashMap) invokeV.objValue;
        }

        public d.l.a.b.a.c.b u(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) ? this.f71738e.get(Long.valueOf(j)) : (d.l.a.b.a.c.b) invokeJ.objValue;
        }

        @NonNull
        public f v(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
                f fVar = new f();
                fVar.f71730a = j;
                fVar.f71731b = a(j);
                d.l.a.a.a.d.c n = n(j);
                fVar.f71732c = n;
                if (n == null) {
                    fVar.f71732c = new d.l.a.a.a.d.h();
                }
                d.l.a.a.a.d.b s = s(j);
                fVar.f71733d = s;
                if (s == null) {
                    fVar.f71733d = new d.l.a.a.a.d.g();
                }
                return fVar;
            }
            return (f) invokeJ.objValue;
        }

        public void w(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
                this.f71735b.remove(Long.valueOf(j));
                this.f71736c.remove(Long.valueOf(j));
                this.f71737d.remove(Long.valueOf(j));
            }
        }

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71734a = false;
            this.f71735b = new ConcurrentHashMap<>();
            this.f71736c = new ConcurrentHashMap<>();
            this.f71737d = new ConcurrentHashMap<>();
            this.f71738e = new ConcurrentHashMap<>();
        }
    }

    /* loaded from: classes8.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f71741a;

        /* renamed from: b  reason: collision with root package name */
        public int f71742b;

        /* renamed from: c  reason: collision with root package name */
        public String f71743c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2) {
            this(i2, 0, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71741a : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71742b : invokeV.intValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f71743c : (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2, int i3) {
            this(i2, i3, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public h(int i2, String str) {
            this(i2, 0, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65539, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        public h(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), str};
                interceptable.invokeUnInit(65538, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f71741a = i2;
            this.f71742b = i3;
            this.f71743c = str;
        }
    }

    /* loaded from: classes8.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static volatile i f71744a;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
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

        public static i a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f71744a == null) {
                    synchronized (e.class) {
                        if (f71744a == null) {
                            f71744a = new i();
                        }
                    }
                }
                return f71744a;
            }
            return (i) invokeV.objValue;
        }

        public void b(int i2, int i3, d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, bVar) == null) || bVar == null) {
                return;
            }
            d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(bVar.s());
            if (d2.b("report_api_hijack", 0) == 0) {
                return;
            }
            int i4 = i3 - i2;
            if (i2 <= 0 || i4 <= d2.b("check_api_hijack_version_code_diff", 500)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version_code_diff", i4);
                jSONObject.put("installed_version_code", i3);
                jSONObject.put("hijack_type", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            e.c.a().w("api_hijack", jSONObject, bVar);
        }
    }

    /* loaded from: classes8.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Collection f71745e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f71746f;

            public a(j jVar, Collection collection) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, collection};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71746f = jVar;
                this.f71745e = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f71746f.g().edit();
                    for (d.l.a.b.a.c.b bVar : this.f71745e) {
                        if (bVar != null && bVar.b() != 0) {
                            edit.putString(String.valueOf(bVar.b()), bVar.g0().toString());
                        }
                    }
                    edit.apply();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f71747e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ j f71748f;

            public b(j jVar, List list) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, list};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71748f = jVar;
                this.f71747e = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    SharedPreferences.Editor edit = this.f71748f.g().edit();
                    for (String str : this.f71747e) {
                        edit.remove(str);
                    }
                    edit.apply();
                }
            }
        }

        /* renamed from: d.l.a.d.b.c$j$c  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C2017c {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static j f71749a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1385085325, "Ld/l/a/d/b/c$j$c;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(-1385085325, "Ld/l/a/d/b/c$j$c;");
                        return;
                    }
                }
                f71749a = new j(null);
            }
        }

        public /* synthetic */ j(a aVar) {
            this();
        }

        public static j b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C2017c.f71749a : (j) invokeV.objValue;
        }

        public void c(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(bVar);
                d(arrayList);
            }
        }

        public synchronized void d(Collection<d.l.a.b.a.c.b> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
                synchronized (this) {
                    if (collection != null) {
                        if (!collection.isEmpty()) {
                            d.l.a.d.e.a().d(new a(this, collection), true);
                        }
                    }
                }
            }
        }

        public void e(List<String> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || list == null || list.isEmpty()) {
                return;
            }
            d.l.a.d.e.a().d(new b(this, list), true);
        }

        @NonNull
        public ConcurrentHashMap<Long, d.l.a.b.a.c.b> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ConcurrentHashMap<Long, d.l.a.b.a.c.b> concurrentHashMap = new ConcurrentHashMap<>();
                Map<String, ?> all = g().getAll();
                if (all == null) {
                    return concurrentHashMap;
                }
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            long longValue = Long.valueOf(entry.getKey()).longValue();
                            d.l.a.b.a.c.b k0 = d.l.a.b.a.c.b.k0(new JSONObject(String.valueOf(entry.getValue())));
                            if (longValue > 0 && k0 != null) {
                                concurrentHashMap.put(Long.valueOf(longValue), k0);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return concurrentHashMap;
            }
            return (ConcurrentHashMap) invokeV.objValue;
        }

        public final SharedPreferences g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? l.a().getSharedPreferences("sp_ad_download_event", 0) : (SharedPreferences) invokeV.objValue;
        }

        public j() {
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
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71698a = null;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f71697b == null) {
                synchronized (c.class) {
                    if (f71697b == null) {
                        f71697b = new c();
                    }
                }
            }
            return f71697b;
        }
        return (c) invokeV.objValue;
    }

    public void b(Context context, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, downloadInfo) == null) && c() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f71698a == null) {
                this.f71698a = new Handler(Looper.getMainLooper());
            }
            String url = downloadInfo.getUrl();
            d.l.a.e.b.g.a.H(context).d(downloadInfo.getId());
            this.f71698a.post(new a(this, url));
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? l.v().optInt("forbid_invalidte_download_file_install", 0) == 1 : invokeV.booleanValue;
    }
}
