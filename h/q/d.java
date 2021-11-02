package h.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes3.dex */
public class d<T> implements h.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f72126e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72127f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f72128g;

    /* renamed from: h  reason: collision with root package name */
    public a f72129h;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object[] f72130a;

        /* renamed from: b  reason: collision with root package name */
        public int f72131b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                int i2 = this.f72131b;
                Object[] objArr = this.f72130a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.f72130a = objArr;
                } else if (i2 == objArr.length) {
                    Object[] objArr2 = new Object[(i2 >> 2) + i2];
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    this.f72130a = objArr2;
                    objArr = objArr2;
                }
                objArr[i2] = obj;
                this.f72131b = i2 + 1;
            }
        }
    }

    public d(h.e<? super T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72126e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72128g) {
            return;
        }
        synchronized (this) {
            if (this.f72128g) {
                return;
            }
            this.f72128g = true;
            if (this.f72127f) {
                a aVar = this.f72129h;
                if (aVar == null) {
                    aVar = new a();
                    this.f72129h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f72127f = true;
            this.f72126e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            h.m.a.e(th);
            if (this.f72128g) {
                return;
            }
            synchronized (this) {
                if (this.f72128g) {
                    return;
                }
                this.f72128g = true;
                if (this.f72127f) {
                    a aVar = this.f72129h;
                    if (aVar == null) {
                        aVar = new a();
                        this.f72129h = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f72127f = true;
                this.f72126e.onError(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0031, code lost:
        continue;
     */
    @Override // h.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f72128g) {
            return;
        }
        synchronized (this) {
            if (this.f72128g) {
                return;
            }
            if (this.f72127f) {
                a aVar = this.f72129h;
                if (aVar == null) {
                    aVar = new a();
                    this.f72129h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f72127f = true;
            try {
                this.f72126e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f72129h;
                        if (aVar2 == null) {
                            this.f72127f = false;
                            return;
                        }
                        this.f72129h = null;
                        for (Object obj : aVar2.f72130a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f72126e, obj)) {
                                    this.f72128g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f72128g = true;
                                h.m.a.e(th);
                                this.f72126e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f72128g = true;
                h.m.a.g(th2, this.f72126e, t);
            }
        }
    }
}
