package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
/* loaded from: classes9.dex */
public abstract class JvmType {

    /* loaded from: classes9.dex */
    public static final class Array extends JvmType {
        public final JvmType elementType;

        public Array(JvmType jvmType) {
            super(null);
            this.elementType = jvmType;
        }

        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Object extends JvmType {
        public final String internalName;

        public Object(String str) {
            super(null);
            this.internalName = str;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    /* loaded from: classes9.dex */
    public static final class Primitive extends JvmType {
        public final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.jvmPrimitiveType = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    public JvmType() {
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    public /* synthetic */ JvmType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
