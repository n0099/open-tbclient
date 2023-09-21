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
    public int f305a;

    /* renamed from: a  reason: collision with other field name */
    public Context f306a;

    /* renamed from: a  reason: collision with other field name */
    public eg f307a;

    /* renamed from: a  reason: collision with other field name */
    public String f308a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<ee, ef> f309a;
    public String b;

    public ec(Context context) {
        HashMap<ee, ef> hashMap = new HashMap<>();
        this.f309a = hashMap;
        this.f306a = context;
        hashMap.put(ee.SERVICE_ACTION, new ei());
        this.f309a.put(ee.SERVICE_COMPONENT, new ej());
        this.f309a.put(ee.ACTIVITY, new ea());
        this.f309a.put(ee.PROVIDER, new eh());
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
        this.f309a.get(eeVar).a(context, ebVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m451a(Context context) {
        return com.xiaomi.push.service.ak.m766a(context, context.getPackageName());
    }

    public int a() {
        return this.f305a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public eg m452a() {
        return this.f307a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m453a() {
        return this.f308a;
    }

    public void a(int i) {
        this.f305a = i;
    }

    public void a(Context context, String str, int i, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            a(i);
            aj.a(this.f306a).a(new ed(this, str, context, str2, str3));
            return;
        }
        dy.a(context, "" + str, 1008, "A receive a incorrect message");
    }

    public void a(ee eeVar, Context context, Intent intent, String str) {
        if (eeVar != null) {
            this.f309a.get(eeVar).a(context, intent, str);
        } else {
            dy.a(context, StringUtil.NULL_STRING, 1008, "A receive a incorrect message with empty type");
        }
    }

    public void a(eg egVar) {
        this.f307a = egVar;
    }

    public void a(String str) {
        this.f308a = str;
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
