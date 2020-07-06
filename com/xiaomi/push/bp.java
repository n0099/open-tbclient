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
    private Context f140a;

    /* renamed from: a  reason: collision with other field name */
    private ce f142a;

    /* renamed from: a  reason: collision with other field name */
    private cf f143a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f144a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f145b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f146c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f141a = new bq(this);
    private ai.a b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f140a = context;
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
        return com.xiaomi.push.service.ak.a(this.f140a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f140a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f140a.getDatabasePath(bt.f148a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m169a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f140a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f140a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f140a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f142a != null) {
            if (bool.booleanValue()) {
                this.f142a.a(this.f140a, str2, str);
            } else {
                this.f142a.b(this.f140a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
