package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʽˎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0368 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile C0368 f210;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f211;

    /* renamed from: com.kuaishou.weapon.p0.ʽˎ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public class RunnableC0369 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ int f212;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final /* synthetic */ C0368 f213;

        public RunnableC0369(C0368 c0368, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0368, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f213 = c0368;
            this.f212 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    C0374 m389 = C0374.m389(this.f213.f211);
                    m389.m405("p1_f_r_b_t", System.currentTimeMillis());
                    if (m389.m392(C0374.f234, 1) == 1) {
                        long m418 = m389.m418(C0374.f275);
                        long currentTimeMillis = System.currentTimeMillis();
                        int m392 = m389.m392(C0374.f237, 0);
                        long j = currentTimeMillis - m418;
                        if (j >= m389.m392(C0374.f236, 6) * 3600000 || (this.f212 == 100 && m392 == 1 && j >= ClearCacheUtils.DO_CLEAR_PERIOD)) {
                            C0326.m238(this.f213.f211, new C0313(this.f213.f211, this.f212, false).m213(C0331.f80), C0331.f80, true);
                            m389.m412(C0374.f275, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public C0368(Context context) {
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
        this.f211 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0368 m381(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f210 == null) {
                synchronized (C0368.class) {
                    if (f210 == null) {
                        f210 = new C0368(context);
                    }
                }
            }
            return f210;
        }
        return (C0368) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m382(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            C0358.m366().m367(new RunnableC0369(this, i));
        }
    }
}
