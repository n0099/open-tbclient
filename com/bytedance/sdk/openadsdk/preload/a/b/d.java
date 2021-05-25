package com.bytedance.sdk.openadsdk.preload.a.b;

import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class d implements w, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final d f29806a = new d();

    /* renamed from: e  reason: collision with root package name */
    public boolean f29810e;

    /* renamed from: b  reason: collision with root package name */
    public double f29807b = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    public int f29808c = 136;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29809d = true;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.preload.a.b> f29811f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.preload.a.b> f29812g = Collections.emptyList();

    private boolean b(Class<?> cls, boolean z) {
        for (com.bytedance.sdk.openadsdk.preload.a.b bVar : z ? this.f29811f : this.f29812g) {
            if (bVar.a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    private boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(final com.bytedance.sdk.openadsdk.preload.a.f fVar, final com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        boolean a3 = a(a2);
        final boolean z = a3 || b(a2, true);
        final boolean z2 = a3 || b(a2, false);
        if (z || z2) {
            return new v<T>() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.d.1

                /* renamed from: f  reason: collision with root package name */
                public v<T> f29818f;

                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
                    if (z) {
                        cVar.f();
                    } else {
                        b().a(cVar, t);
                    }
                }

                /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
                @Override // com.bytedance.sdk.openadsdk.preload.a.v
                public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar2) throws IOException {
                    if (z2) {
                        aVar2.n();
                        return null;
                    }
                    return b().b(aVar2);
                }

                private v<T> b() {
                    v<T> vVar = this.f29818f;
                    if (vVar != 0) {
                        return vVar;
                    }
                    v<T> a4 = fVar.a(d.this, aVar);
                    this.f29818f = a4;
                    return a4;
                }
            };
        }
        return null;
    }

    private boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean a(Field field, boolean z) {
        com.bytedance.sdk.openadsdk.preload.a.a.a aVar;
        if ((this.f29808c & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f29807b == -1.0d || a((com.bytedance.sdk.openadsdk.preload.a.a.d) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (com.bytedance.sdk.openadsdk.preload.a.a.e) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.e.class))) && !field.isSynthetic()) {
            if (!this.f29810e || ((aVar = (com.bytedance.sdk.openadsdk.preload.a.a.a) field.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.a.class)) != null && (!z ? !aVar.b() : !aVar.a()))) {
                if ((this.f29809d || !c(field.getType())) && !b(field.getType())) {
                    List<com.bytedance.sdk.openadsdk.preload.a.b> list = z ? this.f29811f : this.f29812g;
                    if (list.isEmpty()) {
                        return false;
                    }
                    com.bytedance.sdk.openadsdk.preload.a.c cVar = new com.bytedance.sdk.openadsdk.preload.a.c(field);
                    for (com.bytedance.sdk.openadsdk.preload.a.b bVar : list) {
                        if (bVar.a(cVar)) {
                            return true;
                        }
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean a(Class<?> cls) {
        if (this.f29807b == -1.0d || a((com.bytedance.sdk.openadsdk.preload.a.a.d) cls.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.d.class), (com.bytedance.sdk.openadsdk.preload.a.a.e) cls.getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.e.class))) {
            return (!this.f29809d && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar, com.bytedance.sdk.openadsdk.preload.a.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.d dVar) {
        return dVar == null || dVar.a() <= this.f29807b;
    }

    private boolean a(com.bytedance.sdk.openadsdk.preload.a.a.e eVar) {
        return eVar == null || eVar.a() > this.f29807b;
    }
}
