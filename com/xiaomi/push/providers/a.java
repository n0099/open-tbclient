package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.channel.commonutils.logger.b;
import com.yy.hiidostatis.inner.BaseStatisContent;
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f71359a = 1;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f831a;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f832a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1887084510, "Lcom/xiaomi/push/providers/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1887084510, "Lcom/xiaomi/push/providers/a;");
                return;
            }
        }
        f831a = new Object();
        f832a = new String[]{"package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", BaseStatisContent.IMSI, "TEXT"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f71359a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sQLiteDatabase) == null) {
            StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
            for (int i2 = 0; i2 < f832a.length - 1; i2 += 2) {
                if (i2 != 0) {
                    sb.append(",");
                }
                sb.append(f832a[i2]);
                sb.append(" ");
                sb.append(f832a[i2 + 1]);
            }
            sb.append(");");
            sQLiteDatabase.execSQL(sb.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            synchronized (f831a) {
                try {
                    a(sQLiteDatabase);
                } catch (SQLException e2) {
                    b.a(e2);
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase, i2, i3) == null) {
        }
    }
}
