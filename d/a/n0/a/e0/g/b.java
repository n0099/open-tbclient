package d.a.n0.a.e0.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.k;
import d.a.n0.a.q2.e;
import d.a.n0.a.v2.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f44116i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;
    public static final String p;
    public static final String q;
    public static final String r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f44117a;

    /* renamed from: b  reason: collision with root package name */
    public f f44118b;

    /* renamed from: c  reason: collision with root package name */
    public c f44119c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0671b f44120d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f44121e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44122f;

    /* renamed from: g  reason: collision with root package name */
    public int f44123g;

    /* renamed from: h  reason: collision with root package name */
    public int f44124h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.n0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0671b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44125e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f44126f;

        public RunnableC0671b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44126f = bVar;
        }

        public synchronized String b() {
            InterceptResult invokeV;
            BufferedReader bufferedReader;
            IOException e2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (String) invokeV.objValue;
            }
            synchronized (this) {
                if (b.f44116i) {
                    Log.d("PropertyMonitor", "start cpu monitor thread");
                }
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{IAdRequestParam.SCREEN_HEIGHT, "-c", "top -n 1 | grep " + Process.myPid()}).getInputStream()));
                    try {
                        String c2 = c(bufferedReader);
                        if (b.f44116i) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                        }
                        d.a.n0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException e3) {
                        e2 = e3;
                        if (b.f44116i) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e2);
                        }
                        d.a.n0.t.d.d(bufferedReader);
                        return "";
                    }
                } catch (IOException e4) {
                    bufferedReader = null;
                    e2 = e4;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.n0.t.d.d(null);
                    throw th;
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (d.a.n0.a.e0.g.b.f44116i != false) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
            android.util.Log.e("PropertyMonitor", "get CPU Fail : " + r12.getMessage());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String c(BufferedReader bufferedReader) throws IOException {
            InterceptResult invokeL;
            char read;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bufferedReader)) == null) {
                char[] cArr = new char[4];
                int i2 = 0;
                if (Build.VERSION.SDK_INT < 26) {
                    int i3 = 0;
                    do {
                        read = (char) bufferedReader.read();
                        if (read == ' ' || i3 == 4) {
                            i3 = 0;
                        } else {
                            cArr[i3] = read;
                            i3++;
                        }
                        if (read == '%') {
                            break;
                        }
                    } while (read != 65535);
                    return String.valueOf(cArr, 0, i3);
                }
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    char read2 = (char) bufferedReader.read();
                    if (z && read2 != ' ') {
                        i4++;
                    }
                    if (i4 == 9) {
                        if (read2 != '.' && read2 != ' ') {
                            cArr[i5] = read2;
                            i5++;
                        }
                        i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                        return i2 + "%";
                    }
                    z = (i4 <= 9 && read2 != 65535 && i5 < 4) ? read2 == ' ' : true;
                    i2 = Integer.parseInt(String.valueOf(cArr, 0, i5)) / Runtime.getRuntime().availableProcessors();
                    return i2 + "%";
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f44125e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f44126f.f44121e.put("cpu", b2);
                }
                this.f44125e = false;
            }
        }

        public /* synthetic */ RunnableC0671b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f44130a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1945179247, "Ld/a/n0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1945179247, "Ld/a/n0/a/e0/g/b$d;");
                    return;
                }
            }
            f44130a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f44131a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44131a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f44131a.f44121e == null) {
                return;
            }
            this.f44131a.g();
            this.f44131a.f44121e.put("mem", Long.valueOf(((ActivityManager) d.a.n0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f44131a.f44117a != null) {
                this.f44131a.f44117a.sendEmptyMessageDelayed(0, this.f44131a.f44123g);
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f44132e;

        public f(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44132e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.n0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (d.a.n0.a.q2.c<?> cVar : set) {
                this.f44132e.f44121e.put(cVar.f46852a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1950625327, "Ld/a/n0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1950625327, "Ld/a/n0/a/e0/g/b;");
                return;
            }
        }
        f44116i = k.f45831a;
        j = d.a.n0.a.q2.d.f46857d.f46852a;
        k = d.a.n0.a.q2.d.f46855b.f46852a;
        l = d.a.n0.a.q2.d.f46856c.f46852a;
        String str = d.a.n0.a.q2.d.f46860g.f46852a;
        m = d.a.n0.a.q2.d.f46862i.f46852a;
        n = d.a.n0.a.q2.d.f46858e.f46852a;
        o = d.a.n0.a.q2.d.f46859f.f46852a;
        p = d.a.n0.a.q2.d.f46861h.f46852a;
        q = d.a.n0.a.q2.d.j.f46852a;
        r = d.a.n0.a.q2.d.k.f46852a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f44130a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44120d.f44125e) {
            return;
        }
        q.j(this.f44120d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f44124h++;
            k();
            return this.f44121e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f44124h - 1;
            this.f44124h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f44122f) {
                if (f44116i) {
                    Log.d("PropertyMonitor", "System monitor already started");
                    return;
                }
                return;
            }
            this.f44122f = true;
            this.f44119c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f44119c);
            this.f44120d = new RunnableC0671b(this, null);
            this.f44118b = new f(this, null);
            d.a.n0.a.q2.e.a().g(this.f44118b, d.a.n0.a.q2.d.f46857d, d.a.n0.a.q2.d.f46855b, d.a.n0.a.q2.d.f46856c, d.a.n0.a.q2.d.f46862i, d.a.n0.a.q2.d.f46858e, d.a.n0.a.q2.d.f46859f, d.a.n0.a.q2.d.f46860g, d.a.n0.a.q2.d.f46861h, d.a.n0.a.q2.d.j, d.a.n0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f44117a = eVar;
            eVar.sendEmptyMessage(0);
            if (f44116i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f44122f) {
                if (f44116i) {
                    Log.d("PropertyMonitor", "System monitor not started yet");
                    return;
                }
                return;
            }
            this.f44122f = false;
            e eVar = this.f44117a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f44117a = null;
            }
            if (this.f44118b != null) {
                d.a.n0.a.q2.e.a().j(this.f44118b, new d.a.n0.a.q2.c[0]);
                this.f44118b = null;
            }
            this.f44119c = null;
            this.f44120d = null;
            if (f44116i) {
                Log.d("PropertyMonitor", "Stop system monitor");
            }
        }
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
                return;
            }
        }
        this.f44121e = new ConcurrentHashMap();
        this.f44123g = 1000;
    }

    /* loaded from: classes7.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f44127e;

        /* renamed from: f  reason: collision with root package name */
        public int f44128f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f44129g;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44129g = bVar;
            this.f44127e = -1L;
            this.f44128f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.f44129g.f44122f) {
                long j2 = this.f44127e;
                if (j2 > 0 && this.f44128f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f44128f = i2;
                    this.f44129g.f44121e.put("frame", Integer.valueOf(i2));
                }
                this.f44127e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
