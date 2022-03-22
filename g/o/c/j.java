package g.o.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.g;
import g.k;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class j extends g.g {
    public static /* synthetic */ Interceptable $ic;
    public static final j a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a extends g.a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;

        /* renamed from: b  reason: collision with root package name */
        public final PriorityBlockingQueue<b> f44979b;

        /* renamed from: c  reason: collision with root package name */
        public final g.u.a f44980c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicInteger f44981d;

        /* renamed from: g.o.c.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C2145a implements g.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f44982b;

            public C2145a(a aVar, b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44982b = aVar;
                this.a = bVar;
            }

            @Override // g.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44982b.f44979b.remove(this.a);
                }
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger();
            this.f44979b = new PriorityBlockingQueue<>();
            this.f44980c = new g.u.a();
            this.f44981d = new AtomicInteger();
        }

        @Override // g.g.a
        public k b(g.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) ? d(aVar, a()) : (k) invokeL.objValue;
        }

        @Override // g.g.a
        public k c(g.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                long a = a() + timeUnit.toMillis(j);
                return d(new i(aVar, this, a), a);
            }
            return (k) invokeCommon.objValue;
        }

        public final k d(g.n.a aVar, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, aVar, j)) == null) {
                if (this.f44980c.isUnsubscribed()) {
                    return g.u.e.c();
                }
                b bVar = new b(aVar, Long.valueOf(j), this.a.incrementAndGet());
                this.f44979b.add(bVar);
                if (this.f44981d.getAndIncrement() == 0) {
                    do {
                        b poll = this.f44979b.poll();
                        if (poll != null) {
                            poll.a.call();
                        }
                    } while (this.f44981d.decrementAndGet() > 0);
                    return g.u.e.c();
                }
                return g.u.e.a(new C2145a(this, bVar));
            }
            return (k) invokeLJ.objValue;
        }

        @Override // g.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f44980c.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // g.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f44980c.unsubscribe();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Comparable<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g.n.a a;

        /* renamed from: b  reason: collision with root package name */
        public final Long f44983b;

        /* renamed from: c  reason: collision with root package name */
        public final int f44984c;

        public b(g.n.a aVar, Long l, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, l, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f44983b = l;
            this.f44984c = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                int compareTo = this.f44983b.compareTo(bVar.f44983b);
                return compareTo == 0 ? j.a(this.f44984c, bVar.f44984c) : compareTo;
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1180491473, "Lg/o/c/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1180491473, "Lg/o/c/j;");
                return;
            }
        }
        a = new j();
    }

    public j() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i, i2)) == null) {
            if (i < i2) {
                return -1;
            }
            return i == i2 ? 0 : 1;
        }
        return invokeII.intValue;
    }

    @Override // g.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a() : (g.a) invokeV.objValue;
    }
}
