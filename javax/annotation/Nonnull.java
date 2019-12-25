package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface Nonnull {
    When when() default When.ALWAYS;

    /* loaded from: classes4.dex */
    public static class Checker implements TypeQualifierValidator<Nonnull> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnull nonnull, Object obj) {
            return obj == null ? When.NEVER : When.ALWAYS;
        }
    }
}
