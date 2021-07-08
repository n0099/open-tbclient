package d.b.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.IOaidObserver;
import d.b.a.q0;
import d.b.a.v0;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class u0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final String f68856i;
    public static final String j;
    @Nullable
    public static IOaidObserver k;
    public static String l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f68857a;

    /* renamed from: b  reason: collision with root package name */
    public v0 f68858b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68859c;

    /* renamed from: d  reason: collision with root package name */
    public y0 f68860d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f68861e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f68862f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f68863g;

    /* renamed from: h  reason: collision with root package name */
    public Long f68864h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ u0 f68865e;

        public a(u0 u0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68865e = u0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f68865e.j();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(413443374, "Ld/b/a/u0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(413443374, "Ld/b/a/u0;");
                return;
            }
        }
        String str = u0.class.getSimpleName() + "#";
        f68856i = str;
        j = str;
    }

    public u0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68857a = new ReentrantLock();
        this.f68862f = new AtomicBoolean(false);
        this.f68861e = context;
        v0 a2 = w0.a(context);
        this.f68858b = a2;
        if (a2 != null) {
            this.f68859c = a2.a(context);
        } else {
            this.f68859c = false;
        }
        this.f68860d = new y0(context);
    }

    public static void d(@Nullable IOaidObserver.Oaid oaid) {
        IOaidObserver iOaidObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, oaid) == null) || oaid == null || (iOaidObserver = k) == null) {
            return;
        }
        iOaidObserver.onOaidLoaded(oaid);
    }

    @AnyThread
    public static void e(@Nullable IOaidObserver iOaidObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iOaidObserver) == null) {
            k = iOaidObserver;
            String str = l;
            if (str != null) {
                d(new IOaidObserver.Oaid(str));
            }
        }
    }

    public static void g(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, runnable) == null) {
            p0.a(j + "-query", runnable);
        }
    }

    public static <K, V> void h(Map<K, V> map, K k2, V v) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, map, k2, v) == null) || k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void i(JSONObject jSONObject, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, jSONObject, str, obj) == null) || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    @WorkerThread
    public final Pair<String, Boolean> a(Context context) {
        InterceptResult invokeL;
        Boolean bool;
        v0.a b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            v0 v0Var = this.f68858b;
            String str = null;
            if (v0Var == null || (b2 = v0Var.b(context)) == null) {
                bool = null;
            } else {
                str = b2.f68867a;
                bool = Boolean.valueOf(b2.f68868b);
                if (b2 instanceof q0.c) {
                    this.f68864h = Long.valueOf(((q0.c) b2).f68846c);
                }
            }
            return new Pair<>(str, bool);
        }
        return (Pair) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (r2 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        if (r2 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
        r5.f68857a.unlock();
     */
    @Nullable
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            if (this.f68859c) {
                c();
                String str = j;
                o0.c(str, "Oaid#getOaid timeoutMills=" + j2);
                if (this.f68863g == null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z = false;
                    try {
                        try {
                            z = this.f68857a.tryLock(j2, TimeUnit.MILLISECONDS);
                            String str2 = j;
                            o0.e(str2, "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        if (z) {
                            this.f68857a.unlock();
                        }
                        throw th;
                    }
                }
                String str3 = j;
                o0.c(str3, "Oaid#getOaid return apiMap=" + this.f68863g);
                return this.f68863g;
            }
            return null;
        }
        return (Map) invokeJ.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f68862f.compareAndSet(false, true)) {
            g(new a(this));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            o0.e(j, "Oaid#initOaid");
            try {
                this.f68857a.lock();
                o0.e(j, "Oaid#initOaid exec");
                x0 a2 = this.f68860d.a();
                String str = j;
                o0.e(str, "Oaid#initOaid fetch=" + a2);
                if (a2 != null) {
                    l = a2.f68871a;
                    this.f68863g = a2.b();
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Pair<String, Boolean> a3 = a(this.f68861e);
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                x0 x0Var = null;
                String str2 = null;
                if (a3.first != null) {
                    int i2 = -1;
                    int i3 = 1;
                    if (a2 != null) {
                        str2 = a2.f68872b;
                        i2 = a2.f68876f.intValue() + 1;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                    }
                    String str3 = str2;
                    if (i2 > 0) {
                        i3 = i2;
                    }
                    x0 x0Var2 = new x0((String) a3.first, str3, (Boolean) a3.second, Long.valueOf(elapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i3), this.f68864h);
                    this.f68860d.b(x0Var2);
                    x0Var = x0Var2;
                }
                if (x0Var != null) {
                    l = x0Var.f68871a;
                    this.f68863g = x0Var.b();
                }
                String str4 = j;
                o0.e(str4, "Oaid#initOaid oaidModel=" + x0Var);
            } finally {
                this.f68857a.unlock();
                d(new IOaidObserver.Oaid(l));
            }
        }
    }
}
