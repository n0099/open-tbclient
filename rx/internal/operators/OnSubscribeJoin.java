package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.j;
import g.k;
import g.n.f;
import g.n.g;
import g.q.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final d<TLeft> a;

    /* renamed from: b  reason: collision with root package name */
    public final d<TRight> f45395b;

    /* renamed from: c  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f45396c;

    /* renamed from: d  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f45397d;

    /* renamed from: e  reason: collision with root package name */
    public final g<TLeft, TRight, R> f45398e;

    /* loaded from: classes8.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final g.u.b group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap;
        public final j<? super R> subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        /* loaded from: classes8.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f45399e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public final class C2160a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f45400e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f45401f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f45402g;

                public C2160a(a aVar, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, Integer.valueOf(i)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f45402g = aVar;
                    this.f45401f = true;
                    this.f45400e = i;
                }

                @Override // g.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45401f) {
                        this.f45401f = false;
                        this.f45402g.g(this.f45400e, this);
                    }
                }

                @Override // g.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f45402g.onError(th);
                    }
                }

                @Override // g.e
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45399e = resultSink;
            }

            public void g(int i, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, kVar) == null) {
                    synchronized (this.f45399e) {
                        z = this.f45399e.leftMap().remove(Integer.valueOf(i)) != null && this.f45399e.leftMap().isEmpty() && this.f45399e.leftDone;
                    }
                    if (z) {
                        this.f45399e.subscriber.onCompleted();
                        this.f45399e.subscriber.unsubscribe();
                        return;
                    }
                    this.f45399e.group.b(kVar);
                }
            }

            @Override // g.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f45399e) {
                        z = true;
                        this.f45399e.leftDone = true;
                        if (!this.f45399e.rightDone && !this.f45399e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f45399e.subscriber.onCompleted();
                        this.f45399e.subscriber.unsubscribe();
                        return;
                    }
                    this.f45399e.group.b(this);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f45399e.subscriber.onError(th);
                    this.f45399e.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: g.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // g.e
            public void onNext(TLeft tleft) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tleft) == null) {
                    synchronized (this.f45399e) {
                        ResultSink resultSink = this.f45399e;
                        i = resultSink.leftId;
                        resultSink.leftId = i + 1;
                        this.f45399e.leftMap().put(Integer.valueOf(i), tleft);
                        i2 = this.f45399e.rightId;
                    }
                    try {
                        C2160a c2160a = new C2160a(this, i);
                        this.f45399e.group.a(c2160a);
                        this.f45399e.this$0.f45396c.call(tleft).D(c2160a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f45399e) {
                            for (Map.Entry<Integer, TRight> entry : this.f45399e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f45399e.subscriber.onNext(this.f45399e.this$0.f45398e.call(tleft, obj));
                        }
                    } catch (Throwable th) {
                        g.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f45403e;

            /* loaded from: classes8.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f45404e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f45405f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ b f45406g;

                public a(b bVar, int i) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar, Integer.valueOf(i)};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f45406g = bVar;
                    this.f45405f = true;
                    this.f45404e = i;
                }

                @Override // g.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45405f) {
                        this.f45405f = false;
                        this.f45406g.g(this.f45404e, this);
                    }
                }

                @Override // g.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f45406g.onError(th);
                    }
                }

                @Override // g.e
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45403e = resultSink;
            }

            public void g(int i, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, kVar) == null) {
                    synchronized (this.f45403e) {
                        z = this.f45403e.rightMap.remove(Integer.valueOf(i)) != null && this.f45403e.rightMap.isEmpty() && this.f45403e.rightDone;
                    }
                    if (z) {
                        this.f45403e.subscriber.onCompleted();
                        this.f45403e.subscriber.unsubscribe();
                        return;
                    }
                    this.f45403e.group.b(kVar);
                }
            }

            @Override // g.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f45403e) {
                        z = true;
                        this.f45403e.rightDone = true;
                        if (!this.f45403e.leftDone && !this.f45403e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f45403e.subscriber.onCompleted();
                        this.f45403e.subscriber.unsubscribe();
                        return;
                    }
                    this.f45403e.group.b(this);
                }
            }

            @Override // g.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f45403e.subscriber.onError(th);
                    this.f45403e.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: g.n.g<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // g.e
            public void onNext(TRight tright) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tright) == null) {
                    synchronized (this.f45403e) {
                        ResultSink resultSink = this.f45403e;
                        i = resultSink.rightId;
                        resultSink.rightId = i + 1;
                        this.f45403e.rightMap.put(Integer.valueOf(i), tright);
                        i2 = this.f45403e.leftId;
                    }
                    this.f45403e.group.a(new g.u.d());
                    try {
                        a aVar = new a(this, i);
                        this.f45403e.group.a(aVar);
                        this.f45403e.this$0.f45397d.call(tright).D(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f45403e) {
                            for (Map.Entry<Integer, TLeft> entry : this.f45403e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f45403e.subscriber.onNext(this.f45403e.this$0.f45398e.call(obj, tright));
                        }
                    } catch (Throwable th) {
                        g.m.a.f(th, this);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = onSubscribeJoin;
            this.subscriber = jVar;
            this.group = new g.u.b();
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
                this.this$0.a.D(aVar);
                this.this$0.f45395b.D(bVar);
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
            new ResultSink(this, new e(jVar)).run();
        }
    }
}
