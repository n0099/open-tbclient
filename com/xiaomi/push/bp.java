package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
import com.xiaomi.push.cb;
/* loaded from: classes6.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bp f14188a;

    /* renamed from: a  reason: collision with other field name */
    private Context f214a;

    /* renamed from: a  reason: collision with other field name */
    private ce f216a;

    /* renamed from: a  reason: collision with other field name */
    private cf f217a;
    private String e;
    private String f;

    /* renamed from: a  reason: collision with other field name */
    private final String f218a = "push_stat_sp";

    /* renamed from: b  reason: collision with other field name */
    private final String f219b = "upload_time";

    /* renamed from: c  reason: collision with other field name */
    private final String f220c = DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM;
    private final String d = "check_time";

    /* renamed from: a  reason: collision with other field name */
    private ai.a f215a = new bq(this);

    /* renamed from: b  reason: collision with root package name */
    private ai.a f14189b = new br(this);
    private ai.a c = new bs(this);

    private bp(Context context) {
        this.f214a = context;
    }

    public static bp a(Context context) {
        if (f14188a == null) {
            synchronized (bp.class) {
                if (f14188a == null) {
                    f14188a = new bp(context);
                }
            }
        }
        return f14188a;
    }

    private boolean a() {
        return com.xiaomi.push.service.ak.a(this.f214a).a(hr.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        SharedPreferences.Editor edit = this.f214a.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        r.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        return this.f214a.getDatabasePath(bt.f222a).getAbsolutePath();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m205a() {
        return this.e;
    }

    public void a(cb.a aVar) {
        cb.a(this.f214a).a(aVar);
    }

    public void a(hq hqVar) {
        if (a() && com.xiaomi.push.service.bi.a(hqVar.e())) {
            a(by.a(this.f214a, c(), hqVar));
        }
    }

    public void a(String str) {
        if (a() && !TextUtils.isEmpty(str)) {
            a(cg.a(this.f214a, str));
        }
    }

    public void a(String str, String str2, Boolean bool) {
        if (this.f216a != null) {
            if (bool.booleanValue()) {
                this.f216a.a(this.f214a, str2, str);
            } else {
                this.f216a.b(this.f214a, str2, str);
            }
        }
    }

    public String b() {
        return this.f;
    }
}
