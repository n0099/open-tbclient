package rx.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev9;
import com.repackage.kz9;
import com.repackage.oz9;
import com.repackage.uu9;
import com.repackage.yu9;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class TestScheduler extends uu9 {
    public static /* synthetic */ Interceptable $ic;
    public static long c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Queue<c> a;
    public long b;

    /* loaded from: classes8.dex */
    public static final class a implements Comparator<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                long j = cVar.a;
                long j2 = cVar2.a;
                if (j == j2) {
                    if (cVar.d < cVar2.d) {
                        return -1;
                    }
                    return cVar.d > cVar2.d ? 1 : 0;
                } else if (j < j2) {
                    return -1;
                } else {
                    return j > j2 ? 1 : 0;
                }
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class b extends uu9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final kz9 a;
        public final /* synthetic */ TestScheduler b;

        /* loaded from: classes8.dex */
        public class a implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;
            public final /* synthetic */ b b;

            public a(b bVar, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = cVar;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.a.remove(this.a);
                }
            }
        }

        /* renamed from: rx.schedulers.TestScheduler$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0716b implements ev9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;
            public final /* synthetic */ b b;

            public C0716b(b bVar, c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = cVar;
            }

            @Override // com.repackage.ev9
            public void call() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.b.a.remove(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = testScheduler;
            this.a = new kz9();
        }

        @Override // com.repackage.uu9.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b.now() : invokeV.longValue;
        }

        @Override // com.repackage.uu9.a
        public yu9 b(ev9 ev9Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ev9Var)) == null) {
                c cVar = new c(this, 0L, ev9Var);
                this.b.a.add(cVar);
                return oz9.a(new C0716b(this, cVar));
            }
            return (yu9) invokeL.objValue;
        }

        @Override // com.repackage.uu9.a
        public yu9 c(ev9 ev9Var, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ev9Var, Long.valueOf(j), timeUnit})) == null) {
                c cVar = new c(this, this.b.b + timeUnit.toNanos(j), ev9Var);
                this.b.a.add(cVar);
                return oz9.a(new a(this, cVar));
            }
            return (yu9) invokeCommon.objValue;
        }

        @Override // com.repackage.yu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.yu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final ev9 b;
        public final uu9.a c;
        public final long d;

        public c(uu9.a aVar, long j, ev9 ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), ev9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            long j2 = TestScheduler.c;
            TestScheduler.c = 1 + j2;
            this.d = j2;
            this.a = j;
            this.b = ev9Var;
            this.c = aVar;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.a), this.b.toString()) : (String) invokeV.objValue;
        }
    }

    public TestScheduler() {
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
        this.a = new PriorityQueue(11, new a());
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            while (!this.a.isEmpty()) {
                c peek = this.a.peek();
                long j2 = peek.a;
                if (j2 > j) {
                    break;
                }
                if (j2 == 0) {
                    j2 = this.b;
                }
                this.b = j2;
                this.a.remove();
                if (!peek.c.isUnsubscribed()) {
                    peek.b.call();
                }
            }
            this.b = j;
        }
    }

    public void advanceTimeBy(long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, timeUnit) == null) {
            advanceTimeTo(this.b + timeUnit.toNanos(j), TimeUnit.NANOSECONDS);
        }
    }

    public void advanceTimeTo(long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, timeUnit) == null) {
            a(timeUnit.toNanos(j));
        }
    }

    @Override // com.repackage.uu9
    public uu9.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new b(this) : (uu9.a) invokeV.objValue;
    }

    @Override // com.repackage.uu9
    public long now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TimeUnit.NANOSECONDS.toMillis(this.b) : invokeV.longValue;
    }

    public void triggerActions() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a(this.b);
        }
    }
}
