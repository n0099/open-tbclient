package dxm.sasdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DbAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f75199d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f75200e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f75201a;

    /* renamed from: b  reason: collision with root package name */
    public final String f75202b;

    /* renamed from: c  reason: collision with root package name */
    public a f75203c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Table {
        public static final /* synthetic */ Table[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Table EVENTS;
        public transient /* synthetic */ FieldHolder $fh;
        public final String mTableName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1959470139, "Ldxm/sasdk/DbAdapter$Table;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1959470139, "Ldxm/sasdk/DbAdapter$Table;");
                    return;
                }
            }
            Table table = new Table("EVENTS", 0, "events");
            EVENTS = table;
            $VALUES = new Table[]{table};
        }

        public Table(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTableName = str2;
        }

        public static Table valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Table) Enum.valueOf(Table.class, str) : (Table) invokeL.objValue;
        }

        public static Table[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Table[]) $VALUES.clone() : (Table[]) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTableName : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final File f75204a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75204a = context.getDatabasePath(str);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.f75204a.exists() || Math.max(this.f75204a.getUsableSpace(), 33554432L) >= this.f75204a.length() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                close();
                this.f75204a.delete();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
                if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                    Log.i("SA.DbAdapter", "Creating a new Sensors Analytics DB");
                }
                sQLiteDatabase.execSQL(DbAdapter.f75199d);
                sQLiteDatabase.execSQL(DbAdapter.f75200e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
                if (DxmSdkSensorsDataAPI.r.booleanValue()) {
                    Log.i("SA.DbAdapter", "Upgrading app, replacing Sensors Analytics DB");
                }
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
                sQLiteDatabase.execSQL(DbAdapter.f75199d);
                sQLiteDatabase.execSQL(DbAdapter.f75200e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(221850511, "Ldxm/sasdk/DbAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(221850511, "Ldxm/sasdk/DbAdapter;");
                return;
            }
        }
        f75199d = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL);";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb.append(Table.EVENTS.getName());
        sb.append(" (");
        sb.append("created_at");
        sb.append(");");
        f75200e = sb.toString();
    }

    public DbAdapter(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75203c = null;
        this.f75201a = context;
        this.f75202b = str;
        f();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0084 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public int c(JSONObject jSONObject, Table table) {
        InterceptResult invokeLL;
        Cursor cursor;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, table)) == null) {
            if (!this.f75203c.a()) {
                Log.e("SA.DbAdapter", "There is not enough space left on the device to store events, so will delete some old events");
                String[] e2 = e(Table.EVENTS, 100);
                if (e2 == null || d(e2[0], Table.EVENTS) <= 0) {
                    return -2;
                }
            }
            String name = table.getName();
            int i2 = -1;
            synchronized (this.f75203c) {
                Cursor cursor2 = 0;
                cursor2 = 0;
                Cursor cursor3 = null;
                Cursor cursor4 = null;
                try {
                    try {
                        try {
                            SQLiteDatabase writableDatabase = this.f75203c.getWritableDatabase();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("data", jSONObject.toString());
                            contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
                            writableDatabase.insert(name, null, contentValues);
                            cursor = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name, null);
                            try {
                                cursor.moveToFirst();
                                i2 = cursor.getInt(0);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                aVar = this.f75203c;
                            } catch (SQLiteException e3) {
                                e = e3;
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
                                aVar = this.f75203c;
                                cursor2 = cursor3;
                                aVar.close();
                                return i2;
                            } catch (IllegalStateException e4) {
                                e = e4;
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
                                aVar = this.f75203c;
                                cursor2 = cursor4;
                                aVar.close();
                                return i2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = jSONObject;
                            if (cursor2 != 0) {
                                cursor2.close();
                            }
                            this.f75203c.close();
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        cursor = null;
                    } catch (IllegalStateException e6) {
                        e = e6;
                        cursor = null;
                    }
                    aVar.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public int d(String str, Table table) {
        InterceptResult invokeLL;
        a aVar;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, table)) == null) {
            String name = table.getName();
            synchronized (this.f75203c) {
                Cursor cursor = null;
                try {
                    SQLiteDatabase writableDatabase = this.f75203c.getWritableDatabase();
                    writableDatabase.delete(name, "_id <= " + str, null);
                    cursor = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name, null);
                    cursor.moveToFirst();
                    i2 = cursor.getInt(0);
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.f75203c.close();
                } catch (SQLiteException e2) {
                    Log.e("SA.DbAdapter", "Could not clean sent records from " + name + ". Re-initializing database.", e2);
                    f();
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f75203c;
                    aVar.close();
                    i2 = -1;
                    return i2;
                } catch (IllegalStateException e3) {
                    Log.e("SA.DbAdapter", "Could not clean sent records from " + name + ". Re-initializing database.", e3);
                    f();
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f75203c;
                    aVar.close();
                    i2 = -1;
                    return i2;
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] e(Table table, int i2) {
        InterceptResult invokeLI;
        Cursor cursor;
        a aVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, table, i2)) == null) {
            String name = table.getName();
            synchronized (this.f75203c) {
                Cursor cursor2 = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    cursor2 = i2;
                }
                try {
                    cursor = this.f75203c.getReadableDatabase().rawQuery("SELECT * FROM " + name + " ORDER BY created_at ASC LIMIT " + String.valueOf(i2), null);
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
                        this.f75203c.close();
                    } catch (SQLiteException e2) {
                        e = e2;
                        Log.e("SA.DbAdapter", "Could not pull records for SensorsData out of database " + name + ". Waiting to send.", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        aVar = this.f75203c;
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
                        aVar = this.f75203c;
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
                    this.f75203c.close();
                    throw th;
                }
            }
            if (str2 != null || str == null) {
                return null;
            }
            return new String[]{str2, str};
        }
        return (String[]) invokeLI.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a aVar = this.f75203c;
            if (aVar != null) {
                aVar.b();
            }
            this.f75203c = new a(this.f75201a, this.f75202b);
        }
    }
}
