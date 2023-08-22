package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
/* loaded from: classes2.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();

    /* loaded from: classes2.dex */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        public final ReflectJavaElement javaElement;

        public RuntimeSourceElement(ReflectJavaElement reflectJavaElement) {
            this.javaElement = reflectJavaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            Intrinsics.checkExpressionValueIsNotNull(sourceFile, "SourceFile.NO_SOURCE_FILE");
            return sourceFile;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement
        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public String toString() {
            return RuntimeSourceElement.class.getName() + ": " + getJavaElement().toString();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory
    public JavaSourceElement source(JavaElement javaElement) {
        return new RuntimeSourceElement((ReflectJavaElement) javaElement);
    }
}
