package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.e;
import g.j;
import g.k;
import g.n.f;
import g.n.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes8.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d<T1> a;

    /* renamed from: b  reason: collision with root package name */
    public final d<T2> f45380b;

    /* renamed from: c  reason: collision with root package name */
    public final f<? super T1, ? extends d<D1>> f45381c;

    /* renamed from: d  reason: collision with root package name */
    public final f<? super T2, ? extends d<D2>> f45382d;

    /* renamed from: e  reason: collision with root package name */
    public final g<? super T1, ? super d<T2>, ? extends R> f45383e;

    /* loaded from: classes8.dex */
    public final class ResultManager extends HashMap<Integer, e<T2>> implements k {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3035156013812425335L;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription cancel;
        public final g.u.b group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeGroupJoin this$0;

        /* loaded from: classes8.dex */
        public final class a extends j<D1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final int f45384e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f45385f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ResultManager f45386g;

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
                this.f45386g = resultManager;
                this.f45385f = true;
                this.f45384e = i;
            }

            @Override // g.e
            public void onCompleted() {
                e<T2> remove;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45385f) {
                    this.f45385f = false;
                    synchronized (this.f45386g) {
                        remove = this.f45386g.leftMap().remove(Integer.valueOf(this.f45384e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    this.f45386g.group.b(this);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f45386g.errorMain(th);
                }
            }

            @Override // g.e
            public void onNext(D1 d1) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d1) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class b extends j<T1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultManager f45387e;

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
                this.f45387e = resultManager;
            }

            @Override // g.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f45387e) {
                        this.f45387e.leftDone = true;
                        if (this.f45387e.rightDone) {
                            arrayList = new ArrayList(this.f45387e.leftMap().values());
                            this.f45387e.leftMap().clear();
                            this.f45387e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f45387e.complete(arrayList);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f45387e.errorAll(th);
                }
            }

            @Override // g.e
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1) == null) {
                    try {
                        PublishSubject F = PublishSubject.F();
                        g.q.d dVar = new g.q.d(F);
                        synchronized (this.f45387e) {
                            ResultManager resultManager = this.f45387e;
                            i = resultManager.leftIds;
                            resultManager.leftIds = i + 1;
                            this.f45387e.leftMap().put(Integer.valueOf(i), dVar);
                        }
                        g.d a = g.d.a(new a(F, this.f45387e.cancel));
                        a aVar = new a(this.f45387e, i);
                        this.f45387e.group.a(aVar);
                        this.f45387e.this$0.f45381c.call(t1).D(aVar);
                        R call = this.f45387e.this$0.f45383e.call(t1, a);
                        synchronized (this.f45387e) {
                            arrayList = new ArrayList(this.f45387e.rightMap.values());
                        }
                        this.f45387e.subscriber.onNext(call);
                        for (Object obj : arrayList) {
                            dVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        g.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class c extends j<D2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final int f45388e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f45389f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ResultManager f45390g;

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
                this.f45390g = resultManager;
                this.f45389f = true;
                this.f45388e = i;
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45389f) {
                    this.f45389f = false;
                    synchronized (this.f45390g) {
                        this.f45390g.rightMap.remove(Integer.valueOf(this.f45388e));
                    }
                    this.f45390g.group.b(this);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f45390g.errorMain(th);
                }
            }

            @Override // g.e
            public void onNext(D2 d2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class d extends j<T2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultManager f45391e;

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
                this.f45391e = resultManager;
            }

            @Override // g.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f45391e) {
                        this.f45391e.rightDone = true;
                        if (this.f45391e.leftDone) {
                            arrayList = new ArrayList(this.f45391e.leftMap().values());
                            this.f45391e.leftMap().clear();
                            this.f45391e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f45391e.complete(arrayList);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f45391e.errorAll(th);
                }
            }

            @Override // g.e
            public void onNext(T2 t2) {
                int i;
                ArrayList<e> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t2) == null) {
                    try {
                        synchronized (this.f45391e) {
                            ResultManager resultManager = this.f45391e;
                            i = resultManager.rightIds;
                            resultManager.rightIds = i + 1;
                            this.f45391e.rightMap.put(Integer.valueOf(i), t2);
                        }
                        c cVar = new c(this.f45391e, i);
                        this.f45391e.group.a(cVar);
                        this.f45391e.this$0.f45382d.call(t2).D(cVar);
                        synchronized (this.f45391e) {
                            arrayList = new ArrayList(this.f45391e.leftMap().values());
                        }
                        for (e eVar : arrayList) {
                            eVar.onNext(t2);
                        }
                    } catch (Throwable th) {
                        g.m.a.f(th, this);
                    }
                }
            }
        }

        public ResultManager(OnSubscribeGroupJoin onSubscribeGroupJoin, j<? super R> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeGroupJoin, jVar};
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
            this.subscriber = jVar;
            this.group = new g.u.b();
            this.cancel = new RefCountSubscription(this.group);
        }

        public void complete(List<e<T2>> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
                return;
            }
            for (e<T2> eVar : list) {
                eVar.onCompleted();
            }
            this.subscriber.onCompleted();
            this.cancel.unsubscribe();
        }

        public void errorAll(Throwable th) {
            ArrayList<e> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                synchronized (this) {
                    arrayList = new ArrayList(leftMap().values());
                    leftMap().clear();
                    this.rightMap.clear();
                }
                for (e eVar : arrayList) {
                    eVar.onError(th);
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
                this.this$0.f45380b.D(dVar);
            }
        }

        @Override // g.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancel.isUnsubscribed() : invokeV.booleanValue;
        }

        public Map<Integer, e<T2>> leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (Map) invokeV.objValue;
        }

        @Override // g.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.cancel.unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription a;

        /* renamed from: b  reason: collision with root package name */
        public final d<T> f45392b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public final class C2159a extends j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final j<? super T> f45393e;

            /* renamed from: f  reason: collision with root package name */
            public final k f45394f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2159a(a aVar, j<? super T> jVar, k kVar) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jVar, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45393e = jVar;
                this.f45394f = kVar;
            }

            @Override // g.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f45393e.onCompleted();
                    this.f45394f.unsubscribe();
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f45393e.onError(th);
                    this.f45394f.unsubscribe();
                }
            }

            @Override // g.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f45393e.onNext(t);
                }
            }
        }

        public a(d<T> dVar, RefCountSubscription refCountSubscription) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, refCountSubscription};
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
            this.f45392b = dVar;
        }

        @Override // g.d.a, g.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                k a = this.a.a();
                C2159a c2159a = new C2159a(this, jVar, a);
                c2159a.b(a);
                this.f45392b.D(c2159a);
            }
        }
    }

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            ResultManager resultManager = new ResultManager(this, new g.q.e(jVar));
            jVar.b(resultManager);
            resultManager.init();
        }
    }
}
