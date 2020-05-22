package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
class as implements ar {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f110a;

    /* renamed from: a  reason: collision with other field name */
    private Object f111a;

    /* renamed from: a  reason: collision with other field name */
    private Method f112a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f111a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f111a, context);
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
            this.f110a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f111a = this.f110a.newInstance();
            this.f112a = this.f110a.getMethod("getUDID", Context.class);
            this.b = this.f110a.getMethod("getOAID", Context.class);
            this.c = this.f110a.getMethod("getVAID", Context.class);
            this.d = this.f110a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m136a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.a, this.f112a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f110a == null || this.f111a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo133b() {
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
