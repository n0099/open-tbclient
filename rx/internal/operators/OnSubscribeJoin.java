package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c9a;
import com.baidu.tieba.d9a;
import com.baidu.tieba.eda;
import com.baidu.tieba.gda;
import com.baidu.tieba.k8a;
import com.baidu.tieba.nca;
import com.baidu.tieba.q8a;
import com.baidu.tieba.r8a;
import com.baidu.tieba.w8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements k8a.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k8a<TLeft> a;
    public final k8a<TRight> b;
    public final c9a<TLeft, k8a<TLeftDuration>> c;
    public final c9a<TRight, k8a<TRightDuration>> d;
    public final d9a<TLeft, TRight, R> e;

    /* loaded from: classes9.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final eda group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap;
        public final q8a<? super R> subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        public HashMap<Integer, TLeft> leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (HashMap) invokeV.objValue;
        }

        /* loaded from: classes9.dex */
        public final class a extends q8a<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public final class C0743a extends q8a<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final int e;
                public boolean f;
                public final /* synthetic */ a g;

                public C0743a(a aVar, int i) {
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
                    this.g = aVar;
                    this.f = true;
                    this.e = i;
                }

                @Override // com.baidu.tieba.l8a
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.l8a
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.l8a
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
                this.e = resultSink;
            }

            @Override // com.baidu.tieba.l8a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            public void g(int i, r8a r8aVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, r8aVar) == null) {
                    synchronized (this.e) {
                        if (this.e.leftMap().remove(Integer.valueOf(i)) != null && this.e.leftMap().isEmpty() && this.e.leftDone) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(r8aVar);
                }
            }

            @Override // com.baidu.tieba.l8a
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.e) {
                        z = true;
                        this.e.leftDone = true;
                        if (!this.e.rightDone && !this.e.leftMap().isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(this);
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.d9a<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.l8a
            public void onNext(TLeft tleft) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tleft) == null) {
                    synchronized (this.e) {
                        ResultSink resultSink = this.e;
                        i = resultSink.leftId;
                        resultSink.leftId = i + 1;
                        this.e.leftMap().put(Integer.valueOf(i), tleft);
                        i2 = this.e.rightId;
                    }
                    try {
                        C0743a c0743a = new C0743a(this, i);
                        this.e.group.a(c0743a);
                        this.e.this$0.c.call(tleft).B(c0743a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.e) {
                            for (Map.Entry<Integer, TRight> entry : this.e.rightMap.entrySet()) {
                                if (entry.getKey().intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.e.subscriber.onNext(this.e.this$0.e.call(tleft, obj));
                        }
                    } catch (Throwable th) {
                        w8a.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends q8a<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* loaded from: classes9.dex */
            public final class a extends q8a<TRightDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final int e;
                public boolean f;
                public final /* synthetic */ b g;

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
                    this.g = bVar;
                    this.f = true;
                    this.e = i;
                }

                @Override // com.baidu.tieba.l8a
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.l8a
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.l8a
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
                this.e = resultSink;
            }

            @Override // com.baidu.tieba.l8a
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            public void g(int i, r8a r8aVar) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, r8aVar) == null) {
                    synchronized (this.e) {
                        if (this.e.rightMap.remove(Integer.valueOf(i)) != null && this.e.rightMap.isEmpty() && this.e.rightDone) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(r8aVar);
                }
            }

            @Override // com.baidu.tieba.l8a
            public void onCompleted() {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.e) {
                        z = true;
                        this.e.rightDone = true;
                        if (!this.e.leftDone && !this.e.rightMap.isEmpty()) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(this);
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.d9a<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.l8a
            public void onNext(TRight tright) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, tright) == null) {
                    synchronized (this.e) {
                        ResultSink resultSink = this.e;
                        i = resultSink.rightId;
                        resultSink.rightId = i + 1;
                        this.e.rightMap.put(Integer.valueOf(i), tright);
                        i2 = this.e.leftId;
                    }
                    this.e.group.a(new gda());
                    try {
                        a aVar = new a(this, i);
                        this.e.group.a(aVar);
                        this.e.this$0.d.call(tright).B(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.e) {
                            for (Map.Entry<Integer, TLeft> entry : this.e.leftMap().entrySet()) {
                                if (entry.getKey().intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj : arrayList) {
                            this.e.subscriber.onNext(this.e.this$0.e.call(obj, tright));
                        }
                    } catch (Throwable th) {
                        w8a.f(th, this);
                    }
                }
            }
        }

        public ResultSink(OnSubscribeJoin onSubscribeJoin, q8a<? super R> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeJoin, q8aVar};
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
            this.subscriber = q8aVar;
            this.group = new eda();
            this.rightMap = new HashMap();
        }

        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.subscriber.b(this.group);
                a aVar = new a(this);
                b bVar = new b(this);
                this.group.a(aVar);
                this.group.a(bVar);
                this.this$0.a.B(aVar);
                this.this$0.b.B(bVar);
            }
        }
    }

    public void call(q8a<? super R> q8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q8aVar) == null) {
            new ResultSink(this, new nca(q8aVar)).run();
        }
    }

    @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((q8a) ((q8a) obj));
    }
}
