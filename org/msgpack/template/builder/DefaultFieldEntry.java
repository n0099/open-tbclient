package org.msgpack.template.builder;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.msgpack.MessageTypeException;
import org.msgpack.template.FieldOption;
/* loaded from: classes.dex */
public class DefaultFieldEntry extends c {

    /* renamed from: a  reason: collision with root package name */
    protected Field f3104a;

    public DefaultFieldEntry() {
        this(null, FieldOption.IGNORE);
    }

    public DefaultFieldEntry(Field field, FieldOption fieldOption) {
        super(fieldOption);
        this.f3104a = field;
    }

    public Field a() {
        return this.f3104a;
    }

    @Override // org.msgpack.template.builder.c
    public String d() {
        return this.f3104a.getName();
    }

    @Override // org.msgpack.template.builder.c
    public Class<?> e() {
        return this.f3104a.getType();
    }

    @Override // org.msgpack.template.builder.c
    public Type f() {
        return this.f3104a.getGenericType();
    }

    @Override // org.msgpack.template.builder.c
    public Object a(Object obj) {
        try {
            return a().get(obj);
        } catch (IllegalAccessException e) {
            throw new MessageTypeException(e);
        } catch (IllegalArgumentException e2) {
            throw new MessageTypeException(e2);
        }
    }
}
