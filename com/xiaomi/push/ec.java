package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class ec {
    public static volatile ec a;

    /* renamed from: a  reason: collision with other field name */
    public int f306a;

    /* renamed from: a  reason: collision with other field name */
    public Context f307a;

    /* renamed from: a  reason: collision with other field name */
    public eg f308a;

    /* renamed from: a  reason: collision with other field name */
    public String f309a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<ee, ef> f310a;
    public String b;

    public ec(Context context) {
        HashMap<ee, ef> hashMap = new HashMap<>();
        this.f310a = hashMap;
        this.f307a = context;
        hashMap.put(ee.SERVICE_ACTION, new ei());
        this.f310a.put(ee.SERVICE_COMPONENT, new ej());
        this.f310a.put(ee.ACTIVITY, new ea());
        this.f310a.put(ee.PROVIDER, new eh());
    }

    public static ec a(Context context) {
        if (a == null) {
            synchronized (ec.class) {
                if (a == null) {
                    a = new ec(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ee eeVar, Context context, eb ebVar) {
        this.f310a.get(eeVar).a(context, ebVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m448a(Context context) {
        return com.xiaomi.push.service.ak.m763a(context, context.getPackageName());
    }

    public int a() {
        return this.f306a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eg m449a() {
        return this.f308a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m450a() {
        return this.f309a;
    }

    public void a(int i) {
        this.f306a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i);
            aj.a(this.f307a).a(new ed(this, str, context, str2, str3));
            return;
        }
        dy.a(context, "" + str, 1008, "A receive a incorrect message");
    }

    public void a(ee eeVar, Context context, Intent intent, String str) {
        if (eeVar != null) {
            this.f310a.get(eeVar).a(context, intent, str);
        } else {
            dy.a(context, StringUtil.NULL_STRING, 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eg egVar) {
        this.f308a = egVar;
    }

    public void a(String str) {
        this.f309a = str;
    }

    public void a(String str, String str2, int i, eg egVar) {
        a(str);
        b(str2);
        a(i);
        a(egVar);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }
}
