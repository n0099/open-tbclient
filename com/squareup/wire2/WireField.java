package com.squareup.wire2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface WireField {
    String adapter();

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class Label {
        public static final /* synthetic */ Label[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Label ONE_OF;
        public static final Label OPTIONAL;
        public static final Label PACKED;
        public static final Label REPEATED;
        public static final Label REQUIRED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1007575883, "Lcom/squareup/wire2/WireField$Label;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1007575883, "Lcom/squareup/wire2/WireField$Label;");
                    return;
                }
            }
            REQUIRED = new Label("REQUIRED", 0);
            OPTIONAL = new Label("OPTIONAL", 1);
            REPEATED = new Label("REPEATED", 2);
            ONE_OF = new Label("ONE_OF", 3);
            Label label = new Label("PACKED", 4);
            PACKED = label;
            $VALUES = new Label[]{REQUIRED, OPTIONAL, REPEATED, ONE_OF, label};
        }

        public Label(String str, int i) {
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

        public static Label valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (Label) Enum.valueOf(Label.class, str);
            }
            return (Label) invokeL.objValue;
        }

        public static Label[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (Label[]) $VALUES.clone();
            }
            return (Label[]) invokeV.objValue;
        }

        public boolean isOneOf() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this == ONE_OF) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isPacked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this == PACKED) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isRepeated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this != REPEATED && this != PACKED) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }
}
