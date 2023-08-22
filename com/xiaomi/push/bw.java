package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.aj;
import com.xiaomi.push.ci;
/* loaded from: classes10.dex */
public class bw {
    public static volatile bw a;

    /* renamed from: a  reason: collision with other field name */
    public Context f153a;

    /* renamed from: a  reason: collision with other field name */
    public cl f155a;

    /* renamed from: a  reason: collision with other field name */
    public cm f156a;
    public String e;
    public String f;

    /* renamed from: a  reason: collision with other field name */
    public final String f157a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    public final String f158b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    public final String f159c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    public final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    public aj.a f154a = new bx(this);
    public aj.a b = new by(this);
    public aj.a c = new bz(this);

    public bw(Context context) {
        this.f153a = context;
    }

    public static bw a(Context context) {
        if (a == null) {
            synchronized (bw.class) {
                if (a == null) {
                    a = new bw(context);
                }
            }
        }
        return a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ba.a(this.f153a).a(hm.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f153a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        q.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f153a.getDatabasePath(ca.f163a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m308a() {
        return this.e;
    }

    public void a(ci.a aVar) {
        ci.a(this.f153a).a(aVar);
    }

    public void a(hl hlVar) {
        if (a() && com.xiaomi.push.service.bz.a(hlVar.e())) {
            a(cf.a(this.f153a, c(), hlVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cn.a(this.f153a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f155a != null) {
            if (bool.booleanValue()) {
                this.f155a.a(this.f153a, str2, str);
            } else {
                this.f155a.b(this.f153a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
