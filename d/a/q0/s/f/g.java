package d.a.q0.s.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context, "relationship.db", (SQLiteDatabase.CursorFactory) null, 4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            try {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (TextUtils.isEmpty(currentAccount)) {
                    return;
                }
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT, location_time LONG, user_type INT);");
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDbHelper.createTables", new Object[0]);
                BdLog.e("create table wrong " + e2.toString());
            }
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            try {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (TextUtils.isEmpty(currentAccount)) {
                    return;
                }
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "RelationshipDbHelper.dropTables", new Object[0]);
                BdLog.e("drop table wrong " + e2.toString());
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            a(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
            b(sQLiteDatabase);
            a(sQLiteDatabase);
            try {
                MessageManager.getInstance().sendMessageFromBackground(new RequestGetAddressListMessage(304001));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
