package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.reflect.PerClauseKind;
import org.aspectj.lang.reflect.TypePattern;
import org.aspectj.lang.reflect.TypePatternBasedPerClause;
/* loaded from: classes4.dex */
public class TypePatternBasedPerClauseImpl extends PerClauseImpl implements TypePatternBasedPerClause {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TypePattern typePattern;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypePatternBasedPerClauseImpl(PerClauseKind perClauseKind, String str) {
        super(perClauseKind);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {perClauseKind, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((PerClauseKind) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.typePattern = new TypePatternImpl(str);
    }

    @Override // org.aspectj.lang.reflect.TypePatternBasedPerClause
    public TypePattern getTypePattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.typePattern : (TypePattern) invokeV.objValue;
    }

    @Override // org.aspectj.internal.lang.reflect.PerClauseImpl
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "pertypewithin(" + this.typePattern.asString() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
