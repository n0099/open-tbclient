package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.b.e;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    private static final b f4987a;

    public abstract void a(AccessibleObject accessibleObject);

    static {
        f4987a = e.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f4987a;
    }
}
