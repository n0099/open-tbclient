package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.InterTypeDeclaration;
/* loaded from: classes9.dex */
public class InterTypeDeclarationImpl implements InterTypeDeclaration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AjType<?> declaringType;
    public int modifiers;
    public AjType<?> targetType;
    public String targetTypeName;

    public InterTypeDeclarationImpl(AjType<?> ajType, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, str, Integer.valueOf(i)};
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
        this.targetTypeName = str;
        this.modifiers = i;
        try {
            this.targetType = (AjType) StringToType.stringToType(str, ajType.getJavaClass());
        } catch (ClassNotFoundException unused) {
        }
    }

    public InterTypeDeclarationImpl(AjType<?> ajType, AjType<?> ajType2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ajType, ajType2, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.declaringType = ajType;
        this.targetType = ajType2;
        this.targetTypeName = ajType2.getName();
        this.modifiers = i;
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public AjType<?> getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.declaringType;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public int getModifiers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.modifiers;
        }
        return invokeV.intValue;
    }

    @Override // org.aspectj.lang.reflect.InterTypeDeclaration
    public AjType<?> getTargetType() throws ClassNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AjType<?> ajType = this.targetType;
            if (ajType != null) {
                return ajType;
            }
            throw new ClassNotFoundException(this.targetTypeName);
        }
        return (AjType) invokeV.objValue;
    }
}
