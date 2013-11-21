package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TooManyListenersException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends SimpleBeanInfo {
    private static f m = new f(null);

    /* renamed from: a  reason: collision with root package name */
    a[] f2931a;
    private boolean b;
    private boolean c;
    private boolean d;
    private a e;
    private EventSetDescriptor[] f;
    private MethodDescriptor[] g;
    private PropertyDescriptor[] h;
    private BeanDescriptor i = null;
    private Class<?> j;
    private int k;
    private int l;
    private boolean n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Class<?> cls, a aVar, Class<?> cls2) {
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.f2931a = null;
        this.k = -1;
        this.l = -1;
        this.j = cls;
        if (aVar != null) {
            this.e = aVar;
            this.f = aVar.c();
            this.g = aVar.b();
            this.h = aVar.a();
            this.k = aVar.g();
            if (this.k < 0 || this.k >= this.f.length) {
                this.k = -1;
            }
            this.l = aVar.f();
            if (this.l < 0 || this.l >= this.h.length) {
                this.l = -1;
            }
            this.f2931a = aVar.d();
            if (this.f != null) {
                this.d = true;
            }
            if (this.g != null) {
                this.b = true;
            }
            if (this.h != null) {
                this.c = true;
            }
        }
        if (this.g == null) {
            this.g = i();
        }
        if (this.h == null) {
            this.h = a(cls2);
        }
        if (this.f == null) {
            this.f = j();
        }
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public a[] d() {
        return null;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public EventSetDescriptor[] c() {
        return this.f;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public MethodDescriptor[] b() {
        return this.g;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public PropertyDescriptor[] a() {
        return this.h;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public BeanDescriptor e() {
        if (this.i == null) {
            if (this.e != null) {
                this.i = this.e.e();
            }
            if (this.i == null) {
                this.i = new BeanDescriptor(this.j);
            }
        }
        return this.i;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public int g() {
        return this.k;
    }

    @Override // org.msgpack.template.builder.beans.SimpleBeanInfo, org.msgpack.template.builder.beans.a
    public int f() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar, boolean z) {
        PropertyDescriptor[] a2;
        MethodDescriptor[] b;
        EventSetDescriptor[] c;
        if ((z || !this.c) && (a2 = aVar.a()) != null) {
            if (a() != null) {
                this.h = a(a2, aVar.f());
            } else {
                this.h = a2;
                this.l = aVar.f();
            }
        }
        if ((z || !this.b) && (b = aVar.b()) != null) {
            if (this.g != null) {
                this.g = a(b);
            } else {
                this.g = b;
            }
        }
        if ((z || !this.d) && (c = aVar.c()) != null) {
            if (this.f != null) {
                this.f = a(c, aVar.g());
                return;
            }
            this.f = c;
            this.k = aVar.g();
        }
    }

    private PropertyDescriptor[] a(PropertyDescriptor[] propertyDescriptorArr, int i) {
        String str;
        Class<?> cls;
        Class<?> cls2;
        Method method;
        Method method2;
        Method method3;
        HashMap<String, PropertyDescriptor> a2 = a(this.h);
        if (this.l >= 0 && this.l < this.h.length) {
            str = this.h[this.l].b();
        } else if (i < 0 || i >= propertyDescriptorArr.length) {
            str = null;
        } else {
            str = propertyDescriptorArr[i].b();
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= propertyDescriptorArr.length) {
                break;
            }
            PropertyDescriptor propertyDescriptor = propertyDescriptorArr[i3];
            String b = propertyDescriptor.b();
            if (!a2.containsKey(b)) {
                a2.put(b, propertyDescriptor);
            } else {
                PropertyDescriptor propertyDescriptor2 = a2.get(b);
                Method g = propertyDescriptor2.g();
                Method f = propertyDescriptor2.f();
                Method g2 = propertyDescriptor.g();
                Method f2 = propertyDescriptor.f();
                Class<?> h = propertyDescriptor.h();
                Class<?> h2 = propertyDescriptor2.h();
                if (!(propertyDescriptor2 instanceof IndexedPropertyDescriptor)) {
                    cls = null;
                } else {
                    cls = ((IndexedPropertyDescriptor) propertyDescriptor2).e();
                }
                if (!(propertyDescriptor instanceof IndexedPropertyDescriptor)) {
                    cls2 = null;
                } else {
                    cls2 = ((IndexedPropertyDescriptor) propertyDescriptor).e();
                }
                if (cls2 == null) {
                    PropertyDescriptor propertyDescriptor3 = propertyDescriptor2;
                    if (cls == null) {
                        if (h2 != null && h != null && h2.getName() != null && h2.getName().equals(h.getName())) {
                            if (g2 != null && (g == null || g2.equals(g))) {
                                propertyDescriptor3.d(g2);
                            }
                            if (f2 != null && (f == null || f2.equals(f))) {
                                propertyDescriptor3.c(f2);
                            }
                            if (h2 == Boolean.TYPE && g != null && g2 != null && g2.getName().startsWith("is")) {
                                propertyDescriptor3.d(g2);
                            }
                        } else if ((g == null || f == null) && g2 != null) {
                            propertyDescriptor3 = new PropertyDescriptor(b, g2, f2);
                            if (g != null) {
                                String name = g.getName();
                                MethodDescriptor[] i4 = i();
                                int length = i4.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 < length) {
                                        Method a3 = i4[i5].a();
                                        if (a3 == g || !name.equals(a3.getName()) || a3.getParameterTypes().length != 0 || a3.getReturnType() != h) {
                                            i5++;
                                        } else {
                                            propertyDescriptor3.d(a3);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        if (h != null && h.isArray() && h.getComponentType().getName().equals(cls.getName())) {
                            if (g == null && g2 != null) {
                                propertyDescriptor3.d(g2);
                            }
                            if (f == null && f2 != null) {
                                propertyDescriptor3.c(f2);
                            }
                        }
                        if (cls == Boolean.TYPE && h == Boolean.TYPE) {
                            Method a4 = ((IndexedPropertyDescriptor) propertyDescriptor3).a();
                            if (g == null && f == null && a4 != null && g2 != null) {
                                try {
                                    method3 = this.j.getDeclaredMethod(a4.getName(), Boolean.TYPE);
                                } catch (Exception e) {
                                    method3 = f;
                                }
                                if (method3 != null) {
                                    propertyDescriptor3 = new PropertyDescriptor(b, g2, method3);
                                }
                            }
                        }
                    }
                    a2.put(b, propertyDescriptor3);
                } else if (cls == null) {
                    if (h2 != null && h2.isArray() && h2.getComponentType().getName().equals(cls2.getName())) {
                        if (g != null) {
                            propertyDescriptor.d(g);
                        }
                        if (f != null) {
                            propertyDescriptor.c(f);
                        }
                        a2.put(b, propertyDescriptor);
                    } else {
                        if (g == null || f == null) {
                            Class<? super Object> superclass = this.j.getSuperclass();
                            String a5 = a(b);
                            if (g == null) {
                                if (h2 == Boolean.TYPE) {
                                    try {
                                        method2 = superclass.getDeclaredMethod("is" + a5, new Class[0]);
                                    } catch (Exception e2) {
                                        method2 = null;
                                    }
                                } else {
                                    try {
                                        method2 = superclass.getDeclaredMethod("get" + a5, new Class[0]);
                                    } catch (Exception e3) {
                                        method2 = null;
                                    }
                                }
                                if (method2 != null && !Modifier.isStatic(method2.getModifiers()) && method2.getReturnType() == h2) {
                                    propertyDescriptor2.d(method2);
                                }
                            } else {
                                try {
                                    method = superclass.getDeclaredMethod("set" + a5, h2);
                                } catch (Exception e4) {
                                    method = null;
                                }
                                if (method != null && !Modifier.isStatic(method.getModifiers()) && method.getReturnType() == Void.TYPE) {
                                    propertyDescriptor2.c(method);
                                }
                            }
                        }
                        a2.put(b, propertyDescriptor2);
                    }
                } else if (cls.getName().equals(cls2.getName())) {
                    IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) propertyDescriptor2;
                    if (g == null && g2 != null) {
                        indexedPropertyDescriptor.d(g2);
                    }
                    if (f == null && f2 != null) {
                        indexedPropertyDescriptor.c(f2);
                    }
                    IndexedPropertyDescriptor indexedPropertyDescriptor2 = (IndexedPropertyDescriptor) propertyDescriptor;
                    if (indexedPropertyDescriptor.d() == null && indexedPropertyDescriptor2.d() != null) {
                        indexedPropertyDescriptor.a(indexedPropertyDescriptor2.d());
                    }
                    if (indexedPropertyDescriptor.a() == null && indexedPropertyDescriptor2.a() != null) {
                        indexedPropertyDescriptor.b(indexedPropertyDescriptor2.a());
                    }
                    a2.put(b, indexedPropertyDescriptor);
                }
                a(propertyDescriptor2, propertyDescriptor);
            }
            i2 = i3 + 1;
        }
        PropertyDescriptor[] propertyDescriptorArr2 = new PropertyDescriptor[a2.size()];
        a2.values().toArray(propertyDescriptorArr2);
        if (str != null && !this.c) {
            int i6 = 0;
            while (true) {
                if (i6 >= propertyDescriptorArr2.length) {
                    break;
                } else if (!str.equals(propertyDescriptorArr2[i6].b())) {
                    i6++;
                } else {
                    this.l = i6;
                    break;
                }
            }
        }
        return propertyDescriptorArr2;
    }

    private String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() != 0) {
            if (str.length() <= 1 || !Character.isUpperCase(str.charAt(1))) {
                char[] charArray = str.toCharArray();
                charArray[0] = Character.toUpperCase(charArray[0]);
                return new String(charArray);
            }
            return str;
        }
        return str;
    }

    private static void a(PropertyDescriptor propertyDescriptor, PropertyDescriptor propertyDescriptor2) {
        propertyDescriptor.b |= propertyDescriptor2.b;
        propertyDescriptor.c |= propertyDescriptor2.c;
        propertyDescriptor.f2929a |= propertyDescriptor2.f2929a;
        propertyDescriptor.i |= propertyDescriptor2.i;
        propertyDescriptor.h |= propertyDescriptor2.h;
        propertyDescriptor.e = propertyDescriptor2.e;
        if (propertyDescriptor.d == null && propertyDescriptor2.d != null) {
            propertyDescriptor.d = propertyDescriptor2.d;
        }
        if (propertyDescriptor.f == null && propertyDescriptor2.f != null) {
            propertyDescriptor.f = propertyDescriptor2.f;
        }
    }

    private MethodDescriptor[] a(MethodDescriptor[] methodDescriptorArr) {
        HashMap<String, MethodDescriptor> b = b(this.g);
        for (MethodDescriptor methodDescriptor : methodDescriptorArr) {
            String a2 = a(methodDescriptor.a());
            MethodDescriptor methodDescriptor2 = b.get(a2);
            if (methodDescriptor2 == null) {
                b.put(a2, methodDescriptor);
            } else {
                methodDescriptor2.a(methodDescriptor);
            }
        }
        MethodDescriptor[] methodDescriptorArr2 = new MethodDescriptor[b.size()];
        b.values().toArray(methodDescriptorArr2);
        return methodDescriptorArr2;
    }

    private EventSetDescriptor[] a(EventSetDescriptor[] eventSetDescriptorArr, int i) {
        String str;
        HashMap<String, EventSetDescriptor> a2 = a(this.f);
        if (this.k >= 0 && this.k < this.f.length) {
            str = this.f[this.k].b();
        } else if (i < 0 || i >= eventSetDescriptorArr.length) {
            str = null;
        } else {
            str = eventSetDescriptorArr[i].b();
        }
        for (EventSetDescriptor eventSetDescriptor : eventSetDescriptorArr) {
            String b = eventSetDescriptor.b();
            EventSetDescriptor eventSetDescriptor2 = a2.get(b);
            if (eventSetDescriptor2 == null) {
                a2.put(b, eventSetDescriptor);
            } else {
                eventSetDescriptor2.a(eventSetDescriptor);
            }
        }
        EventSetDescriptor[] eventSetDescriptorArr2 = new EventSetDescriptor[a2.size()];
        a2.values().toArray(eventSetDescriptorArr2);
        if (str != null && !this.d) {
            int i2 = 0;
            while (true) {
                if (i2 < eventSetDescriptorArr2.length) {
                    if (!str.equals(eventSetDescriptorArr2[i2].b())) {
                        i2++;
                    } else {
                        this.k = i2;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return eventSetDescriptorArr2;
    }

    private static HashMap<String, PropertyDescriptor> a(PropertyDescriptor[] propertyDescriptorArr) {
        HashMap<String, PropertyDescriptor> hashMap = new HashMap<>();
        for (int i = 0; i < propertyDescriptorArr.length; i++) {
            hashMap.put(propertyDescriptorArr[i].b(), propertyDescriptorArr[i]);
        }
        return hashMap;
    }

    private static HashMap<String, MethodDescriptor> b(MethodDescriptor[] methodDescriptorArr) {
        HashMap<String, MethodDescriptor> hashMap = new HashMap<>();
        for (int i = 0; i < methodDescriptorArr.length; i++) {
            hashMap.put(a(methodDescriptorArr[i].a()), methodDescriptorArr[i]);
        }
        return hashMap;
    }

    private static HashMap<String, EventSetDescriptor> a(EventSetDescriptor[] eventSetDescriptorArr) {
        HashMap<String, EventSetDescriptor> hashMap = new HashMap<>();
        for (int i = 0; i < eventSetDescriptorArr.length; i++) {
            hashMap.put(eventSetDescriptorArr[i].b(), eventSetDescriptorArr[i]);
        }
        return hashMap;
    }

    private static String a(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes != null) {
            for (int i = 0; i < parameterTypes.length; i++) {
                name = String.valueOf(name) + "_" + parameterTypes[i].getName();
            }
        }
        return name;
    }

    private MethodDescriptor[] i() {
        return a(false, this.j);
    }

    private MethodDescriptor[] a(boolean z) {
        return a(z, this.j);
    }

    private MethodDescriptor[] a(boolean z, Class<?> cls) {
        Method[] methods = z ? cls.getMethods() : cls.getDeclaredMethods();
        if (methods == null || methods.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(methods.length);
        for (int i = 0; i < methods.length; i++) {
            if (Modifier.isPublic(methods[i].getModifiers())) {
                arrayList.add(new MethodDescriptor(methods[i]));
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            return (MethodDescriptor[]) arrayList.toArray(new MethodDescriptor[size]);
        }
        return null;
    }

    private PropertyDescriptor[] a(Class<?> cls) {
        PropertyDescriptor indexedPropertyDescriptor;
        MethodDescriptor[] a2;
        MethodDescriptor[] i = i();
        if (i == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i.length; i2++) {
            if (!Modifier.isStatic(i[i2].a().getModifiers())) {
                arrayList.add(i[i2]);
            }
        }
        int size = arrayList.size();
        MethodDescriptor[] methodDescriptorArr = size > 0 ? (MethodDescriptor[]) arrayList.toArray(new MethodDescriptor[size]) : null;
        if (methodDescriptorArr == null) {
            return null;
        }
        HashMap<String, HashMap> hashMap = new HashMap<>(methodDescriptorArr.length);
        for (int i3 = 0; i3 < methodDescriptorArr.length; i3++) {
            a(methodDescriptorArr[i3].a(), hashMap);
            b(methodDescriptorArr[i3].a(), hashMap);
        }
        a(hashMap);
        MethodDescriptor[] a3 = a(true);
        if (cls != null && (a2 = a(true, cls)) != null) {
            ArrayList arrayList2 = new ArrayList();
            for (MethodDescriptor methodDescriptor : a3) {
                if (!a(methodDescriptor, a2)) {
                    arrayList2.add(methodDescriptor);
                }
            }
            a3 = (MethodDescriptor[]) arrayList2.toArray(new MethodDescriptor[0]);
        }
        for (MethodDescriptor methodDescriptor2 : a3) {
            b(methodDescriptor2.a());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry<String, HashMap> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            HashMap value = entry.getValue();
            if (value != null) {
                String str = (String) value.get("normal");
                String str2 = (String) value.get("indexed");
                if (str != null || str2 != null) {
                    Method method = (Method) value.get("normalget");
                    Method method2 = (Method) value.get("normalset");
                    Method method3 = (Method) value.get("indexedget");
                    Method method4 = (Method) value.get("indexedset");
                    if (str2 == null) {
                        indexedPropertyDescriptor = new PropertyDescriptor(key, method, method2);
                    } else {
                        try {
                            indexedPropertyDescriptor = new IndexedPropertyDescriptor(key, method, method2, method3, method4);
                        } catch (IntrospectionException e) {
                            indexedPropertyDescriptor = new IndexedPropertyDescriptor(key, null, null, method3, method4);
                        }
                    }
                    if (this.n && this.o) {
                        indexedPropertyDescriptor.b(true);
                    } else {
                        indexedPropertyDescriptor.b(false);
                    }
                    if (value.get("isConstrained") == Boolean.TRUE) {
                        indexedPropertyDescriptor.a(true);
                    }
                    arrayList3.add(indexedPropertyDescriptor);
                }
            }
        }
        PropertyDescriptor[] propertyDescriptorArr = new PropertyDescriptor[arrayList3.size()];
        arrayList3.toArray(propertyDescriptorArr);
        return propertyDescriptorArr;
    }

    private boolean a(MethodDescriptor methodDescriptor, MethodDescriptor[] methodDescriptorArr) {
        for (MethodDescriptor methodDescriptor2 : methodDescriptorArr) {
            if (methodDescriptor.a().equals(methodDescriptor2.a())) {
                return true;
            }
        }
        return false;
    }

    private void b(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 1) {
            if (name.equals("addPropertyChangeListener") && parameterTypes[0].equals(d.class)) {
                this.n = true;
            }
            if (name.equals("removePropertyChangeListener") && parameterTypes[0].equals(d.class)) {
                this.o = true;
            }
        }
    }

    private static void a(Method method, HashMap<String, HashMap> hashMap) {
        Class<?> returnType;
        HashMap hashMap2;
        String name = method.getName();
        if (name != null) {
            int length = name.startsWith("get") ? "get".length() : 0;
            if (name.startsWith("is")) {
                length = "is".length();
            }
            if (length != 0) {
                String a2 = c.a(name.substring(length));
                if (b(a2) && (returnType = method.getReturnType()) != null && returnType != Void.TYPE) {
                    if (length != 2 || returnType == Boolean.TYPE) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length <= 1) {
                            if (parameterTypes.length != 1 || parameterTypes[0] == Integer.TYPE) {
                                HashMap hashMap3 = hashMap.get(a2);
                                if (hashMap3 == null) {
                                    HashMap hashMap4 = new HashMap();
                                    hashMap.put(a2, hashMap4);
                                    hashMap2 = hashMap4;
                                } else {
                                    hashMap2 = hashMap3;
                                }
                                ArrayList arrayList = (ArrayList) hashMap2.get("getters");
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    hashMap2.put("getters", arrayList);
                                }
                                arrayList.add(method);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void b(Method method, HashMap<String, HashMap> hashMap) {
        HashMap hashMap2;
        String name = method.getName();
        if (name != null && method.getReturnType() == Void.TYPE && name != null && name.startsWith("set")) {
            String a2 = c.a(name.substring("set".length()));
            if (b(a2)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 0 && parameterTypes.length <= 2) {
                    if (parameterTypes.length != 2 || parameterTypes[0] == Integer.TYPE) {
                        HashMap hashMap3 = hashMap.get(a2);
                        if (hashMap3 == null) {
                            HashMap hashMap4 = new HashMap();
                            hashMap.put(a2, hashMap4);
                            hashMap2 = hashMap4;
                        } else {
                            hashMap2 = hashMap3;
                        }
                        ArrayList arrayList = (ArrayList) hashMap2.get("setters");
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            hashMap2.put("setters", arrayList);
                        }
                        for (Class<?> cls : method.getExceptionTypes()) {
                            if (cls.equals(PropertyVetoException.class)) {
                                hashMap2.put("isConstrained", Boolean.TRUE);
                            }
                        }
                        arrayList.add(method);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x022f, code lost:
        if (r7 != null) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0231, code lost:
        if (r3 == null) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0233, code lost:
        if (r6 == null) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0235, code lost:
        r0.put("normal", "valid");
        r0.put("normalget", r5);
        r0.put("normalset", r7);
        r0.put("normalPropertyType", r2);
        r0.put("indexed", "valid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x025c, code lost:
        if (r3.getName().startsWith("get") == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x025e, code lost:
        r0.put("indexedget", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0263, code lost:
        r0.put("indexedset", r6);
        r0.put("indexedPropertyType", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x029d, code lost:
        if (r7 != null) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x029f, code lost:
        if (r3 == null) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02a1, code lost:
        if (r6 != null) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02ad, code lost:
        if (r3.getName().startsWith("get") == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02af, code lost:
        r0.put("normal", "valid");
        r0.put("normalget", r5);
        r0.put("normalset", r7);
        r0.put("normalPropertyType", r2);
        r0.put("indexed", "valid");
        r0.put("indexedget", r3);
        r0.put("indexedset", r6);
        r0.put("indexedPropertyType", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02dd, code lost:
        r0.put("normal", "valid");
        r0.put("normalget", r5);
        r0.put("normalset", r7);
        r0.put("normalPropertyType", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0351, code lost:
        if (r7 != null) goto L225;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0353, code lost:
        if (r3 != null) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0355, code lost:
        if (r6 == null) goto L212;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0357, code lost:
        r0.put("indexed", "valid");
        r0.put("indexedget", r3);
        r0.put("indexedset", r6);
        r0.put("indexedPropertyType", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0391, code lost:
        if (r5 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0393, code lost:
        if (r3 != null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0395, code lost:
        if (r6 == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0397, code lost:
        if (r3 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03a3, code lost:
        if (r3.getName().startsWith("is") == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03a5, code lost:
        if (r6 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03a7, code lost:
        r0.put("indexed", "valid");
        r0.put("indexedset", r6);
        r0.put("indexedPropertyType", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03ba, code lost:
        r0.put("indexed", "valid");
        r0.put("indexedget", r3);
        r0.put("indexedset", r6);
        r0.put("indexedPropertyType", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x018a, code lost:
        if (r7 == null) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<String, HashMap> hashMap) {
        Method method;
        Method method2;
        Class<?> cls;
        Class<?> cls2;
        if (hashMap != null) {
            for (Map.Entry<String, HashMap> entry : hashMap.entrySet()) {
                HashMap value = entry.getValue();
                ArrayList arrayList = (ArrayList) value.get("getters");
                ArrayList arrayList2 = (ArrayList) value.get("setters");
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                Iterator it = arrayList.iterator();
                Method method3 = null;
                Method method4 = null;
                while (it.hasNext()) {
                    Method method5 = (Method) it.next();
                    Class<?>[] parameterTypes = method5.getParameterTypes();
                    String name = method5.getName();
                    if ((parameterTypes == null || parameterTypes.length == 0) && (method4 == null || name.startsWith("is"))) {
                        method4 = method5;
                    }
                    if (parameterTypes != null && parameterTypes.length == 1 && parameterTypes[0] == Integer.TYPE && (method3 == null || name.startsWith("get") || (name.startsWith("is") && !method3.getName().startsWith("get")))) {
                        method3 = method5;
                    }
                }
                if (method4 != null) {
                    Class<?> returnType = method4.getReturnType();
                    Iterator it2 = arrayList2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            method = null;
                            break;
                        }
                        Method method6 = (Method) it2.next();
                        if (method6.getParameterTypes().length == 1 && returnType.equals(method6.getParameterTypes()[0])) {
                            method = method6;
                            break;
                        }
                    }
                } else {
                    Iterator it3 = arrayList2.iterator();
                    Method method7 = null;
                    while (it3.hasNext()) {
                        Method method8 = (Method) it3.next();
                        if (method8.getParameterTypes().length == 1) {
                            method7 = method8;
                        }
                    }
                    method = method7;
                }
                if (method3 != null) {
                    Class<?> returnType2 = method3.getReturnType();
                    Iterator it4 = arrayList2.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            method2 = null;
                            break;
                        }
                        Method method9 = (Method) it4.next();
                        if (method9.getParameterTypes().length == 2 && method9.getParameterTypes()[0] == Integer.TYPE && returnType2.equals(method9.getParameterTypes()[1])) {
                            method2 = method9;
                            break;
                        }
                    }
                } else {
                    Iterator it5 = arrayList2.iterator();
                    Method method10 = null;
                    while (it5.hasNext()) {
                        Method method11 = (Method) it5.next();
                        if (method11.getParameterTypes().length == 2 && method11.getParameterTypes()[0] == Integer.TYPE) {
                            method10 = method11;
                        }
                    }
                    method2 = method10;
                }
                if (method4 != null) {
                    cls = method4.getReturnType();
                } else {
                    cls = method != null ? method.getParameterTypes()[0] : null;
                }
                if (method3 != null) {
                    cls2 = method3.getReturnType();
                } else {
                    cls2 = method2 != null ? method2.getParameterTypes()[1] : null;
                }
                if (method4 != null) {
                    method4.getReturnType().isArray();
                }
                if (method4 != null && method != null && (method3 == null || method2 == null)) {
                    value.put("normal", "valid");
                    value.put("normalget", method4);
                    value.put("normalset", method);
                    value.put("normalPropertyType", cls);
                } else {
                    if (method3 == null && method2 == null) {
                        value.put("normal", "valid");
                        value.put("normalget", method4);
                        value.put("normalset", method);
                        value.put("normalPropertyType", cls);
                    }
                    if ((method4 != null || method != null) && (method3 != null || method2 != null)) {
                        if (method4 != null && method != null && method3 != null && method2 != null) {
                            if (method3.getName().startsWith("get")) {
                                value.put("normal", "valid");
                                value.put("normalget", method4);
                                value.put("normalset", method);
                                value.put("normalPropertyType", cls);
                                value.put("indexed", "valid");
                                value.put("indexedget", method3);
                                value.put("indexedset", method2);
                                value.put("indexedPropertyType", cls2);
                            } else if (cls != Boolean.TYPE && method4.getName().startsWith("is")) {
                                value.put("indexed", "valid");
                                value.put("indexedset", method2);
                                value.put("indexedPropertyType", cls2);
                            } else {
                                value.put("normal", "valid");
                                value.put("normalget", method4);
                                value.put("normalset", method);
                                value.put("normalPropertyType", cls);
                            }
                        } else if (method4 == null && method != null && method3 != null && method2 != null) {
                            value.put("indexed", "valid");
                            if (method3.getName().startsWith("get")) {
                                value.put("indexedget", method3);
                            }
                            value.put("indexedset", method2);
                            value.put("indexedPropertyType", cls2);
                        } else if (method4 == null && method != null && method3 != null && method2 == null) {
                            if (method3.getName().startsWith("get")) {
                                value.put("normal", "valid");
                                value.put("normalget", method4);
                                value.put("normalset", method);
                                value.put("normalPropertyType", cls);
                                value.put("indexed", "valid");
                                value.put("indexedget", method3);
                                value.put("indexedset", method2);
                                value.put("indexedPropertyType", cls2);
                            } else {
                                value.put("normal", "valid");
                                value.put("normalget", method4);
                                value.put("normalset", method);
                                value.put("normalPropertyType", cls);
                            }
                        } else if (method4 == null && method != null && method3 == null && method2 != null) {
                            value.put("indexed", "valid");
                            value.put("indexedget", method3);
                            value.put("indexedset", method2);
                            value.put("indexedPropertyType", cls2);
                        }
                    }
                    if ((method != null || method4 != null) && method3 != null && method2 != null) {
                        value.put("indexed", "valid");
                        value.put("indexedget", method3);
                        value.put("indexedset", method2);
                        value.put("indexedPropertyType", cls2);
                    } else {
                        value.put("normal", "invalid");
                        value.put("indexed", "invalid");
                    }
                }
            }
        }
    }

    private EventSetDescriptor[] j() {
        MethodDescriptor[] i = i();
        if (i == null) {
            return null;
        }
        HashMap hashMap = new HashMap(i.length);
        for (int i2 = 0; i2 < i.length; i2++) {
            a("add", i[i2].a(), hashMap);
            a("remove", i[i2].a(), hashMap);
            c(i[i2].a(), hashMap);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            HashMap hashMap2 = (HashMap) entry.getValue();
            Method method = (Method) hashMap2.get("add");
            Method method2 = (Method) hashMap2.get("remove");
            if (method != null && method2 != null) {
                EventSetDescriptor eventSetDescriptor = new EventSetDescriptor(c.a((String) entry.getKey()), (Class) hashMap2.get("listenerType"), (Method[]) hashMap2.get("listenerMethods"), method, method2, (Method) hashMap2.get("get"));
                eventSetDescriptor.a(hashMap2.get("isUnicast") != null);
                arrayList.add(eventSetDescriptor);
            }
        }
        EventSetDescriptor[] eventSetDescriptorArr = new EventSetDescriptor[arrayList.size()];
        arrayList.toArray(eventSetDescriptorArr);
        return eventSetDescriptorArr;
    }

    private static void a(String str, Method method, HashMap<String, HashMap> hashMap) {
        Class<?>[] parameterTypes;
        Class<?>[] exceptionTypes;
        int i = 0;
        String name = method.getName();
        if (name != null && name.startsWith(str) && name.endsWith("Listener")) {
            String substring = name.substring(str.length());
            String substring2 = substring.substring(0, substring.lastIndexOf("Listener"));
            if (substring2 != null && substring2.length() != 0 && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 1) {
                Class<?> cls = parameterTypes[0];
                if (EventListener.class.isAssignableFrom(cls) && cls.getName().endsWith(substring)) {
                    HashMap hashMap2 = hashMap.get(substring2);
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                    }
                    if (hashMap2.get("listenerType") == null) {
                        hashMap2.put("listenerType", cls);
                        hashMap2.put("listenerMethods", b(cls));
                    }
                    hashMap2.put(str, method);
                    if (str.equals("add") && (exceptionTypes = method.getExceptionTypes()) != null) {
                        while (true) {
                            if (i >= exceptionTypes.length) {
                                break;
                            } else if (!exceptionTypes[i].getName().equals(TooManyListenersException.class.getName())) {
                                i++;
                            } else {
                                hashMap2.put("isUnicast", "true");
                                break;
                            }
                        }
                    }
                    hashMap.put(substring2, hashMap2);
                }
            }
        }
    }

    private static Method[] b(Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < declaredMethods.length; i++) {
            Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
            if (parameterTypes.length == 1 && EventObject.class.isAssignableFrom(parameterTypes[0])) {
                arrayList.add(declaredMethods[i]);
            }
        }
        Method[] methodArr = new Method[arrayList.size()];
        arrayList.toArray(methodArr);
        return methodArr;
    }

    private static void c(Method method, HashMap<String, HashMap> hashMap) {
        Class<?>[] parameterTypes;
        String name = method.getName();
        if (name != null && name.startsWith("get") && name.endsWith("Listeners")) {
            String substring = name.substring("get".length(), name.length() - 1);
            String substring2 = substring.substring(0, substring.lastIndexOf("Listener"));
            if (substring2 != null && substring2.length() != 0 && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 0) {
                Class<?> returnType = method.getReturnType();
                if (returnType.getComponentType() != null && returnType.getComponentType().getName().endsWith(substring)) {
                    HashMap hashMap2 = hashMap.get(substring2);
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                    }
                    hashMap2.put("get", method);
                    hashMap.put(substring2, hashMap2);
                }
            }
        }
    }

    private static boolean b(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        String str;
        if (this.f == null) {
            this.f = new EventSetDescriptor[0];
        }
        if (this.h == null) {
            this.h = new PropertyDescriptor[0];
        }
        if (this.h != null) {
            if (this.l != -1) {
                str = this.h[this.l].b();
            } else {
                str = null;
            }
            Arrays.sort(this.h, m);
            if (str != null) {
                for (int i = 0; i < this.h.length; i++) {
                    if (str.equals(this.h[i].b())) {
                        this.l = i;
                        return;
                    }
                }
            }
        }
    }
}
