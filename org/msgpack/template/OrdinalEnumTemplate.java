package org.msgpack.template;

import java.util.HashMap;
import org.msgpack.MessageTypeException;
import org.msgpack.a.j;
/* loaded from: classes.dex */
public class OrdinalEnumTemplate<T> extends AbstractTemplate<T> {

    /* renamed from: a  reason: collision with root package name */
    protected T[] f2878a;
    protected HashMap<T, Integer> b = new HashMap<>();
    protected boolean c;

    public OrdinalEnumTemplate(Class<T> cls) {
        boolean z = false;
        this.f2878a = cls.getEnumConstants();
        for (int i = 0; i < this.f2878a.length; i++) {
            this.b.put(this.f2878a[i], Integer.valueOf(i));
        }
        this.c = (!cls.isAnnotationPresent(j.class) || ((j) cls.getAnnotation(j.class)).a()) ? true : true;
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, T t, boolean z) {
        if (t == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        Integer num = this.b.get(t);
        if (num == null) {
            throw new MessageTypeException(new IllegalArgumentException("ordinal: " + num));
        }
        aVar.a(num.intValue());
    }
}
