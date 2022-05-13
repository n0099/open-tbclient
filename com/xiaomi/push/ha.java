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
public class ha implements XMPushService.l {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f447a;

    /* renamed from: a  reason: collision with other field name */
    public Context f448a;
    public boolean b;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f448a = context;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f448a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null) : (String) invokeL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.b = com.xiaomi.push.service.aq.a(context).a(hk.ak.a(), true);
            int a2 = com.xiaomi.push.service.aq.a(context).a(hk.al.a(), 7200);
            this.f447a = a2;
            this.f447a = Math.max(60, a2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? Math.abs((System.currentTimeMillis() / 1000) - this.f448a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f447a) : invokeV.booleanValue;
    }

    private boolean a(he heVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, heVar)) == null) {
            if (!bg.b(this.f448a) || heVar == null || TextUtils.isEmpty(a(this.f448a.getPackageName())) || !new File(this.f448a.getFilesDir(), "tiny_data.data").exists() || a) {
                return false;
            }
            return !com.xiaomi.push.service.aq.a(this.f448a).a(hk.aV.a(), false) || i.m476a(this.f448a) || i.m479b(this.f448a);
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo409a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.f448a);
            if (this.b && a()) {
                com.xiaomi.channel.commonutils.logger.b.m109a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
                he a2 = hd.a(this.f448a).a();
                if (a(a2)) {
                    a = true;
                    hb.a(this.f448a, a2);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m109a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }
}
