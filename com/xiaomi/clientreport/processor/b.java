package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.PerformerBox;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bq;
import java.io.File;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements IPerfProcessor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f77605a;

    /* renamed from: a  reason: collision with other field name */
    public HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f47a;

    public b(Context context) {
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
        this.f77605a = context;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
            return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
        }
        return (String) invokeL.objValue;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            int i2 = aVar.production;
            String str2 = aVar.clientInterfaceId;
            if (i2 <= 0 || TextUtils.isEmpty(str2)) {
                str = "";
            } else {
                str = String.valueOf(i2) + "#" + str2;
            }
            File externalFilesDir = this.f77605a.getExternalFilesDir(PerformerBox.TYPE);
            if (externalFilesDir == null) {
                com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
                return null;
            }
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            return new File(externalFilesDir, str).getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            String b2 = b(aVar);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            for (int i2 = 0; i2 < 20; i2++) {
                String str = b2 + i2;
                if (bq.m189a(this.f77605a, str)) {
                    return str;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bq.a(this.f77605a, PerformerBox.TYPE, "perfUploading");
            File[] m190a = bq.m190a(this.f77605a, "perfUploading");
            if (m190a == null || m190a.length <= 0) {
                return;
            }
            for (File file : m190a) {
                if (file != null) {
                    List<String> a2 = e.a(this.f77605a, file.getAbsolutePath());
                    file.delete();
                    a(a2);
                }
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo81a(com.xiaomi.clientreport.data.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && (aVar instanceof PerfClientReport) && this.f47a != null) {
            PerfClientReport perfClientReport = (PerfClientReport) aVar;
            String a2 = a((com.xiaomi.clientreport.data.a) perfClientReport);
            String a3 = e.a(perfClientReport);
            HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f47a.get(a2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a3);
            if (perfClientReport2 != null) {
                perfClientReport.perfCounts += perfClientReport2.perfCounts;
                perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
            }
            hashMap.put(a3, perfClientReport);
            this.f47a.put(a2, hashMap);
        }
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            bq.a(this.f77605a, list);
        }
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVarArr) == null) {
            String c2 = c(aVarArr[0]);
            if (TextUtils.isEmpty(c2)) {
                return;
            }
            e.a(c2, aVarArr);
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hashMap = this.f47a) == null) {
            return;
        }
        if (hashMap.size() > 0) {
            for (String str : this.f47a.keySet()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f47a.get(str);
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f47a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.f47a = hashMap;
        }
    }
}
