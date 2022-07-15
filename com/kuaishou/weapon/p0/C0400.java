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
/* renamed from: com.kuaishou.weapon.p0.ˈ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0400 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static final String f403 = "pc";

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static C0400 f404 = null;

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static final String f405 = "cbl";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f406 = "k";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f407 = "p";

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final String f408 = "v";

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f409 = "l";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f410 = "i";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String f411 = "a";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f412 = "s";

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final String f413 = "n";

    /* renamed from: י  reason: contains not printable characters */
    public static final String f414 = "u";

    /* renamed from: ـ  reason: contains not printable characters */
    public static final String f415 = "c";

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final String f416 = "r";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final String f417 = "b";

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static final String f418 = "dm";

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final String f419 = "m";

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static final String f420 = "rm";

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static final String f421 = "el";

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static final String f422 = "ail";

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static final String f423 = "aps";

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static final String f424 = "dp";

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final String f425 = "pcn";

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final String f426 = "pst";

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final String f427 = "d";

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static final String f428 = "at";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public int f429;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f430;

    /* renamed from: ʽ  reason: contains not printable characters */
    public C0401 f431;

    /* renamed from: ʾ  reason: contains not printable characters */
    public SQLiteDatabase f432;

    /* renamed from: ʿ  reason: contains not printable characters */
    public Context f433;

    /* renamed from: com.kuaishou.weapon.p0.ˈ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class C0401 extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ C0400 f434;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0401(C0400 c0400, Context context) {
            super(context, C0453.f714, (SQLiteDatabase.CursorFactory) null, c0400.f429);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0400, context};
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
            this.f434 = c0400;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                try {
                    sQLiteDatabase.execSQL(this.f434.f430);
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

    public C0400(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f429 = 1;
        this.f430 = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";
        this.f433 = context.getApplicationContext();
        this.f431 = new C0401(this, context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.f432 = this.f431.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized C0400 m529(Context context) {
        InterceptResult invokeL;
        C0400 c0400;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (C0400.class) {
                if (f404 == null) {
                    f404 = new C0400(context);
                }
                c0400 = f404;
            }
            return c0400;
        }
        return (C0400) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public int m531(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("u", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.f432;
                return sQLiteDatabase.update(C0453.f715, contentValues, "k=" + i, null);
            } catch (Throwable unused) {
                return 0;
            }
        }
        return invokeII.intValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public long m532(C0398 c0398) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0398)) == null) {
            long j = 0;
            if (c0398 == null) {
                return 0L;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(c0398.f378));
            contentValues.put("aps", Integer.valueOf(c0398.f392));
            contentValues.put("p", c0398.f379);
            contentValues.put("a", c0398.f381);
            contentValues.put("l", c0398.f384);
            contentValues.put("v", c0398.f380);
            contentValues.put(f424, c0398.f390);
            contentValues.put("a", c0398.f381);
            contentValues.put(f425, c0398.f391);
            contentValues.put(f426, Long.valueOf(c0398.f395));
            contentValues.put(f420, Integer.valueOf(c0398.f399));
            contentValues.put("at", Integer.valueOf(c0398.f393));
            contentValues.put("pc", Integer.valueOf(c0398.f400));
            contentValues.put(f405, Integer.valueOf(c0398.f401 ? 1 : 0));
            if (!TextUtils.isEmpty(c0398.f386)) {
                contentValues.put(f418, c0398.f386);
            }
            try {
                if (m544(c0398.f377)) {
                    j = this.f432.update(C0453.f715, contentValues, "k=" + c0398.f377, null);
                } else {
                    contentValues.put("k", Integer.valueOf(c0398.f377));
                    j = this.f432.insert(C0453.f715, null, contentValues);
                }
            } catch (Throwable unused) {
            }
            return j;
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
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0398 m533(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            C0398 c0398 = null;
            try {
                cursor = this.f432.query(C0453.f715, null, "k=" + i, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            C0398 c03982 = new C0398();
                            try {
                                c03982.f377 = i;
                                c03982.f378 = cursor.getInt(cursor.getColumnIndex("n"));
                                c03982.f379 = cursor.getString(cursor.getColumnIndex("p"));
                                c03982.f381 = cursor.getString(cursor.getColumnIndex("a"));
                                c03982.f384 = cursor.getString(cursor.getColumnIndex("l"));
                                c03982.f380 = cursor.getString(cursor.getColumnIndex("v"));
                                c03982.f390 = cursor.getString(cursor.getColumnIndex(f424));
                                c03982.f392 = cursor.getInt(cursor.getColumnIndex("aps"));
                                c03982.f391 = cursor.getString(cursor.getColumnIndex(f425));
                                c03982.f393 = cursor.getInt(cursor.getColumnIndex("at"));
                                c03982.f395 = cursor.getLong(cursor.getColumnIndex(f426));
                                c03982.f396 = cursor.getInt(cursor.getColumnIndex("d"));
                                c03982.f399 = cursor.getInt(cursor.getColumnIndex(f420));
                                c03982.f386 = cursor.getString(cursor.getColumnIndex(f418));
                                c03982.f400 = cursor.getInt(cursor.getColumnIndex("pc"));
                                boolean z = true;
                                if (cursor.getInt(cursor.getColumnIndex(f405)) != 1) {
                                    z = false;
                                }
                                c03982.f401 = z;
                                c0398 = c03982;
                            } catch (Throwable unused) {
                                c0398 = c03982;
                                if (cursor != null) {
                                }
                                return c0398;
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
            return c0398;
        }
        return (C0398) invokeI.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m534() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ArrayList<C0398> arrayList = new ArrayList();
            for (C0398 c0398 : m538()) {
                if (!C0383.m462(c0398.f381)) {
                    arrayList.add(c0398);
                }
            }
            try {
                C0396 m512 = C0396.m512();
                for (C0398 c03982 : arrayList) {
                    if (m512 != null) {
                        m512.m519(c03982.f381);
                    }
                    SQLiteDatabase sQLiteDatabase = this.f432;
                    sQLiteDatabase.delete(C0453.f715, "k=" + c03982.f377, null);
                    if (C0396.f373 != null && !C0396.f373.contains(Integer.valueOf(c03982.f377))) {
                        C0383.m464(this.f433.getFilesDir().getCanonicalPath() + "/." + c03982.f377);
                    }
                    if (m512.m515() != null && m512.m515().get(c03982.f379) != null) {
                        C0383.m464(this.f433.getFileStreamPath(c03982.f379).getAbsolutePath());
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m535(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f432.delete(C0453.f715, "p=?", new String[]{str});
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
    /* renamed from: ʼ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m536(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int i2 = 0;
            try {
                SQLiteDatabase sQLiteDatabase = this.f432;
                cursor = sQLiteDatabase.query(C0453.f715, new String[]{"n"}, "k=" + i, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            i2 = cursor.getInt(cursor.getColumnIndex("n"));
                        }
                    } catch (Throwable unused) {
                        if (cursor != null) {
                        }
                        return i2;
                    }
                }
                if (cursor != null) {
                }
            } catch (Throwable unused2) {
                cursor = null;
            }
            return i2;
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
    /* renamed from: ʼ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0398 m537(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            C0398 c0398 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                boolean z = true;
                cursor = this.f432.query(C0453.f715, null, "p=?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            C0398 c03982 = new C0398();
                            try {
                                c03982.f377 = cursor.getInt(cursor.getColumnIndex("k"));
                                c03982.f378 = cursor.getInt(cursor.getColumnIndex("n"));
                                c03982.f379 = cursor.getString(cursor.getColumnIndex("p"));
                                c03982.f381 = cursor.getString(cursor.getColumnIndex("a"));
                                c03982.f384 = cursor.getString(cursor.getColumnIndex("l"));
                                c03982.f380 = cursor.getString(cursor.getColumnIndex("v"));
                                c03982.f390 = cursor.getString(cursor.getColumnIndex(f424));
                                c03982.f392 = cursor.getInt(cursor.getColumnIndex("aps"));
                                c03982.f391 = cursor.getString(cursor.getColumnIndex(f425));
                                c03982.f393 = cursor.getInt(cursor.getColumnIndex("at"));
                                c03982.f395 = cursor.getLong(cursor.getColumnIndex(f426));
                                c03982.f396 = cursor.getInt(cursor.getColumnIndex("d"));
                                c03982.f399 = cursor.getInt(cursor.getColumnIndex(f420));
                                c03982.f386 = cursor.getString(cursor.getColumnIndex(f418));
                                c03982.f400 = cursor.getInt(cursor.getColumnIndex("pc"));
                                if (cursor.getInt(cursor.getColumnIndex(f405)) != 1) {
                                    z = false;
                                }
                                c03982.f401 = z;
                                c0398 = c03982;
                            } catch (Throwable unused) {
                                c0398 = c03982;
                                if (cursor != null) {
                                }
                                return c0398;
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
            return c0398;
        }
        return (C0398) invokeL.objValue;
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
    /* renamed from: ʼ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<C0398> m538() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                cursor = this.f432.query(C0453.f715, null, null, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            C0398 c0398 = new C0398();
                            c0398.f377 = cursor.getInt(cursor.getColumnIndex("k"));
                            c0398.f379 = cursor.getString(cursor.getColumnIndex("p"));
                            c0398.f381 = cursor.getString(cursor.getColumnIndex("a"));
                            c0398.f384 = cursor.getString(cursor.getColumnIndex("l"));
                            c0398.f380 = cursor.getString(cursor.getColumnIndex("v"));
                            c0398.f395 = cursor.getLong(cursor.getColumnIndex(f426));
                            c0398.f396 = cursor.getInt(cursor.getColumnIndex("d"));
                            c0398.f399 = cursor.getInt(cursor.getColumnIndex(f420));
                            c0398.f400 = cursor.getInt(cursor.getColumnIndex("pc"));
                            boolean z = true;
                            if (cursor.getInt(cursor.getColumnIndex(f405)) != 1) {
                                z = false;
                            }
                            c0398.f401 = z;
                            arrayList.add(c0398);
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m539(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("n", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.f432;
                sQLiteDatabase.update(C0453.f715, contentValues, "k=" + i, null);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m540() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", (Integer) 0);
            try {
                this.f432.update(C0453.f715, contentValues, "n=-1", null);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m541(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("pc", Integer.valueOf(i2));
                SQLiteDatabase sQLiteDatabase = this.f432;
                sQLiteDatabase.update(C0453.f715, contentValues, "k=" + i, null);
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
    /* renamed from: ʽ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m542(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            boolean z = false;
            try {
                SQLiteDatabase sQLiteDatabase = this.f432;
                cursor = sQLiteDatabase.query(C0453.f715, new String[]{"s"}, "k=" + i, null, null, null, null);
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

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m543() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("u", (Integer) 0);
            try {
                this.f432.update(C0453.f715, contentValues, "u=1", null);
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
    /* renamed from: ʾ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m544(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            boolean z = false;
            try {
                cursor = this.f432.query(C0453.f715, new String[]{"p"}, "k=" + i, null, null, null, null);
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
}
