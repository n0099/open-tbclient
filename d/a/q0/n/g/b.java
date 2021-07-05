package d.a.q0.n.g;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n.g.c.c;
import d.a.q0.n.h.d;
import d.a.q0.n.h.e;
import d.a.q0.n.h.f;
import d.a.q0.n.h.g;
import d.a.q0.n.h.h;
import d.a.q0.n.h.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f53912b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53912b = new c();
    }

    public final <T> List<T> A(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                d.a.q0.n.g.c.b<T> a2 = this.f53912b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a2.e(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(cursor2);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0034 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final <T> T B(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, str)) == null) {
            ?? r0 = 0;
            try {
                try {
                    d.a.q0.n.g.c.b<T> a2 = this.f53912b.a(cls);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(cls), null, "bundle_id =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            T d2 = a2.d(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return d2;
                        } catch (Exception e2) {
                            e = e2;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = cls;
                    d.a.q0.n.o.c.a(r0);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(r0);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final <T> List<T> C(Class<T> cls, String str, String[] strArr, String str2) {
        InterceptResult invokeLLLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, cls, str, strArr, str2)) == null) {
            Cursor cursor2 = null;
            try {
                d.a.q0.n.g.c.b<T> a2 = this.f53912b.a(cls);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(cls), null, str, strArr, str2);
                if (cursor != null) {
                    try {
                        try {
                            List<T> e2 = a2.e(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(cursor2);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLLLL.objValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean a(f fVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fVar, pMSAppInfo)) == null) ? b(fVar, null, null, null, pMSAppInfo) : invokeLL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean b(f fVar, List<g> list, d dVar, d.a.q0.n.h.b bVar, PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLLLL;
        ContentProviderResult[] applyBatch;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, fVar, list, dVar, bVar, pMSAppInfo)) == null) {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            if (fVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f53912b.b(f.class)).withValues(this.f53912b.a(f.class).c(fVar)).build());
            }
            if (list != null && !list.isEmpty()) {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(g.class);
                for (g gVar : list) {
                    arrayList.add(ContentProviderOperation.newInsert(this.f53912b.b(g.class)).withValues(a2.c(gVar)).build());
                }
            }
            if (dVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f53912b.b(d.class)).withValues(this.f53912b.a(d.class).c(dVar)).build());
            }
            if (bVar != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f53912b.b(d.a.q0.n.h.b.class)).withValues(this.f53912b.a(d.a.q0.n.h.b.class).c(bVar)).build());
            }
            if (pMSAppInfo != null) {
                arrayList.add(ContentProviderOperation.newInsert(this.f53912b.b(PMSAppInfo.class)).withValues(this.f53912b.a(PMSAppInfo.class).c(pMSAppInfo)).build());
            }
            try {
                for (ContentProviderResult contentProviderResult : AppRuntime.getAppContext().getContentResolver().applyBatch(d.a.q0.n.g.e.b.f53919b, arrayList)) {
                    if (contentProviderResult == null || (contentProviderResult.uri == null && contentProviderResult.count == null)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f53912b.b(g.class), "app_id=?", new String[]{str});
        } catch (Exception e2) {
            if (d.a.q0.n.c.f53910a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.q0.n.g.a
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            AppRuntime.getAppContext().getContentResolver().delete(this.f53912b.b(g.class), "app_id=? AND version_code=?", new String[]{str, str2});
        } catch (Exception e2) {
            if (d.a.q0.n.c.f53910a) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.a.q0.n.g.a
    public <T extends e> boolean e(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cls, str)) == null) {
            try {
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f53912b.b(cls), "bundle_id =? ", new String[]{str}) > 0;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean f(@NonNull h hVar) {
        InterceptResult invokeL;
        Uri b2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hVar)) == null) {
            try {
                b2 = this.f53912b.b(hVar.getClass());
                if (hVar.f53940i >= 0) {
                    str = "bundle_id = ?  and version_code < ? ";
                    strArr = new String[]{hVar.f53938g, String.valueOf(hVar.f53940i)};
                } else {
                    str = "bundle_id = ? ";
                    strArr = new String[]{hVar.f53938g};
                }
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(b2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().delete(this.f53912b.b(PMSAppInfo.class), "app_id =? ", new String[]{str}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    @WorkerThread
    public int i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Cursor cursor = null;
            int i2 = -1;
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(g.class), new String[]{"version_code"}, "app_id=?", new String[]{str}, "version_code DESC limit 1");
                    if (cursor != null && cursor.moveToFirst()) {
                        i2 = cursor.getInt(0);
                    }
                } catch (Exception e2) {
                    if (d.a.q0.n.c.f53910a) {
                        e2.printStackTrace();
                    }
                }
                return i2;
            } finally {
                d.a.q0.n.o.c.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // d.a.q0.n.g.a
    @NonNull
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<g> j(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Cursor cursor;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i2)) == null) {
            Cursor cursor2 = null;
            r1 = null;
            r1 = null;
            List<g> list = null;
            try {
                if (i2 >= 0) {
                    str2 = "app_id=? and version_code=?";
                } else {
                    str2 = "app_id=? and version_code>?";
                }
                Uri b2 = this.f53912b.b(g.class);
                d.a.q0.n.g.c.b a2 = this.f53912b.a(g.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(b2, null, str2, new String[]{str, String.valueOf(i2)}, null);
                if (query != null && a2 != null) {
                    try {
                        list = a2.e(query);
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        try {
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            if (list != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            d.a.q0.n.o.c.a(cursor2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        cursor2 = query;
                        th = th2;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
                d.a.q0.n.o.c.a(query);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
            return list != null ? Collections.emptyList() : list;
        }
        return (List) invokeLI.objValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean k(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, pMSAppInfo)) == null) {
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f53912b.b(pMSAppInfo.getClass()), this.f53912b.a(pMSAppInfo.getClass()).c(pMSAppInfo));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public <T extends e> boolean l(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, t)) == null) ? y(t) : invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean m(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, str, str2, str3)) == null) {
            Cursor cursor = null;
            try {
                try {
                    Uri b2 = this.f53912b.b(g.class);
                    d.a.q0.n.g.c.b a2 = this.f53912b.a(g.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(b2, null, "app_id=? AND version_code=? AND sub_pkg_name=?", new String[]{str, str2, str3}, null);
                    if (cursor != null) {
                        return a2.d(cursor) != null;
                    }
                } catch (Exception e2) {
                    if (d.a.q0.n.c.f53910a) {
                        e2.printStackTrace();
                    }
                }
                return false;
            } finally {
                d.a.q0.n.o.c.a(cursor);
            }
        }
        return invokeLLL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public List<h> n(int i2) {
        InterceptResult invokeI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Cursor cursor2 = null;
            try {
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
            }
            if (this.f53912b != null) {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(h.class);
                Cursor query = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(h.class), null, null, null, "update_time ASC limit 0," + i2);
                if (query == null) {
                    d.a.q0.n.o.c.a(query);
                    return null;
                }
                try {
                    List<h> e3 = a2.e(query);
                    d.a.q0.n.o.c.a(query);
                    return e3;
                } catch (Exception e4) {
                    cursor = query;
                    e = e4;
                    try {
                        if (d.a.q0.n.c.f53910a) {
                            e.printStackTrace();
                        }
                        d.a.q0.n.o.c.a(cursor);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = query;
                    th = th3;
                    d.a.q0.n.o.c.a(cursor2);
                    throw th;
                }
            }
            Log.i("queryBatchDynamicLib", "mDBDao is null");
            d.a.q0.n.o.c.a(null);
            return null;
        }
        return (List) invokeI.objValue;
    }

    @Override // d.a.q0.n.g.a
    public <T extends e> T o(Class<T> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, cls, str)) == null) ? (T) B(cls, str) : (T) invokeLL.objValue;
    }

    @Override // d.a.q0.n.g.a
    public Map<String, f> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            HashMap hashMap = new HashMap();
            List<f> C = C(f.class, "state =? ", new String[]{"10"}, "version_code ASC");
            if (C != null && C.size() > 0) {
                for (f fVar : C) {
                    if (fVar != null) {
                        hashMap.put(fVar.f53938g, fVar);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // d.a.q0.n.g.a
    public List<h> q(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, strArr)) == null) {
            Cursor cursor2 = null;
            try {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(h.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(h.class), null, str, strArr, "update_time DESC");
                if (cursor != null) {
                    try {
                        try {
                            List<h> e2 = a2.e(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(cursor2);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // d.a.q0.n.g.a
    @Nullable
    public i r(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            ?? r1 = 0;
            try {
                try {
                    d.a.q0.n.g.c.b a2 = this.f53912b.a(i.class);
                    cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(i.class), null, "lib_name =? ", new String[]{str}, "version_code DESC");
                    if (cursor != null) {
                        try {
                            i iVar = (i) a2.d(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return iVar;
                        } catch (Exception e2) {
                            e = e2;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    d.a.q0.n.o.c.a(r1);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(r1);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (i) invokeL.objValue;
    }

    @Override // d.a.q0.n.g.a
    public PMSAppInfo s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) ? z(str) : (PMSAppInfo) invokeL.objValue;
    }

    @Override // d.a.q0.n.g.a
    public Map<String, PMSAppInfo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            HashMap hashMap = new HashMap();
            List<PMSAppInfo> A = A(PMSAppInfo.class, null, null, null);
            if (A != null && A.size() > 0) {
                for (PMSAppInfo pMSAppInfo : A) {
                    if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                        hashMap.put(pMSAppInfo.appId, pMSAppInfo);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // d.a.q0.n.g.a
    public List<h> u(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            Cursor cursor2 = null;
            try {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(h.class);
                Uri.Builder buildUpon = this.f53912b.b(h.class).buildUpon();
                buildUpon.appendQueryParameter("rawQuery", "");
                cursor = AppRuntime.getAppContext().getContentResolver().query(buildUpon.build(), null, str, null, null);
                if (cursor != null) {
                    try {
                        try {
                            List<h> e2 = a2.e(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return e2;
                        } catch (Exception e3) {
                            e = e3;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        d.a.q0.n.o.c.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.q0.n.o.c.a(cursor2);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean v(@NonNull h hVar) {
        InterceptResult invokeL;
        Uri b2;
        ContentValues c2;
        String str;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, hVar)) == null) {
            try {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(hVar.getClass());
                b2 = this.f53912b.b(hVar.getClass());
                c2 = a2.c(hVar);
                if (hVar.f53940i >= 0) {
                    str = "bundle_id = ?  and version_code = ? ";
                    strArr = new String[]{hVar.f53938g, String.valueOf(hVar.f53940i)};
                } else {
                    str = "bundle_id = ?  and version_name = ? ";
                    strArr = new String[]{hVar.f53938g, hVar.j};
                }
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, c2, str, strArr) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean w(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, pMSAppInfo)) == null) {
            try {
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(this.f53912b.b(pMSAppInfo.getClass()), this.f53912b.a(pMSAppInfo.getClass()).c(pMSAppInfo), "app_id =? ", new String[]{pMSAppInfo.appId}) > 0;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.n.g.a
    public boolean x(String str, int i2) {
        InterceptResult invokeLI;
        Uri b2;
        ContentValues contentValues;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                b2 = this.f53912b.b(PMSAppInfo.class);
                contentValues = new ContentValues();
                contentValues.put("pending_err_code", Integer.valueOf(i2));
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                }
            }
            return AppRuntime.getAppContext().getContentResolver().update(b2, contentValues, "app_id =? ", new String[]{str}) > 0;
        }
        return invokeLI.booleanValue;
    }

    public final <T extends e> boolean y(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, t)) == null) {
            try {
                Uri insert = AppRuntime.getAppContext().getContentResolver().insert(this.f53912b.b(t.getClass()), this.f53912b.a(t.getClass()).c(t));
                if (insert != null) {
                    return ContentUris.parseId(insert) > 0;
                }
                return false;
            } catch (Exception e2) {
                if (d.a.q0.n.c.f53910a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final PMSAppInfo z(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            try {
                d.a.q0.n.g.c.b a2 = this.f53912b.a(PMSAppInfo.class);
                cursor = AppRuntime.getAppContext().getContentResolver().query(this.f53912b.b(PMSAppInfo.class), null, "app_id =? ", new String[]{str}, "version_code DESC");
                if (cursor != null) {
                    try {
                        try {
                            PMSAppInfo pMSAppInfo = (PMSAppInfo) a2.d(cursor);
                            d.a.q0.n.o.c.a(cursor);
                            return pMSAppInfo;
                        } catch (Exception e2) {
                            e = e2;
                            if (d.a.q0.n.c.f53910a) {
                                e.printStackTrace();
                            }
                            d.a.q0.n.o.c.a(cursor);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        d.a.q0.n.o.c.a(cursor);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                d.a.q0.n.o.c.a(cursor);
                throw th;
            }
            d.a.q0.n.o.c.a(cursor);
            return null;
        }
        return (PMSAppInfo) invokeL.objValue;
    }
}
