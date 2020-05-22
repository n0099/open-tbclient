package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes8.dex */
public class bp {
    private static volatile bp a;

    /* renamed from: a  reason: collision with other field name */
    private Context f133a;

    /* renamed from: a  reason: collision with other field name */
    private ce f135a;

    /* renamed from: a  reason: collision with other field name */
    private cf f136a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f137a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f138b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f139c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f134a = new bq(this);
    private ai.a b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f133a = context;
    }

    public static bp a(Context context) {
        if (a == null) {
            synchronized (bp.class) {
                if (a == null) {
                    a = new bp(context);
                }
            }
        }
        return a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ak.a(this.f133a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f133a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f133a.getDatabasePath(bt.f141a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m173a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f133a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f133a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f133a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f135a != null) {
            if (bool.booleanValue()) {
                this.f135a.a(this.f133a, str2, str);
            } else {
                this.f135a.b(this.f133a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
