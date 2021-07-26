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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f73659e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f73660f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f73661g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f73662h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f73663i;

    /* loaded from: classes9.dex */
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

        /* loaded from: classes9.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f73664e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public final class C2096a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f73665e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f73666f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f73667g;

                public C2096a(a aVar, int i2) {
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
                    this.f73667g = aVar;
                    this.f73666f = true;
                    this.f73665e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73666f) {
                        this.f73666f = false;
                        this.f73667g.b(this.f73665e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f73667g.onError(th);
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
                this.f73664e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f73664e) {
                        z = this.f73664e.leftMap().remove(Integer.valueOf(i2)) != null && this.f73664e.leftMap().isEmpty() && this.f73664e.leftDone;
                    }
                    if (z) {
                        this.f73664e.subscriber.onCompleted();
                        this.f73664e.subscriber.unsubscribe();
                        return;
                    }
                    this.f73664e.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f73664e) {
                        z = true;
                        this.f73664e.leftDone = true;
                        if (!this.f73664e.rightDone && !this.f73664e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f73664e.subscriber.onCompleted();
                        this.f73664e.subscriber.unsubscribe();
                        return;
                    }
                    this.f73664e.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f73664e.subscriber.onError(th);
                    this.f73664e.subscriber.unsubscribe();
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
                    synchronized (this.f73664e) {
                        ResultSink resultSink = this.f73664e;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f73664e.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f73664e.rightId;
                    }
                    try {
                        C2096a c2096a = new C2096a(this, i2);
                        this.f73664e.group.a(c2096a);
                        this.f73664e.this$0.f73661g.call(tleft).I(c2096a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f73664e) {
                            for (Map.Entry<Integer, TRight> entry : this.f73664e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f73664e.subscriber.onNext(this.f73664e.this$0.f73663i.a(tleft, obj));
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f73668e;

            /* loaded from: classes9.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f73669e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f73670f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ b f73671g;

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
                    this.f73671g = bVar;
                    this.f73670f = true;
                    this.f73669e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f73670f) {
                        this.f73670f = false;
                        this.f73671g.b(this.f73669e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f73671g.onError(th);
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
                this.f73668e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f73668e) {
                        z = this.f73668e.rightMap.remove(Integer.valueOf(i2)) != null && this.f73668e.rightMap.isEmpty() && this.f73668e.rightDone;
                    }
                    if (z) {
                        this.f73668e.subscriber.onCompleted();
                        this.f73668e.subscriber.unsubscribe();
                        return;
                    }
                    this.f73668e.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f73668e) {
                        z = true;
                        this.f73668e.rightDone = true;
                        if (!this.f73668e.leftDone && !this.f73668e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f73668e.subscriber.onCompleted();
                        this.f73668e.subscriber.unsubscribe();
                        return;
                    }
                    this.f73668e.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f73668e.subscriber.onError(th);
                    this.f73668e.subscriber.unsubscribe();
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
                    synchronized (this.f73668e) {
                        ResultSink resultSink = this.f73668e;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f73668e.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f73668e.leftId;
                    }
                    this.f73668e.group.a(new h.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f73668e.group.a(aVar);
                        this.f73668e.this$0.f73662h.call(tright).I(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f73668e) {
                            for (Map.Entry<Integer, TLeft> entry : this.f73668e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f73668e.subscriber.onNext(this.f73668e.this$0.f73663i.a(obj, tright));
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
                this.subscriber.add(this.group);
                a aVar = new a(this);
                b bVar = new b(this);
                this.group.a(aVar);
                this.group.a(bVar);
                this.this$0.f73659e.I(aVar);
                this.this$0.f73660f.I(bVar);
            }
        }
    }
}
