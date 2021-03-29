package com.bytedance.sdk.openadsdk.k.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f29697e;

    /* renamed from: a  reason: collision with root package name */
    public Context f29698a;

    /* renamed from: b  reason: collision with root package name */
    public Object f29699b;

    /* renamed from: c  reason: collision with root package name */
    public Method f29700c;

    /* renamed from: d  reason: collision with root package name */
    public Method f29701d;

    public c() {
        this.f29698a = null;
        this.f29699b = null;
        this.f29700c = null;
        this.f29701d = null;
        Context a2 = p.a();
        this.f29698a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f29699b = systemService;
            try {
                this.f29700c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f29701d = this.f29699b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f29697e == null) {
            synchronized (c.class) {
                if (f29697e == null) {
                    f29697e = new c();
                }
            }
        }
        return f29697e;
    }

    public boolean b() {
        Method method;
        Object obj = this.f29699b;
        if (obj != null && (method = this.f29700c) != null && this.f29701d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f29701d.invoke(this.f29699b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
