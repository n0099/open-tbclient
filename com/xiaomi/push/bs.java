package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class bs extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f8285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.f8285a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo170a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        cfVar = this.f8285a.f137a;
        if (cfVar != null) {
            cfVar2 = this.f8285a.f137a;
            context = this.f8285a.f134a;
            cfVar2.b(context);
            this.f8285a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
