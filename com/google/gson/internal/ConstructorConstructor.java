package com.google.gson.internal;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
/* loaded from: classes5.dex */
public final class ConstructorConstructor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ReflectionAccessor accessor;
    public final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.accessor = ReflectionAccessor.getInstance();
        this.instanceCreators = map;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            try {
                Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                if (!declaredConstructor.isAccessible()) {
                    this.accessor.makeAccessible(declaredConstructor);
                }
                return new ObjectConstructor<T>(this, declaredConstructor) { // from class: com.google.gson.internal.ConstructorConstructor.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConstructorConstructor this$0;
                    public final /* synthetic */ Constructor val$constructor;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, declaredConstructor};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$constructor = declaredConstructor;
                    }

                    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                return this.val$constructor.newInstance(null);
                            } catch (IllegalAccessException e) {
                                throw new AssertionError(e);
                            } catch (InstantiationException e2) {
                                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e2);
                            } catch (InvocationTargetException e3) {
                                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e3.getTargetException());
                            }
                        }
                        return invokeV.objValue;
                    }
                };
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (ObjectConstructor) invokeL.objValue;
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, type, cls)) == null) {
            if (Collection.class.isAssignableFrom(cls)) {
                if (SortedSet.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.TreeSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new TreeSet() : invokeV.objValue;
                        }
                    };
                }
                if (EnumSet.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this, type) { // from class: com.google.gson.internal.ConstructorConstructor.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;
                        public final /* synthetic */ Type val$type;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, type};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$type = type;
                        }

                        /* JADX WARN: Type inference failed for: r0v9, types: [T, java.util.EnumSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                Type type2 = this.val$type;
                                if (type2 instanceof ParameterizedType) {
                                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                                    if (type3 instanceof Class) {
                                        return EnumSet.noneOf((Class) type3);
                                    }
                                    throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
                                }
                                throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
                            }
                            return invokeV.objValue;
                        }
                    };
                }
                if (Set.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.6
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.LinkedHashSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LinkedHashSet() : invokeV.objValue;
                        }
                    };
                }
                if (Queue.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.7
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayDeque] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ArrayDeque() : invokeV.objValue;
                        }
                    };
                }
                return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConstructorConstructor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ArrayList() : invokeV.objValue;
                    }
                };
            } else if (Map.class.isAssignableFrom(cls)) {
                if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ConcurrentSkipListMap() : invokeV.objValue;
                        }
                    };
                }
                if (ConcurrentMap.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.concurrent.ConcurrentHashMap] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ConcurrentHashMap() : invokeV.objValue;
                        }
                    };
                }
                if (SortedMap.class.isAssignableFrom(cls)) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.TreeMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new TreeMap() : invokeV.objValue;
                        }
                    };
                }
                if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                    return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ConstructorConstructor this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.google.gson.internal.ObjectConstructor
                        public T construct() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LinkedHashMap() : invokeV.objValue;
                        }
                    };
                }
                return new ObjectConstructor<T>(this) { // from class: com.google.gson.internal.ConstructorConstructor.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConstructorConstructor this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.google.gson.internal.LinkedTreeMap] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LinkedTreeMap() : invokeV.objValue;
                    }
                };
            } else {
                return null;
            }
        }
        return (ObjectConstructor) invokeLL.objValue;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, type, cls)) == null) ? new ObjectConstructor<T>(this, cls, type) { // from class: com.google.gson.internal.ConstructorConstructor.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConstructorConstructor this$0;
            public final UnsafeAllocator unsafeAllocator;
            public final /* synthetic */ Class val$rawType;
            public final /* synthetic */ Type val$type;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cls, type};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$rawType = cls;
                this.val$type = type;
                this.unsafeAllocator = UnsafeAllocator.create();
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    try {
                        return this.unsafeAllocator.newInstance(this.val$rawType);
                    } catch (Exception e) {
                        throw new RuntimeException("Unable to invoke no-args constructor for " + this.val$type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                    }
                }
                return invokeV.objValue;
            }
        } : (ObjectConstructor) invokeLL.objValue;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, typeToken)) == null) {
            Type type = typeToken.getType();
            Class<? super T> rawType = typeToken.getRawType();
            InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
            if (instanceCreator != null) {
                return new ObjectConstructor<T>(this, instanceCreator, type) { // from class: com.google.gson.internal.ConstructorConstructor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConstructorConstructor this$0;
                    public final /* synthetic */ Type val$type;
                    public final /* synthetic */ InstanceCreator val$typeCreator;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, instanceCreator, type};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$typeCreator = instanceCreator;
                        this.val$type = type;
                    }

                    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$typeCreator.createInstance(this.val$type) : invokeV.objValue;
                    }
                };
            }
            InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
            if (instanceCreator2 != null) {
                return new ObjectConstructor<T>(this, instanceCreator2, type) { // from class: com.google.gson.internal.ConstructorConstructor.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ConstructorConstructor this$0;
                    public final /* synthetic */ InstanceCreator val$rawTypeCreator;
                    public final /* synthetic */ Type val$type;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, instanceCreator2, type};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$rawTypeCreator = instanceCreator2;
                        this.val$type = type;
                    }

                    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$rawTypeCreator.createInstance(this.val$type) : invokeV.objValue;
                    }
                };
            }
            ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType);
            if (newDefaultConstructor != null) {
                return newDefaultConstructor;
            }
            ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type, rawType);
            return newDefaultImplementationConstructor != null ? newDefaultImplementationConstructor : newUnsafeAllocator(type, rawType);
        }
        return (ObjectConstructor) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.instanceCreators.toString() : (String) invokeV.objValue;
    }
}
