package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cv9;
import com.repackage.kv9;
import com.repackage.kz9;
import com.repackage.qu9;
import com.repackage.ru9;
import com.repackage.wu9;
import com.repackage.zw9;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THRESHOLD;
    public static final long serialVersionUID = 5995274816189928317L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ru9<? super R> child;
    public final kz9 childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final kv9<? extends R> zipFunction;

    /* loaded from: classes8.dex */
    public final class a extends wu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zw9 e;
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
            this.e = zw9.a();
        }

        @Override // com.repackage.wu9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(zw9.c);
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                e(j);
            }
        }

        @Override // com.repackage.ru9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.f();
                this.f.tick();
            }
        }

        @Override // com.repackage.ru9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.f.child.onError(th);
            }
        }

        @Override // com.repackage.ru9
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
        THRESHOLD = (int) (zw9.c * 0.7d);
    }

    public OperatorZip$Zip(wu9<? super R> wu9Var, kv9<? extends R> kv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wu9Var, kv9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        kz9 kz9Var = new kz9();
        this.childSubscription = kz9Var;
        this.child = wu9Var;
        this.zipFunction = kv9Var;
        wu9Var.b(kz9Var);
    }

    public void start(qu9[] qu9VarArr, AtomicLong atomicLong) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, qu9VarArr, atomicLong) == null) {
            Object[] objArr = new Object[qu9VarArr.length];
            for (int i = 0; i < qu9VarArr.length; i++) {
                a aVar = new a(this);
                objArr[i] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < qu9VarArr.length; i2++) {
                qu9VarArr[i2].B((a) objArr[i2]);
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
        ru9<? super R> ru9Var = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z = true;
            for (int i = 0; i < length; i++) {
                zw9 zw9Var = ((a) objArr[i]).e;
                Object h = zw9Var.h();
                if (h == null) {
                    z = false;
                } else if (zw9Var.d(h)) {
                    ru9Var.onCompleted();
                    this.childSubscription.unsubscribe();
                    return;
                } else {
                    objArr2[i] = zw9Var.c(h);
                }
            }
            if (z && atomicLong.get() > 0) {
                try {
                    ru9Var.onNext((R) this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        zw9 zw9Var2 = ((a) obj).e;
                        zw9Var2.i();
                        if (zw9Var2.d(zw9Var2.h())) {
                            ru9Var.onCompleted();
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
                    cv9.g(th, ru9Var, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
