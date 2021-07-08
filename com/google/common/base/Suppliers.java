package com.google.common.base;

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
import d.f.d.a.g;
import d.f.d.a.k;
import d.f.d.a.m;
import d.f.d.a.n;
import d.f.d.a.r;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class Suppliers {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class ExpiringMemoizingSupplier<T> implements r<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final r<T> delegate;
        public final long durationNanos;
        public volatile transient long expirationNanos;
        public volatile transient T value;

        public ExpiringMemoizingSupplier(r<T> rVar, long j, TimeUnit timeUnit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar, Long.valueOf(j), timeUnit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(rVar);
            this.delegate = rVar;
            this.durationNanos = timeUnit.toNanos(j);
            n.j(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // d.f.d.a.r
        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                long j = this.expirationNanos;
                long f2 = m.f();
                if (j == 0 || f2 - j >= 0) {
                    synchronized (this) {
                        if (j == this.expirationNanos) {
                            T t = this.delegate.get();
                            this.value = t;
                            long j2 = f2 + this.durationNanos;
                            if (j2 == 0) {
                                j2 = 1;
                            }
                            this.expirationNanos = j2;
                            return t;
                        }
                    }
                }
                return this.value;
            }
            return (T) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "Suppliers.memoizeWithExpiration(" + this.delegate + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.durationNanos + ", NANOS)";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class MemoizingSupplier<T> implements r<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final r<T> delegate;
        public volatile transient boolean initialized;
        public transient T value;

        public MemoizingSupplier(r<T> rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(rVar);
            this.delegate = rVar;
        }

        @Override // d.f.d.a.r
        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (!this.initialized) {
                    synchronized (this) {
                        if (!this.initialized) {
                            T t = this.delegate.get();
                            this.value = t;
                            this.initialized = true;
                            return t;
                        }
                    }
                }
                return this.value;
            }
            return (T) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Suppliers.memoize(");
                if (this.initialized) {
                    obj = "<supplier that returned " + this.value + ">";
                } else {
                    obj = this.delegate;
                }
                sb.append(obj);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class SupplierComposition<F, T> implements r<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final g<? super F, T> function;
        public final r<F> supplier;

        public SupplierComposition(g<? super F, T> gVar, r<F> rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(gVar);
            this.function = gVar;
            n.p(rVar);
            this.supplier = rVar;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof SupplierComposition) {
                    SupplierComposition supplierComposition = (SupplierComposition) obj;
                    return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: F, ? super F */
        @Override // d.f.d.a.r
        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.function.apply((F) this.supplier.get()) : (T) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(this.function, this.supplier) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Suppliers.compose(" + this.function + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.supplier + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class SupplierFunctionImpl implements Object<Object> {
        public static final /* synthetic */ SupplierFunctionImpl[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SupplierFunctionImpl INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(654673892, "Lcom/google/common/base/Suppliers$SupplierFunctionImpl;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(654673892, "Lcom/google/common/base/Suppliers$SupplierFunctionImpl;");
                    return;
                }
            }
            SupplierFunctionImpl supplierFunctionImpl = new SupplierFunctionImpl("INSTANCE", 0);
            INSTANCE = supplierFunctionImpl;
            $VALUES = new SupplierFunctionImpl[]{supplierFunctionImpl};
        }

        public SupplierFunctionImpl(String str, int i2) {
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

        public static SupplierFunctionImpl valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SupplierFunctionImpl) Enum.valueOf(SupplierFunctionImpl.class, str) : (SupplierFunctionImpl) invokeL.objValue;
        }

        public static SupplierFunctionImpl[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SupplierFunctionImpl[]) $VALUES.clone() : (SupplierFunctionImpl[]) invokeV.objValue;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "Suppliers.supplierFunction()" : (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        public Object apply(r<Object> rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, rVar)) == null) ? rVar.get() : invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class SupplierOfInstance<T> implements r<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final T instance;

        public SupplierOfInstance(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.instance = t;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof SupplierOfInstance) {
                    return k.a(this.instance, ((SupplierOfInstance) obj).instance);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // d.f.d.a.r
        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.instance : (T) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(this.instance) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "Suppliers.ofInstance(" + this.instance + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class ThreadSafeSupplier<T> implements r<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final r<T> delegate;

        public ThreadSafeSupplier(r<T> rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(rVar);
            this.delegate = rVar;
        }

        @Override // d.f.d.a.r
        public T get() {
            InterceptResult invokeV;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                synchronized (this.delegate) {
                    t = this.delegate.get();
                }
                return t;
            }
            return (T) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return "Suppliers.synchronizedSupplier(" + this.delegate + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    public static <T> r<T> a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t)) == null) ? new SupplierOfInstance(t) : (r) invokeL.objValue;
    }
}
