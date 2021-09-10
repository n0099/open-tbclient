package com.kwai.filedownloader.b;

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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class d implements com.kwai.filedownloader.b.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f74091b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SQLiteDatabase f74092a;

    /* loaded from: classes10.dex */
    public class a implements a.InterfaceC2023a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f74093a;

        /* renamed from: b  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f74094b;

        /* renamed from: c  reason: collision with root package name */
        public b f74095c;

        /* renamed from: d  reason: collision with root package name */
        public final SparseArray<com.kwai.filedownloader.d.c> f74096d;

        /* renamed from: e  reason: collision with root package name */
        public final SparseArray<List<com.kwai.filedownloader.d.a>> f74097e;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            this(dVar, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((d) objArr2[0], (SparseArray) objArr2[1], (SparseArray) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(d dVar, SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, sparseArray, sparseArray2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f74093a = dVar;
            this.f74094b = new SparseArray<>();
            this.f74096d = sparseArray;
            this.f74097e = sparseArray2;
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC2023a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f74095c;
                if (bVar != null) {
                    bVar.b();
                }
                if (this.f74093a.f74092a == null) {
                    return;
                }
                int size = this.f74094b.size();
                try {
                    try {
                        if (size < 0) {
                            return;
                        }
                        try {
                            this.f74093a.f74092a.beginTransaction();
                            for (int i2 = 0; i2 < size; i2++) {
                                int keyAt = this.f74094b.keyAt(i2);
                                com.kwai.filedownloader.d.c cVar = this.f74094b.get(keyAt);
                                this.f74093a.f74092a.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(keyAt)});
                                this.f74093a.f74092a.insert("ksad_file_download", null, cVar.p());
                                if (cVar.n() > 1) {
                                    List<com.kwai.filedownloader.d.a> c2 = this.f74093a.c(keyAt);
                                    if (c2.size() > 0) {
                                        this.f74093a.f74092a.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(keyAt)});
                                        for (com.kwai.filedownloader.d.a aVar : c2) {
                                            aVar.a(cVar.a());
                                            this.f74093a.f74092a.insert("ksad_file_download_connection", null, aVar.f());
                                        }
                                    }
                                }
                            }
                            if (this.f74096d != null && this.f74097e != null) {
                                synchronized (this.f74096d) {
                                    int size2 = this.f74096d.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        int a2 = this.f74096d.valueAt(i3).a();
                                        List<com.kwai.filedownloader.d.a> c3 = this.f74093a.c(a2);
                                        if (c3 != null && c3.size() > 0) {
                                            synchronized (this.f74097e) {
                                                this.f74097e.put(a2, c3);
                                            }
                                        }
                                    }
                                }
                            }
                            this.f74093a.f74092a.setTransactionSuccessful();
                            if (this.f74093a.f74092a != null) {
                                this.f74093a.f74092a.endTransaction();
                            }
                        } catch (SQLiteException e2) {
                            this.f74093a.a(e2);
                            if (this.f74093a.f74092a != null) {
                                this.f74093a.f74092a.endTransaction();
                            }
                        } catch (Exception e3) {
                            d.b(e3);
                            if (this.f74093a.f74092a != null) {
                                this.f74093a.f74092a.endTransaction();
                            }
                        }
                    } catch (Exception e4) {
                        d.b(e4);
                    }
                } catch (Throwable th) {
                    if (this.f74093a.f74092a != null) {
                        try {
                            this.f74093a.f74092a.endTransaction();
                        } catch (Exception e5) {
                            d.b(e5);
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC2023a
        public void a(int i2, com.kwai.filedownloader.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, cVar) == null) {
                this.f74094b.put(i2, cVar);
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC2023a
        public void a(com.kwai.filedownloader.d.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            }
        }

        @Override // com.kwai.filedownloader.b.a.InterfaceC2023a
        public void b(com.kwai.filedownloader.d.c cVar) {
            SparseArray<com.kwai.filedownloader.d.c> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || (sparseArray = this.f74096d) == null) {
                return;
            }
            synchronized (sparseArray) {
                this.f74096d.put(cVar.a(), cVar);
            }
        }

        @Override // java.lang.Iterable
        public Iterator<com.kwai.filedownloader.d.c> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                b bVar = new b(this.f74093a);
                this.f74095c = bVar;
                return bVar;
            }
            return (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Iterator<com.kwai.filedownloader.d.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f74098a;

        /* renamed from: b  reason: collision with root package name */
        public Cursor f74099b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Integer> f74100c;

        /* renamed from: d  reason: collision with root package name */
        public int f74101d;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f74098a = dVar;
            this.f74100c = new ArrayList();
            if (dVar.f74092a != null) {
                try {
                    this.f74099b = dVar.f74092a.rawQuery("SELECT * FROM ksad_file_download", null);
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
        public com.kwai.filedownloader.d.c next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                com.kwai.filedownloader.d.c b2 = d.b(this.f74099b);
                this.f74101d = b2.a();
                return b2;
            }
            return (com.kwai.filedownloader.d.c) invokeV.objValue;
        }

        public void b() {
            Cursor cursor;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f74098a.f74092a == null || (cursor = this.f74099b) == null) {
                return;
            }
            cursor.close();
            if (this.f74100c.isEmpty()) {
                return;
            }
            String join = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, this.f74100c);
            if (com.kwai.filedownloader.f.d.f74244a) {
                com.kwai.filedownloader.f.d.c(this, "delete %s", join);
            }
            try {
                this.f74098a.f74092a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", join));
                this.f74098a.f74092a.execSQL(f.a("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", join));
            } catch (SQLiteException e2) {
                this.f74098a.a(e2);
            } catch (Exception e3) {
                d.b(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Cursor cursor = this.f74099b;
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
                this.f74100c.add(Integer.valueOf(this.f74101d));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1185770015, "Lcom/kwai/filedownloader/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1185770015, "Lcom/kwai/filedownloader/b/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f74092a = new e(com.kwai.filedownloader.f.c.a()).getWritableDatabase();
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    private void a(int i2, ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, contentValues) == null) || (sQLiteDatabase = this.f74092a) == null) {
            return;
        }
        try {
            sQLiteDatabase.update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i2)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    private void a(int i2, @Nullable SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, sQLiteException) == null) {
            if (!(sQLiteException instanceof SQLiteFullException)) {
                b(sQLiteException);
                return;
            }
            if (i2 != -1) {
                e(i2);
                d(i2);
            }
            a(sQLiteException, !f74091b);
            f74091b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, sQLiteException) == null) {
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

    public static com.kwai.filedownloader.d.c b(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cursor)) == null) {
            com.kwai.filedownloader.d.c cVar = new com.kwai.filedownloader.d.c();
            if (cursor == null) {
                return cVar;
            }
            cVar.a(cursor.getInt(cursor.getColumnIndex("_id")));
            cVar.a(cursor.getString(cursor.getColumnIndex("url")));
            cVar.a(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
            cVar.a((byte) cursor.getShort(cursor.getColumnIndex("status")));
            cVar.a(cursor.getLong(cursor.getColumnIndex("sofar")));
            cVar.c(cursor.getLong(cursor.getColumnIndex("total")));
            cVar.c(cursor.getString(cursor.getColumnIndex("errMsg")));
            cVar.b(cursor.getString(cursor.getColumnIndex("etag")));
            cVar.d(cursor.getString(cursor.getColumnIndex("filename")));
            cVar.b(cursor.getInt(cursor.getColumnIndex("connectionCount")));
            return cVar;
        }
        return (com.kwai.filedownloader.d.c) invokeL.objValue;
    }

    public static void b(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, th) == null) {
            a(th, true);
        }
    }

    public a.InterfaceC2023a a(SparseArray<com.kwai.filedownloader.d.c> sparseArray, SparseArray<List<com.kwai.filedownloader.d.a>> sparseArray2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sparseArray, sparseArray2)) == null) ? new a(this, sparseArray, sparseArray2) : (a.InterfaceC2023a) invokeLL.objValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public void a() {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sQLiteDatabase = this.f74092a) == null) {
            return;
        }
        try {
            sQLiteDatabase.delete("ksad_file_download", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
        try {
            this.f74092a.delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e3) {
            a(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || this.f74092a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i3));
        try {
            this.f74092a.update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i2)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, int i3, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2)}) == null) || this.f74092a == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j2));
        try {
            this.f74092a.update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i2), Integer.toString(i3)});
        } catch (SQLiteException e2) {
            a(i2, e2);
        } catch (Exception e3) {
            b(e3);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 3);
            contentValues.put("sofar", Long.valueOf(j2));
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, str2}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) 2);
            contentValues.put("total", Long.valueOf(j2));
            contentValues.put("etag", str);
            contentValues.put("filename", str2);
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, String str, long j2, long j3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("sofar", Long.valueOf(j2));
            contentValues.put("total", Long.valueOf(j3));
            contentValues.put("etag", str);
            contentValues.put("connectionCount", Integer.valueOf(i3));
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, th) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("errMsg", th.toString());
            contentValues.put("status", (Byte) (byte) 5);
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(int i2, Throwable th, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), th, Long.valueOf(j2)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("errMsg", th.toString());
            contentValues.put("status", (Byte) (byte) -1);
            contentValues.put("sofar", Long.valueOf(j2));
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.a aVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null || (sQLiteDatabase = this.f74092a) == null) {
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

    @Override // com.kwai.filedownloader.b.a
    public void a(com.kwai.filedownloader.d.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || this.f74092a == null) {
            return;
        }
        if (cVar == null) {
            com.kwai.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
        } else if (b(cVar.a()) == null) {
            b(cVar);
        } else {
            try {
                this.f74092a.update("ksad_file_download", cVar.p(), "_id = ? ", new String[]{String.valueOf(cVar.a())});
            } catch (SQLiteException e2) {
                cVar.c(e2.toString());
                cVar.a((byte) -1);
                a(cVar.a(), e2);
            } catch (Exception e3) {
                b(e3);
            }
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public a.InterfaceC2023a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new a(this) : (a.InterfaceC2023a) invokeV.objValue;
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
    @Override // com.kwai.filedownloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwai.filedownloader.d.c b(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048589, this, i2)) != null) {
            return (com.kwai.filedownloader.d.c) invokeI.objValue;
        }
        SQLiteDatabase sQLiteDatabase = this.f74092a;
        ?? r1 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i2)});
                try {
                    if (cursor.moveToNext()) {
                        com.kwai.filedownloader.d.c b2 = b(cursor);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return b2;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    a(i2, e);
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

    @Override // com.kwai.filedownloader.b.a
    public void b(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            e(i2);
        }
    }

    public void b(com.kwai.filedownloader.d.c cVar) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, cVar) == null) || (sQLiteDatabase = this.f74092a) == null) {
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
    @Override // com.kwai.filedownloader.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<com.kwai.filedownloader.d.a> c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048592, this, i2)) != null) {
            return (List) invokeI.objValue;
        }
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f74092a;
        if (sQLiteDatabase == null) {
            return arrayList;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.rawQuery(f.a("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i2)});
                while (cursor.moveToNext()) {
                    com.kwai.filedownloader.d.a aVar = new com.kwai.filedownloader.d.a();
                    aVar.a(i2);
                    aVar.b(cursor.getInt(cursor.getColumnIndex("connectionIndex")));
                    aVar.a(cursor.getLong(cursor.getColumnIndex("startOffset")));
                    aVar.b(cursor.getLong(cursor.getColumnIndex("currentOffset")));
                    aVar.c(cursor.getLong(cursor.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e2) {
                a(i2, e2);
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

    @Override // com.kwai.filedownloader.b.a
    public void c(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Byte) (byte) -2);
            contentValues.put("sofar", Long.valueOf(j2));
            a(i2, contentValues);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public void d(int i2) {
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (sQLiteDatabase = this.f74092a) == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i2);
        } catch (SQLiteException | Exception e2) {
            b(e2);
        }
    }

    @Override // com.kwai.filedownloader.b.a
    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            SQLiteDatabase sQLiteDatabase = this.f74092a;
            if (sQLiteDatabase == null) {
                return false;
            }
            try {
                return sQLiteDatabase.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i2)}) != 0;
            } catch (SQLiteException | Exception e2) {
                b(e2);
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.kwai.filedownloader.b.a
    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
        }
    }
}
