package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import b.h.d.a.n;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
/* loaded from: classes11.dex */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final C endpoint;

    /* loaded from: classes11.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {
        public static /* synthetic */ Interceptable $ic;
        public static final AboveAll INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2028336968, "Lcom/google/common/collect/Cut$AboveAll;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2028336968, "Lcom/google/common/collect/Cut$AboveAll;");
                    return;
                }
            }
            INSTANCE = new AboveAll();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AboveAll() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Comparable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cut)) == null) ? cut == this ? 0 : 1 : invokeL.intValue;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sb) == null) {
                throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sb) == null) {
                sb.append("+∞)");
            }
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                throw new IllegalStateException("range unbounded on this side");
            }
            return (Comparable) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, discreteDomain)) == null) ? discreteDomain.maxValue() : (Comparable) invokeL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? System.identityHashCode(this) : invokeV.intValue;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> comparable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, comparable)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, discreteDomain)) == null) {
                throw new AssertionError();
            }
            return (Comparable) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "+∞" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                throw new AssertionError("this statement should be unreachable");
            }
            return (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                throw new IllegalStateException();
            }
            return (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, boundType, discreteDomain)) == null) {
                throw new AssertionError("this statement should be unreachable");
            }
            return (Cut) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, boundType, discreteDomain)) == null) {
                throw new IllegalStateException();
            }
            return (Cut) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AboveValue(C c2) {
            super(c2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Comparable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(c2);
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, discreteDomain)) == null) {
                C leastValueAbove = leastValueAbove(discreteDomain);
                return leastValueAbove != null ? Cut.belowValue(leastValueAbove) : Cut.aboveAll();
            }
            return (Cut) invokeL.objValue;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) ((Cut) obj));
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sb) == null) {
                sb.append('(');
                sb.append(this.endpoint);
            }
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sb) == null) {
                sb.append(this.endpoint);
                sb.append(']');
            }
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, discreteDomain)) == null) ? this.endpoint : (C) invokeL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ~this.endpoint.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c2)) == null) ? Range.compareOrThrow(this.endpoint, c2) < 0 : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, discreteDomain)) == null) ? discreteDomain.next(this.endpoint) : (C) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return "/" + this.endpoint + IStringUtil.WINDOWS_FOLDER_SEPARATOR;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? BoundType.OPEN : (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? BoundType.CLOSED : (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, boundType, discreteDomain)) == null) {
                int i2 = a.f64211a[boundType.ordinal()];
                if (i2 == 1) {
                    C next = discreteDomain.next(this.endpoint);
                    return next == null ? Cut.belowAll() : Cut.belowValue(next);
                } else if (i2 == 2) {
                    return this;
                } else {
                    throw new AssertionError();
                }
            }
            return (Cut) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, boundType, discreteDomain)) == null) {
                int i2 = a.f64211a[boundType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        C next = discreteDomain.next(this.endpoint);
                        return next == null ? Cut.aboveAll() : Cut.belowValue(next);
                    }
                    throw new AssertionError();
                }
                return this;
            }
            return (Cut) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {
        public static /* synthetic */ Interceptable $ic;
        public static final BelowAll INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1691945508, "Lcom/google/common/collect/Cut$BelowAll;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1691945508, "Lcom/google/common/collect/Cut$BelowAll;");
                    return;
                }
            }
            INSTANCE = new BelowAll();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BelowAll() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Comparable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, discreteDomain)) == null) {
                try {
                    return Cut.belowValue(discreteDomain.minValue());
                } catch (NoSuchElementException unused) {
                    return this;
                }
            }
            return (Cut) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public int compareTo(Cut<Comparable<?>> cut) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cut)) == null) ? cut == this ? 0 : -1 : invokeL.intValue;
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, sb) == null) {
                sb.append("(-∞");
            }
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, sb) == null) {
                throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                throw new IllegalStateException("range unbounded on this side");
            }
            return (Comparable) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, discreteDomain)) == null) {
                throw new AssertionError();
            }
            return (Comparable) invokeL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? System.identityHashCode(this) : invokeV.intValue;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> comparable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, comparable)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, discreteDomain)) == null) ? discreteDomain.minValue() : (Comparable) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "-∞" : (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                throw new IllegalStateException();
            }
            return (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                throw new AssertionError("this statement should be unreachable");
            }
            return (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, boundType, discreteDomain)) == null) {
                throw new IllegalStateException();
            }
            return (Cut) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, boundType, discreteDomain)) == null) {
                throw new AssertionError("this statement should be unreachable");
            }
            return (Cut) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BelowValue(C c2) {
            super(c2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Comparable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(c2);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) ((Cut) obj));
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb) == null) {
                sb.append('[');
                sb.append(this.endpoint);
            }
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sb) == null) {
                sb.append(this.endpoint);
                sb.append(')');
            }
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, discreteDomain)) == null) ? discreteDomain.previous(this.endpoint) : (C) invokeL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.endpoint.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c2)) == null) ? Range.compareOrThrow(this.endpoint, c2) <= 0 : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, discreteDomain)) == null) ? this.endpoint : (C) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return IStringUtil.WINDOWS_FOLDER_SEPARATOR + this.endpoint + "/";
            }
            return (String) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? BoundType.CLOSED : (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? BoundType.OPEN : (BoundType) invokeV.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, boundType, discreteDomain)) == null) {
                int i2 = a.f64211a[boundType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        C previous = discreteDomain.previous(this.endpoint);
                        return previous == null ? Cut.belowAll() : new AboveValue(previous);
                    }
                    throw new AssertionError();
                }
                return this;
            }
            return (Cut) invokeLL.objValue;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, boundType, discreteDomain)) == null) {
                int i2 = a.f64211a[boundType.ordinal()];
                if (i2 == 1) {
                    C previous = discreteDomain.previous(this.endpoint);
                    return previous == null ? Cut.aboveAll() : new AboveValue(previous);
                } else if (i2 == 2) {
                    return this;
                } else {
                    throw new AssertionError();
                }
            }
            return (Cut) invokeLL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64211a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1109918295, "Lcom/google/common/collect/Cut$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1109918295, "Lcom/google/common/collect/Cut$a;");
                    return;
                }
            }
            int[] iArr = new int[BoundType.values().length];
            f64211a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64211a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Cut(C c2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.endpoint = c2;
    }

    public static <C extends Comparable> Cut<C> aboveAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? AboveAll.INSTANCE : (Cut) invokeV.objValue;
    }

    public static <C extends Comparable> Cut<C> aboveValue(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2)) == null) ? new AboveValue(c2) : (Cut) invokeL.objValue;
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? BelowAll.INSTANCE : (Cut) invokeV.objValue;
    }

    public static <C extends Comparable> Cut<C> belowValue(C c2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c2)) == null) ? new BelowValue(c2) : (Cut) invokeL.objValue;
    }

    public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, discreteDomain)) == null) ? this : (Cut) invokeL.objValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Cut) ((Cut) obj));
    }

    public abstract void describeAsLowerBound(StringBuilder sb);

    public abstract void describeAsUpperBound(StringBuilder sb);

    public C endpoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.endpoint : (C) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof Cut) {
                try {
                    return compareTo((Cut) ((Cut) obj)) == 0;
                } catch (ClassCastException unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract C greatestValueBelow(DiscreteDomain<C> discreteDomain);

    public abstract int hashCode();

    public abstract boolean isLessThan(C c2);

    public abstract C leastValueAbove(DiscreteDomain<C> discreteDomain);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    public abstract Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    public int compareTo(Cut<C> cut) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cut)) == null) {
            if (cut == belowAll()) {
                return 1;
            }
            if (cut == aboveAll()) {
                return -1;
            }
            int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
            return compareOrThrow != 0 ? compareOrThrow : Booleans.c(this instanceof AboveValue, cut instanceof AboveValue);
        }
        return invokeL.intValue;
    }
}
