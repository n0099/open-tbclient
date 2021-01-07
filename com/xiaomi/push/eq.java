package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class eq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile eq f14296a;

    /* renamed from: a  reason: collision with other field name */
    private int f381a;

    /* renamed from: a  reason: collision with other field name */
    private Context f382a;

    /* renamed from: a  reason: collision with other field name */
    private eu f383a;

    /* renamed from: a  reason: collision with other field name */
    private String f384a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<es, et> f385a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private String f14297b;

    private eq(Context context) {
        this.f382a = context;
        this.f385a.put(es.SERVICE_ACTION, new ew());
        this.f385a.put(es.SERVICE_COMPONENT, new ex());
        this.f385a.put(es.ACTIVITY, new eo());
        this.f385a.put(es.PROVIDER, new ev());
    }

    public static eq a(Context context) {
        if (f14296a == null) {
            synchronized (eq.class) {
                if (f14296a == null) {
                    f14296a = new eq(context);
                }
            }
        }
        return f14296a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(es esVar, Context context, ep epVar) {
        this.f385a.get(esVar).a(context, epVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m297a(Context context) {
        return com.xiaomi.push.service.aa.m562a(context, context.getPackageName());
    }

    public int a() {
        return this.f381a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eu m298a() {
        return this.f383a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m299a() {
        return this.f384a;
    }

    public void a(int i) {
        this.f381a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            em.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f382a).a(new er(this, str, context, str2, str3));
    }

    public void a(es esVar, Context context, Intent intent, String str) {
        if (esVar != null) {
            this.f385a.get(esVar).a(context, intent, str);
        } else {
            em.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eu euVar) {
        this.f383a = euVar;
    }

    public void a(String str) {
        this.f384a = str;
    }

    public void a(String str, String str2, int i, eu euVar) {
        a(str);
        b(str2);
        a(i);
        a(euVar);
    }

    public String b() {
        return this.f14297b;
    }

    public void b(String str) {
        this.f14297b = str;
    }
}
