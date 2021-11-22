package h.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes2.dex */
public class d<T> implements h.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f73044e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73045f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f73046g;

    /* renamed from: h  reason: collision with root package name */
    public a f73047h;

    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object[] f73048a;

        /* renamed from: b  reason: collision with root package name */
        public int f73049b;

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
                int i2 = this.f73049b;
                Object[] objArr = this.f73048a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.f73048a = objArr;
                } else if (i2 == objArr.length) {
                    Object[] objArr2 = new Object[(i2 >> 2) + i2];
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    this.f73048a = objArr2;
                    objArr = objArr2;
                }
                objArr[i2] = obj;
                this.f73049b = i2 + 1;
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
        this.f73044e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73046g) {
            return;
        }
        synchronized (this) {
            if (this.f73046g) {
                return;
            }
            this.f73046g = true;
            if (this.f73045f) {
                a aVar = this.f73047h;
                if (aVar == null) {
                    aVar = new a();
                    this.f73047h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f73045f = true;
            this.f73044e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            h.m.a.e(th);
            if (this.f73046g) {
                return;
            }
            synchronized (this) {
                if (this.f73046g) {
                    return;
                }
                this.f73046g = true;
                if (this.f73045f) {
                    a aVar = this.f73047h;
                    if (aVar == null) {
                        aVar = new a();
                        this.f73047h = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f73045f = true;
                this.f73044e.onError(th);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f73046g) {
            return;
        }
        synchronized (this) {
            if (this.f73046g) {
                return;
            }
            if (this.f73045f) {
                a aVar = this.f73047h;
                if (aVar == null) {
                    aVar = new a();
                    this.f73047h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f73045f = true;
            try {
                this.f73044e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f73047h;
                        if (aVar2 == null) {
                            this.f73045f = false;
                            return;
                        }
                        this.f73047h = null;
                        for (Object obj : aVar2.f73048a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f73044e, obj)) {
                                    this.f73046g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f73046g = true;
                                h.m.a.e(th);
                                this.f73044e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f73046g = true;
                h.m.a.g(th2, this.f73044e, t);
            }
        }
    }
}
