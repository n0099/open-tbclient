package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.e;
import i.n.j;
import i.o.d.f;
import i.u.b;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THRESHOLD;
    public static final long serialVersionUID = 5995274816189928317L;
    public transient /* synthetic */ FieldHolder $fh;
    public final e<? super R> child;
    public final b childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final j<? extends R> zipFunction;

    /* loaded from: classes2.dex */
    public final class a extends i.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final f f79221e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OperatorZip$Zip f79222f;

        public a(OperatorZip$Zip operatorZip$Zip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorZip$Zip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79222f = operatorZip$Zip;
            this.f79221e = f.a();
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                request(j2);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f79221e.f();
                this.f79222f.tick();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f79222f.child.onError(th);
            }
        }

        @Override // i.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                try {
                    this.f79221e.g(obj);
                } catch (MissingBackpressureException e2) {
                    onError(e2);
                }
                this.f79222f.tick();
            }
        }

        @Override // i.j
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                request(f.f78602g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1733561802, "Lrx/internal/operators/OperatorZip$Zip;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1733561802, "Lrx/internal/operators/OperatorZip$Zip;");
                return;
            }
        }
        THRESHOLD = (int) (f.f78602g * 0.7d);
    }

    public OperatorZip$Zip(i.j<? super R> jVar, j<? extends R> jVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, jVar2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b bVar = new b();
        this.childSubscription = bVar;
        this.child = jVar;
        this.zipFunction = jVar2;
        jVar.add(bVar);
    }

    public void start(d[] dVarArr, AtomicLong atomicLong) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVarArr, atomicLong) == null) {
            Object[] objArr = new Object[dVarArr.length];
            for (int i2 = 0; i2 < dVarArr.length; i2++) {
                a aVar = new a(this);
                objArr[i2] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i3 = 0; i3 < dVarArr.length; i3++) {
                dVarArr[i3].I((a) objArr[i3]);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (objArr = this.subscribers) == null || getAndIncrement() != 0) {
            return;
        }
        int length = objArr.length;
        e<? super R> eVar = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                f fVar = ((a) objArr[i2]).f79221e;
                Object h2 = fVar.h();
                if (h2 == null) {
                    z = false;
                } else if (fVar.d(h2)) {
                    eVar.onCompleted();
                    this.childSubscription.unsubscribe();
                    return;
                } else {
                    objArr2[i2] = fVar.c(h2);
                }
            }
            if (z && atomicLong.get() > 0) {
                try {
                    eVar.onNext((R) this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        f fVar2 = ((a) obj).f79221e;
                        fVar2.i();
                        if (fVar2.d(fVar2.h())) {
                            eVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                    }
                    if (this.emitted > THRESHOLD) {
                        for (Object obj2 : objArr) {
                            ((a) obj2).b(this.emitted);
                        }
                        this.emitted = 0;
                    }
                } catch (Throwable th) {
                    i.m.a.g(th, eVar, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
