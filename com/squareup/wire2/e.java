package com.squareup.wire2;

import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.g;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e<E extends g> extends ProtoAdapter<E> {
    private Method npu;
    private final Class<E> type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Class<E> cls) {
        super(FieldEncoding.VARINT, cls);
        this.type = cls;
    }

    private Method dGv() {
        Method method = this.npu;
        if (method != null) {
            return method;
        }
        try {
            Method method2 = this.type.getMethod("fromValue", Integer.TYPE);
            this.npu = method2;
            return method2;
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: a */
    public int encodedSize(E e) {
        return d.varint32Size(e.getValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: a */
    public void encode(d dVar, E e) throws IOException {
        dVar.writeVarint32(e.getValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.squareup.wire2.ProtoAdapter
    /* renamed from: k */
    public E decode(c cVar) throws IOException {
        int readVarint32 = cVar.readVarint32();
        try {
            E e = (E) dGv().invoke(null, Integer.valueOf(readVarint32));
            if (e == null) {
                throw new ProtoAdapter.EnumConstantNotFoundException(readVarint32, this.type);
            }
            return e;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).type == this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }
}
