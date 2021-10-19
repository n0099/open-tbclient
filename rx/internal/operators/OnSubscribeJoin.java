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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f79754e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f79755f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f79756g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f79757h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f79758i;

    /* loaded from: classes2.dex */
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

        /* loaded from: classes2.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f79759e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C2159a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f79760e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f79761f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f79762g;

                public C2159a(a aVar, int i2) {
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
                    this.f79762g = aVar;
                    this.f79761f = true;
                    this.f79760e = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f79761f) {
                        this.f79761f = false;
                        this.f79762g.b(this.f79760e, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f79762g.onError(th);
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
                this.f79759e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f79759e) {
                        z = this.f79759e.leftMap().remove(Integer.valueOf(i2)) != null && this.f79759e.leftMap().isEmpty() && this.f79759e.leftDone;
                    }
                    if (z) {
                        this.f79759e.subscriber.onCompleted();
                        this.f79759e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79759e.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f79759e) {
                        z = true;
                        this.f79759e.leftDone = true;
                        if (!this.f79759e.rightDone && !this.f79759e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f79759e.subscriber.onCompleted();
                        this.f79759e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79759e.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f79759e.subscriber.onError(th);
                    this.f79759e.subscriber.unsubscribe();
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
                    synchronized (this.f79759e) {
                        ResultSink resultSink = this.f79759e;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f79759e.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f79759e.rightId;
                    }
                    try {
                        C2159a c2159a = new C2159a(this, i2);
                        this.f79759e.group.a(c2159a);
                        this.f79759e.this$0.f79756g.call(tleft).I(c2159a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f79759e) {
                            for (Map.Entry<Integer, TRight> entry : this.f79759e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f79759e.subscriber.onNext(this.f79759e.this$0.f79758i.a(tleft, obj));
                        }
                    } catch (Throwable th) {
                        i.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f79763e;

            /* loaded from: classes2.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f79764e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f79765f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ b f79766g;

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
                    this.f79766g = bVar;
                    this.f79765f = true;
                    this.f79764e = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f79765f) {
                        this.f79765f = false;
                        this.f79766g.b(this.f79764e, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f79766g.onError(th);
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
                this.f79763e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f79763e) {
                        z = this.f79763e.rightMap.remove(Integer.valueOf(i2)) != null && this.f79763e.rightMap.isEmpty() && this.f79763e.rightDone;
                    }
                    if (z) {
                        this.f79763e.subscriber.onCompleted();
                        this.f79763e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79763e.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f79763e) {
                        z = true;
                        this.f79763e.rightDone = true;
                        if (!this.f79763e.leftDone && !this.f79763e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f79763e.subscriber.onCompleted();
                        this.f79763e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79763e.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f79763e.subscriber.onError(th);
                    this.f79763e.subscriber.unsubscribe();
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
                    synchronized (this.f79763e) {
                        ResultSink resultSink = this.f79763e;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f79763e.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f79763e.leftId;
                    }
                    this.f79763e.group.a(new i.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f79763e.group.a(aVar);
                        this.f79763e.this$0.f79757h.call(tright).I(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f79763e) {
                            for (Map.Entry<Integer, TLeft> entry : this.f79763e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f79763e.subscriber.onNext(this.f79763e.this$0.f79758i.a(obj, tright));
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
                this.subscriber.add(this.group);
                a aVar = new a(this);
                b bVar = new b(this);
                this.group.a(aVar);
                this.group.a(bVar);
                this.this$0.f79754e.I(aVar);
                this.this$0.f79755f.I(bVar);
            }
        }
    }
}
