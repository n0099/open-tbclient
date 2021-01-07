package com.fun.ad;

import android.content.ContentValues;
import android.content.Context;
/* loaded from: classes15.dex */
public class bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f8069a;
    public bf pKc;

    public bi(Context context, bf bfVar) {
        this.f8069a = context.getApplicationContext();
        this.pKc = bfVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        bk in = bk.in(this.f8069a);
        bf bfVar = this.pKc;
        if (in == null) {
            throw null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ad_event", bfVar.f8067b);
        contentValues.put("ad_sid", bfVar.c);
        contentValues.put("ad_type", bfVar.d);
        contentValues.put("ad_aid", bfVar.e);
        in.getWritableDatabase().insert("ad_todo_list", null, contentValues);
    }
}
