package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʽˈ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0360 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0360 f192;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f193;

    /* renamed from: com.kuaishou.weapon.p0.ʽˈ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0361 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ int f194;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ C0360 f195;

        public RunnableC0361(C0360 c0360, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0360, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f195 = c0360;
            this.f194 = i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v14 int)] */
        @Override // java.lang.Runnable
        public void run() {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f195.f193);
                    if (m389.m392(C0374.f332, 0) == 1) {
                        long m418 = m389.m418(C0374.f270);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m392 = m389.m392(C0374.f316, 8) * 3600000;
                        int m3922 = m389.m392(C0374.f317, 0);
                        if (m418 > 0) {
                            j = m418;
                            if (currentTimeMillis - m418 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                int hours = new Date(currentTimeMillis).getHours();
                                List<Integer> list = WeaponHI.isList;
                                StringBuilder sb = new StringBuilder();
                                sb.append(hours);
                                if (list.contains(sb.toString())) {
                                    return;
                                }
                            }
                        } else {
                            j = m418;
                        }
                        if (currentTimeMillis - j >= m392 || this.f194 == 106 || (this.f194 == 100 && m3922 == 1)) {
                            C0336.m283(this.f195.f193, new C0328(this.f195.f193, this.f194).m241(C0331.f84), C0331.f84, false, true);
                            m389.m412(C0374.f270, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0360(Context context) {
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
        this.f193 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0360 m369(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f192 == null) {
                synchronized (C0360.class) {
                    if (f192 == null) {
                        f192 = new C0360(context);
                    }
                }
            }
            return f192;
        }
        return (C0360) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m370(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            C0358.m366().m367(new RunnableC0361(this, i));
        }
    }
}
