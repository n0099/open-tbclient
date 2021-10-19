package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.videocache.j;
import com.kwad.sdk.core.videocache.n;
/* loaded from: classes10.dex */
public class a extends SQLiteOpenHelper implements b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f72700a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528490600, "Lcom/kwad/sdk/core/videocache/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-528490600, "Lcom/kwad/sdk/core/videocache/d/a;");
                return;
            }
        }
        f72700a = new String[]{"_id", "url", CloudStabilityUBCUtils.KEY_LENGTH, "mime"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
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
        j.a(context);
    }

    private ContentValues a(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, nVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", nVar.f72746a);
            contentValues.put(CloudStabilityUBCUtils.KEY_LENGTH, Long.valueOf(nVar.f72747b));
            contentValues.put("mime", nVar.f72748c);
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    private n a(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cursor)) == null) ? new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(CloudStabilityUBCUtils.KEY_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow("mime"))) : (n) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.videocache.d.b
    public n a(String str) {
        InterceptResult invokeL;
        Throwable th;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return (n) invokeL.objValue;
        }
        j.a(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f72700a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return nVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.b
    public void a(String str, n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, nVar) == null) {
            j.a(str, nVar);
            boolean z = a(str) != null;
            ContentValues a2 = a(nVar);
            if (z) {
                getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
            } else {
                getWritableDatabase().insert("SourceInfo", null, a2);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            j.a(sQLiteDatabase);
            sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) {
            throw new IllegalStateException("Should not be called. There is no any migration");
        }
    }
}
