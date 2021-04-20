package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.i;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes5.dex */
public final class m<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29651a;

    /* renamed from: b  reason: collision with root package name */
    public final v<T> f29652b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f29653c;

    public m(com.bytedance.sdk.openadsdk.preload.a.f fVar, v<T> vVar, Type type) {
        this.f29651a = fVar;
        this.f29652b = vVar;
        this.f29653c = type;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        v<T> vVar = this.f29652b;
        Type a2 = a(this.f29653c, t);
        if (a2 != this.f29653c) {
            vVar = this.f29651a.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a2));
            if (vVar instanceof i.a) {
                v<T> vVar2 = this.f29652b;
                if (!(vVar2 instanceof i.a)) {
                    vVar = vVar2;
                }
            }
        }
        vVar.a(cVar, t);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        return this.f29652b.b(aVar);
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
