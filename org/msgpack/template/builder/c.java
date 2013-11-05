package org.msgpack.template.builder;

import java.lang.reflect.Type;
import org.msgpack.template.FieldOption;
/* loaded from: classes.dex */
public abstract class c {
    protected FieldOption b;

    public abstract Object a(Object obj);

    public abstract String d();

    public abstract Class<?> e();

    public abstract Type f();

    public c() {
        this(FieldOption.IGNORE);
    }

    public c(FieldOption fieldOption) {
        this.b = fieldOption;
    }

    public void a(FieldOption fieldOption) {
        this.b = fieldOption;
    }

    public boolean g() {
        return this.b != FieldOption.IGNORE;
    }

    public boolean h() {
        return this.b == FieldOption.OPTIONAL;
    }

    public boolean i() {
        return this.b == FieldOption.NOTNULLABLE;
    }

    public String j() {
        Class<?> e = e();
        return e.isArray() ? a(e) : e.getName();
    }

    public String a(Class<?> cls) {
        int i = 1;
        Class<?> componentType = cls.getComponentType();
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(componentType.getName());
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("[]");
        }
        return sb.toString();
    }
}
