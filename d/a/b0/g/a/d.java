package d.a.b0.g.a;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41313a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41313a = false;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41313a : invokeV.booleanValue;
    }

    public abstract boolean b(SQLiteDatabase sQLiteDatabase);

    public void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) != null) {
            return;
        }
        this.f41313a = false;
        try {
            sQLiteDatabase.beginTransaction();
            if (b(sQLiteDatabase)) {
                sQLiteDatabase.setTransactionSuccessful();
                this.f41313a = true;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception unused3) {
        }
    }
}
