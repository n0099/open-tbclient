package d.a.c.e.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final d.a.c.a.k.b f44121a;

    public p(Context context, d.a.c.a.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44121a = bVar;
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", hVar.f44095a);
                contentValues.put("tableName", hVar.f44096b);
                contentValues.put("maxSize", Integer.valueOf(hVar.f44097c));
                contentValues.put("cacheVersion", Integer.valueOf(hVar.f44099e));
                contentValues.put("cacheType", hVar.f44098d);
                contentValues.put("lastActiveTime", Long.valueOf(hVar.f44100f));
                SQLiteDatabase f2 = this.f44121a.f();
                if (f2 == null || f2.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{hVar.f44095a}) != 0) {
                    return;
                }
                f2.insert("cache_meta_info", null, contentValues);
            } catch (Throwable th) {
                this.f44121a.i(th, "addOrUpdate");
            }
        }
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (c(str) == null) {
                    return 0;
                }
                return this.f44121a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                this.f44121a.i(th, "delete");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public h c(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                cursor = this.f44121a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    h hVar = new h();
                    hVar.f44095a = cursor.getString(0);
                    hVar.f44096b = cursor.getString(1);
                    hVar.f44097c = cursor.getInt(2);
                    hVar.f44098d = cursor.getString(3);
                    hVar.f44099e = cursor.getInt(4);
                    hVar.f44100f = cursor.getLong(5);
                    return hVar;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.f44121a.i(th, "get");
                    return null;
                } finally {
                    d.a.c.e.m.a.a(cursor);
                }
            }
            return null;
        }
        return (h) invokeL.objValue;
    }
}
