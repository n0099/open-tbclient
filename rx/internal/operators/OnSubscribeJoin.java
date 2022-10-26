package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a2a;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ey9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.py9;
import com.baidu.tieba.qy9;
import com.baidu.tieba.r2a;
import com.baidu.tieba.t2a;
import com.baidu.tieba.xx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public final class OnSubscribeJoin implements xx9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xx9 a;
    public final xx9 b;
    public final py9 c;
    public final py9 d;
    public final qy9 e;

    /* loaded from: classes9.dex */
    public final class ResultSink extends HashMap {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3491669543549085380L;
        public transient /* synthetic */ FieldHolder $fh;
        public final r2a group;
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map rightMap;
        public final dy9 subscriber;
        public final /* synthetic */ OnSubscribeJoin this$0;

        public HashMap leftMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (HashMap) invokeV.objValue;
        }

        /* loaded from: classes9.dex */
        public final class a extends dy9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* renamed from: rx.internal.operators.OnSubscribeJoin$ResultSink$a$a  reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            public final class C0712a extends dy9 {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final int e;
                public boolean f;
                public final /* synthetic */ a g;

                public C0712a(a aVar, int i) {
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

                @Override // com.baidu.tieba.yx9
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.yx9
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.yx9
                public void onNext(Object obj) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
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

            @Override // com.baidu.tieba.yx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            public void g(int i, ey9 ey9Var) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, ey9Var) == null) {
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
                    this.e.group.b(ey9Var);
                }
            }

            @Override // com.baidu.tieba.yx9
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

            @Override // com.baidu.tieba.yx9
            public void onNext(Object obj) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                    synchronized (this.e) {
                        ResultSink resultSink = this.e;
                        i = resultSink.leftId;
                        resultSink.leftId = i + 1;
                        this.e.leftMap().put(Integer.valueOf(i), obj);
                        i2 = this.e.rightId;
                    }
                    try {
                        C0712a c0712a = new C0712a(this, i);
                        this.e.group.a(c0712a);
                        ((xx9) this.e.this$0.c.call(obj)).B(c0712a);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.e) {
                            for (Map.Entry entry : this.e.rightMap.entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj2 : arrayList) {
                            this.e.subscriber.onNext(this.e.this$0.e.call(obj, obj2));
                        }
                    } catch (Throwable th) {
                        jy9.f(th, this);
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public final class b extends dy9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResultSink e;

            /* loaded from: classes9.dex */
            public final class a extends dy9 {
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

                @Override // com.baidu.tieba.yx9
                public void onCompleted() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f) {
                        this.f = false;
                        this.g.g(this.e, this);
                    }
                }

                @Override // com.baidu.tieba.yx9
                public void onError(Throwable th) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                        this.g.onError(th);
                    }
                }

                @Override // com.baidu.tieba.yx9
                public void onNext(Object obj) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
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

            @Override // com.baidu.tieba.yx9
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                    this.e.subscriber.onError(th);
                    this.e.subscriber.unsubscribe();
                }
            }

            public void g(int i, ey9 ey9Var) {
                boolean z;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048576, this, i, ey9Var) == null) {
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
                    this.e.group.b(ey9Var);
                }
            }

            @Override // com.baidu.tieba.yx9
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

            @Override // com.baidu.tieba.yx9
            public void onNext(Object obj) {
                int i;
                int i2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                    synchronized (this.e) {
                        ResultSink resultSink = this.e;
                        i = resultSink.rightId;
                        resultSink.rightId = i + 1;
                        this.e.rightMap.put(Integer.valueOf(i), obj);
                        i2 = this.e.leftId;
                    }
                    this.e.group.a(new t2a());
                    try {
                        a aVar = new a(this, i);
                        this.e.group.a(aVar);
                        ((xx9) this.e.this$0.d.call(obj)).B(aVar);
                        ArrayList<Object> arrayList = new ArrayList();
                        synchronized (this.e) {
                            for (Map.Entry entry : this.e.leftMap().entrySet()) {
                                if (((Integer) entry.getKey()).intValue() < i2) {
                                    arrayList.add(entry.getValue());
                                }
                            }
                        }
                        for (Object obj2 : arrayList) {
                            this.e.subscriber.onNext(this.e.this$0.e.call(obj2, obj));
                        }
                    } catch (Throwable th) {
                        jy9.f(th, this);
                    }
                }
            }
        }

        public ResultSink(OnSubscribeJoin onSubscribeJoin, dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribeJoin, dy9Var};
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
            this.subscriber = dy9Var;
            this.group = new r2a();
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
            new ResultSink(this, new a2a(dy9Var)).run();
        }
    }
}
