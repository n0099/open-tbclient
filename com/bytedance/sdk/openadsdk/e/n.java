package com.bytedance.sdk.openadsdk.e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.k.c.c;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n implements e<c.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.c f31261a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f31262b;

    public n(Context context) {
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
        this.f31262b = context;
        this.f31261a = com.bytedance.sdk.openadsdk.core.c.a(e());
    }

    private synchronized void b(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() - j;
                Context e2 = e();
                String c2 = c();
                com.bytedance.sdk.openadsdk.multipro.a.a.a(e2, c2, "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i2 + ""});
            }
        }
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            return "CREATE TABLE IF NOT EXISTS logstats (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "logstats" : (String) invokeV.objValue;
    }

    public Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Context context = this.f31262b;
            return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public List<c.a> a(int i2, String str) {
        InterceptResult invokeIL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, str)) == null) {
            if (i2 <= 0 || TextUtils.isEmpty(str)) {
                str2 = null;
            } else {
                str2 = str + " DESC limit " + i2;
            }
            String str3 = str2;
            LinkedList linkedList = new LinkedList();
            Cursor a2 = com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), new String[]{"id", "value"}, null, null, null, null, str3);
            if (a2 != null) {
                while (a2.moveToNext()) {
                    try {
                        try {
                            String string = a2.getString(a2.getColumnIndex("id"));
                            String string2 = a2.getString(a2.getColumnIndex("value"));
                            if (string2 == null) {
                                string2 = "";
                            }
                            linkedList.add(new c.a(string, new JSONObject(string2)));
                        } catch (Throwable unused) {
                        }
                    } finally {
                        if (a2 != null) {
                            a2.close();
                        }
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeIL.objValue;
    }

    @VisibleForTesting
    private synchronized void b(List<c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) {
            synchronized (this) {
                LinkedList linkedList = new LinkedList();
                for (c.a aVar : list) {
                    linkedList.add(aVar.f31391a);
                }
                com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "UPDATE " + c() + " SET " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " = " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + "+1 WHERE " + a("id", linkedList, 1000, true));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bytedance.sdk.openadsdk.e.e
    public synchronized void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            synchronized (this) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", aVar.f31391a);
                contentValues.put("value", aVar.f31392b != null ? aVar.f31392b.toString() : "");
                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, (Integer) 0);
                com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), c(), contentValues);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public synchronized void a(List<c.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            synchronized (this) {
                if (com.bytedance.sdk.component.utils.h.a(list)) {
                    return;
                }
                LinkedList linkedList = new LinkedList();
                for (c.a aVar : list) {
                    linkedList.add(aVar.f31391a);
                }
                com.bytedance.sdk.openadsdk.multipro.a.a.a(e(), "DELETE FROM " + c() + " WHERE " + a("id", linkedList, 1000, true));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f31261a.b("stats_serverbusy_retrycount", 0) : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public synchronized void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (this) {
                b(i2, j);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public synchronized void a(List<c.a> list, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            synchronized (this) {
                if (com.bytedance.sdk.component.utils.h.a(list)) {
                    return;
                }
                try {
                    b(list);
                    b(i2, j);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f31261a.a("stats_serverbusy_flag", z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f31261a.b("stats_serverbusy_flag", false) : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.e.e
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f31261a.a("stats_serverbusy_retrycount", i2);
        }
    }

    public static String a(String str, List<?> list, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, list, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            String str2 = z ? " IN " : " NOT IN ";
            String str3 = z ? " OR " : " AND ";
            int min = Math.min(i2, 1000);
            int size = list.size();
            if (size % min == 0) {
                i3 = size / min;
            } else {
                i3 = (size / min) + 1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * min;
                String a2 = a(TextUtils.join("','", list.subList(i5, Math.min(i5 + min, size))), "");
                if (i4 != 0) {
                    sb.append(str3);
                }
                sb.append(str);
                sb.append(str2);
                sb.append("('");
                sb.append(a2);
                sb.append("')");
            }
            String sb2 = sb.toString();
            return a(sb2, str + str2 + "('')");
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? !TextUtils.isEmpty(str) ? str : str2 : (String) invokeLL.objValue;
    }
}
