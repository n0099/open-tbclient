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
/* loaded from: classes4.dex */
public class ha implements XMPushService.l {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f471a;

    /* renamed from: a  reason: collision with other field name */
    public Context f472a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61158b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56373145, "Lcom/xiaomi/push/ha;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56373145, "Lcom/xiaomi/push/ha;");
        }
    }

    public ha(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f472a = context;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f472a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null) : (String) invokeL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.f61158b = com.xiaomi.push.service.aq.a(context).a(hk.ak.a(), true);
            int a2 = com.xiaomi.push.service.aq.a(context).a(hk.al.a(), 7200);
            this.f471a = a2;
            this.f471a = Math.max(60, a2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? Math.abs((System.currentTimeMillis() / 1000) - this.f472a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f471a) : invokeV.booleanValue;
    }

    private boolean a(he heVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, heVar)) == null) {
            if (!bg.b(this.f472a) || heVar == null || TextUtils.isEmpty(a(this.f472a.getPackageName())) || !new File(this.f472a.getFilesDir(), "tiny_data.data").exists() || a) {
                return false;
            }
            return !com.xiaomi.push.service.aq.a(this.f472a).a(hk.aV.a(), false) || i.m501a(this.f472a) || i.m504b(this.f472a);
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo434a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.f472a);
            if (this.f61158b && a()) {
                com.xiaomi.channel.commonutils.logger.b.m134a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
                he a2 = hd.a(this.f472a).a();
                if (a(a2)) {
                    a = true;
                    hb.a(this.f472a, a2);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m134a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }
}
