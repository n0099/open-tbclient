package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes12.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f4797a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f109a;

    /* renamed from: a  reason: collision with other field name */
    private Object f110a;

    /* renamed from: a  reason: collision with other field name */
    private Method f111a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f4797a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f110a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f110a, context);
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
            this.f109a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f110a = this.f109a.newInstance();
            this.f111a = this.f109a.getMethod("getUDID", Context.class);
            this.b = this.f109a.getMethod("getOAID", Context.class);
            this.c = this.f109a.getMethod("getVAID", Context.class);
            this.d = this.f109a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m138a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f4797a, this.f111a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f109a == null || this.f110a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo135b() {
        return a(this.f4797a, this.b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f4797a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f4797a, this.d);
    }
}
