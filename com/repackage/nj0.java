package com.repackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.sweetsqlite.Column;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qz0;
/* loaded from: classes6.dex */
public class nj0 extends pz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nj0(SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sQLiteDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((SQLiteDatabase) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.pz0, com.repackage.qz0
    public synchronized qz0.a a(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        qz0.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xz0Var, oz0VarArr)) == null) {
            synchronized (this) {
                a = super.a(xz0Var, oz0VarArr);
            }
            return a;
        }
        return (qz0.a) invokeLL.objValue;
    }

    @Override // com.repackage.pz0, com.repackage.qz0
    public synchronized void beginTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                super.beginTransaction();
            }
        }
    }

    @Override // com.repackage.pz0
    public synchronized int delete(String str, yz0 yz0Var) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, yz0Var)) == null) {
            synchronized (this) {
                delete = super.delete(str, yz0Var);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.repackage.pz0, com.repackage.qz0
    public synchronized void endTransaction() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                super.endTransaction();
            }
        }
    }

    @Override // com.repackage.pz0
    public synchronized long insert(xz0 xz0Var) {
        InterceptResult invokeL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xz0Var)) == null) {
            synchronized (this) {
                insert = super.insert(xz0Var);
            }
            return insert;
        }
        return invokeL.longValue;
    }

    @Override // com.repackage.pz0
    public synchronized boolean query(xz0 xz0Var, yz0 yz0Var) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, xz0Var, yz0Var)) == null) {
            synchronized (this) {
                query = super.query(xz0Var, yz0Var);
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.pz0, com.repackage.qz0
    public synchronized void setTransactionSuccessful() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                super.setTransactionSuccessful();
            }
        }
    }

    @Override // com.repackage.pz0, com.repackage.qz0
    public synchronized int update(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, xz0Var, oz0VarArr)) == null) {
            synchronized (this) {
                update = super.update(xz0Var, oz0VarArr);
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.repackage.pz0
    public synchronized int delete(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xz0Var, oz0VarArr)) == null) {
            synchronized (this) {
                delete = super.delete(xz0Var, oz0VarArr);
            }
            return delete;
        }
        return invokeLL.intValue;
    }

    @Override // com.repackage.pz0
    public synchronized long insert(String str, String[] strArr, Object... objArr) {
        InterceptResult invokeLLL;
        long insert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, strArr, objArr)) == null) {
            synchronized (this) {
                insert = super.insert(str, strArr, objArr);
            }
            return insert;
        }
        return invokeLLL.longValue;
    }

    @Override // com.repackage.pz0
    public synchronized boolean query(xz0 xz0Var, oz0... oz0VarArr) {
        InterceptResult invokeLL;
        boolean query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, xz0Var, oz0VarArr)) == null) {
            synchronized (this) {
                query = super.query(xz0Var, oz0VarArr);
            }
            return query;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.pz0
    public synchronized int update(Class<? extends xz0> cls, yz0 yz0Var, oz0[] oz0VarArr, Object... objArr) {
        InterceptResult invokeLLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, cls, yz0Var, oz0VarArr, objArr)) == null) {
            synchronized (this) {
                update = super.update(cls, yz0Var, oz0VarArr, objArr);
            }
            return update;
        }
        return invokeLLLL.intValue;
    }

    @Override // com.repackage.pz0
    public synchronized Cursor query(String str, oz0[] oz0VarArr, yz0 yz0Var) {
        InterceptResult invokeLLL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, oz0VarArr, yz0Var)) == null) {
            synchronized (this) {
                query = super.query(str, oz0VarArr, yz0Var);
            }
            return query;
        }
        return (Cursor) invokeLLL.objValue;
    }

    @Override // com.repackage.pz0
    public synchronized int update(xz0 xz0Var, yz0 yz0Var) {
        InterceptResult invokeLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, xz0Var, yz0Var)) == null) {
            synchronized (this) {
                update = super.update(xz0Var, yz0Var);
            }
            return update;
        }
        return invokeLL.intValue;
    }

    @Override // com.repackage.pz0
    public synchronized Cursor query(zz0 zz0Var) {
        InterceptResult invokeL;
        Cursor query;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zz0Var)) == null) {
            synchronized (this) {
                query = super.query(zz0Var);
            }
            return query;
        }
        return (Cursor) invokeL.objValue;
    }

    @Override // com.repackage.pz0
    public synchronized int update(String str, ContentValues contentValues, yz0 yz0Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, str, contentValues, yz0Var)) == null) {
            synchronized (this) {
                update = super.update(str, contentValues, yz0Var);
            }
            return update;
        }
        return invokeLLL.intValue;
    }

    @Override // com.repackage.pz0
    public synchronized int update(String str, Column[] columnArr, yz0 yz0Var) {
        InterceptResult invokeLLL;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, str, columnArr, yz0Var)) == null) {
            synchronized (this) {
                update = super.update(str, columnArr, yz0Var);
            }
            return update;
        }
        return invokeLLL.intValue;
    }
}
