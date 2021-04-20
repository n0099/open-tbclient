package d.n.a;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.ProtoAdapter;
import d.n.a.g;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public final class e<E extends g> extends ProtoAdapter<E> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<E> f67318a;

    /* renamed from: b  reason: collision with root package name */
    public Method f67319b;

    public e(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        this.f67318a = cls;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: a */
    public E decode(c cVar) throws IOException {
        int l = cVar.l();
        try {
            E e2 = (E) d().invoke(null, Integer.valueOf(l));
            if (e2 != null) {
                return e2;
            }
            throw new ProtoAdapter.EnumConstantNotFoundException(l, this.f67318a);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: b */
    public void encode(d dVar, E e2) throws IOException {
        dVar.q(e2.getValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: c */
    public int encodedSize(E e2) {
        return d.i(e2.getValue());
    }

    public final Method d() {
        Method method = this.f67319b;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.f67318a.getMethod("fromValue", Integer.TYPE);
            this.f67319b = method2;
            return method2;
        } catch (NoSuchMethodException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).f67318a == this.f67318a;
    }

    public int hashCode() {
        return this.f67318a.hashCode();
    }
}
