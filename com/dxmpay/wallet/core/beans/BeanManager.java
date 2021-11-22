package com.dxmpay.wallet.core.beans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.ApollonBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes11.dex */
public final class BeanManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<ApollonBean<?>>> f63469a;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static BeanManager f63470a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(248945420, "Lcom/dxmpay/wallet/core/beans/BeanManager$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(248945420, "Lcom/dxmpay/wallet/core/beans/BeanManager$b;");
                    return;
                }
            }
            f63470a = new BeanManager(null);
        }
    }

    public /* synthetic */ BeanManager(a aVar) {
        this();
    }

    public static BeanManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f63470a : (BeanManager) invokeV.objValue;
    }

    public synchronized void addBean(String str, ApollonBean<?> apollonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, apollonBean) == null) {
            synchronized (this) {
                ArrayList<ApollonBean<?>> arrayList = this.f63469a.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f63469a.put(str, arrayList);
                }
                arrayList.add(apollonBean);
            }
        }
    }

    public synchronized void removeAllBeans(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                ArrayList<ApollonBean<?>> arrayList = this.f63469a.get(str);
                if (arrayList != null) {
                    Iterator<ApollonBean<?>> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().destroyBean();
                    }
                    this.f63469a.remove(str);
                }
            }
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, baseBean) == null) {
            synchronized (this) {
                for (String str : this.f63469a.keySet()) {
                    ArrayList<ApollonBean<?>> arrayList = this.f63469a.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<ApollonBean<?>> it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (baseBean == it.next()) {
                                    arrayList.remove(baseBean);
                                    baseBean.destroyBean();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public BeanManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63469a = new HashMap<>();
    }
}
