package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.aj;
import com.xiaomi.push.ci;
/* loaded from: classes8.dex */
public class bw {
    public static volatile bw a;

    /* renamed from: a  reason: collision with other field name */
    public Context f152a;

    /* renamed from: a  reason: collision with other field name */
    public cl f154a;

    /* renamed from: a  reason: collision with other field name */
    public cm f155a;
    public String e;
    public String f;

    /* renamed from: a  reason: collision with other field name */
    public final String f156a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    public final String f157b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    public final String f158c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    public final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    public aj.a f153a = new bx(this);
    public aj.a b = new by(this);
    public aj.a c = new bz(this);

    public bw(Context context) {
        this.f152a = context;
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
        return com.xiaomi.push.service.ba.a(this.f152a).a(hm.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f152a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        q.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f152a.getDatabasePath(ca.f162a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m229a() {
        return this.e;
    }

    public void a(ci.a aVar) {
        ci.a(this.f152a).a(aVar);
    }

    public void a(hl hlVar) {
        if (a() && com.xiaomi.push.service.bz.a(hlVar.e())) {
            a(cf.a(this.f152a, c(), hlVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cn.a(this.f152a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f154a != null) {
            if (bool.booleanValue()) {
                this.f154a.a(this.f152a, str2, str);
            } else {
                this.f154a.b(this.f152a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
