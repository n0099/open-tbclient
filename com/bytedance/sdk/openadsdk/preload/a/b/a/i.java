package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.t;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class i implements w {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f29809a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.e f29810b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.d f29811c;

    /* renamed from: d  reason: collision with root package name */
    public final d f29812d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.b.b f29813e = com.bytedance.sdk.openadsdk.preload.a.b.b.b.a();

    /* loaded from: classes6.dex */
    public static final class a<T> extends v<T> {

        /* renamed from: a  reason: collision with root package name */
        public final com.bytedance.sdk.openadsdk.preload.a.b.i<T> f29821a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, b> f29822b;

        public a(com.bytedance.sdk.openadsdk.preload.a.b.i<T> iVar, Map<String, b> map) {
            this.f29821a = iVar;
            this.f29822b = map;
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
            if (t == null) {
                cVar.f();
                return;
            }
            cVar.d();
            try {
                for (b bVar : this.f29822b.values()) {
                    if (bVar.a(t)) {
                        cVar.a(bVar.f29823h);
                        bVar.a(cVar, t);
                    }
                }
                cVar.e();
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.preload.a.v
        public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
            if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
                aVar.j();
                return null;
            }
            T a2 = this.f29821a.a();
            try {
                aVar.c();
                while (aVar.e()) {
                    b bVar = this.f29822b.get(aVar.g());
                    if (bVar != null && bVar.j) {
                        bVar.a(aVar, a2);
                    }
                    aVar.n();
                }
                aVar.d();
                return a2;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (IllegalStateException e3) {
                throw new t(e3);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b {

        /* renamed from: h  reason: collision with root package name */
        public final String f29823h;

        /* renamed from: i  reason: collision with root package name */
        public final boolean f29824i;
        public final boolean j;

        public b(String str, boolean z, boolean z2) {
            this.f29823h = str;
            this.f29824i = z;
            this.j = z2;
        }

        public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar, Object obj) throws IOException, IllegalAccessException;

        public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException;

        public abstract boolean a(Object obj) throws IOException, IllegalAccessException;
    }

    public i(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, com.bytedance.sdk.openadsdk.preload.a.e eVar, com.bytedance.sdk.openadsdk.preload.a.b.d dVar, d dVar2) {
        this.f29809a = cVar;
        this.f29810b = eVar;
        this.f29811c = dVar;
        this.f29812d = dVar2;
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.f29811c);
    }

    public static boolean a(Field field, boolean z, com.bytedance.sdk.openadsdk.preload.a.b.d dVar) {
        return (dVar.a(field.getType(), z) || dVar.a(field, z)) ? false : true;
    }

    private List<String> a(Field field) {
        com.bytedance.sdk.openadsdk.preload.a.a.c cVar = (com.bytedance.sdk.openadsdk.preload.a.a.c) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f29810b.a(field));
        }
        String a2 = cVar.a();
        String[] b2 = cVar.b();
        if (b2.length == 0) {
            return Collections.singletonList(a2);
        }
        ArrayList arrayList = new ArrayList(b2.length + 1);
        arrayList.add(a2);
        for (String str : b2) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new a(this.f29809a.a(aVar), a(fVar, (com.bytedance.sdk.openadsdk.preload.a.c.a<?>) aVar, (Class<?>) a2));
        }
        return null;
    }

    private b a(final com.bytedance.sdk.openadsdk.preload.a.f fVar, final Field field, String str, final com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, boolean z, boolean z2) {
        final boolean a2 = com.bytedance.sdk.openadsdk.preload.a.b.k.a(aVar.a());
        com.bytedance.sdk.openadsdk.preload.a.a.b bVar = (com.bytedance.sdk.openadsdk.preload.a.a.b) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.b.class);
        v<?> a3 = bVar != null ? this.f29812d.a(this.f29809a, fVar, aVar, bVar) : null;
        final boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) aVar);
        }
        final v<?> vVar = a3;
        return new b(str, z, z2) { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.i.1
            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException, IllegalAccessException {
                (z3 ? vVar : new m(fVar, vVar, aVar.b())).a(cVar, field.get(obj));
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2, Object obj) throws IOException, IllegalAccessException {
                Object b2 = vVar.b(aVar2);
                if (b2 == null && a2) {
                    return;
                }
                field.set(obj, b2);
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.a.i.b
            public boolean a(Object obj) throws IOException, IllegalAccessException {
                return this.f29824i && field.get(obj) != obj;
            }
        };
    }

    private Map<String, b> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, Class<?> cls) {
        b bVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i2 = 0;
            while (i2 < length) {
                Field field = declaredFields[i2];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    this.f29813e.a(field);
                    Type a4 = com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    b bVar2 = null;
                    int i3 = 0;
                    while (i3 < size) {
                        String str = a5.get(i3);
                        boolean z2 = i3 != 0 ? false : a2;
                        int i4 = i3;
                        b bVar3 = bVar2;
                        int i5 = size;
                        List<String> list = a5;
                        Field field2 = field;
                        bVar2 = bVar3 == null ? (b) linkedHashMap.put(str, a(fVar, field, str, com.bytedance.sdk.openadsdk.preload.a.c.a.a(a4), z2, a3)) : bVar3;
                        i3 = i4 + 1;
                        a2 = z2;
                        a5 = list;
                        size = i5;
                        field = field2;
                    }
                    if (bVar2 != null) {
                        throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar.f29823h);
                    }
                }
                i2++;
                z = false;
            }
            aVar2 = com.bytedance.sdk.openadsdk.preload.a.c.a.a(com.bytedance.sdk.openadsdk.preload.a.b.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }
}
