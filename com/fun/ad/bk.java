package com.fun.ad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.IMConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class bk extends SQLiteOpenHelper {
    public static volatile bk pFD;

    public bk(Context context) {
        super(context, "ad_log_report.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static bk il(Context context) {
        if (pFD == null) {
            synchronized (bk.class) {
                if (pFD == null) {
                    pFD = new bk(context.getApplicationContext());
                }
            }
        }
        return pFD;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<bf> a() {
        Cursor cursor;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                cursor = getReadableDatabase().query("ad_todo_list", null, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e) {
            e = e;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor == null) {
            if (cursor != null) {
                cursor.close();
            }
            return arrayList2;
        }
        try {
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(cursor.getColumnIndex("ad_event"));
                    String string2 = cursor.getString(cursor.getColumnIndex("ad_sid"));
                    String string3 = cursor.getString(cursor.getColumnIndex("ad_type"));
                    String string4 = cursor.getString(cursor.getColumnIndex("ad_aid"));
                    long j = cursor.getLong(cursor.getColumnIndex(IMConstants.MSG_ROW_ID));
                    bf bfVar = new bf();
                    bfVar.f7766a = j;
                    bfVar.f7767b = string;
                    bfVar.c = string2;
                    bfVar.d = string3;
                    bfVar.e = string4;
                    arrayList2.add(bfVar);
                } while (cursor.moveToNext());
                cursor.close();
                arrayList = arrayList2;
            } else {
                cursor.close();
                arrayList = arrayList2;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            arrayList = arrayList2;
            return arrayList;
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table ad_todo_list (_id integer primary key autoincrement,ad_event text,ad_sid text,ad_type text,ad_aid text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
