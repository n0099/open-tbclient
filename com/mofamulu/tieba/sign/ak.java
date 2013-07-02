package com.mofamulu.tieba.sign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.mofamulu.tieba.ch.bg;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class ak {
    private com.mofamulu.tieba.ch.ad a;
    private SQLiteDatabase b;

    public ak(Context context) {
        this.a = new com.mofamulu.tieba.ch.ad(context);
        this.b = this.a.getWritableDatabase();
    }

    public static void a(AccountData accountData) {
        if (bg.c().w()) {
            ak akVar = new ak(TiebaApplication.f());
            try {
                if (akVar.b(accountData.getAccount()) == null) {
                    al alVar = new al();
                    alVar.j = 1;
                    alVar.a = accountData.getAccount();
                    akVar.a(alVar);
                }
                akVar.c();
            } catch (Throwable th) {
                akVar.c();
            }
        }
    }

    public static void a(String str) {
        if (bg.c().w()) {
            for (AccountData accountData : DatabaseService.n()) {
                if (accountData.getID().equalsIgnoreCase(str)) {
                    ak akVar = new ak(TiebaApplication.f());
                    try {
                        al b = akVar.b(accountData.getAccount());
                        if (b != null && b.l() == 1) {
                            akVar.c(b.d());
                        }
                        akVar.c();
                    } catch (Throwable th) {
                        akVar.c();
                    }
                }
            }
        }
    }

    public void a(al alVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("userName", alVar.a);
            contentValues.put("password", alVar.b);
            contentValues.put("authCode", alVar.c);
            contentValues.put("cookies", alVar.d);
            contentValues.put("loginError", alVar.e);
            contentValues.put("signStatus", Integer.valueOf(alVar.f));
            contentValues.put("lastSign", Integer.valueOf(alVar.g));
            contentValues.put("fromType", Integer.valueOf(alVar.j));
            contentValues.put("ignoredTiebas", alVar.b());
            contentValues.put("tiebas", alVar.a());
            if (this.b.update("signs", contentValues, "userName = ?", new String[]{alVar.a}) == 0) {
                this.b.insert("signs", null, contentValues);
            }
        } catch (Throwable th) {
            Log.e("tbhp_s_db", "failed to insert " + alVar.a + " to db.", th);
        }
    }

    public List a() {
        Cursor cursor = null;
        try {
            cursor = this.b.rawQuery("SELECT * FROM signs where signStatus = ? and lastSign < ?", new String[]{String.valueOf(0), String.valueOf(al.c())});
            return a(cursor);
        } catch (Throwable th) {
            try {
                Log.e("tbhp_s_db", "failed to listUsersWaitingToSignToday", th);
                com.mofamulu.tieba.ch.ac.a(cursor);
                return new LinkedList();
            } finally {
                com.mofamulu.tieba.ch.ac.a(cursor);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [150=4] */
    public al b(String str) {
        Cursor cursor;
        try {
            cursor = this.b.rawQuery("SELECT * FROM signs where userName = ?", new String[]{str});
            try {
                List a = a(cursor);
                if (a.isEmpty()) {
                    return null;
                }
                return (al) a.get(0);
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("tbhp_s_db", "failed to findSignInfoByUserName:" + str, th);
                    return null;
                } finally {
                    com.mofamulu.tieba.ch.ac.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public List b() {
        Cursor cursor = null;
        try {
            cursor = this.b.rawQuery("SELECT * FROM signs", new String[0]);
            return a(cursor);
        } catch (Throwable th) {
            try {
                Log.e("tbhp_s_db", "failed to listAllUsers", th);
                com.mofamulu.tieba.ch.ac.a(cursor);
                return new LinkedList();
            } finally {
                com.mofamulu.tieba.ch.ac.a(cursor);
            }
        }
    }

    protected List a(Cursor cursor) {
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            al alVar = new al();
            alVar.a = cursor.getString(cursor.getColumnIndex("userName"));
            alVar.b = cursor.getString(cursor.getColumnIndex("password"));
            alVar.c = cursor.getString(cursor.getColumnIndex("authCode"));
            alVar.d = cursor.getString(cursor.getColumnIndex("cookies"));
            alVar.e = cursor.getString(cursor.getColumnIndex("loginError"));
            alVar.f = cursor.getInt(cursor.getColumnIndex("signStatus"));
            alVar.g = cursor.getInt(cursor.getColumnIndex("lastSign"));
            alVar.j = cursor.getInt(cursor.getColumnIndex("fromType"));
            alVar.b(cursor.getString(cursor.getColumnIndex("ignoredTiebas")));
            alVar.a(cursor.getString(cursor.getColumnIndex("tiebas")));
            linkedList.addLast(alVar);
        }
        return linkedList;
    }

    public void c(String str) {
        try {
            this.b.delete("signs", "userName = ?", new String[]{str});
        } catch (Throwable th) {
            Log.e("tbhp_s_db", "failed to delete user" + str, th);
        }
    }

    public void c() {
        try {
            this.b.close();
        } catch (Throwable th) {
            Log.e("tbhp_s_db", "failed to closeDB.", th);
        }
    }
}
