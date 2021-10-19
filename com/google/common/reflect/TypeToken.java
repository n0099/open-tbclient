package com.google.common.reflect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.i;
import c.i.d.a.n;
import c.i.d.a.o;
import c.i.d.c.j0;
import c.i.d.c.o1;
import c.i.d.c.x;
import c.i.d.h.b;
import c.i.d.h.f;
import c.i.d.h.g;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes10.dex */
public abstract class TypeToken<T> extends c.i.d.h.d<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 3637540370352322684L;
    public transient /* synthetic */ FieldHolder $fh;
    public transient c.i.d.h.f covariantTypeResolver;
    public transient c.i.d.h.f invariantTypeResolver;
    public final Type runtimeType;

    /* loaded from: classes10.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public transient ImmutableSet<TypeToken<? super T>> classes;
        public final /* synthetic */ TypeToken this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClassSet(TypeToken typeToken) {
            super(typeToken);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((TypeToken) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = typeToken;
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.this$0.getTypes().classes() : invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (TypeSet) invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new UnsupportedOperationException("classes().interfaces() not supported.");
            }
            return (TypeSet) invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ImmutableSet.copyOf((Collection) f.f71198b.a().c(this.this$0.getRawTypes())) : (Set) invokeV.objValue;
        }

        public /* synthetic */ ClassSet(TypeToken typeToken, a aVar) {
            this(typeToken);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.reflect.TypeToken.TypeSet, c.i.d.c.j0, c.i.d.c.y, c.i.d.c.h0
        public Set<TypeToken<? super T>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
                if (immutableSet == null) {
                    ImmutableSet<TypeToken<? super T>> f2 = x.d(f.f71197a.a().d(this.this$0)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                    this.classes = f2;
                    return f2;
                }
                return immutableSet;
            }
            return (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SimpleTypeToken(Type type) {
            super(type, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {type};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Type) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static abstract class TypeFilter implements o<TypeToken<?>> {
        public static final /* synthetic */ TypeFilter[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD;
        public static final TypeFilter INTERFACE_ONLY;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(785942122, "Lcom/google/common/reflect/TypeToken$TypeFilter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(785942122, "Lcom/google/common/reflect/TypeToken$TypeFilter;");
                    return;
                }
            }
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = new TypeFilter("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0) { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.reflect.TypeToken.TypeFilter, c.i.d.a.o
                public boolean apply(TypeToken<?> typeToken) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, typeToken)) == null) ? ((typeToken.runtimeType instanceof TypeVariable) || (typeToken.runtimeType instanceof WildcardType)) ? false : true : invokeL.booleanValue;
                }
            };
            TypeFilter typeFilter = new TypeFilter("INTERFACE_ONLY", 1) { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.common.reflect.TypeToken.TypeFilter, c.i.d.a.o
                public boolean apply(TypeToken<?> typeToken) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, typeToken)) == null) ? typeToken.getRawType().isInterface() : invokeL.booleanValue;
                }
            };
            INTERFACE_ONLY = typeFilter;
            $VALUES = new TypeFilter[]{IGNORE_TYPE_VARIABLE_OR_WILDCARD, typeFilter};
        }

        public TypeFilter(String str, int i2) {
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

        public static TypeFilter valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (TypeFilter) Enum.valueOf(TypeFilter.class, str) : (TypeFilter) invokeL.objValue;
        }

        public static TypeFilter[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (TypeFilter[]) $VALUES.clone() : (TypeFilter[]) invokeV.objValue;
        }

        @Override // c.i.d.a.o
        public abstract /* synthetic */ boolean apply(T t);

        public /* synthetic */ TypeFilter(String str, int i2, a aVar) {
            this(str, i2);
        }
    }

    /* loaded from: classes10.dex */
    public class a extends b.C1513b<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TypeToken f71191h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TypeToken typeToken, Method method) {
            super(method);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken, method};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Method) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71191h = typeToken;
        }

        @Override // c.i.d.h.a
        public TypeToken<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71191h : (TypeToken) invokeV.objValue;
        }

        @Override // c.i.d.h.a
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return a() + "." + super.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b extends b.a<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TypeToken f71192h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(TypeToken typeToken, Constructor constructor) {
            super(constructor);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken, constructor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Constructor) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71192h = typeToken;
        }

        @Override // c.i.d.h.a
        public TypeToken<T> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71192h : (TypeToken) invokeV.objValue;
        }

        @Override // c.i.d.h.b.a
        public Type[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.i.d.h.f invariantTypeResolver = this.f71192h.getInvariantTypeResolver();
                Type[] b2 = super.b();
                invariantTypeResolver.l(b2);
                return b2;
            }
            return (Type[]) invokeV.objValue;
        }

        @Override // c.i.d.h.a
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return a() + "(" + i.g(StringUtil.ARRAY_ELEMENT_SEPARATOR).e(b()) + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class c extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TypeToken f71193b;

        public c(TypeToken typeToken) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71193b = typeToken;
        }

        @Override // c.i.d.h.g
        public void c(GenericArrayType genericArrayType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, genericArrayType) == null) {
                a(genericArrayType.getGenericComponentType());
            }
        }

        @Override // c.i.d.h.g
        public void d(ParameterizedType parameterizedType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parameterizedType) == null) {
                a(parameterizedType.getActualTypeArguments());
                a(parameterizedType.getOwnerType());
            }
        }

        @Override // c.i.d.h.g
        public void e(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, typeVariable) == null) {
                throw new IllegalArgumentException(this.f71193b.runtimeType + "contains a type variable and is not safe for the operation");
            }
        }

        @Override // c.i.d.h.g
        public void f(WildcardType wildcardType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, wildcardType) == null) {
                a(wildcardType.getLowerBounds());
                a(wildcardType.getUpperBounds());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f71194b;

        public d(TypeToken typeToken, ImmutableSet.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71194b = aVar;
        }

        @Override // c.i.d.h.g
        public void b(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
                this.f71194b.a(cls);
            }
        }

        @Override // c.i.d.h.g
        public void c(GenericArrayType genericArrayType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, genericArrayType) == null) {
                this.f71194b.a(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
            }
        }

        @Override // c.i.d.h.g
        public void d(ParameterizedType parameterizedType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parameterizedType) == null) {
                this.f71194b.a((Class) parameterizedType.getRawType());
            }
        }

        @Override // c.i.d.h.g
        public void e(TypeVariable<?> typeVariable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, typeVariable) == null) {
                a(typeVariable.getBounds());
            }
        }

        @Override // c.i.d.h.g
        public void f(WildcardType wildcardType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, wildcardType) == null) {
                a(wildcardType.getUpperBounds());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Type[] f71195a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f71196b;

        public e(Type[] typeArr, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeArr, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71195a = typeArr;
            this.f71196b = z;
        }

        public boolean a(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, type)) == null) {
                for (Type type2 : this.f71195a) {
                    boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                    boolean z = this.f71196b;
                    if (isSubtypeOf == z) {
                        return z;
                    }
                }
                return !this.f71196b;
            }
            return invokeL.booleanValue;
        }

        public boolean b(Type type) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, type)) == null) {
                TypeToken<?> of = TypeToken.of(type);
                for (Type type2 : this.f71195a) {
                    boolean isSubtypeOf = of.isSubtypeOf(type2);
                    boolean z = this.f71196b;
                    if (isSubtypeOf == z) {
                        return z;
                    }
                }
                return !this.f71196b;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class f<K> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final f<TypeToken<?>> f71197a;

        /* renamed from: b  reason: collision with root package name */
        public static final f<Class<?>> f71198b;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes10.dex */
        public static class a extends f<TypeToken<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a() {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, typeToken)) == null) ? typeToken.getGenericInterfaces() : (Iterable) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, typeToken)) == null) ? typeToken.getRawType() : (Class) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, typeToken)) == null) ? typeToken.getGenericSuperclass() : (TypeToken) invokeL.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public static class b extends f<Class<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b() {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.reflect.TypeToken.f
            public /* bridge */ /* synthetic */ Class f(Class<?> cls) {
                Class<?> cls2 = cls;
                j(cls2);
                return cls2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? Arrays.asList(cls.getInterfaces()) : (Iterable) invokeL.objValue;
            }

            public Class<?> j(Class<?> cls) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) ? cls : (Class) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.reflect.TypeToken.f
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) ? cls.getSuperclass() : (Class) invokeL.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public class c extends e<K> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(f fVar, f fVar2) {
                super(fVar2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, fVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((f) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.reflect.TypeToken.f
            public ImmutableList<K> c(Iterable<? extends K> iterable) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iterable)) == null) {
                    ImmutableList.a builder = ImmutableList.builder();
                    for (K k : iterable) {
                        if (!f(k).isInterface()) {
                            builder.h(k);
                        }
                    }
                    return super.c(builder.j());
                }
                return (ImmutableList) invokeL.objValue;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Iterable<? extends K> e(K k) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? ImmutableSet.of() : (Iterable) invokeL.objValue;
            }
        }

        /* loaded from: classes10.dex */
        public static class d extends Ordering<K> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Comparator f71199e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Map f71200f;

            public d(Comparator comparator, Map map) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {comparator, map};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71199e = comparator;
                this.f71200f = map;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Comparator */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, k2)) == null) ? this.f71199e.compare(this.f71200f.get(k), this.f71200f.get(k2)) : invokeLL.intValue;
            }
        }

        /* loaded from: classes10.dex */
        public static class e<K> extends f<K> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: c  reason: collision with root package name */
            public final f<K> f71201c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(f<K> fVar) {
                super(null);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((a) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71201c = fVar;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public Class<?> f(K k) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? this.f71201c.f(k) : (Class) invokeL.objValue;
            }

            @Override // com.google.common.reflect.TypeToken.f
            public K g(K k) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? this.f71201c.g(k) : (K) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(47326228, "Lcom/google/common/reflect/TypeToken$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(47326228, "Lcom/google/common/reflect/TypeToken$f;");
                    return;
                }
            }
            f71197a = new a();
            f71198b = new b();
        }

        public f() {
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

        public static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, comparator)) == null) ? (ImmutableList<K>) new d(comparator, map).immutableSortedCopy(map.keySet()) : (ImmutableList) invokeLL.objValue;
        }

        public final f<K> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this, this) : (f) invokeV.objValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: int */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: int */
        /* JADX WARN: Multi-variable type inference failed */
        public final int b(K k, Map<? super K, Integer> map) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, map)) == null) {
                Integer num = map.get(k);
                if (num != null) {
                    return num.intValue();
                }
                boolean isInterface = f(k).isInterface();
                int i2 = isInterface;
                for (K k2 : e(k)) {
                    i2 = Math.max(i2, b(k2, map));
                }
                K g2 = g(k);
                int i3 = i2;
                if (g2 != null) {
                    i3 = Math.max(i2, b(g2, map));
                }
                int i4 = i3 + 1;
                map.put(k, Integer.valueOf(i4));
                return i4;
            }
            return invokeLL.intValue;
        }

        public ImmutableList<K> c(Iterable<? extends K> iterable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) {
                HashMap s = Maps.s();
                for (K k : iterable) {
                    b(k, s);
                }
                return h(s, Ordering.natural().reverse());
            }
            return (ImmutableList) invokeL.objValue;
        }

        public final ImmutableList<K> d(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) ? c(ImmutableList.of(k)) : (ImmutableList) invokeL.objValue;
        }

        public abstract Iterable<? extends K> e(K k);

        public abstract Class<?> f(K k);

        public abstract K g(K k);

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public /* synthetic */ TypeToken(Type type, a aVar) {
        this(type);
    }

    public static e any(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, typeArr)) == null) ? new e(typeArr, true) : (e) invokeL.objValue;
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, type)) == null) {
            TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
            if (typeToken.getRawType().isInterface()) {
                return null;
            }
            return typeToken;
        }
        return (TypeToken) invokeL.objValue;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, typeArr)) == null) {
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                TypeToken<?> of = of(type);
                if (of.getRawType().isInterface()) {
                    builder.h(of);
                }
            }
            return builder.j();
        }
        return (ImmutableList) invokeL.objValue;
    }

    public static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, typeVariable, type)) == null) {
            if (type instanceof WildcardType) {
                return canonicalizeWildcardType(typeVariable, (WildcardType) type);
            }
            return canonicalizeWildcardsInType(type);
        }
        return (Type) invokeLL.objValue;
    }

    public static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        InterceptResult invokeLL;
        Type[] upperBounds;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, typeVariable, wildcardType)) == null) {
            Type[] bounds = typeVariable.getBounds();
            ArrayList arrayList = new ArrayList();
            for (Type type : wildcardType.getUpperBounds()) {
                if (!any(bounds).a(type)) {
                    arrayList.add(canonicalizeWildcardsInType(type));
                }
            }
            return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
        }
        return (WildcardType) invokeLL.objValue;
    }

    public static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, parameterizedType)) == null) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                actualTypeArguments[i2] = canonicalizeTypeArg(typeParameters[i2], actualTypeArguments[i2]);
            }
            return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
        }
        return (ParameterizedType) invokeL.objValue;
    }

    public static Type canonicalizeWildcardsInType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, type)) == null) {
            if (type instanceof ParameterizedType) {
                return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
            }
            return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
        }
        return (Type) invokeL.objValue;
    }

    public static e every(Type[] typeArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, typeArr)) == null) ? new e(typeArr, false) : (e) invokeL.objValue;
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, cls)) == null) ? (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType)) : (TypeToken) invokeL.objValue;
    }

    /* JADX DEBUG: Type inference failed for r5v1. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? super ?> */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, this, cls)) == null) {
            TypeToken<?> componentType = getComponentType();
            n.s(componentType, "%s isn't a super type of %s", cls, this);
            return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(componentType.getSupertype(cls.getComponentType()).runtimeType));
        }
        return (TypeToken) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.i.d.h.f getCovariantTypeResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            c.i.d.h.f fVar = this.covariantTypeResolver;
            if (fVar == null) {
                c.i.d.h.f d2 = c.i.d.h.f.d(this.runtimeType);
                this.covariantTypeResolver = d2;
                return d2;
            }
            return fVar;
        }
        return (c.i.d.h.f) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.i.d.h.f getInvariantTypeResolver() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            c.i.d.h.f fVar = this.invariantTypeResolver;
            if (fVar == null) {
                c.i.d.h.f f2 = c.i.d.h.f.f(this.runtimeType);
                this.invariantTypeResolver = f2;
                return f2;
            }
            return fVar;
        }
        return (c.i.d.h.f) invokeV.objValue;
    }

    private Type getOwnerTypeIfPresent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            Type type = this.runtimeType;
            if (type instanceof ParameterizedType) {
                return ((ParameterizedType) type).getOwnerType();
            }
            if (type instanceof Class) {
                return ((Class) type).getEnclosingClass();
            }
            return null;
        }
        return (Type) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            ImmutableSet.a builder = ImmutableSet.builder();
            new d(this, builder).a(this.runtimeType);
            return builder.l();
        }
        return (ImmutableSet) invokeV.objValue;
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, this, cls, typeArr)) == null) {
            if (typeArr.length > 0) {
                return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
            }
            throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
        }
        return (TypeToken) invokeLL.objValue;
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, this, cls, typeArr)) == null) {
            for (Type type : typeArr) {
                TypeToken<?> of = of(type);
                if (of.isSubtypeOf(cls)) {
                    return (TypeToken<? super T>) of.getSupertype(cls);
                }
            }
            throw new IllegalArgumentException(cls + " isn't a super type of " + this);
        }
        return (TypeToken) invokeLL.objValue;
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, this, type, typeVariable)) == null) {
            if (this.runtimeType.equals(type)) {
                return true;
            }
            if (type instanceof WildcardType) {
                WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
                return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
            }
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
        }
        return invokeLL.booleanValue;
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, type)) == null) {
            Iterator<TypeToken<? super T>> it = getTypes().iterator();
            while (it.hasNext()) {
                Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
                if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, genericArrayType)) == null) {
            Type type = this.runtimeType;
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
                }
                return false;
            } else if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, this, parameterizedType)) == null) {
            Class<? super Object> rawType = of(parameterizedType).getRawType();
            if (someRawTypeIsSubclassOf(rawType)) {
                TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i2 = 0; i2 < typeParameters.length; i2++) {
                    if (!of(getCovariantTypeResolver().j(typeParameters[i2])).is(actualTypeArguments[i2], typeParameters[i2])) {
                        return false;
                    }
                }
                return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, this, genericArrayType)) == null) {
            Type type = this.runtimeType;
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.isArray()) {
                    return cls.isAssignableFrom(Object[].class);
                }
                return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
            } else if (type instanceof GenericArrayType) {
                return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) ? c.i.d.g.a.b().contains(this.runtimeType) : invokeV.booleanValue;
    }

    public static Type newArrayClassOrGenericArrayType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, type)) == null) ? Types.JavaVersion.JAVA7.newArrayType(type) : (Type) invokeL.objValue;
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65567, null, cls)) == null) ? new SimpleTypeToken(cls) : (TypeToken) invokeL.objValue;
    }

    private TypeToken<?> resolveSupertype(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, this, type)) == null) {
            TypeToken<?> of = of(getCovariantTypeResolver().j(type));
            of.covariantTypeResolver = this.covariantTypeResolver;
            of.invariantTypeResolver = this.invariantTypeResolver;
            return of;
        }
        return (TypeToken) invokeL.objValue;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, cls)) == null) {
            if (!(this.runtimeType instanceof Class) || (cls.getTypeParameters().length != 0 && getRawType().getTypeParameters().length == 0)) {
                TypeToken genericType = toGenericType(cls);
                return new c.i.d.h.f().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
            }
            return cls;
        }
        return (Type) invokeL.objValue;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, cls)) == null) {
            o1<Class<? super T>> it = getRawTypes().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, cls)) == null) {
            if (cls.isArray()) {
                return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
            }
            TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
            Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
            if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
                return of((Class) cls);
            }
            return (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters));
        }
        return (TypeToken) invokeL.objValue;
    }

    public final c.i.d.h.b<T, T> constructor(Constructor<?> constructor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, constructor)) == null) {
            n.l(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
            return new b(this, constructor);
        }
        return (c.i.d.h.b) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof TypeToken) {
                return this.runtimeType.equals(((TypeToken) obj).runtimeType);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final TypeToken<?> getComponentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Type j2 = Types.j(this.runtimeType);
            if (j2 == null) {
                return null;
            }
            return of(j2);
        }
        return (TypeToken) invokeV.objValue;
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Type type = this.runtimeType;
            if (type instanceof TypeVariable) {
                return boundsAsInterfaces(((TypeVariable) type).getBounds());
            }
            if (type instanceof WildcardType) {
                return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
            }
            ImmutableList.a builder = ImmutableList.builder();
            for (Type type2 : getRawType().getGenericInterfaces()) {
                builder.h(resolveSupertype(type2));
            }
            return builder.j();
        }
        return (ImmutableList) invokeV.objValue;
    }

    public final TypeToken<? super T> getGenericSuperclass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Type type = this.runtimeType;
            if (type instanceof TypeVariable) {
                return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
            }
            if (type instanceof WildcardType) {
                return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
            }
            Type genericSuperclass = getRawType().getGenericSuperclass();
            if (genericSuperclass == null) {
                return null;
            }
            return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
        }
        return (TypeToken) invokeV.objValue;
    }

    public final Class<? super T> getRawType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getRawTypes().iterator().next() : (Class) invokeV.objValue;
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) {
            n.k(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
            Type type = this.runtimeType;
            if (type instanceof WildcardType) {
                return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
            }
            if (isArray()) {
                return getArraySubtype(cls);
            }
            n.l(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
            TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
            n.l(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
            return typeToken;
        }
        return (TypeToken) invokeL.objValue;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            n.l(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
            Type type = this.runtimeType;
            if (type instanceof TypeVariable) {
                return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
            }
            if (type instanceof WildcardType) {
                return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
            }
            if (cls.isArray()) {
                return getArraySupertype(cls);
            }
            return (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
        }
        return (TypeToken) invokeL.objValue;
    }

    public final Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.runtimeType : (Type) invokeV.objValue;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new TypeSet(this) : (TypeSet) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.runtimeType.hashCode() : invokeV.intValue;
    }

    public final boolean isArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getComponentType() != null : invokeV.booleanValue;
    }

    public final boolean isPrimitive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Type type = this.runtimeType;
            return (type instanceof Class) && ((Class) type).isPrimitive();
        }
        return invokeV.booleanValue;
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, typeToken)) == null) ? isSubtypeOf(typeToken.getType()) : invokeL.booleanValue;
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, typeToken)) == null) ? typeToken.isSubtypeOf(getType()) : invokeL.booleanValue;
    }

    public final c.i.d.h.b<T, Object> method(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, method)) == null) {
            n.l(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
            return new a(this, method);
        }
        return (c.i.d.h.b) invokeL.objValue;
    }

    public final TypeToken<T> rejectTypeVariables() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            new c(this).a(this.runtimeType);
            return this;
        }
        return (TypeToken) invokeV.objValue;
    }

    public final TypeToken<?> resolveType(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, type)) == null) {
            n.p(type);
            return of(getInvariantTypeResolver().j(type));
        }
        return (TypeToken) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? Types.t(this.runtimeType) : (String) invokeV.objValue;
    }

    public final TypeToken<T> unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? isWrapper() ? of(c.i.d.g.a.c((Class) this.runtimeType)) : this : (TypeToken) invokeV.objValue;
    }

    public final <X> TypeToken<T> where(c.i.d.h.e<X> eVar, TypeToken<X> typeToken) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, eVar, typeToken)) == null) ? new SimpleTypeToken(new c.i.d.h.f().o(ImmutableMap.of(new f.d(eVar.f34310a), typeToken.runtimeType)).j(this.runtimeType)) : (TypeToken) invokeLL.objValue;
    }

    public final TypeToken<T> wrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? isPrimitive() ? of(c.i.d.g.a.d((Class) this.runtimeType)) : this : (TypeToken) invokeV.objValue;
    }

    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? of(new c.i.d.h.f().j(this.runtimeType)) : invokeV.objValue;
    }

    /* loaded from: classes10.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final transient TypeToken<T>.TypeSet allTypes;
        public transient ImmutableSet<TypeToken<? super T>> interfaces;
        public final /* synthetic */ TypeToken this$0;

        /* loaded from: classes10.dex */
        public class a implements o<Class<?>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(InterfaceSet interfaceSet) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {interfaceSet};
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
            @Override // c.i.d.a.o
            /* renamed from: a */
            public boolean apply(Class<?> cls) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? cls.isInterface() : invokeL.booleanValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InterfaceSet(TypeToken typeToken, TypeToken<T>.TypeSet typeSet) {
            super(typeToken);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken, typeSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((TypeToken) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = typeToken;
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.this$0.getTypes().interfaces() : invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new UnsupportedOperationException("interfaces().classes() not supported.");
            }
            return (TypeSet) invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (TypeSet) invokeV.objValue;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? x.d(f.f71198b.c(this.this$0.getRawTypes())).c(new a(this)).f() : (Set) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.reflect.TypeToken.TypeSet, c.i.d.c.j0, c.i.d.c.y, c.i.d.c.h0
        public Set<TypeToken<? super T>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
                if (immutableSet == null) {
                    ImmutableSet<TypeToken<? super T>> f2 = x.d(this.allTypes).c(TypeFilter.INTERFACE_ONLY).f();
                    this.interfaces = f2;
                    return f2;
                }
                return immutableSet;
            }
            return (Set) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class TypeSet extends j0<TypeToken<? super T>> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TypeToken this$0;
        public transient ImmutableSet<TypeToken<? super T>> types;

        public TypeSet(TypeToken typeToken) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {typeToken};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = typeToken;
        }

        public TypeToken<T>.TypeSet classes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ClassSet(this.this$0, null) : (TypeSet) invokeV.objValue;
        }

        public TypeToken<T>.TypeSet interfaces() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new InterfaceSet(this.this$0, this) : (TypeSet) invokeV.objValue;
        }

        public Set<Class<? super T>> rawTypes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ImmutableSet.copyOf((Collection) f.f71198b.c(this.this$0.getRawTypes())) : (Set) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.j0, c.i.d.c.y, c.i.d.c.h0
        public Set<TypeToken<? super T>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
                if (immutableSet == null) {
                    ImmutableSet<TypeToken<? super T>> f2 = x.d(f.f71197a.d(this.this$0)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                    this.types = f2;
                    return f2;
                }
                return immutableSet;
            }
            return (Set) invokeV.objValue;
        }
    }

    public TypeToken() {
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
        Type capture = capture();
        this.runtimeType = capture;
        n.A(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, type)) == null) ? new SimpleTypeToken(type) : (TypeToken) invokeL.objValue;
    }

    public final boolean isSubtypeOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, type)) == null) {
            n.p(type);
            if (type instanceof WildcardType) {
                return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
            }
            Type type2 = this.runtimeType;
            if (type2 instanceof WildcardType) {
                return any(((WildcardType) type2).getUpperBounds()).a(type);
            }
            if (type2 instanceof TypeVariable) {
                return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
            } else if (type2 instanceof GenericArrayType) {
                return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
            } else {
                if (type instanceof Class) {
                    return someRawTypeIsSubclassOf((Class) type);
                }
                if (type instanceof ParameterizedType) {
                    return isSubtypeOfParameterizedType((ParameterizedType) type);
                }
                if (type instanceof GenericArrayType) {
                    return isSubtypeOfArrayType((GenericArrayType) type);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean isSupertypeOf(Type type) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, type)) == null) ? of(type).isSubtypeOf(getType()) : invokeL.booleanValue;
    }

    public TypeToken(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = c.i.d.h.f.d(cls).j(capture);
        }
    }

    public final <X> TypeToken<T> where(c.i.d.h.e<X> eVar, Class<X> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, eVar, cls)) == null) ? where(eVar, of((Class) cls)) : (TypeToken) invokeLL.objValue;
    }

    public TypeToken(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        n.p(type);
        this.runtimeType = type;
    }
}
