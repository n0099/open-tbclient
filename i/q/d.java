package i.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes10.dex */
public class d<T> implements i.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.e<? super T> f78657e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f78658f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f78659g;

    /* renamed from: h  reason: collision with root package name */
    public a f78660h;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object[] f78661a;

        /* renamed from: b  reason: collision with root package name */
        public int f78662b;

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
                int i2 = this.f78662b;
                Object[] objArr = this.f78661a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.f78661a = objArr;
                } else if (i2 == objArr.length) {
                    Object[] objArr2 = new Object[(i2 >> 2) + i2];
                    System.arraycopy(objArr, 0, objArr2, 0, i2);
                    this.f78661a = objArr2;
                    objArr = objArr2;
                }
                objArr[i2] = obj;
                this.f78662b = i2 + 1;
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
        this.f78657e = eVar;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f78659g) {
            return;
        }
        synchronized (this) {
            if (this.f78659g) {
                return;
            }
            this.f78659g = true;
            if (this.f78658f) {
                a aVar = this.f78660h;
                if (aVar == null) {
                    aVar = new a();
                    this.f78660h = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f78658f = true;
            this.f78657e.onCompleted();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            i.m.a.e(th);
            if (this.f78659g) {
                return;
            }
            synchronized (this) {
                if (this.f78659g) {
                    return;
                }
                this.f78659g = true;
                if (this.f78658f) {
                    a aVar = this.f78660h;
                    if (aVar == null) {
                        aVar = new a();
                        this.f78660h = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f78658f = true;
                this.f78657e.onError(th);
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f78659g) {
            return;
        }
        synchronized (this) {
            if (this.f78659g) {
                return;
            }
            if (this.f78658f) {
                a aVar = this.f78660h;
                if (aVar == null) {
                    aVar = new a();
                    this.f78660h = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f78658f = true;
            try {
                this.f78657e.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f78660h;
                        if (aVar2 == null) {
                            this.f78658f = false;
                            return;
                        }
                        this.f78660h = null;
                        for (Object obj : aVar2.f78661a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.f78657e, obj)) {
                                    this.f78659g = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f78659g = true;
                                i.m.a.e(th);
                                this.f78657e.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f78659g = true;
                i.m.a.g(th2, this.f78657e, t);
            }
        }
    }
}
