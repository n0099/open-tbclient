package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
class as implements ar {

    /* renamed from: a  reason: collision with root package name */
    private Context f13865a;

    /* renamed from: a  reason: collision with other field name */
    private Class<?> f190a;

    /* renamed from: a  reason: collision with other field name */
    private Object f191a;

    /* renamed from: a  reason: collision with other field name */
    private Method f192a = null;

    /* renamed from: b  reason: collision with root package name */
    private Method f13866b = null;
    private Method c = null;
    private Method d = null;

    public as(Context context) {
        this.f13865a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        if (this.f191a != null && method != null) {
            try {
                Object invoke = method.invoke(this.f191a, context);
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
            this.f190a = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f191a = this.f190a.newInstance();
            this.f192a = this.f190a.getMethod("getUDID", Context.class);
            this.f13866b = this.f190a.getMethod("getOAID", Context.class);
            this.c = this.f190a.getMethod("getVAID", Context.class);
            this.d = this.f190a.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m164a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return a(this.f13865a, this.f192a);
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f190a == null || this.f191a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo161b() {
        return a(this.f13865a, this.f13866b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f13865a, this.c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f13865a, this.d);
    }
}
