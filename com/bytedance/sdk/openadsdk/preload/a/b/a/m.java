package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a.i;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class m<T> extends v<T> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.preload.a.f f4973a;
    private final v<T> b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.bytedance.sdk.openadsdk.preload.a.f fVar, v<T> vVar, Type type) {
        this.f4973a = fVar;
        this.b = vVar;
        this.c = type;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        return this.b.b(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
        v<T> vVar = this.b;
        Type a2 = a(this.c, t);
        if (a2 != this.c) {
            vVar = this.f4973a.a((com.bytedance.sdk.openadsdk.preload.a.c.a) com.bytedance.sdk.openadsdk.preload.a.c.a.a(a2));
            if ((vVar instanceof i.a) && !(this.b instanceof i.a)) {
                vVar = this.b;
            }
        }
        vVar.a(cVar, t);
    }

    private Type a(Type type, Object obj) {
        if (obj != null) {
            if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }
}
