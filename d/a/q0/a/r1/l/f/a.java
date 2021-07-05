package d.a.q0.a.r1.l.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.j2.c;
import d.a.q0.a.v2.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f50465d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, SwanAppConfigData> f50466b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50467c;

    /* renamed from: d.a.q0.a.r1.l.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0929a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50468e;

        public RunnableC0929a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50468e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f50468e.b();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "async batch parse app.json cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                if (file == null) {
                    return 1;
                }
                if (file2 == null) {
                    return -1;
                }
                return (int) ((b(file) - b(file2)) * (-1));
            }
            return invokeLL.intValue;
        }

        public final long b(@NonNull File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? file.lastModified() : invokeL.longValue;
        }

        public /* synthetic */ b(a aVar, RunnableC0929a runnableC0929a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f50469a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1936486750, "Ld/a/q0/a/r1/l/f/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1936486750, "Ld/a/q0/a/r1/l/f/a$c;");
                    return;
                }
            }
            f50469a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(292517565, "Ld/a/q0/a/r1/l/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(292517565, "Ld/a/q0/a/r1/l/f/a;");
                return;
            }
        }
        f50465d = new HashSet();
    }

    public /* synthetic */ a(RunnableC0929a runnableC0929a) {
        this();
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? c.f50469a : (a) invokeV.objValue;
    }

    public final void b() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File g2 = e.g();
            if (!g2.exists() || (listFiles = g2.listFiles()) == null || listFiles.length == 0) {
                return;
            }
            for (String str : f50465d) {
                c(new File(g2, str));
            }
        }
    }

    public final void c(File file) {
        File d2;
        SwanAppConfigData a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) || file == null || !file.exists() || !file.isDirectory() || (d2 = d(file)) == null || (a2 = d.a.q0.a.f1.c.a.a(d2)) == null) {
            return;
        }
        this.f50466b.put(d2.getAbsolutePath(), a2);
    }

    public final File d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            if (file != null && !file.isFile()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    if (listFiles.length > 1) {
                        Arrays.sort(listFiles, new b(this, null));
                    }
                    return listFiles[0];
                }
                c.b bVar = new c.b(CyberPlayerManager.MEDIA_INFO_START_PLAY);
                bVar.h(file.getAbsolutePath());
                bVar.k("async parse swanApp");
                bVar.m();
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", file.getAbsolutePath() + " is an empty folder");
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.f50466b;
            if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                this.f50466b.clear();
            }
            this.f50467c = false;
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.d("SwanPerformance", "release app.json batch cache");
            }
        }
    }

    public void g(String str) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f50466b) == null || concurrentHashMap.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, SwanAppConfigData>> it = this.f50466b.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, SwanAppConfigData> next = it.next();
            if (next != null) {
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && key.contains(str)) {
                    this.f50466b.remove(key);
                    break;
                }
            }
        }
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.d("SwanPerformance", "release app.json appId = " + str);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f50465d.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
            f50465d.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
            f50465d.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
            f50465d.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
            f50465d.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
        }
    }

    @AnyThread
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f50467c) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.d("SwanPerformance", "has batch parse app.json, size = " + this.f50466b.size());
                    return;
                }
                return;
            }
            this.f50467c = true;
            try {
                q.j(new RunnableC0929a(this), "startAsyncBatchParseAppJson");
            } catch (Throwable th) {
                if (d.a.q0.a.f1.f.a.f47786a) {
                    Log.e("SwanPerformance", "batch parse app.json exception");
                    th.printStackTrace();
                }
            }
        }
    }

    public SwanAppConfigData j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            String absolutePath = file.getAbsolutePath();
            if (TextUtils.isEmpty(absolutePath)) {
                return null;
            }
            SwanAppConfigData swanAppConfigData = this.f50466b.get(absolutePath);
            if (d.a.q0.a.f1.f.a.f47786a) {
                StringBuilder sb = new StringBuilder();
                sb.append("try obtain config data success = ");
                sb.append(swanAppConfigData != null);
                Log.d("SwanPerformance", sb.toString());
            }
            return swanAppConfigData;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public a() {
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
        this.f50466b = new ConcurrentHashMap<>();
        this.f50467c = false;
        h();
    }
}
