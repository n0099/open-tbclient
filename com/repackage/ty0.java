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
import com.repackage.uy0;
/* loaded from: classes7.dex */
public class ty0 implements uy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SQLiteDatabase a;
    public final SQLiteDatabase b;

    public ty0(SQLiteDatabase sQLiteDatabase, SQLiteDatabase sQLiteDatabase2) {
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

    @Override // com.repackage.uy0
    public uy0.a a(bz0 bz0Var, sy0... sy0VarArr) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, bz0Var, sy0VarArr)) != null) {
            return (uy0.a) invokeLL.objValue;
        }
        try {
            this.a.beginTransaction();
            i = update(bz0Var, sy0VarArr);
            r0 = i == 0 ? insert(bz0Var) : 0L;
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
            return new uy0.a(r0, i);
        }
    }

    public final Column[] b(bz0 bz0Var, sy0... sy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bz0Var, sy0VarArr)) == null) {
            if (sy0VarArr.length > 0) {
                return yy0.d(bz0Var, sy0VarArr);
            }
            return yy0.d(bz0Var, bz0Var.b().f());
        }
        return (Column[]) invokeLL.objValue;
    }

    @Override // com.repackage.uy0
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

    public int delete(String str, cz0 cz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, cz0Var)) == null) ? this.a.delete(str, cz0Var.l(), cz0Var.e()) : invokeLL.intValue;
    }

    @Override // com.repackage.uy0
    public void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.endTransaction();
        }
    }

    public long insert(bz0 bz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bz0Var)) == null) {
            az0 b = bz0Var.b();
            String g = b.g();
            sy0[] f = b.f();
            if (f.length != 1) {
                return this.a.insert(g, null, bz0Var.a());
            }
            Column column = yy0.d(bz0Var, f[0])[0];
            boolean l = yy0.l(column);
            if (l && column.isAssignedValue) {
                throw new IllegalArgumentException("Model " + bz0Var.getClass().toString() + " has a primary auto increment key with value.");
            }
            long insert = this.a.insert(g, null, bz0Var.a());
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

    public boolean query(bz0 bz0Var, cz0 cz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, bz0Var, cz0Var)) == null) {
            ez0 ez0Var = new ez0(this.b.rawQuery("SELECT " + xy0.d(bz0Var.b().d()) + " FROM " + bz0Var.b().g() + cz0Var.k(), cz0Var.e()));
            boolean moveToFirst = ez0Var.moveToFirst();
            if (moveToFirst) {
                zy0.a(ez0Var, bz0Var);
            }
            ez0Var.close();
            return moveToFirst;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.uy0
    public void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a.setTransactionSuccessful();
        }
    }

    @Override // com.repackage.uy0
    public int update(bz0 bz0Var, sy0... sy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, bz0Var, sy0VarArr)) == null) {
            String g = bz0Var.b().g();
            cz0 j = cz0.j(b(bz0Var, sy0VarArr));
            return this.a.update(g, bz0Var.a(), j.l(), j.e());
        }
        return invokeLL.intValue;
    }

    public int delete(bz0 bz0Var, sy0... sy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bz0Var, sy0VarArr)) == null) {
            String g = bz0Var.b().g();
            Column[] b = b(bz0Var, sy0VarArr);
            int length = b.length;
            for (int i = 0; i < length; i++) {
                if (!c(b[i])) {
                    throw new IllegalArgumentException("delete operation must have all 'key' columns with explicit value.");
                }
            }
            return delete(g, cz0.j(b));
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ty0(SQLiteDatabase sQLiteDatabase) {
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

    public int update(Class<? extends bz0> cls, cz0 cz0Var, sy0[] sy0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048592, this, cls, cz0Var, sy0VarArr, objArr)) == null) {
            if (sy0VarArr.length != 0 && objArr.length == sy0VarArr.length) {
                return update(vy0.b(cls).g(), yy0.c(sy0VarArr, objArr), cz0Var);
            }
            throw new IllegalArgumentException("columns and values must have equal number.");
        }
        return invokeLLLL.intValue;
    }

    public boolean query(bz0 bz0Var, sy0... sy0VarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, bz0Var, sy0VarArr)) == null) ? query(bz0Var, cz0.j(b(bz0Var, sy0VarArr))) : invokeLL.booleanValue;
    }

    public Cursor query(String str, sy0[] sy0VarArr, cz0 cz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, str, sy0VarArr, cz0Var)) == null) {
            return new ez0(this.b.rawQuery("SELECT " + xy0.d(sy0VarArr) + " FROM " + str + cz0Var.k(), cz0Var.e()));
        }
        return (Cursor) invokeLLL.objValue;
    }

    public int update(bz0 bz0Var, cz0 cz0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bz0Var, cz0Var)) == null) ? update(bz0Var.b().g(), bz0Var.a(), cz0Var) : invokeLL.intValue;
    }

    public int update(String str, ContentValues contentValues, cz0 cz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, str, contentValues, cz0Var)) == null) {
            return this.a.update(str, contentValues, cz0Var != null ? cz0Var.l() : null, cz0Var != null ? cz0Var.e() : null);
        }
        return invokeLLL.intValue;
    }

    public Cursor query(dz0 dz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, dz0Var)) == null) ? new ez0(this.b.rawQuery(dz0Var.b(), dz0Var.a())) : (Cursor) invokeL.objValue;
    }

    public int update(String str, Column[] columnArr, cz0 cz0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, str, columnArr, cz0Var)) == null) ? update(str, yy0.e(columnArr), cz0Var) : invokeLLL.intValue;
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
