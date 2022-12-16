package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.c3a;
import com.baidu.tieba.d7a;
import com.baidu.tieba.e7a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.n3a;
import com.baidu.tieba.t3a;
import com.baidu.tieba.u3a;
import com.baidu.tieba.v7a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.subjects.PublishSubject;
import rx.subscriptions.RefCountSubscription;
/* loaded from: classes9.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements b3a.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b3a<T1> a;
    public final b3a<T2> b;
    public final t3a<? super T1, ? extends b3a<D1>> c;
    public final t3a<? super T2, ? extends b3a<D2>> d;
    public final u3a<? super T1, ? super b3a<T2>, ? extends R> e;

    /* loaded from: classes9.dex */
    public final class ResultManager extends HashMap<Integer, c3a<T2>> implements i3a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3035156013812425335L;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription cancel;
        public final v7a group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap;
        public final h3a<? super R> subscriber;
        public final /* synthetic */ OnSubscribeGroupJoin this$0;

        public Map<Integer, c3a<T2>> leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (Map) invokeV.objValue;
        }

        /* loaded from: classes9.dex */
        public final class a extends h3a<D1> {
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

            @Override // com.baidu.tieba.c3a
            public void onCompleted() {
                c3a<T2> remove;
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

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.g.errorMain(th);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onNext(D1 d1) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d1) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends h3a<T1> {
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

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.errorAll(th);
                }
            }

            @Override // com.baidu.tieba.c3a
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

            @Override // com.baidu.tieba.c3a
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t1) == null) {
                    try {
                        PublishSubject D = PublishSubject.D();
                        d7a d7aVar = new d7a(D);
                        synchronized (this.e) {
                            ResultManager resultManager = this.e;
                            i = resultManager.leftIds;
                            resultManager.leftIds = i + 1;
                            this.e.leftMap().put(Integer.valueOf(i), d7aVar);
                        }
                        b3a a = b3a.a(new a(D, this.e.cancel));
                        a aVar = new a(this.e, i);
                        this.e.group.a(aVar);
                        this.e.this$0.c.call(t1).B(aVar);
                        R call = this.e.this$0.e.call(t1, a);
                        synchronized (this.e) {
                            arrayList = new ArrayList(this.e.rightMap.values());
                        }
                        this.e.subscriber.onNext(call);
                        for (Object obj : arrayList) {
                            d7aVar.onNext(obj);
                        }
                    } catch (Throwable th) {
                        n3a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class c extends h3a<D2> {
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

            @Override // com.baidu.tieba.c3a
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

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.g.errorMain(th);
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onNext(D2 d2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2) == null) {
                    onCompleted();
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class d extends h3a<T2> {
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

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.errorAll(th);
                }
            }

            @Override // com.baidu.tieba.c3a
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

            @Override // com.baidu.tieba.c3a
            public void onNext(T2 t2) {
                int i;
                ArrayList<c3a> arrayList;
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
                        this.e.this$0.d.call(t2).B(cVar);
                        synchronized (this.e) {
                            arrayList = new ArrayList(this.e.leftMap().values());
                        }
                        for (c3a c3aVar : arrayList) {
                            c3aVar.onNext(t2);
                        }
                    } catch (Throwable th) {
                        n3a.f(th, this);
                    }
                }
            }
        }

        public ResultManager(OnSubscribeGroupJoin onSubscribeGroupJoin, h3a<? super R> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeGroupJoin, h3aVar};
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
            this.subscriber = h3aVar;
            this.group = new v7a();
            this.cancel = new RefCountSubscription(this.group);
        }

        public void complete(List<c3a<T2>> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && list != null) {
                for (c3a<T2> c3aVar : list) {
                    c3aVar.onCompleted();
                }
                this.subscriber.onCompleted();
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

        public void errorAll(Throwable th) {
            ArrayList<c3a> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                synchronized (this) {
                    arrayList = new ArrayList(leftMap().values());
                    leftMap().clear();
                    this.rightMap.clear();
                }
                for (c3a c3aVar : arrayList) {
                    c3aVar.onError(th);
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
                this.this$0.a.B(bVar);
                this.this$0.b.B(dVar);
            }
        }

        @Override // com.baidu.tieba.i3a
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.cancel.isUnsubscribed();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.i3a
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.cancel.unsubscribe();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class a<T> implements b3a.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RefCountSubscription a;
        public final b3a<T> b;

        /* renamed from: rx.internal.operators.OnSubscribeGroupJoin$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public final class C0743a extends h3a<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final h3a<? super T> e;
            public final i3a f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0743a(a aVar, h3a<? super T> h3aVar, i3a i3aVar) {
                super(h3aVar);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, h3aVar, i3aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((h3a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = h3aVar;
                this.f = i3aVar;
            }

            @Override // com.baidu.tieba.c3a
            public void onCompleted() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.e.onCompleted();
                    this.f.unsubscribe();
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.e.onError(th);
                    this.f.unsubscribe();
                }
            }

            @Override // com.baidu.tieba.c3a
            public void onNext(T t) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                    this.e.onNext(t);
                }
            }
        }

        public a(b3a<T> b3aVar, RefCountSubscription refCountSubscription) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b3aVar, refCountSubscription};
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
            this.b = b3aVar;
        }

        public void call(h3a<? super T> h3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
                i3a a = this.a.a();
                C0743a c0743a = new C0743a(this, h3aVar, a);
                c0743a.b(a);
                this.b.B(c0743a);
            }
        }

        @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((h3a) ((h3a) obj));
        }
    }

    public void call(h3a<? super R> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            ResultManager resultManager = new ResultManager(this, new e7a(h3aVar));
            h3aVar.b(resultManager);
            resultManager.init();
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
