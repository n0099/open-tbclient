package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclarePrecedence;
import org.aspectj.lang.reflect.TypePattern;
/* loaded from: classes4.dex */
public class DeclarePrecedenceImpl implements DeclarePrecedence {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AjType<?> declaringType;
    public TypePattern[] precedenceList;
    public String precedenceString;

    public DeclarePrecedenceImpl(String str, AjType ajType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ajType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.declaringType = ajType;
        this.precedenceString = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str.startsWith("(") ? str.substring(1, str.length() - 1) : str, ",");
        this.precedenceList = new TypePattern[stringTokenizer.countTokens()];
        int i4 = 0;
        while (true) {
            TypePattern[] typePatternArr = this.precedenceList;
            if (i4 >= typePatternArr.length) {
                return;
            }
            typePatternArr[i4] = new TypePatternImpl(stringTokenizer.nextToken().trim());
            i4++;
        }
    }

    @Override // org.aspectj.lang.reflect.DeclarePrecedence
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.declaringType : (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclarePrecedence
    public TypePattern[] getPrecedenceOrder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.precedenceList : (TypePattern[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "declare precedence : " + this.precedenceString;
        }
        return (String) invokeV.objValue;
    }
}
