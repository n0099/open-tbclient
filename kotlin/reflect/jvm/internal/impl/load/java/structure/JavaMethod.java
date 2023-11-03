package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
/* loaded from: classes2.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {
    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();

    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod javaMethod) {
            if (javaMethod.getAnnotationParameterDefaultValue() != null) {
                return true;
            }
            return false;
        }
    }
}
