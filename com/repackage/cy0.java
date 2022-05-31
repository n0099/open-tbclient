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
import com.repackage.dy0;
/* loaded from: classes5.dex */
public class cy0 implements dy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public cy0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.repackage.dy0
    public dy0.a a(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, ky0Var, by0VarArr)) != null) {
            return (dy0.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(ky0Var, by0VarArr);
            r0 = i == 0 ? insert(ky0Var) : 0L;
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
            return new dy0.a(r0, i);
        }
    }

    public final Column[] b(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ky0Var, by0VarArr)) == null) {
            if (by0VarArr.length > 0) {
                return hy0.d(ky0Var, by0VarArr);
            }
            return hy0.d(ky0Var, ky0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.repackage.dy0
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

    public int delete(String str, ly0 ly0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, ly0Var)) == null) ? this.a.delete(str, ly0Var.l(), ly0Var.e()) : invokeLL.intValue;
    }

    @Override // com.repackage.dy0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(ky0 ky0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ky0Var)) == null) {
            jy0 b = ky0Var.b();
            String g = b.g();
            by0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, ky0Var.a());
            }
            Column column = hy0.d(ky0Var, f[0])[0];
            boolean l = hy0.l(column);
            if (l && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + ky0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, ky0Var.a());
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

    public boolean query(ky0 ky0Var, ly0 ly0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, ky0Var, ly0Var)) == null) {
            ny0 ny0Var = new ny0(this.b.rawQuery("SELECT " + gy0.d(ky0Var.b().d()) + " FROM " + ky0Var.b().g() + ly0Var.k(), ly0Var.e()));
            boolean moveToFirst = ny0Var.moveToFirst();
            if (moveToFirst) {
                iy0.a(ny0Var, ky0Var);
            }
            ny0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.dy0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.repackage.dy0
    public int update(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, ky0Var, by0VarArr)) == null) {
            String g = ky0Var.b().g();
            ly0 j = ly0.j(b(ky0Var, by0VarArr));
            return this.a.update(g, ky0Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public int delete(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, ky0Var, by0VarArr)) == null) {
            String g = ky0Var.b().g();
            Column[] b = b(ky0Var, by0VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, ly0.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cy0(SQLiteDatabase sQLiteDatabase) {
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

    public int update(Class<? extends ky0> cls, ly0 ly0Var, by0[] by0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, ly0Var, by0VarArr, objArr)) == null) {
            if (by0VarArr.length != 0 && objArr.length == by0VarArr.length) {
                return update(ey0.b(cls).g(), hy0.c(by0VarArr, objArr), ly0Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(ky0 ky0Var, by0... by0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, ky0Var, by0VarArr)) == null) ? query(ky0Var, ly0.j(b(ky0Var, by0VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, by0[] by0VarArr, ly0 ly0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, by0VarArr, ly0Var)) == null) {
            return new ny0(this.b.rawQuery("SELECT " + gy0.d(by0VarArr) + " FROM " + str + ly0Var.k(), ly0Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(ky0 ky0Var, ly0 ly0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, ky0Var, ly0Var)) == null) ? update(ky0Var.b().g(), ky0Var.a(), ly0Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, ly0 ly0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, ly0Var)) == null) {
            return this.a.update(str, contentValues, ly0Var != null ? ly0Var.l() : null, ly0Var != null ? ly0Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(my0 my0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, my0Var)) == null) ? new ny0(this.b.rawQuery(my0Var.b(), my0Var.a())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, ly0 ly0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, ly0Var)) == null) ? update(str, hy0.e(columnArr), ly0Var) : invokeLLL.intValue;
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
