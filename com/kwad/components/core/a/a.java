package com.kwad.components.core.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a CS;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase CR;

    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0569a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic = null;
        public static int CU = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String CV;
        public String CW;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-248092376, "Lcom/kwad/components/core/a/a$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-248092376, "Lcom/kwad/components/core/a/a$a;");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0569a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, CU);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.CV = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.CW = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL(this.CV);
                sQLiteDatabase.execSQL(this.CW);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i, i2) == null) {
            }
        }
    }

    public a(Context context) {
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
        this.CR = new C0569a(context).getWritableDatabase();
    }

    private <T extends h> void b(List<T> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, list, str) == null) {
            try {
                try {
                    this.CR.beginTransaction();
                    for (T t : list) {
                        try {
                            long insertWithOnConflict = this.CR.insertWithOnConflict(str, null, t.ma(), 5);
                            com.kwad.sdk.core.e.b.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                        } catch (Exception e) {
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                        }
                    }
                    this.CR.setTransactionSuccessful();
                    SQLiteDatabase sQLiteDatabase = this.CR;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Exception e2) {
                            com.kwad.sdk.core.e.b.printStackTrace(e2);
                        }
                    }
                } catch (Exception e3) {
                    com.kwad.sdk.core.e.b.printStackTrace(e3);
                    SQLiteDatabase sQLiteDatabase2 = this.CR;
                    if (sQLiteDatabase2 != null) {
                        try {
                            sQLiteDatabase2.endTransaction();
                        } catch (Exception e4) {
                            com.kwad.sdk.core.e.b.printStackTrace(e4);
                        }
                    }
                }
            } catch (Throwable th) {
                SQLiteDatabase sQLiteDatabase3 = this.CR;
                if (sQLiteDatabase3 != null) {
                    try {
                        sQLiteDatabase3.endTransaction();
                    } catch (Exception e5) {
                        com.kwad.sdk.core.e.b.printStackTrace(e5);
                    }
                }
                throw th;
            }
        }
    }

    @Nullable
    public static a lP() {
        InterceptResult invokeV;
        KsAdSDKImpl ksAdSDKImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (CS == null) {
                synchronized (a.class) {
                    if (CS == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                        try {
                            CS = new a(ksAdSDKImpl.getContext());
                        } catch (SQLiteException e) {
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                            CS = null;
                        }
                    }
                }
            }
            return CS;
        }
        return (a) invokeV.objValue;
    }

    @Nullable
    @WorkerThread
    public final List<g> a(String str, long j, int i) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i)})) != null) {
            return (List) invokeCommon.objValue;
        }
        Closeable closeable = null;
        try {
            try {
                cursor = this.CR.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<g> a = g.a(cursor);
                    if (a == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (g gVar : a) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(gVar.mi());
                            sb.append(i2 == a.size() ? SmallTailInfo.EMOTION_SUFFIX : " OR");
                        } else if (gVar.mg() >= j) {
                            arrayList.add(gVar);
                        }
                    }
                    if (i2 > i) {
                        this.CR.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable = 1048576;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
            throw th;
        }
    }

    public final void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
        }
    }

    @WorkerThread
    public final e af(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                cursor = this.CR.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
                try {
                    try {
                        List<e> a = e.a(cursor);
                        if (a != null && a.size() > 0) {
                            e eVar = a.get(0);
                            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                            return eVar;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        }
        return (e) invokeL.objValue;
    }

    @WorkerThread
    public final void h(List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            b(list, "ksad_ad_cache");
        }
    }

    @WorkerThread
    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            try {
                int delete = this.CR.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
                com.kwad.sdk.core.e.b.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }

    @WorkerThread
    public final void lQ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.CR.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }
}
