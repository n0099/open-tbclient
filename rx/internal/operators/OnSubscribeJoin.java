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
/* loaded from: classes10.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements d.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final d<TLeft> f76171e;

    /* renamed from: f  reason: collision with root package name */
    public final d<TRight> f76172f;

    /* renamed from: g  reason: collision with root package name */
    public final f<TLeft, d<TLeftDuration>> f76173g;

    /* renamed from: h  reason: collision with root package name */
    public final f<TRight, d<TRightDuration>> f76174h;

    /* renamed from: i  reason: collision with root package name */
    public final g<TLeft, TRight, R> f76175i;

    /* loaded from: classes10.dex */
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

        /* loaded from: classes10.dex */
        public final class a extends j<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f76176e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            public final class C2129a extends j<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f76177e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f76178f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ a f76179g;

                public C2129a(a aVar, int i2) {
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
                    this.f76179g = aVar;
                    this.f76178f = true;
                    this.f76177e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f76178f) {
                        this.f76178f = false;
                        this.f76179g.b(this.f76177e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f76179g.onError(th);
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
                this.f76176e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f76176e) {
                        z = this.f76176e.leftMap().remove(Integer.valueOf(i2)) != null && this.f76176e.leftMap().isEmpty() && this.f76176e.leftDone;
                    }
                    if (z) {
                        this.f76176e.subscriber.onCompleted();
                        this.f76176e.subscriber.unsubscribe();
                        return;
                    }
                    this.f76176e.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f76176e) {
                        z = true;
                        this.f76176e.leftDone = true;
                        if (!this.f76176e.rightDone && !this.f76176e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f76176e.subscriber.onCompleted();
                        this.f76176e.subscriber.unsubscribe();
                        return;
                    }
                    this.f76176e.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f76176e.subscriber.onError(th);
                    this.f76176e.subscriber.unsubscribe();
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
                    synchronized (this.f76176e) {
                        ResultSink resultSink = this.f76176e;
                        i2 = resultSink.leftId;
                        resultSink.leftId = i2 + 1;
                        this.f76176e.leftMap().put(Integer.valueOf(i2), tleft);
                        i3 = this.f76176e.rightId;
                    }
                    try {
                        C2129a c2129a = new C2129a(this, i2);
                        this.f76176e.group.a(c2129a);
                        this.f76176e.this$0.f76173g.call(tleft).I(c2129a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f76176e) {
                            for (Map.Entry<Integer, TRight> entry : this.f76176e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f76176e.subscriber.onNext(this.f76176e.this$0.f76175i.a(tleft, obj));
                        }
                    } catch (Throwable th) {
                        h.m.a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes10.dex */
        public final class b extends j<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ResultSink f76180e;

            /* loaded from: classes10.dex */
            public final class a extends j<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final int f76181e;

                /* renamed from: f  reason: collision with root package name */
                public boolean f76182f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ b f76183g;

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
                    this.f76183g = bVar;
                    this.f76182f = true;
                    this.f76181e = i2;
                }

                @Override // h.e
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f76182f) {
                        this.f76182f = false;
                        this.f76183g.b(this.f76181e, this);
                    }
                }

                @Override // h.e
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.f76183g.onError(th);
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
                this.f76180e = resultSink;
            }

            public void b(int i2, k kVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i2, kVar) == null) {
                    synchronized (this.f76180e) {
                        z = this.f76180e.rightMap.remove(Integer.valueOf(i2)) != null && this.f76180e.rightMap.isEmpty() && this.f76180e.rightDone;
                    }
                    if (z) {
                        this.f76180e.subscriber.onCompleted();
                        this.f76180e.subscriber.unsubscribe();
                        return;
                    }
                    this.f76180e.group.b(kVar);
                }
            }

            @Override // h.e
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.f76180e) {
                        z = true;
                        this.f76180e.rightDone = true;
                        if (!this.f76180e.leftDone && !this.f76180e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f76180e.subscriber.onCompleted();
                        this.f76180e.subscriber.unsubscribe();
                        return;
                    }
                    this.f76180e.group.b(this);
                }
            }

            @Override // h.e
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.f76180e.subscriber.onError(th);
                    this.f76180e.subscriber.unsubscribe();
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
                    synchronized (this.f76180e) {
                        ResultSink resultSink = this.f76180e;
                        i2 = resultSink.rightId;
                        resultSink.rightId = i2 + 1;
                        this.f76180e.rightMap.put(Integer.valueOf(i2), tright);
                        i3 = this.f76180e.leftId;
                    }
                    this.f76180e.group.a(new h.u.d());
                    try {
                        a aVar = new a(this, i2);
                        this.f76180e.group.a(aVar);
                        this.f76180e.this$0.f76174h.call(tright).I(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.f76180e) {
                            for (Map.Entry<Integer, TLeft> entry : this.f76180e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i3) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.f76180e.subscriber.onNext(this.f76180e.this$0.f76175i.a(obj, tright));
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
                this.this$0.f76171e.I(aVar);
                this.this$0.f76172f.I(bVar);
            }
        }
    }
}
