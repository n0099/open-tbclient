package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
import java.util.Random;
/* renamed from: com.kuaishou.weapon.p0.ʽˋ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0366 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0366 f205;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f206;

    /* renamed from: com.kuaishou.weapon.p0.ʽˋ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0367 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ int f207;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ int f208;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final /* synthetic */ C0366 f209;

        public RunnableC0367(C0366 c0366, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0366, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f209 = c0366;
            this.f207 = i;
            this.f208 = i2;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r13v6 int)] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f209.f206);
                    if (m389.m392(C0374.f322, 1) == 1) {
                        long m418 = m389.m418(C0374.f272);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m392 = m389.m392(C0374.f320, 1) * 3600000;
                        long m3922 = m389.m392(C0374.f324, 5) * 60000;
                        int m3923 = m389.m392(C0374.f326, 0);
                        if (m418 > 0 && currentTimeMillis - m418 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                int nextInt = new Random().nextInt(60) + 1;
                                C0444.m955(this.f209.f206, C0303.f38, Integer.valueOf(C0331.f78).intValue(), (nextInt * 60000) + 3600000, "env://");
                                return;
                            }
                        }
                        long j = currentTimeMillis - m418;
                        if (j < m392 && ((this.f207 != 100 || m3923 != 1) && this.f207 != 106 && (this.f207 == 100 || this.f207 <= 0 || j < m3922))) {
                            C0444.m955(this.f209.f206, C0303.f38, Integer.valueOf(C0331.f78).intValue(), m392 - j, "env://");
                            return;
                        }
                        C0336.m283(this.f209.f206, new C0332(this.f209.f206, this.f207, this.f208).m247(C0331.f78), C0331.f78, true, true);
                        m389.m412(C0374.f272, currentTimeMillis);
                        C0444.m955(this.f209.f206, C0303.f38, Integer.valueOf(C0331.f78).intValue(), m392, "env://");
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0366(Context context) {
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
        this.f206 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0366 m378(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f205 == null) {
                synchronized (C0366.class) {
                    if (f205 == null) {
                        f205 = new C0366(context);
                    }
                }
            }
            return f205;
        }
        return (C0366) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m379(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            C0358.m366().m367(new RunnableC0367(this, i, i2));
        }
    }
}
