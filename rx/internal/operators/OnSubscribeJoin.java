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
    public final d<TLeft> f72614e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f72615f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f72616g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f72617h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f72618i;

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
            public final /* synthetic */ ResultSink f72619i;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public final class C2086a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f72620i;
                public boolean j;
                public final /* synthetic */ a k;

                public C2086a(a aVar, int i2) {
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
                    this.f72620i = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j) {
                        this.j = false;
                        this.k.g(this.f72620i, this);
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
                this.f72619i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f72619i) {
                        z = this.f72619i.leftMap().remove(Integer.valueOf(i2)) != null && this.f72619i.leftMap().isEmpty() && this.f72619i.leftDone;
                    }
                    if (z) {
                        this.f72619i.subscriber.onCompleted();
                        this.f72619i.subscriber.unsubscribe();
                        return;
                    }
                    this.f72619i.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f72619i) {
                        z = true;
                        this.f72619i.leftDone = true;
                        if (!this.f72619i.rightDone && !this.f72619i.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f72619i.subscriber.onCompleted();
                        this.f72619i.subscriber.unsubscribe();
                        return;
                    }
                    this.f72619i.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f72619i.subscriber.onError(th);
                    this.f72619i.subscriber.unsubscribe();
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
                    synchronized (this.f72619i) {
                        ResultSink resultSink = this.f72619i;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f72619i.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f72619i.rightId;
                    }
                    try {
                        C2086a c2086a = new C2086a(this, i2);
                        this.f72619i.group.a(c2086a);
                        this.f72619i.this$0.f72616g.call(tleft).D(c2086a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f72619i) {
                            for (Map.Entry<Integer, TRight> entry : this.f72619i.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f72619i.subscriber.onNext(this.f72619i.this$0.f72618i.call(tleft, obj));
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
            public final /* synthetic */ ResultSink f72621i;

            /* loaded from: classes3.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: i  reason: collision with root package name */
                public final int f72622i;
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
                    this.f72622i = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j) {
                        this.j = false;
                        this.k.g(this.f72622i, this);
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
                this.f72621i = resultSink;
            }

            public void g(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f72621i) {
                        z = this.f72621i.rightMap.remove(Integer.valueOf(i2)) != null && this.f72621i.rightMap.isEmpty() && this.f72621i.rightDone;
                    }
                    if (z) {
                        this.f72621i.subscriber.onCompleted();
                        this.f72621i.subscriber.unsubscribe();
                        return;
                    }
                    this.f72621i.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f72621i) {
                        z = true;
                        this.f72621i.rightDone = true;
                        if (!this.f72621i.leftDone && !this.f72621i.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f72621i.subscriber.onCompleted();
                        this.f72621i.subscriber.unsubscribe();
                        return;
                    }
                    this.f72621i.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f72621i.subscriber.onError(th);
                    this.f72621i.subscriber.unsubscribe();
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
                    synchronized (this.f72621i) {
                        ResultSink resultSink = this.f72621i;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f72621i.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f72621i.leftId;
                    }
                    this.f72621i.group.a(new h.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f72621i.group.a(aVar);
                        this.f72621i.this$0.f72617h.call(tright).D(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f72621i) {
                            for (Map.Entry<Integer, TLeft> entry : this.f72621i.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f72621i.subscriber.onNext(this.f72621i.this$0.f72618i.call(obj, tright));
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
                this.this$0.f72614e.D(aVar);
                this.this$0.f72615f.D(bVar);
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
