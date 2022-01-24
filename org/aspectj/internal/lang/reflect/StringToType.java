package org.aspectj.internal.lang.reflect;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringTokenizer;
import org.aspectj.lang.reflect.AjTypeSystem;
/* loaded from: classes5.dex */
public class StringToType {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public StringToType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Type[] commaSeparatedListToTypeArray(String str, Class cls) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, cls)) == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            Type[] typeArr = new Type[stringTokenizer.countTokens()];
            int i2 = 0;
            while (stringTokenizer.hasMoreTokens()) {
                typeArr[i2] = stringToType(stringTokenizer.nextToken().trim(), cls);
                i2++;
            }
            return typeArr;
        }
        return (Type[]) invokeLL.objValue;
    }

    public static Type makeParameterizedType(String str, Class cls) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cls)) == null) {
            int indexOf = str.indexOf(60);
            return new ParameterizedType(commaSeparatedListToTypeArray(str.substring(indexOf + 1, str.lastIndexOf(62)), cls), Class.forName(str.substring(0, indexOf), false, cls.getClassLoader())) { // from class: org.aspectj.internal.lang.reflect.StringToType.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Class val$baseClass;
                public final /* synthetic */ Type[] val$typeParams;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$typeParams = r6;
                    this.val$baseClass = r7;
                }

                @Override // java.lang.reflect.ParameterizedType
                public Type[] getActualTypeArguments() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$typeParams : (Type[]) invokeV.objValue;
                }

                @Override // java.lang.reflect.ParameterizedType
                public Type getOwnerType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$baseClass.getEnclosingClass() : (Type) invokeV.objValue;
                }

                @Override // java.lang.reflect.ParameterizedType
                public Type getRawType() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.val$baseClass : (Type) invokeV.objValue;
                }
            };
        }
        return (Type) invokeLL.objValue;
    }

    public static Type stringToType(String str, Class cls) throws ClassNotFoundException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, cls)) == null) {
            try {
                if (str.indexOf("<") == -1) {
                    return AjTypeSystem.getAjType(Class.forName(str, false, cls.getClassLoader()));
                }
                return makeParameterizedType(str, cls);
            } catch (ClassNotFoundException unused) {
                TypeVariable[] typeParameters = cls.getTypeParameters();
                for (int i2 = 0; i2 < typeParameters.length; i2++) {
                    if (typeParameters[i2].getName().equals(str)) {
                        return typeParameters[i2];
                    }
                }
                throw new ClassNotFoundException(str);
            }
        }
        return (Type) invokeLL.objValue;
    }
}
