package d.a.o0.a.e0.g;

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
import d.a.o0.a.k;
import d.a.o0.a.q2.e;
import d.a.o0.a.v2.q;
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
    public static final boolean f44620i;
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
    public e f44621a;

    /* renamed from: b  reason: collision with root package name */
    public f f44622b;

    /* renamed from: c  reason: collision with root package name */
    public c f44623c;

    /* renamed from: d  reason: collision with root package name */
    public RunnableC0680b f44624d;

    /* renamed from: e  reason: collision with root package name */
    public ConcurrentMap<String, Object> f44625e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44626f;

    /* renamed from: g  reason: collision with root package name */
    public int f44627g;

    /* renamed from: h  reason: collision with root package name */
    public int f44628h;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.o0.a.e0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0680b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f44630f;

        public RunnableC0680b(b bVar) {
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
            this.f44630f = bVar;
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
                if (b.f44620i) {
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
                        if (b.f44620i) {
                            Log.d("PropertyMonitor", "stop cpu monitor thread , cpu rate is : " + c2);
                        }
                        d.a.o0.t.d.d(bufferedReader);
                        return c2;
                    } catch (IOException e3) {
                        e2 = e3;
                        if (b.f44620i) {
                            Log.e("PropertyMonitor", "error in cpu monitor", e2);
                        }
                        d.a.o0.t.d.d(bufferedReader);
                        return "";
                    }
                } catch (IOException e4) {
                    bufferedReader = null;
                    e2 = e4;
                } catch (Throwable th2) {
                    th = th2;
                    d.a.o0.t.d.d(null);
                    throw th;
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:6|(1:9)|10|(6:12|(1:15)|16|17|18|19)|(1:27)(1:32)|(1:31)|16|17|18|19) */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
            r12 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (d.a.o0.a.e0.g.b.f44620i != false) goto L25;
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
                this.f44629e = true;
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    this.f44630f.f44625e.put("cpu", b2);
                }
                this.f44629e = false;
            }
        }

        public /* synthetic */ RunnableC0680b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f44634a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1439620622, "Ld/a/o0/a/e0/g/b$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1439620622, "Ld/a/o0/a/e0/g/b$d;");
                    return;
                }
            }
            f44634a = new b(null);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes7.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f44635a;

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
            this.f44635a = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || this.f44635a.f44625e == null) {
                return;
            }
            this.f44635a.g();
            this.f44635a.f44625e.put("mem", Long.valueOf(((ActivityManager) d.a.o0.a.c1.a.b().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() / 1000));
            if (this.f44635a.f44621a != null) {
                this.f44635a.f44621a.sendEmptyMessageDelayed(0, this.f44635a.f44627g);
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
        public final /* synthetic */ b f44636e;

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
            this.f44636e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Set<d.a.o0.a.q2.c<?>> set) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, set) == null) || set == null || set.size() <= 0) {
                return;
            }
            for (d.a.o0.a.q2.c<?> cVar : set) {
                this.f44636e.f44625e.put(cVar.f47356a, cVar.a());
            }
        }

        public /* synthetic */ f(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2079708046, "Ld/a/o0/a/e0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2079708046, "Ld/a/o0/a/e0/g/b;");
                return;
            }
        }
        f44620i = k.f46335a;
        j = d.a.o0.a.q2.d.f47361d.f47356a;
        k = d.a.o0.a.q2.d.f47359b.f47356a;
        l = d.a.o0.a.q2.d.f47360c.f47356a;
        String str = d.a.o0.a.q2.d.f47364g.f47356a;
        m = d.a.o0.a.q2.d.f47366i.f47356a;
        n = d.a.o0.a.q2.d.f47362e.f47356a;
        o = d.a.o0.a.q2.d.f47363f.f47356a;
        p = d.a.o0.a.q2.d.f47365h.f47356a;
        q = d.a.o0.a.q2.d.j.f47356a;
        r = d.a.o0.a.q2.d.k.f47356a;
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? d.f44634a : (b) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44624d.f44629e) {
            return;
        }
        q.j(this.f44624d, "swanAppCpuMonitor");
    }

    public Map<String, Object> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f44628h++;
            k();
            return this.f44625e;
        }
        return (Map) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.f44628h - 1;
            this.f44628h = i2;
            if (i2 <= 0) {
                l();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f44626f) {
                if (f44620i) {
                    Log.d("PropertyMonitor", "System monitor already started");
                    return;
                }
                return;
            }
            this.f44626f = true;
            this.f44623c = new c(this, null);
            Choreographer.getInstance().postFrameCallback(this.f44623c);
            this.f44624d = new RunnableC0680b(this, null);
            this.f44622b = new f(this, null);
            d.a.o0.a.q2.e.a().g(this.f44622b, d.a.o0.a.q2.d.f47361d, d.a.o0.a.q2.d.f47359b, d.a.o0.a.q2.d.f47360c, d.a.o0.a.q2.d.f47366i, d.a.o0.a.q2.d.f47362e, d.a.o0.a.q2.d.f47363f, d.a.o0.a.q2.d.f47364g, d.a.o0.a.q2.d.f47365h, d.a.o0.a.q2.d.j, d.a.o0.a.q2.d.k);
            e eVar = new e(this, null);
            this.f44621a = eVar;
            eVar.sendEmptyMessage(0);
            if (f44620i) {
                Log.d("PropertyMonitor", "Start system monitor");
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f44626f) {
                if (f44620i) {
                    Log.d("PropertyMonitor", "System monitor not started yet");
                    return;
                }
                return;
            }
            this.f44626f = false;
            e eVar = this.f44621a;
            if (eVar != null) {
                eVar.removeMessages(0);
                this.f44621a = null;
            }
            if (this.f44622b != null) {
                d.a.o0.a.q2.e.a().j(this.f44622b, new d.a.o0.a.q2.c[0]);
                this.f44622b = null;
            }
            this.f44623c = null;
            this.f44624d = null;
            if (f44620i) {
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
        this.f44625e = new ConcurrentHashMap();
        this.f44627g = 1000;
    }

    /* loaded from: classes7.dex */
    public class c implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f44631e;

        /* renamed from: f  reason: collision with root package name */
        public int f44632f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f44633g;

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
            this.f44633g = bVar;
            this.f44631e = -1L;
            this.f44632f = -1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.f44633g.f44626f) {
                long j2 = this.f44631e;
                if (j2 > 0 && this.f44632f != (i2 = (int) ((1.0d / (j - j2)) * 1.0E9d))) {
                    this.f44632f = i2;
                    this.f44633g.f44625e.put("frame", Integer.valueOf(i2));
                }
                this.f44631e = j;
                Choreographer.getInstance().postFrameCallback(this);
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }
}
