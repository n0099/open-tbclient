package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.aj;
/* loaded from: classes10.dex */
public class bz extends aj.a {
    public final /* synthetic */ bw a;

    public bz(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.xiaomi.push.aj.a
    /* renamed from: a */
    public String mo297a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        cm cmVar;
        cm cmVar2;
        Context context;
        cmVar = this.a.f155a;
        if (cmVar != null) {
            cmVar2 = this.a.f155a;
            context = this.a.f152a;
            cmVar2.b(context);
            this.a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
