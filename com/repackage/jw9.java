package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import java.util.ArrayList;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes6.dex */
public final class jw9<T> extends mw9<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object[] c;
    public transient /* synthetic */ FieldHolder $fh;
    public final SubjectSubscriptionManager<T> b;

    /* loaded from: classes6.dex */
    public static class a implements is9<SubjectSubscriptionManager.c<T>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SubjectSubscriptionManager a;

        public a(SubjectSubscriptionManager subjectSubscriptionManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {subjectSubscriptionManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = subjectSubscriptionManager;
        }

        @Override // com.repackage.is9
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.c) ((SubjectSubscriptionManager.c) obj));
        }

        public void call(SubjectSubscriptionManager.c<T> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                cVar.b(this.a.getLatest());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755574107, "Lcom/repackage/jw9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755574107, "Lcom/repackage/jw9;");
                return;
            }
        }
        c = new Object[0];
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jw9(ur9.a<T> aVar, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, subjectSubscriptionManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ur9.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = subjectSubscriptionManager;
    }

    public static <T> jw9<T> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? E(null, false) : (jw9) invokeV.objValue;
    }

    public static <T> jw9<T> E(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, t, z)) == null) {
            SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
            if (z) {
                subjectSubscriptionManager.setLatest(NotificationLite.h(t));
            }
            a aVar = new a(subjectSubscriptionManager);
            subjectSubscriptionManager.onAdded = aVar;
            subjectSubscriptionManager.onTerminated = aVar;
            return new jw9<>(subjectSubscriptionManager, subjectSubscriptionManager);
        }
        return (jw9) invokeLZ.objValue;
    }

    @Override // com.repackage.vr9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object b = NotificationLite.b();
                for (SubjectSubscriptionManager.c<T> cVar : this.b.terminate(b)) {
                    cVar.d(b);
                }
            }
        }
    }

    @Override // com.repackage.vr9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object c2 = NotificationLite.c(th);
                ArrayList arrayList = null;
                for (SubjectSubscriptionManager.c<T> cVar : this.b.terminate(c2)) {
                    try {
                        cVar.d(c2);
                    } catch (Throwable th2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
                gs9.d(arrayList);
            }
        }
    }

    @Override // com.repackage.vr9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            if (this.b.getLatest() == null || this.b.active) {
                Object h = NotificationLite.h(t);
                for (SubjectSubscriptionManager.c<T> cVar : this.b.next(h)) {
                    cVar.d(h);
                }
            }
        }
    }
}
