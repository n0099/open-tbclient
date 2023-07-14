package kotlin.reflect.jvm.internal.impl.types.model;
/* loaded from: classes2.dex */
public interface TypeSystemOptimizationContext {

    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean identicalArguments(TypeSystemOptimizationContext typeSystemOptimizationContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            return false;
        }
    }

    boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2);
}
