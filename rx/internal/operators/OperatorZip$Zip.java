package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a0a;
import com.baidu.tieba.a4a;
import com.baidu.tieba.gz9;
import com.baidu.tieba.hz9;
import com.baidu.tieba.mz9;
import com.baidu.tieba.p1a;
import com.baidu.tieba.sz9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THRESHOLD;
    public static final long serialVersionUID = 5995274816189928317L;
    public transient /* synthetic */ FieldHolder $fh;
    public final hz9<? super R> child;
    public final a4a childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final a0a<? extends R> zipFunction;

    /* loaded from: classes9.dex */
    public final class a extends mz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final p1a e;
        public final /* synthetic */ OperatorZip$Zip f;

        public a(OperatorZip$Zip operatorZip$Zip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorZip$Zip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = operatorZip$Zip;
            this.e = p1a.a();
        }

        @Override // com.baidu.tieba.mz9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(p1a.c);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.f();
                this.f.tick();
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                e(j);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.f.child.onError(th);
            }
        }

        @Override // com.baidu.tieba.hz9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                try {
                    this.e.g(obj);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                this.f.tick();
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
        THRESHOLD = (int) (p1a.c * 0.7d);
    }

    public OperatorZip$Zip(mz9<? super R> mz9Var, a0a<? extends R> a0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mz9Var, a0aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a4a a4aVar = new a4a();
        this.childSubscription = a4aVar;
        this.child = mz9Var;
        this.zipFunction = a0aVar;
        mz9Var.b(a4aVar);
    }

    public void start(gz9[] gz9VarArr, AtomicLong atomicLong) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, gz9VarArr, atomicLong) == null) {
            Object[] objArr = new Object[gz9VarArr.length];
            for (int i = 0; i < gz9VarArr.length; i++) {
                a aVar = new a(this);
                objArr[i] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < gz9VarArr.length; i2++) {
                gz9VarArr[i2].B((a) objArr[i2]);
            }
        }
    }

    /* JADX DEBUG: Type inference failed for r9v4. Raw type applied. Possible types: R, ? super R */
    public void tick() {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (objArr = this.subscribers) != null && getAndIncrement() == 0) {
            int length = objArr.length;
            hz9<? super R> hz9Var = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    p1a p1aVar = ((a) objArr[i]).e;
                    Object h = p1aVar.h();
                    if (h == null) {
                        z = false;
                    } else if (p1aVar.d(h)) {
                        hz9Var.onCompleted();
                        this.childSubscription.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = p1aVar.c(h);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        hz9Var.onNext((R) this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            p1a p1aVar2 = ((a) obj).e;
                            p1aVar2.i();
                            if (p1aVar2.d(p1aVar2.h())) {
                                hz9Var.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > THRESHOLD) {
                            for (Object obj2 : objArr) {
                                ((a) obj2).g(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        sz9.g(th, hz9Var, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }
}
