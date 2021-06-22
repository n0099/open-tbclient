package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class h extends v<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final w f29888a = new w() { // from class: com.bytedance.sdk.openadsdk.preload.a.b.a.h.1
        @Override // com.bytedance.sdk.openadsdk.preload.a.w
        public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
            if (aVar.a() == Object.class) {
                return new h(fVar);
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.f f29889b;

    /* renamed from: com.bytedance.sdk.openadsdk.preload.a.b.a.h$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29890a;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.preload.a.d.b.values().length];
            f29890a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29890a[com.bytedance.sdk.openadsdk.preload.a.d.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29890a[com.bytedance.sdk.openadsdk.preload.a.d.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29890a[com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29890a[com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29890a[com.bytedance.sdk.openadsdk.preload.a.d.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public h(com.bytedance.sdk.openadsdk.preload.a.f fVar) {
        this.f29889b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, Object obj) throws IOException {
        if (obj == null) {
            cVar.f();
            return;
        }
        v a2 = this.f29889b.a((Class) obj.getClass());
        if (a2 instanceof h) {
            cVar.d();
            cVar.e();
            return;
        }
        a2.a(cVar, obj);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public Object b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        switch (AnonymousClass2.f29890a[aVar.f().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(b(aVar));
                }
                aVar.b();
                return arrayList;
            case 2:
                com.bytedance.sdk.openadsdk.preload.a.b.h hVar = new com.bytedance.sdk.openadsdk.preload.a.b.h();
                aVar.c();
                while (aVar.e()) {
                    hVar.put(aVar.g(), b(aVar));
                }
                aVar.d();
                return hVar;
            case 3:
                return aVar.h();
            case 4:
                return Double.valueOf(aVar.k());
            case 5:
                return Boolean.valueOf(aVar.i());
            case 6:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
