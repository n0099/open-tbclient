package kotlin.reflect.jvm.internal.impl.load.kotlin;
/* loaded from: classes2.dex */
public interface JvmTypeFactory<T> {
    T boxType(T t);

    T createFromString(String str);

    T createObjectType(String str);

    T getJavaLangClassType();

    String toString(T t);
}
