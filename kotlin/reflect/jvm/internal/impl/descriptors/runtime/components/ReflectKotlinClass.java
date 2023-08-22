package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes2.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = new Factory(null);
    public final KotlinClassHeader classHeader;
    public final Class<?> klass;

    /* loaded from: classes2.dex */
    public static final class Factory {
        public Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReflectKotlinClass create(Class<?> cls) {
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, null);
        }
    }

    public ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, byte[] bArr) {
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, annotationVisitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor memberVisitor, byte[] bArr) {
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, memberVisitor);
    }

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ReflectKotlinClass) && Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) obj).klass)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        String name = this.klass.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "klass.name");
        sb.append(StringsKt__StringsJVMKt.replace$default(name, (char) IStringUtil.EXTENSION_SEPARATOR, (char) WebvttCueParser.CHAR_SLASH, false, 4, (Object) null));
        sb.append(".class");
        return sb.toString();
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return ReflectKotlinClass.class.getName() + ": " + this.klass;
    }
}
