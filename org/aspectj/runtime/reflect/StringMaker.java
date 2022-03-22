package org.aspectj.runtime.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Modifier;
/* loaded from: classes8.dex */
public class StringMaker {
    public static /* synthetic */ Interceptable $ic;
    public static StringMaker longStringMaker;
    public static StringMaker middleStringMaker;
    public static StringMaker shortStringMaker;
    public transient /* synthetic */ FieldHolder $fh;
    public int cacheOffset;
    public boolean includeArgs;
    public boolean includeEnclosingPoint;
    public boolean includeJoinPointTypeName;
    public boolean includeModifiers;
    public boolean includeThrows;
    public boolean shortKindName;
    public boolean shortPrimaryTypeNames;
    public boolean shortTypeNames;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1878984293, "Lorg/aspectj/runtime/reflect/StringMaker;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1878984293, "Lorg/aspectj/runtime/reflect/StringMaker;");
                return;
            }
        }
        StringMaker stringMaker = new StringMaker();
        shortStringMaker = stringMaker;
        stringMaker.shortTypeNames = true;
        stringMaker.includeArgs = false;
        stringMaker.includeThrows = false;
        stringMaker.includeModifiers = false;
        stringMaker.shortPrimaryTypeNames = true;
        stringMaker.includeJoinPointTypeName = false;
        stringMaker.includeEnclosingPoint = false;
        stringMaker.cacheOffset = 0;
        StringMaker stringMaker2 = new StringMaker();
        middleStringMaker = stringMaker2;
        stringMaker2.shortTypeNames = true;
        stringMaker2.includeArgs = true;
        stringMaker2.includeThrows = false;
        stringMaker2.includeModifiers = false;
        stringMaker2.shortPrimaryTypeNames = false;
        shortStringMaker.cacheOffset = 1;
        StringMaker stringMaker3 = new StringMaker();
        longStringMaker = stringMaker3;
        stringMaker3.shortTypeNames = false;
        stringMaker3.includeArgs = true;
        stringMaker3.includeThrows = false;
        stringMaker3.includeModifiers = true;
        stringMaker3.shortPrimaryTypeNames = false;
        stringMaker3.shortKindName = false;
        stringMaker3.cacheOffset = 2;
    }

    public StringMaker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.shortTypeNames = true;
        this.includeArgs = true;
        this.includeThrows = false;
        this.includeModifiers = false;
        this.shortPrimaryTypeNames = false;
        this.includeJoinPointTypeName = true;
        this.includeEnclosingPoint = true;
        this.shortKindName = true;
    }

    public void addSignature(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, stringBuffer, clsArr) == null) || clsArr == null) {
            return;
        }
        if (!this.includeArgs) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        addTypeNames(stringBuffer, clsArr);
        stringBuffer.append(SmallTailInfo.EMOTION_SUFFIX);
    }

    public void addThrows(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, stringBuffer, clsArr) == null) || !this.includeThrows || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        addTypeNames(stringBuffer, clsArr);
    }

    public void addTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, stringBuffer, clsArr) == null) {
            for (int i = 0; i < clsArr.length; i++) {
                if (i > 0) {
                    stringBuffer.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                stringBuffer.append(makeTypeName(clsArr[i]));
            }
        }
    }

    public String makeKindName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(45);
            return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public String makeModifiersString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.includeModifiers) {
                String modifier = Modifier.toString(i);
                if (modifier.length() == 0) {
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(modifier);
                stringBuffer.append(" ");
                return stringBuffer.toString();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public String makePrimaryTypeName(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cls, str)) == null) ? makeTypeName(cls, str, this.shortPrimaryTypeNames) : (String) invokeLL.objValue;
    }

    public String makeTypeName(Class cls, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, cls, str, z)) == null) {
            if (cls == null) {
                return "ANONYMOUS";
            }
            if (!cls.isArray()) {
                if (z) {
                    return stripPackageName(str).replace('$', IStringUtil.EXTENSION_SEPARATOR);
                }
                return str.replace('$', IStringUtil.EXTENSION_SEPARATOR);
            }
            Class<?> componentType = cls.getComponentType();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(makeTypeName(componentType, componentType.getName(), z));
            stringBuffer.append("[]");
            return stringBuffer.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public String stripPackageName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public String makeTypeName(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) ? makeTypeName(cls, cls.getName(), this.shortTypeNames) : (String) invokeL.objValue;
    }
}
