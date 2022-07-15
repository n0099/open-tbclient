package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as9;
import com.repackage.du9;
import com.repackage.gs9;
import com.repackage.os9;
import com.repackage.ow9;
import com.repackage.ur9;
import com.repackage.vr9;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
public final class OperatorZip$Zip<R> extends AtomicLong {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int THRESHOLD;
    public static final long serialVersionUID = 5995274816189928317L;
    public transient /* synthetic */ FieldHolder $fh;
    public final vr9<? super R> child;
    public final ow9 childSubscription;
    public int emitted;
    public AtomicLong requested;
    public volatile Object[] subscribers;
    public final os9<? extends R> zipFunction;

    /* loaded from: classes8.dex */
    public final class a extends as9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final du9 e;
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
            this.e = du9.a();
        }

        @Override // com.repackage.as9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e(du9.c);
            }
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                e(j);
            }
        }

        @Override // com.repackage.vr9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.f();
                this.f.tick();
            }
        }

        @Override // com.repackage.vr9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.f.child.onError(th);
            }
        }

        @Override // com.repackage.vr9
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
        THRESHOLD = (int) (du9.c * 0.7d);
    }

    public OperatorZip$Zip(as9<? super R> as9Var, os9<? extends R> os9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {as9Var, os9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ow9 ow9Var = new ow9();
        this.childSubscription = ow9Var;
        this.child = as9Var;
        this.zipFunction = os9Var;
        as9Var.b(ow9Var);
    }

    public void start(ur9[] ur9VarArr, AtomicLong atomicLong) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, ur9VarArr, atomicLong) == null) {
            Object[] objArr = new Object[ur9VarArr.length];
            for (int i = 0; i < ur9VarArr.length; i++) {
                a aVar = new a(this);
                objArr[i] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < ur9VarArr.length; i2++) {
                ur9VarArr[i2].B((a) objArr[i2]);
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
        vr9<? super R> vr9Var = this.child;
        AtomicLong atomicLong = this.requested;
        while (true) {
            Object[] objArr2 = new Object[length];
            boolean z = true;
            for (int i = 0; i < length; i++) {
                du9 du9Var = ((a) objArr[i]).e;
                Object h = du9Var.h();
                if (h == null) {
                    z = false;
                } else if (du9Var.d(h)) {
                    vr9Var.onCompleted();
                    this.childSubscription.unsubscribe();
                    return;
                } else {
                    objArr2[i] = du9Var.c(h);
                }
            }
            if (z && atomicLong.get() > 0) {
                try {
                    vr9Var.onNext((R) this.zipFunction.call(objArr2));
                    atomicLong.decrementAndGet();
                    this.emitted++;
                    for (Object obj : objArr) {
                        du9 du9Var2 = ((a) obj).e;
                        du9Var2.i();
                        if (du9Var2.d(du9Var2.h())) {
                            vr9Var.onCompleted();
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
                    gs9.g(th, vr9Var, objArr2);
                    return;
                }
            } else if (decrementAndGet() <= 0) {
                return;
            }
        }
    }
}
