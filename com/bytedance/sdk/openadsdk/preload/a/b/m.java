package com.bytedance.sdk.openadsdk.preload.a.b;

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
/* loaded from: classes9.dex */
public abstract class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static m a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Class<?> cls = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                return new m(cls.getMethod("allocateInstance", Class.class), declaredField.get(null)) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.m.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Method f68530a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ Object f68531b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r6, r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f68530a = r6;
                        this.f68531b = r7;
                    }

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                    public <T> T a(Class<T> cls2) throws Exception {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                            m.b(cls2);
                            return (T) this.f68530a.invoke(this.f68531b, cls2);
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
                        return new m(declaredMethod2, intValue) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.m.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Method f68532a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f68533b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {declaredMethod2, Integer.valueOf(intValue)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68532a = declaredMethod2;
                                this.f68533b = intValue;
                            }

                            @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                            public <T> T a(Class<T> cls2) throws Exception {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                                    m.b(cls2);
                                    return (T) this.f68532a.invoke(null, cls2, Integer.valueOf(this.f68533b));
                                }
                                return (T) invokeL.objValue;
                            }
                        };
                    } catch (Exception unused2) {
                        Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                        declaredMethod3.setAccessible(true);
                        return new m(declaredMethod3) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.m.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Method f68534a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {declaredMethod3};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f68534a = declaredMethod3;
                            }

                            @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                            public <T> T a(Class<T> cls2) throws Exception {
                                InterceptResult invokeL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls2)) == null) {
                                    m.b(cls2);
                                    return (T) this.f68534a.invoke(null, cls2, Object.class);
                                }
                                return (T) invokeL.objValue;
                            }
                        };
                    }
                } catch (Exception unused3) {
                    return new m() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.m.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.preload.a.b.m
                        public <T> T a(Class<T> cls2) {
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
        return (m) invokeV.objValue;
    }

    public static void b(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, cls) == null) {
            int modifiers = cls.getModifiers();
            if (!Modifier.isInterface(modifiers)) {
                if (Modifier.isAbstract(modifiers)) {
                    throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
                }
                return;
            }
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
