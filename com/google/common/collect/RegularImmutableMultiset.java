package com.google.common.collect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.primitives.Ints;
import d.f.d.c.s0;
import d.f.d.c.v0;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static /* synthetic */ Interceptable $ic;
    public static final RegularImmutableMultiset<Object> EMPTY;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient v0<E> contents;
    public transient ImmutableSet<E> elementSet;
    public final transient int size;

    /* loaded from: classes7.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RegularImmutableMultiset this$0;

        public ElementSet(RegularImmutableMultiset regularImmutableMultiset) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {regularImmutableMultiset};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = regularImmutableMultiset;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.this$0.contains(obj) : invokeL.booleanValue;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.this$0.contents.i(i2) : (E) invokeI.objValue;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.contents.C() : invokeV.intValue;
        }

        public /* synthetic */ ElementSet(RegularImmutableMultiset regularImmutableMultiset, a aVar) {
            this(regularImmutableMultiset);
        }
    }

    /* loaded from: classes7.dex */
    public static class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final int[] counts;
        public final Object[] elements;

        public SerializedForm(s0<?> s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int size = s0Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i4 = 0;
            for (s0.a<?> aVar : s0Var.entrySet()) {
                this.elements[i4] = aVar.getElement();
                this.counts[i4] = aVar.getCount();
                i4++;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableMultiset$b */
        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.objValue;
            }
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i2 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i2 < objArr.length) {
                    bVar.j(objArr[i2], this.counts[i2]);
                    i2++;
                } else {
                    return bVar.k();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-504046337, "Lcom/google/common/collect/RegularImmutableMultiset;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-504046337, "Lcom/google/common/collect/RegularImmutableMultiset;");
                return;
            }
        }
        EMPTY = new RegularImmutableMultiset<>(v0.b());
    }

    public RegularImmutableMultiset(v0<E> v0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v0Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.contents = v0Var;
        long j = 0;
        for (int i4 = 0; i4 < v0Var.C(); i4++) {
            j += v0Var.k(i4);
        }
        this.size = Ints.j(j);
    }

    @Override // com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public int count(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this.contents.f(obj) : invokeL.intValue;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public s0.a<E> getEntry(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.contents.g(i2) : (s0.a) invokeI.objValue;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.f.d.c.s0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.size : invokeV.intValue;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultiset, d.f.d.c.s0
    public ImmutableSet<E> elementSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ImmutableSet<E> immutableSet = this.elementSet;
            if (immutableSet == null) {
                ElementSet elementSet = new ElementSet(this, null);
                this.elementSet = elementSet;
                return elementSet;
            }
            return immutableSet;
        }
        return (ImmutableSet) invokeV.objValue;
    }
}
