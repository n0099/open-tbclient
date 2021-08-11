package org.apache.commons.lang3.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class MultiBackgroundInitializer extends BackgroundInitializer<MultiBackgroundInitializerResults> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, BackgroundInitializer<?>> childInitializers;

    /* renamed from: org.apache.commons.lang3.concurrent.MultiBackgroundInitializer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class MultiBackgroundInitializerResults {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, ConcurrentException> exceptions;
        public final Map<String, BackgroundInitializer<?>> initializers;
        public final Map<String, Object> resultObjects;

        public /* synthetic */ MultiBackgroundInitializerResults(Map map, Map map2, Map map3, AnonymousClass1 anonymousClass1) {
            this(map, map2, map3);
        }

        private BackgroundInitializer<?> checkName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
                BackgroundInitializer<?> backgroundInitializer = this.initializers.get(str);
                if (backgroundInitializer != null) {
                    return backgroundInitializer;
                }
                throw new NoSuchElementException("No child initializer with name " + str);
            }
            return (BackgroundInitializer) invokeL.objValue;
        }

        public ConcurrentException getException(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                checkName(str);
                return this.exceptions.get(str);
            }
            return (ConcurrentException) invokeL.objValue;
        }

        public BackgroundInitializer<?> getInitializer(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? checkName(str) : (BackgroundInitializer) invokeL.objValue;
        }

        public Object getResultObject(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                checkName(str);
                return this.resultObjects.get(str);
            }
            return invokeL.objValue;
        }

        public Set<String> initializerNames() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Collections.unmodifiableSet(this.initializers.keySet()) : (Set) invokeV.objValue;
        }

        public boolean isException(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                checkName(str);
                return this.exceptions.containsKey(str);
            }
            return invokeL.booleanValue;
        }

        public boolean isSuccessful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.exceptions.isEmpty() : invokeV.booleanValue;
        }

        public MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> map, Map<String, Object> map2, Map<String, ConcurrentException> map3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, map2, map3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.initializers = map;
            this.resultObjects = map2;
            this.exceptions = map3;
        }
    }

    public MultiBackgroundInitializer() {
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
        this.childInitializers = new HashMap();
    }

    public void addInitializer(String str, BackgroundInitializer<?> backgroundInitializer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, backgroundInitializer) == null) {
            if (str == null) {
                throw new IllegalArgumentException("Name of child initializer must not be null!");
            }
            if (backgroundInitializer != null) {
                synchronized (this) {
                    if (!isStarted()) {
                        this.childInitializers.put(str, backgroundInitializer);
                    } else {
                        throw new IllegalStateException("addInitializer() must not be called after start()!");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Child initializer must not be null!");
        }
    }

    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public int getTaskCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 1;
            for (BackgroundInitializer<?> backgroundInitializer : this.childInitializers.values()) {
                i2 += backgroundInitializer.getTaskCount();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    public MultiBackgroundInitializerResults initialize() throws Exception {
        InterceptResult invokeV;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                hashMap = new HashMap(this.childInitializers);
            }
            ExecutorService activeExecutor = getActiveExecutor();
            for (BackgroundInitializer backgroundInitializer : hashMap.values()) {
                if (backgroundInitializer.getExternalExecutor() == null) {
                    backgroundInitializer.setExternalExecutor(activeExecutor);
                }
                backgroundInitializer.start();
            }
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                try {
                    hashMap2.put(entry.getKey(), ((BackgroundInitializer) entry.getValue()).get());
                } catch (ConcurrentException e2) {
                    hashMap3.put(entry.getKey(), e2);
                }
            }
            return new MultiBackgroundInitializerResults(hashMap, hashMap2, hashMap3, null);
        }
        return (MultiBackgroundInitializerResults) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiBackgroundInitializer(ExecutorService executorService) {
        super(executorService);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ExecutorService) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.childInitializers = new HashMap();
    }
}
