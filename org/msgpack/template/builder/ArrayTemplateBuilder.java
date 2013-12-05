package org.msgpack.template.builder;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.template.BooleanArrayTemplate;
import org.msgpack.template.ByteArrayTemplate;
import org.msgpack.template.DoubleArrayTemplate;
import org.msgpack.template.FloatArrayTemplate;
import org.msgpack.template.IntegerArrayTemplate;
import org.msgpack.template.LongArrayTemplate;
import org.msgpack.template.ObjectArrayTemplate;
import org.msgpack.template.ShortArrayTemplate;
/* loaded from: classes.dex */
public class ArrayTemplateBuilder extends AbstractTemplateBuilder {
    private static final Logger b = Logger.getLogger(ArrayTemplateBuilder.class.getName());

    public ArrayTemplateBuilder(org.msgpack.template.e eVar) {
        super(eVar);
    }

    @Override // org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean b2 = AbstractTemplateBuilder.b((Class<?>) cls, false);
        if (b2 && b.isLoggable(Level.FINE)) {
            b.fine("matched type: " + cls.getName());
        }
        return b2;
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder, org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> a(Type type) {
        int i;
        Class cls;
        Type type2;
        int i2 = 1;
        if (type instanceof GenericArrayType) {
            i = 1;
            Type type3 = ((GenericArrayType) type).getGenericComponentType();
            while (type3 instanceof GenericArrayType) {
                i++;
                type3 = ((GenericArrayType) type3).getGenericComponentType();
            }
            if (type3 instanceof ParameterizedType) {
                cls = (Class) ((ParameterizedType) type3).getRawType();
                type2 = type3;
            } else {
                cls = (Class) type3;
                type2 = type3;
            }
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                i2++;
            }
            i = i2;
            cls = componentType;
            type2 = componentType;
        }
        return a(type, type2, cls, i);
    }

    private org.msgpack.template.d a(Type type, Type type2, Class cls, int i) {
        if (i == 1) {
            if (cls == Boolean.TYPE) {
                return BooleanArrayTemplate.a();
            }
            if (cls == Short.TYPE) {
                return ShortArrayTemplate.a();
            }
            if (cls == Integer.TYPE) {
                return IntegerArrayTemplate.a();
            }
            if (cls == Long.TYPE) {
                return LongArrayTemplate.a();
            }
            if (cls == Float.TYPE) {
                return FloatArrayTemplate.a();
            }
            if (cls == Double.TYPE) {
                return DoubleArrayTemplate.a();
            }
            if (cls == Byte.TYPE) {
                return ByteArrayTemplate.a();
            }
            return new ObjectArrayTemplate(cls, this.f3100a.a(type2));
        } else if (i == 2) {
            return new a(Array.newInstance(cls, 0).getClass(), a(type, type2, cls, i - 1));
        } else {
            a aVar = (a) a(type, type2, cls, i - 1);
            return new a(Array.newInstance(aVar.a(), 0).getClass(), aVar);
        }
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder, org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> a(Class<T> cls, org.msgpack.template.a aVar) {
        throw new UnsupportedOperationException(cls.getName());
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder
    protected <T> org.msgpack.template.d<T> a(Class<T> cls, c[] cVarArr) {
        throw new UnsupportedOperationException(cls.getName());
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder, org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> b(Type type) {
        return null;
    }
}
