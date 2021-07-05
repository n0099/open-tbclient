package com.kwad.sdk.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.g.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.e;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class DecodeJob<R> implements a.c, e.a, Comparable<DecodeJob<?>>, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataSource A;
    public com.kwad.sdk.glide.load.a.d<?> B;
    public volatile com.kwad.sdk.glide.load.engine.e C;
    public volatile boolean D;
    public volatile boolean E;

    /* renamed from: a  reason: collision with root package name */
    public final f<R> f37928a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Throwable> f37929b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.g.a.c f37930c;

    /* renamed from: d  reason: collision with root package name */
    public final d f37931d;

    /* renamed from: e  reason: collision with root package name */
    public final Pools.Pool<DecodeJob<?>> f37932e;

    /* renamed from: f  reason: collision with root package name */
    public final c<?> f37933f;

    /* renamed from: g  reason: collision with root package name */
    public final e f37934g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.glide.e f37935h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.c f37936i;
    public Priority j;
    public l k;
    public int l;
    public int m;
    public h n;
    public com.kwad.sdk.glide.load.e o;
    public a<R> p;
    public int q;
    public Stage r;
    public RunReason s;
    public long t;
    public boolean u;
    public Object v;
    public Thread w;
    public com.kwad.sdk.glide.load.c x;
    public com.kwad.sdk.glide.load.c y;
    public Object z;

    /* renamed from: com.kwad.sdk.glide.load.engine.DecodeJob$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37937a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f37938b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f37939c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1436773608, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1436773608, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$1;");
                    return;
                }
            }
            int[] iArr = new int[EncodeStrategy.values().length];
            f37939c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37939c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f37938b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37938b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37938b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37938b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37938b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f37937a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37937a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37937a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class RunReason {
        public static final /* synthetic */ RunReason[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final RunReason DECODE_DATA;
        public static final RunReason INITIALIZE;
        public static final RunReason SWITCH_TO_SOURCE_SERVICE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1696901558, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$RunReason;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1696901558, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$RunReason;");
                    return;
                }
            }
            INITIALIZE = new RunReason("INITIALIZE", 0);
            SWITCH_TO_SOURCE_SERVICE = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
            RunReason runReason = new RunReason("DECODE_DATA", 2);
            DECODE_DATA = runReason;
            $VALUES = new RunReason[]{INITIALIZE, SWITCH_TO_SOURCE_SERVICE, runReason};
        }

        public RunReason(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static RunReason valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RunReason) Enum.valueOf(RunReason.class, str) : (RunReason) invokeL.objValue;
        }

        public static RunReason[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RunReason[]) $VALUES.clone() : (RunReason[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Stage {
        public static final /* synthetic */ Stage[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Stage DATA_CACHE;
        public static final Stage ENCODE;
        public static final Stage FINISHED;
        public static final Stage INITIALIZE;
        public static final Stage RESOURCE_CACHE;
        public static final Stage SOURCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(136863963, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$Stage;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(136863963, "Lcom/kwad/sdk/glide/load/engine/DecodeJob$Stage;");
                    return;
                }
            }
            INITIALIZE = new Stage("INITIALIZE", 0);
            RESOURCE_CACHE = new Stage("RESOURCE_CACHE", 1);
            DATA_CACHE = new Stage("DATA_CACHE", 2);
            SOURCE = new Stage("SOURCE", 3);
            ENCODE = new Stage("ENCODE", 4);
            Stage stage = new Stage("FINISHED", 5);
            FINISHED = stage;
            $VALUES = new Stage[]{INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, stage};
        }

        public Stage(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Stage valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Stage) Enum.valueOf(Stage.class, str) : (Stage) invokeL.objValue;
        }

        public static Stage[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Stage[]) $VALUES.clone() : (Stage[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface a<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(s<R> sVar, DataSource dataSource);
    }

    /* loaded from: classes7.dex */
    public final class b<Z> implements g.a<Z> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DecodeJob f37940a;

        /* renamed from: b  reason: collision with root package name */
        public final DataSource f37941b;

        public b(DecodeJob decodeJob, DataSource dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {decodeJob, dataSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37940a = decodeJob;
            this.f37941b = dataSource;
        }

        @Override // com.kwad.sdk.glide.load.engine.g.a
        @NonNull
        public s<Z> a(@NonNull s<Z> sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVar)) == null) ? this.f37940a.a(this.f37941b, sVar) : (s) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c<Z> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public com.kwad.sdk.glide.load.c f37942a;

        /* renamed from: b  reason: collision with root package name */
        public com.kwad.sdk.glide.load.g<Z> f37943b;

        /* renamed from: c  reason: collision with root package name */
        public r<Z> f37944c;

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
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.kwad.sdk.glide.load.g<X> */
        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.kwad.sdk.glide.load.engine.r<X> */
        /* JADX WARN: Multi-variable type inference failed */
        public <X> void a(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.g<X> gVar, r<X> rVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, cVar, gVar, rVar) == null) {
                this.f37942a = cVar;
                this.f37943b = gVar;
                this.f37944c = rVar;
            }
        }

        public void a(d dVar, com.kwad.sdk.glide.load.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, eVar) == null) {
                com.kwad.sdk.glide.g.a.b.a("DecodeJob.encode");
                try {
                    dVar.a().a(this.f37942a, new com.kwad.sdk.glide.load.engine.d(this.f37943b, this.f37944c, eVar));
                } finally {
                    this.f37944c.b();
                    com.kwad.sdk.glide.g.a.b.a();
                }
            }
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37944c != null : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f37942a = null;
                this.f37943b = null;
                this.f37944c = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        com.kwad.sdk.glide.load.engine.a.a a();
    }

    /* loaded from: classes7.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f37945a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37946b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37947c;

        public e() {
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

        private boolean b(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) ? (this.f37947c || z || this.f37946b) && this.f37945a : invokeZ.booleanValue;
        }

        public synchronized boolean a() {
            InterceptResult invokeV;
            boolean b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this) {
                    this.f37946b = true;
                    b2 = b(false);
                }
                return b2;
            }
            return invokeV.booleanValue;
        }

        public synchronized boolean a(boolean z) {
            InterceptResult invokeZ;
            boolean b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                synchronized (this) {
                    this.f37945a = true;
                    b2 = b(z);
                }
                return b2;
            }
            return invokeZ.booleanValue;
        }

        public synchronized boolean b() {
            InterceptResult invokeV;
            boolean b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    this.f37947c = true;
                    b2 = b(false);
                }
                return b2;
            }
            return invokeV.booleanValue;
        }

        public synchronized void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    this.f37946b = false;
                    this.f37945a = false;
                    this.f37947c = false;
                }
            }
        }
    }

    public DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, pool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37928a = new f<>();
        this.f37929b = new ArrayList();
        this.f37930c = com.kwad.sdk.glide.g.a.c.a();
        this.f37933f = new c<>();
        this.f37934g = new e();
        this.f37931d = dVar;
        this.f37932e = pool;
    }

    @NonNull
    private com.kwad.sdk.glide.load.e a(DataSource dataSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, dataSource)) == null) {
            com.kwad.sdk.glide.load.e eVar = this.o;
            if (Build.VERSION.SDK_INT < 26) {
                return eVar;
            }
            boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f37928a.m();
            Boolean bool = (Boolean) eVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38225d);
            if (bool == null || (bool.booleanValue() && !z)) {
                com.kwad.sdk.glide.load.e eVar2 = new com.kwad.sdk.glide.load.e();
                eVar2.a(this.o);
                eVar2.a(com.kwad.sdk.glide.load.resource.bitmap.k.f38225d, Boolean.valueOf(z));
                return eVar2;
            }
            return eVar;
        }
        return (com.kwad.sdk.glide.load.e) invokeL.objValue;
    }

    private Stage a(Stage stage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, stage)) == null) {
            int i2 = AnonymousClass1.f37938b[stage.ordinal()];
            if (i2 == 1) {
                return this.n.b() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
            } else if (i2 == 2) {
                return this.u ? Stage.FINISHED : Stage.SOURCE;
            } else if (i2 == 3 || i2 == 4) {
                return Stage.FINISHED;
            } else {
                if (i2 == 5) {
                    return this.n.a() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
                }
                throw new IllegalArgumentException("Unrecognized stage: " + stage);
            }
        }
        return (Stage) invokeL.objValue;
    }

    private <Data> s<R> a(com.kwad.sdk.glide.load.a.d<?> dVar, Data data, DataSource dataSource) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, dVar, data, dataSource)) == null) {
            if (data == null) {
                return null;
            }
            try {
                long a2 = com.kwad.sdk.glide.g.f.a();
                s<R> a3 = a((DecodeJob<R>) data, dataSource);
                if (Log.isLoggable(com.bumptech.glide.load.engine.DecodeJob.TAG, 2)) {
                    a("Decoded result " + a3, a2);
                }
                return a3;
            } finally {
                dVar.b();
            }
        }
        return (s) invokeLLL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.kwad.sdk.glide.load.engine.q<Data, ?, R>, com.kwad.sdk.glide.load.engine.q<Data, ResourceType, R> */
    private <Data> s<R> a(Data data, DataSource dataSource) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, data, dataSource)) == null) ? a((DecodeJob<R>) data, dataSource, (q<DecodeJob<R>, ResourceType, R>) ((q<Data, ?, R>) this.f37928a.b(data.getClass()))) : (s) invokeLL.objValue;
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, data, dataSource, qVar)) == null) {
            com.kwad.sdk.glide.load.e a2 = a(dataSource);
            com.kwad.sdk.glide.load.a.e<Data> b2 = this.f37935h.d().b((Registry) data);
            try {
                return qVar.a(b2, a2, this.l, this.m, new b(this, dataSource));
            } finally {
                b2.b();
            }
        }
        return (s) invokeLLL.objValue;
    }

    private void a(s<R> sVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, sVar, dataSource) == null) {
            m();
            this.p.a(sVar, dataSource);
        }
    }

    private void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65543, this, str, j) == null) {
            a(str, j, (String) null);
        }
    }

    private void a(String str, long j, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{str, Long.valueOf(j), str2}) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" in ");
            sb.append(com.kwad.sdk.glide.g.f.a(j));
            sb.append(", load key: ");
            sb.append(this.k);
            if (str2 != null) {
                str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + str2;
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(", thread: ");
            sb.append(Thread.currentThread().getName());
            Log.v(com.bumptech.glide.load.engine.DecodeJob.TAG, sb.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.kwad.sdk.glide.load.engine.r */
    /* JADX WARN: Multi-variable type inference failed */
    private void b(s<R> sVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, sVar, dataSource) == null) {
            if (sVar instanceof o) {
                ((o) sVar).b();
            }
            r rVar = 0;
            if (this.f37933f.a()) {
                sVar = r.a(sVar);
                rVar = sVar;
            }
            a((s) sVar, dataSource);
            this.r = Stage.ENCODE;
            try {
                if (this.f37933f.a()) {
                    this.f37933f.a(this.f37931d, this.o);
                }
                e();
            } finally {
                if (rVar != 0) {
                    rVar.b();
                }
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, this) == null) && this.f37934g.a()) {
            g();
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, this) == null) && this.f37934g.b()) {
            g();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f37934g.c();
            this.f37933f.b();
            this.f37928a.a();
            this.D = false;
            this.f37935h = null;
            this.f37936i = null;
            this.o = null;
            this.j = null;
            this.k = null;
            this.p = null;
            this.r = null;
            this.C = null;
            this.w = null;
            this.x = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.t = 0L;
            this.E = false;
            this.v = null;
            this.f37929b.clear();
            this.f37932e.release(this);
        }
    }

    private int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) ? this.j.ordinal() : invokeV.intValue;
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int i2 = AnonymousClass1.f37937a[this.s.ordinal()];
            if (i2 == 1) {
                this.r = a(Stage.INITIALIZE);
                this.C = j();
            } else if (i2 != 2) {
                if (i2 == 3) {
                    n();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.s);
            }
            k();
        }
    }

    private com.kwad.sdk.glide.load.engine.e j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            int i2 = AnonymousClass1.f37938b[this.r.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return null;
                        }
                        throw new IllegalStateException("Unrecognized stage: " + this.r);
                    }
                    return new w(this.f37928a, this);
                }
                return new com.kwad.sdk.glide.load.engine.b(this.f37928a, this);
            }
            return new t(this.f37928a, this);
        }
        return (com.kwad.sdk.glide.load.engine.e) invokeV.objValue;
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            this.w = Thread.currentThread();
            this.t = com.kwad.sdk.glide.g.f.a();
            boolean z = false;
            while (!this.E && this.C != null && !(z = this.C.a())) {
                this.r = a(this.r);
                this.C = j();
                if (this.r == Stage.SOURCE) {
                    c();
                    return;
                }
            }
            if ((this.r == Stage.FINISHED || this.E) && !z) {
                l();
            }
        }
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            m();
            this.p.a(new GlideException("Failed to load resource", new ArrayList(this.f37929b)));
            f();
        }
    }

    private void m() {
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.f37930c.b();
            if (!this.D) {
                this.D = true;
                return;
            }
            if (this.f37929b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f37929b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (Log.isLoggable(com.bumptech.glide.load.engine.DecodeJob.TAG, 2)) {
                long j = this.t;
                a("Retrieved data", j, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
            }
            s<R> sVar = null;
            try {
                sVar = a(this.B, (com.kwad.sdk.glide.load.a.d<?>) this.z, this.A);
            } catch (GlideException e2) {
                e2.setLoggingDetails(this.y, this.A);
                this.f37929b.add(e2);
            }
            if (sVar != null) {
                b(sVar, this.A);
            } else {
                k();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, decodeJob)) == null) {
            int h2 = h() - decodeJob.h();
            return h2 == 0 ? this.q - decodeJob.q : h2;
        }
        return invokeL.intValue;
    }

    public DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.e eVar2, a<R> aVar, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, obj, lVar, cVar, Integer.valueOf(i2), Integer.valueOf(i3), cls, cls2, priority, hVar, map, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), eVar2, aVar, Integer.valueOf(i4)})) == null) {
            this.f37928a.a(eVar, obj, cVar, i2, i3, hVar, cls, cls2, priority, eVar2, map, z, z2, this.f37931d);
            this.f37935h = eVar;
            this.f37936i = cVar;
            this.j = priority;
            this.k = lVar;
            this.l = i2;
            this.m = i3;
            this.n = hVar;
            this.u = z3;
            this.o = eVar2;
            this.p = aVar;
            this.q = i4;
            this.s = RunReason.INITIALIZE;
            this.v = obj;
            return this;
        }
        return (DecodeJob) invokeCommon.objValue;
    }

    @NonNull
    public <Z> s<Z> a(DataSource dataSource, @NonNull s<Z> sVar) {
        InterceptResult invokeLL;
        s<Z> sVar2;
        com.kwad.sdk.glide.load.h<Z> hVar;
        EncodeStrategy encodeStrategy;
        com.kwad.sdk.glide.load.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataSource, sVar)) == null) {
            Class<?> cls = sVar.e().getClass();
            com.kwad.sdk.glide.load.g<Z> gVar = null;
            if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
                com.kwad.sdk.glide.load.h<Z> c2 = this.f37928a.c(cls);
                hVar = c2;
                sVar2 = c2.a(this.f37935h, sVar, this.l, this.m);
            } else {
                sVar2 = sVar;
                hVar = null;
            }
            if (!sVar.equals(sVar2)) {
                sVar.d_();
            }
            if (this.f37928a.a((s<?>) sVar2)) {
                gVar = this.f37928a.b(sVar2);
                encodeStrategy = gVar.a(this.o);
            } else {
                encodeStrategy = EncodeStrategy.NONE;
            }
            com.kwad.sdk.glide.load.g gVar2 = gVar;
            if (this.n.a(!this.f37928a.a(this.x), dataSource, encodeStrategy)) {
                if (gVar2 != null) {
                    int i2 = AnonymousClass1.f37939c[encodeStrategy.ordinal()];
                    if (i2 == 1) {
                        cVar = new com.kwad.sdk.glide.load.engine.c(this.x, this.f37936i);
                    } else if (i2 != 2) {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    } else {
                        cVar = new u(this.f37928a.i(), this.x, this.f37936i, this.l, this.m, hVar, cls, this.o);
                    }
                    r a2 = r.a(sVar2);
                    this.f37933f.a(cVar, gVar2, a2);
                    return a2;
                }
                throw new Registry.NoResultEncoderAvailableException(sVar2.e().getClass());
            }
            return sVar2;
        }
        return (s) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, cVar, exc, dVar, dataSource) == null) {
            dVar.b();
            GlideException glideException = new GlideException("Fetching data failed", exc);
            glideException.setLoggingDetails(cVar, dataSource, dVar.a());
            this.f37929b.add(glideException);
            if (Thread.currentThread() == this.w) {
                k();
                return;
            }
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((DecodeJob<?>) this);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, cVar, obj, dVar, dataSource, cVar2) == null) {
            this.x = cVar;
            this.z = obj;
            this.B = dVar;
            this.A = dataSource;
            this.y = cVar2;
            if (Thread.currentThread() != this.w) {
                this.s = RunReason.DECODE_DATA;
                this.p.a((DecodeJob<?>) this);
                return;
            }
            com.kwad.sdk.glide.g.a.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                n();
            } finally {
                com.kwad.sdk.glide.g.a.b.a();
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && this.f37934g.a(z)) {
            g();
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Stage a2 = a(Stage.INITIALIZE);
            return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.E = true;
            com.kwad.sdk.glide.load.engine.e eVar = this.C;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.p.a((DecodeJob<?>) this);
        }
    }

    @Override // com.kwad.sdk.glide.g.a.a.c
    @NonNull
    public com.kwad.sdk.glide.g.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37930c : (com.kwad.sdk.glide.g.a.c) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.sdk.glide.g.a.b.a("DecodeJob#run(model=%s)", this.v);
            com.kwad.sdk.glide.load.a.d<?> dVar = this.B;
            try {
                try {
                    if (this.E) {
                        l();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.kwad.sdk.glide.g.a.b.a();
                        return;
                    }
                    i();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.kwad.sdk.glide.g.a.b.a();
                } catch (CallbackException e2) {
                    throw e2;
                }
            }
        }
    }
}
