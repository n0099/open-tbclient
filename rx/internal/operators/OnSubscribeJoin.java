package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.j;
import h.k;
import h.n.f;
import h.n.g;
import h.q.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f73532e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f73533f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f73534g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f73535h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f73536i;

    /* loaded from: classes3.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final h.u.b group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        /* loaded from: classes3.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultSink f73537i;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public final class C2122a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f73538i;
                public boolean j;
                public final /* synthetic */ a k;

                public C2122a(a aVar, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Integer.valueOf(i2)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.k = aVar;
                    this.j = true;
                    this.f73538i = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j) {
                        this.j = false;
                        this.k.g(this.f73538i, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.k.onError(th);
                    }
                }

                @Override // h.e
                public void onNext(TLeftDuration tleftduration) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tleftduration) == null) {
                        onCompleted();
                    }
                }
            }

            public a(ResultSink resultSink) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultSink};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73537i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f73537i) {
                        z = this.f73537i.leftMap().remove(Integer.valueOf(i2)) != null && this.f73537i.leftMap().isEmpty() && this.f73537i.leftDone;
                    }
                    if (z) {
                        this.f73537i.subscriber.onCompleted();
                        this.f73537i.subscriber.unsubscribe();
                        return;
                    }
                    this.f73537i.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f73537i) {
                        z = true;
                        this.f73537i.leftDone = true;
                        if (!this.f73537i.rightDone && !this.f73537i.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f73537i.subscriber.onCompleted();
                        this.f73537i.subscriber.unsubscribe();
                        return;
                    }
                    this.f73537i.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f73537i.subscriber.onError(th);
                    this.f73537i.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: h.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.e
            public void onNext(TLeft tleft) {
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tleft) == null) {
                    synchronized (this.f73537i) {
                        ResultSink resultSink = this.f73537i;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f73537i.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f73537i.rightId;
                    }
                    try {
                        C2122a c2122a = new C2122a(this, i2);
                        this.f73537i.group.a(c2122a);
                        this.f73537i.this$0.f73534g.call(tleft).D(c2122a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f73537i) {
                            for (Map.Entry<Integer, TRight> entry : this.f73537i.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f73537i.subscriber.onNext(this.f73537i.this$0.f73536i.call(tleft, obj));
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultSink f73539i;

            /* loaded from: classes3.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f73540i;
                public boolean j;
                public final /* synthetic */ b k;

                public a(b bVar, int i2) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Integer.valueOf(i2)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.k = bVar;
                    this.j = true;
                    this.f73540i = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j) {
                        this.j = false;
                        this.k.g(this.f73540i, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.k.onError(th);
                    }
                }

                @Override // h.e
                public void onNext(TRightDuration trightduration) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, trightduration) == null) {
                        onCompleted();
                    }
                }
            }

            public b(ResultSink resultSink) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {resultSink};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f73539i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f73539i) {
                        z = this.f73539i.rightMap.remove(Integer.valueOf(i2)) != null && this.f73539i.rightMap.isEmpty() && this.f73539i.rightDone;
                    }
                    if (z) {
                        this.f73539i.subscriber.onCompleted();
                        this.f73539i.subscriber.unsubscribe();
                        return;
                    }
                    this.f73539i.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f73539i) {
                        z = true;
                        this.f73539i.rightDone = true;
                        if (!this.f73539i.leftDone && !this.f73539i.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f73539i.subscriber.onCompleted();
                        this.f73539i.subscriber.unsubscribe();
                        return;
                    }
                    this.f73539i.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f73539i.subscriber.onError(th);
                    this.f73539i.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: h.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // h.e
            public void onNext(TRight tright) {
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tright) == null) {
                    synchronized (this.f73539i) {
                        ResultSink resultSink = this.f73539i;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f73539i.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f73539i.leftId;
                    }
                    this.f73539i.group.a(new h.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f73539i.group.a(aVar);
                        this.f73539i.this$0.f73535h.call(tright).D(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f73539i) {
                            for (Map.Entry<Integer, TLeft> entry : this.f73539i.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f73539i.subscriber.onNext(this.f73539i.this$0.f73536i.call(obj, tright));
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
                    }
                }
            }
        }

        public ResultSink(OnSubscribeJoin onSubscribeJoin, j<? super R> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeJoin, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = onSubscribeJoin;
            this.subscriber = jVar;
            this.group = new h.u.b();
            this.rightMap = new HashMap();
        }

        public HashMap<Integer, TLeft> leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (HashMap) invokeV.objValue;
        }

        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.subscriber.b(this.group);
                a aVar = new a(this);
                b bVar = new b(this);
                this.group.a(aVar);
                this.group.a(bVar);
                this.this$0.f73532e.D(aVar);
                this.this$0.f73533f.D(bVar);
            }
        }
    }

    @Override // h.d.a, h.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public void call(j<? super R> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            new ResultSink(this, new e(jVar)).run();
        }
    }
}
