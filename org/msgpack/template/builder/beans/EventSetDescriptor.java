package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TooManyListenersException;
/* loaded from: classes.dex */
public class EventSetDescriptor extends b {
    private Class<?> h;
    private ArrayList<MethodDescriptor> i;
    private Method[] j;
    private Method k;
    private Method l;
    private Method m;
    private boolean n;
    private boolean o = true;

    public EventSetDescriptor(String str, Class<?> cls, Method[] methodArr, Method method, Method method2, Method method3) {
        a(str);
        this.h = cls;
        this.j = methodArr;
        if (methodArr != null) {
            this.i = new ArrayList<>();
            for (Method method4 : methodArr) {
                this.i.add(new MethodDescriptor(method4));
            }
        }
        this.l = method;
        this.m = method2;
        this.k = method3;
        this.n = a(method);
    }

    public void a(boolean z) {
        this.n = z;
    }

    private static boolean a(Method method) {
        if (method != null) {
            for (Class<?> cls : method.getExceptionTypes()) {
                if (cls.equals(TooManyListenersException.class)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(EventSetDescriptor eventSetDescriptor) {
        super.a((b) eventSetDescriptor);
        if (this.l == null) {
            this.l = eventSetDescriptor.l;
        }
        if (this.k == null) {
            this.k = eventSetDescriptor.k;
        }
        if (this.i == null) {
            this.i = eventSetDescriptor.i;
        }
        if (this.j == null) {
            this.j = eventSetDescriptor.j;
        }
        if (this.h == null) {
            this.h = eventSetDescriptor.h;
        }
        if (this.m == null) {
            this.m = eventSetDescriptor.m;
        }
        this.o &= eventSetDescriptor.o;
    }
}
