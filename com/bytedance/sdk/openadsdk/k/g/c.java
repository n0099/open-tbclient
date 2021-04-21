package com.bytedance.sdk.openadsdk.k.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f29390e;

    /* renamed from: a  reason: collision with root package name */
    public Context f29391a;

    /* renamed from: b  reason: collision with root package name */
    public Object f29392b;

    /* renamed from: c  reason: collision with root package name */
    public Method f29393c;

    /* renamed from: d  reason: collision with root package name */
    public Method f29394d;

    public c() {
        this.f29391a = null;
        this.f29392b = null;
        this.f29393c = null;
        this.f29394d = null;
        Context a2 = p.a();
        this.f29391a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f29392b = systemService;
            try {
                this.f29393c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f29394d = this.f29392b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f29390e == null) {
            synchronized (c.class) {
                if (f29390e == null) {
                    f29390e = new c();
                }
            }
        }
        return f29390e;
    }

    public boolean b() {
        Method method;
        Object obj = this.f29392b;
        if (obj != null && (method = this.f29393c) != null && this.f29394d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f29394d.invoke(this.f29392b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
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
