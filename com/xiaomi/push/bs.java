package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public class bs extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f4822a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.f4822a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo167a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        cfVar = this.f4822a.f138a;
        if (cfVar != null) {
            cfVar2 = this.f4822a.f138a;
            context = this.f4822a.f135a;
            cfVar2.b(context);
            this.f4822a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
