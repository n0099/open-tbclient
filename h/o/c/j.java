package h.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class j extends h.g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final j f75602a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static final class a extends g.a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f75603e;

        /* renamed from: f  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f75604f;

        /* renamed from: g  reason: collision with root package name */
        public final h.u.a f75605g;

        /* renamed from: h  reason: collision with root package name */
        public final AtomicInteger f75606h;

        /* renamed from: h.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C2109a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f75607e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f75608f;

            public C2109a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f75608f = aVar;
                this.f75607e = bVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f75608f.f75604f.remove(this.f75607e);
                }
            }
        }

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
                    return;
                }
            }
            this.f75603e = new AtomicInteger();
            this.f75604f = new PriorityBlockingQueue<>();
            this.f75605g = new h.u.a();
            this.f75606h = new AtomicInteger();
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? d(aVar, a()) : (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                long a2 = a() + timeUnit.toMillis(j);
                return d(new i(aVar, this, a2), a2);
            }
            return (k) invokeCommon.objValue;
        }

        public final k d(h.n.a aVar, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, aVar, j)) == null) {
                if (this.f75605g.isUnsubscribed()) {
                    return h.u.e.c();
                }
                b bVar = new b(aVar, Long.valueOf(j), this.f75603e.incrementAndGet());
                this.f75604f.add(bVar);
                if (this.f75606h.getAndIncrement() == 0) {
                    do {
                        b poll = this.f75604f.poll();
                        if (poll != null) {
                            poll.f75609e.call();
                        }
                    } while (this.f75606h.decrementAndGet() > 0);
                    return h.u.e.c();
                }
                return h.u.e.a(new C2109a(this, bVar));
            }
            return (k) invokeLJ.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75605g.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f75605g.unsubscribe();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.n.a f75609e;

        /* renamed from: f  reason: collision with root package name */
        public final Long f75610f;

        /* renamed from: g  reason: collision with root package name */
        public final int f75611g;

        public b(h.n.a aVar, Long l, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, l, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75609e = aVar;
            this.f75610f = l;
            this.f75611g = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                int compareTo = this.f75610f.compareTo(bVar.f75610f);
                return compareTo == 0 ? j.a(this.f75611g, bVar.f75611g) : compareTo;
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1371665488, "Lh/o/c/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1371665488, "Lh/o/c/j;");
                return;
            }
        }
        f75602a = new j();
    }

    public j() {
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

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            if (i2 < i3) {
                return -1;
            }
            return i2 == i3 ? 0 : 1;
        }
        return invokeII.intValue;
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (g.a) invokeV.objValue;
    }
}
