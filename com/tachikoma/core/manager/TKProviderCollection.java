package com.tachikoma.core.manager;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.AttributeProvider;
import com.tachikoma.core.ExportClassProvider;
import com.tachikoma.core.FactoryProvider;
import com.tachikoma.core.MethodProvider;
import com.tachikoma.core.PropertyProvider;
import com.tachikoma.core.component.IFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes7.dex */
public class TKProviderCollection {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<IProvider> attributeProviderList;
    public static ArrayList<IProvider> exportClassList;
    public static ArrayList<IProvider> factoryProviderList;
    public static ArrayList<IProvider> methodList;
    public static ArrayList<IProvider> propertyProviderList;
    public static final Set<String> sEXTRA_PKG;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-681001475, "Lcom/tachikoma/core/manager/TKProviderCollection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-681001475, "Lcom/tachikoma/core/manager/TKProviderCollection;");
                return;
            }
        }
        factoryProviderList = new ArrayList<>();
        exportClassList = new ArrayList<>();
        methodList = new ArrayList<>();
        propertyProviderList = new ArrayList<>();
        attributeProviderList = new ArrayList<>();
        sEXTRA_PKG = new HashSet();
    }

    public TKProviderCollection() {
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

    public static HashMap<String, String> allExportClasses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator<IProvider> it = exportClassList.iterator();
            while (it.hasNext()) {
                hashMap.putAll(it.next().get());
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static void applyAttributes(String str, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, obj, hashMap) == null) {
            Iterator<IProvider> it = attributeProviderList.iterator();
            while (it.hasNext()) {
                it.next().apply(str, obj, hashMap);
            }
        }
    }

    public static void applyProperties(String str, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, obj, hashMap) == null) {
            Iterator<IProvider> it = propertyProviderList.iterator();
            while (it.hasNext()) {
                it.next().apply(str, obj, hashMap);
            }
        }
    }

    public static void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            Iterator<IProvider> it = factoryProviderList.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            factoryProviderList.clear();
            Iterator<IProvider> it2 = exportClassList.iterator();
            while (it2.hasNext()) {
                it2.next().clear();
            }
            exportClassList.clear();
            Iterator<IProvider> it3 = methodList.iterator();
            while (it3.hasNext()) {
                it3.next().clear();
            }
            methodList.clear();
            Iterator<IProvider> it4 = propertyProviderList.iterator();
            while (it4.hasNext()) {
                it4.next().clear();
            }
            propertyProviderList.clear();
            Iterator<IProvider> it5 = attributeProviderList.iterator();
            while (it5.hasNext()) {
                it5.next().clear();
            }
            attributeProviderList.clear();
        }
    }

    public static IProvider createProvider(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            try {
                return (IProvider) TKProviderCollection.class.getClassLoader().loadClass(str).newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        return (IProvider) invokeL.objValue;
    }

    public static HashMap<String, Class[]> getClassMethods(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Iterator<IProvider> it = methodList.iterator();
            while (it.hasNext()) {
                IProvider next = it.next();
                if (next.of(str) != null) {
                    return (HashMap) next.of(str);
                }
            }
            return null;
        }
        return (HashMap) invokeL.objValue;
    }

    public static IFactory getIFactory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            Iterator<IProvider> it = factoryProviderList.iterator();
            while (it.hasNext()) {
                IProvider next = it.next();
                if (next.of(str) != null) {
                    return (IFactory) next.of(str);
                }
            }
            return null;
        }
        return (IFactory) invokeL.objValue;
    }

    public static String getJsFunctionName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            Iterator<IProvider> it = methodList.iterator();
            while (it.hasNext()) {
                IProvider next = it.next();
                if (next.get() != null && next.get().get(str) != null) {
                    return next.get().get(str);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static ArrayList<String> getProperties(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            Iterator<IProvider> it = propertyProviderList.iterator();
            while (it.hasNext()) {
                IProvider next = it.next();
                if (next.of(str) != null) {
                    return (ArrayList) next.of(str);
                }
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            register();
            Iterator<IProvider> it = factoryProviderList.iterator();
            while (it.hasNext()) {
                it.next().init();
            }
            Iterator<IProvider> it2 = exportClassList.iterator();
            while (it2.hasNext()) {
                it2.next().init();
            }
            Iterator<IProvider> it3 = methodList.iterator();
            while (it3.hasNext()) {
                it3.next().init();
            }
            Iterator<IProvider> it4 = propertyProviderList.iterator();
            while (it4.hasNext()) {
                it4.next().init();
            }
            Iterator<IProvider> it5 = attributeProviderList.iterator();
            while (it5.hasNext()) {
                it5.next().init();
            }
        }
    }

    public static boolean isEmpty(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, objArr)) == null) ? objArr == null || objArr.length == 0 : invokeL.booleanValue;
    }

    public static void register() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            registerExportClass(new ExportClassProvider());
            registerFactory(new FactoryProvider());
            registerMethod(new MethodProvider());
            registerProperty(new PropertyProvider());
            registerAttribute(new AttributeProvider());
            safelyRegisterExtras();
        }
    }

    public static void registerAttribute(IProvider iProvider) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65550, null, iProvider) == null) || attributeProviderList.contains(iProvider)) {
            return;
        }
        attributeProviderList.add(iProvider);
    }

    public static void registerExportClass(IProvider iProvider) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, iProvider) == null) || exportClassList.contains(iProvider)) {
            return;
        }
        exportClassList.add(iProvider);
    }

    public static void registerExtraLib(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, strArr) == null) {
            synchronized (sEXTRA_PKG) {
                if (isEmpty(strArr)) {
                    return;
                }
                sEXTRA_PKG.addAll(Arrays.asList(strArr));
            }
        }
    }

    public static void registerFactory(IProvider iProvider) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, iProvider) == null) || factoryProviderList.contains(iProvider)) {
            return;
        }
        factoryProviderList.add(iProvider);
    }

    public static void registerMethod(IProvider iProvider) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, iProvider) == null) || methodList.contains(iProvider)) {
            return;
        }
        methodList.add(iProvider);
    }

    public static void registerProperty(IProvider iProvider) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, iProvider) == null) || propertyProviderList.contains(iProvider)) {
            return;
        }
        propertyProviderList.add(iProvider);
    }

    public static HashMap<String, Object> retrieveEvent(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, obj)) == null) {
            Iterator<IProvider> it = propertyProviderList.iterator();
            while (it.hasNext()) {
                IProvider next = it.next();
                HashMap<String, Object> retrieveEvent = next.retrieveEvent(str, obj);
                if (retrieveEvent != null && retrieveEvent.size() > 0) {
                    return next.retrieveEvent(str, obj);
                }
            }
            return null;
        }
        return (HashMap) invokeLL.objValue;
    }

    public static void safelyRegister(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            try {
                IProvider createProvider = createProvider(str + ".ExportClassProvider");
                if (createProvider != null) {
                    registerExportClass(createProvider);
                }
                IProvider createProvider2 = createProvider(str + ".FactoryProvider");
                if (createProvider2 != null) {
                    registerFactory(createProvider2);
                }
                IProvider createProvider3 = createProvider(str + ".MethodProvider");
                if (createProvider3 != null) {
                    registerMethod(createProvider3);
                }
                IProvider createProvider4 = createProvider(str + ".PropertyProvider");
                if (createProvider4 != null) {
                    registerProperty(createProvider4);
                }
                IProvider createProvider5 = createProvider(str + ".AttributeProvider");
                if (createProvider5 != null) {
                    registerAttribute(createProvider5);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void safelyRegisterExtras() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            registerExtraLib("com.tachikoma.plugin", "com.tachikoma.kwai.tach");
            synchronized (sEXTRA_PKG) {
                for (String str : sEXTRA_PKG) {
                    safelyRegister(str);
                }
            }
        }
    }

    public static void unregisterExtraLib(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, strArr) == null) {
            synchronized (sEXTRA_PKG) {
                if (isEmpty(strArr)) {
                    return;
                }
                for (String str : strArr) {
                    sEXTRA_PKG.remove(str);
                }
            }
        }
    }
}
