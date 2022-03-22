package com.kwai.filedownloader.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a.a;
import com.kwai.filedownloader.e.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class d implements com.kwai.filedownloader.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f41588b;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC2011a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.c.c> f41589b;

        /* renamed from: c  reason: collision with root package name */
        public b f41590c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.c.c> f41591d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<List<com.kwai.filedownloader.c.a>> f41592e;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            this(dVar, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((d) objArr2[0], (SparseArray) objArr2[1], (SparseArray) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(d dVar, SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, sparseArray, sparseArray2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f41589b = new SparseArray<>();
            this.f41591d = sparseArray;
            this.f41592e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2011a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f41590c;
                if (bVar != null) {
                    bVar.b();
                }
                if (this.a.a == null) {
                    return;
                }
                int size = this.f41589b.size();
                try {
                    try {
                        if (size < 0) {
                            return;
                        }
                        try {
                            this.a.a.beginTransaction();
                            for (int i = 0; i < size; i++) {
                                int keyAt = this.f41589b.keyAt(i);
                                com.kwai.filedownloader.c.c cVar = this.f41589b.get(keyAt);
                                this.a.a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                                this.a.a.insert("ksad_file_download", null, cVar.p());
                                if (cVar.n() > 1) {
                                    List<com.kwai.filedownloader.c.a> c2 = this.a.c(keyAt);
                                    if (c2.size() > 0) {
                                        this.a.a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                        for (com.kwai.filedownloader.c.a aVar : c2) {
                                            aVar.a(cVar.a());
                                            this.a.a.insert("ksad_file_download_connection", null, aVar.f());
                                        }
                                    }
                                }
                            }
                            if (this.f41591d != null && this.f41592e != null) {
                                synchronized (this.f41591d) {
                                    int size2 = this.f41591d.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        int a = this.f41591d.valueAt(i2).a();
                                        List<com.kwai.filedownloader.c.a> c3 = this.a.c(a);
                                        if (c3 != null && c3.size() > 0) {
                                            synchronized (this.f41592e) {
                                                this.f41592e.put(a, c3);
                                            }
                                        }
                                    }
                                }
                            }
                            this.a.a.setTransactionSuccessful();
                            if (this.a.a != null) {
                                this.a.a.endTransaction();
                            }
                        } catch (SQLiteException e2) {
                            this.a.a(e2);
                            if (this.a.a != null) {
                                this.a.a.endTransaction();
                            }
                        } catch (Exception e3) {
                            d.b(e3);
                            if (this.a.a != null) {
                                this.a.a.endTransaction();
                            }
                        }
                    } catch (Exception e4) {
                        d.b(e4);
                    }
                } catch (Throwable th) {
                    if (this.a.a != null) {
                        try {
                            this.a.a.endTransaction();
                        } catch (Exception e5) {
                            d.b(e5);
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2011a
        public void a(int i, com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cVar) == null) {
                this.f41589b.put(i, cVar);
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2011a
        public void a(com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC2011a
        public void b(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || (sparseArray = this.f41591d) == null) {
                return;
            }
            synchronized (sparseArray) {
                this.f41591d.put(cVar.a(), cVar);
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.c.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b bVar = new b(this.a);
                this.f41590c = bVar;
                return bVar;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Iterator<com.kwai.filedownloader.c.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public Cursor f41593b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Integer> f41594c;

        /* renamed from: d  reason: collision with root package name */
        public int f41595d;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.f41594c = new ArrayList();
            if (dVar.a != null) {
                try {
                    this.f41593b = dVar.a.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e2) {
                    dVar.a(e2);
                } catch (Exception e3) {
                    d.b(e3);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public com.kwai.filedownloader.c.c next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                com.kwai.filedownloader.c.c b2 = d.b(this.f41593b);
                this.f41595d = b2.a();
                return b2;
            }
            return (com.kwai.filedownloader.c.c) invokeV.objValue;
        }

        public void b() {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.a == null || (cursor = this.f41593b) == null) {
                return;
            }
            cursor.close();
            if (this.f41594c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.f41594c);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "delete %s", join);
            }
            try {
                this.a.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                this.a.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                this.a.a(e2);
            } catch (Exception e3) {
                d.b(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Cursor cursor = this.f41593b;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f41594c.add(Integer.valueOf(this.f41595d));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1185799806, "Lcom/kwai/filedownloader/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1185799806, "Lcom/kwai/filedownloader/a/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.a = new e(com.kwai.filedownloader.e.c.a()).getWritableDatabase();
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    private void a(int i, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, contentValues) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e2) {
            a(i, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, this, i, sQLiteException) == null) {
            if (!(sQLiteException instanceof SQLiteFullException)) {
                b(sQLiteException);
                return;
            }
            if (i != -1) {
                e(i);
                d(i);
            }
            a(sQLiteException, !f41588b);
            f41588b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, sQLiteException) == null) {
            a(-1, sQLiteException);
        }
    }

    public static void a(Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65545, null, th, z) == null) || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static com.kwai.filedownloader.c.c b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cursor)) == null) {
            com.kwai.filedownloader.c.c cVar = new com.kwai.filedownloader.c.c();
            if (cursor == null) {
                return cVar;
            }
            cVar.a(cursor.getInt(cursor.getColumnIndex("_id")));
            cVar.a(cursor.getString(cursor.getColumnIndex("url")));
            cVar.a(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
            cVar.a((byte) cursor.getShort(cursor.getColumnIndex("status")));
            cVar.a(cursor.getLong(cursor.getColumnIndex("sofar")));
            cVar.c(cursor.getLong(cursor.getColumnIndex("total")));
            cVar.c(cursor.getString(cursor.getColumnIndex(StatConstants.KEY_EXT_ERR_MSG)));
            cVar.b(cursor.getString(cursor.getColumnIndex("etag")));
            cVar.d(cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
            cVar.b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
            return cVar;
        }
        return (com.kwai.filedownloader.c.c) invokeL.objValue;
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, th) == null) {
            a(th, true);
        }
    }

    public a.InterfaceC2011a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sparseArray, sparseArray2)) == null) ? new a(this, sparseArray, sparseArray2) : (a.InterfaceC2011a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void a() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.delete("ksad_file_download", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
        try {
            this.a.delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e3) {
            a(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e2) {
            a(i, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e2) {
            a(i, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 3);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 2);
            contentValues.put("total", Long.valueOf(j));
            contentValues.put("etag", str);
            contentValues.put(BreakpointSQLiteKey.FILENAME, str2);
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, String str, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sofar", Long.valueOf(j));
            contentValues.put("total", Long.valueOf(j2));
            contentValues.put("etag", str);
            contentValues.put("connectionCount", Integer.valueOf(i2));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, th) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
            contentValues.put("status", (Byte) (byte) 5);
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(int i, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), th, Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
            contentValues.put("status", (Byte) (byte) -1);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.f());
        } catch (SQLiteException e2) {
            a(aVar.a(), e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void a(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || this.a == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.e.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            try {
                this.a.update("ksad_file_download", cVar.p(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e2) {
                cVar.c(e2.toString());
                cVar.a((byte) -1);
                a(cVar.a(), e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public a.InterfaceC2011a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this) : (a.InterfaceC2011a) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0040 */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r0 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
        if (r0 == null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    @Override // com.kwai.filedownloader.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.filedownloader.c.c b(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048589, this, i)) != null) {
            return (com.kwai.filedownloader.c.c) invokeI.objValue;
        }
        SQLiteDatabase sQLiteDatabase = this.a;
        ?? r1 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwai.filedownloader.c.c b2 = b(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return b2;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    a(i, e);
                } catch (Exception e3) {
                    e = e3;
                    b(e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void b(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            e(i);
        }
    }

    public void b(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download", null, cVar.p());
        } catch (SQLiteException e2) {
            cVar.c(e2.toString());
            cVar.a((byte) -1);
            a(cVar.a(), e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0074, code lost:
        if (r2 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        if (r2 == null) goto L15;
     */
    @Override // com.kwai.filedownloader.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.kwai.filedownloader.c.a> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048592, this, i)) != null) {
            return (List) invokeI.objValue;
        }
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursor.moveToNext()) {
                    com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                    aVar.a(i);
                    aVar.b(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.a(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    aVar.b(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.c(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e2) {
                a(i, e2);
            } catch (Exception e3) {
                b(e3);
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) -2);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public void d(int i) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException | Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return false;
            }
            try {
                return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
            } catch (SQLiteException | Exception e2) {
                b(e2);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
        }
    }
}
