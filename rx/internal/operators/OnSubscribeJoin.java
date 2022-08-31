package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bz9;
import com.baidu.tieba.ev9;
import com.baidu.tieba.fv9;
import com.baidu.tieba.kv9;
import com.baidu.tieba.qv9;
import com.baidu.tieba.rv9;
import com.baidu.tieba.sz9;
import com.baidu.tieba.uz9;
import com.baidu.tieba.yu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements yu9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yu9<TLeft> a;
    public final yu9<TRight> b;
    public final qv9<TLeft, yu9<TLeftDuration>> c;
    public final qv9<TRight, yu9<TRightDuration>> d;
    public final rv9<TLeft, TRight, R> e;

    /* loaded from: classes8.dex */
    public final class ResultSink extends HashMap<Integer, TLeft> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final sz9 group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap;
        public final ev9<? super R> subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        /* loaded from: classes8.dex */
        public final class a extends ev9<TLeft> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public final class C0715a extends ev9<TLeftDuration> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final int e;
                public boolean f;
                public final /* synthetic */ a g;

                public C0715a(a aVar, int i) {
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

                @Override // com.baidu.tieba.zu9
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.zu9
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.zu9
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

            public void g(int i, fv9 fv9Var) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, fv9Var) == null) {
                    synchronized (this.e) {
                        z = this.e.leftMap().remove(Integer.valueOf(i)) != null && this.e.leftMap().isEmpty() && this.e.leftDone;
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(fv9Var);
                }
            }

            @Override // com.baidu.tieba.zu9
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

            @Override // com.baidu.tieba.zu9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.rv9<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.zu9
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
                        C0715a c0715a = new C0715a(this, i);
                        this.e.group.a(c0715a);
                        this.e.this$0.c.call(tleft).B(c0715a);
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
                        kv9.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
        public final class b extends ev9<TRight> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* loaded from: classes8.dex */
            public final class a extends ev9<TRightDuration> {
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

                @Override // com.baidu.tieba.zu9
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.zu9
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.zu9
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

            public void g(int i, fv9 fv9Var) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, fv9Var) == null) {
                    synchronized (this.e) {
                        z = this.e.rightMap.remove(Integer.valueOf(i)) != null && this.e.rightMap.isEmpty() && this.e.rightDone;
                    }
                    if (z) {
                        this.e.subscriber.onCompleted();
                        this.e.subscriber.unsubscribe();
                        return;
                    }
                    this.e.group.b(fv9Var);
                }
            }

            @Override // com.baidu.tieba.zu9
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

            @Override // com.baidu.tieba.zu9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: com.baidu.tieba.rv9<TLeft, TRight, R> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.zu9
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
                    this.e.group.a(new uz9());
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
                        kv9.f(th, this);
                    }
                }
            }
        }

        public ResultSink(OnSubscribeJoin onSubscribeJoin, ev9<? super R> ev9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeJoin, ev9Var};
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
            this.subscriber = ev9Var;
            this.group = new sz9();
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
                this.this$0.a.B(aVar);
                this.this$0.b.B(bVar);
            }
        }
    }

    @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ev9) ((ev9) obj));
    }

    public void call(ev9<? super R> ev9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
            new ResultSink(this, new bz9(ev9Var)).run();
        }
    }
}
