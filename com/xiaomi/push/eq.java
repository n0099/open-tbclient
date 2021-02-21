package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class eq {

    /* renamed from: a  reason: collision with root package name */
    private static volatile eq f13998a;

    /* renamed from: a  reason: collision with other field name */
    private int f380a;

    /* renamed from: a  reason: collision with other field name */
    private Context f381a;

    /* renamed from: a  reason: collision with other field name */
    private eu f382a;

    /* renamed from: a  reason: collision with other field name */
    private String f383a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<es, et> f384a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private String f13999b;

    private eq(Context context) {
        this.f381a = context;
        this.f384a.put(es.SERVICE_ACTION, new ew());
        this.f384a.put(es.SERVICE_COMPONENT, new ex());
        this.f384a.put(es.ACTIVITY, new eo());
        this.f384a.put(es.PROVIDER, new ev());
    }

    public static eq a(Context context) {
        if (f13998a == null) {
            synchronized (eq.class) {
                if (f13998a == null) {
                    f13998a = new eq(context);
                }
            }
        }
        return f13998a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(es esVar, Context context, ep epVar) {
        this.f384a.get(esVar).a(context, epVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m292a(Context context) {
        return com.xiaomi.push.service.aa.m557a(context, context.getPackageName());
    }

    public int a() {
        return this.f380a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eu m293a() {
        return this.f382a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m294a() {
        return this.f383a;
    }

    public void a(int i) {
        this.f380a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            em.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f381a).a(new er(this, str, context, str2, str3));
    }

    public void a(es esVar, Context context, Intent intent, String str) {
        if (esVar != null) {
            this.f384a.get(esVar).a(context, intent, str);
        } else {
            em.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eu euVar) {
        this.f382a = euVar;
    }

    public void a(String str) {
        this.f383a = str;
    }

    public void a(String str, String str2, int i, eu euVar) {
        a(str);
        b(str2);
        a(i);
        a(euVar);
    }

    public String b() {
        return this.f13999b;
    }

    public void b(String str) {
        this.f13999b = str;
    }
}
