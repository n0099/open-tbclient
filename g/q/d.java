package g.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import rx.exceptions.OnErrorThrowable;
import rx.internal.operators.NotificationLite;
/* loaded from: classes7.dex */
public class d<T> implements g.e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.e<? super T> a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45045b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f45046c;

    /* renamed from: d  reason: collision with root package name */
    public a f45047d;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f45048b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                int i = this.f45048b;
                Object[] objArr = this.a;
                if (objArr == null) {
                    objArr = new Object[16];
                    this.a = objArr;
                } else if (i == objArr.length) {
                    Object[] objArr2 = new Object[(i >> 2) + i];
                    System.arraycopy(objArr, 0, objArr2, 0, i);
                    this.a = objArr2;
                    objArr = objArr2;
                }
                objArr[i] = obj;
                this.f45048b = i + 1;
            }
        }
    }

    public d(g.e<? super T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eVar;
    }

    @Override // g.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45046c) {
            return;
        }
        synchronized (this) {
            if (this.f45046c) {
                return;
            }
            this.f45046c = true;
            if (this.f45045b) {
                a aVar = this.f45047d;
                if (aVar == null) {
                    aVar = new a();
                    this.f45047d = aVar;
                }
                aVar.a(NotificationLite.b());
                return;
            }
            this.f45045b = true;
            this.a.onCompleted();
        }
    }

    @Override // g.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            g.m.a.e(th);
            if (this.f45046c) {
                return;
            }
            synchronized (this) {
                if (this.f45046c) {
                    return;
                }
                this.f45046c = true;
                if (this.f45045b) {
                    a aVar = this.f45047d;
                    if (aVar == null) {
                        aVar = new a();
                        this.f45047d = aVar;
                    }
                    aVar.a(NotificationLite.c(th));
                    return;
                }
                this.f45045b = true;
                this.a.onError(th);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0031, code lost:
        continue;
     */
    @Override // g.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.f45046c) {
            return;
        }
        synchronized (this) {
            if (this.f45046c) {
                return;
            }
            if (this.f45045b) {
                a aVar = this.f45047d;
                if (aVar == null) {
                    aVar = new a();
                    this.f45047d = aVar;
                }
                aVar.a(NotificationLite.h(t));
                return;
            }
            this.f45045b = true;
            try {
                this.a.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f45047d;
                        if (aVar2 == null) {
                            this.f45045b = false;
                            return;
                        }
                        this.f45047d = null;
                        for (Object obj : aVar2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (NotificationLite.a(this.a, obj)) {
                                    this.f45046c = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f45046c = true;
                                g.m.a.e(th);
                                this.a.onError(OnErrorThrowable.addValueAsLastCause(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f45046c = true;
                g.m.a.g(th2, this.a, t);
            }
        }
    }
}
