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
import com.repackage.ty0;
/* loaded from: classes7.dex */
public class sy0 implements ty0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public sy0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.repackage.ty0
    public ty0.a a(az0 az0Var, ry0... ry0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, az0Var, ry0VarArr)) != null) {
            return (ty0.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(az0Var, ry0VarArr);
            r0 = i == 0 ? insert(az0Var) : 0L;
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
            return new ty0.a(r0, i);
        }
    }

    public final Column[] b(az0 az0Var, ry0... ry0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, az0Var, ry0VarArr)) == null) {
            if (ry0VarArr.length > 0) {
                return xy0.d(az0Var, ry0VarArr);
            }
            return xy0.d(az0Var, az0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.repackage.ty0
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

    public int delete(String str, bz0 bz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, bz0Var)) == null) ? this.a.delete(str, bz0Var.l(), bz0Var.e()) : invokeLL.intValue;
    }

    @Override // com.repackage.ty0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(az0 az0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, az0Var)) == null) {
            zy0 b = az0Var.b();
            String g = b.g();
            ry0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, az0Var.a());
            }
            Column column = xy0.d(az0Var, f[0])[0];
            boolean l = xy0.l(column);
            if (l && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + az0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, az0Var.a());
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

    public boolean query(az0 az0Var, bz0 bz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, az0Var, bz0Var)) == null) {
            dz0 dz0Var = new dz0(this.b.rawQuery("SELECT " + wy0.d(az0Var.b().d()) + " FROM " + az0Var.b().g() + bz0Var.k(), bz0Var.e()));
            boolean moveToFirst = dz0Var.moveToFirst();
            if (moveToFirst) {
                yy0.a(dz0Var, az0Var);
            }
            dz0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.ty0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.repackage.ty0
    public int update(az0 az0Var, ry0... ry0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, az0Var, ry0VarArr)) == null) {
            String g = az0Var.b().g();
            bz0 j = bz0.j(b(az0Var, ry0VarArr));
            return this.a.update(g, az0Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public int delete(az0 az0Var, ry0... ry0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, az0Var, ry0VarArr)) == null) {
            String g = az0Var.b().g();
            Column[] b = b(az0Var, ry0VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, bz0.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sy0(SQLiteDatabase sQLiteDatabase) {
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

    public int update(Class<? extends az0> cls, bz0 bz0Var, ry0[] ry0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, bz0Var, ry0VarArr, objArr)) == null) {
            if (ry0VarArr.length != 0 && objArr.length == ry0VarArr.length) {
                return update(uy0.b(cls).g(), xy0.c(ry0VarArr, objArr), bz0Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(az0 az0Var, ry0... ry0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, az0Var, ry0VarArr)) == null) ? query(az0Var, bz0.j(b(az0Var, ry0VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, ry0[] ry0VarArr, bz0 bz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, ry0VarArr, bz0Var)) == null) {
            return new dz0(this.b.rawQuery("SELECT " + wy0.d(ry0VarArr) + " FROM " + str + bz0Var.k(), bz0Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(az0 az0Var, bz0 bz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, az0Var, bz0Var)) == null) ? update(az0Var.b().g(), az0Var.a(), bz0Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, bz0 bz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, bz0Var)) == null) {
            return this.a.update(str, contentValues, bz0Var != null ? bz0Var.l() : null, bz0Var != null ? bz0Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(cz0 cz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cz0Var)) == null) ? new dz0(this.b.rawQuery(cz0Var.b(), cz0Var.a())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, bz0 bz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, bz0Var)) == null) ? update(str, xy0.e(columnArr), bz0Var) : invokeLLL.intValue;
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
