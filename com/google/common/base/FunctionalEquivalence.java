package com.google.common.base;

import b.i.d.a.g;
import b.i.d.a.k;
import b.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final g<F, ? extends T> function;
    public final Equivalence<T> resultEquivalence;

    public FunctionalEquivalence(g<F, ? extends T> gVar, Equivalence<T> equivalence) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, equivalence};
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
        n.p(equivalence);
        this.resultEquivalence = equivalence;
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F f2, F f3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f2, f3)) == null) ? this.resultEquivalence.equivalent(this.function.apply(f2), this.function.apply(f3)) : invokeLL.booleanValue;
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F f2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) ? this.resultEquivalence.hash(this.function.apply(f2)) : invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FunctionalEquivalence) {
                FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
                return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? k.b(this.function, this.resultEquivalence) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.resultEquivalence + ".onResultOf(" + this.function + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
