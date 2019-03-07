package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    private static volatile e b;
    private static String c = "GeoFenceDao.";
    private f a;

    private e(Context context) {
        this.a = new f(context);
    }

    private synchronized Cursor a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.k.a(false);
            try {
                cursor = sQLiteDatabase.rawQuery("SELECT * FROM geofence", null);
            } catch (Exception e) {
            }
        }
        return cursor;
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e(context);
                }
            }
        }
        return b;
    }

    private synchronized com.xiaomi.xmpush.thrift.k a(Cursor cursor) {
        com.xiaomi.xmpush.thrift.k kVar;
        try {
            com.xiaomi.xmpush.thrift.k[] values = com.xiaomi.xmpush.thrift.k.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    kVar = null;
                    break;
                }
                kVar = values[i];
                if (TextUtils.equals(cursor.getString(cursor.getColumnIndex("type")), kVar.name())) {
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            kVar = null;
        }
        return kVar;
    }

    private synchronized String a(List<com.xiaomi.xmpush.thrift.l> list) {
        String str;
        if (list != null) {
            if (list.size() >= 3) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (com.xiaomi.xmpush.thrift.l lVar : list) {
                        if (lVar != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("point_lantitude", lVar.c());
                            jSONObject.put("point_longtitude", lVar.a());
                            jSONArray.put(jSONObject);
                        }
                    }
                    str = jSONArray.toString();
                } catch (JSONException e) {
                    com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    str = null;
                }
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(c + " points unvalidated");
        str = null;
        return str;
    }

    private synchronized com.xiaomi.xmpush.thrift.l b(Cursor cursor) {
        com.xiaomi.xmpush.thrift.l lVar;
        lVar = new com.xiaomi.xmpush.thrift.l();
        try {
            lVar.b(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_lantitude"))));
            lVar.a(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_longtitude"))));
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            lVar = null;
        }
        return lVar;
    }

    private synchronized ArrayList<com.xiaomi.xmpush.thrift.l> c(Cursor cursor) {
        ArrayList<com.xiaomi.xmpush.thrift.l> arrayList;
        ArrayList<com.xiaomi.xmpush.thrift.l> arrayList2 = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex("polygon_points")));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                com.xiaomi.xmpush.thrift.l lVar = new com.xiaomi.xmpush.thrift.l();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                lVar.b(jSONObject.getDouble("point_lantitude"));
                lVar.a(jSONObject.getDouble("point_longtitude"));
                arrayList2.add(lVar);
                i = i2 + 1;
            }
            arrayList = arrayList2;
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    private synchronized com.xiaomi.xmpush.thrift.h d(Cursor cursor) {
        com.xiaomi.xmpush.thrift.h hVar;
        try {
            hVar = com.xiaomi.xmpush.thrift.h.valueOf(cursor.getString(cursor.getColumnIndex("coordinate_provider")));
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            hVar = null;
        }
        return hVar;
    }

    public synchronized int a(String str, String str2) {
        int i = 0;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.k.a(false);
            try {
                if ("Enter".equals(str2) || "Leave".equals(str2) || "Unknown".equals(str2)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("current_status", str2);
                    SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                    int update = writableDatabase.update("geofence", contentValues, "id=?", new String[]{str});
                    writableDatabase.close();
                    i = update;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return i;
    }

    public synchronized long a(com.xiaomi.xmpush.thrift.j jVar) {
        long j;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", jVar.a());
            contentValues.put("appId", Long.valueOf(jVar.e()));
            contentValues.put("name", jVar.c());
            contentValues.put("package_name", jVar.g());
            contentValues.put("create_time", Long.valueOf(jVar.i()));
            contentValues.put("type", jVar.k().name());
            contentValues.put("center_longtitude", String.valueOf(jVar.m().a()));
            contentValues.put("center_lantitude", String.valueOf(jVar.m().c()));
            contentValues.put("circle_radius", Double.valueOf(jVar.o()));
            contentValues.put("polygon_point", a(jVar.q()));
            contentValues.put("coordinate_provider", jVar.s().name());
            contentValues.put("current_status", "Unknown");
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            j = writableDatabase.insert("geofence", null, contentValues);
            writableDatabase.close();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            j = -1;
        }
        return j;
    }

    public synchronized com.xiaomi.xmpush.thrift.j a(String str) {
        com.xiaomi.xmpush.thrift.j jVar;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            Iterator<com.xiaomi.xmpush.thrift.j> it = a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    jVar = null;
                    break;
                }
                jVar = it.next();
                if (TextUtils.equals(jVar.a(), str)) {
                    break;
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            jVar = null;
        }
        return jVar;
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.j> a() {
        ArrayList<com.xiaomi.xmpush.thrift.j> arrayList;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            Cursor a = a(writableDatabase);
            arrayList = new ArrayList<>();
            if (a != null) {
                while (a.moveToNext()) {
                    try {
                        com.xiaomi.xmpush.thrift.j jVar = new com.xiaomi.xmpush.thrift.j();
                        jVar.a(a.getString(a.getColumnIndex("id")));
                        jVar.b(a.getString(a.getColumnIndex("name")));
                        jVar.a(a.getInt(a.getColumnIndex("appId")));
                        jVar.c(a.getString(a.getColumnIndex("package_name")));
                        jVar.b(a.getInt(a.getColumnIndex("create_time")));
                        com.xiaomi.xmpush.thrift.k a2 = a(a);
                        if (a2 == null) {
                            com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo type null");
                        } else {
                            jVar.a(a2);
                            if (TextUtils.equals("Circle", a2.name())) {
                                jVar.a(b(a));
                                jVar.a(a.getDouble(a.getColumnIndex("circle_radius")));
                            } else if (TextUtils.equals("Polygon", a2.name())) {
                                ArrayList<com.xiaomi.xmpush.thrift.l> c2 = c(a);
                                if (c2 == null || c2.size() < 3) {
                                    com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo points null or size<3");
                                } else {
                                    jVar.a(c2);
                                }
                            }
                            com.xiaomi.xmpush.thrift.h d = d(a);
                            if (d == null) {
                                com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo Coordinate Provider null ");
                            } else {
                                jVar.a(d);
                                arrayList.add(jVar);
                            }
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    }
                }
                a.close();
            }
            writableDatabase.close();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.j> b(String str) {
        ArrayList<com.xiaomi.xmpush.thrift.j> arrayList;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            ArrayList<com.xiaomi.xmpush.thrift.j> a = a();
            ArrayList<com.xiaomi.xmpush.thrift.j> arrayList2 = new ArrayList<>();
            Iterator<com.xiaomi.xmpush.thrift.j> it = a.iterator();
            while (it.hasNext()) {
                com.xiaomi.xmpush.thrift.j next = it.next();
                if (TextUtils.equals(next.g(), str)) {
                    arrayList2.add(next);
                }
            }
            arrayList = arrayList2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized String c(String str) {
        String str2;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            Cursor a = a(this.a.getWritableDatabase());
            if (a != null) {
                while (a.moveToNext()) {
                    if (TextUtils.equals(a.getString(a.getColumnIndex("id")), str)) {
                        str2 = a.getString(a.getColumnIndex("current_status"));
                        com.xiaomi.channel.commonutils.logger.b.c(c + "findGeoStatueByGeoId: geo current statue is " + str2 + " geoId:" + str);
                        a.close();
                        break;
                    }
                }
                a.close();
            }
            str2 = "Unknown";
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            str2 = "Unknown";
        }
        return str2;
    }

    public synchronized int d(String str) {
        int i;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            if (a(str) != null) {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                i = writableDatabase.delete("geofence", "id = ?", new String[]{str});
                writableDatabase.close();
            } else {
                i = 0;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            i = 0;
        }
        return i;
    }

    public synchronized int e(String str) {
        int i;
        com.xiaomi.channel.commonutils.misc.k.a(false);
        try {
            if (TextUtils.isEmpty(str)) {
                i = 0;
            } else {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                i = writableDatabase.delete("geofence", "package_name = ?", new String[]{str});
                writableDatabase.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            i = 0;
        }
        return i;
    }
}
