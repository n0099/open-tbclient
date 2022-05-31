package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.request.RequestStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class b02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<xz1> a;
    public final List<xz1> b;
    public final List<xz1> c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-552074576, "Lcom/repackage/b02$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-552074576, "Lcom/repackage/b02$a;");
                    return;
                }
            }
            int[] iArr = new int[RequestStatus.values().length];
            a = iArr;
            try {
                iArr[RequestStatus.STATUS_SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RequestStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RequestStatus.STATUS_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b02() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public synchronized void a(xz1 xz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz1Var) == null) {
            synchronized (this) {
                if (xz1Var == null) {
                    return;
                }
                int i = a.a[xz1Var.e.ordinal()];
                if (i == 1) {
                    this.a.add(xz1Var);
                } else if (i == 2) {
                    this.b.add(xz1Var);
                    c(this.a, xz1Var);
                } else if (i == 3) {
                    this.c.add(xz1Var);
                    c(this.a, xz1Var);
                }
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.c.clear();
                this.a.clear();
                this.b.clear();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
        r5.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(List<xz1> list, xz1 xz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, xz1Var) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty() && xz1Var != null) {
                        Iterator<xz1> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (xz1Var.equals(it.next())) {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized List<xz1> d() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (xz1 xz1Var : this.c) {
                    if (xz1Var != null && xz1Var.g(true)) {
                        arrayList.add(xz1Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int e() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                size = this.c.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized List<xz1> f() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (xz1 xz1Var : this.c) {
                    if (xz1Var != null && xz1Var.f()) {
                        arrayList.add(xz1Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<xz1> g() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (xz1 xz1Var : this.b) {
                    if (xz1Var != null && xz1Var.h()) {
                        arrayList.add(xz1Var);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int h() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                size = this.b.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized int i() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                size = this.a.size() + h() + e();
            }
            return size;
        }
        return invokeV.intValue;
    }
}
