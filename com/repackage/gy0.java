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
import com.repackage.hy0;
/* loaded from: classes6.dex */
public class gy0 implements hy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public gy0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.repackage.hy0
    public hy0.a a(oy0 oy0Var, fy0... fy0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, oy0Var, fy0VarArr)) != null) {
            return (hy0.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(oy0Var, fy0VarArr);
            r0 = i == 0 ? insert(oy0Var) : 0L;
            this.a.setTransactionSuccessful();
        } catch (Exception unused) {
            i = 0;
        } catch (Throwable th) {
            try {
                this.a.endTransaction();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            this.a.endTransaction();
        } catch (Exception unused3) {
            return new hy0.a(r0, i);
        }
    }

    public final Column[] b(oy0 oy0Var, fy0... fy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oy0Var, fy0VarArr)) == null) {
            if (fy0VarArr.length > 0) {
                return ly0.d(oy0Var, fy0VarArr);
            }
            return ly0.d(oy0Var, oy0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.repackage.hy0
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

    public int delete(String str, py0 py0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, py0Var)) == null) ? this.a.delete(str, py0Var.l(), py0Var.e()) : invokeLL.intValue;
    }

    @Override // com.repackage.hy0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(oy0 oy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, oy0Var)) == null) {
            ny0 b = oy0Var.b();
            String g = b.g();
            fy0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, oy0Var.a());
            }
            Column column = ly0.d(oy0Var, f[0])[0];
            boolean l = ly0.l(column);
            if (l && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + oy0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, oy0Var.a());
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

    public boolean query(oy0 oy0Var, py0 py0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, oy0Var, py0Var)) == null) {
            ry0 ry0Var = new ry0(this.b.rawQuery("SELECT " + ky0.d(oy0Var.b().d()) + " FROM " + oy0Var.b().g() + py0Var.k(), py0Var.e()));
            boolean moveToFirst = ry0Var.moveToFirst();
            if (moveToFirst) {
                my0.a(ry0Var, oy0Var);
            }
            ry0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.hy0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.repackage.hy0
    public int update(oy0 oy0Var, fy0... fy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, oy0Var, fy0VarArr)) == null) {
            String g = oy0Var.b().g();
            py0 j = py0.j(b(oy0Var, fy0VarArr));
            return this.a.update(g, oy0Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public int delete(oy0 oy0Var, fy0... fy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, oy0Var, fy0VarArr)) == null) {
            String g = oy0Var.b().g();
            Column[] b = b(oy0Var, fy0VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, py0.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gy0(SQLiteDatabase sQLiteDatabase) {
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

    public int update(Class<? extends oy0> cls, py0 py0Var, fy0[] fy0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, py0Var, fy0VarArr, objArr)) == null) {
            if (fy0VarArr.length != 0 && objArr.length == fy0VarArr.length) {
                return update(iy0.b(cls).g(), ly0.c(fy0VarArr, objArr), py0Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(oy0 oy0Var, fy0... fy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, oy0Var, fy0VarArr)) == null) ? query(oy0Var, py0.j(b(oy0Var, fy0VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, fy0[] fy0VarArr, py0 py0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, fy0VarArr, py0Var)) == null) {
            return new ry0(this.b.rawQuery("SELECT " + ky0.d(fy0VarArr) + " FROM " + str + py0Var.k(), py0Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(oy0 oy0Var, py0 py0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, oy0Var, py0Var)) == null) ? update(oy0Var.b().g(), oy0Var.a(), py0Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, py0 py0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, py0Var)) == null) {
            return this.a.update(str, contentValues, py0Var != null ? py0Var.l() : null, py0Var != null ? py0Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(qy0 qy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, qy0Var)) == null) ? new ry0(this.b.rawQuery(qy0Var.b(), qy0Var.a())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, py0 py0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, py0Var)) == null) ? update(str, ly0.e(columnArr), py0Var) : invokeLLL.intValue;
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
