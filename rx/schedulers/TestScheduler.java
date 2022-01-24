package rx.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
import i.k;
import i.u.e;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class TestScheduler extends g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static long f62615c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<c> a;

    /* renamed from: b  reason: collision with root package name */
    public long f62616b;

    /* loaded from: classes5.dex */
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
                long j2 = cVar.a;
                long j3 = cVar2.a;
                if (j2 == j3) {
                    if (cVar.f62625d < cVar2.f62625d) {
                        return -1;
                    }
                    return cVar.f62625d > cVar2.f62625d ? 1 : 0;
                } else if (j2 < j3) {
                    return -1;
                } else {
                    return j2 > j3 ? 1 : 0;
                }
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class b extends g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final i.u.a f62617e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TestScheduler f62618f;

        /* loaded from: classes5.dex */
        public class a implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f62619e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f62620f;

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
                this.f62620f = bVar;
                this.f62619e = cVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f62620f.f62618f.a.remove(this.f62619e);
                }
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C2324b implements i.n.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f62621e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f62622f;

            public C2324b(b bVar, c cVar) {
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
                this.f62622f = bVar;
                this.f62621e = cVar;
            }

            @Override // i.n.a
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f62622f.f62618f.a.remove(this.f62621e);
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
            this.f62618f = testScheduler;
            this.f62617e = new i.u.a();
        }

        @Override // i.g.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62618f.now() : invokeV.longValue;
        }

        @Override // i.g.a
        public k b(i.n.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                c cVar = new c(this, 0L, aVar);
                this.f62618f.a.add(cVar);
                return e.a(new C2324b(this, cVar));
            }
            return (k) invokeL.objValue;
        }

        @Override // i.g.a
        public k c(i.n.a aVar, long j2, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{aVar, Long.valueOf(j2), timeUnit})) == null) {
                c cVar = new c(this, this.f62618f.f62616b + timeUnit.toNanos(j2), aVar);
                this.f62618f.a.add(cVar);
                return e.a(new a(this, cVar));
            }
            return (k) invokeCommon.objValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62617e.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f62617e.unsubscribe();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;

        /* renamed from: b  reason: collision with root package name */
        public final i.n.a f62623b;

        /* renamed from: c  reason: collision with root package name */
        public final g.a f62624c;

        /* renamed from: d  reason: collision with root package name */
        public final long f62625d;

        public c(g.a aVar, long j2, i.n.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            long j3 = TestScheduler.f62615c;
            TestScheduler.f62615c = 1 + j3;
            this.f62625d = j3;
            this.a = j2;
            this.f62623b = aVar2;
            this.f62624c = aVar;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.a), this.f62623b.toString()) : (String) invokeV.objValue;
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
        this.a = new PriorityQueue(11, new a());
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            while (!this.a.isEmpty()) {
                c peek = this.a.peek();
                long j3 = peek.a;
                if (j3 > j2) {
                    break;
                }
                if (j3 == 0) {
                    j3 = this.f62616b;
                }
                this.f62616b = j3;
                this.a.remove();
                if (!peek.f62624c.isUnsubscribed()) {
                    peek.f62623b.call();
                }
            }
            this.f62616b = j2;
        }
    }

    public void advanceTimeBy(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, timeUnit) == null) {
            advanceTimeTo(this.f62616b + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
        }
    }

    public void advanceTimeTo(long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit) == null) {
            a(timeUnit.toNanos(j2));
        }
    }

    @Override // i.g
    public g.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (g.a) invokeV.objValue;
    }

    @Override // i.g
    public long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TimeUnit.NANOSECONDS.toMillis(this.f62616b) : invokeV.longValue;
    }

    public void triggerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(this.f62616b);
        }
    }
}
