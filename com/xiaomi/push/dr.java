package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
/* loaded from: classes8.dex */
public class dr {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dr a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f231a;

    /* renamed from: a  reason: collision with other field name */
    public a f232a;

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public dr(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f231a = context;
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? Math.max(60, i) : invokeI.intValue;
    }

    public static dr a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (a == null) {
                synchronized (dr.class) {
                    if (a == null) {
                        a = new dr(context);
                    }
                }
            }
            return a;
        }
        return (dr) invokeL.objValue;
    }

    private void a(com.xiaomi.push.service.ba baVar, al alVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, baVar, alVar, z) == null) && baVar.a(ho.a.a(), true)) {
            dv dvVar = new dv(this.f231a);
            if (z) {
                alVar.a((al.a) dvVar, a(baVar.a(ho.b.a(), 86400)));
            } else {
                alVar.m167a((al.a) dvVar);
            }
        }
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            try {
                ((Application) (this.f231a instanceof Application ? this.f231a : this.f231a.getApplicationContext())).registerActivityLifecycleCallbacks(new dl(this.f231a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            al a2 = al.a(this.f231a);
            com.xiaomi.push.service.ba a3 = com.xiaomi.push.service.ba.a(this.f231a);
            SharedPreferences sharedPreferences = this.f231a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
            if (j == currentTimeMillis) {
                sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
            }
            if (Math.abs(currentTimeMillis - j) < 172800000) {
                return;
            }
            a(a3, a2, false);
            if (a3.a(ho.aI.a(), true)) {
                int a4 = a(a3.a(ho.aJ.a(), 86400));
                a2.a(new du(this.f231a, a4), a4, 0);
            }
            if (m.m562a(this.f231a) && (aVar = this.f232a) != null) {
                aVar.a();
            }
            if (a3.a(ho.ap.a(), false)) {
                a();
            }
            a(a3, a2, true);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m271a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            al.a(this.f231a).a(new ds(this));
        }
    }
}
