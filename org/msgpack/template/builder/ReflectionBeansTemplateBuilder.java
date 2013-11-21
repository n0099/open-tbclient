package org.msgpack.template.builder;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.a.h;
import org.msgpack.a.i;
import org.msgpack.template.FieldOption;
import org.msgpack.template.builder.ReflectionTemplateBuilder;
import org.msgpack.template.builder.beans.IntrospectionException;
import org.msgpack.template.builder.beans.PropertyDescriptor;
/* loaded from: classes.dex */
public class ReflectionBeansTemplateBuilder extends ReflectionTemplateBuilder {
    private static Logger b = Logger.getLogger(ReflectionBeansTemplateBuilder.class.getName());

    public ReflectionBeansTemplateBuilder(org.msgpack.template.e eVar) {
        super(eVar, null);
    }

    @Override // org.msgpack.template.builder.ReflectionTemplateBuilder, org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean a2 = a((Type) cls, z);
        if (a2 && b.isLoggable(Level.FINE)) {
            b.fine("matched type: " + cls.getName());
        }
        return a2;
    }

    @Override // org.msgpack.template.builder.ReflectionTemplateBuilder
    protected ReflectionTemplateBuilder.ReflectionFieldTemplate[] a(c[] cVarArr) {
        ReflectionTemplateBuilder.ReflectionFieldTemplate[] reflectionFieldTemplateArr = new ReflectionTemplateBuilder.ReflectionFieldTemplate[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            c cVar = cVarArr[i];
            if (cVar.e().isPrimitive()) {
                reflectionFieldTemplateArr[i] = new d(cVar);
            } else {
                reflectionFieldTemplateArr[i] = new e(cVar, this.f2919a.a(cVar.f()));
            }
        }
        return reflectionFieldTemplateArr;
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder
    public c[] a(Class<?> cls, FieldOption fieldOption) {
        try {
            PropertyDescriptor[] a2 = org.msgpack.template.builder.beans.c.a(cls).a();
            ArrayList arrayList = new ArrayList();
            for (PropertyDescriptor propertyDescriptor : a2) {
                if (!b(propertyDescriptor)) {
                    arrayList.add(propertyDescriptor);
                }
            }
            PropertyDescriptor[] propertyDescriptorArr = new PropertyDescriptor[arrayList.size()];
            arrayList.toArray(propertyDescriptorArr);
            BeansFieldEntry[] beansFieldEntryArr = new BeansFieldEntry[propertyDescriptorArr.length];
            for (PropertyDescriptor propertyDescriptor2 : propertyDescriptorArr) {
                int a3 = a(propertyDescriptor2);
                if (a3 >= 0) {
                    if (beansFieldEntryArr[a3] != null) {
                        throw new TemplateBuildException("duplicated index: " + a3);
                    }
                    if (a3 >= beansFieldEntryArr.length) {
                        throw new TemplateBuildException("invalid index: " + a3);
                    }
                    beansFieldEntryArr[a3] = new BeansFieldEntry(propertyDescriptor2);
                    propertyDescriptorArr[a3] = null;
                }
            }
            int i = 0;
            for (PropertyDescriptor propertyDescriptor3 : propertyDescriptorArr) {
                if (propertyDescriptor3 != null) {
                    while (beansFieldEntryArr[i] != null) {
                        i++;
                    }
                    beansFieldEntryArr[i] = new BeansFieldEntry(propertyDescriptor3);
                }
            }
            for (BeansFieldEntry beansFieldEntry : beansFieldEntryArr) {
                beansFieldEntry.a(a(beansFieldEntry, fieldOption));
            }
            return beansFieldEntryArr;
        } catch (IntrospectionException e) {
            throw new TemplateBuildException("Class must be java beans class:" + cls.getName());
        }
    }

    private FieldOption a(BeansFieldEntry beansFieldEntry, FieldOption fieldOption) {
        FieldOption a2 = a(beansFieldEntry.c().g());
        if (a2 != FieldOption.DEFAULT) {
            return a2;
        }
        FieldOption a3 = a(beansFieldEntry.c().f());
        return a3 != FieldOption.DEFAULT ? a3 : fieldOption;
    }

    private FieldOption a(Method method) {
        if (a(method, org.msgpack.a.b.class)) {
            return FieldOption.IGNORE;
        }
        if (a(method, i.class)) {
            return FieldOption.OPTIONAL;
        }
        if (a(method, h.class)) {
            return FieldOption.NOTNULLABLE;
        }
        return FieldOption.DEFAULT;
    }

    private int a(PropertyDescriptor propertyDescriptor) {
        int b2 = b(propertyDescriptor.g());
        if (b2 < 0) {
            return b(propertyDescriptor.f());
        }
        return b2;
    }

    private int b(Method method) {
        org.msgpack.a.c cVar = (org.msgpack.a.c) method.getAnnotation(org.msgpack.a.c.class);
        if (cVar == null) {
            return -1;
        }
        return cVar.a();
    }

    private boolean b(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor == null) {
            return true;
        }
        Method g = propertyDescriptor.g();
        Method f = propertyDescriptor.f();
        return g == null || f == null || !Modifier.isPublic(g.getModifiers()) || !Modifier.isPublic(f.getModifiers()) || a(g, org.msgpack.a.b.class) || a(f, org.msgpack.a.b.class);
    }
}
