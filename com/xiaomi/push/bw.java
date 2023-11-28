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
    public Context f148a;

    /* renamed from: a  reason: collision with other field name */
    public cl f150a;

    /* renamed from: a  reason: collision with other field name */
    public cm f151a;
    public String e;
    public String f;

    /* renamed from: a  reason: collision with other field name */
    public final String f152a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    public final String f153b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    public final String f154c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    public final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    public aj.a f149a = new bx(this);
    public aj.a b = new by(this);
    public aj.a c = new bz(this);

    public bw(Context context) {
        this.f148a = context;
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
        return com.xiaomi.push.service.ba.a(this.f148a).a(hm.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f148a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        q.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f148a.getDatabasePath(ca.f158a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m318a() {
        return this.e;
    }

    public void a(ci.a aVar) {
        ci.a(this.f148a).a(aVar);
    }

    public void a(hl hlVar) {
        if (a() && com.xiaomi.push.service.bz.a(hlVar.e())) {
            a(cf.a(this.f148a, c(), hlVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cn.a(this.f148a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f150a != null) {
            if (bool.booleanValue()) {
                this.f150a.a(this.f148a, str2, str);
            } else {
                this.f150a.b(this.f148a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
