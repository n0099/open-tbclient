package javax.annotation;

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
/* loaded from: classes5.dex */
public @interface MatchesPattern {
    int flags() default 0;

    @RegEx
    String value();

    /* loaded from: classes5.dex */
    public static class Checker implements TypeQualifierValidator<MatchesPattern> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(MatchesPattern matchesPattern, Object obj) {
            return Pattern.compile(matchesPattern.value(), matchesPattern.flags()).matcher((String) obj).matches() ? When.ALWAYS : When.NEVER;
        }
    }
}
