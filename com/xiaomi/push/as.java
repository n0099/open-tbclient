package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
class as implements ar {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f116a;

    /* renamed from: a  reason: collision with other field name */
    private Object f117a;

    /* renamed from: a  reason: collision with other field name */
    private Method f118a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f117a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f117a, context);
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
            this.f116a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f117a = this.f116a.newInstance();
            this.f118a = this.f116a.getMethod("getUDID", Context.class);
            this.b = this.f116a.getMethod("getOAID", Context.class);
            this.c = this.f116a.getMethod("getVAID", Context.class);
            this.d = this.f116a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m132a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.a, this.f118a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f116a == null || this.f117a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo129b() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.a, this.d);
    }
}
