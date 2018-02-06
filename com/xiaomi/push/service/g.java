package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.tauth.AuthActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class g {
    private static volatile g a;
    private f b;

    private g(Context context) {
        this.b = new f(context);
    }

    private synchronized Cursor a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.k.a(false);
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM geoMessage", null);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return cursor;
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.k.a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                    int delete = writableDatabase.delete("geoMessage", "message_id = ?", new String[]{str});
                    writableDatabase.close();
                    i = delete;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                }
            }
        }
        return i;
    }

    public synchronized ArrayList<com.xiaomi.push.service.module.b> a() {
        ArrayList<com.xiaomi.push.service.module.b> arrayList;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            Cursor a2 = a(writableDatabase);
            arrayList = new ArrayList<>();
            if (a2 != null) {
                while (a2.moveToNext()) {
                    com.xiaomi.push.service.module.b bVar = new com.xiaomi.push.service.module.b();
                    bVar.a(a2.getString(a2.getColumnIndex("message_id")));
                    bVar.b(a2.getString(a2.getColumnIndex("geo_id")));
                    bVar.a(a2.getBlob(a2.getColumnIndex("content")));
                    bVar.a(a2.getInt(a2.getColumnIndex(AuthActivity.ACTION_KEY)));
                    bVar.a(a2.getLong(a2.getColumnIndex("deadline")));
                    arrayList.add(bVar);
                }
                a2.close();
            }
            writableDatabase.close();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized boolean a(ArrayList<ContentValues> arrayList) {
        boolean z;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            try {
                SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                writableDatabase.beginTransaction();
                Iterator<ContentValues> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (-1 == writableDatabase.insert("geoMessage", null, it.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    writableDatabase.setTransactionSuccessful();
                }
                writableDatabase.endTransaction();
                writableDatabase.close();
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                z = false;
            }
        }
        return z;
    }

    public synchronized int b(String str) {
        int i = 0;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.k.a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
                    int delete = writableDatabase.delete("geoMessage", "geo_id = ?", new String[]{str});
                    writableDatabase.close();
                    i = delete;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                }
            }
        }
        return i;
    }

    public synchronized ArrayList<com.xiaomi.push.service.module.b> c(String str) {
        ArrayList<com.xiaomi.push.service.module.b> arrayList;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        if (TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            try {
                ArrayList<com.xiaomi.push.service.module.b> a2 = a();
                ArrayList<com.xiaomi.push.service.module.b> arrayList2 = new ArrayList<>();
                Iterator<com.xiaomi.push.service.module.b> it = a2.iterator();
                while (it.hasNext()) {
                    com.xiaomi.push.service.module.b next = it.next();
                    if (TextUtils.equals(next.c(), str)) {
                        arrayList2.add(next);
                    }
                }
                arrayList = arrayList2;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                arrayList = null;
            }
        }
        return arrayList;
    }
}
