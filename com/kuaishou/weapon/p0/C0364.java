package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* renamed from: com.kuaishou.weapon.p0.ʽˊ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0364 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0364 f202;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f203;

    /* renamed from: com.kuaishou.weapon.p0.ʽˊ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0365 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ C0364 f204;

        public RunnableC0365(C0364 c0364) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0364};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f204 = c0364;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v12 int)] */
        @Override // java.lang.Runnable
        public void run() {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f204.f203);
                    if (m389.m392(C0374.f312, 1) == 1) {
                        long m418 = m389.m418(C0374.f276);
                        long currentTimeMillis = System.currentTimeMillis();
                        long m392 = m389.m392(C0374.f298, 12) * 3600000;
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
                        if (currentTimeMillis - j >= m392) {
                            C0336.m283(this.f204.f203, new C0330(this.f204.f203).m245(C0331.f82), C0331.f82, true, true);
                            m389.m412(C0374.f276, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0364(Context context) {
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
        this.f203 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0364 m375(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f202 == null) {
                synchronized (C0364.class) {
                    if (f202 == null) {
                        f202 = new C0364(context);
                    }
                }
            }
            return f202;
        }
        return (C0364) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m376() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            C0358.m366().m367(new RunnableC0365(this));
        }
    }
}
