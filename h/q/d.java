package h.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes10.dex */
public class d<T> implements h.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.e<? super T> f75674e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75675f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f75676g;

    /* renamed from: h  reason: collision with root package name */
    public a f75677h;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object[] f75678a;

        /* renamed from: b  reason: collision with root package name */
        public int f75679b;

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
                int i2 = this.f75679b;
                Object[] objArr = this.f75678a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.f75678a = objArr;
                } else if (i2 == objArr.length) {
                    Object[] objArr2 = new Object[(i2 >> 2) + i2];
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    this.f75678a = objArr2;
                    objArr = objArr2;
                }
                objArr[i2] = obj;
                this.f75679b = i2 + 1;
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
        this.f75674e = eVar;
    }

    @Override // h.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f75676g) {
            return;
        }
        synchronized (this) {
            if (this.f75676g) {
                return;
            }
            this.f75676g = true;
            if (this.f75675f) {
                a aVar = this.f75677h;
                if (aVar == null) {
                    aVar = new a();
                    this.f75677h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f75675f = true;
            this.f75674e.onCompleted();
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            h.m.a.e(th);
            if (this.f75676g) {
                return;
            }
            synchronized (this) {
                if (this.f75676g) {
                    return;
                }
                this.f75676g = true;
                if (this.f75675f) {
                    a aVar = this.f75677h;
                    if (aVar == null) {
                        aVar = new a();
                        this.f75677h = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f75675f = true;
                this.f75674e.onError(th);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f75676g) {
            return;
        }
        synchronized (this) {
            if (this.f75676g) {
                return;
            }
            if (this.f75675f) {
                a aVar = this.f75677h;
                if (aVar == null) {
                    aVar = new a();
                    this.f75677h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f75675f = true;
            try {
                this.f75674e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f75677h;
                        if (aVar2 == null) {
                            this.f75675f = false;
                            return;
                        }
                        this.f75677h = null;
                        for (Object obj : aVar2.f75678a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f75674e, obj)) {
                                    this.f75676g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f75676g = true;
                                h.m.a.e(th);
                                this.f75674e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f75676g = true;
                h.m.a.g(th2, this.f75674e, t);
            }
        }
    }
}
