package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010.\u001a\u0006\u0012\u0002\b\u00030-¢\u0006\u0004\bN\u0010OJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0017¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b\"\u0010 \u001a\u0004\b!\u0010\u001eR\u001c\u0010#\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR\u001c\u0010%\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001a\u0004\b%\u0010\u001eR\u001c\u0010'\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b(\u0010 \u001a\u0004\b'\u0010\u001eR\u001c\u0010)\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b)\u0010\u001eR\u001c\u0010+\u001a\u00020\u00058V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b+\u0010\u001eR \u0010.\u001a\u0006\u0012\u0002\b\u00030-8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R \u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR \u00106\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00188V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u0018\u00109\u001a\u0004\u0018\u00010\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0012R*\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00138V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\b=\u0010 \u001a\u0004\b<\u0010\u0016R\u0018\u0010@\u001a\u0004\u0018\u00010\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0012R\"\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u00138V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010 \u001a\u0004\bB\u0010\u0016R\"\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00138V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\bG\u0010 \u001a\u0004\bF\u0010\u0016R\u001e\u0010M\u001a\u0004\u0018\u00010I8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\bL\u0010 \u001a\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "error", "()Ljava/lang/Void;", "", "hashCode", "()I", "value", "isInstance", "", "toString", "()Ljava/lang/String;", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "constructors", "isAbstract", "()Z", "isAbstract$annotations", "()V", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "Ljava/lang/Class;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/reflect/KCallable;", "getMembers", "members", "getNestedClasses", "nestedClasses", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance", "getQualifiedName", "qualifiedName", "getSealedSubclasses", "sealedSubclasses$annotations", "sealedSubclasses", "getSimpleName", "simpleName", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$annotations", "supertypes", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$annotations", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility$annotations", "visibility", "<init>", "(Ljava/lang/Class;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public final Class<?> jClass;

    public ClassReference(Class<?> cls) {
        this.jClass = cls;
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void sealedSubclasses$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void supertypes$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void typeParameters$annotations() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void visibility$annotations() {
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object obj) {
        return (obj instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw null;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KType> getSupertypes() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(Object obj) {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        throw null;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        throw null;
    }

    public String toString() {
        return getJClass().toString() + Reflection.REFLECTION_NOT_AVAILABLE;
    }
}
