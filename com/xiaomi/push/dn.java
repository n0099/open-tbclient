package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
/* loaded from: classes8.dex */
public class dn {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile dn f42968a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f240a;

    public dn(Context context) {
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
        this.f240a = context;
    }

    private int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? Math.max(60, i2) : invokeI.intValue;
    }

    public static dn a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f42968a == null) {
                synchronized (dn.class) {
                    if (f42968a == null) {
                        f42968a = new dn(context);
                    }
                }
            }
            return f42968a;
        }
        return (dn) invokeL.objValue;
    }

    private void a(com.xiaomi.push.service.aq aqVar, ai aiVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(65540, this, aqVar, aiVar, z) == null) && aqVar.a(hk.f43266a.a(), true)) {
            ds dsVar = new ds(this.f240a);
            if (z) {
                aiVar.a((ai.a) dsVar, a(aqVar.a(hk.f43267b.a(), 86400)));
            } else {
                aiVar.m142a((ai.a) dsVar);
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    ((Application) (this.f240a instanceof Application ? this.f240a : this.f240a.getApplicationContext())).registerActivityLifecycleCallbacks(new dh(this.f240a, String.valueOf(System.currentTimeMillis() / 1000)));
                    return true;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            ai a2 = ai.a(this.f240a);
            com.xiaomi.push.service.aq a3 = com.xiaomi.push.service.aq.a(this.f240a);
            SharedPreferences sharedPreferences = this.f240a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
            if (j == currentTimeMillis) {
                sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
            }
            if (Math.abs(currentTimeMillis - j) < 172800000) {
                return;
            }
            a(a3, a2, false);
            if (a3.a(hk.aI.a(), true)) {
                int a4 = a(a3.a(hk.aJ.a(), 86400));
                a2.a(new dr(this.f240a, a4), a4, 0);
            }
            boolean a5 = a3.a(hk.aO.a(), false);
            String a6 = a3.a(hk.aQ.a(), (String) null);
            if (a5 && !TextUtils.isEmpty(a6)) {
                int a7 = a(a3.a(hk.aP.a(), 86400));
                a2.a(new dp(this.f240a, a7, a6), a7, 0);
            }
            if (a3.a(hk.ap.a(), false)) {
                a();
            }
            a(a3, a2, true);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m247a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ai.a(this.f240a).a(new Cdo(this));
        }
    }
}
