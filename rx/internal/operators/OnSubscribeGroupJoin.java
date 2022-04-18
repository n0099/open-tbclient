package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.cz9;
import com.repackage.e3a;
import com.repackage.f3a;
import com.repackage.hz9;
import com.repackage.iz9;
import com.repackage.nz9;
import com.repackage.tz9;
import com.repackage.uz9;
import com.repackage.w3a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes8.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements bz9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bz9<T1> a;
    public final bz9<T2> b;
    public final tz9<? super T1, ? extends bz9<D1>> c;
    public final tz9<? super T2, ? extends bz9<D2>> d;
    public final uz9<? super T1, ? super bz9<T2>, ? extends R> e;

    /* loaded from: classes8.dex */
    public final class ResultManager extends HashMap<Integer, cz9<T2>> implements iz9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3035156013812425335L;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription cancel;
        public final w3a group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap;
        public final hz9<? super R> subscriber;
        public final /* synthetic */ OnSubscribeGroupJoin this$0;

        /* loaded from: classes8.dex */
        public final class a extends hz9<D1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int e;
            public boolean f;
            public final /* synthetic */ ResultManager g;

            public a(ResultManager resultManager, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.g = resultManager;
                this.f = true;
                this.e = i;
            }

            @Override // com.repackage.cz9
            public void onCompleted() {
                cz9<T2> remove;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                    this.f = false;
                    synchronized (this.g) {
                        remove = this.g.leftMap().remove(Integer.valueOf(this.e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    this.g.group.b(this);
                }
            }

            @Override // com.repackage.cz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.g.errorMain(th);
                }
            }

            @Override // com.repackage.cz9
            public void onNext(D1 d1) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d1) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class b extends hz9<T1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultManager e;

            public b(ResultManager resultManager) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = resultManager;
            }

            @Override // com.repackage.cz9
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.e) {
                        this.e.leftDone = true;
                        if (this.e.rightDone) {
                            arrayList = new ArrayList(this.e.leftMap().values());
                            this.e.leftMap().clear();
                            this.e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.e.complete(arrayList);
                }
            }

            @Override // com.repackage.cz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.errorAll(th);
                }
            }

            @Override // com.repackage.cz9
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1) == null) {
                    try {
                        PublishSubject F = PublishSubject.F();
                        e3a e3aVar = new e3a(F);
                        synchronized (this.e) {
                            ResultManager resultManager = this.e;
                            i = resultManager.leftIds;
                            resultManager.leftIds = i + 1;
                            this.e.leftMap().put(Integer.valueOf(i), e3aVar);
                        }
                        bz9 a = bz9.a(new a(F, this.e.cancel));
                        a aVar = new a(this.e, i);
                        this.e.group.a(aVar);
                        this.e.this$0.c.call(t1).D(aVar);
                        R call = this.e.this$0.e.call(t1, a);
                        synchronized (this.e) {
                            arrayList = new ArrayList(this.e.rightMap.values());
                        }
                        this.e.subscriber.onNext(call);
                        for (Object obj : arrayList) {
                            e3aVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        nz9.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class c extends hz9<D2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final int e;
            public boolean f;
            public final /* synthetic */ ResultManager g;

            public c(ResultManager resultManager, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.g = resultManager;
                this.f = true;
                this.e = i;
            }

            @Override // com.repackage.cz9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                    this.f = false;
                    synchronized (this.g) {
                        this.g.rightMap.remove(Integer.valueOf(this.e));
                    }
                    this.g.group.b(this);
                }
            }

            @Override // com.repackage.cz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.g.errorMain(th);
                }
            }

            @Override // com.repackage.cz9
            public void onNext(D2 d2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class d extends hz9<T2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultManager e;

            public d(ResultManager resultManager) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = resultManager;
            }

            @Override // com.repackage.cz9
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.e) {
                        this.e.rightDone = true;
                        if (this.e.leftDone) {
                            arrayList = new ArrayList(this.e.leftMap().values());
                            this.e.leftMap().clear();
                            this.e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.e.complete(arrayList);
                }
            }

            @Override // com.repackage.cz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.errorAll(th);
                }
            }

            @Override // com.repackage.cz9
            public void onNext(T2 t2) {
                int i;
                ArrayList<cz9> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t2) == null) {
                    try {
                        synchronized (this.e) {
                            ResultManager resultManager = this.e;
                            i = resultManager.rightIds;
                            resultManager.rightIds = i + 1;
                            this.e.rightMap.put(Integer.valueOf(i), t2);
                        }
                        c cVar = new c(this.e, i);
                        this.e.group.a(cVar);
                        this.e.this$0.d.call(t2).D(cVar);
                        synchronized (this.e) {
                            arrayList = new ArrayList(this.e.leftMap().values());
                        }
                        for (cz9 cz9Var : arrayList) {
                            cz9Var.onNext(t2);
                        }
                    } catch (Throwable th) {
                        nz9.f(th, this);
                    }
                }
            }
        }

        public ResultManager(OnSubscribeGroupJoin onSubscribeGroupJoin, hz9<? super R> hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeGroupJoin, hz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = onSubscribeGroupJoin;
            this.rightMap = new HashMap();
            this.subscriber = hz9Var;
            this.group = new w3a();
            this.cancel = new RefCountSubscription(this.group);
        }

        public void complete(List<cz9<T2>> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            for (cz9<T2> cz9Var : list) {
                cz9Var.onCompleted();
            }
            this.subscriber.onCompleted();
            this.cancel.unsubscribe();
        }

        public void errorAll(Throwable th) {
            ArrayList<cz9> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                synchronized (this) {
                    arrayList = new ArrayList(leftMap().values());
                    leftMap().clear();
                    this.rightMap.clear();
                }
                for (cz9 cz9Var : arrayList) {
                    cz9Var.onError(th);
                }
                this.subscriber.onError(th);
                this.cancel.unsubscribe();
            }
        }

        public void errorMain(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                synchronized (this) {
                    leftMap().clear();
                    this.rightMap.clear();
                }
                this.subscriber.onError(th);
                this.cancel.unsubscribe();
            }
        }

        public void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                b bVar = new b(this);
                d dVar = new d(this);
                this.group.a(bVar);
                this.group.a(dVar);
                this.this$0.a.D(bVar);
                this.this$0.b.D(dVar);
            }
        }

        @Override // com.repackage.iz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancel.isUnsubscribed() : invokeV.booleanValue;
        }

        public Map<Integer, cz9<T2>> leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (Map) invokeV.objValue;
        }

        @Override // com.repackage.iz9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.cancel.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a<T> implements bz9.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription a;
        public final bz9<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public final class C0664a extends hz9<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final hz9<? super T> e;
            public final iz9 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0664a(a aVar, hz9<? super T> hz9Var, iz9 iz9Var) {
                super(hz9Var);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hz9Var, iz9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((hz9) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = hz9Var;
                this.f = iz9Var;
            }

            @Override // com.repackage.cz9
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.e.onCompleted();
                    this.f.unsubscribe();
                }
            }

            @Override // com.repackage.cz9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.onError(th);
                    this.f.unsubscribe();
                }
            }

            @Override // com.repackage.cz9
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.e.onNext(t);
                }
            }
        }

        public a(bz9<T> bz9Var, RefCountSubscription refCountSubscription) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bz9Var, refCountSubscription};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = refCountSubscription;
            this.b = bz9Var;
        }

        @Override // com.repackage.bz9.a, com.repackage.pz9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((hz9) ((hz9) obj));
        }

        public void call(hz9<? super T> hz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hz9Var) == null) {
                iz9 a = this.a.a();
                C0664a c0664a = new C0664a(this, hz9Var, a);
                c0664a.b(a);
                this.b.D(c0664a);
            }
        }
    }

    @Override // com.repackage.bz9.a, com.repackage.pz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((hz9) ((hz9) obj));
    }

    public void call(hz9<? super R> hz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hz9Var) == null) {
            ResultManager resultManager = new ResultManager(this, new f3a(hz9Var));
            hz9Var.b(resultManager);
            resultManager.init();
        }
    }
}
