package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class ax implements at {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f127a;

    /* renamed from: a  reason: collision with other field name */
    public Object f128a;

    /* renamed from: a  reason: collision with other field name */
    public Method f129a = null;
    public Method b = null;
    public Method c = null;
    public Method d = null;

    public ax(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f128a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }

    private void a(Context context) {
        try {
            Class<?> a = s.a(context, "com.android.id.impl.IdProviderImpl");
            this.f127a = a;
            this.f128a = a.newInstance();
            this.b = this.f127a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo265a() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo266a() {
        return (this.f127a == null || this.f128a == null) ? false : true;
    }
}
