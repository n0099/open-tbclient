package h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final f f72769a;

    /* loaded from: classes2.dex */
    public static class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        @Override // h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                cVar.onSubscribe(h.u.e.c());
                cVar.onCompleted();
            }
        }
    }

    /* renamed from: h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2083b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f72770e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f72771f;

        /* renamed from: h.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements h.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g.a f72772e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h.c f72773f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ h.o.d.h f72774g;

            /* renamed from: h.b$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C2084a implements h.n.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f72775e;

                public C2084a(a aVar) {
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
                    this.f72775e = aVar;
                }

                @Override // h.n.a
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.f72775e.f72773f.onCompleted();
                        } finally {
                            this.f72775e.f72774g.unsubscribe();
                        }
                    }
                }
            }

            /* renamed from: h.b$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C2085b implements h.n.a {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Throwable f72776e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ a f72777f;

                public C2085b(a aVar, Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, th};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72777f = aVar;
                    this.f72776e = th;
                }

                @Override // h.n.a
                public void call() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        try {
                            this.f72777f.f72773f.onError(this.f72776e);
                        } finally {
                            this.f72777f.f72774g.unsubscribe();
                        }
                    }
                }
            }

            public a(C2083b c2083b, g.a aVar, h.c cVar, h.o.d.h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2083b, aVar, cVar, hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72772e = aVar;
                this.f72773f = cVar;
                this.f72774g = hVar;
            }

            @Override // h.c
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f72772e.b(new C2084a(this));
                }
            }

            @Override // h.c
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f72772e.b(new C2085b(this, th));
                }
            }

            @Override // h.c
            public void onSubscribe(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                    this.f72774g.a(kVar);
                }
            }
        }

        public C2083b(b bVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72771f = bVar;
            this.f72770e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                h.o.d.h hVar = new h.o.d.h();
                g.a createWorker = this.f72770e.createWorker();
                hVar.a(createWorker);
                cVar.onSubscribe(hVar);
                this.f72771f.j(new a(this, createWorker, cVar, hVar));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.u.c f72778e;

        public c(b bVar, h.u.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72778e = cVar;
        }

        @Override // h.c
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f72778e.unsubscribe();
            }
        }

        @Override // h.c
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                h.r.c.j(th);
                this.f72778e.unsubscribe();
                b.c(th);
            }
        }

        @Override // h.c
        public void onSubscribe(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kVar) == null) {
                this.f72778e.a(kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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
        @Override // h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                cVar.onSubscribe(h.u.e.c());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f72779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f72780f;

        /* loaded from: classes2.dex */
        public class a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h.c f72781e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g.a f72782f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ e f72783g;

            public a(e eVar, h.c cVar, g.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72783g = eVar;
                this.f72781e = cVar;
                this.f72782f = aVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f72783g.f72780f.j(this.f72781e);
                    } finally {
                        this.f72782f.unsubscribe();
                    }
                }
            }
        }

        public e(b bVar, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72780f = bVar;
            this.f72779e = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.b.f, h.n.b
        public void call(h.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                g.a createWorker = this.f72779e.createWorker();
                createWorker.b(new a(this, cVar, createWorker));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f extends h.n.b<h.c> {
        @Override // h.n.b
        /* synthetic */ void call(T t);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73334124, "Lh/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73334124, "Lh/b;");
                return;
            }
        }
        new b(new a(), false);
        new b(new d(), false);
    }

    public b(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f72769a = h.r.c.g(fVar);
    }

    public static b a(Iterable<? extends b> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
            e(iterable);
            return b(new CompletableOnSubscribeConcatIterable(iterable));
        }
        return (b) invokeL.objValue;
    }

    public static b b(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar)) == null) {
            e(fVar);
            try {
                return new b(fVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                h.r.c.j(th);
                throw i(th);
            }
        }
        return (b) invokeL.objValue;
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, th) == null) {
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    public static <T> T e(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static NullPointerException i(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, th)) == null) {
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            return nullPointerException;
        }
        return (NullPointerException) invokeL.objValue;
    }

    public final b d(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            e(gVar);
            return b(new C2083b(this, gVar));
        }
        return (b) invokeL.objValue;
    }

    public final k f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.u.c cVar = new h.u.c();
            j(new c(this, cVar));
            return cVar;
        }
        return (k) invokeV.objValue;
    }

    public final void g(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            if (!(cVar instanceof h.q.b)) {
                cVar = new h.q.b(cVar);
            }
            j(cVar);
        }
    }

    public final b h(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gVar)) == null) {
            e(gVar);
            return b(new e(this, gVar));
        }
        return (b) invokeL.objValue;
    }

    public final void j(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            e(cVar);
            try {
                h.r.c.e(this, this.f72769a).call(cVar);
            } catch (NullPointerException e2) {
                throw e2;
            } catch (Throwable th) {
                h.m.a.e(th);
                Throwable d2 = h.r.c.d(th);
                h.r.c.j(d2);
                throw i(d2);
            }
        }
    }

    public b(f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f72769a = z ? h.r.c.g(fVar) : fVar;
    }
}
