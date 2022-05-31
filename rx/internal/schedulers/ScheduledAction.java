package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bx9;
import com.repackage.dv9;
import com.repackage.kz9;
import com.repackage.xu9;
import com.repackage.xy9;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes8.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, xu9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3962399486978279857L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9 action;
    public final bx9 cancel;

    /* loaded from: classes8.dex */
    public static final class Remover extends AtomicBoolean implements xu9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 247232374289553518L;
        public transient /* synthetic */ FieldHolder $fh;
        public final kz9 parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, kz9 kz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledAction, kz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = scheduledAction;
            this.parent = kz9Var;
        }

        @Override // com.repackage.xu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.xu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Remover2 extends AtomicBoolean implements xu9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 247232374289553518L;
        public transient /* synthetic */ FieldHolder $fh;
        public final bx9 parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, bx9 bx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledAction, bx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = scheduledAction;
            this.parent = bx9Var;
        }

        @Override // com.repackage.xu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.xu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class a implements xu9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Future<?> a;
        public final /* synthetic */ ScheduledAction b;

        public a(ScheduledAction scheduledAction, Future<?> future) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledAction, future};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = scheduledAction;
            this.a = future;
        }

        @Override // com.repackage.xu9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.isCancelled() : invokeV.booleanValue;
        }

        @Override // com.repackage.xu9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b.get() != Thread.currentThread()) {
                    this.a.cancel(true);
                } else {
                    this.a.cancel(false);
                }
            }
        }
    }

    public ScheduledAction(dv9 dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.action = dv9Var;
        this.cancel = new bx9();
    }

    public void add(xu9 xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            this.cancel.a(xu9Var);
        }
    }

    public void addParent(kz9 kz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, kz9Var) == null) {
            this.cancel.a(new Remover(this, kz9Var));
        }
    }

    @Override // com.repackage.xu9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancel.isUnsubscribed() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 0, expect 1 */
    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                try {
                    lazySet(Thread.currentThread());
                    this.action.call();
                } finally {
                    unsubscribe();
                }
            } catch (OnErrorNotImplementedException e) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
            } catch (Throwable th) {
                signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
            }
        }
    }

    public void signalError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, th) == null) {
            xy9.j(th);
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    @Override // com.repackage.xu9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, future) == null) {
            this.cancel.a(new a(this, future));
        }
    }

    public void addParent(bx9 bx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bx9Var) == null) {
            this.cancel.a(new Remover2(this, bx9Var));
        }
    }

    public ScheduledAction(dv9 dv9Var, kz9 kz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var, kz9Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.action = dv9Var;
        this.cancel = new bx9(new Remover(this, kz9Var));
    }

    public ScheduledAction(dv9 dv9Var, bx9 bx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var, bx9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.action = dv9Var;
        this.cancel = new bx9(new Remover2(this, bx9Var));
    }
}
