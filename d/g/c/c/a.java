package d.g.c.c;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? super T> f66116a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f66117b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66118c;

    public a() {
        Type d2 = d(a.class);
        this.f66117b = d2;
        this.f66116a = (Class<? super T>) C$Gson$Types.k(d2);
        this.f66118c = this.f66117b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    public static Type d(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C$Gson$Types.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> c() {
        return this.f66116a;
    }

    public final Type e() {
        return this.f66117b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.f(this.f66117b, ((a) obj).f66117b);
    }

    public final int hashCode() {
        return this.f66118c;
    }

    public final String toString() {
        return C$Gson$Types.u(this.f66117b);
    }

    public a(Type type) {
        d.g.c.b.a.b(type);
        Type b2 = C$Gson$Types.b(type);
        this.f66117b = b2;
        this.f66116a = (Class<? super T>) C$Gson$Types.k(b2);
        this.f66118c = this.f66117b.hashCode();
    }
}
