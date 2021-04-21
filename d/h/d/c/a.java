package d.h.d.c;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? super T> f67257a;

    /* renamed from: b  reason: collision with root package name */
    public final Type f67258b;

    /* renamed from: c  reason: collision with root package name */
    public final int f67259c;

    public a() {
        Type d2 = d(a.class);
        this.f67258b = d2;
        this.f67257a = (Class<? super T>) C$Gson$Types.k(d2);
        this.f67259c = this.f67258b.hashCode();
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
        return this.f67257a;
    }

    public final Type e() {
        return this.f67258b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.f(this.f67258b, ((a) obj).f67258b);
    }

    public final int hashCode() {
        return this.f67259c;
    }

    public final String toString() {
        return C$Gson$Types.u(this.f67258b);
    }

    public a(Type type) {
        d.h.d.b.a.b(type);
        Type b2 = C$Gson$Types.b(type);
        this.f67258b = b2;
        this.f67257a = (Class<? super T>) C$Gson$Types.k(b2);
        this.f67259c = this.f67258b.hashCode();
    }
}
