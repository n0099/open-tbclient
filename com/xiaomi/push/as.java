package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes18.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f4569a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f112a;

    /* renamed from: a  reason: collision with other field name */
    private Object f113a;

    /* renamed from: a  reason: collision with other field name */
    private Method f114a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f4569a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f113a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f113a, context);
                if (invoke != null) {
                    return (String) invoke;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            }
        }
        return null;
    }

    private void a(Context context) {
        try {
            this.f112a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f113a = this.f112a.newInstance();
            this.f114a = this.f112a.getMethod("getUDID", Context.class);
            this.b = this.f112a.getMethod("getOAID", Context.class);
            this.c = this.f112a.getMethod("getVAID", Context.class);
            this.d = this.f112a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m131a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f4569a, this.f114a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f112a == null || this.f113a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo128b() {
        return a(this.f4569a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f4569a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f4569a, this.d);
    }
}
