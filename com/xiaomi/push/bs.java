package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bs extends ai.a {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo162a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        cfVar = this.a.f136a;
        if (cfVar != null) {
            cfVar2 = this.a.f136a;
            context = this.a.f133a;
            cfVar2.b(context);
            this.a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
