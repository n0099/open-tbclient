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
/* loaded from: classes5.dex */
public final class d implements com.kwai.filedownloader.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    /* loaded from: classes5.dex */
    public class a implements a.InterfaceC0556a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final SparseArray<com.kwai.filedownloader.c.c> b;
        public b c;
        public final SparseArray<com.kwai.filedownloader.c.c> d;
        public final SparseArray<List<com.kwai.filedownloader.c.a>> e;

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
            this.b = new SparseArray<>();
            this.d = sparseArray;
            this.e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0556a
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.c;
                if (bVar != null) {
                    bVar.a();
                }
                if (this.a.a == null) {
                    return;
                }
                int size = this.b.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        try {
                            this.a.a.beginTransaction();
                            for (int i = 0; i < size; i++) {
                                int keyAt = this.b.keyAt(i);
                                com.kwai.filedownloader.c.c cVar = this.b.get(keyAt);
                                this.a.a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                                this.a.a.insert("ksad_file_download", null, cVar.o());
                                if (cVar.m() > 1) {
                                    List<com.kwai.filedownloader.c.a> c = this.a.c(keyAt);
                                    if (c.size() > 0) {
                                        this.a.a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                        for (com.kwai.filedownloader.c.a aVar : c) {
                                            aVar.a(cVar.a());
                                            this.a.a.insert("ksad_file_download_connection", null, aVar.f());
                                        }
                                    }
                                }
                            }
                            if (this.d != null && this.e != null) {
                                synchronized (this.d) {
                                    int size2 = this.d.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        int a = this.d.valueAt(i2).a();
                                        List<com.kwai.filedownloader.c.a> c2 = this.a.c(a);
                                        if (c2 != null && c2.size() > 0) {
                                            synchronized (this.e) {
                                                this.e.put(a, c2);
                                            }
                                        }
                                    }
                                }
                            }
                            this.a.a.setTransactionSuccessful();
                            if (this.a.a != null) {
                                try {
                                    this.a.a.endTransaction();
                                } catch (Exception e) {
                                    d.b(e);
                                }
                            }
                        } catch (SQLiteException e2) {
                            this.a.a(e2);
                            if (this.a.a != null) {
                                try {
                                    this.a.a.endTransaction();
                                } catch (Exception e3) {
                                    d.b(e3);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        d.b(e4);
                        if (this.a.a != null) {
                            try {
                                this.a.a.endTransaction();
                            } catch (Exception e5) {
                                d.b(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (this.a.a != null) {
                        try {
                            this.a.a.endTransaction();
                        } catch (Exception e6) {
                            d.b(e6);
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0556a
        public final void a(int i, com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cVar) == null) {
                this.b.put(i, cVar);
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0556a
        public final void a(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || (sparseArray = this.d) == null) {
                return;
            }
            synchronized (sparseArray) {
                this.d.put(cVar.a(), cVar);
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b bVar = new b(this.a);
                this.c = bVar;
                return bVar;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Iterator<com.kwai.filedownloader.c.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public Cursor b;
        public final List<Integer> c;
        public int d;

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
            this.c = new ArrayList();
            if (dVar.a != null) {
                try {
                    this.b = dVar.a.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e) {
                    dVar.a(e);
                } catch (Exception e2) {
                    d.b(e2);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: b */
        public com.kwai.filedownloader.c.c next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                com.kwai.filedownloader.c.c b = d.b(this.b);
                this.d = b.a();
                return b;
            }
            return (com.kwai.filedownloader.c.c) invokeV.objValue;
        }

        public final void a() {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null || (cursor = this.b) == null) {
                return;
            }
            cursor.close();
            if (this.c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.c);
            if (com.kwai.filedownloader.e.d.a) {
                com.kwai.filedownloader.e.d.c(this, "delete %s", join);
            }
            try {
                this.a.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                this.a.a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e) {
                this.a.a(e);
            } catch (Exception e2) {
                d.b(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Cursor cursor = this.b;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c.add(Integer.valueOf(this.d));
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
        } catch (SQLiteException e) {
            a(e);
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
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            b(e2);
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
            c(sQLiteException);
            b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, sQLiteException) == null) {
            a(-1, sQLiteException);
        }
    }

    public static com.kwai.filedownloader.c.c b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cursor)) == null) {
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

    private void b(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, cVar) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download", null, cVar.o());
        } catch (SQLiteException e) {
            cVar.c(e.toString());
            cVar.a((byte) -1);
            a(cVar.a(), e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, th) == null) {
            c(th);
        }
    }

    public static void c(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, th) == null) || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public final a.InterfaceC0556a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sparseArray, sparseArray2)) == null) ? new a(this, sparseArray, sparseArray2) : (a.InterfaceC0556a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            this.a.delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 3);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
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
    public final void a(int i, String str, long j, long j2, int i2) {
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
    public final void a(int i, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, th) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
            contentValues.put("status", (Byte) (byte) 5);
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
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
    public final void a(com.kwai.filedownloader.c.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.f());
        } catch (SQLiteException e) {
            a(aVar.a(), e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(com.kwai.filedownloader.c.c cVar) {
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
                this.a.update("ksad_file_download", cVar.o(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e) {
                cVar.c(e.toString());
                cVar.a((byte) -1);
                a(cVar.a(), e);
            } catch (Exception e2) {
                b(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0556a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this) : (a.InterfaceC0556a) invokeV.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c b(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048589, this, i)) != null) {
            return (com.kwai.filedownloader.c.c) invokeI.objValue;
        }
        SQLiteDatabase sQLiteDatabase = this.a;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwai.filedownloader.c.c b2 = b(cursor);
                        com.kwad.sdk.crash.utils.b.a(cursor);
                        return b2;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    a(i, e);
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    b(e);
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.a(sQLiteDatabase2);
                throw th;
            }
            com.kwad.sdk.crash.utils.b.a(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            e(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return arrayList;
            }
            Cursor cursor = null;
            try {
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
                    } catch (Exception e) {
                        b(e);
                    }
                } catch (SQLiteException e2) {
                    a(i, e2);
                }
                return arrayList;
            } finally {
                com.kwad.sdk.crash.utils.b.a(cursor);
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) -2);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || (sQLiteDatabase = this.a) == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            b(e);
        } catch (Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            SQLiteDatabase sQLiteDatabase = this.a;
            if (sQLiteDatabase == null) {
                return false;
            }
            try {
                return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
            } catch (SQLiteException | Exception e) {
                b(e);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
        }
    }
}
