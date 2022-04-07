package com.kuaishou.weapon.un;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class x {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "at";
    public static final String B = "dm";
    public static final String C = "rm";
    public static final String D = "pc";
    public static final String E = "cbl";
    public static final String F = "ctc";
    public static final String G = "_id";
    public static x H = null;
    public static final String g = "k";
    public static final String h = "p";
    public static final String i = "v";
    public static final String j = "l";
    public static final String k = "i";
    public static final String l = "a";
    public static final String m = "s";
    public static final String n = "n";
    public static final String o = "u";
    public static final String p = "c";
    public static final String q = "r";
    public static final String r = "b";
    public static final String s = "m";
    public static final String t = "el";
    public static final String u = "ail";
    public static final String v = "aps";
    public static final String w = "dp";
    public static final String x = "pcn";
    public static final String y = "pst";
    public static final String z = "d";
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public a d;
    public SQLiteDatabase e;
    public Context f;

    /* loaded from: classes5.dex */
    public class a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x xVar, Context context) {
            super(context, r1.l, (SQLiteDatabase.CursorFactory) null, xVar.a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, context};
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
            this.a = xVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.a.b);
                } catch (Throwable th) {
                    l1.a(th);
                }
                try {
                    sQLiteDatabase.execSQL(this.a.c);
                } catch (Throwable th2) {
                    l1.a(th2);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
                if (i < 2 && i2 >= 2) {
                    try {
                        sQLiteDatabase.execSQL(this.a.c);
                    }
                }
                if (i >= 3 || i2 < 3) {
                    return;
                }
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public x(Context context) {
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
        this.c = "create table wc(_id INTEGER primary key autoincrement,k INTEGER,v TEXT,ctc INTEGER)";
        this.f = context.getApplicationContext();
        this.d = new a(this, context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.e = this.d.getWritableDatabase();
            }
        } catch (Throwable th) {
            l1.a(th);
        }
    }

    public static synchronized x a(Context context) {
        InterceptResult invokeL;
        x xVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (x.class) {
                if (H == null) {
                    H = new x(context);
                }
                xVar = H;
            }
            return xVar;
        }
        return (x) invokeL.objValue;
    }

    public static x i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? H : (x) invokeV.objValue;
    }

    public long a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pVar)) == null) {
            long j2 = 0;
            if (pVar == null) {
                return 0L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(pVar.b));
            contentValues.put("aps", Integer.valueOf(pVar.p));
            contentValues.put("p", pVar.c);
            contentValues.put("a", pVar.e);
            contentValues.put("l", pVar.h);
            contentValues.put("v", pVar.d);
            contentValues.put(w, pVar.n);
            contentValues.put("a", pVar.e);
            contentValues.put(x, pVar.o);
            contentValues.put(y, Long.valueOf(pVar.t));
            contentValues.put(C, Integer.valueOf(pVar.x));
            contentValues.put("at", Integer.valueOf(pVar.q));
            contentValues.put("pc", Integer.valueOf(pVar.y));
            contentValues.put(E, Integer.valueOf(pVar.z ? 1 : 0));
            ActivityInfo[] activityInfoArr = pVar.l;
            if (activityInfoArr != null) {
                contentValues.put(u, new l(activityInfoArr).a());
            }
            if (!TextUtils.isEmpty(pVar.j)) {
                contentValues.put(B, pVar.j);
            }
            try {
                if (f(pVar.a)) {
                    j2 = this.e.update(r1.m, contentValues, "k=" + pVar.a, null);
                } else {
                    contentValues.put("k", Integer.valueOf(pVar.a));
                    j2 = this.e.insert(r1.m, null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ArrayList<p> arrayList = new ArrayList();
            for (p pVar : b()) {
                if (!l1.a(pVar.e)) {
                    arrayList.add(pVar);
                }
            }
            try {
                o c = o.c();
                for (p pVar2 : arrayList) {
                    if (c != null) {
                        c.f(pVar2.e);
                    }
                    SQLiteDatabase sQLiteDatabase = this.e;
                    sQLiteDatabase.delete(r1.m, "k=" + pVar2.a, null);
                    if (o.o != null && !o.o.contains(Integer.valueOf(pVar2.a))) {
                        l1.b(this.f.getFilesDir().getCanonicalPath() + "/." + pVar2.a);
                    }
                    if (c.b() != null && c.b().get(pVar2.c) != null) {
                        l1.b(this.f.getFileStreamPath(pVar2.c).getAbsolutePath());
                    }
                }
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 <= 0) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.e;
            sQLiteDatabase.delete(r1.m, "k=" + i2, null);
        } catch (Throwable th) {
            l1.a(th);
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i3));
            try {
                SQLiteDatabase sQLiteDatabase = this.e;
                sQLiteDatabase.update(r1.m, contentValues, "k=" + i2 + " and n=1", null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a(PackageInfo packageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, packageInfo) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("aps", (Integer) 1);
            contentValues.put(x, packageInfo.applicationInfo.className);
            ActivityInfo[] activityInfoArr = packageInfo.activities;
            if (activityInfoArr != null) {
                contentValues.put(u, new l(activityInfoArr).a());
            }
            this.e.update(r1.m, contentValues, "p=?", new String[]{packageInfo.packageName});
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.e.delete(r1.m, "p=?", new String[]{str});
        } catch (Throwable th) {
            l1.a(th);
        }
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("s", Integer.valueOf(i2));
            try {
                this.e.update(r1.m, contentValues, "p=? and n=1", new String[]{str});
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, str3) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("r", (Integer) 1);
            contentValues.put("b", str2);
            contentValues.put("m", str3);
            try {
                this.e.update(r1.m, contentValues, "p=?", new String[]{str});
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public int b(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.e;
                return sQLiteDatabase.update(r1.m, contentValues, "k=" + i2, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x01a6, code lost:
        if (r1.isClosed() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        ArrayList<m> a2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            p pVar = null;
            try {
                cursor = this.e.query(r1.m, null, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            p pVar2 = new p();
                            try {
                                pVar2.a = i2;
                                pVar2.b = cursor.getInt(cursor.getColumnIndex("n"));
                                pVar2.c = cursor.getString(cursor.getColumnIndex("p"));
                                pVar2.e = cursor.getString(cursor.getColumnIndex("a"));
                                pVar2.h = cursor.getString(cursor.getColumnIndex("l"));
                                pVar2.d = cursor.getString(cursor.getColumnIndex("v"));
                                pVar2.n = cursor.getString(cursor.getColumnIndex(w));
                                pVar2.p = cursor.getInt(cursor.getColumnIndex("aps"));
                                pVar2.o = cursor.getString(cursor.getColumnIndex(x));
                                pVar2.q = cursor.getInt(cursor.getColumnIndex("at"));
                                pVar2.t = cursor.getLong(cursor.getColumnIndex(y));
                                pVar2.u = cursor.getInt(cursor.getColumnIndex("d"));
                                pVar2.x = cursor.getInt(cursor.getColumnIndex(C));
                                pVar2.j = cursor.getString(cursor.getColumnIndex(B));
                                pVar2.y = cursor.getInt(cursor.getColumnIndex("pc"));
                                boolean z2 = true;
                                if (cursor.getInt(cursor.getColumnIndex(E)) != 1) {
                                    z2 = false;
                                }
                                pVar2.z = z2;
                                byte[] blob = cursor.getBlob(cursor.getColumnIndex(u));
                                if (blob != null && (a2 = l.a(blob)) != null && (size = a2.size()) > 0) {
                                    pVar2.l = new ActivityInfo[size];
                                    for (int i3 = 0; i3 < size; i3++) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        activityInfo.theme = a2.get(i3).a;
                                        activityInfo.name = a2.get(i3).k;
                                        activityInfo.configChanges = a2.get(i3).h;
                                        activityInfo.flags = a2.get(i3).f;
                                        activityInfo.labelRes = a2.get(i3).m;
                                        activityInfo.launchMode = a2.get(i3).b;
                                        activityInfo.nonLocalizedLabel = a2.get(i3).n;
                                        activityInfo.packageName = a2.get(i3).l;
                                        activityInfo.permission = a2.get(i3).c;
                                        activityInfo.screenOrientation = a2.get(i3).g;
                                        activityInfo.softInputMode = a2.get(i3).i;
                                        activityInfo.targetActivity = a2.get(i3).e;
                                        activityInfo.taskAffinity = a2.get(i3).d;
                                        pVar2.l[i3] = activityInfo;
                                    }
                                }
                                pVar = pVar2;
                            } catch (Throwable th) {
                                th = th;
                                pVar = pVar2;
                                try {
                                    l1.a(th);
                                    return pVar;
                                } finally {
                                    if (cursor != null && !cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            return pVar;
        }
        return (p) invokeI.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01ab, code lost:
        if (r12.isClosed() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p b(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        ArrayList<m> a2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            p pVar = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                boolean z2 = true;
                cursor = this.e.query(r1.m, null, "p=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            p pVar2 = new p();
                            try {
                                pVar2.a = cursor.getInt(cursor.getColumnIndex("k"));
                                pVar2.b = cursor.getInt(cursor.getColumnIndex("n"));
                                pVar2.c = cursor.getString(cursor.getColumnIndex("p"));
                                pVar2.e = cursor.getString(cursor.getColumnIndex("a"));
                                pVar2.h = cursor.getString(cursor.getColumnIndex("l"));
                                pVar2.d = cursor.getString(cursor.getColumnIndex("v"));
                                pVar2.n = cursor.getString(cursor.getColumnIndex(w));
                                pVar2.p = cursor.getInt(cursor.getColumnIndex("aps"));
                                pVar2.o = cursor.getString(cursor.getColumnIndex(x));
                                pVar2.q = cursor.getInt(cursor.getColumnIndex("at"));
                                pVar2.t = cursor.getLong(cursor.getColumnIndex(y));
                                pVar2.u = cursor.getInt(cursor.getColumnIndex("d"));
                                pVar2.x = cursor.getInt(cursor.getColumnIndex(C));
                                pVar2.j = cursor.getString(cursor.getColumnIndex(B));
                                pVar2.y = cursor.getInt(cursor.getColumnIndex("pc"));
                                if (cursor.getInt(cursor.getColumnIndex(E)) != 1) {
                                    z2 = false;
                                }
                                pVar2.z = z2;
                                byte[] blob = cursor.getBlob(cursor.getColumnIndex(u));
                                if (blob != null && (a2 = l.a(blob)) != null && (size = a2.size()) > 0) {
                                    pVar2.l = new ActivityInfo[size];
                                    for (int i2 = 0; i2 < size; i2++) {
                                        ActivityInfo activityInfo = new ActivityInfo();
                                        activityInfo.theme = a2.get(i2).a;
                                        activityInfo.name = a2.get(i2).k;
                                        activityInfo.configChanges = a2.get(i2).h;
                                        activityInfo.flags = a2.get(i2).f;
                                        activityInfo.labelRes = a2.get(i2).m;
                                        activityInfo.launchMode = a2.get(i2).b;
                                        activityInfo.nonLocalizedLabel = a2.get(i2).n;
                                        activityInfo.packageName = a2.get(i2).l;
                                        activityInfo.permission = a2.get(i2).c;
                                        activityInfo.screenOrientation = a2.get(i2).g;
                                        activityInfo.softInputMode = a2.get(i2).i;
                                        activityInfo.targetActivity = a2.get(i2).e;
                                        activityInfo.taskAffinity = a2.get(i2).d;
                                        pVar2.l[i2] = activityInfo;
                                    }
                                }
                                pVar = pVar2;
                            } catch (Throwable th2) {
                                th = th2;
                                pVar = pVar2;
                                try {
                                    l1.a(th);
                                    return pVar;
                                } finally {
                                    if (cursor != null && !cursor.isClosed()) {
                                        cursor.close();
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
            return pVar;
        }
        return (p) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
        if (r1.isClosed() == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<p> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = this.e.query(r1.m, null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        p pVar = new p();
                        pVar.a = cursor.getInt(cursor.getColumnIndex("k"));
                        pVar.c = cursor.getString(cursor.getColumnIndex("p"));
                        pVar.e = cursor.getString(cursor.getColumnIndex("a"));
                        pVar.h = cursor.getString(cursor.getColumnIndex("l"));
                        pVar.d = cursor.getString(cursor.getColumnIndex("v"));
                        pVar.t = cursor.getLong(cursor.getColumnIndex(y));
                        pVar.u = cursor.getInt(cursor.getColumnIndex("d"));
                        pVar.x = cursor.getInt(cursor.getColumnIndex(C));
                        pVar.y = cursor.getInt(cursor.getColumnIndex("pc"));
                        boolean z2 = true;
                        if (cursor.getInt(cursor.getColumnIndex(E)) != 1) {
                            z2 = false;
                        }
                        pVar.z = z2;
                        arrayList.add(pVar);
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r2.isClosed() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int i3 = 0;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.e;
                cursor = sQLiteDatabase.query(r1.m, new String[]{"n"}, "k=" + i2, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    i3 = cursor.getInt(cursor.getColumnIndex("n"));
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
        if (r1.isClosed() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<Integer, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                cursor = this.e.query(r1.m, null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        hashMap.put(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("k"))), cursor.getString(cursor.getColumnIndex("p")));
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.e;
                sQLiteDatabase.update(r1.m, contentValues, "k=" + i2, null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public String[] c(String str) {
        InterceptResult invokeL;
        Throwable th;
        String[] strArr;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            Cursor cursor2 = null;
            r3 = null;
            r3 = null;
            r3 = null;
            r3 = null;
            r3 = null;
            String[] strArr2 = null;
            try {
                cursor = this.e.query(r1.m, new String[]{"r", "b", "m"}, "p=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            boolean z2 = cursor.getInt(cursor.getColumnIndex("r")) == 1;
                            String string = cursor.getString(cursor.getColumnIndex("b"));
                            String string2 = cursor.getString(cursor.getColumnIndex("m"));
                            if (z2 && !TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                strArr2 = new String[]{string, string2};
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        strArr = strArr2;
                        cursor2 = cursor;
                        try {
                            l1.a(th);
                            if (cursor2 == null || cursor2.isClosed()) {
                                return strArr;
                            }
                            cursor = cursor2;
                            strArr2 = strArr;
                            cursor.close();
                            return strArr2;
                        } catch (Throwable th3) {
                            if (cursor2 != null && !cursor2.isClosed()) {
                                cursor2.close();
                            }
                            throw th3;
                        }
                    }
                }
                if (cursor == null || cursor.isClosed()) {
                    return strArr2;
                }
            } catch (Throwable th4) {
                th = th4;
                strArr = null;
            }
            cursor.close();
            return strArr2;
        }
        return (String[]) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0057, code lost:
        if (r2.isClosed() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<Integer, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            HashMap hashMap = new HashMap();
            Cursor cursor = null;
            try {
                cursor = this.e.query(r1.m, null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(cursor.getColumnIndex("k"));
                        String string = cursor.getString(cursor.getColumnIndex("v"));
                        Integer valueOf = Integer.valueOf(i2);
                        hashMap.put(valueOf, "'" + string + "'");
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    public void d(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(C, Integer.valueOf(i3));
            try {
                SQLiteDatabase sQLiteDatabase = this.e;
                sQLiteDatabase.update(r1.m, contentValues, "k=" + i2, null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        if (r2.isClosed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            boolean z2 = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.e;
                cursor = sQLiteDatabase.query(r1.m, new String[]{"u"}, "k=" + i2, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    if (cursor.getInt(cursor.getColumnIndex("u")) == 1) {
                        z2 = true;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x006c, code lost:
        if (r1.isClosed() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<p> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = this.e.query(r1.m, null, "n=1", null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        p pVar = new p();
                        pVar.a = cursor.getInt(cursor.getColumnIndex("k"));
                        pVar.c = cursor.getString(cursor.getColumnIndex("p"));
                        pVar.e = cursor.getString(cursor.getColumnIndex("a"));
                        pVar.h = cursor.getString(cursor.getColumnIndex("l"));
                        pVar.d = cursor.getString(cursor.getColumnIndex("v"));
                        arrayList.add(pVar);
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void e(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pc", Integer.valueOf(i3));
                SQLiteDatabase sQLiteDatabase = this.e;
                sQLiteDatabase.update(r1.m, contentValues, "k=" + i2, null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
        if (r2.isClosed() == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            boolean z2 = false;
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = this.e;
                cursor = sQLiteDatabase.query(r1.m, new String[]{"s"}, "k=" + i2, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    if (cursor.getInt(cursor.getColumnIndex("s")) == 1) {
                        z2 = true;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.e : (SQLiteDatabase) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
        if (r9.isClosed() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            boolean z2 = false;
            Cursor cursor = null;
            try {
                cursor = this.e.query(r1.m, new String[]{"p"}, "k=" + i2, null, null, null, null);
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        z2 = true;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable th) {
                try {
                    l1.a(th);
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) 0);
            try {
                this.e.update(r1.m, contentValues, "n=-1", null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", (Integer) 0);
            try {
                this.e.update(r1.m, contentValues, "u=1", null);
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }
}
