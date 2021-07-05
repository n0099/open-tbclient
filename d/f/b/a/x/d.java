package d.f.b.a.x;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes10.dex */
public interface d {

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Handler f73569a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final d f73570b;

        /* renamed from: d.f.b.a.x.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2026a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.y.d f73571e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73572f;

            public RunnableC2026a(a aVar, d.f.b.a.y.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73572f = aVar;
                this.f73571e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73572f.f73570b.d(this.f73571e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f73573e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f73574f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f73575g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f73576h;

            public b(a aVar, String str, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73576h = aVar;
                this.f73573e = str;
                this.f73574f = j;
                this.f73575g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73576h.f73570b.b(this.f73573e, this.f73574f, this.f73575g);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f73577e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73578f;

            public c(a aVar, Format format) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, format};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73578f = aVar;
                this.f73577e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73578f.f73570b.n(this.f73577e);
                }
            }
        }

        /* renamed from: d.f.b.a.x.d$a$d  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2027d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f73579e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f73580f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f73581g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f73582h;

            public RunnableC2027d(a aVar, int i2, long j, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73582h = aVar;
                this.f73579e = i2;
                this.f73580f = j;
                this.f73581g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73582h.f73570b.j(this.f73579e, this.f73580f, this.f73581g);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.y.d f73583e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73584f;

            public e(a aVar, d.f.b.a.y.d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73584f = aVar;
                this.f73583e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73583e.a();
                    this.f73584f.f73570b.l(this.f73583e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f73585e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73586f;

            public f(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73586f = aVar;
                this.f73585e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73586f.f73570b.a(this.f73585e);
                }
            }
        }

        public a(@Nullable Handler handler, @Nullable d dVar) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (dVar != null) {
                d.f.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f73569a = handler2;
            this.f73570b = dVar;
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new f(this, i2));
        }

        public void c(int i2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new RunnableC2027d(this, i2, j, j2));
        }

        public void d(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new b(this, str, j, j2));
        }

        public void e(d.f.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new e(this, dVar));
        }

        public void f(d.f.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new RunnableC2026a(this, dVar));
        }

        public void g(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, format) == null) || this.f73570b == null) {
                return;
            }
            this.f73569a.post(new c(this, format));
        }
    }

    void a(int i2);

    void b(String str, long j, long j2);

    void d(d.f.b.a.y.d dVar);

    void j(int i2, long j, long j2);

    void l(d.f.b.a.y.d dVar);

    void n(Format format);
}
