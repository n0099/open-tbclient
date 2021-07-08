package com.bytedance.sdk.openadsdk.preload.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Type, com.bytedance.sdk.openadsdk.preload.a.h<?>> f31926a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.b.b f31927b;

    public c(Map<Type, com.bytedance.sdk.openadsdk.preload.a.h<?>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31927b = com.bytedance.sdk.openadsdk.preload.a.b.b.b.a();
        this.f31926a = map;
    }

    private <T> i<T> b(Type type, Class<? super T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, type, cls)) == null) ? new i<T>(this, cls, type) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Class f31941a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Type f31942b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f31943c;

            /* renamed from: d  reason: collision with root package name */
            public final m f31944d;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, cls, type};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f31943c = this;
                this.f31941a = cls;
                this.f31942b = type;
                this.f31944d = m.a();
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
            @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
            public T a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    try {
                        return this.f31944d.a(this.f31941a);
                    } catch (Exception e2) {
                        throw new RuntimeException("Unable to invoke no-args constructor for " + this.f31942b + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
                    }
                }
                return invokeV.objValue;
            }
        } : (i) invokeLL.objValue;
    }

    public <T> i<T> a(com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            Type b2 = aVar.b();
            Class<? super T> a2 = aVar.a();
            com.bytedance.sdk.openadsdk.preload.a.h<?> hVar = this.f31926a.get(b2);
            if (hVar != null) {
                return new i<T>(this, hVar, b2) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.h f31928a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Type f31929b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f31930c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, hVar, b2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31930c = this;
                        this.f31928a = hVar;
                        this.f31929b = b2;
                    }

                    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f31928a.a(this.f31929b) : invokeV.objValue;
                    }
                };
            }
            com.bytedance.sdk.openadsdk.preload.a.h<?> hVar2 = this.f31926a.get(a2);
            if (hVar2 != null) {
                return new i<T>(this, hVar2, b2) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ com.bytedance.sdk.openadsdk.preload.a.h f31945a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Type f31946b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ c f31947c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, hVar2, b2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31947c = this;
                        this.f31945a = hVar2;
                        this.f31946b = b2;
                    }

                    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f31945a.a(this.f31946b) : invokeV.objValue;
                    }
                };
            }
            i<T> a3 = a(a2);
            if (a3 != null) {
                return a3;
            }
            i<T> a4 = a(b2, a2);
            return a4 != null ? a4 : b(b2, a2);
        }
        return (i) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31926a.toString() : (String) invokeV.objValue;
    }

    private <T> i<T> a(Class<? super T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cls)) == null) {
            try {
                Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                if (!declaredConstructor.isAccessible()) {
                    this.f31927b.a(declaredConstructor);
                }
                return new i<T>(this, declaredConstructor) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Constructor f31948a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ c f31949b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, declaredConstructor};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31949b = this;
                        this.f31948a = declaredConstructor;
                    }

                    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            try {
                                return this.f31948a.newInstance(null);
                            } catch (IllegalAccessException e2) {
                                throw new AssertionError(e2);
                            } catch (InstantiationException e3) {
                                throw new RuntimeException("Failed to invoke " + this.f31948a + " with no args", e3);
                            } catch (InvocationTargetException e4) {
                                throw new RuntimeException("Failed to invoke " + this.f31948a + " with no args", e4.getTargetException());
                            }
                        }
                        return invokeV.objValue;
                    }
                };
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
        return (i) invokeL.objValue;
    }

    private <T> i<T> a(Type type, Class<? super T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, type, cls)) == null) {
            if (Collection.class.isAssignableFrom(cls)) {
                if (SortedSet.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31950a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31950a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.TreeSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new TreeSet() : invokeV.objValue;
                        }
                    };
                }
                if (EnumSet.class.isAssignableFrom(cls)) {
                    return new i<T>(this, type) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.10
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Type f31931a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ c f31932b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, type};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31932b = this;
                            this.f31931a = type;
                        }

                        /* JADX WARN: Type inference failed for: r0v9, types: [T, java.util.EnumSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                                Type type2 = this.f31931a;
                                if (type2 instanceof ParameterizedType) {
                                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                                    if (type3 instanceof Class) {
                                        return EnumSet.noneOf((Class) type3);
                                    }
                                    throw new com.bytedance.sdk.openadsdk.preload.a.m("Invalid EnumSet type: " + this.f31931a.toString());
                                }
                                throw new com.bytedance.sdk.openadsdk.preload.a.m("Invalid EnumSet type: " + this.f31931a.toString());
                            }
                            return invokeV.objValue;
                        }
                    };
                }
                if (Set.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31933a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31933a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.LinkedHashSet] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LinkedHashSet() : invokeV.objValue;
                        }
                    };
                }
                if (Queue.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31934a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31934a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayDeque] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ArrayDeque() : invokeV.objValue;
                        }
                    };
                }
                return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f31935a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31935a = this;
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ArrayList() : invokeV.objValue;
                    }
                };
            } else if (Map.class.isAssignableFrom(cls)) {
                if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.14
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31936a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31936a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.ConcurrentSkipListMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ConcurrentSkipListMap() : invokeV.objValue;
                        }
                    };
                }
                if (ConcurrentMap.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31937a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31937a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.concurrent.ConcurrentHashMap] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new ConcurrentHashMap() : invokeV.objValue;
                        }
                    };
                }
                if (SortedMap.class.isAssignableFrom(cls)) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31938a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31938a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.TreeMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new TreeMap() : invokeV.objValue;
                        }
                    };
                }
                if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(com.bytedance.sdk.openadsdk.preload.a.c.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
                    return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f31939a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31939a = this;
                        }

                        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, T] */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                        public T a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LinkedHashMap() : invokeV.objValue;
                        }
                    };
                }
                return new i<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.c.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ c f31940a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f31940a = this;
                    }

                    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.bytedance.sdk.openadsdk.preload.a.b.h] */
                    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.Object] */
                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new h() : invokeV.objValue;
                    }
                };
            } else {
                return null;
            }
        }
        return (i) invokeLL.objValue;
    }
}
