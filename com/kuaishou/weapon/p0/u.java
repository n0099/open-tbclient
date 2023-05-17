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
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "dm";
    public static final String B = "rm";
    public static final String C = "pc";
    public static final String D = "cbl";
    public static u E = null;
    public static final String f = "k";
    public static final String g = "p";
    public static final String h = "v";
    public static final String i = "l";
    public static final String j = "i";
    public static final String k = "a";
    public static final String l = "s";
    public static final String m = "n";
    public static final String n = "u";
    public static final String o = "c";
    public static final String p = "r";
    public static final String q = "b";
    public static final String r = "m";
    public static final String s = "el";
    public static final String t = "ail";
    public static final String u = "aps";
    public static final String v = "dp";
    public static final String w = "pcn";
    public static final String x = "pst";
    public static final String y = "d";
    public static final String z = "at";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public a c;
    public SQLiteDatabase d;
    public Context e;

    /* loaded from: classes9.dex */
    public class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, Context context) {
            super(context, i1.p, (SQLiteDatabase.CursorFactory) null, uVar.a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar, context};
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
            this.a = uVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.a.b);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) || i >= 3 || i2 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused) {
            }
        }
    }

    public u(Context context) {
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
        this.a = 1;
        this.b = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";
        this.e = context.getApplicationContext();
        this.c = new a(this, context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.d = this.c.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized u a(Context context) {
        InterceptResult invokeL;
        u uVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (u.class) {
                if (E == null) {
                    E = new u(context);
                }
                uVar = E;
            }
            return uVar;
        }
        return (u) invokeL.objValue;
    }

    public int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.d;
                return sQLiteDatabase.update(i1.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    public long a(t tVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar)) == null) {
            long j2 = 0;
            if (tVar == null) {
                return 0L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(tVar.b));
            contentValues.put("aps", Integer.valueOf(tVar.p));
            contentValues.put("p", tVar.c);
            contentValues.put("a", tVar.e);
            contentValues.put("l", tVar.h);
            contentValues.put("v", tVar.d);
            contentValues.put(v, tVar.n);
            contentValues.put("a", tVar.e);
            contentValues.put(w, tVar.o);
            contentValues.put(x, Long.valueOf(tVar.s));
            contentValues.put(B, Integer.valueOf(tVar.w));
            contentValues.put("at", Integer.valueOf(tVar.q));
            contentValues.put("pc", Integer.valueOf(tVar.x));
            contentValues.put(D, Integer.valueOf(tVar.y ? 1 : 0));
            if (!TextUtils.isEmpty(tVar.j)) {
                contentValues.put(A, tVar.j);
            }
            try {
                if (d(tVar.a)) {
                    j2 = this.d.update(i1.q, contentValues, "k=" + tVar.a, null);
                } else {
                    contentValues.put("k", Integer.valueOf(tVar.a));
                    j2 = this.d.insert(i1.q, null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j2;
        }
        return invokeL.longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00f4, code lost:
        if (r1.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00fe, code lost:
        if (r1.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0101, code lost:
        r1.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t a(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            t tVar = null;
            try {
                cursor = this.d.query(i1.q, null, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            t tVar2 = new t();
                            try {
                                tVar2.a = i2;
                                tVar2.b = cursor.getInt(cursor.getColumnIndex("n"));
                                tVar2.c = cursor.getString(cursor.getColumnIndex("p"));
                                tVar2.e = cursor.getString(cursor.getColumnIndex("a"));
                                tVar2.h = cursor.getString(cursor.getColumnIndex("l"));
                                tVar2.d = cursor.getString(cursor.getColumnIndex("v"));
                                tVar2.n = cursor.getString(cursor.getColumnIndex(v));
                                tVar2.p = cursor.getInt(cursor.getColumnIndex("aps"));
                                tVar2.o = cursor.getString(cursor.getColumnIndex(w));
                                tVar2.q = cursor.getInt(cursor.getColumnIndex("at"));
                                tVar2.s = cursor.getLong(cursor.getColumnIndex(x));
                                tVar2.t = cursor.getInt(cursor.getColumnIndex("d"));
                                tVar2.w = cursor.getInt(cursor.getColumnIndex(B));
                                tVar2.j = cursor.getString(cursor.getColumnIndex(A));
                                tVar2.x = cursor.getInt(cursor.getColumnIndex("pc"));
                                boolean z2 = true;
                                if (cursor.getInt(cursor.getColumnIndex(D)) != 1) {
                                    z2 = false;
                                }
                                tVar2.y = z2;
                                tVar = tVar2;
                            } catch (Throwable unused) {
                                tVar = tVar2;
                                if (cursor != null) {
                                }
                                return tVar;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
            return tVar;
        }
        return (t) invokeI.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList<t> arrayList = new ArrayList();
            for (t tVar : b()) {
                if (!n3.a(tVar.e)) {
                    arrayList.add(tVar);
                }
            }
            try {
                s b = s.b();
                for (t tVar2 : arrayList) {
                    if (b != null) {
                        b.d(tVar2.e);
                    }
                    SQLiteDatabase sQLiteDatabase = this.d;
                    sQLiteDatabase.delete(i1.q, "k=" + tVar2.a, null);
                    if (s.h != null && !s.h.contains(Integer.valueOf(tVar2.a))) {
                        n3.b(this.e.getFilesDir().getCanonicalPath() + i1.j + tVar2.a);
                    }
                    if (b.a() != null && b.a().get(tVar2.c) != null) {
                        n3.b(this.e.getFileStreamPath(tVar2.c).getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.d.delete(i1.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r11.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r11.isClosed() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            int i3 = 0;
            try {
                SQLiteDatabase sQLiteDatabase = this.d;
                cursor = sQLiteDatabase.query(i1.q, new String[]{"n"}, "k=" + i2, null, null, null, null);
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00fd, code lost:
        if (r12.isClosed() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0107, code lost:
        if (r12.isClosed() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x010a, code lost:
        r12.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public t b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            t tVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                boolean z2 = true;
                cursor = this.d.query(i1.q, null, "p=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            t tVar2 = new t();
                            try {
                                tVar2.a = cursor.getInt(cursor.getColumnIndex("k"));
                                tVar2.b = cursor.getInt(cursor.getColumnIndex("n"));
                                tVar2.c = cursor.getString(cursor.getColumnIndex("p"));
                                tVar2.e = cursor.getString(cursor.getColumnIndex("a"));
                                tVar2.h = cursor.getString(cursor.getColumnIndex("l"));
                                tVar2.d = cursor.getString(cursor.getColumnIndex("v"));
                                tVar2.n = cursor.getString(cursor.getColumnIndex(v));
                                tVar2.p = cursor.getInt(cursor.getColumnIndex("aps"));
                                tVar2.o = cursor.getString(cursor.getColumnIndex(w));
                                tVar2.q = cursor.getInt(cursor.getColumnIndex("at"));
                                tVar2.s = cursor.getLong(cursor.getColumnIndex(x));
                                tVar2.t = cursor.getInt(cursor.getColumnIndex("d"));
                                tVar2.w = cursor.getInt(cursor.getColumnIndex(B));
                                tVar2.j = cursor.getString(cursor.getColumnIndex(A));
                                tVar2.x = cursor.getInt(cursor.getColumnIndex("pc"));
                                if (cursor.getInt(cursor.getColumnIndex(D)) != 1) {
                                    z2 = false;
                                }
                                tVar2.y = z2;
                                tVar = tVar2;
                            } catch (Throwable unused) {
                                tVar = tVar2;
                                if (cursor != null) {
                                }
                                return tVar;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused3) {
                cursor = null;
            }
            return tVar;
        }
        return (t) invokeL.objValue;
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
    public List<t> b() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                cursor = this.d.query(i1.q, null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            t tVar = new t();
                            tVar.a = cursor.getInt(cursor.getColumnIndex("k"));
                            tVar.c = cursor.getString(cursor.getColumnIndex("p"));
                            tVar.e = cursor.getString(cursor.getColumnIndex("a"));
                            tVar.h = cursor.getString(cursor.getColumnIndex("l"));
                            tVar.d = cursor.getString(cursor.getColumnIndex("v"));
                            tVar.s = cursor.getLong(cursor.getColumnIndex(x));
                            tVar.t = cursor.getInt(cursor.getColumnIndex("d"));
                            tVar.w = cursor.getInt(cursor.getColumnIndex(B));
                            tVar.x = cursor.getInt(cursor.getColumnIndex("pc"));
                            boolean z2 = true;
                            if (cursor.getInt(cursor.getColumnIndex(D)) != 1) {
                                z2 = false;
                            }
                            tVar.y = z2;
                            arrayList.add(tVar);
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

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.d;
                sQLiteDatabase.update(i1.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) 0);
            try {
                this.d.update(i1.q, contentValues, "n=-1", null);
            } catch (Throwable unused) {
            }
        }
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pc", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.d;
                sQLiteDatabase.update(i1.q, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r11.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r11.isClosed() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        r11.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            boolean z2 = false;
            try {
                SQLiteDatabase sQLiteDatabase = this.d;
                cursor = sQLiteDatabase.query(i1.q, new String[]{"s"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                                z2 = true;
                            }
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return z2;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", (Integer) 0);
            try {
                this.d.update(i1.q, contentValues, "u=1", null);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r10.isClosed() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        r10.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            boolean z2 = false;
            try {
                cursor = this.d.query(i1.q, new String[]{"p"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            z2 = true;
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return z2;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return z2;
        }
        return invokeI.booleanValue;
    }
}
