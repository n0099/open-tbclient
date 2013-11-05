package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class PropertyDescriptor extends b {
    boolean h;
    boolean i;
    private Method j;
    private Method k;
    private Class<?> l;

    public PropertyDescriptor(String str, Method method, Method method2) {
        if (str == null || str.length() == 0) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.04"));
        }
        a(str);
        d(method);
        c(method2);
    }

    public void c(Method method) {
        if (method != null) {
            if (!Modifier.isPublic(method.getModifiers())) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.05"));
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.06"));
            }
            Class<?> cls = parameterTypes[0];
            Class<?> h = h();
            if (h != null && !h.equals(cls)) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.07"));
            }
        }
        this.k = method;
    }

    public void d(Method method) {
        if (method != null) {
            if (!Modifier.isPublic(method.getModifiers())) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.0A"));
            }
            if (method.getParameterTypes().length != 0) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.08"));
            }
            Class<?> returnType = method.getReturnType();
            if (returnType.equals(Void.TYPE)) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.33"));
            }
            Class<?> h = h();
            if (h != null && !returnType.equals(h)) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.09"));
            }
        }
        this.j = method;
    }

    public Method f() {
        return this.k;
    }

    public Method g() {
        return this.j;
    }

    public boolean equals(Object obj) {
        boolean z = obj instanceof PropertyDescriptor;
        if (z) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) obj;
            return ((this.j == null && propertyDescriptor.g() == null) || (this.j != null && this.j.equals(propertyDescriptor.g()))) && ((this.k == null && propertyDescriptor.f() == null) || (this.k != null && this.k.equals(propertyDescriptor.f()))) && (h() == propertyDescriptor.h()) && (i() == propertyDescriptor.i()) && (k() == propertyDescriptor.k()) && (j() == propertyDescriptor.j());
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [176=5] */
    public int hashCode() {
        return org.a.a.a.a.a(this.j) + org.a.a.a.a.a(this.k) + org.a.a.a.a.a((Object) h()) + org.a.a.a.a.a((Object) i()) + org.a.a.a.a.a(k()) + org.a.a.a.a.a(j());
    }

    public Class<?> h() {
        if (this.j != null) {
            return this.j.getReturnType();
        }
        if (this.k == null) {
            return null;
        }
        return this.k.getParameterTypes()[0];
    }

    public Class<?> i() {
        return this.l;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.i;
    }
}
