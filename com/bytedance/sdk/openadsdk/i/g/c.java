package com.bytedance.sdk.openadsdk.i.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.p;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class c {
    private static c e;

    /* renamed from: a  reason: collision with root package name */
    private Context f4847a;
    private Object b;
    private Method c;
    private Method d;

    public static c a() {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c();
                }
            }
        }
        return e;
    }

    private c() {
        this.f4847a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f4847a = p.a();
        if (this.f4847a != null) {
            this.b = this.f4847a.getSystemService("storage");
            try {
                this.c = this.b.getClass().getMethod("getVolumeList", new Class[0]);
                this.d = this.b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean b() {
        Object[] objArr;
        if (this.b == null || this.c == null || this.d == null) {
            return false;
        }
        try {
            objArr = (Object[]) this.c.invoke(this.b, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (objArr == null || objArr.length == 0) {
            return false;
        }
        Method method = objArr[0].getClass().getMethod("getPath", new Class[0]);
        Method method2 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
        if (method == null || method2 == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (((Boolean) method2.invoke(obj, new Object[0])).booleanValue() && this.d.invoke(this.b, (String) method.invoke(obj, new Object[0])).equals("mounted")) {
                return true;
            }
        }
        return false;
    }
}
