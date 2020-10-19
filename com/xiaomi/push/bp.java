package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes12.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bp f4819a;

    /* renamed from: a  reason: collision with other field name */
    private Context f135a;

    /* renamed from: a  reason: collision with other field name */
    private ce f137a;

    /* renamed from: a  reason: collision with other field name */
    private cf f138a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f139a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f140b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f141c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f136a = new bq(this);
    private ai.a b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f135a = context;
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
        return com.xiaomi.push.service.ak.a(this.f135a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f135a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f135a.getDatabasePath(bt.f143a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m176a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f135a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f135a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f135a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f137a != null) {
            if (bool.booleanValue()) {
                this.f137a.a(this.f135a, str2, str);
            } else {
                this.f137a.b(this.f135a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
