package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.e;
import h.j;
import h.k;
import h.n.f;
import h.n.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<T1> f73642e;

    /* renamed from: f  reason: collision with root package name */
    public final d<T2> f73643f;

    /* renamed from: g  reason: collision with root package name */
    public final f<? super T1, ? extends d<D1>> f73644g;

    /* renamed from: h  reason: collision with root package name */
    public final f<? super T2, ? extends d<D2>> f73645h;

    /* renamed from: i  reason: collision with root package name */
    public final g<? super T1, ? super d<T2>, ? extends R> f73646i;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, e<T2>> implements k {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3035156013812425335L;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription cancel;
        public final h.u.b group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeGroupJoin this$0;

        /* loaded from: classes9.dex */
        public final class a extends j<D1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final int f73647e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f73648f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ResultManager f73649g;

            public a(ResultManager resultManager, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73649g = resultManager;
                this.f73648f = true;
                this.f73647e = i2;
            }

            @Override // h.e
            public void onCompleted() {
                e<T2> remove;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73648f) {
                    this.f73648f = false;
                    synchronized (this.f73649g) {
                        remove = this.f73649g.leftMap().remove(Integer.valueOf(this.f73647e));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    this.f73649g.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f73649g.errorMain(th);
                }
            }

            @Override // h.e
            public void onNext(D1 d1) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d1) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends j<T1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultManager f73650e;

            public b(ResultManager resultManager) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73650e = resultManager;
            }

            @Override // h.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f73650e) {
                        this.f73650e.leftDone = true;
                        if (this.f73650e.rightDone) {
                            arrayList = new ArrayList(this.f73650e.leftMap().values());
                            this.f73650e.leftMap().clear();
                            this.f73650e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f73650e.complete(arrayList);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f73650e.errorAll(th);
                }
            }

            @Override // h.e
            public void onNext(T1 t1) {
                int i2;
                ArrayList<Object> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1) == null) {
                    try {
                        PublishSubject K = PublishSubject.K();
                        h.q.d dVar = new h.q.d(K);
                        synchronized (this.f73650e) {
                            ResultManager resultManager = this.f73650e;
                            i2 = resultManager.leftIds;
                            resultManager.leftIds = i2 + 1;
                            this.f73650e.leftMap().put(Integer.valueOf(i2), dVar);
                        }
                        h.d b2 = h.d.b(new a(K, this.f73650e.cancel));
                        a aVar = new a(this.f73650e, i2);
                        this.f73650e.group.a(aVar);
                        this.f73650e.this$0.f73644g.call(t1).I(aVar);
                        R a2 = this.f73650e.this$0.f73646i.a(t1, b2);
                        synchronized (this.f73650e) {
                            arrayList = new ArrayList(this.f73650e.rightMap.values());
                        }
                        this.f73650e.subscriber.onNext(a2);
                        for (Object obj : arrayList) {
                            dVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends j<D2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final int f73651e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f73652f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ ResultManager f73653g;

            public c(ResultManager resultManager, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73653g = resultManager;
                this.f73652f = true;
                this.f73651e = i2;
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73652f) {
                    this.f73652f = false;
                    synchronized (this.f73653g) {
                        this.f73653g.rightMap.remove(Integer.valueOf(this.f73651e));
                    }
                    this.f73653g.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f73653g.errorMain(th);
                }
            }

            @Override // h.e
            public void onNext(D2 d2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends j<T2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultManager f73654e;

            public d(ResultManager resultManager) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultManager};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73654e = resultManager;
            }

            @Override // h.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f73654e) {
                        this.f73654e.rightDone = true;
                        if (this.f73654e.leftDone) {
                            arrayList = new ArrayList(this.f73654e.leftMap().values());
                            this.f73654e.leftMap().clear();
                            this.f73654e.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f73654e.complete(arrayList);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f73654e.errorAll(th);
                }
            }

            @Override // h.e
            public void onNext(T2 t2) {
                int i2;
                ArrayList<e> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t2) == null) {
                    try {
                        synchronized (this.f73654e) {
                            ResultManager resultManager = this.f73654e;
                            i2 = resultManager.rightIds;
                            resultManager.rightIds = i2 + 1;
                            this.f73654e.rightMap.put(Integer.valueOf(i2), t2);
                        }
                        c cVar = new c(this.f73654e, i2);
                        this.f73654e.group.a(cVar);
                        this.f73654e.this$0.f73645h.call(t2).I(cVar);
                        synchronized (this.f73654e) {
                            arrayList = new ArrayList(this.f73654e.leftMap().values());
                        }
                        for (e eVar : arrayList) {
                            eVar.onNext(t2);
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = onSubscribeGroupJoin;
            this.rightMap = new HashMap();
            this.subscriber = jVar;
            this.group = new h.u.b();
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
                this.this$0.f73642e.I(bVar);
                this.this$0.f73643f.I(dVar);
            }
        }

        @Override // h.k
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

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.cancel.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final RefCountSubscription f73655e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T> f73656f;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C2095a extends j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final j<? super T> f73657e;

            /* renamed from: f  reason: collision with root package name */
            public final k f73658f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2095a(a aVar, j<? super T> jVar, k kVar) {
                super(jVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jVar, kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((j) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73657e = jVar;
                this.f73658f = kVar;
            }

            @Override // h.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f73657e.onCompleted();
                    this.f73658f.unsubscribe();
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f73657e.onError(th);
                    this.f73658f.unsubscribe();
                }
            }

            @Override // h.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f73657e.onNext(t);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73655e = refCountSubscription;
            this.f73656f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                k a2 = this.f73655e.a();
                C2095a c2095a = new C2095a(this, jVar, a2);
                c2095a.add(a2);
                this.f73656f.I(c2095a);
            }
        }
    }
}
