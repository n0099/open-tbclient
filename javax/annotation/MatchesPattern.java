package javax.annotation;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;
@TypeQualifier(applicableTo = String.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes10.dex */
public @interface MatchesPattern {

    /* loaded from: classes10.dex */
    public static class Checker implements TypeQualifierValidator<MatchesPattern> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Checker() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(MatchesPattern matchesPattern, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matchesPattern, obj)) == null) {
                if (Pattern.compile(matchesPattern.value(), matchesPattern.flags()).matcher((String) obj).matches()) {
                    return When.ALWAYS;
                }
                return When.NEVER;
            }
            return (When) invokeLL.objValue;
        }
    }

    int flags() default 0;

    @RegEx
    String value();
}
