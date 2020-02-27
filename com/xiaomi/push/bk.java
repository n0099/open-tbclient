package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.bw;
/* loaded from: classes8.dex */
public class bk {
    private static volatile bk a;

    /* renamed from: a  reason: collision with other field name */
    private Context f149a;

    /* renamed from: a  reason: collision with other field name */
    private bz f151a;

    /* renamed from: a  reason: collision with other field name */
    private ca f152a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f153a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f154b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f155c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f150a = new bl(this);
    private ai.a b = new bm(this);
    private ai.a c = new bn(this);

    private bk(Context context) {
        this.f149a = context;
    }

    public static bk a(Context context) {
        if (a == null) {
            synchronized (bk.class) {
                if (a == null) {
                    a = new bk(context);
                }
            }
        }
        return a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ag.a(this.f149a).a(hl.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f149a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f149a.getDatabasePath(bo.f157a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m166a() {
        return this.e;
    }

    public void a(bw.a aVar) {
        bw.a(this.f149a).a(aVar);
    }

    public void a(hk hkVar) {
        if (a() && com.xiaomi.push.service.be.a(hkVar.e())) {
            a(bt.a(this.f149a, c(), hkVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cb.a(this.f149a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f151a != null) {
            if (bool.booleanValue()) {
                this.f151a.a(this.f149a, str2, str);
            } else {
                this.f151a.b(this.f149a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
