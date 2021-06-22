package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.i;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* loaded from: classes6.dex */
public final class m<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29924a;

    /* renamed from: b  reason: collision with root package name */
    public final v<T> f29925b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f29926c;

    public m(com.bytedance.sdk.openadsdk.preload.a.f fVar, v<T> vVar, Type type) {
        this.f29924a = fVar;
        this.f29925b = vVar;
        this.f29926c = type;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        v<T> vVar = this.f29925b;
        Type a2 = a(this.f29926c, t);
        if (a2 != this.f29926c) {
            vVar = this.f29924a.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a2));
            if (vVar instanceof i.a) {
                v<T> vVar2 = this.f29925b;
                if (!(vVar2 instanceof i.a)) {
                    vVar = vVar2;
                }
            }
        }
        vVar.a(cVar, t);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        return this.f29925b.b(aVar);
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
