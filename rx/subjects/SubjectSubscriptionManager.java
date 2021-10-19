package rx.subjects;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.e;
import i.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public final class SubjectSubscriptionManager<T> extends AtomicReference<b<T>> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 6035251036011671568L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean active;
    public volatile Object latest;
    public i.n.b<c<T>> onAdded;
    public i.n.b<c<T>> onStart;
    public i.n.b<c<T>> onTerminated;

    /* loaded from: classes2.dex */
    public class a implements i.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f79881e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f79882f;

        public a(SubjectSubscriptionManager subjectSubscriptionManager, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subjectSubscriptionManager, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79882f = subjectSubscriptionManager;
            this.f79881e = cVar;
        }

        @Override // i.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f79882f.remove(this.f79881e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static final c[] f79883c;

        /* renamed from: d  reason: collision with root package name */
        public static final b f79884d;

        /* renamed from: e  reason: collision with root package name */
        public static final b f79885e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f79886a;

        /* renamed from: b  reason: collision with root package name */
        public final c[] f79887b;

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
            f79883c = cVarArr;
            f79884d = new b(true, cVarArr);
            f79885e = new b(false, f79883c);
        }

        public b(boolean z, c[] cVarArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), cVarArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f79886a = z;
            this.f79887b = cVarArr;
        }

        public b a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                c[] cVarArr = this.f79887b;
                int length = cVarArr.length;
                c[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                return new b(this.f79886a, cVarArr2);
            }
            return (b) invokeL.objValue;
        }

        public b b(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
                c[] cVarArr = this.f79887b;
                int length = cVarArr.length;
                if (length == 1 && cVarArr[0] == cVar) {
                    return f79885e;
                }
                if (length == 0) {
                    return this;
                }
                int i2 = length - 1;
                c[] cVarArr2 = new c[i2];
                int i3 = 0;
                for (c cVar2 : cVarArr) {
                    if (cVar2 != cVar) {
                        if (i3 == i2) {
                            return this;
                        }
                        cVarArr2[i3] = cVar2;
                        i3++;
                    }
                }
                if (i3 == 0) {
                    return f79885e;
                }
                if (i3 < i2) {
                    c[] cVarArr3 = new c[i3];
                    System.arraycopy(cVarArr2, 0, cVarArr3, 0, i3);
                    cVarArr2 = cVarArr3;
                }
                return new b(this.f79886a, cVarArr2);
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<T> implements e<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final j<? super T> f79888e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f79889f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f79890g;

        /* renamed from: h  reason: collision with root package name */
        public List<Object> f79891h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f79892i;

        public c(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79889f = true;
            this.f79888e = jVar;
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null) {
                return;
            }
            NotificationLite.a(this.f79888e, obj);
        }

        public void b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                synchronized (this) {
                    if (this.f79889f && !this.f79890g) {
                        this.f79889f = false;
                        this.f79890g = obj != null;
                        if (obj != null) {
                            c(null, obj);
                        }
                    }
                }
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
                                list = this.f79891h;
                                this.f79891h = null;
                                if (list == null) {
                                    this.f79890g = false;
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
                                this.f79890g = false;
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
                if (!this.f79892i) {
                    synchronized (this) {
                        this.f79889f = false;
                        if (this.f79890g) {
                            if (this.f79891h == null) {
                                this.f79891h = new ArrayList();
                            }
                            this.f79891h.add(obj);
                            return;
                        }
                        this.f79892i = true;
                    }
                }
                NotificationLite.a(this.f79888e, obj);
            }
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f79888e.onCompleted();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, th) == null) {
                this.f79888e.onError(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
                this.f79888e.onNext(t);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectSubscriptionManager() {
        super(b.f79885e);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                if (bVar.f79886a) {
                    this.onTerminated.call(cVar);
                    return false;
                }
            } while (!compareAndSet(bVar, bVar.a(cVar)));
            this.onAdded.call(cVar);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addUnsubscriber(j<? super T> jVar, c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar, cVar) == null) {
            jVar.add(i.u.e.a(new a(this, cVar)));
        }
    }

    @Override // i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public Object getLatest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.latest : invokeV.objValue;
    }

    public c<T>[] next(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            setLatest(obj);
            return get().f79887b;
        }
        return (c[]) invokeL.objValue;
    }

    public c<T>[] observers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? get().f79887b : (c[]) invokeV.objValue;
    }

    public void remove(c<T> cVar) {
        b<T> bVar;
        b<T> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            do {
                bVar = get();
                if (bVar.f79886a || (b2 = bVar.b(cVar)) == bVar) {
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
            if (get().f79886a) {
                return b.f79883c;
            }
            return getAndSet(b.f79884d).f79887b;
        }
        return (c[]) invokeL.objValue;
    }

    public void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) {
            c<T> cVar = new c<>(jVar);
            addUnsubscriber(jVar, cVar);
            this.onStart.call(cVar);
            if (!jVar.isUnsubscribed() && add(cVar) && jVar.isUnsubscribed()) {
                remove(cVar);
            }
        }
    }
}
