package com.bytedance.sdk.openadsdk.preload.geckox.c;

import com.bytedance.sdk.openadsdk.preload.a.d.c;
import com.bytedance.sdk.openadsdk.preload.a.p;
import com.bytedance.sdk.openadsdk.preload.a.v;
import java.io.IOException;
/* loaded from: classes5.dex */
public class a extends v<Boolean> {

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.c.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30854a;

        static {
            int[] iArr = new int[com.bytedance.sdk.openadsdk.preload.a.d.b.values().length];
            f30854a = iArr;
            try {
                iArr[com.bytedance.sdk.openadsdk.preload.a.d.b.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30854a[com.bytedance.sdk.openadsdk.preload.a.d.b.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30854a[com.bytedance.sdk.openadsdk.preload.a.d.b.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    public void a(c cVar, Boolean bool) throws IOException {
        if (bool == null) {
            cVar.f();
        } else {
            cVar.a(bool);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.preload.a.v
    /* renamed from: a */
    public Boolean b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
        com.bytedance.sdk.openadsdk.preload.a.d.b f2 = aVar.f();
        int i2 = AnonymousClass1.f30854a[f2.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                aVar.j();
                return null;
            } else if (i2 == 3) {
                return Boolean.valueOf(aVar.m() != 0);
            } else {
                throw new p("Expected BOOLEAN or NUMBER but was " + f2);
            }
        }
        return Boolean.valueOf(aVar.i());
    }
}
