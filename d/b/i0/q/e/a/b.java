package d.b.i0.q.e.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import d.b.c.e.p.m;
import d.b.i0.e1.h.g;
import d.b.i0.e1.h.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f58986a;

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            if (f58986a == null) {
                f58986a = new b();
            }
            bVar = f58986a;
        }
        return bVar;
    }

    public final int a(d.b.i0.e1.g.a aVar) {
        SQLiteDatabase c2 = g.c();
        int i = 0;
        if (c2 != null) {
            try {
                if (o(c2, aVar.b())) {
                    ContentValues contentValues = new ContentValues();
                    long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(aVar.b());
                    contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                    int j = h.e().j("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.b())});
                    try {
                        aVar.h(correctUserIdAfterOverflowCut);
                        i = j;
                    } catch (Exception e2) {
                        e = e2;
                        i = j;
                        e.printStackTrace();
                        return i;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return i;
    }

    public boolean b(long j) {
        return c(g.c(), j);
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return h.e().b("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final long d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.c();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = h.e().h("select * from tb_new_friends", new String[0]);
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getLong(cursor.getColumnIndex("uid"));
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                return 0L;
            } finally {
                m.a(cursor);
            }
        }
        return 0L;
    }

    public synchronized d.b.i0.e1.g.a e(long j) {
        d.b.i0.e1.g.a aVar;
        aVar = new d.b.i0.e1.g.a();
        Cursor cursor = null;
        try {
            cursor = h.e().h("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
            if (cursor != null && cursor.moveToNext()) {
                aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        m.a(cursor);
        return aVar;
    }

    public List<d.b.i0.e1.g.a> g() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        d.b.i0.e1.g.a aVar = new d.b.i0.e1.g.a();
                        aVar.h(cursor.getLong(cursor.getColumnIndex("uid")));
                        aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                        aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                        aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                        aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                        aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        arrayList.add(aVar);
                    }
                    p();
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return arrayList;
        } finally {
            m.a(cursor);
        }
    }

    public int h() {
        Cursor cursor = null;
        try {
            try {
                cursor = h.e().h("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
                if (cursor != null && cursor.moveToNext()) {
                    return cursor.getInt(0);
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return 0;
        } finally {
            m.a(cursor);
        }
    }

    public final int i(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.c();
        }
        Cursor cursor = null;
        try {
            if (sQLiteDatabase == null) {
                return 0;
            }
            try {
                cursor = h.e().h("select * from tb_new_friends", new String[0]);
                if (cursor != null && cursor.moveToFirst()) {
                    return cursor.getCount();
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return 0;
        } finally {
            m.a(cursor);
        }
    }

    public List<d.b.i0.e1.g.a> j() {
        SQLiteDatabase c2 = g.c();
        ArrayList arrayList = new ArrayList();
        if (c2 != null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = h.e().h("select * from tb_new_friends ORDER BY _id DESC", null);
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                d.b.i0.e1.g.a aVar = new d.b.i0.e1.g.a();
                                aVar.h(cursor.getLong(cursor.getColumnIndex("uid")));
                                if (aVar.b() < 0) {
                                    a(aVar);
                                }
                                aVar.g(cursor.getString(cursor.getColumnIndex("ucontent")));
                                aVar.i(cursor.getInt(cursor.getColumnIndex("isread")));
                                aVar.j(cursor.getString(cursor.getColumnIndex("uname")));
                                aVar.k(cursor.getString(cursor.getColumnIndex("uportrait")));
                                aVar.l(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                arrayList.add(aVar);
                            }
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                m.a(cursor);
            }
        }
        return arrayList;
    }

    public final void k(SQLiteDatabase sQLiteDatabase, d.b.i0.e1.g.a aVar) throws Exception {
        if (aVar == null || aVar.b() == 0 || TextUtils.isEmpty(aVar.d())) {
            return;
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.c();
        }
        if (sQLiteDatabase != null) {
            c(sQLiteDatabase, aVar.b());
            if (i(sQLiteDatabase) >= 200) {
                b(d(sQLiteDatabase));
            }
            if (sQLiteDatabase != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("uid", Long.valueOf(aVar.b()));
                contentValues.put("uname", aVar.d());
                contentValues.put("uportrait", aVar.e());
                contentValues.put("ucontent", aVar.a());
                contentValues.put("ustatus", Integer.valueOf(aVar.f()));
                contentValues.put("isread", Integer.valueOf(aVar.c()));
                h.e().g("tb_new_friends", null, contentValues);
            }
        }
    }

    public void l(d.b.i0.e1.g.a aVar) {
        try {
            k(g.c(), aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m(List<d.b.i0.e1.g.a> list) {
        try {
            for (d.b.i0.e1.g.a aVar : list) {
                k(g.c(), aVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean n(long j) {
        return o(g.c(), j);
    }

    public final boolean o(SQLiteDatabase sQLiteDatabase, long j) {
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.c();
        }
        boolean z = false;
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = h.e().h("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            z = true;
                        }
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                m.a(cursor);
            }
        }
        return z;
    }

    public void p() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        h.e().j("tb_new_friends", contentValues, null, null);
    }

    public int q(d.b.i0.e1.g.a aVar) {
        SQLiteDatabase c2 = g.c();
        int i = 0;
        if (c2 != null) {
            try {
                if (o(c2, aVar.b())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(aVar.f()));
                    contentValues.put("isread", Integer.valueOf(aVar.c()));
                    i = h.e().j("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.b())});
                } else {
                    k(c2, aVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i;
    }
}
