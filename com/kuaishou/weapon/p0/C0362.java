package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʽˉ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0362 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0362 f196;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f197;

    /* renamed from: com.kuaishou.weapon.p0.ʽˉ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0363 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ boolean f198;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ boolean f199;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final /* synthetic */ int f200;

        /* renamed from: ʾ  reason: contains not printable characters */
        public final /* synthetic */ C0362 f201;

        public RunnableC0363(C0362 c0362, boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0362, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f201 = c0362;
            this.f198 = z;
            this.f199 = z2;
            this.f200 = i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v9 int)] */
        @Override // java.lang.Runnable
        public void run() {
            String str;
            C0374 c0374;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f201.f197);
                    if (m389.m392(C0374.f313, 1) == 1) {
                        if (this.f198 || this.f199) {
                            long m418 = m389.m418(C0374.f271);
                            long currentTimeMillis = System.currentTimeMillis();
                            long m392 = m389.m392(C0374.f315, 8) * 3600000;
                            int m3922 = m389.m392(C0374.f317, 0);
                            long m3923 = m389.m392(C0374.f321, 20) * 60000;
                            if (m418 > 0) {
                                int i = WeaponHI.ii;
                                str = C0374.f271;
                                c0374 = m389;
                                if (currentTimeMillis - m418 < i * 3600000 && WeaponHI.isList != null) {
                                    int hours = new Date(currentTimeMillis).getHours();
                                    List<Integer> list = WeaponHI.isList;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(hours);
                                    if (list.contains(sb.toString())) {
                                        return;
                                    }
                                }
                            } else {
                                str = C0374.f271;
                                c0374 = m389;
                            }
                            long j = currentTimeMillis - m418;
                            if (j >= m392 || ((this.f200 == 100 && m3922 == 1) || ((this.f200 == 101 || this.f200 == 102) && j >= m3923))) {
                                C0336.m283(this.f201.f197, new C0329(this.f201.f197, this.f200).m243(C0331.f79), C0331.f79, true, true);
                                c0374.m412(str, currentTimeMillis);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0362(Context context) {
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
        this.f197 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0362 m372(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f196 == null) {
                synchronized (C0362.class) {
                    if (f196 == null) {
                        f196 = new C0362(context);
                    }
                }
            }
            return f196;
        }
        return (C0362) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m373(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                C0374 m389 = C0374.m389(this.f197);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                if (m408 || m4082) {
                    C0358.m366().m367(new RunnableC0363(this, m408, m4082, i));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
