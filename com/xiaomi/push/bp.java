package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes6.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bp f13890a;

    /* renamed from: a  reason: collision with other field name */
    private Context f213a;

    /* renamed from: a  reason: collision with other field name */
    private ce f215a;

    /* renamed from: a  reason: collision with other field name */
    private cf f216a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f217a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f218b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f219c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f214a = new bq(this);

    /* renamed from: b  reason: collision with root package name */
    private ai.a f13891b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f213a = context;
    }

    public static bp a(Context context) {
        if (f13890a == null) {
            synchronized (bp.class) {
                if (f13890a == null) {
                    f13890a = new bp(context);
                }
            }
        }
        return f13890a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ak.a(this.f213a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f213a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f213a.getDatabasePath(bt.f221a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m201a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f213a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f213a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f213a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f215a != null) {
            if (bool.booleanValue()) {
                this.f215a.a(this.f213a, str2, str);
            } else {
                this.f215a.b(this.f213a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
