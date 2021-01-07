package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f14163a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f191a;

    /* renamed from: a  reason: collision with other field name */
    private Object f192a;

    /* renamed from: a  reason: collision with other field name */
    private Method f193a = null;

    /* renamed from: b  reason: collision with root package name */
    private Method f14164b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f14163a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f192a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f192a, context);
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
            this.f191a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f192a = this.f191a.newInstance();
            this.f193a = this.f191a.getMethod("getUDID", Context.class);
            this.f14164b = this.f191a.getMethod("getOAID", Context.class);
            this.c = this.f191a.getMethod("getVAID", Context.class);
            this.d = this.f191a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m168a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f14163a, this.f193a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f191a == null || this.f192a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo165b() {
        return a(this.f14163a, this.f14164b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f14163a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f14163a, this.d);
    }
}
