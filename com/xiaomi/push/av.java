package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class av implements ar {

    /* renamed from: a  reason: collision with root package name */
    public Context f40632a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f131a;

    /* renamed from: a  reason: collision with other field name */
    public Object f132a;

    /* renamed from: a  reason: collision with other field name */
    public Method f133a = null;

    /* renamed from: b  reason: collision with root package name */
    public Method f40633b = null;

    /* renamed from: c  reason: collision with root package name */
    public Method f40634c = null;

    /* renamed from: d  reason: collision with root package name */
    public Method f40635d = null;

    public av(Context context) {
        this.f40632a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f132a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e2);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a2 = t.a(context, "com.android.id.impl.IdProviderImpl");
            this.f131a = a2;
            this.f132a = a2.newInstance();
            this.f133a = this.f131a.getMethod("getUDID", Context.class);
            this.f40633b = this.f131a.getMethod("getOAID", Context.class);
            this.f40634c = this.f131a.getMethod("getVAID", Context.class);
            this.f40635d = this.f131a.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m137a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName());
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return null;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        return (this.f131a == null || this.f132a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo134b() {
        return a(this.f40632a, this.f40633b);
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        return a(this.f40632a, this.f40634c);
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        return a(this.f40632a, this.f40635d);
    }
}
