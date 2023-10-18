package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
/* loaded from: classes10.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public abstract Member getMember();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        Member member = getMember();
        if (member != null) {
            return (AnnotatedElement) member;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name identifier;
        String name = getMember().getName();
        if (name == null || (identifier = Name.identifier(name)) == null) {
            Name name2 = SpecialNames.NO_NAME_PROVIDED;
            Intrinsics.checkExpressionValueIsNotNull(name2, "SpecialNames.NO_NAME_PROVIDED");
            return name2;
        }
        return identifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ReflectJavaMember) && Intrinsics.areEqual(getMember(), ((ReflectJavaMember) obj).getMember())) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    public final List<JavaValueParameter> getValueParameters(Type[] typeArr, Annotation[][] annotationArr, boolean z) {
        int i;
        String str;
        boolean z2;
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> loadParameterNames = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (loadParameterNames != null) {
            i = loadParameterNames.size() - typeArr.length;
        } else {
            i = 0;
        }
        int length = typeArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ReflectJavaType create = ReflectJavaType.Factory.create(typeArr[i2]);
            if (loadParameterNames != null) {
                str = (String) CollectionsKt___CollectionsKt.getOrNull(loadParameterNames, i2 + i);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + i + " (name=" + getName() + " type=" + create + ") in " + loadParameterNames + "@ReflectJavaMember").toString());
                }
            } else {
                str = null;
            }
            if (z && i2 == ArraysKt___ArraysKt.getLastIndex(typeArr)) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new ReflectJavaValueParameter(create, annotationArr[i2], str, z2));
        }
        return arrayList;
    }
}
