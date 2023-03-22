package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* loaded from: classes9.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    public final JavaClassifier classifier;
    public final Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName fqName) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaClassifierType(Type type) {
        JavaClassifier reflectJavaClass;
        this.reflectType = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            reflectJavaClass = new ReflectJavaTypeParameter((TypeVariable) reflectType);
        } else if (reflectType instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            if (rawType != null) {
                reflectJavaClass = new ReflectJavaClass((Class) rawType);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
            }
        } else {
            throw new IllegalStateException("Not a classifier type (" + reflectType.getClass() + "): " + reflectType);
        }
        this.classifier = reflectJavaClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public List<JavaType> getTypeArguments() {
        List<Type> parameterizedTypeArguments = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        for (Type type : parameterizedTypeArguments) {
            arrayList.add(factory.create(type));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        boolean z;
        Type reflectType = getReflectType();
        if (!(reflectType instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
        Intrinsics.checkExpressionValueIsNotNull(typeParameters, "getTypeParameters()");
        if (typeParameters.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!(!z)) {
            return false;
        }
        return true;
    }
}
