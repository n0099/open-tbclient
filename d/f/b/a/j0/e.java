package d.f.b.a.j0;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
/* loaded from: classes10.dex */
public interface e {

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Handler f73468a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final e f73469b;

        /* renamed from: d.f.b.a.j0.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2022a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.y.d f73470e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73471f;

            public RunnableC2022a(a aVar, d.f.b.a.y.d dVar) {
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
                this.f73471f = aVar;
                this.f73470e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73471f.f73469b.m(this.f73470e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f73472e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f73473f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ long f73474g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f73475h;

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
                this.f73475h = aVar;
                this.f73472e = str;
                this.f73473f = j;
                this.f73474g = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73475h.f73469b.e(this.f73472e, this.f73473f, this.f73474g);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Format f73476e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73477f;

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
                this.f73477f = aVar;
                this.f73476e = format;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73477f.f73469b.h(this.f73476e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f73478e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f73479f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f73480g;

            public d(a aVar, int i2, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73480g = aVar;
                this.f73478e = i2;
                this.f73479f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73480g.f73469b.c(this.f73478e, this.f73479f);
                }
            }
        }

        /* renamed from: d.f.b.a.j0.e$a$e  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class RunnableC2023e implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f73481e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f73482f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f73483g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ float f73484h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ a f73485i;

            public RunnableC2023e(a aVar, int i2, int i3, int i4, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73485i = aVar;
                this.f73481e = i2;
                this.f73482f = i3;
                this.f73483g = i4;
                this.f73484h = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73485i.f73469b.onVideoSizeChanged(this.f73481e, this.f73482f, this.f73483g, this.f73484h);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class f implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Surface f73486e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73487f;

            public f(a aVar, Surface surface) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, surface};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73487f = aVar;
                this.f73486e = surface;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73487f.f73469b.f(this.f73486e);
                }
            }
        }

        /* loaded from: classes10.dex */
        public class g implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.f.b.a.y.d f73488e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f73489f;

            public g(a aVar, d.f.b.a.y.d dVar) {
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
                this.f73489f = aVar;
                this.f73488e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73488e.a();
                    this.f73489f.f73469b.k(this.f73488e);
                }
            }
        }

        public a(@Nullable Handler handler, @Nullable e eVar) {
            Handler handler2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (eVar != null) {
                d.f.b.a.i0.a.e(handler);
                handler2 = handler;
            } else {
                handler2 = null;
            }
            this.f73468a = handler2;
            this.f73469b = eVar;
        }

        public void b(String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new b(this, str, j, j2));
        }

        public void c(d.f.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new g(this, dVar));
        }

        public void d(int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new d(this, i2, j));
        }

        public void e(d.f.b.a.y.d dVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new RunnableC2022a(this, dVar));
        }

        public void f(Format format) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, format) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new c(this, format));
        }

        public void g(Surface surface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, surface) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new f(this, surface));
        }

        public void h(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) || this.f73469b == null) {
                return;
            }
            this.f73468a.post(new RunnableC2023e(this, i2, i3, i4, f2));
        }
    }

    void c(int i2, long j);

    void e(String str, long j, long j2);

    void f(Surface surface);

    void h(Format format);

    void k(d.f.b.a.y.d dVar);

    void m(d.f.b.a.y.d dVar);

    void onVideoSizeChanged(int i2, int i3, int i4, float f2);
}
