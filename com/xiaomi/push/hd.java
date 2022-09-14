package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes8.dex */
public class hd implements XMPushService.n {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f463a;

    /* renamed from: a  reason: collision with other field name */
    public Context f464a;
    public boolean b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56373052, "Lcom/xiaomi/push/hd;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56373052, "Lcom/xiaomi/push/hd;");
        }
    }

    public hd(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f464a = context;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f464a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null) : (String) invokeL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.b = com.xiaomi.push.service.ba.a(context).a(ho.ak.a(), true);
            int a2 = com.xiaomi.push.service.ba.a(context).a(ho.al.a(), 7200);
            this.f463a = a2;
            this.f463a = Math.max(60, a2);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            a = z;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? Math.abs((System.currentTimeMillis() / 1000) - this.f464a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f463a) : invokeV.booleanValue;
    }

    private boolean a(hh hhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, hhVar)) == null) {
            if (!bj.b(this.f464a) || hhVar == null || TextUtils.isEmpty(a(this.f464a.getPackageName())) || !new File(this.f464a.getFilesDir(), "tiny_data.data").exists() || a) {
                return false;
            }
            return !com.xiaomi.push.service.ba.a(this.f464a).a(ho.aV.a(), false) || j.m537a(this.f464a) || j.m539b(this.f464a);
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.n
    /* renamed from: a  reason: collision with other method in class */
    public void mo395a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hh a2 = hg.a(this.f464a).a();
            if (hi.a(this.f464a) && a2 != null) {
                hf.a(this.f464a, a2, com.xiaomi.push.service.ca.f965a);
                com.xiaomi.push.service.ca.a();
                com.xiaomi.channel.commonutils.logger.b.c("coord data upload");
            }
            a(this.f464a);
            if (this.b && a()) {
                com.xiaomi.channel.commonutils.logger.b.m90a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
                if (a(a2)) {
                    a = true;
                    he.a(this.f464a, a2);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m90a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }
}
