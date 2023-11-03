package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum UBYTE uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class UnsignedType {
    public static final /* synthetic */ UnsignedType[] $VALUES;
    public static final UnsignedType UBYTE;
    public static final UnsignedType UINT;
    public static final UnsignedType ULONG;
    public static final UnsignedType USHORT;
    public final ClassId arrayClassId;
    public final ClassId classId;
    public final Name typeName;

    public static UnsignedType valueOf(String str) {
        return (UnsignedType) Enum.valueOf(UnsignedType.class, str);
    }

    public static UnsignedType[] values() {
        return (UnsignedType[]) $VALUES.clone();
    }

    static {
        ClassId fromString = ClassId.fromString("kotlin/UByte");
        Intrinsics.checkExpressionValueIsNotNull(fromString, "ClassId.fromString(\"kotlin/UByte\")");
        UnsignedType unsignedType = new UnsignedType("UBYTE", 0, fromString);
        UBYTE = unsignedType;
        ClassId fromString2 = ClassId.fromString("kotlin/UShort");
        Intrinsics.checkExpressionValueIsNotNull(fromString2, "ClassId.fromString(\"kotlin/UShort\")");
        UnsignedType unsignedType2 = new UnsignedType("USHORT", 1, fromString2);
        USHORT = unsignedType2;
        ClassId fromString3 = ClassId.fromString("kotlin/UInt");
        Intrinsics.checkExpressionValueIsNotNull(fromString3, "ClassId.fromString(\"kotlin/UInt\")");
        UnsignedType unsignedType3 = new UnsignedType("UINT", 2, fromString3);
        UINT = unsignedType3;
        ClassId fromString4 = ClassId.fromString("kotlin/ULong");
        Intrinsics.checkExpressionValueIsNotNull(fromString4, "ClassId.fromString(\"kotlin/ULong\")");
        UnsignedType unsignedType4 = new UnsignedType("ULONG", 3, fromString4);
        ULONG = unsignedType4;
        $VALUES = new UnsignedType[]{unsignedType, unsignedType2, unsignedType3, unsignedType4};
    }

    public UnsignedType(String str, int i, ClassId classId) {
        this.classId = classId;
        Name shortClassName = classId.getShortClassName();
        Intrinsics.checkExpressionValueIsNotNull(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        FqName packageFqName = this.classId.getPackageFqName();
        this.arrayClassId = new ClassId(packageFqName, Name.identifier(this.typeName.asString() + "Array"));
    }

    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public final Name getTypeName() {
        return this.typeName;
    }
}
