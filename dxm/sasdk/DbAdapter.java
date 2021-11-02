package dxm.sasdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
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
/* loaded from: classes2.dex */
public class DbAdapter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f71630d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71631e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f71632a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71633b;

    /* renamed from: c  reason: collision with root package name */
    public a f71634c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final File f71635e;

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
            this.f71635e = context.getDatabasePath(str);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !this.f71635e.exists() || Math.max(this.f71635e.getUsableSpace(), 33554432L) >= this.f71635e.length() : invokeV.booleanValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                close();
                this.f71635e.delete();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
                DxmSdkSensorsDataAPI.r.booleanValue();
                sQLiteDatabase.execSQL(DbAdapter.f71630d);
                sQLiteDatabase.execSQL(DbAdapter.f71631e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
                DxmSdkSensorsDataAPI.r.booleanValue();
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
                sQLiteDatabase.execSQL(DbAdapter.f71630d);
                sQLiteDatabase.execSQL(DbAdapter.f71631e);
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
        f71630d = "CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, data STRING NOT NULL, created_at INTEGER NOT NULL);";
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb.append(Table.EVENTS.getName());
        sb.append(" (");
        sb.append("created_at");
        sb.append(");");
        f71631e = sb.toString();
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
        this.f71634c = null;
        this.f71632a = context;
        this.f71633b = str;
        f();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0078 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x002d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0 A[Catch: all -> 0x00d9, TryCatch #2 {, blocks: (B:18:0x006f, B:19:0x0072, B:20:0x0074, B:45:0x00ca, B:32:0x009c, B:33:0x009f, B:43:0x00c4, B:44:0x00c7, B:50:0x00d0, B:51:0x00d3, B:52:0x00d8), top: B:64:0x002d }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(JSONObject jSONObject, Table table) {
        InterceptResult invokeLL;
        Cursor cursor;
        a aVar;
        String[] e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, table)) == null) {
            if (this.f71634c.a() || ((e2 = e(Table.EVENTS, 100)) != null && d(e2[0], Table.EVENTS) > 0)) {
                String name = table.getName();
                int i2 = -1;
                synchronized (this.f71634c) {
                    Cursor cursor2 = 0;
                    cursor2 = 0;
                    Cursor cursor3 = null;
                    Cursor cursor4 = null;
                    try {
                        try {
                            try {
                                SQLiteDatabase writableDatabase = this.f71634c.getWritableDatabase();
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
                                    aVar = this.f71634c;
                                } catch (SQLiteException unused) {
                                    String str = "Could not add data to table " + name + ". Re-initializing database.";
                                    if (cursor != null) {
                                        cursor.close();
                                    } else {
                                        cursor3 = cursor;
                                    }
                                    f();
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    aVar = this.f71634c;
                                    cursor2 = cursor3;
                                    aVar.close();
                                    return i2;
                                } catch (IllegalStateException unused2) {
                                    String str2 = "Could not add data to table " + name + ". Re-initializing database.";
                                    if (cursor != null) {
                                        cursor.close();
                                    } else {
                                        cursor4 = cursor;
                                    }
                                    f();
                                    if (cursor4 != null) {
                                        cursor4.close();
                                    }
                                    aVar = this.f71634c;
                                    cursor2 = cursor4;
                                    aVar.close();
                                    return i2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (cursor2 != 0) {
                                    cursor2.close();
                                }
                                this.f71634c.close();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = jSONObject;
                            if (cursor2 != 0) {
                            }
                            this.f71634c.close();
                            throw th;
                        }
                    } catch (SQLiteException unused3) {
                        cursor = null;
                    } catch (IllegalStateException unused4) {
                        cursor = null;
                    }
                    aVar.close();
                }
                return i2;
            }
            return -2;
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
            synchronized (this.f71634c) {
                Cursor cursor = null;
                try {
                    try {
                        SQLiteDatabase writableDatabase = this.f71634c.getWritableDatabase();
                        writableDatabase.delete(name, "_id <= " + str, null);
                        cursor = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + name, null);
                        cursor.moveToFirst();
                        i2 = cursor.getInt(0);
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.f71634c.close();
                    } catch (IllegalStateException unused) {
                        String str2 = "Could not clean sent records from " + name + ". Re-initializing database.";
                        f();
                        if (cursor != null) {
                            cursor.close();
                        }
                        aVar = this.f71634c;
                        aVar.close();
                        i2 = -1;
                        return i2;
                    }
                } catch (SQLiteException unused2) {
                    String str3 = "Could not clean sent records from " + name + ". Re-initializing database.";
                    f();
                    if (cursor != null) {
                        cursor.close();
                    }
                    aVar = this.f71634c;
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
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8 A[ADDED_TO_REGION] */
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
            synchronized (this.f71634c) {
                Cursor cursor2 = null;
                try {
                } catch (Throwable th) {
                    th = th;
                    cursor2 = i2;
                }
                try {
                    cursor = this.f71634c.getReadableDatabase().rawQuery("SELECT * FROM " + name + " ORDER BY created_at ASC LIMIT " + String.valueOf(i2), null);
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
                        this.f71634c.close();
                    } catch (SQLiteException unused2) {
                        String str3 = "Could not pull records for SensorsData out of database " + name + ". Waiting to send.";
                        if (cursor != null) {
                            cursor.close();
                        }
                        aVar = this.f71634c;
                        aVar.close();
                        str = null;
                        str2 = null;
                        if (str2 != null) {
                        }
                        return null;
                    } catch (IllegalStateException unused3) {
                        String str4 = "Could not pull records for SensorsData out of database " + name + ". Waiting to send.";
                        if (cursor != null) {
                            cursor.close();
                        }
                        aVar = this.f71634c;
                        aVar.close();
                        str = null;
                        str2 = null;
                        if (str2 != null) {
                        }
                        return null;
                    }
                } catch (SQLiteException unused4) {
                    cursor = null;
                } catch (IllegalStateException unused5) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    this.f71634c.close();
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
            a aVar = this.f71634c;
            if (aVar != null) {
                aVar.c();
            }
            this.f71634c = new a(this.f71632a, this.f71633b);
        }
    }
}
