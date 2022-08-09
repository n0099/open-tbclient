package com.repackage;

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
/* loaded from: classes7.dex */
public class ye {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j9 a;

    public ye(Context context, j9 j9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, j9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j9Var;
    }

    public void a(qe qeVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qeVar) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", qeVar.a);
                contentValues.put("tableName", qeVar.b);
                contentValues.put("maxSize", Integer.valueOf(qeVar.c));
                contentValues.put("cacheVersion", Integer.valueOf(qeVar.e));
                contentValues.put("cacheType", qeVar.d);
                contentValues.put("lastActiveTime", Long.valueOf(qeVar.f));
                SQLiteDatabase f = this.a.f();
                if (f == null || f.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{qeVar.a}) != 0) {
                    return;
                }
                f.insert("cache_meta_info", null, contentValues);
            } catch (Throwable th) {
                this.a.i(th, "addOrUpdate");
            }
        }
    }

    public qe b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                cursor = this.a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    qe qeVar = new qe();
                    qeVar.a = cursor.getString(0);
                    qeVar.b = cursor.getString(1);
                    qeVar.c = cursor.getInt(2);
                    qeVar.d = cursor.getString(3);
                    qeVar.e = cursor.getInt(4);
                    qeVar.f = cursor.getLong(5);
                    return qeVar;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.a.i(th, "get");
                    return null;
                } finally {
                    ng.a(cursor);
                }
            }
            return null;
        }
        return (qe) invokeL.objValue;
    }

    public int delete(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                if (b(str) == null) {
                    return 0;
                }
                return this.a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.i(th, "delete");
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
