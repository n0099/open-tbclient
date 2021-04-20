package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.b.e;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f29686a;

    static {
        f29686a = e.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f29686a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
