package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/* loaded from: classes8.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<q> a;
    public String b;
    public String c;
    public String d;

    public t(List<q> list, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!HianalyticsHelper.DEAULT_HA_SERVICE_TAG.equals(this.c)) {
                a(this.a, this.c, this.b);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (q qVar : this.a) {
                String c = qVar.c();
                if (TextUtils.isEmpty(c) || "oper".equals(c)) {
                    arrayList4.add(qVar);
                } else if ("maint".equals(c)) {
                    arrayList.add(qVar);
                } else if ("preins".equals(c)) {
                    arrayList2.add(qVar);
                } else if ("diffprivacy".equals(c)) {
                    arrayList3.add(qVar);
                }
            }
            a(arrayList4, "oper", HianalyticsHelper.DEAULT_HA_SERVICE_TAG);
            a(arrayList, "maint", HianalyticsHelper.DEAULT_HA_SERVICE_TAG);
            a(arrayList2, "preins", HianalyticsHelper.DEAULT_HA_SERVICE_TAG);
            a(arrayList3, "diffprivacy", HianalyticsHelper.DEAULT_HA_SERVICE_TAG);
        }
    }

    public final void a(List<q> list, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str, str2) == null) || list.isEmpty()) {
            return;
        }
        int size = (list.size() / 500) + 1;
        for (int i = 0; i < size; i++) {
            int i2 = i * 500;
            List<q> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
            String replace = UUID.randomUUID().toString().replace("-", "");
            long currentTimeMillis = System.currentTimeMillis();
            long b = c.b(str2, str) * 86400000;
            ArrayList arrayList = new ArrayList();
            for (q qVar : subList) {
                if (!q0.a(qVar.b(), currentTimeMillis, b)) {
                    arrayList.add(qVar);
                }
            }
            if (arrayList.size() > 0) {
                new u(str2, str, this.d, arrayList, replace).a();
            } else {
                y.e("hmsSdk", "No data to report handler");
            }
        }
    }
}
