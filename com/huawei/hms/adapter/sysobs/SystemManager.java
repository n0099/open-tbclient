package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes10.dex */
public final class SystemManager {
    public static /* synthetic */ Interceptable $ic;
    public static SystemManager a;
    public static final Object b;
    public static SystemNotifier c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a implements SystemNotifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<SystemObserver> a;

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
                    return;
                }
            }
            this.a = new ArrayList();
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                synchronized (SystemManager.b) {
                    Iterator<SystemObserver> it = this.a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onNoticeResult(i)) {
                            it.remove();
                        }
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                synchronized (SystemManager.b) {
                    Iterator<SystemObserver> it = this.a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onUpdateResult(i)) {
                            it.remove();
                        }
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, intent, str) == null) {
                synchronized (SystemManager.b) {
                    Iterator<SystemObserver> it = this.a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onSolutionResult(intent, str)) {
                            it.remove();
                        }
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, systemObserver) == null) && systemObserver != null && !this.a.contains(systemObserver)) {
                synchronized (SystemManager.b) {
                    this.a.add(systemObserver);
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, systemObserver) == null) {
                synchronized (SystemManager.b) {
                    this.a.remove(systemObserver);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(156831754, "Lcom/huawei/hms/adapter/sysobs/SystemManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(156831754, "Lcom/huawei/hms/adapter/sysobs/SystemManager;");
                return;
            }
        }
        a = new SystemManager();
        b = new Object();
        c = new a();
    }

    public SystemManager() {
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

    public static SystemManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a;
        }
        return (SystemManager) invokeV.objValue;
    }

    public static SystemNotifier getSystemNotifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c;
        }
        return (SystemNotifier) invokeV.objValue;
    }

    public void notifyNoticeResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            c.notifyNoticeObservers(i);
        }
    }

    public void notifyUpdateResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            c.notifyObservers(i);
        }
    }

    public void notifyResolutionResult(Intent intent, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent, str) == null) {
            c.notifyObservers(intent, str);
        }
    }
}
