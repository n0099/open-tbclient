package rx.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
import h.k;
import h.u.e;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class TestScheduler extends g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static long f73769c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Queue<c> f73770a;

    /* renamed from: b  reason: collision with root package name */
    public long f73771b;

    /* loaded from: classes9.dex */
    public static final class a implements Comparator<c> {
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
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, cVar2)) == null) {
                long j = cVar.f73778a;
                long j2 = cVar2.f73778a;
                if (j == j2) {
                    if (cVar.f73781d < cVar2.f73781d) {
                        return -1;
                    }
                    return cVar.f73781d > cVar2.f73781d ? 1 : 0;
                } else if (j < j2) {
                    return -1;
                } else {
                    return j > j2 ? 1 : 0;
                }
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public final class b extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final h.u.a f73772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TestScheduler f73773f;

        /* loaded from: classes9.dex */
        public class a implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f73774e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f73775f;

            public a(b bVar, c cVar) {
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
                this.f73775f = bVar;
                this.f73774e = cVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73775f.f73773f.f73770a.remove(this.f73774e);
                }
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C2098b implements h.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f73776e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f73777f;

            public C2098b(b bVar, c cVar) {
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
                this.f73777f = bVar;
                this.f73776e = cVar;
            }

            @Override // h.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73777f.f73773f.f73770a.remove(this.f73776e);
                }
            }
        }

        public b(TestScheduler testScheduler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {testScheduler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73773f = testScheduler;
            this.f73772e = new h.u.a();
        }

        @Override // h.g.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f73773f.now() : invokeV.longValue;
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                c cVar = new c(this, 0L, aVar);
                this.f73773f.f73770a.add(cVar);
                return e.a(new C2098b(this, cVar));
            }
            return (k) invokeL.objValue;
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Long.valueOf(j), timeUnit})) == null) {
                c cVar = new c(this, this.f73773f.f73771b + timeUnit.toNanos(j), aVar);
                this.f73773f.f73770a.add(cVar);
                return e.a(new a(this, cVar));
            }
            return (k) invokeCommon.objValue;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f73772e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f73772e.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f73778a;

        /* renamed from: b  reason: collision with root package name */
        public final h.n.a f73779b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f73780c;

        /* renamed from: d  reason: collision with root package name */
        public final long f73781d;

        public c(g.a aVar, long j, h.n.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            long j2 = TestScheduler.f73769c;
            TestScheduler.f73769c = 1 + j2;
            this.f73781d = j2;
            this.f73778a = j;
            this.f73779b = aVar2;
            this.f73780c = aVar;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.f73778a), this.f73779b.toString()) : (String) invokeV.objValue;
        }
    }

    public TestScheduler() {
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
        this.f73770a = new PriorityQueue(11, new a());
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            while (!this.f73770a.isEmpty()) {
                c peek = this.f73770a.peek();
                long j2 = peek.f73778a;
                if (j2 > j) {
                    break;
                }
                if (j2 == 0) {
                    j2 = this.f73771b;
                }
                this.f73771b = j2;
                this.f73770a.remove();
                if (!peek.f73780c.isUnsubscribed()) {
                    peek.f73779b.call();
                }
            }
            this.f73771b = j;
        }
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit) == null) {
            advanceTimeTo(this.f73771b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
        }
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit) == null) {
            a(timeUnit.toNanos(j));
        }
    }

    @Override // h.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (g.a) invokeV.objValue;
    }

    @Override // h.g
    public long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TimeUnit.NANOSECONDS.toMillis(this.f73771b) : invokeV.longValue;
    }

    public void triggerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(this.f73771b);
        }
    }
}
