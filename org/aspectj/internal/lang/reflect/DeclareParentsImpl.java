package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareParents;
import org.aspectj.lang.reflect.TypePattern;
/* loaded from: classes8.dex */
public class DeclareParentsImpl implements DeclareParents {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AjType declaringType;
    public String firstMissingTypeName;
    public boolean isExtends;
    public Type[] parents;
    public boolean parentsError;
    public String parentsString;
    public TypePattern targetTypesPattern;

    public DeclareParentsImpl(String str, String str2, boolean z, AjType ajType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z), ajType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parentsError = false;
        this.targetTypesPattern = new TypePatternImpl(str);
        this.isExtends = z;
        this.declaringType = ajType;
        this.parentsString = str2;
        try {
            this.parents = StringToType.commaSeparatedListToTypeArray(str2, ajType.getJavaClass());
        } catch (ClassNotFoundException e) {
            this.parentsError = true;
            this.firstMissingTypeName = e.getMessage();
        }
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public AjType getDeclaringType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.declaringType;
        }
        return (AjType) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public Type[] getParentTypes() throws ClassNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!this.parentsError) {
                return this.parents;
            }
            throw new ClassNotFoundException(this.firstMissingTypeName);
        }
        return (Type[]) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public TypePattern getTargetTypesPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.targetTypesPattern;
        }
        return (TypePattern) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public boolean isExtends() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isExtends;
        }
        return invokeV.booleanValue;
    }

    @Override // org.aspectj.lang.reflect.DeclareParents
    public boolean isImplements() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return !this.isExtends;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("declare parents : ");
            stringBuffer.append(getTargetTypesPattern().asString());
            if (isExtends()) {
                str = " extends ";
            } else {
                str = " implements ";
            }
            stringBuffer.append(str);
            stringBuffer.append(this.parentsString);
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
