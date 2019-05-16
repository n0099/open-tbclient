package com.xiaomi.push.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    private static volatile g b;
    private static String c = "GeoFenceDao.";
    private Context a;

    private g(Context context) {
        this.a = context;
    }

    private synchronized Cursor a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            cursor = sQLiteDatabase.query("geofence", null, null, null, null, null, null);
        } catch (Exception e) {
            cursor = null;
        }
        return cursor;
    }

    public static g a(Context context) {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g(context);
                }
            }
        }
        return b;
    }

    private synchronized com.xiaomi.xmpush.thrift.n a(Cursor cursor) {
        com.xiaomi.xmpush.thrift.n nVar;
        try {
            com.xiaomi.xmpush.thrift.n[] values = com.xiaomi.xmpush.thrift.n.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    nVar = null;
                    break;
                }
                nVar = values[i];
                if (TextUtils.equals(cursor.getString(cursor.getColumnIndex("type")), nVar.name())) {
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            nVar = null;
        }
        return nVar;
    }

    private synchronized String a(List<com.xiaomi.xmpush.thrift.o> list) {
        String str;
        if (list != null) {
            if (list.size() >= 3) {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (com.xiaomi.xmpush.thrift.o oVar : list) {
                        if (oVar != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("point_lantitude", oVar.c());
                            jSONObject.put("point_longtitude", oVar.a());
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

    private synchronized com.xiaomi.xmpush.thrift.o b(Cursor cursor) {
        com.xiaomi.xmpush.thrift.o oVar;
        oVar = new com.xiaomi.xmpush.thrift.o();
        try {
            oVar.b(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_lantitude"))));
            oVar.a(Double.parseDouble(cursor.getString(cursor.getColumnIndex("center_longtitude"))));
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            oVar = null;
        }
        return oVar;
    }

    private synchronized ArrayList<com.xiaomi.xmpush.thrift.o> c(Cursor cursor) {
        ArrayList<com.xiaomi.xmpush.thrift.o> arrayList;
        ArrayList<com.xiaomi.xmpush.thrift.o> arrayList2 = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(cursor.getString(cursor.getColumnIndex("polygon_points")));
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                com.xiaomi.xmpush.thrift.o oVar = new com.xiaomi.xmpush.thrift.o();
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                oVar.b(jSONObject.getDouble("point_lantitude"));
                oVar.a(jSONObject.getDouble("point_longtitude"));
                arrayList2.add(oVar);
                i = i2 + 1;
            }
            arrayList = arrayList2;
        } catch (JSONException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            arrayList = null;
        }
        return arrayList;
    }

    private synchronized com.xiaomi.xmpush.thrift.j d(Cursor cursor) {
        com.xiaomi.xmpush.thrift.j jVar;
        try {
            jVar = com.xiaomi.xmpush.thrift.j.valueOf(cursor.getString(cursor.getColumnIndex("coordinate_provider")));
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            jVar = null;
        }
        return jVar;
    }

    public synchronized int a(String str, String str2) {
        int i = 0;
        synchronized (this) {
            com.xiaomi.channel.commonutils.misc.n.a(false);
            try {
                if ("Enter".equals(str2) || "Leave".equals(str2) || "Unknown".equals(str2)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("current_status", str2);
                    int update = h.a(this.a).a().update("geofence", contentValues, "id=?", new String[]{str});
                    h.a(this.a).b();
                    i = update;
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            }
        }
        return i;
    }

    public synchronized long a(com.xiaomi.xmpush.thrift.m mVar) {
        long j;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", mVar.a());
            contentValues.put("appId", Long.valueOf(mVar.e()));
            contentValues.put("name", mVar.c());
            contentValues.put(Constants.PACKAGE_NAME, mVar.g());
            contentValues.put("create_time", Long.valueOf(mVar.i()));
            contentValues.put("type", mVar.k().name());
            contentValues.put("center_longtitude", String.valueOf(mVar.m().a()));
            contentValues.put("center_lantitude", String.valueOf(mVar.m().c()));
            contentValues.put("circle_radius", Double.valueOf(mVar.o()));
            contentValues.put("polygon_point", a(mVar.q()));
            contentValues.put("coordinate_provider", mVar.s().name());
            contentValues.put("current_status", "Unknown");
            j = h.a(this.a).a().insert("geofence", null, contentValues);
            h.a(this.a).b();
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            j = -1;
        }
        return j;
    }

    public synchronized com.xiaomi.xmpush.thrift.m a(String str) {
        com.xiaomi.xmpush.thrift.m mVar;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            Iterator<com.xiaomi.xmpush.thrift.m> it = a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    mVar = null;
                    break;
                }
                mVar = it.next();
                if (TextUtils.equals(mVar.a(), str)) {
                    break;
                }
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            mVar = null;
        }
        return mVar;
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.m> a() {
        ArrayList<com.xiaomi.xmpush.thrift.m> arrayList;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            Cursor a = a(h.a(this.a).a());
            arrayList = new ArrayList<>();
            if (a != null) {
                while (a.moveToNext()) {
                    try {
                        com.xiaomi.xmpush.thrift.m mVar = new com.xiaomi.xmpush.thrift.m();
                        mVar.a(a.getString(a.getColumnIndex("id")));
                        mVar.b(a.getString(a.getColumnIndex("name")));
                        mVar.a(a.getInt(a.getColumnIndex("appId")));
                        mVar.c(a.getString(a.getColumnIndex(Constants.PACKAGE_NAME)));
                        mVar.b(a.getInt(a.getColumnIndex("create_time")));
                        com.xiaomi.xmpush.thrift.n a2 = a(a);
                        if (a2 == null) {
                            com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo type null");
                        } else {
                            mVar.a(a2);
                            if (TextUtils.equals("Circle", a2.name())) {
                                mVar.a(b(a));
                                mVar.a(a.getDouble(a.getColumnIndex("circle_radius")));
                            } else if (TextUtils.equals("Polygon", a2.name())) {
                                ArrayList<com.xiaomi.xmpush.thrift.o> c2 = c(a);
                                if (c2 == null || c2.size() < 3) {
                                    com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo points null or size<3");
                                } else {
                                    mVar.a(c2);
                                }
                            }
                            com.xiaomi.xmpush.thrift.j d = d(a);
                            if (d == null) {
                                com.xiaomi.channel.commonutils.logger.b.c(c + "findAllGeoFencing: geo Coordinate Provider null ");
                            } else {
                                mVar.a(d);
                                arrayList.add(mVar);
                            }
                        }
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
                    }
                }
                a.close();
            }
            h.a(this.a).b();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
            arrayList = null;
        }
        return arrayList;
    }

    public synchronized ArrayList<com.xiaomi.xmpush.thrift.m> b(String str) {
        ArrayList<com.xiaomi.xmpush.thrift.m> arrayList;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            ArrayList<com.xiaomi.xmpush.thrift.m> a = a();
            ArrayList<com.xiaomi.xmpush.thrift.m> arrayList2 = new ArrayList<>();
            Iterator<com.xiaomi.xmpush.thrift.m> it = a.iterator();
            while (it.hasNext()) {
                com.xiaomi.xmpush.thrift.m next = it.next();
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
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            Cursor a = a(h.a(this.a).a());
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
            h.a(this.a).b();
            str2 = "Unknown";
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            str2 = "Unknown";
        }
        return str2;
    }

    public synchronized int d(String str) {
        int i;
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            if (a(str) != null) {
                i = h.a(this.a).a().delete("geofence", "id = ?", new String[]{str});
                h.a(this.a).b();
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
        com.xiaomi.channel.commonutils.misc.n.a(false);
        try {
            if (TextUtils.isEmpty(str)) {
                i = 0;
            } else {
                i = h.a(this.a).a().delete("geofence", "package_name = ?", new String[]{str});
                h.a(this.a).b();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d(e.toString());
            i = 0;
        }
        return i;
    }
}
