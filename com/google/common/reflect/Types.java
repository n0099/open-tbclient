package com.google.common.reflect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.i;
import c.i.d.a.k;
import c.i.d.a.n;
import c.i.d.c.o0;
import c.i.d.c.o1;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.text.Typography;
/* loaded from: classes3.dex */
public final class Types {
    public static /* synthetic */ Interceptable $ic;
    public static final g<Type, String> a;

    /* renamed from: b  reason: collision with root package name */
    public static final i f54935b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static abstract class ClassOwnership {
        public static final /* synthetic */ ClassOwnership[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ClassOwnership JVM_BEHAVIOR;
        public static final ClassOwnership LOCAL_CLASS_HAS_NO_OWNER;
        public static final ClassOwnership OWNED_BY_ENCLOSING_CLASS;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public class a<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
        }

        /* loaded from: classes3.dex */
        public static class b extends a<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1672069535, "Lcom/google/common/reflect/Types$ClassOwnership;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1672069535, "Lcom/google/common/reflect/Types$ClassOwnership;");
                    return;
                }
            }
            OWNED_BY_ENCLOSING_CLASS = new ClassOwnership("OWNED_BY_ENCLOSING_CLASS", 0) { // from class: com.google.common.reflect.Types.ClassOwnership.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.ClassOwnership
                public Class<?> getOwnerType(Class<?> cls) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) ? cls.getEnclosingClass() : (Class) invokeL.objValue;
                }
            };
            ClassOwnership classOwnership = new ClassOwnership("LOCAL_CLASS_HAS_NO_OWNER", 1) { // from class: com.google.common.reflect.Types.ClassOwnership.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.ClassOwnership
                public Class<?> getOwnerType(Class<?> cls) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, cls)) == null) {
                        if (cls.isLocalClass()) {
                            return null;
                        }
                        return cls.getEnclosingClass();
                    }
                    return (Class) invokeL.objValue;
                }
            };
            LOCAL_CLASS_HAS_NO_OWNER = classOwnership;
            $VALUES = new ClassOwnership[]{OWNED_BY_ENCLOSING_CLASS, classOwnership};
            JVM_BEHAVIOR = detectJvmBehavior();
        }

        public ClassOwnership(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ClassOwnership detectJvmBehavior() {
            InterceptResult invokeV;
            ClassOwnership[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                ParameterizedType parameterizedType = (ParameterizedType) b.class.getGenericSuperclass();
                for (ClassOwnership classOwnership : values()) {
                    if (classOwnership.getOwnerType(a.class) == parameterizedType.getOwnerType()) {
                        return classOwnership;
                    }
                }
                throw new AssertionError();
            }
            return (ClassOwnership) invokeV.objValue;
        }

        public static ClassOwnership valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (ClassOwnership) Enum.valueOf(ClassOwnership.class, str) : (ClassOwnership) invokeL.objValue;
        }

        public static ClassOwnership[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (ClassOwnership[]) $VALUES.clone() : (ClassOwnership[]) invokeV.objValue;
        }

        public abstract Class<?> getOwnerType(Class<?> cls);

        public /* synthetic */ ClassOwnership(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof GenericArrayType) {
                    return k.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.componentType : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.componentType.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Types.t(this.componentType) + "[]";
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static abstract class JavaVersion {
        public static final /* synthetic */ JavaVersion[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final JavaVersion CURRENT;
        public static final JavaVersion JAVA6;
        public static final JavaVersion JAVA7;
        public static final JavaVersion JAVA8;
        public static final JavaVersion JAVA9;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes3.dex */
        public static class a extends c.i.d.h.d<Map.Entry<String, int[][]>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
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
        }

        /* loaded from: classes3.dex */
        public static class b extends c.i.d.h.d<int[]> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
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
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1224834774, "Lcom/google/common/reflect/Types$JavaVersion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1224834774, "Lcom/google/common/reflect/Types$JavaVersion;");
                    return;
                }
            }
            JAVA6 = new JavaVersion("JAVA6", 0) { // from class: com.google.common.reflect.Types.JavaVersion.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) {
                        n.p(type);
                        if (type instanceof Class) {
                            Class cls = (Class) type;
                            return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                        }
                        return type;
                    }
                    return (Type) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.reflect.Types.JavaVersion
                public GenericArrayType newArrayType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, type)) == null) ? new GenericArrayTypeImpl(type) : (GenericArrayType) invokeL.objValue;
                }
            };
            JAVA7 = new JavaVersion("JAVA7", 1) { // from class: com.google.common.reflect.Types.JavaVersion.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, type)) == null) {
                        if (type instanceof Class) {
                            return Types.i((Class) type);
                        }
                        return new GenericArrayTypeImpl(type);
                    }
                    return (Type) invokeL.objValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type)) == null) {
                        n.p(type);
                        return type;
                    }
                    return (Type) invokeL.objValue;
                }
            };
            JAVA8 = new JavaVersion("JAVA8", 2) { // from class: com.google.common.reflect.Types.JavaVersion.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, type)) == null) ? JavaVersion.JAVA7.newArrayType(type) : (Type) invokeL.objValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public String typeName(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type)) == null) {
                        try {
                            return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                        } catch (IllegalAccessException e2) {
                            throw new RuntimeException(e2);
                        } catch (NoSuchMethodException unused) {
                            throw new AssertionError("Type.getTypeName should be available in Java 8");
                        } catch (InvocationTargetException e3) {
                            throw new RuntimeException(e3);
                        }
                    }
                    return (String) invokeL.objValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) ? JavaVersion.JAVA7.usedInGenericType(type) : (Type) invokeL.objValue;
                }
            };
            JavaVersion javaVersion = new JavaVersion("JAVA9", 3) { // from class: com.google.common.reflect.Types.JavaVersion.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r9, r10, null);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r9, Integer.valueOf(r10)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr2 = newInitContext.callArgs;
                            super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (a) objArr2[2]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public boolean jdkTypeDuplicatesOwnerName() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type newArrayType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type)) == null) ? JavaVersion.JAVA8.newArrayType(type) : (Type) invokeL.objValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public String typeName(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) ? JavaVersion.JAVA8.typeName(type) : (String) invokeL.objValue;
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public Type usedInGenericType(Type type) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048579, this, type)) == null) ? JavaVersion.JAVA8.usedInGenericType(type) : (Type) invokeL.objValue;
                }
            };
            JAVA9 = javaVersion;
            $VALUES = new JavaVersion[]{JAVA6, JAVA7, JAVA8, javaVersion};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = JAVA8;
                } else {
                    CURRENT = JAVA9;
                }
            } else if (new b().capture() instanceof Class) {
                CURRENT = JAVA7;
            } else {
                CURRENT = JAVA6;
            }
        }

        public JavaVersion(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static JavaVersion valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (JavaVersion) Enum.valueOf(JavaVersion.class, str) : (JavaVersion) invokeL.objValue;
        }

        public static JavaVersion[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (JavaVersion[]) $VALUES.clone() : (JavaVersion[]) invokeV.objValue;
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public abstract Type newArrayType(Type type);

        public String typeName(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, type)) == null) ? Types.t(type) : (String) invokeL.objValue;
        }

        public final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, typeArr)) == null) {
                ImmutableList.a builder = ImmutableList.builder();
                for (Type type : typeArr) {
                    builder.h(usedInGenericType(type));
                }
                return builder.j();
            }
            return (ImmutableList) invokeL.objValue;
        }

        public abstract Type usedInGenericType(Type type);

        public /* synthetic */ JavaVersion(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes3.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableList<Type> argumentsList;
        public final Type ownerType;
        public final Class<?> rawType;

        public ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type, cls, typeArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(cls);
            n.d(typeArr.length == cls.getTypeParameters().length);
            Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) obj;
                    return getRawType().equals(parameterizedType.getRawType()) && k.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Types.s(this.argumentsList) : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ownerType : (Type) invokeV.objValue;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.rawType : (Type) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Type type = this.ownerType;
                return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.ownerType != null && JavaVersion.CURRENT.jdkTypeDuplicatesOwnerName()) {
                    sb.append(JavaVersion.CURRENT.typeName(this.ownerType));
                    sb.append('.');
                }
                sb.append(this.rawType.getName());
                sb.append(Typography.less);
                sb.append(Types.f54935b.c(o0.s(this.argumentsList, Types.a)));
                sb.append(Typography.greater);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final ImmutableList<Type> lowerBounds;
        public final ImmutableList<Type> upperBounds;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeArr, typeArr2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Types.g(typeArr, "lower bound for wildcard");
            Types.g(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) obj;
                    return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Types.s(this.lowerBounds) : (Type[]) invokeV.objValue;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Types.s(this.upperBounds) : (Type[]) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.lowerBounds.hashCode() ^ this.upperBounds.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder("?");
                o1<Type> it = this.lowerBounds.iterator();
                while (it.hasNext()) {
                    sb.append(" super ");
                    sb.append(JavaVersion.CURRENT.typeName(it.next()));
                }
                for (Type type : Types.h(this.upperBounds)) {
                    sb.append(" extends ");
                    sb.append(JavaVersion.CURRENT.typeName(type));
                }
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements g<Type, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.a.g
        /* renamed from: a */
        public String apply(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, type)) == null) ? JavaVersion.CURRENT.typeName(type) : (String) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends c.i.d.h.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f54936b;

        public b(AtomicReference atomicReference) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atomicReference};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54936b = atomicReference;
        }

        @Override // c.i.d.h.g
        public void b(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
                this.f54936b.set(cls.getComponentType());
            }
        }

        @Override // c.i.d.h.g
        public void c(GenericArrayType genericArrayType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, genericArrayType) == null) {
                this.f54936b.set(genericArrayType.getGenericComponentType());
            }
        }

        @Override // c.i.d.h.g
        public void e(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, typeVariable) == null) {
                this.f54936b.set(Types.q(typeVariable.getBounds()));
            }
        }

        @Override // c.i.d.h.g
        public void f(WildcardType wildcardType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wildcardType) == null) {
                this.f54936b.set(Types.q(wildcardType.getUpperBounds()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c<X> {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-940853027, "Lcom/google/common/reflect/Types$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-940853027, "Lcom/google/common/reflect/Types$c;");
                    return;
                }
            }
            a = !c.class.getTypeParameters()[0].equals(Types.l(c.class, "X", new Type[0]));
        }

        public c() {
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

    /* loaded from: classes3.dex */
    public static final class d<D extends GenericDeclaration> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final D a;

        /* renamed from: b  reason: collision with root package name */
        public final String f54937b;

        /* renamed from: c  reason: collision with root package name */
        public final ImmutableList<Type> f54938c;

        public d(D d2, String str, Type[] typeArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2, str, typeArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Types.g(typeArr, "bound for type variable");
            n.p(d2);
            this.a = d2;
            n.p(str);
            this.f54937b = str;
            this.f54938c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (D) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54937b : (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (c.a) {
                    if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof e)) {
                        d dVar = ((e) Proxy.getInvocationHandler(obj)).f54940e;
                        return this.f54937b.equals(dVar.b()) && this.a.equals(dVar.a()) && this.f54938c.equals(dVar.f54938c);
                    }
                    return false;
                } else if (obj instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) obj;
                    return this.f54937b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.hashCode() ^ this.f54937b.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54937b : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: f  reason: collision with root package name */
        public static final ImmutableMap<String, Method> f54939f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d<?> f54940e;

        static {
            InterceptResult invokeClinit;
            Method[] methods;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-940852965, "Lcom/google/common/reflect/Types$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-940852965, "Lcom/google/common/reflect/Types$e;");
                    return;
                }
            }
            ImmutableMap.b builder = ImmutableMap.builder();
            for (Method method : d.class.getMethods()) {
                if (method.getDeclaringClass().equals(d.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            f54939f = builder.a();
        }

        public e(d<?> dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f54940e = dVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                Method method2 = f54939f.get(name);
                if (method2 != null) {
                    try {
                        return method2.invoke(this.f54940e, objArr);
                    } catch (InvocationTargetException e2) {
                        throw e2.getCause();
                    }
                }
                throw new UnsupportedOperationException(name);
            }
            return invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1748463108, "Lcom/google/common/reflect/Types;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1748463108, "Lcom/google/common/reflect/Types;");
                return;
            }
        }
        a = new a();
        f54935b = i.g(StringUtil.ARRAY_ELEMENT_SEPARATOR).i(StringUtil.NULL_STRING);
    }

    public static void g(Type[] typeArr, String str) {
        Class cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, typeArr, str) == null) {
            for (Type type : typeArr) {
                if (type instanceof Class) {
                    n.l(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
                }
            }
        }
    }

    public static Iterable<Type> h(Iterable<Type> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, iterable)) == null) ? o0.e(iterable, Predicates.j(Predicates.f(Object.class))) : (Iterable) invokeL.objValue;
    }

    public static Class<?> i(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? Array.newInstance(cls, 0).getClass() : (Class) invokeL.objValue;
    }

    public static Type j(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, type)) == null) {
            n.p(type);
            AtomicReference atomicReference = new AtomicReference();
            new b(atomicReference).a(type);
            return (Type) atomicReference.get();
        }
        return (Type) invokeL.objValue;
    }

    public static Type k(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, type)) == null) {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerBounds = wildcardType.getLowerBounds();
                n.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
                if (lowerBounds.length == 1) {
                    return r(k(lowerBounds[0]));
                }
                Type[] upperBounds = wildcardType.getUpperBounds();
                n.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
                return p(k(upperBounds[0]));
            }
            return JavaVersion.CURRENT.newArrayType(type);
        }
        return (Type) invokeL.objValue;
    }

    public static <D extends GenericDeclaration> TypeVariable<D> l(D d2, String str, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, d2, str, typeArr)) == null) {
            if (typeArr.length == 0) {
                typeArr = new Type[]{Object.class};
            }
            return o(d2, str, typeArr);
        }
        return (TypeVariable) invokeLLL.objValue;
    }

    public static ParameterizedType m(Class<?> cls, Type... typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, cls, typeArr)) == null) ? new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr) : (ParameterizedType) invokeLL.objValue;
    }

    public static ParameterizedType n(Type type, Class<?> cls, Type... typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, type, cls, typeArr)) == null) {
            if (type == null) {
                return m(cls, typeArr);
            }
            n.p(typeArr);
            n.k(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
            return new ParameterizedTypeImpl(type, cls, typeArr);
        }
        return (ParameterizedType) invokeLLL.objValue;
    }

    public static <D extends GenericDeclaration> TypeVariable<D> o(D d2, String str, Type[] typeArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, d2, str, typeArr)) == null) ? (TypeVariable) c.i.d.h.c.a(TypeVariable.class, new e(new d(d2, str, typeArr))) : (TypeVariable) invokeLLL.objValue;
    }

    public static WildcardType p(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, type)) == null) ? new WildcardTypeImpl(new Type[0], new Type[]{type}) : (WildcardType) invokeL.objValue;
    }

    public static Type q(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, typeArr)) == null) {
            for (Type type : typeArr) {
                Type j2 = j(type);
                if (j2 != null) {
                    if (j2 instanceof Class) {
                        Class cls = (Class) j2;
                        if (cls.isPrimitive()) {
                            return cls;
                        }
                    }
                    return p(j2);
                }
            }
            return null;
        }
        return (Type) invokeL.objValue;
    }

    public static WildcardType r(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, type)) == null) ? new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class}) : (WildcardType) invokeL.objValue;
    }

    public static Type[] s(Collection<Type> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, collection)) == null) ? (Type[]) collection.toArray(new Type[collection.size()]) : (Type[]) invokeL.objValue;
    }

    public static String t(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, type)) == null) ? type instanceof Class ? ((Class) type).getName() : type.toString() : (String) invokeL.objValue;
    }
}
