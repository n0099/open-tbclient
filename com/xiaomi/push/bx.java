package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.xiaomi.push.ai;
/* loaded from: classes7.dex */
public class bx extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bu f37374a;

    public bx(bu buVar) {
        this.f37374a = buVar;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo171a() {
        return "10053";
    }

    @Override // java.lang.Runnable
    public void run() {
        ck ckVar;
        ck ckVar2;
        Context context;
        ckVar = this.f37374a.f160a;
        if (ckVar != null) {
            ckVar2 = this.f37374a.f160a;
            context = this.f37374a.f157a;
            ckVar2.b(context);
            this.f37374a.b(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM);
        }
    }
}
