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
/* loaded from: classes10.dex */
public final class d implements com.kwai.filedownloader.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static boolean aub;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase aua;

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC0699a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SparseArray<com.kwai.filedownloader.c.c> atQ;
        public final SparseArray<List<com.kwai.filedownloader.c.a>> atR;
        public final SparseArray<com.kwai.filedownloader.c.c> auc;
        public b aud;
        public final /* synthetic */ d aue;

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
            this.aue = dVar;
            this.auc = new SparseArray<>();
            this.atQ = sparseArray;
            this.atR = sparseArray2;
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0699a
        public final void Di() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.aud;
                if (bVar != null) {
                    bVar.Di();
                }
                if (this.aue.aua == null) {
                    return;
                }
                int size = this.auc.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        try {
                            this.aue.aua.beginTransaction();
                            for (int i = 0; i < size; i++) {
                                int keyAt = this.auc.keyAt(i);
                                com.kwai.filedownloader.c.c cVar = this.auc.get(keyAt);
                                this.aue.aua.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                                this.aue.aua.insert("ksad_file_download", null, cVar.Ek());
                                if (cVar.Eo() > 1) {
                                    List<com.kwai.filedownloader.c.a> ce = this.aue.ce(keyAt);
                                    if (ce.size() > 0) {
                                        this.aue.aua.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                        for (com.kwai.filedownloader.c.a aVar : ce) {
                                            aVar.setId(cVar.getId());
                                            this.aue.aua.insert("ksad_file_download_connection", null, aVar.Ek());
                                        }
                                    }
                                }
                            }
                            if (this.atQ != null && this.atR != null) {
                                synchronized (this.atQ) {
                                    int size2 = this.atQ.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        int id = this.atQ.valueAt(i2).getId();
                                        List<com.kwai.filedownloader.c.a> ce2 = this.aue.ce(id);
                                        if (ce2 != null && ce2.size() > 0) {
                                            synchronized (this.atR) {
                                                this.atR.put(id, ce2);
                                            }
                                        }
                                    }
                                }
                            }
                            this.aue.aua.setTransactionSuccessful();
                            if (this.aue.aua != null) {
                                try {
                                    this.aue.aua.endTransaction();
                                } catch (Exception e) {
                                    d.printStackTrace(e);
                                }
                            }
                        } catch (SQLiteException e2) {
                            this.aue.a(e2);
                            if (this.aue.aua != null) {
                                try {
                                    this.aue.aua.endTransaction();
                                } catch (Exception e3) {
                                    d.printStackTrace(e3);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        if (this.aue.aua != null) {
                            try {
                                this.aue.aua.endTransaction();
                            } catch (Exception e5) {
                                d.printStackTrace(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (this.aue.aua != null) {
                        try {
                            this.aue.aua.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0699a
        public final void a(int i, com.kwai.filedownloader.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cVar) == null) {
                this.auc.put(i, cVar);
            }
        }

        @Override // com.kwai.filedownloader.a.a.InterfaceC0699a
        public final void c(com.kwai.filedownloader.c.c cVar) {
            SparseArray<com.kwai.filedownloader.c.c> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || (sparseArray = this.atQ) == null) {
                return;
            }
            synchronized (sparseArray) {
                this.atQ.put(cVar.getId(), cVar);
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwai.filedownloader.c.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                b bVar = new b(this.aue);
                this.aud = bVar;
                return bVar;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Iterator<com.kwai.filedownloader.c.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d aue;
        public Cursor auf;
        public final List<Integer> aug;
        public int auh;

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
            this.aue = dVar;
            this.aug = new ArrayList();
            if (dVar.aua != null) {
                try {
                    this.auf = dVar.aua.rawQuery("SELECT * FROM ksad_file_download", null);
                } catch (SQLiteException e) {
                    dVar.a(e);
                } catch (Exception e2) {
                    d.printStackTrace(e2);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: Dj */
        public com.kwai.filedownloader.c.c next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                com.kwai.filedownloader.c.c h = d.h(this.auf);
                this.auh = h.getId();
                return h;
            }
            return (com.kwai.filedownloader.c.c) invokeV.objValue;
        }

        public final void Di() {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.aue.aua == null || (cursor = this.auf) == null) {
                return;
            }
            cursor.close();
            if (this.aug.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.aug);
            if (com.kwai.filedownloader.e.d.awL) {
                com.kwai.filedownloader.e.d.e(this, "delete %s", join);
            }
            try {
                this.aue.aua.execSQL(f.h("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                this.aue.aua.execSQL(f.h("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e) {
                this.aue.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Cursor cursor = this.auf;
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
                this.aug.add(Integer.valueOf(this.auh));
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
            this.aua = new e(com.kwai.filedownloader.e.c.EJ()).getWritableDatabase();
        } catch (SQLiteException e) {
            a(e);
        }
    }

    private void a(int i, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, this, i, contentValues) == null) || (sQLiteDatabase = this.aua) == null) {
            return;
        }
        try {
            sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private void a(int i, @Nullable SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, sQLiteException) == null) {
            if (!(sQLiteException instanceof SQLiteFullException)) {
                printStackTrace(sQLiteException);
                return;
            }
            if (i != -1) {
                cg(i);
                cf(i);
            }
            o(sQLiteException);
            aub = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, sQLiteException) == null) {
            a(-1, sQLiteException);
        }
    }

    private void d(com.kwai.filedownloader.c.c cVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, cVar) == null) || (sQLiteDatabase = this.aua) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download", null, cVar.Ek());
        } catch (SQLiteException e) {
            cVar.eA(e.toString());
            cVar.e((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    public static com.kwai.filedownloader.c.c h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cursor)) == null) {
            com.kwai.filedownloader.c.c cVar = new com.kwai.filedownloader.c.c();
            if (cursor == null) {
                return cVar;
            }
            cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
            cVar.d(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
            cVar.e((byte) cursor.getShort(cursor.getColumnIndex("status")));
            cVar.Z(cursor.getLong(cursor.getColumnIndex("sofar")));
            cVar.ab(cursor.getLong(cursor.getColumnIndex("total")));
            cVar.eA(cursor.getString(cursor.getColumnIndex(StatConstants.KEY_EXT_ERR_MSG)));
            cVar.ez(cursor.getString(cursor.getColumnIndex("etag")));
            cVar.eB(cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME)));
            cVar.cw(cursor.getInt(cursor.getColumnIndex("connectionCount")));
            return cVar;
        }
        return (com.kwai.filedownloader.c.c) invokeL.objValue;
    }

    public static void o(Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, null, th) == null) || th == null) {
            return;
        }
        th.printStackTrace();
    }

    public static void printStackTrace(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, th) == null) {
            o(th);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final a.InterfaceC0699a Dh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a.InterfaceC0699a) invokeV.objValue;
    }

    public final a.InterfaceC0699a a(SparseArray<com.kwai.filedownloader.c.c> sparseArray, SparseArray<List<com.kwai.filedownloader.c.a>> sparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray, sparseArray2)) == null) ? new a(this, sparseArray, sparseArray2) : (a.InterfaceC0699a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.aua == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            this.aua.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, long j, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2}) == null) {
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
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
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
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, th) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(StatConstants.KEY_EXT_ERR_MSG, th.toString());
            contentValues.put("status", (Byte) (byte) 5);
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void a(int i, Throwable th, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), th, Long.valueOf(j)}) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (sQLiteDatabase = this.aua) == null) {
            return;
        }
        try {
            sQLiteDatabase.insert("ksad_file_download_connection", null, aVar.Ek());
        } catch (SQLiteException e) {
            a(aVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void b(com.kwai.filedownloader.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || this.aua == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.e.d.f(this, "update but model == null!", new Object[0]);
        } else if (cd(cVar.getId()) == null) {
            d(cVar);
        } else {
            try {
                this.aua.update("ksad_file_download", cVar.Ek(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
            } catch (SQLiteException e) {
                cVar.eA(e.toString());
                cVar.e((byte) -1);
                a(cVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void c(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 3);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final com.kwai.filedownloader.c.c cd(int i) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048587, this, i)) != null) {
            return (com.kwai.filedownloader.c.c) invokeI.objValue;
        }
        SQLiteDatabase sQLiteDatabase = this.aua;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.h("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwai.filedownloader.c.c h = h(cursor);
                        com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                        return h;
                    }
                } catch (SQLiteException e) {
                    e = e;
                    a(i, e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    printStackTrace(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
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
                com.kwad.sdk.crash.utils.b.closeQuietly(sQLiteDatabase2);
                throw th;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return null;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase2 = sQLiteDatabase;
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final List<com.kwai.filedownloader.c.a> ce(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase sQLiteDatabase = this.aua;
            if (sQLiteDatabase == null) {
                return arrayList;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = sQLiteDatabase.rawQuery(f.h("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                        while (cursor.moveToNext()) {
                            com.kwai.filedownloader.c.a aVar = new com.kwai.filedownloader.c.a();
                            aVar.setId(i);
                            aVar.setIndex(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                            aVar.setStartOffset(cursor.getLong(cursor.getColumnIndex("startOffset")));
                            aVar.X(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                            aVar.Y(cursor.getLong(cursor.getColumnIndex("endOffset")));
                            arrayList.add(aVar);
                        }
                    } catch (Exception e) {
                        printStackTrace(e);
                    }
                } catch (SQLiteException e2) {
                    a(i, e2);
                }
                return arrayList;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void cf(int i) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (sQLiteDatabase = this.aua) == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final boolean cg(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            SQLiteDatabase sQLiteDatabase = this.aua;
            if (sQLiteDatabase == null) {
                return false;
            }
            try {
                return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
            } catch (SQLiteException | Exception e) {
                printStackTrace(e);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.a.a
    public final void ch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void clear() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (sQLiteDatabase = this.aua) == null) {
            return;
        }
        try {
            sQLiteDatabase.delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            this.aua.delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void d(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            cg(i);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void e(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) -2);
            contentValues.put("sofar", Long.valueOf(j));
            a(i, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.a.a
    public final void x(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) || this.aua == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            this.aua.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }
}
