package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes18.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bp f4819a;

    /* renamed from: a  reason: collision with other field name */
    private Context f137a;

    /* renamed from: a  reason: collision with other field name */
    private ce f139a;

    /* renamed from: a  reason: collision with other field name */
    private cf f140a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f141a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f142b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f143c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f138a = new bq(this);
    private ai.a b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f137a = context;
    }

    public static bp a(Context context) {
        if (f4819a == null) {
            synchronized (bp.class) {
                if (f4819a == null) {
                    f4819a = new bp(context);
                }
            }
        }
        return f4819a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ak.a(this.f137a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f137a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f137a.getDatabasePath(bt.f145a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m178a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f137a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f137a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f137a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f139a != null) {
            if (bool.booleanValue()) {
                this.f139a.a(this.f137a, str2, str);
            } else {
                this.f139a.b(this.f137a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
