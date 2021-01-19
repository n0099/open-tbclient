package com.fun.ad;

import android.content.ContentValues;
import android.content.Context;
/* loaded from: classes14.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f7769a;
    public bf pFC;

    public bi(Context context, bf bfVar) {
        this.f7769a = context.getApplicationContext();
        this.pFC = bfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk il = bk.il(this.f7769a);
        bf bfVar = this.pFC;
        if (il == null) {
            throw null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_event", bfVar.f7767b);
        contentValues.put("ad_sid", bfVar.c);
        contentValues.put("ad_type", bfVar.d);
        contentValues.put("ad_aid", bfVar.e);
        il.getWritableDatabase().insert("ad_todo_list", null, contentValues);
    }
}
