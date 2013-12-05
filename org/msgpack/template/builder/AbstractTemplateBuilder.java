package org.msgpack.template.builder;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.msgpack.a.h;
import org.msgpack.a.i;
import org.msgpack.a.j;
import org.msgpack.template.FieldOption;
/* loaded from: classes.dex */
public abstract class AbstractTemplateBuilder implements f {

    /* renamed from: a  reason: collision with root package name */
    protected org.msgpack.template.e f3100a;

    protected abstract <T> org.msgpack.template.d<T> a(Class<T> cls, c[] cVarArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractTemplateBuilder(org.msgpack.template.e eVar) {
        this.f3100a = eVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.msgpack.template.builder.AbstractTemplateBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> a(Type type) {
        Class cls = (Class) type;
        a((Class<?>) cls);
        return a(cls, a(cls, b((Class<?>) cls)));
    }

    @Override // org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> a(Class<T> cls, org.msgpack.template.a aVar) {
        a((Class<?>) cls);
        return a(cls, b((Class<?>) cls, aVar));
    }

    protected void a(Class<?> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            throw new TemplateBuildException("Cannot build template for abstract class: " + cls.getName());
        }
        if (cls.isInterface()) {
            throw new TemplateBuildException("Cannot build template for interface: " + cls.getName());
        }
        if (cls.isArray()) {
            throw new TemplateBuildException("Cannot build template for array class: " + cls.getName());
        }
        if (cls.isPrimitive()) {
            throw new TemplateBuildException("Cannot build template of primitive type: " + cls.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FieldOption b(Class<?> cls) {
        org.msgpack.a.d dVar = (org.msgpack.a.d) cls.getAnnotation(org.msgpack.a.d.class);
        if (dVar == null) {
            return FieldOption.DEFAULT;
        }
        if (((org.msgpack.a.f) cls.getAnnotation(org.msgpack.a.f.class)) == null) {
            return FieldOption.DEFAULT;
        }
        return dVar.a();
    }

    private c[] b(Class<?> cls, org.msgpack.template.a aVar) {
        List<org.msgpack.template.b> a2 = aVar.a();
        c[] cVarArr = new c[a2.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < a2.size()) {
                org.msgpack.template.b bVar = a2.get(i2);
                if (bVar.c()) {
                    try {
                        cVarArr[i2] = new DefaultFieldEntry(cls.getDeclaredField(bVar.a()), bVar.b());
                    } catch (NoSuchFieldException e) {
                        throw new TemplateBuildException(e);
                    } catch (SecurityException e2) {
                        throw new TemplateBuildException(e2);
                    }
                } else {
                    cVarArr[i2] = new DefaultFieldEntry();
                }
                i = i2 + 1;
            } else {
                return cVarArr;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c[] a(Class<?> cls, FieldOption fieldOption) {
        Field[] c = c(cls);
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Field field : c) {
            FieldOption a2 = a(field, fieldOption);
            if (a2 != FieldOption.IGNORE) {
                int a3 = a(field, i);
                if (arrayList.size() > a3 && arrayList.get(a3) != null) {
                    throw new TemplateBuildException("duplicated index: " + a3);
                }
                if (a3 < 0) {
                    throw new TemplateBuildException("invalid index: " + a3);
                }
                while (arrayList.size() <= a3) {
                    arrayList.add(null);
                }
                arrayList.set(a3, new DefaultFieldEntry(field, a2));
                if (i < a3) {
                    i = a3;
                }
            }
        }
        c[] cVarArr = new c[i + 1];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            c cVar = (c) arrayList.get(i2);
            if (cVar == null) {
                cVarArr[i2] = new DefaultFieldEntry();
            } else {
                cVarArr[i2] = cVar;
            }
        }
        return cVarArr;
    }

    private Field[] c(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            i += declaredFields.length;
            arrayList.add(declaredFields);
            cls = cls.getSuperclass();
        }
        Field[] fieldArr = new Field[i];
        int i2 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Field[] fieldArr2 = (Field[]) arrayList.get(size);
            System.arraycopy(fieldArr2, 0, fieldArr, i2, fieldArr2.length);
            i2 += fieldArr2.length;
        }
        return fieldArr;
    }

    private FieldOption a(Field field, FieldOption fieldOption) {
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) || Modifier.isFinal(modifiers) || Modifier.isTransient(modifiers)) {
            return FieldOption.IGNORE;
        }
        if (a(field, org.msgpack.a.b.class)) {
            return FieldOption.IGNORE;
        }
        if (a(field, i.class)) {
            return FieldOption.OPTIONAL;
        }
        if (a(field, h.class)) {
            return FieldOption.NOTNULLABLE;
        }
        if (fieldOption == FieldOption.DEFAULT) {
            if (field.getType().isPrimitive()) {
                return FieldOption.NOTNULLABLE;
            }
            return FieldOption.OPTIONAL;
        }
        return fieldOption;
    }

    private int a(Field field, int i) {
        org.msgpack.a.c cVar = (org.msgpack.a.c) field.getAnnotation(org.msgpack.a.c.class);
        return cVar == null ? i + 1 : cVar.a();
    }

    @Override // org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> b(Type type) {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<? extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Class<?> cls, Class<? extends Annotation> cls2) {
        return cls.getAnnotation(cls2) != null;
    }

    public static boolean a(AccessibleObject accessibleObject, Class<? extends Annotation> cls) {
        return accessibleObject.getAnnotation(cls) != null;
    }

    public static boolean a(Class<?> cls, boolean z) {
        return z ? a(cls, org.msgpack.a.d.class) || a(cls, org.msgpack.a.f.class) : (cls.isEnum() || cls.isInterface()) ? false : true;
    }

    public static boolean a(Type type, boolean z) {
        Class cls = (Class) type;
        return z ? a((Class) type, org.msgpack.a.a.class) || a((Class) type, org.msgpack.a.e.class) : (cls.isEnum() && cls.isInterface()) ? false : true;
    }

    public static boolean b(Class<?> cls, boolean z) {
        if (cls instanceof GenericArrayType) {
            return true;
        }
        return cls.isArray();
    }

    public static boolean c(Class<?> cls, boolean z) {
        if (z) {
            return a(cls, j.class) || a(cls, org.msgpack.a.g.class);
        }
        return cls.isEnum();
    }
}
