package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory Factory = new Factory(null);
    public final Name name;

    /* loaded from: classes2.dex */
    public static final class Factory {
        public Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReflectJavaAnnotationArgument create(Object obj, Name name) {
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(obj.getClass())) {
                return new ReflectJavaEnumValueAnnotationArgument(name, (Enum) obj);
            }
            if (obj instanceof Annotation) {
                return new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) obj);
            }
            if (obj instanceof Object[]) {
                return new ReflectJavaArrayAnnotationArgument(name, (Object[]) obj);
            }
            if (obj instanceof Class) {
                return new ReflectJavaClassObjectAnnotationArgument(name, (Class) obj);
            }
            return new ReflectJavaLiteralAnnotationArgument(name, obj);
        }
    }

    public ReflectJavaAnnotationArgument(Name name) {
        this.name = name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument
    public Name getName() {
        return this.name;
    }
}
