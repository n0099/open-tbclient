package com.qq.e.comm.plugin.d;

import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Method f12279a;

    /* renamed from: b  reason: collision with root package name */
    private Method f12280b;
    private Method c;
    private Method d;
    private final Object e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Object obj) {
        this.e = obj;
        Class<?> cls = obj.getClass();
        try {
            this.f12279a = cls.getMethod("setShowHideAnimationEnabled", Boolean.TYPE);
            this.f12280b = cls.getMethod("isShowing", new Class[0]);
            this.c = cls.getMethod("show", new Class[0]);
            this.d = cls.getMethod("hide", new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        try {
            this.f12279a.invoke(this.e, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        try {
            return ((Boolean) this.f12280b.invoke(this.e, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void b() {
        try {
            this.c.invoke(this.e, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        try {
            this.d.invoke(this.e, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
