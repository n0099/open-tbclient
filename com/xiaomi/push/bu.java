package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cg;
/* loaded from: classes7.dex */
public class bu {

    /* renamed from: a  reason: collision with root package name */
    public static volatile bu f41045a;

    /* renamed from: a  reason: collision with other field name */
    public Context f157a;

    /* renamed from: a  reason: collision with other field name */
    public cj f159a;

    /* renamed from: a  reason: collision with other field name */
    public ck f160a;

    /* renamed from: e  reason: collision with root package name */
    public String f41049e;

    /* renamed from: f  reason: collision with root package name */
    public String f41050f;

    /* renamed from: a  reason: collision with other field name */
    public final String f161a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    public final String f162b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    public final String f163c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;

    /* renamed from: d  reason: collision with root package name */
    public final String f41048d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    public ai.a f158a = new bv(this);

    /* renamed from: b  reason: collision with root package name */
    public ai.a f41046b = new bw(this);

    /* renamed from: c  reason: collision with root package name */
    public ai.a f41047c = new bx(this);

    public bu(Context context) {
        this.f157a = context;
    }

    public static bu a(Context context) {
        if (f41045a == null) {
            synchronized (bu.class) {
                if (f41045a == null) {
                    f41045a = new bu(context);
                }
            }
        }
        return f41045a;
    }

    private boolean a() {
        return com.xiaomi.push.service.aq.a(this.f157a).a(hk.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f157a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f157a.getDatabasePath(by.f165a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m178a() {
        return this.f41049e;
    }

    public void a(cg.a aVar) {
        cg.a(this.f157a).a(aVar);
    }

    public void a(hj hjVar) {
        if (a() && com.xiaomi.push.service.bm.a(hjVar.e())) {
            a(cd.a(this.f157a, c(), hjVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cl.a(this.f157a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f159a != null) {
            if (bool.booleanValue()) {
                this.f159a.a(this.f157a, str2, str);
            } else {
                this.f159a.b(this.f157a, str2, str);
            }
        }
    }

    public String b() {
        return this.f41050f;
    }
}
