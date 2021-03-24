package dxm.sasdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class DbAdapter {

    /* renamed from: d  reason: collision with root package name */
    public static final String f67391d = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL);";

    /* renamed from: e  reason: collision with root package name */
    public static final String f67392e;

    /* renamed from: a  reason: collision with root package name */
    public final Context f67393a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67394b;

    /* renamed from: c  reason: collision with root package name */
    public a f67395c = null;

    /* loaded from: classes7.dex */
    public enum Table {
        EVENTS("events");
        
        public final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public final File f67396a;

        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
            this.f67396a = context.getDatabasePath(str);
        }

        public boolean a() {
            return !this.f67396a.exists() || Math.max(this.f67396a.getUsableSpace(), 33554432L) >= this.f67396a.length();
        }

        public void b() {
            close();
            this.f67396a.delete();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                Log.i("SA.DbAdapter", "Creating a new Sensors Analytics DB");
            }
            sQLiteDatabase.execSQL(DbAdapter.f67391d);
            sQLiteDatabase.execSQL(DbAdapter.f67392e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                Log.i("SA.DbAdapter", "Upgrading app, replacing Sensors Analytics DB");
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
            sQLiteDatabase.execSQL(DbAdapter.f67391d);
            sQLiteDatabase.execSQL(DbAdapter.f67392e);
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb.append(Table.EVENTS.getName());
        sb.append(" (");
        sb.append("created_at");
        sb.append(");");
        f67392e = sb.toString();
    }

    public DbAdapter(Context context, String str) {
        this.f67393a = context;
        this.f67394b = str;
        f();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0080 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x0030 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public int c(JSONObject jSONObject, Table table) {
        Cursor cursor;
        a aVar;
        if (!this.f67395c.a()) {
            Log.e("SA.DbAdapter", "There is not enough space left on the device to store events, so will delete some old events");
            String[] e2 = e(Table.EVENTS, 100);
            if (e2 == null || d(e2[0], Table.EVENTS) <= 0) {
                return -2;
            }
        }
        String name = table.getName();
        int i = -1;
        synchronized (this.f67395c) {
            Cursor cursor2 = 0;
            cursor2 = 0;
            Cursor cursor3 = null;
            Cursor cursor4 = null;
            try {
                try {
                    try {
                        SQLiteDatabase writableDatabase = this.f67395c.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("data", jSONObject.toString());
                        contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                        writableDatabase.insert(name, null, contentValues);
                        cursor = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name, null);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor2 != 0) {
                            cursor2.close();
                        }
                        this.f67395c.close();
                        throw th;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = null;
                } catch (IllegalStateException e4) {
                    e = e4;
                    cursor = null;
                }
                try {
                    cursor.moveToFirst();
                    i = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f67395c;
                } catch (SQLiteException e5) {
                    e = e5;
                    Log.e("SA.DbAdapter", "Could not add data to table " + name + ". Re-initializing database.", e);
                    if (cursor != null) {
                        cursor.close();
                    } else {
                        cursor3 = cursor;
                    }
                    f();
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    aVar = this.f67395c;
                    cursor2 = cursor3;
                    aVar.close();
                    return i;
                } catch (IllegalStateException e6) {
                    e = e6;
                    Log.e("SA.DbAdapter", "Could not add data to table " + name + ". Re-initializing database.", e);
                    if (cursor != null) {
                        cursor.close();
                    } else {
                        cursor4 = cursor;
                    }
                    f();
                    if (cursor4 != null) {
                        cursor4.close();
                    }
                    aVar = this.f67395c;
                    cursor2 = cursor4;
                    aVar.close();
                    return i;
                }
                aVar.close();
            } catch (Throwable th2) {
                th = th2;
                cursor2 = jSONObject;
            }
        }
        return i;
    }

    public int d(String str, Table table) {
        a aVar;
        int i;
        String name = table.getName();
        synchronized (this.f67395c) {
            Cursor cursor = null;
            try {
                SQLiteDatabase writableDatabase = this.f67395c.getWritableDatabase();
                writableDatabase.delete(name, "_id <= " + str, null);
                cursor = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name, null);
                cursor.moveToFirst();
                i = cursor.getInt(0);
                if (cursor != null) {
                    cursor.close();
                }
                this.f67395c.close();
            } catch (SQLiteException e2) {
                Log.e("SA.DbAdapter", "Could not clean sent records from " + name + ". Re-initializing database.", e2);
                f();
                if (cursor != null) {
                    cursor.close();
                }
                aVar = this.f67395c;
                aVar.close();
                i = -1;
                return i;
            } catch (IllegalStateException e3) {
                Log.e("SA.DbAdapter", "Could not clean sent records from " + name + ". Re-initializing database.", e3);
                f();
                if (cursor != null) {
                    cursor.close();
                }
                aVar = this.f67395c;
                aVar.close();
                i = -1;
                return i;
            }
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] e(Table table, int i) {
        Cursor cursor;
        a aVar;
        String str;
        String str2;
        String name = table.getName();
        synchronized (this.f67395c) {
            Cursor cursor2 = null;
            try {
            } catch (Throwable th) {
                th = th;
                cursor2 = i;
            }
            try {
                cursor = this.f67395c.getReadableDatabase().rawQuery("SELECT * FROM " + name + " ORDER BY created_at ASC LIMIT " + String.valueOf(i), null);
                try {
                    JSONArray jSONArray = new JSONArray();
                    str2 = null;
                    while (cursor.moveToNext()) {
                        if (cursor.isLast()) {
                            str2 = cursor.getString(cursor.getColumnIndex("_id"));
                        }
                        try {
                            jSONArray.put(new JSONObject(cursor.getString(cursor.getColumnIndex("data"))));
                        } catch (JSONException unused) {
                        }
                    }
                    str = jSONArray.length() > 0 ? jSONArray.toString() : null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.f67395c.close();
                } catch (SQLiteException e2) {
                    e = e2;
                    Log.e("SA.DbAdapter", "Could not pull records for SensorsData out of database " + name + ". Waiting to send.", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f67395c;
                    aVar.close();
                    str = null;
                    str2 = null;
                    if (str2 != null) {
                    }
                    return null;
                } catch (IllegalStateException e3) {
                    e = e3;
                    Log.e("SA.DbAdapter", "Could not pull records for SensorsData out of database " + name + ". Waiting to send.", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f67395c;
                    aVar.close();
                    str = null;
                    str2 = null;
                    if (str2 != null) {
                    }
                    return null;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (IllegalStateException e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                this.f67395c.close();
                throw th;
            }
        }
        if (str2 != null || str == null) {
            return null;
        }
        return new String[]{str2, str};
    }

    public void f() {
        a aVar = this.f67395c;
        if (aVar != null) {
            aVar.b();
        }
        this.f67395c = new a(this.f67393a, this.f67394b);
    }
}
