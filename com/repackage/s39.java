package com.repackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class s39 {
    public static /* synthetic */ Interceptable $ic;
    public static s39 c;
    public static SQLiteOpenHelper d;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicInteger a;
    public SQLiteDatabase b;

    public s39() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger();
    }

    public static synchronized s39 a() {
        InterceptResult invokeV;
        s39 s39Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (s39.class) {
                if (c == null) {
                    b(n39.h().getContext());
                }
                s39Var = c;
            }
            return s39Var;
        }
        return (s39) invokeV.objValue;
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (s39.class) {
                if (c == null) {
                    c = new s39();
                    d = new q39(context);
                }
            }
        }
    }

    public final synchronized SQLiteDatabase c() {
        InterceptResult invokeV;
        SQLiteDatabase sQLiteDatabase;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.a.incrementAndGet() == 1) {
                    o49.a("***************新建立了 一个数据库的实例****************");
                    this.b = d.getWritableDatabase();
                }
                sQLiteDatabase = this.b;
            }
            return sQLiteDatabase;
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
