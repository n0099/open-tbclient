package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class a<E> extends v<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f29779a = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.a.1
        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            Type b2 = aVar.b();
            if ((b2 instanceof GenericArrayType) || ((b2 instanceof Class) && ((Class) b2).isArray())) {
                Type g2 = com.bytedance.sdk.openadsdk.preload.a.b.b.g(b2);
                return new a(fVar, fVar.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(g2)), com.bytedance.sdk.openadsdk.preload.a.b.b.e(g2));
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final Class<E> f29780b;

    /* renamed from: c  reason: collision with root package name */
    public final v<E> f29781c;

    public a(com.bytedance.sdk.openadsdk.preload.a.f fVar, v<E> vVar, Class<E> cls) {
        this.f29781c = new m(fVar, vVar, cls);
        this.f29780b = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.bytedance.sdk.openadsdk.preload.a.v<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        cVar.b();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f29781c.a(cVar, Array.get(obj, i2));
        }
        cVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.f29781c.b(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f29780b, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(newInstance, i2, arrayList.get(i2));
        }
        return newInstance;
    }
}
