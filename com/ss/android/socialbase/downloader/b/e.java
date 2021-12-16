package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.b.c;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.f.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class e extends c.a implements t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f62185b;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: c  reason: collision with root package name */
    public g f62186c;

    /* renamed from: d  reason: collision with root package name */
    public g f62187d;

    /* renamed from: e  reason: collision with root package name */
    public g f62188e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f62189f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(479221857, "Lcom/ss/android/socialbase/downloader/b/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(479221857, "Lcom/ss/android/socialbase/downloader/b/e;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65567, this) == null) && f62185b == null) {
            synchronized (e.class) {
                if (f62185b == null) {
                    f62185b = a.a().getWritableDatabase();
                    this.f62186c = new g(f62185b, "downloader", com.ss.android.socialbase.downloader.constants.c.a, com.ss.android.socialbase.downloader.constants.c.f62241b);
                    this.f62187d = new g(f62185b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.f62242c, com.ss.android.socialbase.downloader.constants.c.f62243d);
                    this.f62188e = new g(f62185b, "segments", com.ss.android.socialbase.downloader.constants.c.f62244e, com.ss.android.socialbase.downloader.constants.c.f62245f);
                }
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            f62185b.beginTransaction();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            try {
                if (f62185b == null || !f62185b.inTransaction()) {
                    return;
                }
                f62185b.endTransaction();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            synchronized (this) {
                i();
                f62185b.delete("downloader", null, null);
                f62185b.delete("downloadChunk", null, null);
                f62185b.setTransactionSuccessful();
                j();
            }
        }
    }

    private void update(int i2, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, this, i2, contentValues) == null) {
            h();
            if (f62185b == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, contentValues) { // from class: com.ss.android.socialbase.downloader.b.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ContentValues f62195b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f62196c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), contentValues};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62196c = this;
                    this.a = i2;
                    this.f62195b = contentValues;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62196c.a(this.a, this.f62195b);
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, list) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadInfo) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean e(int i2) {
        InterceptResult invokeI;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            h();
            if (f62185b != null && (gVar = this.f62186c) != null) {
                try {
                    a(i2, gVar.b());
                    return true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.b.e.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f62194b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62194b = this;
                    this.a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62194b.e(this.a);
                        this.f62194b.d(this.a);
                        this.f62194b.m(this.a);
                    }
                }
            });
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, i> l(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            h();
            if (f62185b != null) {
                try {
                    cursor = f62185b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
                    try {
                        if (cursor.moveToNext()) {
                            int columnIndex = cursor.getColumnIndex("info");
                            String string = columnIndex >= 0 ? cursor.getString(columnIndex) : null;
                            HashMap hashMap = new HashMap();
                            JSONArray jSONArray = new JSONArray(string);
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                i iVar = new i(jSONArray.getJSONObject(i3));
                                hashMap.put(Long.valueOf(iVar.c()), iVar);
                            }
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            return hashMap;
                        }
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            return null;
                        } catch (Throwable th2) {
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            return null;
        }
        return (Map) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            h();
            if (f62185b == null) {
                return;
            }
            try {
                a(i2, this.f62188e.b());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        if (z) {
            this.f62189f = false;
            a();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            h();
            if (f62185b != null) {
                try {
                    cursor = f62185b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
                    try {
                        if (cursor.moveToNext()) {
                            DownloadInfo downloadInfo = new DownloadInfo(cursor);
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            return downloadInfo;
                        }
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            return null;
                        } catch (Throwable th2) {
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = null;
                }
            }
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            h();
            if (f62185b != null) {
                Cursor cursor = null;
                try {
                    cursor = f62185b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
                    while (cursor.moveToNext()) {
                        arrayList.add(new com.ss.android.socialbase.downloader.model.b(cursor));
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        throw th2;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            h();
            if (f62185b == null || this.f62187d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.b.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f62197b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62197b = this;
                    this.a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62197b.a(this.a, this.f62197b.f62187d.b());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-7));
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, downloadInfo) == null) {
            synchronized (this) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    if (!a(downloadInfo.getId())) {
                        c(downloadInfo);
                    } else if (this.f62186c == null) {
                    } else {
                        b(downloadInfo, this.f62186c.c());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-4));
            contentValues.put("curBytes", Long.valueOf(j2));
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /* renamed from: k */
    public ArrayList<i> n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            Map<Long, i> l = l(i2);
            if (l == null || l.isEmpty()) {
                return null;
            }
            return new ArrayList<>(l.values());
        }
        return (ArrayList) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 5);
            contentValues.put("isFirstDownload", (Integer) 0);
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
            a(bVar);
        }
    }

    private void b(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, this, downloadInfo, sQLiteStatement) == null) || downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.bindLong(downloadInfo.getBindValueCount() + 1, downloadInfo.getId());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a(new SparseArray<>(), new SparseArray<>(), (d) null);
        }
    }

    private void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, this, downloadInfo) == null) {
            h();
            if (f62185b == null || this.f62186c == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.b.e.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f62210b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62210b = this;
                    this.a = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62210b.a(this.a, this.f62210b.f62186c.a());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, sparseArray, sparseArray2, dVar) == null) {
            try {
                Runnable runnable = new Runnable(this, sparseArray, sparseArray2, dVar) { // from class: com.ss.android.socialbase.downloader.b.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SparseArray a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ SparseArray f62190b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f62191c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ e f62192d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, sparseArray, sparseArray2, dVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f62192d = this;
                        this.a = sparseArray;
                        this.f62190b = sparseArray2;
                        this.f62191c = dVar;
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, IGET, IGET, IGET, INVOKE, INVOKE, IGET, INVOKE, IGET, IGET, IGET, INVOKE, IF] complete} */
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
                    /* JADX WARN: Code restructure failed: missing block: B:122:0x0273, code lost:
                        if (r0 == null) goto L90;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:127:0x027d, code lost:
                        if (r0 == null) goto L90;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:129:0x0281, code lost:
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:163:0x0336, code lost:
                        if (r0 == null) goto L183;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:168:0x033f, code lost:
                        if (r0 == null) goto L183;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:169:0x0341, code lost:
                        r0.a();
                        r18.f62192d.f62189f = true;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:170:0x0349, code lost:
                        r18.f62192d.a(r18.a, r18.f62190b);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:171:0x0352, code lost:
                        throw r0;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:80:0x019f, code lost:
                        if (r0 != null) goto L92;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:197:0x00de A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:199:0x00ce A[SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        d dVar2;
                        d dVar3;
                        boolean z;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                            return;
                        }
                        this.f62192d.h();
                        if (e.f62185b == null) {
                            return;
                        }
                        k B = com.ss.android.socialbase.downloader.downloader.c.B();
                        SparseArray sparseArray3 = new SparseArray();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        Cursor cursor = null;
                        int i2 = 0;
                        try {
                            cursor = e.f62185b.rawQuery("SELECT * FROM downloader", null);
                            while (cursor.moveToNext()) {
                                DownloadInfo downloadInfo = new DownloadInfo(cursor);
                                downloadInfo.setStatusAtDbInit(downloadInfo.getRealStatus());
                                if (downloadInfo.isCanResumeFromBreakPointStatus()) {
                                    downloadInfo.setStatus(-5);
                                    if (com.ss.android.socialbase.downloader.g.a.c().b("status_not_update_to_db", true)) {
                                        sparseArray3.put(downloadInfo.getId(), downloadInfo);
                                    }
                                }
                                if (!TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                                    if (downloadInfo.getStatus() != 1 || downloadInfo.getCurBytes() > 0) {
                                        if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != 11 && !downloadInfo.isFileDataValid()) {
                                            downloadInfo.reset();
                                        }
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (downloadInfo.getStatus() == 11) {
                                        downloadInfo.setStatus(-5);
                                    }
                                    if (com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName())) {
                                        if (!com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                                            downloadInfo.erase();
                                        }
                                    }
                                    if (!z) {
                                        arrayList.add(Integer.valueOf(downloadInfo.getId()));
                                        arrayList2.add(downloadInfo);
                                    } else {
                                        int id = downloadInfo.getId();
                                        int a = B != null ? B.a(downloadInfo.getUrl(), downloadInfo.getSavePath()) : 0;
                                        if (a != id) {
                                            downloadInfo.setId(a);
                                            sparseArray3.put(id, downloadInfo);
                                        }
                                        this.a.put(downloadInfo.getId(), downloadInfo);
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                            }
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            this.f62192d.a(arrayList2);
                            this.f62192d.a(arrayList2, arrayList, sparseArray3, this.a, this.f62190b);
                            try {
                                ArrayList<Integer> arrayList3 = new ArrayList();
                                if (this.a != null) {
                                    while (i2 < this.a.size()) {
                                        int keyAt = this.a.keyAt(i2);
                                        if (keyAt != 0) {
                                            DownloadInfo downloadInfo2 = (DownloadInfo) this.a.get(keyAt);
                                            if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                                    arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                    this.f62190b.remove(downloadInfo2.getId());
                                                }
                                            } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                                arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                this.f62190b.remove(downloadInfo2.getId());
                                            }
                                        }
                                        for (Integer num : arrayList3) {
                                            this.a.remove(num.intValue());
                                        }
                                        i2++;
                                    }
                                }
                                dVar3 = this.f62191c;
                            } catch (Throwable th) {
                                try {
                                    th.printStackTrace();
                                } finally {
                                }
                            }
                        } catch (Throwable th2) {
                            try {
                                th2.printStackTrace();
                                com.ss.android.socialbase.downloader.i.f.a(cursor);
                                this.f62192d.a(arrayList2);
                                this.f62192d.a(arrayList2, arrayList, sparseArray3, this.a, this.f62190b);
                                try {
                                    ArrayList<Integer> arrayList4 = new ArrayList();
                                    if (this.a != null) {
                                        while (i2 < this.a.size()) {
                                            int keyAt2 = this.a.keyAt(i2);
                                            if (keyAt2 != 0) {
                                                DownloadInfo downloadInfo3 = (DownloadInfo) this.a.get(keyAt2);
                                                if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                    if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                                        arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                        this.f62190b.remove(downloadInfo3.getId());
                                                    }
                                                } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                                    arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                    this.f62190b.remove(downloadInfo3.getId());
                                                }
                                            }
                                            for (Integer num2 : arrayList4) {
                                                this.a.remove(num2.intValue());
                                            }
                                            i2++;
                                        }
                                    }
                                    dVar3 = this.f62191c;
                                } catch (Throwable th3) {
                                    try {
                                        th3.printStackTrace();
                                        dVar3 = this.f62191c;
                                    } finally {
                                        d dVar4 = this.f62191c;
                                        if (dVar4 != null) {
                                            dVar4.a();
                                            this.f62192d.f62189f = true;
                                        }
                                        this.f62192d.a(this.a, this.f62190b);
                                    }
                                }
                            } catch (Throwable th4) {
                                com.ss.android.socialbase.downloader.i.f.a(cursor);
                                this.f62192d.a(arrayList2);
                                this.f62192d.a(arrayList2, arrayList, sparseArray3, this.a, this.f62190b);
                                try {
                                    ArrayList<Integer> arrayList5 = new ArrayList();
                                    if (this.a != null) {
                                        while (i2 < this.a.size()) {
                                            int keyAt3 = this.a.keyAt(i2);
                                            if (keyAt3 != 0) {
                                                DownloadInfo downloadInfo4 = (DownloadInfo) this.a.get(keyAt3);
                                                if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                    if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                                        arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                        this.f62190b.remove(downloadInfo4.getId());
                                                    }
                                                } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                                    arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                    this.f62190b.remove(downloadInfo4.getId());
                                                }
                                            }
                                            for (Integer num3 : arrayList5) {
                                                this.a.remove(num3.intValue());
                                            }
                                            i2++;
                                        }
                                    }
                                    dVar2 = this.f62191c;
                                } catch (Throwable th5) {
                                    try {
                                        th5.printStackTrace();
                                        dVar2 = this.f62191c;
                                    } finally {
                                        d dVar5 = this.f62191c;
                                        if (dVar5 != null) {
                                            dVar5.a();
                                            this.f62192d.f62189f = true;
                                        }
                                        this.f62192d.a(this.a, this.f62190b);
                                    }
                                }
                            }
                        }
                    }
                };
                ExecutorService r = com.ss.android.socialbase.downloader.downloader.c.r();
                if (r != null) {
                    r.execute(runnable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo d(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-2));
            contentValues.put("curBytes", Long.valueOf(j2));
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            h();
            if (f62185b == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.b.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.k();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, list) == null) || list == null) {
            return;
        }
        try {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    com.ss.android.socialbase.downloader.i.f.b(downloadInfo);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f62189f : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-1));
            contentValues.put("curBytes", Long.valueOf(j2));
            if (j2 > 0) {
                contentValues.put("isFirstDownload", (Integer) 0);
            }
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-3));
            contentValues.put("curBytes", Long.valueOf(j2));
            contentValues.put("isFirstDownload", (Integer) 0);
            contentValues.put("isFirstSuccess", (Integer) 0);
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, List<Integer> list2, SparseArray<DownloadInfo> sparseArray, SparseArray<DownloadInfo> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray3) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65558, this, list, list2, sparseArray, sparseArray2, sparseArray3) == null) || (size = sparseArray.size()) < 0 || f62185b == null) {
            return;
        }
        synchronized (f62185b) {
            try {
                i();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.g.a.c().a("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            strArr[i2] = String.valueOf(list.get(i2));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f62185b.delete("downloader", str, strArr);
                        f62185b.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, list2);
                        f62185b.delete("downloader", "_id IN (?)", new String[]{join});
                        f62185b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = sparseArray.keyAt(i3);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f62185b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f62185b.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.b> c2 = c(keyAt);
                        if (c2.size() > 0) {
                            f62185b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                                bVar.b(downloadInfo.getId());
                                f62185b.insert("downloadChunk", null, bVar.a());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        int id = sparseArray2.valueAt(i4).getId();
                        List<com.ss.android.socialbase.downloader.model.b> a = com.ss.android.socialbase.downloader.i.f.a(c(id));
                        if (a != null && a.size() > 0) {
                            sparseArray3.put(id, a);
                        }
                    }
                }
                f62185b.setTransactionSuccessful();
                j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, list) == null) {
            try {
                d(i2);
                if (list != null) {
                    for (com.ss.android.socialbase.downloader.model.b bVar : list) {
                        if (bVar != null) {
                            a(bVar);
                            if (bVar.f()) {
                                for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.g()) {
                                    a(bVar2);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            try {
                return b(i2) != null;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            h();
            ArrayList arrayList = new ArrayList();
            if (f62185b != null) {
                Cursor cursor = null;
                try {
                    cursor = f62185b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                    if (cursor.moveToNext()) {
                        arrayList.add(new DownloadInfo(cursor));
                    }
                    com.ss.android.socialbase.downloader.i.f.a(cursor);
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                    } catch (Throwable th2) {
                        com.ss.android.socialbase.downloader.i.f.a(cursor);
                        throw th2;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65543, this, i2, sQLiteStatement) == null) || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i2);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            h();
            if (f62185b == null || this.f62187d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, bVar) { // from class: com.ss.android.socialbase.downloader.b.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.downloader.model.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f62198b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62198b = this;
                    this.a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62198b.a(this.a, this.f62198b.f62187d.a());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, this, downloadInfo, sQLiteStatement) == null) || downloadInfo == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                downloadInfo.bindValue(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.ss.android.socialbase.downloader.model.b bVar, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, this, bVar, sQLiteStatement) == null) || bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.a(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || j2 < 0 || f62185b == null || this.f62187d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, j2) { // from class: com.ss.android.socialbase.downloader.b.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62199b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f62200c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f62201d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62201d = this;
                    this.a = i2;
                    this.f62199b = i3;
                    this.f62200c = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62201d.a(this.a, this.f62199b, this.f62200c, this.f62201d.f62187d.c());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || i4 < 0 || j2 < 0 || f62185b == null || this.f62187d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, i4, j2) { // from class: com.ss.android.socialbase.downloader.b.e.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62202b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f62203c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f62204d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ e f62205e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62205e = this;
                    this.a = i2;
                    this.f62202b = i3;
                    this.f62203c = i4;
                    this.f62204d = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62205e.a(this.a, this.f62202b, this.f62203c, this.f62204d, this.f62205e.f62187d.c());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            h();
            if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f62185b == null || this.f62187d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, i4, i5) { // from class: com.ss.android.socialbase.downloader.b.e.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f62206b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f62207c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f62208d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ e f62209e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62209e = this;
                    this.a = i2;
                    this.f62206b = i3;
                    this.f62207c = i4;
                    this.f62208d = i5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f62209e.a(this.a, this.f62206b, this.f62207c, this.f62208d, this.f62209e.f62187d.c());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, int i5, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("chunkIndex", Integer.valueOf(i5));
                    f62185b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, long j2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j2));
                    f62185b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j2, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j2));
                    f62185b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            h();
            if (f62185b == null) {
                return null;
            }
            int i4 = 10;
            while (f62185b.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chunkCount", Integer.valueOf(i3));
            f62185b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
            return null;
        }
        return (DownloadInfo) invokeII.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, downloadInfo)) == null) {
            h();
            if (downloadInfo == null || f62185b == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.b.e.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DownloadInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f62193b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62193b = this;
                    this.a = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f62193b.d(this.a);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 3);
            contentValues.put("totalBytes", Long.valueOf(j2));
            contentValues.put("eTag", str);
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("name", str2);
            }
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 4);
            contentValues.put("curBytes", Long.valueOf(j2));
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, i> map) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i2, map)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            h();
            if (f62185b == null) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (Long l : map.keySet()) {
                    jSONArray.put(map.get(Long.valueOf(l.longValue())).k());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            r0 = "json=" + jSONArray;
            SQLiteStatement d2 = this.f62188e.d();
            synchronized (d2) {
                d2.clearBindings();
                d2.bindLong(1, i2);
                d2.bindString(2, jSONArray.toString());
                d2.execute();
            }
            com.ss.android.socialbase.downloader.c.a.b("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.i.f.c(currentTimeMillis));
            return false;
        }
        return invokeIL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65542, this, i2, contentValues) == null) {
            int i3 = 10;
            while (f62185b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            f62185b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sparseArray, sparseArray2) == null) {
            try {
                HashMap a = com.ss.android.socialbase.downloader.i.f.a(sparseArray);
                HashMap a2 = com.ss.android.socialbase.downloader.i.f.a(sparseArray2);
                if (this.a != null) {
                    this.a.a(a, a2);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
