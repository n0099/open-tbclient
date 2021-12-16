package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.e;
import i.j;
import i.k;
import i.n.f;
import i.n.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes4.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<T1> f64899e;

    /* renamed from: f  reason: collision with root package name */
    public final d<T2> f64900f;

    /* renamed from: g  reason: collision with root package name */
    public final f<? super T1, ? extends d<D1>> f64901g;

    /* renamed from: h  reason: collision with root package name */
    public final f<? super T2, ? extends d<D2>> f64902h;

    /* renamed from: i  reason: collision with root package name */
    public final g<? super T1, ? super d<T2>, ? extends R> f64903i;

    /* loaded from: classes4.dex */
    public final class ResultManager extends HashMap<Integer, e<T2>> implements k {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3035156013812425335L;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription cancel;
        public final i.u.b group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeGroupJoin this$0;

        /* loaded from: classes4.dex */
        public final class a extends j<D1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final int f64904i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f64905j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ ResultManager f64906k;

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
                this.f64906k = resultManager;
                this.f64905j = true;
                this.f64904i = i2;
            }

            @Override // i.e
            public void onCompleted() {
                e<T2> remove;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64905j) {
                    this.f64905j = false;
                    synchronized (this.f64906k) {
                        remove = this.f64906k.leftMap().remove(Integer.valueOf(this.f64904i));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    this.f64906k.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f64906k.errorMain(th);
                }
            }

            @Override // i.e
            public void onNext(D1 d1) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d1) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class b extends j<T1> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultManager f64907i;

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
                this.f64907i = resultManager;
            }

            @Override // i.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f64907i) {
                        this.f64907i.leftDone = true;
                        if (this.f64907i.rightDone) {
                            arrayList = new ArrayList(this.f64907i.leftMap().values());
                            this.f64907i.leftMap().clear();
                            this.f64907i.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f64907i.complete(arrayList);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f64907i.errorAll(th);
                }
            }

            @Override // i.e
            public void onNext(T1 t1) {
                int i2;
                ArrayList<Object> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1) == null) {
                    try {
                        PublishSubject F = PublishSubject.F();
                        i.q.d dVar = new i.q.d(F);
                        synchronized (this.f64907i) {
                            ResultManager resultManager = this.f64907i;
                            i2 = resultManager.leftIds;
                            resultManager.leftIds = i2 + 1;
                            this.f64907i.leftMap().put(Integer.valueOf(i2), dVar);
                        }
                        i.d a = i.d.a(new a(F, this.f64907i.cancel));
                        a aVar = new a(this.f64907i, i2);
                        this.f64907i.group.a(aVar);
                        this.f64907i.this$0.f64901g.call(t1).D(aVar);
                        R call = this.f64907i.this$0.f64903i.call(t1, a);
                        synchronized (this.f64907i) {
                            arrayList = new ArrayList(this.f64907i.rightMap.values());
                        }
                        this.f64907i.subscriber.onNext(call);
                        for (Object obj : arrayList) {
                            dVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        i.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class c extends j<D2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final int f64908i;

            /* renamed from: j  reason: collision with root package name */
            public boolean f64909j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ ResultManager f64910k;

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
                this.f64910k = resultManager;
                this.f64909j = true;
                this.f64908i = i2;
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f64909j) {
                    this.f64909j = false;
                    synchronized (this.f64910k) {
                        this.f64910k.rightMap.remove(Integer.valueOf(this.f64908i));
                    }
                    this.f64910k.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f64910k.errorMain(th);
                }
            }

            @Override // i.e
            public void onNext(D2 d2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes4.dex */
        public final class d extends j<T2> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultManager f64911i;

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
                this.f64911i = resultManager;
            }

            @Override // i.e
            public void onCompleted() {
                ArrayList arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    synchronized (this.f64911i) {
                        this.f64911i.rightDone = true;
                        if (this.f64911i.leftDone) {
                            arrayList = new ArrayList(this.f64911i.leftMap().values());
                            this.f64911i.leftMap().clear();
                            this.f64911i.rightMap.clear();
                        } else {
                            arrayList = null;
                        }
                    }
                    this.f64911i.complete(arrayList);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f64911i.errorAll(th);
                }
            }

            @Override // i.e
            public void onNext(T2 t2) {
                int i2;
                ArrayList<e> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t2) == null) {
                    try {
                        synchronized (this.f64911i) {
                            ResultManager resultManager = this.f64911i;
                            i2 = resultManager.rightIds;
                            resultManager.rightIds = i2 + 1;
                            this.f64911i.rightMap.put(Integer.valueOf(i2), t2);
                        }
                        c cVar = new c(this.f64911i, i2);
                        this.f64911i.group.a(cVar);
                        this.f64911i.this$0.f64902h.call(t2).D(cVar);
                        synchronized (this.f64911i) {
                            arrayList = new ArrayList(this.f64911i.leftMap().values());
                        }
                        for (e eVar : arrayList) {
                            eVar.onNext(t2);
                        }
                    } catch (Throwable th) {
                        i.m.a.f(th, this);
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
            this.group = new i.u.b();
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
                this.this$0.f64899e.D(bVar);
                this.this$0.f64900f.D(dVar);
            }
        }

        @Override // i.k
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

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.cancel.unsubscribe();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class a<T> implements d.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final RefCountSubscription f64912e;

        /* renamed from: f  reason: collision with root package name */
        public final d<T> f64913f;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class C2290a extends j<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final j<? super T> f64914i;

            /* renamed from: j  reason: collision with root package name */
            public final k f64915j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2290a(a aVar, j<? super T> jVar, k kVar) {
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
                this.f64914i = jVar;
                this.f64915j = kVar;
            }

            @Override // i.e
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f64914i.onCompleted();
                    this.f64915j.unsubscribe();
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.f64914i.onError(th);
                    this.f64915j.unsubscribe();
                }
            }

            @Override // i.e
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.f64914i.onNext(t);
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
            this.f64912e = refCountSubscription;
            this.f64913f = dVar;
        }

        @Override // i.d.a, i.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                k a = this.f64912e.a();
                C2290a c2290a = new C2290a(this, jVar, a);
                c2290a.b(a);
                this.f64913f.D(c2290a);
            }
        }
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            ResultManager resultManager = new ResultManager(this, new i.q.e(jVar));
            jVar.b(resultManager);
            resultManager.init();
        }
    }
}
