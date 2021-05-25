package d.a.j0.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import d.a.j0.l.c;
import d.a.j0.l.e;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f40447c;

    /* renamed from: a  reason: collision with root package name */
    public b f40448a;

    /* renamed from: b  reason: collision with root package name */
    public Context f40449b;

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
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }

        public b(a aVar, Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 1);
        }
    }

    public a(Context context) {
        this.f40449b = context;
        this.f40448a = new b(this.f40449b);
    }

    public static a a(Context context) {
        if (f40447c == null) {
            synchronized (a.class) {
                if (f40447c == null) {
                    f40447c = new a(context);
                }
            }
        }
        return f40447c;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<d.a.j0.j.a> b(String str) {
        Throwable th;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = this.f40448a.getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM rp_tb WHERE c IN (");
            sb.append(str);
            sb.append(") LIMIT 100");
            cursor = writableDatabase.rawQuery(sb.toString(), null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() != 0) {
                        ArrayList<d.a.j0.j.a> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            d.a.j0.j.a aVar = new d.a.j0.j.a();
                            aVar.b(cursor.getInt(cursor.getColumnIndex("id")));
                            aVar.c(e.a(this.f40449b, cursor.getString(cursor.getColumnIndex("a"))));
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

    public void c(d.a.j0.j.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("a", e.b(this.f40449b, aVar.d().getBytes()));
            contentValues.put("c", Integer.valueOf(aVar.h()));
            contentValues.put("d", Integer.valueOf(aVar.f()));
            this.f40448a.getWritableDatabase().insert("rp_tb", null, contentValues);
        } catch (Throwable th) {
            c.d(th);
        }
    }

    public void d(ArrayList<d.a.j0.j.a> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    f(arrayList.get(i2));
                }
            } catch (Throwable th) {
                c.d(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, IF, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public ArrayList<d.a.j0.j.a> e(String str) {
        Throwable th;
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = this.f40448a.getWritableDatabase();
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
                        ArrayList<d.a.j0.j.a> arrayList = new ArrayList<>();
                        while (cursor.moveToNext()) {
                            d.a.j0.j.a aVar = new d.a.j0.j.a();
                            aVar.b(cursor.getInt(cursor.getColumnIndex("id")));
                            aVar.c(e.a(this.f40449b, cursor.getString(cursor.getColumnIndex("a"))));
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

    public final void f(d.a.j0.j.a aVar) {
        try {
            this.f40448a.getWritableDatabase().delete("rp_tb", "id=?", new String[]{String.valueOf(aVar.a())});
        } catch (Throwable th) {
            System.currentTimeMillis();
            c.d(th);
        }
    }
}
