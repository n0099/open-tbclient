package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class t {
    public static /* synthetic */ Interceptable $ic = null;
    public static t E = null;
    public static final String a = "k";
    public static final String b = "p";
    public static final String c = "v";
    public static final String d = "l";
    public static final String e = "i";
    public static final String f = "a";
    public static final String g = "s";
    public static final String h = "n";
    public static final String i = "u";
    public static final String j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public a B;
    public SQLiteDatabase C;
    public Context D;
    public int z;

    /* loaded from: classes10.dex */
    public class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t tVar, Context context) {
            super(context, bi.p, (SQLiteDatabase.CursorFactory) null, tVar.z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.a.A);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) && i < 3 && i2 >= 3) {
                try {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                        sQLiteDatabase.setTransactionSuccessful();
                    } catch (Throwable unused) {
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = 1;
        this.A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";
        this.D = context.getApplicationContext();
        this.B = new a(this, context.getApplicationContext());
        try {
            if (!context.getFilesDir().getParentFile().exists()) {
                return;
            }
            this.C = this.B.getWritableDatabase();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            boolean z = false;
            try {
                cursor = this.C.query(bi.q, new String[]{"p"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            z = true;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return z;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            int i3 = 0;
            try {
                cursor = this.C.query(bi.q, new String[]{"n"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            i3 = cursor.getInt(cursor.getColumnIndex("n"));
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return i3;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return i3;
        }
        return invokeI.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r11.isClosed() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            boolean z = false;
            try {
                cursor = this.C.query(bi.q, new String[]{"s"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                                z = true;
                            }
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return z;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public static synchronized t a(Context context) {
        InterceptResult invokeL;
        t tVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (t.class) {
                if (E == null) {
                    E = new t(context);
                }
                tVar = E;
            }
            return tVar;
        }
        return (t) invokeL.objValue;
    }

    public int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.C;
                return sQLiteDatabase.update(bi.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.C;
                sQLiteDatabase.update(bi.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pc", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.C;
                sQLiteDatabase.update(bi.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
            }
        }
    }

    public long a(s sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar)) == null) {
            long j2 = 0;
            if (sVar == null) {
                return 0L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(sVar.b));
            contentValues.put("aps", Integer.valueOf(sVar.p));
            contentValues.put("p", sVar.c);
            contentValues.put("a", sVar.e);
            contentValues.put("l", sVar.h);
            contentValues.put("v", sVar.d);
            contentValues.put(q, sVar.n);
            contentValues.put("a", sVar.e);
            contentValues.put(r, sVar.o);
            contentValues.put(s, Long.valueOf(sVar.s));
            contentValues.put(w, Integer.valueOf(sVar.w));
            contentValues.put("at", Integer.valueOf(sVar.q));
            contentValues.put("pc", Integer.valueOf(sVar.x));
            contentValues.put(y, Integer.valueOf(sVar.y ? 1 : 0));
            if (!TextUtils.isEmpty(sVar.j)) {
                contentValues.put(v, sVar.j);
            }
            try {
                if (b(sVar.a)) {
                    j2 = this.C.update(bi.q, contentValues, "k=" + sVar.a, null);
                } else {
                    contentValues.put("k", Integer.valueOf(sVar.a));
                    j2 = this.C.insert(bi.q, null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public s b(String str) {
        InterceptResult invokeL;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            Cursor cursor = null;
            r1 = null;
            s sVar2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                boolean z = true;
                Cursor query = this.C.query(bi.q, null, "p=?", new String[]{str}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            sVar = new s();
                            try {
                                sVar.a = query.getInt(query.getColumnIndex("k"));
                                sVar.b = query.getInt(query.getColumnIndex("n"));
                                sVar.c = query.getString(query.getColumnIndex("p"));
                                sVar.e = query.getString(query.getColumnIndex("a"));
                                sVar.h = query.getString(query.getColumnIndex("l"));
                                sVar.d = query.getString(query.getColumnIndex("v"));
                                sVar.n = query.getString(query.getColumnIndex(q));
                                sVar.p = query.getInt(query.getColumnIndex("aps"));
                                sVar.o = query.getString(query.getColumnIndex(r));
                                sVar.q = query.getInt(query.getColumnIndex("at"));
                                sVar.s = query.getLong(query.getColumnIndex(s));
                                sVar.t = query.getInt(query.getColumnIndex("d"));
                                sVar.w = query.getInt(query.getColumnIndex(w));
                                sVar.j = query.getString(query.getColumnIndex(v));
                                sVar.x = query.getInt(query.getColumnIndex("pc"));
                                if (query.getInt(query.getColumnIndex(y)) != 1) {
                                    z = false;
                                }
                                sVar.y = z;
                                sVar2 = sVar;
                            } catch (Throwable unused) {
                                cursor = query;
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                return sVar;
                            }
                        }
                    } catch (Throwable unused2) {
                        sVar = null;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                    return sVar2;
                }
                return sVar2;
            } catch (Throwable unused3) {
                sVar = null;
            }
        } else {
            return (s) invokeL.objValue;
        }
    }

    public s a(int i2) {
        InterceptResult invokeI;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            Cursor cursor = null;
            r0 = null;
            s sVar2 = null;
            try {
                Cursor query = this.C.query(bi.q, null, "k=" + i2, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            sVar = new s();
                            try {
                                sVar.a = i2;
                                sVar.b = query.getInt(query.getColumnIndex("n"));
                                sVar.c = query.getString(query.getColumnIndex("p"));
                                sVar.e = query.getString(query.getColumnIndex("a"));
                                sVar.h = query.getString(query.getColumnIndex("l"));
                                sVar.d = query.getString(query.getColumnIndex("v"));
                                sVar.n = query.getString(query.getColumnIndex(q));
                                sVar.p = query.getInt(query.getColumnIndex("aps"));
                                sVar.o = query.getString(query.getColumnIndex(r));
                                sVar.q = query.getInt(query.getColumnIndex("at"));
                                sVar.s = query.getLong(query.getColumnIndex(s));
                                sVar.t = query.getInt(query.getColumnIndex("d"));
                                sVar.w = query.getInt(query.getColumnIndex(w));
                                sVar.j = query.getString(query.getColumnIndex(v));
                                sVar.x = query.getInt(query.getColumnIndex("pc"));
                                boolean z = true;
                                if (query.getInt(query.getColumnIndex(y)) != 1) {
                                    z = false;
                                }
                                sVar.y = z;
                                sVar2 = sVar;
                            } catch (Throwable unused) {
                                cursor = query;
                                if (cursor != null && !cursor.isClosed()) {
                                    cursor.close();
                                }
                                return sVar;
                            }
                        }
                    } catch (Throwable unused2) {
                        sVar = null;
                    }
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                    return sVar2;
                }
                return sVar2;
            } catch (Throwable unused3) {
                sVar = null;
            }
        } else {
            return (s) invokeI.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ae, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b8, code lost:
        if (r1.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<s> a() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                cursor = this.C.query(bi.q, null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            s sVar = new s();
                            sVar.a = cursor.getInt(cursor.getColumnIndex("k"));
                            sVar.c = cursor.getString(cursor.getColumnIndex("p"));
                            sVar.e = cursor.getString(cursor.getColumnIndex("a"));
                            sVar.h = cursor.getString(cursor.getColumnIndex("l"));
                            sVar.d = cursor.getString(cursor.getColumnIndex("v"));
                            sVar.s = cursor.getLong(cursor.getColumnIndex(s));
                            sVar.t = cursor.getInt(cursor.getColumnIndex("d"));
                            sVar.w = cursor.getInt(cursor.getColumnIndex(w));
                            sVar.x = cursor.getInt(cursor.getColumnIndex("pc"));
                            boolean z = true;
                            if (cursor.getInt(cursor.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            arrayList.add(sVar);
                        } catch (Throwable unused) {
                            if (cursor != null) {
                            }
                            return arrayList;
                        }
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ArrayList<s> arrayList = new ArrayList();
            for (s sVar : a()) {
                if (!dn.a(sVar.e)) {
                    arrayList.add(sVar);
                }
            }
            try {
                r a2 = r.a();
                for (s sVar2 : arrayList) {
                    if (a2 != null) {
                        a2.a(sVar2.e);
                    }
                    SQLiteDatabase sQLiteDatabase = this.C;
                    sQLiteDatabase.delete(bi.q, "k=" + sVar2.a, null);
                    if (r.b != null && !r.b.contains(Integer.valueOf(sVar2.a))) {
                        dn.c(this.D.getFilesDir().getCanonicalPath() + bi.j + sVar2.a);
                    }
                    if (a2.b() != null && a2.b().get(sVar2.c) != null) {
                        dn.c(this.D.getFileStreamPath(sVar2.c).getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) 0);
            try {
                this.C.update(bi.q, contentValues, "n=-1", null);
            } catch (Throwable unused) {
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", (Integer) 0);
            try {
                this.C.update(bi.q, contentValues, "u=1", null);
            } catch (Throwable unused) {
            }
        }
    }
}
