package h.o.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public final class h implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<k> f75636e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f75637f;

    public h() {
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

    public static void c(Collection<k> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, collection) == null) || collection == null) {
            return;
        }
        ArrayList arrayList = null;
        for (k kVar : collection) {
            try {
                kVar.unsubscribe();
            } catch (Throwable th) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th);
            }
        }
        h.m.a.d(arrayList);
    }

    public void a(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, kVar) == null) || kVar.isUnsubscribed()) {
            return;
        }
        if (!this.f75637f) {
            synchronized (this) {
                if (!this.f75637f) {
                    List list = this.f75636e;
                    if (list == null) {
                        list = new LinkedList();
                        this.f75636e = list;
                    }
                    list.add(kVar);
                    return;
                }
            }
        }
        kVar.unsubscribe();
    }

    public void b(k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kVar) == null) || this.f75637f) {
            return;
        }
        synchronized (this) {
            List<k> list = this.f75636e;
            if (!this.f75637f && list != null) {
                boolean remove = list.remove(kVar);
                if (remove) {
                    kVar.unsubscribe();
                }
            }
        }
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f75637f : invokeV.booleanValue;
    }

    @Override // h.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f75637f) {
            return;
        }
        synchronized (this) {
            if (this.f75637f) {
                return;
            }
            this.f75637f = true;
            List<k> list = this.f75636e;
            this.f75636e = null;
            c(list);
        }
    }

    public h(k... kVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVarArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f75636e = new LinkedList(Arrays.asList(kVarArr));
    }

    public h(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        LinkedList linkedList = new LinkedList();
        this.f75636e = linkedList;
        linkedList.add(kVar);
    }
}
