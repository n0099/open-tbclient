package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f8262a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f111a;

    /* renamed from: a  reason: collision with other field name */
    private Object f112a;

    /* renamed from: a  reason: collision with other field name */
    private Method f113a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f8262a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f112a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f112a, context);
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
            this.f111a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f112a = this.f111a.newInstance();
            this.f113a = this.f111a.getMethod("getUDID", Context.class);
            this.b = this.f111a.getMethod("getOAID", Context.class);
            this.c = this.f111a.getMethod("getVAID", Context.class);
            this.d = this.f111a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m142a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f8262a, this.f113a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f111a == null || this.f112a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo139b() {
        return a(this.f8262a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f8262a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f8262a, this.d);
    }
}
