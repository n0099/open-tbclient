package d.a.q0.a.e0.g;

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
import d.a.q0.a.k;
import d.a.q0.a.q2.e;
import d.a.q0.a.v2.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f47418i;
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
    public e f47419a;

    /* renamed from: b  reason: collision with root package name */
    public f f47420b;

    /* renamed from: c  reason: collision with root package name */
    public c f47421c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0722b f47422d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f47423e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47424f;

    /* renamed from: g  reason: collision with root package name */
    public int f47425g;

    /* renamed from: h  reason: collision with root package name */
    public int f47426h;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0722b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f47427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f47428f;

        public RunnableC0722b(b bVar) {
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
            this.f47428f = bVar;
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
                if (b.f47418i) {
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
                        if (b.f47418i) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                        }
                        d.a.q0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException e3) {
                        e2 = e3;
                        if (b.f47418i) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e2);
                        }
                        d.a.q0.t.d.d(bufferedReader);
                        return "";
                    }
                } catch (IOException e4) {
                    bufferedReader = null;
                    e2 = e4;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.q0.t.d.d(null);
                    throw th;
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (d.a.q0.a.e0.g.b.f47418i != false) goto L25;
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
                this.f47427e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f47428f.f47423e.put("cpu", b2);
                }
                this.f47427e = false;
            }
        }

        public /* synthetic */ RunnableC0722b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f47432a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(428503372, "Ld/a/q0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(428503372, "Ld/a/q0/a/e0/g/b$d;");
                    return;
                }
            }
            f47432a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes8.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f47433a;

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
            this.f47433a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f47433a.f47423e == null) {
                return;
            }
            this.f47433a.g();
            this.f47433a.f47423e.put("mem", Long.valueOf(((ActivityManager) d.a.q0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f47433a.f47419a != null) {
                this.f47433a.f47419a.sendEmptyMessageDelayed(0, this.f47433a.f47425g);
            }
        }

        public /* synthetic */ e(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f47434e;

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
            this.f47434e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.q0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (d.a.q0.a.q2.c<?> cVar : set) {
                this.f47434e.f47423e.put(cVar.f50154a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957093812, "Ld/a/q0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1957093812, "Ld/a/q0/a/e0/g/b;");
                return;
            }
        }
        f47418i = k.f49133a;
        j = d.a.q0.a.q2.d.f50159d.f50154a;
        k = d.a.q0.a.q2.d.f50157b.f50154a;
        l = d.a.q0.a.q2.d.f50158c.f50154a;
        String str = d.a.q0.a.q2.d.f50162g.f50154a;
        m = d.a.q0.a.q2.d.f50164i.f50154a;
        n = d.a.q0.a.q2.d.f50160e.f50154a;
        o = d.a.q0.a.q2.d.f50161f.f50154a;
        p = d.a.q0.a.q2.d.f50163h.f50154a;
        q = d.a.q0.a.q2.d.j.f50154a;
        r = d.a.q0.a.q2.d.k.f50154a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f47432a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47422d.f47427e) {
            return;
        }
        q.j(this.f47422d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f47426h++;
            k();
            return this.f47423e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f47426h - 1;
            this.f47426h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f47424f) {
                if (f47418i) {
                    Log.d("PropertyMonitor", "System monitor already started");
                    return;
                }
                return;
            }
            this.f47424f = true;
            this.f47421c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f47421c);
            this.f47422d = new RunnableC0722b(this, null);
            this.f47420b = new f(this, null);
            d.a.q0.a.q2.e.a().g(this.f47420b, d.a.q0.a.q2.d.f50159d, d.a.q0.a.q2.d.f50157b, d.a.q0.a.q2.d.f50158c, d.a.q0.a.q2.d.f50164i, d.a.q0.a.q2.d.f50160e, d.a.q0.a.q2.d.f50161f, d.a.q0.a.q2.d.f50162g, d.a.q0.a.q2.d.f50163h, d.a.q0.a.q2.d.j, d.a.q0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f47419a = eVar;
            eVar.sendEmptyMessage(0);
            if (f47418i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f47424f) {
                if (f47418i) {
                    Log.d("PropertyMonitor", "System monitor not started yet");
                    return;
                }
                return;
            }
            this.f47424f = false;
            e eVar = this.f47419a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f47419a = null;
            }
            if (this.f47420b != null) {
                d.a.q0.a.q2.e.a().j(this.f47420b, new d.a.q0.a.q2.c[0]);
                this.f47420b = null;
            }
            this.f47421c = null;
            this.f47422d = null;
            if (f47418i) {
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
        this.f47423e = new ConcurrentHashMap();
        this.f47425g = 1000;
    }

    /* loaded from: classes8.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f47429e;

        /* renamed from: f  reason: collision with root package name */
        public int f47430f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f47431g;

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
            this.f47431g = bVar;
            this.f47429e = -1L;
            this.f47430f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.f47431g.f47424f) {
                long j2 = this.f47429e;
                if (j2 > 0 && this.f47430f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f47430f = i2;
                    this.f47431g.f47423e.put("frame", Integer.valueOf(i2));
                }
                this.f47429e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
