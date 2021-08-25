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
    public final d<TLeft> f79162e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f79163f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f79164g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f79165h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f79166i;

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
            public final /* synthetic */ ResultSink f79167e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public final class C2153a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f79168e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f79169f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f79170g;

                public C2153a(a aVar, int i2) {
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
                    this.f79170g = aVar;
                    this.f79169f = true;
                    this.f79168e = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f79169f) {
                        this.f79169f = false;
                        this.f79170g.b(this.f79168e, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f79170g.onError(th);
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
                this.f79167e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f79167e) {
                        z = this.f79167e.leftMap().remove(Integer.valueOf(i2)) != null && this.f79167e.leftMap().isEmpty() && this.f79167e.leftDone;
                    }
                    if (z) {
                        this.f79167e.subscriber.onCompleted();
                        this.f79167e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79167e.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f79167e) {
                        z = true;
                        this.f79167e.leftDone = true;
                        if (!this.f79167e.rightDone && !this.f79167e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f79167e.subscriber.onCompleted();
                        this.f79167e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79167e.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f79167e.subscriber.onError(th);
                    this.f79167e.subscriber.unsubscribe();
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
                    synchronized (this.f79167e) {
                        ResultSink resultSink = this.f79167e;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f79167e.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f79167e.rightId;
                    }
                    try {
                        C2153a c2153a = new C2153a(this, i2);
                        this.f79167e.group.a(c2153a);
                        this.f79167e.this$0.f79164g.call(tleft).I(c2153a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f79167e) {
                            for (Map.Entry<Integer, TRight> entry : this.f79167e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f79167e.subscriber.onNext(this.f79167e.this$0.f79166i.a(tleft, obj));
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
            public final /* synthetic */ ResultSink f79171e;

            /* loaded from: classes2.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f79172e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f79173f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ b f79174g;

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
                    this.f79174g = bVar;
                    this.f79173f = true;
                    this.f79172e = i2;
                }

                @Override // i.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f79173f) {
                        this.f79173f = false;
                        this.f79174g.b(this.f79172e, this);
                    }
                }

                @Override // i.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f79174g.onError(th);
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
                this.f79171e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f79171e) {
                        z = this.f79171e.rightMap.remove(Integer.valueOf(i2)) != null && this.f79171e.rightMap.isEmpty() && this.f79171e.rightDone;
                    }
                    if (z) {
                        this.f79171e.subscriber.onCompleted();
                        this.f79171e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79171e.group.b(kVar);
                }
            }

            @Override // i.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f79171e) {
                        z = true;
                        this.f79171e.rightDone = true;
                        if (!this.f79171e.leftDone && !this.f79171e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f79171e.subscriber.onCompleted();
                        this.f79171e.subscriber.unsubscribe();
                        return;
                    }
                    this.f79171e.group.b(this);
                }
            }

            @Override // i.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f79171e.subscriber.onError(th);
                    this.f79171e.subscriber.unsubscribe();
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
                    synchronized (this.f79171e) {
                        ResultSink resultSink = this.f79171e;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f79171e.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f79171e.leftId;
                    }
                    this.f79171e.group.a(new i.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f79171e.group.a(aVar);
                        this.f79171e.this$0.f79165h.call(tright).I(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f79171e) {
                            for (Map.Entry<Integer, TLeft> entry : this.f79171e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f79171e.subscriber.onNext(this.f79171e.this$0.f79166i.a(obj, tright));
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
                this.this$0.f79162e.I(aVar);
                this.this$0.f79163f.I(bVar);
            }
        }
    }
}
