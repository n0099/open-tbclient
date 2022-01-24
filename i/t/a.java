package i.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes4.dex */
public final class a<T> extends d<T, T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f62141g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SubjectSubscriptionManager<T> f62142f;

    /* renamed from: i.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2303a implements i.n.b<SubjectSubscriptionManager.c<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SubjectSubscriptionManager f62143e;

        public C2303a(SubjectSubscriptionManager subjectSubscriptionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subjectSubscriptionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62143e = subjectSubscriptionManager;
        }

        @Override // i.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.c) ((SubjectSubscriptionManager.c) obj));
        }

        public void call(SubjectSubscriptionManager.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                cVar.b(this.f62143e.getLatest());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1783773351, "Li/t/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1783773351, "Li/t/a;");
                return;
            }
        }
        f62141g = new Object[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, subjectSubscriptionManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62142f = subjectSubscriptionManager;
    }

    public static <T> a<T> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? G(null, false) : (a) invokeV.objValue;
    }

    public static <T> a<T> G(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, t, z)) == null) {
            SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
            if (z) {
                subjectSubscriptionManager.setLatest(NotificationLite.h(t));
            }
            C2303a c2303a = new C2303a(subjectSubscriptionManager);
            subjectSubscriptionManager.onAdded = c2303a;
            subjectSubscriptionManager.onTerminated = c2303a;
            return new a<>(subjectSubscriptionManager, subjectSubscriptionManager);
        }
        return (a) invokeLZ.objValue;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f62142f.getLatest() == null || this.f62142f.active) {
                Object b2 = NotificationLite.b();
                for (SubjectSubscriptionManager.c<T> cVar : this.f62142f.terminate(b2)) {
                    cVar.d(b2);
                }
            }
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            if (this.f62142f.getLatest() == null || this.f62142f.active) {
                Object c2 = NotificationLite.c(th);
                ArrayList arrayList = null;
                for (SubjectSubscriptionManager.c<T> cVar : this.f62142f.terminate(c2)) {
                    try {
                        cVar.d(c2);
                    } catch (Throwable th2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
                i.m.a.d(arrayList);
            }
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            if (this.f62142f.getLatest() == null || this.f62142f.active) {
                Object h2 = NotificationLite.h(t);
                for (SubjectSubscriptionManager.c<T> cVar : this.f62142f.next(h2)) {
                    cVar.d(h2);
                }
            }
        }
    }
}
