package kotlin.reflect.jvm.internal.impl.descriptors;
/* loaded from: classes10.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = new SourceFile() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.1
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceFile
        public String getName() {
            return null;
        }
    };

    String getName();
}
