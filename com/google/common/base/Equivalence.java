package com.google.common.base;

import b.h.d.a.g;
import b.h.d.a.k;
import b.h.d.a.n;
import b.h.d.a.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes11.dex */
public abstract class Equivalence<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Equals INSTANCE;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1913985586, "Lcom/google/common/base/Equivalence$Equals;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1913985586, "Lcom/google/common/base/Equivalence$Equals;");
                    return;
                }
            }
            INSTANCE = new Equals();
        }

        public Equals() {
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

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) ? obj.equals(obj2) : invokeLL.booleanValue;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj.hashCode() : invokeL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class EquivalentToPredicate<T> implements o<T>, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Equivalence<T> equivalence;
        public final T target;

        public EquivalentToPredicate(Equivalence<T> equivalence, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {equivalence, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(equivalence);
            this.equivalence = equivalence;
            this.target = t;
        }

        @Override // b.h.d.a.o
        public boolean apply(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? this.equivalence.equivalent(t, this.target) : invokeL.booleanValue;
        }

        @Override // b.h.d.a.o
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof EquivalentToPredicate) {
                    EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
                    return this.equivalence.equals(equivalentToPredicate.equivalence) && k.a(this.target, equivalentToPredicate.target);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k.b(this.equivalence, this.target) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.equivalence + ".equivalentTo(" + this.target + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Identity INSTANCE;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1851555793, "Lcom/google/common/base/Equivalence$Identity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1851555793, "Lcom/google/common/base/Equivalence$Identity;");
                    return;
                }
            }
            INSTANCE = new Identity();
        }

        public Identity() {
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

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? System.identityHashCode(obj) : invokeL.intValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class Wrapper<T> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Equivalence<? super T> equivalence;
        public final T reference;

        public /* synthetic */ Wrapper(Equivalence equivalence, Object obj, a aVar) {
            this(equivalence, obj);
        }

        /* JADX DEBUG: Type inference failed for r1v2. Raw type applied. Possible types: T, ? super T */
        /* JADX DEBUG: Type inference failed for r5v4. Raw type applied. Possible types: T, ? super T */
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Wrapper) {
                    Wrapper wrapper = (Wrapper) obj;
                    if (this.equivalence.equals(wrapper.equivalence)) {
                        return this.equivalence.equivalent((T) this.reference, (T) wrapper.reference);
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.reference : (T) invokeV.objValue;
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.equivalence.hash((T) this.reference) : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.equivalence + ".wrap(" + this.reference + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public Wrapper(Equivalence<? super T> equivalence, T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {equivalence, t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(equivalence);
            this.equivalence = equivalence;
            this.reference = t;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public Equivalence() {
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

    public static Equivalence<Object> equals() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Equals.INSTANCE : (Equivalence) invokeV.objValue;
    }

    public static Equivalence<Object> identity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Identity.INSTANCE : (Equivalence) invokeV.objValue;
    }

    public abstract boolean doEquivalent(T t, T t2);

    public abstract int doHash(T t);

    public final boolean equivalent(T t, T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, t2)) == null) {
            if (t == t2) {
                return true;
            }
            if (t == null || t2 == null) {
                return false;
            }
            return doEquivalent(t, t2);
        }
        return invokeLL.booleanValue;
    }

    public final o<T> equivalentTo(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, t)) == null) ? new EquivalentToPredicate(this, t) : (o) invokeL.objValue;
    }

    public final int hash(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, t)) == null) {
            if (t == null) {
                return 0;
            }
            return doHash(t);
        }
        return invokeL.intValue;
    }

    public final <F> Equivalence<F> onResultOf(g<F, ? extends T> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) ? new FunctionalEquivalence(gVar, this) : (Equivalence) invokeL.objValue;
    }

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new PairwiseEquivalence(this) : (Equivalence) invokeV.objValue;
    }

    public final <S extends T> Wrapper<S> wrap(S s) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, s)) == null) ? new Wrapper<>(this, s, null) : (Wrapper) invokeL.objValue;
    }
}
