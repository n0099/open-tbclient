package kotlin.reflect.jvm.internal.impl.load.java.descriptors;
/* loaded from: classes9.dex */
public final class StringDefaultValue extends AnnotationDefaultValue {
    public final String value;

    public StringDefaultValue(String str) {
        super(null);
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
