package org.aspectj.runtime.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.lang.reflect.MethodSignature;
/* loaded from: classes4.dex */
public class MethodSignatureImpl extends CodeSignatureImpl implements MethodSignature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Method method;
    public Class returnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MethodSignatureImpl(int i2, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
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
        this.returnType = cls2;
    }

    private Method search(Class cls, String str, Class[] clsArr, Set set) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, cls, str, clsArr, set)) == null) {
            if (cls == null) {
                return null;
            }
            if (!set.contains(cls)) {
                set.add(cls);
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                }
            }
            Method search = search(cls.getSuperclass(), str, clsArr, set);
            if (search != null) {
                return search;
            }
            Class<?>[] interfaces = cls.getInterfaces();
            if (interfaces != null) {
                for (Class<?> cls2 : interfaces) {
                    Method search2 = search(cls2, str, clsArr, set);
                    if (search2 != null) {
                        return search2;
                    }
                }
            }
            return null;
        }
        return (Method) invokeLLLL.objValue;
    }

    @Override // org.aspectj.runtime.reflect.SignatureImpl
    public String createToString(StringMaker stringMaker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, stringMaker)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(stringMaker.makeModifiersString(getModifiers()));
            if (stringMaker.includeArgs) {
                stringBuffer.append(stringMaker.makeTypeName(getReturnType()));
            }
            if (stringMaker.includeArgs) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(stringMaker.makePrimaryTypeName(getDeclaringType(), getDeclaringTypeName()));
            stringBuffer.append(".");
            stringBuffer.append(getName());
            stringMaker.addSignature(stringBuffer, getParameterTypes());
            stringMaker.addThrows(stringBuffer, getExceptionTypes());
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    @Override // org.aspectj.lang.reflect.MethodSignature
    public Method getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.method == null) {
                Class declaringType = getDeclaringType();
                try {
                    this.method = declaringType.getDeclaredMethod(getName(), getParameterTypes());
                } catch (NoSuchMethodException unused) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(declaringType);
                    this.method = search(declaringType, getName(), getParameterTypes(), hashSet);
                }
            }
            return this.method;
        }
        return (Method) invokeV.objValue;
    }

    @Override // org.aspectj.lang.reflect.MethodSignature
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
    public MethodSignatureImpl(String str) {
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
