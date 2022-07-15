package rx.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bs9;
import com.repackage.bw9;
import com.repackage.fu9;
import com.repackage.hs9;
import com.repackage.ow9;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes8.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, bs9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -3962399486978279857L;
    public transient /* synthetic */ FieldHolder $fh;
    public final hs9 action;
    public final fu9 cancel;

    /* loaded from: classes8.dex */
    public static final class Remover extends AtomicBoolean implements bs9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 247232374289553518L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ow9 parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, ow9 ow9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledAction, ow9Var};
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
            this.parent = ow9Var;
        }

        @Override // com.repackage.bs9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.bs9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Remover2 extends AtomicBoolean implements bs9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 247232374289553518L;
        public transient /* synthetic */ FieldHolder $fh;
        public final fu9 parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, fu9 fu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scheduledAction, fu9Var};
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
            this.parent = fu9Var;
        }

        @Override // com.repackage.bs9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s.isUnsubscribed() : invokeV.booleanValue;
        }

        @Override // com.repackage.bs9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && compareAndSet(false, true)) {
                this.parent.b(this.s);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class a implements bs9 {
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

        @Override // com.repackage.bs9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.isCancelled() : invokeV.booleanValue;
        }

        @Override // com.repackage.bs9
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

    public ScheduledAction(hs9 hs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hs9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.action = hs9Var;
        this.cancel = new fu9();
    }

    public void add(bs9 bs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bs9Var) == null) {
            this.cancel.a(bs9Var);
        }
    }

    public void addParent(ow9 ow9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ow9Var) == null) {
            this.cancel.a(new Remover(this, ow9Var));
        }
    }

    @Override // com.repackage.bs9
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
            bw9.j(th);
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
        }
    }

    @Override // com.repackage.bs9
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

    public void addParent(fu9 fu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fu9Var) == null) {
            this.cancel.a(new Remover2(this, fu9Var));
        }
    }

    public ScheduledAction(hs9 hs9Var, ow9 ow9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hs9Var, ow9Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.action = hs9Var;
        this.cancel = new fu9(new Remover(this, ow9Var));
    }

    public ScheduledAction(hs9 hs9Var, fu9 fu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hs9Var, fu9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.action = hs9Var;
        this.cancel = new fu9(new Remover2(this, fu9Var));
    }
}
