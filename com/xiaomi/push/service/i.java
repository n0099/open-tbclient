package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class i {
    private static volatile i a;
    private Context b;

    private i(Context context) {
        this.b = context;
    }

    private synchronized Cursor a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            cursor = sQLiteDatabase.query("geoMessage", null, null, null, null, null, null);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            cursor = null;
        }
        return cursor;
    }

    public static i a(Context context) {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i(context);
                }
            }
        }
        return a;
    }

    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.n.a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int delete = h.a(this.b).a().delete("geoMessage", "message_id = ?", new String[]{str});
                    h.a(this.b).b();
                    i = delete;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                }
            }
        }
        return i;
    }

    public synchronized ArrayList<com.xiaomi.push.service.module.a> a() {
        ArrayList<com.xiaomi.push.service.module.a> arrayList;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            Cursor a2 = a(h.a(this.b).a());
            arrayList = new ArrayList<>();
            if (a2 != null) {
                while (a2.moveToNext()) {
                    com.xiaomi.push.service.module.a aVar = new com.xiaomi.push.service.module.a();
                    aVar.a(a2.getString(a2.getColumnIndex(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID)));
                    aVar.b(a2.getString(a2.getColumnIndex("geo_id")));
                    aVar.a(a2.getBlob(a2.getColumnIndex("content")));
                    aVar.a(a2.getInt(a2.getColumnIndex("action")));
                    aVar.a(a2.getLong(a2.getColumnIndex("deadline")));
                    arrayList.add(aVar);
                }
                a2.close();
            }
            h.a(this.b).b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized boolean a(ArrayList<ContentValues> arrayList) {
        boolean z;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            try {
                SQLiteDatabase a2 = h.a(this.b).a();
                a2.beginTransaction();
                Iterator<ContentValues> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    } else if (-1 == a2.insert("geoMessage", null, it.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    a2.setTransactionSuccessful();
                }
                a2.endTransaction();
                h.a(this.b).b();
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
            com.xiaomi.channel.commonutils.misc.n.a(false);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int delete = h.a(this.b).a().delete("geoMessage", "geo_id = ?", new String[]{str});
                    h.a(this.b).b();
                    i = delete;
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                }
            }
        }
        return i;
    }

    public synchronized ArrayList<com.xiaomi.push.service.module.a> c(String str) {
        ArrayList<com.xiaomi.push.service.module.a> arrayList;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        if (TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            try {
                ArrayList<com.xiaomi.push.service.module.a> a2 = a();
                ArrayList<com.xiaomi.push.service.module.a> arrayList2 = new ArrayList<>();
                Iterator<com.xiaomi.push.service.module.a> it = a2.iterator();
                while (it.hasNext()) {
                    com.xiaomi.push.service.module.a next = it.next();
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
