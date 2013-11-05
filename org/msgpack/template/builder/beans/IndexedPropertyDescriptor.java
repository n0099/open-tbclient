package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class IndexedPropertyDescriptor extends PropertyDescriptor {
    private Class<?> j;
    private Method k;
    private Method l;

    private boolean l() {
        Class<?> h = h();
        if (h == null) {
            return true;
        }
        Class<?> componentType = h.getComponentType();
        if (componentType == null || this.j == null) {
            return false;
        }
        return componentType.getName().equals(this.j.getName());
    }

    public IndexedPropertyDescriptor(String str, Method method, Method method2, Method method3, Method method4) {
        super(str, method, method2);
        if (method3 != null) {
            e(method3);
            a(method4, true);
        } else {
            a(method4, true);
            e(method3);
        }
        if (!l()) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.57"));
        }
    }

    public void a(Method method) {
        e(method);
    }

    public void b(Method method) {
        a(method, false);
    }

    public Method a() {
        return this.l;
    }

    public Method d() {
        return this.k;
    }

    @Override // org.msgpack.template.builder.beans.PropertyDescriptor
    public boolean equals(Object obj) {
        if (obj instanceof IndexedPropertyDescriptor) {
            IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) obj;
            if (super.equals(indexedPropertyDescriptor)) {
                if (this.j == null) {
                    if (indexedPropertyDescriptor.j != null) {
                        return false;
                    }
                } else if (!this.j.equals(indexedPropertyDescriptor.j)) {
                    return false;
                }
                if (this.k == null) {
                    if (indexedPropertyDescriptor.k != null) {
                        return false;
                    }
                } else if (!this.k.equals(indexedPropertyDescriptor.k)) {
                    return false;
                }
                if (this.l == null) {
                    if (indexedPropertyDescriptor.l != null) {
                        return false;
                    }
                } else if (!this.l.equals(indexedPropertyDescriptor.l)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // org.msgpack.template.builder.beans.PropertyDescriptor
    public int hashCode() {
        return super.hashCode() + org.a.a.a.a.a((Object) this.j) + org.a.a.a.a.a(this.k) + org.a.a.a.a.a(this.l);
    }

    public Class<?> e() {
        return this.j;
    }

    private void e(Method method) {
        if (method == null) {
            if (this.l == null) {
                if (h() != null) {
                    throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5A"));
                }
                this.j = null;
            }
            this.k = null;
        } else if (method.getParameterTypes().length != 1 || method.getParameterTypes()[0] != Integer.TYPE) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5B"));
        } else {
            Class<?> returnType = method.getReturnType();
            if (returnType == Void.TYPE) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5B"));
            }
            if (this.l != null && method.getReturnType() != this.l.getParameterTypes()[1]) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5A"));
            }
            if (this.k == null) {
                this.j = returnType;
            } else if (this.j != returnType) {
                throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5A"));
            }
            this.k = method;
        }
    }

    private void a(Method method, boolean z) {
        if (method == null) {
            if (this.k == null) {
                if (h() != null) {
                    throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5E"));
                }
                this.j = null;
            }
            this.l = null;
            return;
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 2) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.5F"));
        }
        if (parameterTypes[0] != Integer.TYPE) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.60"));
        }
        Class<?> cls = parameterTypes[1];
        if (z && this.k == null) {
            this.j = cls;
        } else if (this.j != cls) {
            throw new IntrospectionException(org.a.a.a.a.a.a.a("custom.beans.61"));
        }
        this.l = method;
    }
}
