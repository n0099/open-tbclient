package d.b.f0.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import d.b.f0.l.c;
import d.b.f0.l.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f43387c;

    /* renamed from: a  reason: collision with root package name */
    public b f43388a;

    /* renamed from: b  reason: collision with root package name */
    public Context f43389b;

    /* loaded from: classes2.dex */
    public class b extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("create table if not exists rp_tb(id integer primary key autoincrement, a text, c integer, d integer);");
            } catch (Throwable th) {
                c.d(th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public b(a aVar, Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 1);
        }
    }

    public a(Context context) {
        this.f43389b = context;
        this.f43388a = new b(this.f43389b);
    }

    public static a a(Context context) {
        if (f43387c == null) {
            synchronized (a.class) {
                if (f43387c == null) {
                    f43387c = new a(context);
                }
            }
        }
        return f43387c;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<d.b.f0.j.a> b(String str) {
        Throwable th;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = this.f43388a.getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM rp_tb WHERE c IN (");
            sb.append(str);
            sb.append(") LIMIT 100");
            cursor = writableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        ArrayList<d.b.f0.j.a> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            d.b.f0.j.a aVar = new d.b.f0.j.a();
                            aVar.b(cursor.getInt(cursor.getColumnIndex("id")));
                            aVar.c(e.a(this.f43389b, cursor.getString(cursor.getColumnIndex("a"))));
                            aVar.g(cursor.getInt(cursor.getColumnIndex("c")));
                            aVar.e(cursor.getInt(cursor.getColumnIndex("d")));
                            arrayList.add(aVar);
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c.d(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                c.d(th3);
                            }
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th4) {
                                c.d(th4);
                            }
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    c.d(th5);
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public void c(d.b.f0.j.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", e.b(this.f43389b, aVar.d().getBytes()));
            contentValues.put("c", Integer.valueOf(aVar.h()));
            contentValues.put("d", Integer.valueOf(aVar.f()));
            this.f43388a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            c.d(th);
        }
    }

    public void d(ArrayList<d.b.f0.j.a> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    f(arrayList.get(i));
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<d.b.f0.j.a> e(String str) {
        Throwable th;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = this.f43388a.getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM rp_tb WHERE c IN (");
            sb.append(str);
            sb.append(") and ");
            sb.append("d");
            sb.append("=");
            sb.append(2);
            sb.append(" LIMIT 100");
            cursor = writableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        ArrayList<d.b.f0.j.a> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            d.b.f0.j.a aVar = new d.b.f0.j.a();
                            aVar.b(cursor.getInt(cursor.getColumnIndex("id")));
                            aVar.c(e.a(this.f43389b, cursor.getString(cursor.getColumnIndex("a"))));
                            aVar.g(cursor.getInt(cursor.getColumnIndex("c")));
                            aVar.e(cursor.getInt(cursor.getColumnIndex("d")));
                            arrayList.add(aVar);
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        c.d(th);
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th3) {
                                c.d(th3);
                            }
                        }
                        return null;
                    } finally {
                        if (cursor != null) {
                            try {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            } catch (Throwable th4) {
                                c.d(th4);
                            }
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th5) {
                    c.d(th5);
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            cursor = null;
        }
    }

    public final void f(d.b.f0.j.a aVar) {
        try {
            this.f43388a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(aVar.a())});
        } catch (Throwable th) {
            System.currentTimeMillis();
            c.d(th);
        }
    }
}
