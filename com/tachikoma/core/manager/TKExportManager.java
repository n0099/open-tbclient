package com.tachikoma.core.manager;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.common.ILifeCycle;
import com.tachikoma.core.component.IFactory;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class TKExportManager implements ILifeCycle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean isInit;

    /* renamed from: com.tachikoma.core.manager.TKExportManager$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final TKExportManager instance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(646683232, "Lcom/tachikoma/core/manager/TKExportManager$InstanceHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(646683232, "Lcom/tachikoma/core/manager/TKExportManager$InstanceHolder;");
                    return;
                }
            }
            instance = new TKExportManager(null);
        }

        public InstanceHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public TKExportManager() {
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
        this.isInit = false;
    }

    public /* synthetic */ TKExportManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static TKExportManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? InstanceHolder.instance : (TKExportManager) invokeV.objValue;
    }

    private synchronized void maybeReInit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            synchronized (this) {
                if (!isCreate()) {
                    onCreate();
                }
            }
        }
    }

    public synchronized HashMap<String, String> allExportClasses() {
        InterceptResult invokeV;
        HashMap<String, String> allExportClasses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                maybeReInit();
                allExportClasses = TKProviderCollection.allExportClasses();
            }
            return allExportClasses;
        }
        return (HashMap) invokeV.objValue;
    }

    public synchronized void applyAttributes(String str, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj, hashMap) == null) {
            synchronized (this) {
                maybeReInit();
                TKProviderCollection.applyAttributes(str, obj, hashMap);
            }
        }
    }

    public synchronized void applyProperties(String str, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, obj, hashMap) == null) {
            synchronized (this) {
                maybeReInit();
                TKProviderCollection.applyProperties(str, obj, hashMap);
            }
        }
    }

    public synchronized HashMap<String, Class[]> getClassMethods(String str) {
        InterceptResult invokeL;
        HashMap<String, Class[]> classMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                maybeReInit();
                classMethods = TKProviderCollection.getClassMethods(str);
            }
            return classMethods;
        }
        return (HashMap) invokeL.objValue;
    }

    public synchronized IFactory getIFactory(String str) {
        InterceptResult invokeL;
        IFactory iFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                maybeReInit();
                iFactory = TKProviderCollection.getIFactory(str);
            }
            return iFactory;
        }
        return (IFactory) invokeL.objValue;
    }

    public synchronized String getJsFunctionName(String str) {
        InterceptResult invokeL;
        String jsFunctionName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                maybeReInit();
                jsFunctionName = TKProviderCollection.getJsFunctionName(str);
            }
            return jsFunctionName;
        }
        return (String) invokeL.objValue;
    }

    public synchronized ArrayList<String> getProperties(String str) {
        InterceptResult invokeL;
        ArrayList<String> properties;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            synchronized (this) {
                maybeReInit();
                properties = TKProviderCollection.getProperties(str);
            }
            return properties;
        }
        return (ArrayList) invokeL.objValue;
    }

    public boolean isCreate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isInit : invokeV.booleanValue;
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    public synchronized void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                TKProviderCollection.init();
                this.isInit = true;
            }
        }
    }

    @Override // com.tachikoma.core.common.ILifeCycle
    public synchronized void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                TKProviderCollection.clear();
                this.isInit = false;
            }
        }
    }

    public synchronized HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        HashMap<String, Object> retrieveEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, obj)) == null) {
            synchronized (this) {
                maybeReInit();
                retrieveEvent = TKProviderCollection.retrieveEvent(str, obj);
            }
            return retrieveEvent;
        }
        return (HashMap) invokeLL.objValue;
    }
}
