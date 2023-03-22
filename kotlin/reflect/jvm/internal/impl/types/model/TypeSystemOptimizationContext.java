package kotlin.reflect.jvm.internal.impl.types.model;
/* loaded from: classes9.dex */
public interface TypeSystemOptimizationContext {

    /* loaded from: classes9.dex */
    public static final class DefaultImpls {
        public static boolean identicalArguments(TypeSystemOptimizationContext typeSystemOptimizationContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            return false;
        }
    }

    boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2);
}
