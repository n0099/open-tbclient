package org.msgpack.template;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.msgpack.MessageTypeException;
import org.msgpack.template.builder.f;
import org.msgpack.template.builder.g;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    Map<Type, d<Type>> f2950a;
    private e b;
    private g c;
    private Map<Type, c> d;

    private e() {
        this.b = null;
        this.b = null;
        this.c = a();
        this.d = new HashMap();
        this.f2950a = new HashMap();
        c();
        this.f2950a = Collections.unmodifiableMap(this.f2950a);
    }

    public e(e eVar) {
        this.b = null;
        if (eVar != null) {
            this.b = eVar;
        } else {
            this.b = new e();
        }
        this.c = a();
        this.f2950a = new HashMap();
        this.d = new HashMap();
        b();
    }

    protected g a() {
        return new g(this);
    }

    private void c() {
        a(Boolean.TYPE, BooleanTemplate.a());
        a(Boolean.class, BooleanTemplate.a());
        a(Byte.TYPE, ByteTemplate.a());
        a(Byte.class, ByteTemplate.a());
        a(Short.TYPE, ShortTemplate.a());
        a(Short.class, ShortTemplate.a());
        a(Integer.TYPE, IntegerTemplate.a());
        a(Integer.class, IntegerTemplate.a());
        a(Long.TYPE, LongTemplate.a());
        a(Long.class, LongTemplate.a());
        a(Float.TYPE, FloatTemplate.a());
        a(Float.class, FloatTemplate.a());
        a(Double.TYPE, DoubleTemplate.a());
        a(Double.class, DoubleTemplate.a());
        a(BigInteger.class, BigIntegerTemplate.a());
        a(Character.TYPE, CharacterTemplate.a());
        a(Character.class, CharacterTemplate.a());
        a(boolean[].class, BooleanArrayTemplate.a());
        a(short[].class, ShortArrayTemplate.a());
        a(int[].class, IntegerArrayTemplate.a());
        a(long[].class, LongArrayTemplate.a());
        a(float[].class, FloatArrayTemplate.a());
        a(double[].class, DoubleArrayTemplate.a());
        a(String.class, StringTemplate.a());
        a(byte[].class, ByteArrayTemplate.a());
        a(ByteBuffer.class, ByteBufferTemplate.a());
        a(r.class, ValueTemplate.a());
        a(BigDecimal.class, BigDecimalTemplate.a());
        a(Date.class, DateTemplate.a());
        b();
    }

    protected void b() {
        AnyTemplate anyTemplate = new AnyTemplate(this);
        a(List.class, new ListTemplate(anyTemplate));
        a(Set.class, new SetTemplate(anyTemplate));
        a(Collection.class, new CollectionTemplate(anyTemplate));
        a(Map.class, new MapTemplate(anyTemplate, anyTemplate));
        a(List.class, new GenericCollectionTemplate(this, ListTemplate.class));
        a(Set.class, new GenericCollectionTemplate(this, SetTemplate.class));
        a(Collection.class, new GenericCollectionTemplate(this, CollectionTemplate.class));
        a(Map.class, new GenericMapTemplate(this, MapTemplate.class));
    }

    public synchronized void a(Type type, d dVar) {
        if (dVar == null) {
            throw new NullPointerException("Template object is null");
        }
        if (type instanceof ParameterizedType) {
            this.f2950a.put(((ParameterizedType) type).getRawType(), dVar);
        } else {
            this.f2950a.put(type, dVar);
        }
    }

    public synchronized void a(Type type, c cVar) {
        if (type instanceof ParameterizedType) {
            this.d.put(((ParameterizedType) type).getRawType(), cVar);
        } else {
            this.d.put(type, cVar);
        }
    }

    public synchronized d a(Type type) {
        Type type2;
        d<Type> b;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            b = a(parameterizedType);
            if (b == null) {
                type2 = parameterizedType.getRawType();
            }
        } else {
            type2 = type;
        }
        b = b(type2);
        if (b == null && (b = c(type2)) == null) {
            if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable)) {
                b = new AnyTemplate<>(this);
                a(type2, b);
            } else {
                Class cls = (Class) type2;
                if (org.msgpack.b.class.isAssignableFrom(cls)) {
                    d<Type> messagePackableTemplate = new MessagePackableTemplate(cls);
                    a(cls, messagePackableTemplate);
                    b = messagePackableTemplate;
                } else if (cls.isInterface()) {
                    b = new AnyTemplate<>(this);
                    a(type2, b);
                } else {
                    d<Type> a2 = a(cls);
                    if (a2 != null) {
                        b = a2;
                    } else {
                        d<Type> b2 = b(cls);
                        if (b2 != null) {
                            b = b2;
                        } else {
                            d<Type> c = c(cls);
                            if (c != null) {
                                b = c;
                            } else {
                                d<Type> d = d(cls);
                                if (d == null) {
                                    throw new MessageTypeException("Cannot find template for " + cls + " class.  Try to add @Message annotation to the class or call MessagePack.register(Type).");
                                }
                                b = d;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    private d<Type> a(ParameterizedType parameterizedType) {
        d<Type> b = b(parameterizedType);
        if (b == null) {
            try {
                d<Type> b2 = this.b.b(parameterizedType);
                if (b2 != null) {
                    return b2;
                }
            } catch (NullPointerException e) {
            }
            d<Type> c = c(parameterizedType);
            if (c == null) {
                d<Type> d = d(parameterizedType);
                if (d == null) {
                    return null;
                }
                return d;
            }
            return c;
        }
        return b;
    }

    private d b(ParameterizedType parameterizedType) {
        return a(parameterizedType, parameterizedType.getRawType());
    }

    private d a(ParameterizedType parameterizedType, Type type) {
        c cVar = this.d.get(type);
        if (cVar == null) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        d[] dVarArr = new d[actualTypeArguments.length];
        for (int i = 0; i < actualTypeArguments.length; i++) {
            dVarArr[i] = a(actualTypeArguments[i]);
        }
        return cVar.a(dVarArr);
    }

    private <T> d<T> c(ParameterizedType parameterizedType) {
        try {
            d<T> dVar = null;
            for (Class<?> cls : ((Class) parameterizedType.getRawType()).getInterfaces()) {
                try {
                    dVar = a(parameterizedType, cls);
                    if (dVar != null) {
                        return dVar;
                    }
                } catch (ClassCastException e) {
                    return dVar;
                }
            }
            return dVar;
        } catch (ClassCastException e2) {
            return null;
        }
    }

    private <T> d<T> d(ParameterizedType parameterizedType) {
        try {
            Class<? super Object> superclass = ((Class) parameterizedType.getRawType()).getSuperclass();
            if (superclass == null) {
                return null;
            }
            d dVar = null;
            for (Class<? super Object> cls = superclass; cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    dVar = a(parameterizedType, cls);
                    if (dVar != null) {
                        a(parameterizedType, dVar);
                        return dVar;
                    }
                } catch (ClassCastException e) {
                    return dVar;
                }
            }
            return dVar;
        } catch (ClassCastException e2) {
            return null;
        }
    }

    private d<Type> b(Type type) {
        if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type;
            d<Type> a2 = a(genericArrayType);
            if (a2 != null) {
                return a2;
            }
            try {
                d<Type> a3 = this.b.a(genericArrayType);
                if (a3 != null) {
                    return a3;
                }
                return null;
            } catch (NullPointerException e) {
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 java.lang.reflect.GenericArrayType)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.reflect.Type : 0x0041: INVOKE  (r3v0 java.lang.reflect.Type A[REMOVE]) = (r9v0 java.lang.reflect.GenericArrayType) type: INTERFACE call: java.lang.reflect.GenericArrayType.getGenericComponentType():java.lang.reflect.Type)] */
    private d a(GenericArrayType genericArrayType) {
        Class<?> loadClass;
        Class<?> loadClass2;
        String sb = new StringBuilder().append(genericArrayType).toString();
        int length = sb.split("\\[").length - 1;
        if (length <= 0) {
            throw new MessageTypeException(String.format("fatal error: type=", sb));
        }
        if (length > 1) {
            throw new UnsupportedOperationException(String.format("Not implemented template generation of %s", sb));
        }
        String sb2 = new StringBuilder().append(genericArrayType.getGenericComponentType()).toString();
        boolean a2 = a(sb2);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append('[');
        }
        if (!a2) {
            stringBuffer.append('L');
            stringBuffer.append(b(sb2));
            stringBuffer.append(';');
        } else {
            stringBuffer.append(c(sb2));
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && (loadClass2 = contextClassLoader.loadClass(stringBuffer2)) != null) {
                return a((Class) loadClass2);
            }
        } catch (ClassNotFoundException e) {
        }
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null && (loadClass = classLoader.loadClass(stringBuffer2)) != null) {
                return a((Class) loadClass);
            }
        } catch (ClassNotFoundException e2) {
        }
        try {
            Class<?> cls = Class.forName(stringBuffer2);
            if (cls != null) {
                return a((Class) cls);
            }
        } catch (ClassNotFoundException e3) {
        }
        throw new MessageTypeException(String.format("cannot find template of %s", stringBuffer2));
    }

    private d<Type> c(Type type) {
        d<Type> dVar = this.f2950a.get(type);
        if (dVar == null) {
            try {
                return this.b.c(type);
            } catch (NullPointerException e) {
                return dVar;
            }
        }
        return dVar;
    }

    private <T> d<T> a(Class<T> cls) {
        f a2 = this.c.a((Type) cls, true);
        if (a2 != null) {
            d<T> b = this.c.a().b(cls);
            if (b != null) {
                a(cls, b);
                return b;
            }
            return a(a2, cls, true, null);
        }
        return null;
    }

    private <T> d<T> b(Class<T> cls) {
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        d<Type> dVar = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Class<?> cls2 = interfaces[i];
            dVar = this.f2950a.get(cls2);
            if (dVar != null) {
                a(cls, dVar);
                break;
            }
            try {
                dVar = this.b.c((Type) cls2);
            } catch (NullPointerException e) {
            }
            if (dVar == null) {
                continue;
                i++;
            } else {
                a(cls, dVar);
                break;
            }
        }
        return dVar;
    }

    private <T> d<T> c(Class<T> cls) {
        Class<? super T> superclass = cls.getSuperclass();
        d<Type> dVar = null;
        if (superclass != null) {
            while (true) {
                if (superclass == Object.class) {
                    break;
                }
                dVar = this.f2950a.get(superclass);
                if (dVar != null) {
                    a(cls, dVar);
                    break;
                }
                try {
                    dVar = this.b.c((Type) superclass);
                } catch (NullPointerException e) {
                }
                if (dVar == null) {
                    continue;
                    superclass = superclass.getSuperclass();
                } else {
                    a(cls, dVar);
                    break;
                }
            }
        }
        return dVar;
    }

    private <T> d<T> d(Class<T> cls) {
        Class<? super T> superclass = cls.getSuperclass();
        d dVar = null;
        if (superclass != null) {
            while (true) {
                if (superclass == Object.class) {
                    break;
                }
                dVar = b((Class) superclass);
                if (dVar != null) {
                    a(cls, dVar);
                    break;
                }
                try {
                    dVar = this.b.c((Type) superclass);
                } catch (NullPointerException e) {
                }
                if (dVar == null) {
                    continue;
                    superclass = superclass.getSuperclass();
                } else {
                    a(cls, dVar);
                    break;
                }
            }
        }
        return dVar;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005d: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:38:0x005d */
    private synchronized d a(f fVar, Class cls, boolean z, a aVar) {
        d<Type> dVar;
        d<Type> dVar2;
        d<Type> a2;
        d<Type> dVar3 = null;
        synchronized (this) {
            try {
                try {
                    try {
                        dVar2 = this.f2950a.containsKey(cls) ? this.f2950a.get(cls) : null;
                        try {
                            try {
                                this.f2950a.put(cls, new TemplateReference(this, cls));
                                if (fVar == null) {
                                    fVar = this.c.a(cls, z);
                                }
                                a2 = aVar != null ? fVar.a(cls, aVar) : fVar.a(cls);
                                if (a2 != null) {
                                    this.f2950a.put(cls, a2);
                                }
                            } catch (Exception e) {
                                e = e;
                                if (dVar2 != null) {
                                    this.f2950a.put(cls, dVar2);
                                } else {
                                    this.f2950a.remove(cls);
                                }
                                if (e instanceof MessageTypeException) {
                                    throw ((MessageTypeException) e);
                                }
                                throw new MessageTypeException(e);
                            }
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        dVar2 = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (dVar3 != null) {
                        this.f2950a.put(cls, dVar3);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dVar3 = dVar;
            }
        }
        return a2;
    }

    private static boolean a(String str) {
        return str.equals("byte") || str.equals("short") || str.equals("int") || str.equals("long") || str.equals("float") || str.equals("double") || str.equals("boolean") || str.equals("char");
    }

    private static String b(String str) {
        return str.substring(6);
    }

    private static String c(String str) {
        if (str.equals("byte")) {
            return "B";
        }
        if (str.equals("short")) {
            return "S";
        }
        if (str.equals("int")) {
            return "I";
        }
        if (str.equals("long")) {
            return "J";
        }
        if (str.equals("float")) {
            return "F";
        }
        if (str.equals("double")) {
            return "D";
        }
        if (str.equals("boolean")) {
            return "Z";
        }
        if (str.equals("char")) {
            return "C";
        }
        throw new MessageTypeException(String.format("fatal error: type=%s", str));
    }
}
