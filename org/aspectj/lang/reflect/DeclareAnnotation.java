package org.aspectj.lang.reflect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Annotation;
/* loaded from: classes9.dex */
public interface DeclareAnnotation {
    Annotation getAnnotation();

    String getAnnotationAsText();

    AjType<?> getDeclaringType();

    Kind getKind();

    SignaturePattern getSignaturePattern();

    TypePattern getTypePattern();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Kind {
        public static final /* synthetic */ Kind[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Kind Constructor;
        public static final Kind Field;
        public static final Kind Method;
        public static final Kind Type;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-143525955, "Lorg/aspectj/lang/reflect/DeclareAnnotation$Kind;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-143525955, "Lorg/aspectj/lang/reflect/DeclareAnnotation$Kind;");
                    return;
                }
            }
            Field = new Kind("Field", 0);
            Method = new Kind("Method", 1);
            Constructor = new Kind("Constructor", 2);
            Kind kind = new Kind("Type", 3);
            Type = kind;
            $VALUES = new Kind[]{Field, Method, Constructor, kind};
        }

        public Kind(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Kind valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Kind) Enum.valueOf(Kind.class, str);
            }
            return (Kind) invokeL.objValue;
        }

        public static Kind[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Kind[]) $VALUES.clone();
            }
            return (Kind[]) invokeV.objValue;
        }
    }
}
