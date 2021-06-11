package com.bytedance.sdk.openadsdk.k.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f29570e;

    /* renamed from: a  reason: collision with root package name */
    public Context f29571a;

    /* renamed from: b  reason: collision with root package name */
    public Object f29572b;

    /* renamed from: c  reason: collision with root package name */
    public Method f29573c;

    /* renamed from: d  reason: collision with root package name */
    public Method f29574d;

    public c() {
        this.f29571a = null;
        this.f29572b = null;
        this.f29573c = null;
        this.f29574d = null;
        Context a2 = p.a();
        this.f29571a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f29572b = systemService;
            try {
                this.f29573c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f29574d = this.f29572b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f29570e == null) {
            synchronized (c.class) {
                if (f29570e == null) {
                    f29570e = new c();
                }
            }
        }
        return f29570e;
    }

    public boolean b() {
        Method method;
        Object obj = this.f29572b;
        if (obj != null && (method = this.f29573c) != null && this.f29574d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f29574d.invoke(this.f29572b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
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
