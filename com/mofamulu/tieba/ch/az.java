package com.mofamulu.tieba.ch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class az {
    private ad a;
    private SQLiteDatabase b;

    public az(Context context) {
        this.a = new ad(context);
        this.b = this.a.getWritableDatabase();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [55=4] */
    public av a(String str) {
        Cursor cursor;
        try {
            cursor = this.b.rawQuery("SELECT userName, nickName, color, brand, sign, nickType, lastUpdateTime, banner FROM chs where userName = ?", new String[]{str});
            try {
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("tbhp_n_db", str, th);
                    return null;
                } finally {
                    ac.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        if (!cursor.moveToNext()) {
            ac.a(cursor);
            return null;
        }
        av avVar = new av();
        avVar.b = cursor.getString(0);
        avVar.c = cursor.getString(1);
        avVar.d = cursor.getInt(2);
        avVar.e = cursor.getString(3);
        avVar.f = cursor.getString(4);
        avVar.g = cursor.getInt(5);
        avVar.h = cursor.getLong(6);
        avVar.i = cursor.getString(7);
        return avVar;
    }

    public void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            av avVar = (av) it.next();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("userName", avVar.b);
                contentValues.put("nickName", avVar.c);
                contentValues.put("color", Integer.valueOf(avVar.d));
                contentValues.put("brand", avVar.e);
                contentValues.put("sign", avVar.f);
                contentValues.put("nickType", Integer.valueOf(avVar.g));
                contentValues.put("lastUpdateTime", Long.valueOf(avVar.h));
                contentValues.put("banner", avVar.i);
                if (this.b.update("chs", contentValues, "userName = ?", new String[]{avVar.b}) == 0) {
                    this.b.insert("chs", null, contentValues);
                }
            } catch (Throwable th) {
                Log.e("tbhp_n_db", "failed to insert " + avVar.b + " to db.", th);
            }
        }
    }

    public void a() {
        this.b.execSQL("delete from chs");
    }

    public void b() {
        try {
            this.b.close();
        } catch (Throwable th) {
            Log.e("tbhp_n_db", "failed to closeDB.", th);
        }
    }
}
