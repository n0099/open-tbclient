package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class ea {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ea f40819a;

    /* renamed from: a  reason: collision with other field name */
    public int f308a;

    /* renamed from: a  reason: collision with other field name */
    public Context f309a;

    /* renamed from: a  reason: collision with other field name */
    public ee f310a;

    /* renamed from: a  reason: collision with other field name */
    public String f311a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<ec, ed> f312a;

    /* renamed from: b  reason: collision with root package name */
    public String f40820b;

    public ea(Context context) {
        HashMap<ec, ed> hashMap = new HashMap<>();
        this.f312a = hashMap;
        this.f309a = context;
        hashMap.put(ec.SERVICE_ACTION, new eg());
        this.f312a.put(ec.SERVICE_COMPONENT, new eh());
        this.f312a.put(ec.ACTIVITY, new dy());
        this.f312a.put(ec.PROVIDER, new ef());
    }

    public static ea a(Context context) {
        if (f40819a == null) {
            synchronized (ea.class) {
                if (f40819a == null) {
                    f40819a = new ea(context);
                }
            }
        }
        return f40819a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ec ecVar, Context context, dz dzVar) {
        this.f312a.get(ecVar).a(context, dzVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m267a(Context context) {
        return com.xiaomi.push.service.ac.m559a(context, context.getPackageName());
    }

    public int a() {
        return this.f308a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ee m268a() {
        return this.f310a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m269a() {
        return this.f311a;
    }

    public void a(int i) {
        this.f308a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i);
            ai.a(this.f309a).a(new eb(this, str, context, str2, str3));
            return;
        }
        dw.a(context, "" + str, 1008, "A receive a incorrect message");
    }

    public void a(ec ecVar, Context context, Intent intent, String str) {
        if (ecVar != null) {
            this.f312a.get(ecVar).a(context, intent, str);
        } else {
            dw.a(context, StringUtil.NULL_STRING, 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(ee eeVar) {
        this.f310a = eeVar;
    }

    public void a(String str) {
        this.f311a = str;
    }

    public void a(String str, String str2, int i, ee eeVar) {
        a(str);
        b(str2);
        a(i);
        a(eeVar);
    }

    public String b() {
        return this.f40820b;
    }

    public void b(String str) {
        this.f40820b = str;
    }
}
