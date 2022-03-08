package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.j;
import i.k;
import i.n.f;
import i.n.g;
import i.q.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f61041e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f61042f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f61043g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f61044h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f61045i;

    /* loaded from: classes9.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final i.u.b group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        /* loaded from: classes9.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultSink f61046i;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public final class C2311a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f61047i;

                /* renamed from: j  reason: collision with root package name */
                public boolean f61048j;
                public final /* synthetic */ a k;

                public C2311a(a aVar, int i2) {
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
                    this.f61048j = true;
                    this.f61047i = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61048j) {
                        this.f61048j = false;
                        this.k.g(this.f61047i, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.k.onError(th);
                    }
                }

                @Override // i.e
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
                this.f61046i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f61046i) {
                        z = this.f61046i.leftMap().remove(Integer.valueOf(i2)) != null && this.f61046i.leftMap().isEmpty() && this.f61046i.leftDone;
                    }
                    if (z) {
                        this.f61046i.subscriber.onCompleted();
                        this.f61046i.subscriber.unsubscribe();
                        return;
                    }
                    this.f61046i.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f61046i) {
                        z = true;
                        this.f61046i.leftDone = true;
                        if (!this.f61046i.rightDone && !this.f61046i.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f61046i.subscriber.onCompleted();
                        this.f61046i.subscriber.unsubscribe();
                        return;
                    }
                    this.f61046i.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f61046i.subscriber.onError(th);
                    this.f61046i.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: i.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // i.e
            public void onNext(TLeft tleft) {
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tleft) == null) {
                    synchronized (this.f61046i) {
                        ResultSink resultSink = this.f61046i;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f61046i.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f61046i.rightId;
                    }
                    try {
                        C2311a c2311a = new C2311a(this, i2);
                        this.f61046i.group.a(c2311a);
                        this.f61046i.this$0.f61043g.call(tleft).D(c2311a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f61046i) {
                            for (Map.Entry<Integer, TRight> entry : this.f61046i.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f61046i.subscriber.onNext(this.f61046i.this$0.f61045i.call(tleft, obj));
                        }
                    } catch (Throwable th) {
                        i.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ ResultSink f61049i;

            /* loaded from: classes9.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f61050i;

                /* renamed from: j  reason: collision with root package name */
                public boolean f61051j;
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
                    this.f61051j = true;
                    this.f61050i = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61051j) {
                        this.f61051j = false;
                        this.k.g(this.f61050i, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.k.onError(th);
                    }
                }

                @Override // i.e
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
                this.f61049i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f61049i) {
                        z = this.f61049i.rightMap.remove(Integer.valueOf(i2)) != null && this.f61049i.rightMap.isEmpty() && this.f61049i.rightDone;
                    }
                    if (z) {
                        this.f61049i.subscriber.onCompleted();
                        this.f61049i.subscriber.unsubscribe();
                        return;
                    }
                    this.f61049i.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f61049i) {
                        z = true;
                        this.f61049i.rightDone = true;
                        if (!this.f61049i.leftDone && !this.f61049i.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f61049i.subscriber.onCompleted();
                        this.f61049i.subscriber.unsubscribe();
                        return;
                    }
                    this.f61049i.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f61049i.subscriber.onError(th);
                    this.f61049i.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: i.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // i.e
            public void onNext(TRight tright) {
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tright) == null) {
                    synchronized (this.f61049i) {
                        ResultSink resultSink = this.f61049i;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f61049i.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f61049i.leftId;
                    }
                    this.f61049i.group.a(new i.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f61049i.group.a(aVar);
                        this.f61049i.this$0.f61044h.call(tright).D(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f61049i) {
                            for (Map.Entry<Integer, TLeft> entry : this.f61049i.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f61049i.subscriber.onNext(this.f61049i.this$0.f61045i.call(obj, tright));
                        }
                    } catch (Throwable th) {
                        i.m.a.f(th, this);
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
            this.group = new i.u.b();
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
                this.this$0.f61041e.D(aVar);
                this.this$0.f61042f.D(bVar);
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
            new ResultSink(this, new e(jVar)).run();
        }
    }
}
