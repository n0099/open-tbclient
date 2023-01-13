package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hda;
import com.baidu.tieba.k8a;
import com.baidu.tieba.l8a;
import com.baidu.tieba.q8a;
import com.baidu.tieba.x8a;
import com.baidu.tieba.y8a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
/* loaded from: classes9.dex */
public final class SubjectSubscriptionManager<T> extends AtomicReference<b<T>> implements k8a.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6035251036011671568L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean active;
    public volatile Object latest;
    public y8a<c<T>> onAdded;
    public y8a<c<T>> onStart;
    public y8a<c<T>> onTerminated;

    /* loaded from: classes9.dex */
    public class a implements x8a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ SubjectSubscriptionManager b;

        public a(SubjectSubscriptionManager subjectSubscriptionManager, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subjectSubscriptionManager, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = subjectSubscriptionManager;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.x8a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.remove(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class b<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final c[] c;
        public static final b d;
        public static final b e;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final c[] b;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2042411886, "Lrx/subjects/SubjectSubscriptionManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2042411886, "Lrx/subjects/SubjectSubscriptionManager$b;");
                    return;
                }
            }
            c[] cVarArr = new c[0];
            c = cVarArr;
            d = new b(true, cVarArr);
            e = new b(false, c);
        }

        public b(boolean z, c[] cVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), cVarArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = cVarArr;
        }

        public b a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                c[] cVarArr = this.b;
                int length = cVarArr.length;
                c[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                return new b(this.a, cVarArr2);
            }
            return (b) invokeL.objValue;
        }

        public b b(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                c[] cVarArr = this.b;
                int length = cVarArr.length;
                if (length == 1 && cVarArr[0] == cVar) {
                    return e;
                }
                if (length == 0) {
                    return this;
                }
                int i = length - 1;
                c[] cVarArr2 = new c[i];
                int i2 = 0;
                for (c cVar2 : cVarArr) {
                    if (cVar2 != cVar) {
                        if (i2 == i) {
                            return this;
                        }
                        cVarArr2[i2] = cVar2;
                        i2++;
                    }
                }
                if (i2 == 0) {
                    return e;
                }
                if (i2 < i) {
                    c[] cVarArr3 = new c[i2];
                    System.arraycopy(cVarArr2, 0, cVarArr3, 0, i2);
                    cVarArr2 = cVarArr3;
                }
                return new b(this.a, cVarArr2);
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static final class c<T> implements l8a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final q8a<? super T> a;
        public boolean b;
        public boolean c;
        public List<Object> d;
        public boolean e;

        public c(q8a<? super T> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = true;
            this.a = q8aVar;
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null) {
                NotificationLite.a(this.a, obj);
            }
        }

        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                synchronized (this) {
                    if (this.b && !this.c) {
                        boolean z = false;
                        this.b = false;
                        if (obj != null) {
                            z = true;
                        }
                        this.c = z;
                        if (obj != null) {
                            c(null, obj);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.a.onError(th);
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                this.a.onNext(t);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(List<Object> list, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, obj) == null) {
                boolean z = true;
                boolean z2 = true;
                while (true) {
                    if (list != null) {
                        try {
                            for (Object obj2 : list) {
                                a(obj2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                            if (!z) {
                            }
                            throw th;
                        }
                    }
                    if (z2) {
                        a(obj);
                        z2 = false;
                    }
                    try {
                        synchronized (this) {
                            try {
                                list = this.d;
                                this.d = null;
                                if (list == null) {
                                    this.c = false;
                                    return;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                z = false;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        th = th4;
                        if (!z) {
                            synchronized (this) {
                                this.c = false;
                            }
                        }
                        throw th;
                    }
                }
            }
        }

        public void d(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (!this.e) {
                    synchronized (this) {
                        this.b = false;
                        if (this.c) {
                            if (this.d == null) {
                                this.d = new ArrayList();
                            }
                            this.d.add(obj);
                            return;
                        }
                        this.e = true;
                    }
                }
                NotificationLite.a(this.a, obj);
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a.onCompleted();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectSubscriptionManager() {
        super(b.e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.active = true;
        this.onStart = Actions.a();
        this.onAdded = Actions.a();
        this.onTerminated = Actions.a();
    }

    public boolean add(c<T> cVar) {
        b<T> bVar;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            do {
                bVar = get();
                if (bVar.a) {
                    this.onTerminated.call(cVar);
                    return false;
                }
            } while (!compareAndSet(bVar, bVar.a(cVar)));
            this.onAdded.call(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void call(q8a<? super T> q8aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q8aVar) == null) {
            c<T> cVar = new c<>(q8aVar);
            addUnsubscriber(q8aVar, cVar);
            this.onStart.call(cVar);
            if (!q8aVar.isUnsubscribed() && add(cVar) && q8aVar.isUnsubscribed()) {
                remove(cVar);
            }
        }
    }

    public c<T>[] next(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            setLatest(obj);
            return get().b;
        }
        return (c[]) invokeL.objValue;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            do {
                bVar = get();
                if (bVar.a || (b2 = bVar.b(cVar)) == bVar) {
                    return;
                }
            } while (!compareAndSet(bVar, b2));
        }
    }

    public void setLatest(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            this.latest = obj;
        }
    }

    public c<T>[] terminate(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            setLatest(obj);
            this.active = false;
            if (get().a) {
                return b.c;
            }
            return getAndSet(b.d).b;
        }
        return (c[]) invokeL.objValue;
    }

    public void addUnsubscriber(q8a<? super T> q8aVar, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q8aVar, cVar) == null) {
            q8aVar.b(hda.a(new a(this, cVar)));
        }
    }

    @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((q8a) ((q8a) obj));
    }

    public Object getLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.latest;
        }
        return invokeV.objValue;
    }

    public c<T>[] observers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return get().b;
        }
        return (c[]) invokeV.objValue;
    }
}
