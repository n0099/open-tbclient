package com.dxmpay.apollon.statistics.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class MyDb extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase mDb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyDb(Context context, String str, int i2) {
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
        try {
            this.mDb = getWritableDatabase();
        } catch (SQLiteException e2) {
            this.mDb = null;
            e2.printStackTrace();
        }
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, sQLiteDatabase, str, str2) == null) {
            sQLiteDatabase.execSQL("create table if not exists " + str + " (" + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.isOpen()) {
                    this.mDb.close();
                }
                this.mDb = null;
            }
            super.finalize();
        }
    }

    public static void createTable(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, sQLiteDatabase, str, strArr) == null) {
            StringBuilder sb = new StringBuilder("create table if not exists ");
            sb.append(str);
            sb.append(" (");
            for (String str2 : strArr) {
                sb.append(str2);
                sb.append(",");
            }
            int length = sb.length();
            sb.replace(length - 1, length, SmallTailInfo.EMOTION_SUFFIX);
            sQLiteDatabase.execSQL(sb.toString());
        }
    }
}
