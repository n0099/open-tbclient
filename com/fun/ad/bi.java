package com.fun.ad;

import android.content.ContentValues;
import android.content.Context;
/* loaded from: classes6.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f7771a;
    public bf pPH;

    public bi(Context context, bf bfVar) {
        this.f7771a = context.getApplicationContext();
        this.pPH = bfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk io2 = bk.io(this.f7771a);
        bf bfVar = this.pPH;
        if (io2 == null) {
            throw null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_event", bfVar.f7769b);
        contentValues.put("ad_sid", bfVar.c);
        contentValues.put("ad_type", bfVar.d);
        contentValues.put("ad_aid", bfVar.e);
        io2.getWritableDatabase().insert("ad_todo_list", null, contentValues);
    }
}
