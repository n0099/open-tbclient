package org.msgpack.template.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import org.msgpack.MessageTypeException;
import org.msgpack.template.FieldOption;
import org.msgpack.template.builder.beans.PropertyDescriptor;
/* loaded from: classes.dex */
public class BeansFieldEntry extends c {

    /* renamed from: a  reason: collision with root package name */
    protected PropertyDescriptor f2937a;

    public BeansFieldEntry() {
    }

    public BeansFieldEntry(PropertyDescriptor propertyDescriptor) {
        this(propertyDescriptor, FieldOption.DEFAULT);
    }

    public BeansFieldEntry(PropertyDescriptor propertyDescriptor, FieldOption fieldOption) {
        super(fieldOption);
        this.f2937a = propertyDescriptor;
    }

    public String a() {
        return c().g().getName();
    }

    public String b() {
        return c().f().getName();
    }

    public PropertyDescriptor c() {
        return this.f2937a;
    }

    @Override // org.msgpack.template.builder.c
    public String d() {
        return c().c();
    }

    @Override // org.msgpack.template.builder.c
    public Class<?> e() {
        return c().h();
    }

    @Override // org.msgpack.template.builder.c
    public Type f() {
        return c().g().getGenericReturnType();
    }

    @Override // org.msgpack.template.builder.c
    public Object a(Object obj) {
        try {
            return c().g().invoke(obj, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new MessageTypeException(e);
        } catch (IllegalArgumentException e2) {
            throw new MessageTypeException(e2);
        } catch (InvocationTargetException e3) {
            throw new MessageTypeException(e3);
        }
    }
}
