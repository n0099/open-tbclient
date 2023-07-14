package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public abstract class JvmMemberSignature {
    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    /* loaded from: classes2.dex */
    public static final class Field extends JvmMemberSignature {
        public final String desc;
        public final String name;

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Field) {
                    Field field = (Field) obj;
                    return Intrinsics.areEqual(getName(), field.getName()) && Intrinsics.areEqual(getDesc(), field.getDesc());
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String name = getName();
            int hashCode = (name != null ? name.hashCode() : 0) * 31;
            String desc = getDesc();
            return hashCode + (desc != null ? desc.hashCode() : 0);
        }

        public Field(String str, String str2) {
            super(null);
            this.name = str;
            this.desc = str2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Method extends JvmMemberSignature {
        public final String desc;
        public final String name;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Method) {
                    Method method = (Method) obj;
                    return Intrinsics.areEqual(getName(), method.getName()) && Intrinsics.areEqual(getDesc(), method.getDesc());
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            String name = getName();
            int hashCode = (name != null ? name.hashCode() : 0) * 31;
            String desc = getDesc();
            return hashCode + (desc != null ? desc.hashCode() : 0);
        }

        public Method(String str, String str2) {
            super(null);
            this.name = str;
            this.desc = str2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }
    }

    public JvmMemberSignature() {
    }

    public final String toString() {
        return asString();
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
