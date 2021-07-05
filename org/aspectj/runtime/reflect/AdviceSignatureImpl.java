package org.aspectj.runtime.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AdviceSignature;
/* loaded from: classes10.dex */
public class AdviceSignatureImpl extends CodeSignatureImpl implements AdviceSignature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method adviceMethod;
    public Class returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdviceSignatureImpl(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i2, str, cls, clsArr, strArr, clsArr2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), str, cls, clsArr, strArr, clsArr2, cls2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2], (Class[]) objArr2[3], (String[]) objArr2[4], (Class[]) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adviceMethod = null;
        this.returnType = cls2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String toAdviceName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (str.indexOf(36) == -1) {
                return str;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, "$");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.startsWith("before") || nextToken.startsWith("after") || nextToken.startsWith("around")) {
                    return nextToken;
                }
                while (stringTokenizer.hasMoreTokens()) {
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, stringMaker)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringMaker.includeArgs) {
                stringBuffer.append(stringMaker.makeTypeName(getReturnType()));
            }
            if (stringMaker.includeArgs) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
            stringBuffer.append(".");
            stringBuffer.append(toAdviceName(getName()));
            stringMaker.addSignature(stringBuffer, getParameterTypes());
            stringMaker.addThrows(stringBuffer, getExceptionTypes());
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.AdviceSignature
    public Method getAdvice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.adviceMethod == null) {
                try {
                    this.adviceMethod = getDeclaringType().getDeclaredMethod(getName(), getParameterTypes());
                } catch (Exception unused) {
                }
            }
            return this.adviceMethod;
        }
        return (Method) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.AdviceSignature
    public Class getReturnType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.returnType == null) {
                this.returnType = extractType(6);
            }
            return this.returnType;
        }
        return (Class) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdviceSignatureImpl(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.adviceMethod = null;
    }
}
