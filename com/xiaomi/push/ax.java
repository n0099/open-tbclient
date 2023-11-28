package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public class ax implements at {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f122a;

    /* renamed from: a  reason: collision with other field name */
    public Object f123a;

    /* renamed from: a  reason: collision with other field name */
    public Method f124a = null;
    public Method b = null;
    public Method c = null;
    public Method d = null;

    public ax(Context context) {
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        Object obj = this.f123a;
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
            this.f122a = a;
            this.f123a = a.newInstance();
            this.b = this.f122a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public String mo275a() {
        return a(this.a, this.b);
    }

    @Override // com.xiaomi.push.at
    /* renamed from: a */
    public boolean mo276a() {
        return (this.f122a == null || this.f123a == null) ? false : true;
    }
}
