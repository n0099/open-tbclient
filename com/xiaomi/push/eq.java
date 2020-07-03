package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class eq {
    private static volatile eq a;

    /* renamed from: a  reason: collision with other field name */
    private int f306a;

    /* renamed from: a  reason: collision with other field name */
    private Context f307a;

    /* renamed from: a  reason: collision with other field name */
    private eu f308a;

    /* renamed from: a  reason: collision with other field name */
    private String f309a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<es, et> f310a = new HashMap<>();
    private String b;

    private eq(Context context) {
        this.f307a = context;
        this.f310a.put(es.SERVICE_ACTION, new ew());
        this.f310a.put(es.SERVICE_COMPONENT, new ex());
        this.f310a.put(es.ACTIVITY, new eo());
        this.f310a.put(es.PROVIDER, new ev());
    }

    public static eq a(Context context) {
        if (a == null) {
            synchronized (eq.class) {
                if (a == null) {
                    a = new eq(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(es esVar, Context context, ep epVar) {
        this.f310a.get(esVar).a(context, epVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m261a(Context context) {
        return com.xiaomi.push.service.aa.m526a(context, context.getPackageName());
    }

    public int a() {
        return this.f306a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eu m262a() {
        return this.f308a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m263a() {
        return this.f309a;
    }

    public void a(int i) {
        this.f306a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            em.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f307a).a(new er(this, str, context, str2, str3));
    }

    public void a(es esVar, Context context, Intent intent, String str) {
        if (esVar != null) {
            this.f310a.get(esVar).a(context, intent, str);
        } else {
            em.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eu euVar) {
        this.f308a = euVar;
    }

    public void a(String str) {
        this.f309a = str;
    }

    public void a(String str, String str2, int i, eu euVar) {
        a(str);
        b(str2);
        a(i);
        a(euVar);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}
