package kotlin.reflect.jvm.internal.impl.load.java.structure;
/* loaded from: classes10.dex */
public interface JavaField extends JavaMember {
    boolean getHasConstantNotNullInitializer();

    JavaType getType();

    boolean isEnumEntry();
}
