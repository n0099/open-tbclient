package org.aspectj.runtime.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import org.aspectj.lang.reflect.FieldSignature;
/* loaded from: classes9.dex */
public class FieldSignatureImpl extends MemberSignatureImpl implements FieldSignature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Field field;
    public Class fieldType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldSignatureImpl(int i2, String str, Class cls, Class cls2) {
        super(i2, str, cls);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, cls, cls2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (Class) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fieldType = cls2;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, stringMaker)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stringMaker.makeModifiersString(getModifiers()));
            if (stringMaker.includeArgs) {
                stringBuffer.append(stringMaker.makeTypeName(getFieldType()));
            }
            if (stringMaker.includeArgs) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
            stringBuffer.append(".");
            stringBuffer.append(getName());
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.FieldSignature
    public Field getField() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.field == null) {
                try {
                    this.field = getDeclaringType().getDeclaredField(getName());
                } catch (Exception unused) {
                }
            }
            return this.field;
        }
        return (Field) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.FieldSignature
    public Class getFieldType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.fieldType == null) {
                this.fieldType = extractType(3);
            }
            return this.fieldType;
        }
        return (Class) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldSignatureImpl(String str) {
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
    }
}
