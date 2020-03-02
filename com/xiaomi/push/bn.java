package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bn extends ai.a {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo157a() {
        return 10053;
    }

    @Override // java.lang.Runnable
    public void run() {
        ca caVar;
        ca caVar2;
        Context context;
        caVar = this.a.f151a;
        if (caVar != null) {
            caVar2 = this.a.f151a;
            context = this.a.f148a;
            caVar2.b(context);
            this.a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
