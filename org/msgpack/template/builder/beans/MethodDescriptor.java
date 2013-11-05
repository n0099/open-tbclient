package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MethodDescriptor extends b {
    private Method h;
    private ParameterDescriptor[] i;

    public MethodDescriptor(Method method) {
        if (method == null) {
            throw new NullPointerException();
        }
        this.h = method;
        a(method.getName());
    }

    public Method a() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MethodDescriptor methodDescriptor) {
        super.a((b) methodDescriptor);
        if (this.h == null) {
            this.h = methodDescriptor.h;
        }
        if (this.i == null) {
            this.i = methodDescriptor.i;
        }
    }
}
