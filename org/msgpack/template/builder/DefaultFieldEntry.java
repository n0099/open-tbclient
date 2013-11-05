package org.msgpack.template.builder;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.msgpack.MessageTypeException;
import org.msgpack.template.FieldOption;
/* loaded from: classes.dex */
public class DefaultFieldEntry extends c {

    /* renamed from: a  reason: collision with root package name */
    protected Field f2891a;

    public DefaultFieldEntry() {
        this(null, FieldOption.IGNORE);
    }

    public DefaultFieldEntry(Field field, FieldOption fieldOption) {
        super(fieldOption);
        this.f2891a = field;
    }

    public Field a() {
        return this.f2891a;
    }

    @Override // org.msgpack.template.builder.c
    public String d() {
        return this.f2891a.getName();
    }

    @Override // org.msgpack.template.builder.c
    public Class<?> e() {
        return this.f2891a.getType();
    }

    @Override // org.msgpack.template.builder.c
    public Type f() {
        return this.f2891a.getGenericType();
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
