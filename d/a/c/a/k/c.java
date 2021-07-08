package d.a.c.a.k;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.k.a;
/* loaded from: classes6.dex */
public abstract class c extends SQLiteOpenHelper implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0543a callback;
    public final String databaseName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, String str, int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.databaseName = str;
    }

    private void exeCallback(SQLiteDatabase sQLiteDatabase) {
        a.InterfaceC0543a interfaceC0543a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, sQLiteDatabase) == null) || (interfaceC0543a = this.callback) == null) {
            return;
        }
        interfaceC0543a.a(sQLiteDatabase);
    }

    public abstract void clearAllTables(SQLiteDatabase sQLiteDatabase);

    public abstract void createAllTables(SQLiteDatabase sQLiteDatabase);

    @Override // d.a.c.a.k.a
    public boolean dropDatabase(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? context.deleteDatabase(this.databaseName) : invokeL.booleanValue;
    }

    public boolean executeDDLSqlIgnoreAnyErrors(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, sQLiteDatabase, str)) == null) {
            try {
                sQLiteDatabase.execSQL(str);
                return true;
            } catch (Throwable th) {
                BdLog.e(str + ":" + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            createAllTables(sQLiteDatabase);
            exeCallback(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, sQLiteDatabase, i2, i3) == null) {
            clearAllTables(sQLiteDatabase);
            createAllTables(sQLiteDatabase);
        }
    }

    @Override // d.a.c.a.k.a
    public void setOnCreateCallback(a.InterfaceC0543a interfaceC0543a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0543a) == null) {
            this.callback = interfaceC0543a;
        }
    }
}
