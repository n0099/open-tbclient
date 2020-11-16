package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes18.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f4799a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f114a;

    /* renamed from: a  reason: collision with other field name */
    private Object f115a;

    /* renamed from: a  reason: collision with other field name */
    private Method f116a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f4799a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f115a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f115a, context);
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
            this.f114a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f115a = this.f114a.newInstance();
            this.f116a = this.f114a.getMethod("getUDID", Context.class);
            this.b = this.f114a.getMethod("getOAID", Context.class);
            this.c = this.f114a.getMethod("getVAID", Context.class);
            this.d = this.f114a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m141a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f4799a, this.f116a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f114a == null || this.f115a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo138b() {
        return a(this.f4799a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f4799a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f4799a, this.d);
    }
}
