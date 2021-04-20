package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;
@TypeQualifier(applicableTo = Number.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes7.dex */
public @interface Nonnegative {

    /* loaded from: classes7.dex */
    public static class Checker implements TypeQualifierValidator<Nonnegative> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnegative nonnegative, Object obj) {
            if (!(obj instanceof Number)) {
                return When.NEVER;
            }
            Number number = (Number) obj;
            boolean z = true;
            if (!(number instanceof Long) ? !(number instanceof Double) ? !(number instanceof Float) ? number.intValue() >= 0 : number.floatValue() >= 0.0f : number.doubleValue() >= 0.0d : number.longValue() >= 0) {
                z = false;
            }
            if (z) {
                return When.NEVER;
            }
            return When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}
