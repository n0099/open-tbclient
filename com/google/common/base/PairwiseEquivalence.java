package com.google.common.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Equivalence<? super T> elementEquivalence;

    public PairwiseEquivalence(Equivalence<? super T> equivalence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {equivalence};
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
        this.elementEquivalence = equivalence;
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ boolean doEquivalent(Object obj, Object obj2) {
        return doEquivalent((Iterable) ((Iterable) obj), (Iterable) ((Iterable) obj2));
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ int doHash(Object obj) {
        return doHash((Iterable) ((Iterable) obj));
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj instanceof PairwiseEquivalence) {
                return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.elementEquivalence.hashCode() ^ 1185147655 : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.elementEquivalence + ".pairwise()";
        }
        return (String) invokeV.objValue;
    }

    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iterable, iterable2)) == null) {
            Iterator<T> it = iterable.iterator();
            Iterator<T> it2 = iterable2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                    return false;
                }
            }
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public int doHash(Iterable<T> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iterable)) == null) {
            int i2 = 78721;
            for (T t : iterable) {
                i2 = (i2 * 24943) + this.elementEquivalence.hash(t);
            }
            return i2;
        }
        return invokeL.intValue;
    }
}
