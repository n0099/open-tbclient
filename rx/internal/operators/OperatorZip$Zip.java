package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ax9;
import com.repackage.dv9;
import com.repackage.lv9;
import com.repackage.lz9;
import com.repackage.ru9;
import com.repackage.su9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THRESHOLD;
    public static final long serialVersionUID = 5995274816189928317L;
    public transient /* synthetic */ FieldHolder $fh;
    public final su9<? super R> child;
    public final lz9 childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final lv9<? extends R> zipFunction;

    /* loaded from: classes8.dex */
    public final class a extends xu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ax9 e;
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
            this.e = ax9.a();
        }

        @Override // com.repackage.xu9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(ax9.c);
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                e(j);
            }
        }

        @Override // com.repackage.su9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.f();
                this.f.tick();
            }
        }

        @Override // com.repackage.su9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.f.child.onError(th);
            }
        }

        @Override // com.repackage.su9
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
        THRESHOLD = (int) (ax9.c * 0.7d);
    }

    public OperatorZip$Zip(xu9<? super R> xu9Var, lv9<? extends R> lv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xu9Var, lv9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        lz9 lz9Var = new lz9();
        this.childSubscription = lz9Var;
        this.child = xu9Var;
        this.zipFunction = lv9Var;
        xu9Var.b(lz9Var);
    }

    public void start(ru9[] ru9VarArr, AtomicLong atomicLong) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ru9VarArr, atomicLong) == null) {
            Object[] objArr = new Object[ru9VarArr.length];
            for (int i = 0; i < ru9VarArr.length; i++) {
                a aVar = new a(this);
                objArr[i] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < ru9VarArr.length; i2++) {
                ru9VarArr[i2].B((a) objArr[i2]);
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
        su9<? super R> su9Var = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z = true;
            for (int i = 0; i < length; i++) {
                ax9 ax9Var = ((a) objArr[i]).e;
                Object h = ax9Var.h();
                if (h == null) {
                    z = false;
                } else if (ax9Var.d(h)) {
                    su9Var.onCompleted();
                    this.childSubscription.unsubscribe();
                    return;
                } else {
                    objArr2[i] = ax9Var.c(h);
                }
            }
            if (z && atomicLong.get() > 0) {
                try {
                    su9Var.onNext((R) this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        ax9 ax9Var2 = ((a) obj).e;
                        ax9Var2.i();
                        if (ax9Var2.d(ax9Var2.h())) {
                            su9Var.onCompleted();
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
                    dv9.g(th, su9Var, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
