package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes18.dex */
public final class eq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile eq f4891a;

    /* renamed from: a  reason: collision with other field name */
    private int f304a;

    /* renamed from: a  reason: collision with other field name */
    private Context f305a;

    /* renamed from: a  reason: collision with other field name */
    private eu f306a;

    /* renamed from: a  reason: collision with other field name */
    private String f307a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<es, et> f308a = new HashMap<>();
    private String b;

    private eq(Context context) {
        this.f305a = context;
        this.f308a.put(es.SERVICE_ACTION, new ew());
        this.f308a.put(es.SERVICE_COMPONENT, new ex());
        this.f308a.put(es.ACTIVITY, new eo());
        this.f308a.put(es.PROVIDER, new ev());
    }

    public static eq a(Context context) {
        if (f4891a == null) {
            synchronized (eq.class) {
                if (f4891a == null) {
                    f4891a = new eq(context);
                }
            }
        }
        return f4891a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(es esVar, Context context, ep epVar) {
        this.f308a.get(esVar).a(context, epVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m270a(Context context) {
        return com.xiaomi.push.service.aa.m535a(context, context.getPackageName());
    }

    public int a() {
        return this.f304a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eu m271a() {
        return this.f306a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m272a() {
        return this.f307a;
    }

    public void a(int i) {
        this.f304a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            em.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f305a).a(new er(this, str, context, str2, str3));
    }

    public void a(es esVar, Context context, Intent intent, String str) {
        if (esVar != null) {
            this.f308a.get(esVar).a(context, intent, str);
        } else {
            em.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eu euVar) {
        this.f306a = euVar;
    }

    public void a(String str) {
        this.f307a = str;
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
