package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class je extends ke<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je(j9 j9Var) {
        super(j9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ke
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            j9 j9Var = this.a;
            j9Var.d("DROP TABLE IF EXISTS " + this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ke
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [byte[], T] */
    @Override // com.repackage.ke
    public oe<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) != null) {
            return (oe) invokeLL.objValue;
        }
        Cursor cursor = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
            try {
                if (!rawQuery.moveToNext()) {
                    mg.a(rawQuery);
                    return null;
                }
                oe<byte[]> oeVar = new oe<>();
                oeVar.a = rawQuery.getString(0);
                oeVar.d = rawQuery.getLong(1);
                oeVar.e = rawQuery.getLong(2);
                oeVar.f = rawQuery.getLong(3);
                oeVar.b = rawQuery.getBlob(4);
                mg.a(rawQuery);
                return oeVar;
            } catch (Throwable th) {
                th = th;
                cursor = rawQuery;
                mg.a(cursor);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.repackage.ke
    public void k(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i, i2) == null) {
        }
    }

    @Override // com.repackage.ke
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            String str2 = "cache_kv_b" + hashCode;
            this.a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.ke
    public ContentValues p(oe<byte[]> oeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, oeVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", oeVar.a);
            contentValues.put("m_value", oeVar.b);
            contentValues.put("saveTime", Long.valueOf(oeVar.d));
            contentValues.put("lastHitTime", Long.valueOf(oeVar.e));
            contentValues.put("timeToExpire", Long.valueOf(oeVar.f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // com.repackage.ke
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.b, new String[0]);
        }
        return (Cursor) invokeLL.objValue;
    }
}
