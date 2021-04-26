package com.bytedance.sdk.openadsdk.k.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static c f30293e;

    /* renamed from: a  reason: collision with root package name */
    public Context f30294a;

    /* renamed from: b  reason: collision with root package name */
    public Object f30295b;

    /* renamed from: c  reason: collision with root package name */
    public Method f30296c;

    /* renamed from: d  reason: collision with root package name */
    public Method f30297d;

    public c() {
        this.f30294a = null;
        this.f30295b = null;
        this.f30296c = null;
        this.f30297d = null;
        Context a2 = p.a();
        this.f30294a = a2;
        if (a2 != null) {
            Object systemService = a2.getSystemService("storage");
            this.f30295b = systemService;
            try {
                this.f30296c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f30297d = this.f30295b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f30293e == null) {
            synchronized (c.class) {
                if (f30293e == null) {
                    f30293e = new c();
                }
            }
        }
        return f30293e;
    }

    public boolean b() {
        Method method;
        Object obj = this.f30295b;
        if (obj != null && (method = this.f30296c) != null && this.f30297d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f30297d.invoke(this.f30295b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
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
