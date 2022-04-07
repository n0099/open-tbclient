package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.nadcore.sweetsqlite.IntegerColumn;
import com.baidu.nadcore.sweetsqlite.LongColumn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qz0;
/* loaded from: classes6.dex */
public class pz0 implements qz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public pz0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase, sQLiteDatabase2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = sQLiteDatabase;
        this.b = sQLiteDatabase2;
    }

    @Override // com.repackage.qz0
    public qz0.a a(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xz0Var, oz0VarArr)) == null) {
            this.a.beginTransaction();
            try {
                int update = update(xz0Var, oz0VarArr);
                long insert = update == 0 ? insert(xz0Var) : 0L;
                this.a.setTransactionSuccessful();
                this.a.endTransaction();
                return new qz0.a(insert, update);
            } catch (Throwable th) {
                this.a.endTransaction();
                throw th;
            }
        }
        return (qz0.a) invokeLL.objValue;
    }

    public final Column[] b(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xz0Var, oz0VarArr)) == null) {
            if (oz0VarArr.length > 0) {
                return uz0.d(xz0Var, oz0VarArr);
            }
            return uz0.d(xz0Var, xz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.repackage.qz0
    public void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.beginTransaction();
        }
    }

    public final boolean c(Column... columnArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, columnArr)) == null) {
            for (Column column : columnArr) {
                if (column == null || !column.isAssignedValue) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int delete(String str, yz0 yz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, yz0Var)) == null) ? this.a.delete(str, yz0Var.l(), yz0Var.e()) : invokeLL.intValue;
    }

    @Override // com.repackage.qz0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(xz0 xz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, xz0Var)) == null) {
            wz0 b = xz0Var.b();
            String g = b.g();
            oz0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, xz0Var.a());
            }
            Column column = uz0.d(xz0Var, f[0])[0];
            boolean l = uz0.l(column);
            if (l && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + xz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, xz0Var.a());
            if (l) {
                int type = column.type();
                if (type == 2) {
                    ((IntegerColumn) column).setValue((int) insert);
                } else if (type == 3) {
                    ((LongColumn) column).setValue(insert);
                } else {
                    throw new IllegalStateException("Invalid key type. Must be Long or Integer.");
                }
            }
            return insert;
        }
        return invokeL.longValue;
    }

    public boolean query(xz0 xz0Var, yz0 yz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, xz0Var, yz0Var)) == null) {
            Cursor rawQuery = this.b.rawQuery("SELECT " + tz0.d(xz0Var.b().d()) + " FROM " + xz0Var.b().g() + yz0Var.k(), yz0Var.e());
            boolean moveToFirst = rawQuery.moveToFirst();
            if (moveToFirst) {
                vz0.a(rawQuery, xz0Var);
            }
            rawQuery.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.qz0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.repackage.qz0
    public int update(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, xz0Var, oz0VarArr)) == null) {
            String g = xz0Var.b().g();
            yz0 j = yz0.j(b(xz0Var, oz0VarArr));
            return this.a.update(g, xz0Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public int delete(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, xz0Var, oz0VarArr)) == null) {
            String g = xz0Var.b().g();
            Column[] b = b(xz0Var, oz0VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, yz0.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public pz0(SQLiteDatabase sQLiteDatabase) {
        this(sQLiteDatabase, sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((SQLiteDatabase) objArr2[0], (SQLiteDatabase) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int update(Class<? extends xz0> cls, yz0 yz0Var, oz0[] oz0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, yz0Var, oz0VarArr, objArr)) == null) {
            if (oz0VarArr.length != 0 && objArr.length == oz0VarArr.length) {
                return update(rz0.b(cls).g(), uz0.c(oz0VarArr, objArr), yz0Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, xz0Var, oz0VarArr)) == null) ? query(xz0Var, yz0.j(b(xz0Var, oz0VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, oz0[] oz0VarArr, yz0 yz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, oz0VarArr, yz0Var)) == null) {
            return this.b.rawQuery("SELECT " + tz0.d(oz0VarArr) + " FROM " + str + yz0Var.k(), yz0Var.e());
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(xz0 xz0Var, yz0 yz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, xz0Var, yz0Var)) == null) ? update(xz0Var.b().g(), xz0Var.a(), yz0Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, yz0 yz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, yz0Var)) == null) {
            return this.a.update(str, contentValues, yz0Var != null ? yz0Var.l() : null, yz0Var != null ? yz0Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(zz0 zz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, zz0Var)) == null) ? this.b.rawQuery(zz0Var.b(), zz0Var.a()) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, yz0 yz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, yz0Var)) == null) ? update(str, uz0.e(columnArr), yz0Var) : invokeLLL.intValue;
    }

    public long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, objArr)) == null) {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < strArr.length; i++) {
                contentValues.put(strArr[i], String.valueOf(objArr[i]));
            }
            return this.a.insert(str, null, contentValues);
        }
        return invokeLLL.longValue;
    }
}
