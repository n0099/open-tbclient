package javax.annotation.meta;

import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;
/* loaded from: classes3.dex */
public interface TypeQualifierValidator<A extends Annotation> {
    @Nonnull
    When forConstantValue(@Nonnull A a, Object obj);
}
