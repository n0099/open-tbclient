package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
import java.io.File;
/* loaded from: classes6.dex */
public class ha implements XMPushService.l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f40517a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f466a;

    /* renamed from: a  reason: collision with other field name */
    public Context f467a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40518b;

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
        this.f467a = context;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f467a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null) : (String) invokeL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
            this.f40518b = com.xiaomi.push.service.aq.a(context).a(hk.ak.a(), true);
            int a2 = com.xiaomi.push.service.aq.a(context).a(hk.al.a(), 7200);
            this.f466a = a2;
            this.f466a = Math.max(60, a2);
        }
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f40517a = z;
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? Math.abs((System.currentTimeMillis() / 1000) - this.f467a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1L)) > ((long) this.f466a) : invokeV.booleanValue;
    }

    private boolean a(he heVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, heVar)) == null) {
            if (!bg.b(this.f467a) || heVar == null || TextUtils.isEmpty(a(this.f467a.getPackageName())) || !new File(this.f467a.getFilesDir(), "tiny_data.data").exists() || f40517a) {
                return false;
            }
            return !com.xiaomi.push.service.aq.a(this.f467a).a(hk.aV.a(), false) || i.m437a(this.f467a) || i.m440b(this.f467a);
        }
        return invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo370a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a(this.f467a);
            if (this.f40518b && a()) {
                com.xiaomi.channel.commonutils.logger.b.m70a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
                he a2 = hd.a(this.f467a).a();
                if (a(a2)) {
                    f40517a = true;
                    hb.a(this.f467a, a2);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.m70a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
            }
        }
    }
}
