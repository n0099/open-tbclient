package i.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes8.dex */
public class d<T> implements i.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.e<? super T> f60634e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60635f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f60636g;

    /* renamed from: h  reason: collision with root package name */
    public a f60637h;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f60638b;

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
                int i2 = this.f60638b;
                Object[] objArr = this.a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.a = objArr;
                } else if (i2 == objArr.length) {
                    Object[] objArr2 = new Object[(i2 >> 2) + i2];
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    this.a = objArr2;
                    objArr = objArr2;
                }
                objArr[i2] = obj;
                this.f60638b = i2 + 1;
            }
        }
    }

    public d(i.e<? super T> eVar) {
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
        this.f60634e = eVar;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60636g) {
            return;
        }
        synchronized (this) {
            if (this.f60636g) {
                return;
            }
            this.f60636g = true;
            if (this.f60635f) {
                a aVar = this.f60637h;
                if (aVar == null) {
                    aVar = new a();
                    this.f60637h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f60635f = true;
            this.f60634e.onCompleted();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            i.m.a.e(th);
            if (this.f60636g) {
                return;
            }
            synchronized (this) {
                if (this.f60636g) {
                    return;
                }
                this.f60636g = true;
                if (this.f60635f) {
                    a aVar = this.f60637h;
                    if (aVar == null) {
                        aVar = new a();
                        this.f60637h = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f60635f = true;
                this.f60634e.onError(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0031, code lost:
        continue;
     */
    @Override // i.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f60636g) {
            return;
        }
        synchronized (this) {
            if (this.f60636g) {
                return;
            }
            if (this.f60635f) {
                a aVar = this.f60637h;
                if (aVar == null) {
                    aVar = new a();
                    this.f60637h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f60635f = true;
            try {
                this.f60634e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f60637h;
                        if (aVar2 == null) {
                            this.f60635f = false;
                            return;
                        }
                        this.f60637h = null;
                        for (Object obj : aVar2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f60634e, obj)) {
                                    this.f60636g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f60636g = true;
                                i.m.a.e(th);
                                this.f60634e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f60636g = true;
                i.m.a.g(th2, this.f60634e, t);
            }
        }
    }
}
