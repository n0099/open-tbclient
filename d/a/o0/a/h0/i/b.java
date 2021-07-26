package d.a.o0.a.h0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.q;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45295a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45296e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ File f45297f;

        public a(String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45296e = str;
            this.f45297f = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (b.class) {
                    d.a.o0.t.d.R(this.f45296e, this.f45297f, true);
                }
                b.c();
            }
        }
    }

    /* renamed from: d.a.o0.a.h0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0744b implements Comparator<Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0744b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Long l, Long l2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, l, l2)) == null) ? l2.compareTo(l) : invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(447311375, "Ld/a/o0/a/h0/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(447311375, "Ld/a/o0/a/h0/i/b;");
                return;
            }
        }
        f45295a = k.f46335a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static File b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) {
            String f2 = f();
            if (f2 == null) {
                return null;
            }
            File file = new File(f2 + File.separator + j);
            if (file.exists()) {
                d.a.o0.t.d.K(file);
            }
            d.a.o0.t.d.h(file);
            return file;
        }
        return (File) invokeJ.objValue;
    }

    public static void c() {
        d.a.o0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || (Q = d.a.o0.a.a2.e.Q()) == null || TextUtils.isEmpty(Q.getAppId())) {
            return;
        }
        File file = new File(d.a.o0.a.a1.e.g().getPath() + File.separator + "launch_tips");
        if (file.exists() && file.isDirectory()) {
            d.a.o0.t.d.i(file);
        }
    }

    public static File d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) {
            File[] g2 = g();
            if (g2 != null && g2.length != 0) {
                File file = null;
                for (File file2 : g2) {
                    try {
                        long parseLong = Long.parseLong(file2.getName());
                        if (parseLong == j) {
                            file = file2;
                        } else if (j - parseLong >= 259200000) {
                            d.a.o0.t.d.i(file2);
                        }
                    } catch (NumberFormatException unused) {
                        d.a.o0.t.d.i(file2);
                    }
                }
                return file == null ? b(j) : file;
            }
            return b(j);
        }
        return (File) invokeJ.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            File[] g2 = g();
            if (g2 == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap(new C0744b());
            long i2 = i(System.currentTimeMillis());
            for (File file : g2) {
                try {
                    long parseLong = Long.parseLong(file.getName());
                    if (i2 - parseLong >= 259200000) {
                        d.a.o0.t.d.i(file);
                    } else {
                        List<String> E = d.a.o0.t.d.E(file);
                        if (E != null && E.size() > 0) {
                            treeMap.put(Long.valueOf(parseLong), E);
                        }
                    }
                } catch (NumberFormatException unused) {
                    d.a.o0.t.d.i(file);
                }
            }
            if (treeMap.size() == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder("\n（二）历史日志");
            for (Map.Entry entry : treeMap.entrySet()) {
                sb.append("\n----------【");
                sb.append(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(((Long) entry.getKey()).longValue())));
                sb.append("】----------");
                for (String str : (List) entry.getValue()) {
                    if (!TextUtils.isEmpty(str)) {
                        sb.append("\n");
                        sb.append(str);
                    }
                }
            }
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            String appId = Q.getAppId();
            if (TextUtils.isEmpty(appId)) {
                return null;
            }
            return d.a.o0.a.a1.e.g().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
        }
        return (String) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String f2 = f();
            if (f2 == null) {
                return null;
            }
            File file = new File(f2);
            if (file.exists() && file.isDirectory()) {
                return file.listFiles();
            }
            return null;
        }
        return (File[]) invokeV.objValue;
    }

    public static void h(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65545, null, j, str) == null) {
            long i2 = i(j);
            if (i2 == -1) {
                if (f45295a) {
                    Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                    return;
                }
                return;
            }
            File d2 = d(i2);
            if (d2 == null || !d2.exists()) {
                return;
            }
            q.j(new a(str, d2), "saveLaunchTipsLog");
        }
    }

    public static long i(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            try {
                Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
                if (parse == null) {
                    return -1L;
                }
                return parse.getTime();
            } catch (ParseException e2) {
                if (k.f46335a) {
                    e2.printStackTrace();
                }
                return -1L;
            }
        }
        return invokeJ.longValue;
    }
}
