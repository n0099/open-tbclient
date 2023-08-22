package com.huawei.hms.common.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.ListIterator;
/* loaded from: classes10.dex */
public class BindResolveClients {
    public static /* synthetic */ Interceptable $ic;
    public static final Object LOCK_INST;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ResolveClientBean> mClientList;

    /* renamed from: com.huawei.hms.common.internal.BindResolveClients$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class SingletonManager {
        public static /* synthetic */ Interceptable $ic;
        public static final BindResolveClients INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1285960875, "Lcom/huawei/hms/common/internal/BindResolveClients$SingletonManager;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1285960875, "Lcom/huawei/hms/common/internal/BindResolveClients$SingletonManager;");
                    return;
                }
            }
            INSTANCE = new BindResolveClients(null);
        }

        public SingletonManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-846759835, "Lcom/huawei/hms/common/internal/BindResolveClients;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-846759835, "Lcom/huawei/hms/common/internal/BindResolveClients;");
                return;
            }
        }
        LOCK_INST = new Object();
    }

    public BindResolveClients() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClientList = new ArrayList<>();
    }

    public static BindResolveClients getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return SingletonManager.INSTANCE;
        }
        return (BindResolveClients) invokeV.objValue;
    }

    public void notifyClientReconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (LOCK_INST) {
                ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
                while (listIterator.hasNext()) {
                    listIterator.next().clientReconnect();
                }
                this.mClientList.clear();
            }
        }
    }

    public void unRegisterAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (LOCK_INST) {
                this.mClientList.clear();
            }
        }
    }

    public /* synthetic */ BindResolveClients(AnonymousClass1 anonymousClass1) {
        this();
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resolveClientBean)) == null) {
            synchronized (LOCK_INST) {
                contains = this.mClientList.contains(resolveClientBean);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public void register(ResolveClientBean resolveClientBean) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resolveClientBean) != null) || resolveClientBean == null) {
            return;
        }
        synchronized (LOCK_INST) {
            if (!this.mClientList.contains(resolveClientBean)) {
                this.mClientList.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, resolveClientBean) != null) || resolveClientBean == null) {
            return;
        }
        synchronized (LOCK_INST) {
            if (this.mClientList.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.mClientList.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }
}
