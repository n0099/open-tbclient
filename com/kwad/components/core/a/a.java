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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a b;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;

    /* renamed from: com.kwad.components.core.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0499a extends SQLiteOpenHelper {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;

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
        public C0499a(@Nullable Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, a);
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
            this.b = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.c = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
                sQLiteDatabase.execSQL(this.b);
                sQLiteDatabase.execSQL(this.c);
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
        this.a = new C0499a(context).getWritableDatabase();
    }

    @Nullable
    public static a a() {
        InterceptResult invokeV;
        KsAdSDKImpl ksAdSDKImpl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null && (ksAdSDKImpl = KsAdSDKImpl.get()) != null) {
                        try {
                            b = new a(ksAdSDKImpl.getContext());
                        } catch (SQLiteException e) {
                            com.kwad.sdk.core.d.b.b(e);
                            b = null;
                        }
                    }
                }
            }
            return b;
        }
        return (a) invokeV.objValue;
    }

    private <T extends g> void a(List<T> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, list, str) == null) {
            try {
                this.a.beginTransaction();
                for (T t : list) {
                    try {
                        long insertWithOnConflict = this.a.insertWithOnConflict(str, null, t.f(), 5);
                        com.kwad.sdk.core.d.b.a("AdCacheDBManager", "insertData: " + str + ", rowId: " + insertWithOnConflict);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.a(e);
                    }
                }
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.a(e2);
            }
        }
    }

    public final e a(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                cursor = this.a.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
                try {
                    try {
                        List<e> a = e.a(cursor);
                        if (a != null && a.size() > 0) {
                            e eVar = a.get(0);
                            com.kwad.sdk.crash.utils.b.a(cursor);
                            return eVar;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.b.b(e);
                        com.kwad.sdk.crash.utils.b.a(cursor);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                com.kwad.sdk.crash.utils.b.a(cursor);
                throw th;
            }
            com.kwad.sdk.crash.utils.b.a(cursor);
            return null;
        }
        return (e) invokeL.objValue;
    }

    @WorkerThread
    public final List<f> a(String str, long j, int i) {
        InterceptResult invokeCommon;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j), Integer.valueOf(i)})) != null) {
            return (List) invokeCommon.objValue;
        }
        Closeable closeable = null;
        try {
            try {
                cursor = this.a.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
                try {
                    List<f> a = f.a(cursor);
                    if (a == null) {
                        com.kwad.sdk.crash.utils.b.a(cursor);
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (f fVar : a) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(fVar.b());
                            sb.append(i2 == a.size() ? SmallTailInfo.EMOTION_SUFFIX : " OR");
                        } else if (fVar.a() >= j) {
                            arrayList.add(fVar);
                        }
                    }
                    if (i2 > i) {
                        this.a.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    return arrayList;
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.b.b(e);
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable = 1048577;
                com.kwad.sdk.crash.utils.b.a(closeable);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.a(closeable);
            throw th;
        }
    }

    @WorkerThread
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            try {
                int delete = this.a.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)});
                com.kwad.sdk.core.d.b.a("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + delete);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }

    public final void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            a(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
        }
    }

    @WorkerThread
    public final void a(List<f> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            a(list, "ksad_ad_cache");
        }
    }

    @WorkerThread
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                this.a.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }
}
