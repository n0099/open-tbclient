package com.bytedance.sdk.openadsdk.preload.a.b.b;

import com.bytedance.sdk.openadsdk.preload.a.b.e;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f29846a;

    static {
        f29846a = e.a() < 9 ? new a() : new c();
    }

    public static b a() {
        return f29846a;
    }

    public abstract void a(AccessibleObject accessibleObject);
}
