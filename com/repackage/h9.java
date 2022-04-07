package com.repackage;

import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteMisuseException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g9;
import java.sql.SQLException;
/* loaded from: classes6.dex */
public class h9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;
    public g9.a b;
    public g9 c;

    public h9(g9 g9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = g9Var;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.a != null) {
                    this.a.close();
                    this.a = null;
                }
            } catch (Exception e) {
                BdLog.e("closeDatabase：" + e.getMessage());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        boolean dropDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (h9.class) {
                a();
                try {
                    dropDatabase = this.c.dropDatabase(BdBaseApplication.getInst().getContext());
                } catch (Exception e) {
                    BdLog.e("deleteDatabase：" + e.getMessage());
                    this.a = null;
                    return false;
                }
            }
            return dropDatabase;
        }
        return invokeV.booleanValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (h9.class) {
                if (this.a == null || !this.a.isOpen()) {
                    try {
                        this.c.setOnCreateCallback(this.b);
                        this.a = this.c.getWritableDatabase();
                    } catch (RuntimeException e) {
                        if (z) {
                            i(e, "ensureDatabaseReady");
                        } else {
                            throw e;
                        }
                    }
                }
            }
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SQLiteDatabase f = f();
            if (f != null) {
                try {
                    f.execSQL(str);
                    return true;
                } catch (Throwable th) {
                    i(th, "execSQLNoException:" + str);
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str, Object[] objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, objArr)) == null) {
            SQLiteDatabase f = f();
            if (f != null) {
                try {
                    f.execSQL(str, objArr);
                    return true;
                } catch (Throwable th) {
                    i(th, "execSQLNoException:" + str);
                    return false;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public SQLiteDatabase f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? g(true) : (SQLiteDatabase) invokeV.objValue;
    }

    public SQLiteDatabase g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            c(z);
            return this.a;
        }
        return (SQLiteDatabase) invokeZ.objValue;
    }

    public void h(String str, int i, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048583, this, str, i, str2, objArr) == null) {
            try {
                BdStatisticsManager.getInstance().db(str, "", i, str2, objArr);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void i(Throwable th, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, th, str) == null) && th != null && (th instanceof SQLiteException)) {
            int i = -17;
            if (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException) {
                BdLog.w("database corrupted. recreate!");
                try {
                    b();
                } catch (Throwable th2) {
                    BdLog.detailException("failed to drop database. msg:", th2);
                }
                i = -14;
                this.a = null;
            } else if (th instanceof SQLiteAbortException) {
                i = -11;
            } else if (th instanceof SQLiteConstraintException) {
                i = -12;
            } else if (th instanceof SQLiteDiskIOException) {
                i = -15;
                this.a = null;
            } else if (th instanceof SQLiteFullException) {
                i = -16;
                this.a = null;
            } else if (th instanceof SQLiteDoneException) {
                i = -19;
                this.a = null;
            } else if (!(th instanceof SQLiteMisuseException)) {
                this.a = null;
            }
            h(str, i, th.getMessage(), new Object[0]);
        }
    }

    public Cursor j(String str, String[] strArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, strArr)) == null) {
            SQLiteDatabase g = g(false);
            if (g != null) {
                return g.rawQuery(str, strArr);
            }
            throw new SQLException("unable to open database.");
        }
        return (Cursor) invokeLL.objValue;
    }

    public void k(g9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
