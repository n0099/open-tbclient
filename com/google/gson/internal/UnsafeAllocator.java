package com.google.gson.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
public abstract class UnsafeAllocator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    public UnsafeAllocator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void assertInstantiable(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, cls) == null) {
            int modifiers = cls.getModifiers();
            if (!Modifier.isInterface(modifiers)) {
                if (!Modifier.isAbstract(modifiers)) {
                    return;
                }
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
    }

    public static UnsafeAllocator create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class<?> cls = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return new UnsafeAllocator(cls.getMethod("allocateInstance", Class.class), declaredField.get(null)) { // from class: com.google.gson.internal.UnsafeAllocator.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Method val$allocateInstance;
                    public final /* synthetic */ Object val$unsafe;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r6, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$allocateInstance = r6;
                        this.val$unsafe = r7;
                    }

                    @Override // com.google.gson.internal.UnsafeAllocator
                    public <T> T newInstance(Class<T> cls2) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                            UnsafeAllocator.assertInstantiable(cls2);
                            return (T) this.val$allocateInstance.invoke(this.val$unsafe, cls2);
                        }
                        return (T) invokeL.objValue;
                    }
                };
            } catch (Exception unused) {
                try {
                    try {
                        Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                        declaredMethod.setAccessible(true);
                        int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                        Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                        declaredMethod2.setAccessible(true);
                        return new UnsafeAllocator(declaredMethod2, intValue) { // from class: com.google.gson.internal.UnsafeAllocator.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int val$constructorId;
                            public final /* synthetic */ Method val$newInstance;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {declaredMethod2, Integer.valueOf(intValue)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$newInstance = declaredMethod2;
                                this.val$constructorId = intValue;
                            }

                            @Override // com.google.gson.internal.UnsafeAllocator
                            public <T> T newInstance(Class<T> cls2) throws Exception {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                                    UnsafeAllocator.assertInstantiable(cls2);
                                    return (T) this.val$newInstance.invoke(null, cls2, Integer.valueOf(this.val$constructorId));
                                }
                                return (T) invokeL.objValue;
                            }
                        };
                    } catch (Exception unused2) {
                        Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                        declaredMethod3.setAccessible(true);
                        return new UnsafeAllocator(declaredMethod3) { // from class: com.google.gson.internal.UnsafeAllocator.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Method val$newInstance;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {declaredMethod3};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$newInstance = declaredMethod3;
                            }

                            @Override // com.google.gson.internal.UnsafeAllocator
                            public <T> T newInstance(Class<T> cls2) throws Exception {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                                    UnsafeAllocator.assertInstantiable(cls2);
                                    return (T) this.val$newInstance.invoke(null, cls2, Object.class);
                                }
                                return (T) invokeL.objValue;
                            }
                        };
                    }
                } catch (Exception unused3) {
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls2) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                                throw new UnsupportedOperationException("Cannot allocate " + cls2);
                            }
                            return (T) invokeL.objValue;
                        }
                    };
                }
            }
        }
        return (UnsafeAllocator) invokeV.objValue;
    }
}
