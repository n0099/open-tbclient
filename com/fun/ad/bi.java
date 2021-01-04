package com.fun.ad;

import android.content.ContentValues;
import android.content.Context;
/* loaded from: classes15.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f8068a;
    public bf pIu;

    public bi(Context context, bf bfVar) {
        this.f8068a = context.getApplicationContext();
        this.pIu = bfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk in = bk.in(this.f8068a);
        bf bfVar = this.pIu;
        if (in == null) {
            throw null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_event", bfVar.f8066b);
        contentValues.put("ad_sid", bfVar.c);
        contentValues.put("ad_type", bfVar.d);
        contentValues.put("ad_aid", bfVar.e);
        in.getWritableDatabase().insert("ad_todo_list", null, contentValues);
    }
}
