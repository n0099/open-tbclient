package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʽˏ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0370 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0370 f214;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f215;

    /* renamed from: com.kuaishou.weapon.p0.ʽˏ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0371 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ int f216;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ C0370 f217;

        public RunnableC0371(C0370 c0370, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0370, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f217 = c0370;
            this.f216 = i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v13 int)] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f217.f215);
                    m389.m405("p1_f_p_b_t", System.currentTimeMillis());
                    if (m389.m392(C0374.f248, 1) == 1) {
                        long m415 = m389.m415();
                        long currentTimeMillis = System.currentTimeMillis();
                        long m392 = m389.m392(C0374.f250, 8) * 3600000;
                        if (m415 > 0 && currentTimeMillis - m415 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - m415 >= m392) {
                            C0336.m283(this.f217.f215, new C0334(this.f217.f215, this.f216).m277(C0331.f77), C0331.f77, true, true);
                            m389.m404(currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0370(Context context) {
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
        this.f215 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0370 m384(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f214 == null) {
                synchronized (C0370.class) {
                    if (f214 == null) {
                        f214 = new C0370(context);
                    }
                }
            }
            return f214;
        }
        return (C0370) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m385(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            C0358.m366().m367(new RunnableC0371(this, i));
        }
    }
}
