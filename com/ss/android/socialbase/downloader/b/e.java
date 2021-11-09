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
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes2.dex */
public class e extends c.a implements t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SQLiteDatabase f69087b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f69088a;

    /* renamed from: c  reason: collision with root package name */
    public g f69089c;

    /* renamed from: d  reason: collision with root package name */
    public g f69090d;

    /* renamed from: e  reason: collision with root package name */
    public g f69091e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f69092f;

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
        if ((interceptable == null || interceptable.invokeV(65567, this) == null) && f69087b == null) {
            synchronized (e.class) {
                if (f69087b == null) {
                    f69087b = a.a().getWritableDatabase();
                    this.f69089c = new g(f69087b, "downloader", com.ss.android.socialbase.downloader.constants.c.f69166a, com.ss.android.socialbase.downloader.constants.c.f69167b);
                    this.f69090d = new g(f69087b, "downloadChunk", com.ss.android.socialbase.downloader.constants.c.f69168c, com.ss.android.socialbase.downloader.constants.c.f69169d);
                    this.f69091e = new g(f69087b, "segments", com.ss.android.socialbase.downloader.constants.c.f69170e, com.ss.android.socialbase.downloader.constants.c.f69171f);
                }
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            f69087b.beginTransaction();
        }
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            try {
                if (f69087b == null || !f69087b.inTransaction()) {
                    return;
                }
                f69087b.endTransaction();
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
                f69087b.delete("downloader", null, null);
                f69087b.delete("downloadChunk", null, null);
                f69087b.setTransactionSuccessful();
                j();
            }
        }
    }

    private void update(int i2, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65571, this, i2, contentValues) == null) {
            h();
            if (f69087b == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, contentValues) { // from class: com.ss.android.socialbase.downloader.b.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69102a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ContentValues f69103b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f69104c;

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
                    this.f69104c = this;
                    this.f69102a = i2;
                    this.f69103b = contentValues;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69104c.a(this.f69102a, this.f69103b);
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
            if (f69087b != null && (gVar = this.f69089c) != null) {
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

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69099a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f69100b;

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
                    this.f69100b = this;
                    this.f69099a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69100b.e(this.f69099a);
                        this.f69100b.d(this.f69099a);
                        this.f69100b.m(this.f69099a);
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
            if (f69087b != null) {
                try {
                    cursor = f69087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i2)});
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
            if (f69087b == null) {
                return;
            }
            try {
                a(i2, this.f69091e.b());
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
        this.f69088a = null;
        if (z) {
            this.f69092f = false;
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
            if (f69087b != null) {
                try {
                    cursor = f69087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i2)});
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
            if (f69087b != null) {
                Cursor cursor = null;
                try {
                    cursor = f69087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i2)});
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
            if (f69087b == null || this.f69090d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2) { // from class: com.ss.android.socialbase.downloader.b.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69105a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f69106b;

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
                    this.f69106b = this;
                    this.f69105a = i2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69106b.a(this.f69105a, this.f69106b.f69090d.b());
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
                    } else if (this.f69089c == null) {
                    } else {
                        b(downloadInfo, this.f69089c.c());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo e(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-4));
            contentValues.put("curBytes", Long.valueOf(j));
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
            if (f69087b == null || this.f69089c == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.b.e.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69123a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f69124b;

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
                    this.f69124b = this;
                    this.f69123a = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69124b.a(this.f69123a, this.f69124b.f69089c.a());
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

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ SparseArray f69093a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ SparseArray f69094b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f69095c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ e f69096d;

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
                        this.f69096d = this;
                        this.f69093a = sparseArray;
                        this.f69094b = sparseArray2;
                        this.f69095c = dVar;
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
                        r18.f69096d.f69092f = true;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:170:0x0349, code lost:
                        r18.f69096d.a(r18.f69093a, r18.f69094b);
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
                        this.f69096d.h();
                        if (e.f69087b == null) {
                            return;
                        }
                        k B = com.ss.android.socialbase.downloader.downloader.c.B();
                        SparseArray sparseArray3 = new SparseArray();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        Cursor cursor = null;
                        int i2 = 0;
                        try {
                            cursor = e.f69087b.rawQuery("SELECT * FROM downloader", null);
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
                                        int a2 = B != null ? B.a(downloadInfo.getUrl(), downloadInfo.getSavePath()) : 0;
                                        if (a2 != id) {
                                            downloadInfo.setId(a2);
                                            sparseArray3.put(id, downloadInfo);
                                        }
                                        this.f69093a.put(downloadInfo.getId(), downloadInfo);
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                            }
                            com.ss.android.socialbase.downloader.i.f.a(cursor);
                            this.f69096d.a(arrayList2);
                            this.f69096d.a(arrayList2, arrayList, sparseArray3, this.f69093a, this.f69094b);
                            try {
                                ArrayList<Integer> arrayList3 = new ArrayList();
                                if (this.f69093a != null) {
                                    while (i2 < this.f69093a.size()) {
                                        int keyAt = this.f69093a.keyAt(i2);
                                        if (keyAt != 0) {
                                            DownloadInfo downloadInfo2 = (DownloadInfo) this.f69093a.get(keyAt);
                                            if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable() && downloadInfo2.getStatus() != -3) {
                                                    arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                    this.f69094b.remove(downloadInfo2.getId());
                                                }
                                            } else if (downloadInfo2 != null && !downloadInfo2.isChunkBreakpointAvailable()) {
                                                arrayList3.add(Integer.valueOf(downloadInfo2.getId()));
                                                this.f69094b.remove(downloadInfo2.getId());
                                            }
                                        }
                                        for (Integer num : arrayList3) {
                                            this.f69093a.remove(num.intValue());
                                        }
                                        i2++;
                                    }
                                }
                                dVar3 = this.f69095c;
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
                                this.f69096d.a(arrayList2);
                                this.f69096d.a(arrayList2, arrayList, sparseArray3, this.f69093a, this.f69094b);
                                try {
                                    ArrayList<Integer> arrayList4 = new ArrayList();
                                    if (this.f69093a != null) {
                                        while (i2 < this.f69093a.size()) {
                                            int keyAt2 = this.f69093a.keyAt(i2);
                                            if (keyAt2 != 0) {
                                                DownloadInfo downloadInfo3 = (DownloadInfo) this.f69093a.get(keyAt2);
                                                if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                    if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable() && downloadInfo3.getStatus() != -3) {
                                                        arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                        this.f69094b.remove(downloadInfo3.getId());
                                                    }
                                                } else if (downloadInfo3 != null && !downloadInfo3.isChunkBreakpointAvailable()) {
                                                    arrayList4.add(Integer.valueOf(downloadInfo3.getId()));
                                                    this.f69094b.remove(downloadInfo3.getId());
                                                }
                                            }
                                            for (Integer num2 : arrayList4) {
                                                this.f69093a.remove(num2.intValue());
                                            }
                                            i2++;
                                        }
                                    }
                                    dVar3 = this.f69095c;
                                } catch (Throwable th3) {
                                    try {
                                        th3.printStackTrace();
                                        dVar3 = this.f69095c;
                                    } finally {
                                        d dVar4 = this.f69095c;
                                        if (dVar4 != null) {
                                            dVar4.a();
                                            this.f69096d.f69092f = true;
                                        }
                                        this.f69096d.a(this.f69093a, this.f69094b);
                                    }
                                }
                            } catch (Throwable th4) {
                                com.ss.android.socialbase.downloader.i.f.a(cursor);
                                this.f69096d.a(arrayList2);
                                this.f69096d.a(arrayList2, arrayList, sparseArray3, this.f69093a, this.f69094b);
                                try {
                                    ArrayList<Integer> arrayList5 = new ArrayList();
                                    if (this.f69093a != null) {
                                        while (i2 < this.f69093a.size()) {
                                            int keyAt3 = this.f69093a.keyAt(i2);
                                            if (keyAt3 != 0) {
                                                DownloadInfo downloadInfo4 = (DownloadInfo) this.f69093a.get(keyAt3);
                                                if (com.ss.android.socialbase.downloader.i.a.a(8192)) {
                                                    if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable() && downloadInfo4.getStatus() != -3) {
                                                        arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                        this.f69094b.remove(downloadInfo4.getId());
                                                    }
                                                } else if (downloadInfo4 != null && !downloadInfo4.isChunkBreakpointAvailable()) {
                                                    arrayList5.add(Integer.valueOf(downloadInfo4.getId()));
                                                    this.f69094b.remove(downloadInfo4.getId());
                                                }
                                            }
                                            for (Integer num3 : arrayList5) {
                                                this.f69093a.remove(num3.intValue());
                                            }
                                            i2++;
                                        }
                                    }
                                    dVar2 = this.f69095c;
                                } catch (Throwable th5) {
                                    try {
                                        th5.printStackTrace();
                                        dVar2 = this.f69095c;
                                    } finally {
                                        d dVar5 = this.f69095c;
                                        if (dVar5 != null) {
                                            dVar5.a();
                                            this.f69096d.f69092f = true;
                                        }
                                        this.f69096d.a(this.f69093a, this.f69094b);
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
    public DownloadInfo d(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-2));
            contentValues.put("curBytes", Long.valueOf(j));
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
            if (f69087b == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this) { // from class: com.ss.android.socialbase.downloader.b.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f69101a;

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
                    this.f69101a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69101a.k();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f69092f : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo b(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-1));
            contentValues.put("curBytes", Long.valueOf(j));
            if (j > 0) {
                contentValues.put("isFirstDownload", (Integer) 0);
            }
            update(i2, contentValues);
            return null;
        }
        return (DownloadInfo) invokeCommon.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo c(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) (-3));
            contentValues.put("curBytes", Long.valueOf(j));
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
        if (!(interceptable == null || interceptable.invokeLLLLL(65558, this, list, list2, sparseArray, sparseArray2, sparseArray3) == null) || (size = sparseArray.size()) < 0 || f69087b == null) {
            return;
        }
        synchronized (f69087b) {
            try {
                i();
                if (!list.isEmpty()) {
                    if (com.ss.android.socialbase.downloader.g.a.c().a("clear_invalid_task_error")) {
                        String[] strArr = new String[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            strArr[i2] = String.valueOf(list.get(i2));
                        }
                        String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                        f69087b.delete("downloader", str, strArr);
                        f69087b.delete("downloadChunk", str, strArr);
                    } else {
                        String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, list2);
                        f69087b.delete("downloader", "_id IN (?)", new String[]{join});
                        f69087b.delete("downloadChunk", "_id IN (?)", new String[]{join});
                    }
                }
                for (int i3 = 0; i3 < size; i3++) {
                    int keyAt = sparseArray.keyAt(i3);
                    DownloadInfo downloadInfo = sparseArray.get(keyAt);
                    f69087b.delete("downloader", "_id = ?", new String[]{String.valueOf(keyAt)});
                    f69087b.insert("downloader", null, downloadInfo.toContentValues());
                    if (downloadInfo.getChunkCount() > 1) {
                        List<com.ss.android.socialbase.downloader.model.b> c2 = c(keyAt);
                        if (c2.size() > 0) {
                            f69087b.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(keyAt)});
                            for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                                bVar.b(downloadInfo.getId());
                                f69087b.insert("downloadChunk", null, bVar.a());
                            }
                        }
                    }
                }
                if (sparseArray2 != null && sparseArray3 != null) {
                    int size2 = sparseArray2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        int id = sparseArray2.valueAt(i4).getId();
                        List<com.ss.android.socialbase.downloader.model.b> a2 = com.ss.android.socialbase.downloader.i.f.a(c(id));
                        if (a2 != null && a2.size() > 0) {
                            sparseArray3.put(id, a2);
                        }
                    }
                }
                f69087b.setTransactionSuccessful();
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
            if (f69087b != null) {
                Cursor cursor = null;
                try {
                    cursor = f69087b.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
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
            if (f69087b == null || this.f69090d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, bVar) { // from class: com.ss.android.socialbase.downloader.b.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.socialbase.downloader.model.b f69107a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f69108b;

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
                    this.f69108b = this;
                    this.f69107a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69108b.a(this.f69107a, this.f69108b.f69090d.a());
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
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || j < 0 || f69087b == null || this.f69090d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, j) { // from class: com.ss.android.socialbase.downloader.b.e.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69109a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69110b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f69111c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ e f69112d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69112d = this;
                    this.f69109a = i2;
                    this.f69110b = i3;
                    this.f69111c = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69112d.a(this.f69109a, this.f69110b, this.f69111c, this.f69112d.f69090d.c());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            h();
            if (i2 == 0 || i3 < 0 || i4 < 0 || j < 0 || f69087b == null || this.f69090d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, i4, j) { // from class: com.ss.android.socialbase.downloader.b.e.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69113a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69114b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f69115c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f69116d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ e f69117e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i5 = newInitContext.flag;
                        if ((i5 & 1) != 0) {
                            int i6 = i5 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69117e = this;
                    this.f69113a = i2;
                    this.f69114b = i3;
                    this.f69115c = i4;
                    this.f69116d = j;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69117e.a(this.f69113a, this.f69114b, this.f69115c, this.f69116d, this.f69117e.f69090d.c());
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
            if (i2 == 0 || i4 < 0 || i5 == i3 || i5 < 0 || f69087b == null || this.f69090d == null) {
                return;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, i2, i3, i4, i5) { // from class: com.ss.android.socialbase.downloader.b.e.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69118a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f69119b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f69120c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f69121d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ e f69122e;

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
                    this.f69122e = this;
                    this.f69118a = i2;
                    this.f69119b = i3;
                    this.f69120c = i4;
                    this.f69121d = i5;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f69122e.a(this.f69118a, this.f69119b, this.f69120c, this.f69121d, this.f69122e.f69090d.c());
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
                    f69087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j));
                    f69087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j, SQLiteStatement sQLiteStatement) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j), sQLiteStatement}) == null) {
            try {
                synchronized (sQLiteStatement) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("curOffset", Long.valueOf(j));
                    f69087b.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3), Integer.toString(i4)});
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
            if (f69087b == null) {
                return null;
            }
            int i4 = 10;
            while (f69087b.isDbLockedByCurrentThread() && i4 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("chunkCount", Integer.valueOf(i3));
            f69087b.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
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
            if (downloadInfo == null || f69087b == null) {
                return false;
            }
            com.ss.android.socialbase.downloader.downloader.c.b(new Runnable(this, downloadInfo) { // from class: com.ss.android.socialbase.downloader.b.e.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f69097a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f69098b;

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
                    this.f69098b = this;
                    this.f69097a = downloadInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f69098b.d(this.f69097a);
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public DownloadInfo a(int i2, long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 3);
            contentValues.put("totalBytes", Long.valueOf(j));
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
    public DownloadInfo a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 4);
            contentValues.put("curBytes", Long.valueOf(j));
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
            if (f69087b == null) {
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
            SQLiteStatement d2 = this.f69091e.d();
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
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, contentValues) == null) {
            int i3 = 10;
            while (f69087b.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            f69087b.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.c
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f69088a = bVar;
        }
    }

    public void a(SparseArray<DownloadInfo> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, sparseArray, sparseArray2) == null) {
            try {
                HashMap a2 = com.ss.android.socialbase.downloader.i.f.a(sparseArray);
                HashMap a3 = com.ss.android.socialbase.downloader.i.f.a(sparseArray2);
                if (this.f69088a != null) {
                    this.f69088a.a(a2, a3);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
