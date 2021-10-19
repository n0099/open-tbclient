package com.bytedance.sdk.openadsdk.p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class g implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f68697a;

    public g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68697a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.p.f
    public synchronized List<e> a() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                linkedList = new LinkedList();
                Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f68697a, "trackurl", null, null, null, null, null, null);
                if (a2 != null) {
                    while (a2.moveToNext()) {
                        linkedList.add(new e(a2.getString(a2.getColumnIndex("id")), a2.getString(a2.getColumnIndex("url")), a2.getInt(a2.getColumnIndex("replaceholder")) > 0, a2.getInt(a2.getColumnIndex(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM))));
                    }
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.p.f
    public synchronized void b(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            synchronized (this) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", eVar.a());
                contentValues.put("url", eVar.b());
                contentValues.put("replaceholder", Integer.valueOf(eVar.c() ? 1 : 0));
                contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, Integer.valueOf(eVar.d()));
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f68697a, "trackurl", contentValues, "id=?", new String[]{eVar.a()});
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.p.f
    public synchronized void c(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            synchronized (this) {
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f68697a, "trackurl", "id=?", new String[]{eVar.a()});
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return "CREATE TABLE IF NOT EXISTS trackurl (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,url TEXT ,replaceholder INTEGER default 0, " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.p.f
    public synchronized void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            synchronized (this) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", eVar.a());
                contentValues.put("url", eVar.b());
                contentValues.put("replaceholder", Integer.valueOf(eVar.c() ? 1 : 0));
                contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, Integer.valueOf(eVar.d()));
                com.bytedance.sdk.openadsdk.multipro.a.a.a(this.f68697a, "trackurl", contentValues);
            }
        }
    }
}
