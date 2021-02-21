package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class bs extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bp f13894a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.f13894a = bpVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo191a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        cf cfVar;
        cf cfVar2;
        Context context;
        cfVar = this.f13894a.f216a;
        if (cfVar != null) {
            cfVar2 = this.f13894a.f216a;
            context = this.f13894a.f213a;
            cfVar2.b(context);
            this.f13894a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
