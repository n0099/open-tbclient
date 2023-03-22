package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes9.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<PrimitiveType> NUMBER_TYPES;
    public final Name arrayTypeName;
    public final Name typeName;
    public FqName typeFqName = null;
    public FqName arrayTypeFqName = null;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType";
        if (i == 1 || i == 2) {
            objArr[1] = "getTypeFqName";
        } else if (i == 3) {
            objArr[1] = "getArrayTypeName";
        } else if (i == 4 || i == 5) {
            objArr[1] = "getArrayTypeFqName";
        } else {
            objArr[1] = "getTypeName";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    static {
        PrimitiveType primitiveType = DOUBLE;
        NUMBER_TYPES = Collections.unmodifiableSet(EnumSet.of(CHAR, BYTE, SHORT, INT, FLOAT, LONG, primitiveType));
    }

    PrimitiveType(String str) {
        this.typeName = Name.identifier(str);
        this.arrayTypeName = Name.identifier(str + "Array");
    }

    public FqName getArrayTypeFqName() {
        FqName fqName = this.arrayTypeFqName;
        if (fqName != null) {
            if (fqName == null) {
                $$$reportNull$$$0(4);
            }
            return fqName;
        }
        FqName child = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.arrayTypeName);
        this.arrayTypeFqName = child;
        if (child == null) {
            $$$reportNull$$$0(5);
        }
        return child;
    }

    public Name getArrayTypeName() {
        Name name = this.arrayTypeName;
        if (name == null) {
            $$$reportNull$$$0(3);
        }
        return name;
    }

    public FqName getTypeFqName() {
        FqName fqName = this.typeFqName;
        if (fqName != null) {
            if (fqName == null) {
                $$$reportNull$$$0(1);
            }
            return fqName;
        }
        FqName child = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName);
        this.typeFqName = child;
        if (child == null) {
            $$$reportNull$$$0(2);
        }
        return child;
    }

    public Name getTypeName() {
        Name name = this.typeName;
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        return name;
    }
}
