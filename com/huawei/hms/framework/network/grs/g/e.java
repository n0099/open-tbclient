package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ JSONArray c;

        public a(long j, ArrayList arrayList, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), arrayList, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = arrayList;
            this.c = jSONArray;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                com.huawei.hms.framework.network.grs.g.k.a aVar = new com.huawei.hms.framework.network.grs.g.k.a();
                aVar.put("total_time", this.a);
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (dVar.o() || dVar.m()) {
                        aVar.put(e.b(dVar));
                        it.remove();
                        z = true;
                        break;
                    }
                    while (it.hasNext()) {
                    }
                }
                z = false;
                if (!z && this.b.size() > 0) {
                    ArrayList arrayList = this.b;
                    d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                    aVar.put(e.b(dVar2));
                    this.b.remove(dVar2);
                }
                if (this.b.size() > 0) {
                    Iterator it2 = this.b.iterator();
                    while (it2.hasNext()) {
                        this.c.put(new JSONObject(e.b((d) it2.next())));
                    }
                }
                if (this.c.length() > 0) {
                    aVar.put("failed_info", this.c.toString());
                }
                Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
                HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
            }
        }
    }

    public static void a(ArrayList<d> arrayList, long j, JSONArray jSONArray, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{arrayList, Long.valueOf(j), jSONArray, context}) == null) || context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
    }

    public static LinkedHashMap<String, String> b(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
            Exception d = dVar.d();
            if (d != null) {
                linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(d));
                linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, d.getClass().getSimpleName());
                linkedHashMapPack.put("message", StringUtils.anonymizeMessage(d.getMessage()));
            } else {
                linkedHashMapPack.put("error_code", dVar.b());
                linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.c());
            }
            try {
                linkedHashMapPack.put("domain", new URL(dVar.l()).getHost());
            } catch (MalformedURLException e) {
                Logger.w("HaReportHelper", "report host MalformedURLException", e);
            }
            linkedHashMapPack.put("req_start_time", dVar.h());
            linkedHashMapPack.put("req_end_time", dVar.g());
            linkedHashMapPack.put("req_total_time", dVar.i());
            return linkedHashMapPack.getAll();
        }
        return (LinkedHashMap) invokeL.objValue;
    }
}
