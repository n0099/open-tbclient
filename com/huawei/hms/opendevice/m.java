package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tieba.ola;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;
/* loaded from: classes8.dex */
public class m extends Thread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean b;
        boolean d;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!p.b()) {
                HMSLog.d("ReportAaidToken", "Not HW Phone.");
                return;
            }
            b = n.b(this.a);
            if (b) {
                return;
            }
            String a = o.a(this.a);
            if (TextUtils.isEmpty(a)) {
                HMSLog.w("ReportAaidToken", "AAID is empty.");
                return;
            }
            d = n.d(this.a, a, this.b);
            if (!d) {
                HMSLog.d("ReportAaidToken", "This time need not report.");
                return;
            }
            String a2 = ola.c(this.a).a("region");
            if (TextUtils.isEmpty(a2)) {
                HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                return;
            }
            String a3 = e.a(this.a, "com.huawei.hms.opendevicesdk", "ROOT", null, a2);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            c = n.c(this.a, a, this.b);
            Context context = this.a;
            n.b(this.a, d.a(context, a3 + "/rest/appdata/v1/aaid/report", c, (Map<String, String>) null), a, this.b);
        }
    }
}
