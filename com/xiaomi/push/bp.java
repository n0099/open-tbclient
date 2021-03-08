package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes5.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bp f8282a;

    /* renamed from: a  reason: collision with other field name */
    private Context f134a;

    /* renamed from: a  reason: collision with other field name */
    private ce f136a;

    /* renamed from: a  reason: collision with other field name */
    private cf f137a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f138a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f139b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f140c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f135a = new bq(this);
    private ai.a b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f134a = context;
    }

    public static bp a(Context context) {
        if (f8282a == null) {
            synchronized (bp.class) {
                if (f8282a == null) {
                    f8282a = new bp(context);
                }
            }
        }
        return f8282a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ak.a(this.f134a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f134a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f134a.getDatabasePath(bt.f142a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m179a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f134a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f134a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f134a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f136a != null) {
            if (bool.booleanValue()) {
                this.f136a.a(this.f134a, str2, str);
            } else {
                this.f136a.b(this.f134a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
