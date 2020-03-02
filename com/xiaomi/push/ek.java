package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class ek {
    private static volatile ek a;

    /* renamed from: a  reason: collision with other field name */
    private int f314a;

    /* renamed from: a  reason: collision with other field name */
    private Context f315a;

    /* renamed from: a  reason: collision with other field name */
    private eo f316a;

    /* renamed from: a  reason: collision with other field name */
    private String f317a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<em, en> f318a = new HashMap<>();
    private String b;

    private ek(Context context) {
        this.f315a = context;
        this.f318a.put(em.SERVICE_ACTION, new eq());
        this.f318a.put(em.SERVICE_COMPONENT, new er());
        this.f318a.put(em.ACTIVITY, new ei());
        this.f318a.put(em.PROVIDER, new ep());
    }

    public static ek a(Context context) {
        if (a == null) {
            synchronized (ek.class) {
                if (a == null) {
                    a = new ek(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(em emVar, Context context, ej ejVar) {
        this.f318a.get(emVar).a(context, ejVar);
    }

    public int a() {
        return this.f314a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eo m257a() {
        return this.f316a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m258a() {
        return this.f317a;
    }

    public void a(int i) {
        this.f314a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            eg.a(context, "" + str, 1008, "A receive a incorrect message");
            return;
        }
        a(i);
        ai.a(this.f315a).a(new el(this, str, context, str2, str3));
    }

    public void a(em emVar, Context context, Intent intent, String str) {
        if (emVar != null) {
            this.f318a.get(emVar).a(context, intent, str);
        } else {
            eg.a(context, "null", 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eo eoVar) {
        this.f316a = eoVar;
    }

    public void a(String str) {
        this.f317a = str;
    }

    public void a(String str, String str2, int i, eo eoVar) {
        a(str);
        b(str2);
        a(i);
        a(eoVar);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}
